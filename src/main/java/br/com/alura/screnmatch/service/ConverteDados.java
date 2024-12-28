package br.com.alura.screnmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ConverteDados implements IConverteDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String obterJson(Object dados) {
        try {
            return mapper.writeValueAsString(dados);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    private Gson gson = new Gson();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return gson.fromJson(json, classe);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }
     */
}
