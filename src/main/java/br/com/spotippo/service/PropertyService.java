package br.com.spotippo.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.spotippo.model.PropertyEntity;

public interface PropertyService {
	
	PropertyEntity buscarImovelPorId(Long id);
	
	PropertyEntity cadastrarImovel(@NotNull PropertyEntity imovel);
	
	List<PropertyEntity> buscarImoveisEmSpottipos(int ax, int ay, int bx, int by);

}
