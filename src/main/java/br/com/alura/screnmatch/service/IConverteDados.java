package br.com.alura.screnmatch.service;

import br.com.alura.screnmatch.model.Tarefa;

import java.io.File;

public interface IConverteDados {

    <T> T desserializa(String json, Class<T> classe);
    <T> T desserializa(File json, Class<T> classe);
    <T> String serializaEmString(T objeto);
    <T> File serializaEmArquivo(String caminho, T objeto);

}
