package br.com.alura.screnmatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PersisteDados implements IPersisteDados {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void gravaJsonEmArquivo(String json, String caminhoArquivo) {
        var file = new File(caminhoArquivo);
        try {
            mapper.writeValue(file,json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
