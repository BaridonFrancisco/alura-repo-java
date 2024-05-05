package com.aluraSpring.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConvertirDatos {

    <T> T convertirDatos(String json,Class<T>tipoClase) throws JsonProcessingException;
}
