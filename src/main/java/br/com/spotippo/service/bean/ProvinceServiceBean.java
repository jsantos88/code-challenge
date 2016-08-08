package br.com.spotippo.service.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spotippo.model.ProvinceEntity;
import br.com.spotippo.repository.ProvinceRepository;
import br.com.spotippo.service.ProvinceService;

@Service
public class ProvinceServiceBean implements ProvinceService {
	
	private ProvinceRepository provinciaRepository;
	
	@Autowired
	public ProvinceServiceBean(ProvinceRepository provinciaRepository) {
		this.provinciaRepository = provinciaRepository;
	}

	@Override
	public List<ProvinceEntity> buscarProvinciaPeloPonto(int x, int y) {
		List<ProvinceEntity> provincias = provinciaRepository.buscarProvinciasDoImovel(x, y);
		return provincias;
	}

	@Override
	public void cadastrarProvincia(ProvinceEntity provinciaEntity) {
		provinciaRepository.save(provinciaEntity);
	}

}
