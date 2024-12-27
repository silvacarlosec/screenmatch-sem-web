package br.com.alura.screnmatch;

import br.com.alura.screnmatch.model.DadosSerie;
import br.com.alura.screnmatch.service.ConsumoApi;
import br.com.alura.screnmatch.service.ConverteDados;
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

		/**
		 * 2 - Suponha que decidimos mudar de ideia e utilizar novamente a biblioteca Gson no nosso projeto
		 * ScreenMatch. Agora que estamos trabalhando com o Maven, os passos para adicionar a biblioteca são
		 * diferentes do que já foi feito antes. Explique quais passos você iria realizar nesse caso.
		 */

		ConsumoApi consumoApi = new ConsumoApi();
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);

		DadosSerie dados = null;
		ConverteDados converteDados = new ConverteDados();

		dados = converteDados.obterDadosWithJackson(json, DadosSerie.class);
		System.out.println(dados);

		dados = null;
		dados = converteDados.obterDadosWithGson(json, DadosSerie.class);
		System.out.println(dados);
	}
}
