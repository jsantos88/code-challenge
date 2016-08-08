package br.com.spotippo.webresource;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.spotippo.dto.ResponseDTO;
import br.com.spotippo.model.PropertyEntity;
import br.com.spotippo.service.PropertyService;


@RestController
@RequestMapping("/properties")
public class PropertyResource {
	
	private PropertyService propertyService;
	
	@Autowired
	public PropertyResource(PropertyService imovelService) {
		this.propertyService = imovelService;
	}
	
	/*
	 * 2. Mostre um imóvel específico em Spotippos =] 
	*/
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<PropertyEntity> buscarImovelPorId(@PathVariable Long id) {
		PropertyEntity imovel = propertyService.buscarImovelPorId(id);
		if (imovel == null) {
			return new ResponseEntity<PropertyEntity>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PropertyEntity>(imovel, HttpStatus.OK);
	}
	
	/*
	 * 1. Crie imóveis em Spotippos :)
	*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> cadastrarImovel(@RequestBody @Valid PropertyEntity propertyEntity) {
		
		PropertyEntity property = propertyService.cadastrarImovel(propertyEntity);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(property.getId()).toUri());
        return new ResponseEntity<String>(null, httpHeaders, HttpStatus.CREATED);
	}
	
	/*
	 * 3. Busque imóveis em Spotippos :D 
	*/
	@RequestMapping(method=RequestMethod.GET, params={"ax","ay", "bx", "by"})
	public ResponseEntity<ResponseDTO> buscarImoveisEmSpottipos(
			@RequestParam("ax") @Valid @NotNull @Min(0) @Max(1400) Integer ax, 
			@RequestParam("ay") @Valid @NotNull @Min(0) @Max(1000) Integer ay, 
			@RequestParam("bx") @Valid @NotNull @Min(0) @Max(1400) Integer bx, 
			@RequestParam("by") @Valid @NotNull @Min(0) @Max(1000) Integer by) {
		
		List<PropertyEntity> imoveis = propertyService.buscarImoveisEmSpottipos(ax, ay, bx, by);
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		responseDTO.setFoundProperties(imoveis.size());
		responseDTO.setProperties(imoveis);
		
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
