package br.com.alura.screnmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") @SerializedName("Title") String titulo,
                         @JsonAlias("totalSeasons") @SerializedName("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") @SerializedName("imdbRating") String avaliacao) {
}
