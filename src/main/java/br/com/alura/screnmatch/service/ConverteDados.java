package br.com.alura.screnmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConverteDados implements IConverteDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T desserializa(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T desserializa(File json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> String serializaEmString(T objeto) {
        try {
            return mapper.writeValueAsString(objeto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> File serializaEmArquivo(String caminho, T objeto) {
        File file = new File(caminho);
        try {
            mapper.writeValue(file, objeto);
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* // Implementação alternativa, utilizando a biblioteca Gson
    private Gson gson = new Gson();

    @Override
    public <T> T desserializa(String json, Class<T> classe) {
        try {
            return gson.fromJson(json, classe);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }
     */
}
