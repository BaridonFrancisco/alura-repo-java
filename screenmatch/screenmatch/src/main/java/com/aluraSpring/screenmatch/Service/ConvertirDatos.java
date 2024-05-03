package com.aluraSpring.screenmatch.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertirDatos implements IConvertirDatos {
    ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public <T> T convertirDatos(String json, Class<T> tipoClase) throws JsonProcessingException {
        return objectMapper.readValue(json,tipoClase);
    }
}
