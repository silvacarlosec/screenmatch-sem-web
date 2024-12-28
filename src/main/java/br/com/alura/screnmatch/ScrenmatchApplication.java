package br.com.alura.screnmatch;

import br.com.alura.screnmatch.model.DadosSerie;
import br.com.alura.screnmatch.model.Tarefa;
import br.com.alura.screnmatch.service.ConsumoApi;
import br.com.alura.screnmatch.service.ConverteDados;
import br.com.alura.screnmatch.service.PersisteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ScrenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ConsumoApi consumoApi = new ConsumoApi();
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		ConverteDados converteDados = new ConverteDados();
		DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		Tarefa tarefa = new Tarefa(
				"Atividade 4: serialização de um objeto",
				true,
				"Carlos");
		String tarefaJson = converteDados.obterJson(tarefa);
		System.out.println(tarefaJson);
		PersisteDados persisteDados = new PersisteDados();
		persisteDados.gravaJsonEmArquivo(tarefaJson, "tarefa.json");

	}
}
