package br.com.spotippo.service.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spotippo.model.PropertyEntity;
import br.com.spotippo.model.ProvinceEntity;
import br.com.spotippo.repository.PropertyRepository;
import br.com.spotippo.service.PropertyService;
import br.com.spotippo.service.ProvinceService;

@Service
public class PropertyServiceBean implements PropertyService {

	private PropertyRepository propertyRepository;
	
	private ProvinceService provinceService;
	
	@Autowired
	public PropertyServiceBean(PropertyRepository propertyRepository, ProvinceService provinceService) {
		this.propertyRepository = propertyRepository;
		this.provinceService = provinceService;
	}
	
	@Override
	public PropertyEntity buscarImovelPorId(Long id) {
		return propertyRepository.findOne(id);
	}

	@Override
	public PropertyEntity cadastrarImovel(PropertyEntity imovel) {
		
		List<ProvinceEntity> provinciasDoImovel = provinceService.buscarProvinciaPeloPonto(imovel.getX(), imovel.getY());
		
		imovel.setProvinces(provinciasDoImovel);
		
		PropertyEntity property = propertyRepository.save(imovel);
		
		return property;

	}

	@Override
	public List<PropertyEntity> buscarImoveisEmSpottipos(int ax, int ay, int bx, int by) {
		
		return propertyRepository.buscarImoveisEmSpottipos(ax, ay, bx, by);
		
	}

}
