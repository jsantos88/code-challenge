package br.com.spotippo.webresource;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.spotippo.model.PropertyEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest
@WebAppConfiguration
public class PropertyResourceTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void validarQuantidadeDeQuartosInvalido() throws Exception {

		PropertyEntity property = getProperty();
		
		property.setBeds(6);
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/properties")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(mapper.writeValueAsString(property)))
					.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void validarQuantidadeDeBanheirosInvalido() throws Exception {
		
		PropertyEntity property = getProperty();
		
		property.setBaths(6);
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/properties")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(mapper.writeValueAsString(property)))
					.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void validarMetragemInvalida() throws Exception {

		PropertyEntity property = getProperty();
		
		property.setSquareMeters(250);
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/properties")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(mapper.writeValueAsString(property)))
					.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void validarImovelForaDaArea() throws Exception {
		
		PropertyEntity property = getProperty();
		
		property.setX(1401);
		property.setY(1001);
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/properties")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(mapper.writeValueAsString(property)))
					.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void testCadastroImovelComSucesso() throws Exception {
		
		PropertyEntity property = getProperty();
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/properties")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(mapper.writeValueAsString(property)))
					.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	private PropertyEntity getProperty() {
		PropertyEntity property = new PropertyEntity();
		property.setBeds(2);
		property.setBaths(2);
		property.setDescription("teste cadastro com sucesso");
		property.setPrice(new BigDecimal("360000"));
		property.setX(200);
		property.setY(250);
		property.setSquareMeters(200);
		property.setTitle("title");
		return property;
	}
	
}
