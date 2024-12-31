package br.com.alura.screnmatch;

import br.com.alura.screnmatch.model.DadosSerie;
import br.com.alura.screnmatch.model.Tarefa;
import br.com.alura.screnmatch.service.ConsumoApi;
import br.com.alura.screnmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


@SpringBootApplication
public class ScrenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ConsumoApi consumoApi = new ConsumoApi();
		String jsonSerie = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(jsonSerie);
		ConverteDados converteDados = new ConverteDados();
		DadosSerie dadosSerie = converteDados.desserializa(jsonSerie, DadosSerie.class);
		System.out.println(dadosSerie);

		Tarefa tarefa = new Tarefa(
				"Atividade 4: serialização de um objeto",
				true,
				"Carlos");
		String jsonTarefa = converteDados.serializaEmString(tarefa);
		System.out.println(jsonTarefa);
		File fileTarefa = converteDados.serializaEmArquivo("tarefa.json", tarefa);

		Tarefa tarefaDesserializada = converteDados.desserializa(fileTarefa, Tarefa.class);
		System.out.println("Arquivo desserializado: " + tarefaDesserializada);
	}
}
