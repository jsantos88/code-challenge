package br.com.spotippo.service;

import java.util.List;

import br.com.spotippo.model.ProvinceEntity;

public interface ProvinceService {
	
	List<ProvinceEntity> buscarProvinciaPeloPonto(int x, int y);
	
	void cadastrarProvincia(ProvinceEntity provinciaEntity);
	
}
