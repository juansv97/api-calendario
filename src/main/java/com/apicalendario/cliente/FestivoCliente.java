package com.apicalendario.cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.apicalendario.modelo.RespuestaFestivo;

@Component
public class FestivoCliente {

    private final RestTemplate restTemplate = new RestTemplate();

    public RespuestaFestivo verificar(int anio, int mes, int dia) {

        String url = "http://localhost:3030/api/festivos/verificar/"
                + anio + "/" + mes + "/" + dia;

        ResponseEntity<RespuestaFestivo> response =
                restTemplate.getForEntity(url, RespuestaFestivo.class);

        return response.getBody();
    }

}