package br.com.spotippo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.spotippo.model.PropertyEntity;
import br.com.spotippo.model.ProvinceEntity;
import br.com.spotippo.repository.ProvinceRepository;
import br.com.spotippo.service.PropertyService;

@SpringBootApplication
public class SpotippoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotippoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initProvincies(ResourceLoader resourceLoader, ObjectMapper mapper, ProvinceRepository repository,
			PropertyService service, SpotippoConfiguration configuration) {
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {

				loadProvinciesFromJson(resourceLoader, mapper, repository);
				
				if (configuration.isCarregarImoveis()) {
					loadPropertiesFromJson(resourceLoader, mapper, service);
				}
			}

		};
	}
	
	
	private void loadProvinciesFromJson(ResourceLoader resourceLoader, ObjectMapper mapper,
			ProvinceRepository repository) throws IOException, JsonParseException, JsonMappingException {
		Resource resource = resourceLoader.getResource("classpath:json/provincies.json");
		InputStream inputStream = resource.getInputStream();

		String provincias = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
				.lines().collect(Collectors.joining());

		TypeReference<HashMap<String, ProvinceEntity>> typeRef = new TypeReference<HashMap<String, ProvinceEntity>>() {
		};
		Map<String, ProvinceEntity> mapProvincias = mapper.readValue(provincias, typeRef);

		for (String name : mapProvincias.keySet()) {
			ProvinceEntity provincia = mapProvincias.get(name);
			provincia.setNome(name);
			repository.save(provincia);
		}
	}
	
	private void loadPropertiesFromJson(ResourceLoader resourceLoader, ObjectMapper mapper, PropertyService service) throws IOException {
		Resource resource = resourceLoader.getResource("classpath:json/properties.json");
		InputStream inputStream = resource.getInputStream();

		String properties = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
				.lines().collect(Collectors.joining());

		JsonProperties jsonProperties = mapper.readValue(properties, JsonProperties.class);

		for (PropertyEntity property : jsonProperties.getProperties()) {
			service.cadastrarImovel(property);
		}
	}
	
	public static class JsonProperties {
		private String totalProperties;
		private List<PropertyEntity> properties;
		public String getTotalProperties() {
			return totalProperties;
		}
		public void setTotalProperties(String totalProperties) {
			this.totalProperties = totalProperties;
		}
		public List<PropertyEntity> getProperties() {
			return properties;
		}
		public void setProperties(List<PropertyEntity> properties) {
			this.properties = properties;
		}
	}
}
