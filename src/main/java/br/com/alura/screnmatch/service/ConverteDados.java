package br.com.alura.screnmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ConverteDados implements IConverteDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDadosWithJackson(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private Gson mapper2 = new Gson();

    @Override
    public <T> T obterDadosWithGson(String json, Class<T> classe) {
        try {
            return mapper2.fromJson(json, classe);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
