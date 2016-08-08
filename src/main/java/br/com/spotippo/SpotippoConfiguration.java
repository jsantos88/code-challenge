package br.com.spotippo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spotippos")
public class SpotippoConfiguration {
	
	private boolean carregarImoveis;

	public boolean isCarregarImoveis() {
		return carregarImoveis;
	}

	public void setCarregarImoveis(boolean carregarImoveis) {
		this.carregarImoveis = carregarImoveis;
	}
	
}
