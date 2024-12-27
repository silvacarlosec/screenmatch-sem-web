package br.com.alura.screnmatch.service;

public interface IConverteDados {

    <T> T obterDadosWithJackson(String json, Class<T> classe);
    <T> T obterDadosWithGson(String json, Class<T> classe);
}
