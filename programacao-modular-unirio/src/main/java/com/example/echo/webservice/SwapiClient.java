package com.example.echo.webservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwapiClient {

	
	RestTemplate restTemplate = new RestTemplate();
	
	final String ROOT_URI = "https://swapi.dev/api/planets/";

	public String getPlanetName(String id) {
		int idPesquisa = Integer.parseInt(id) + 1;
		idPesquisa = idPesquisa - 1;
		String idFinal = Integer.toString(idPesquisa);
		Swapi swapi = restTemplate.getForObject(ROOT_URI + "/"+ idFinal + "/", Swapi.class);

		if(swapi != null) {
			return swapi.getName();
		}

		return null;
	}

}
