package com.aluraSpring.screenmatch;
import Model.DatosEpisodio;
import Model.DatosPorTemporada;
import Model.DatosSerie;
import Service.ConsumoAPI;
import Service.ConvertirDatos;
import Service.IConvertirDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoApi=new ConsumoAPI();
		String re=consumoApi.obtenerDatos("https://www.omdbapi.com/?i=tt3896198&apikey=2d969581");
		IConvertirDatos convertirDatos= new ConvertirDatos();
		var resultado=convertirDatos.convertirDatos(re, DatosSerie.class);
		System.out.println(resultado+"\n");

		re=consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=2d969581");
		DatosEpisodio resultado2=convertirDatos.convertirDatos(re,DatosEpisodio.class);
		System.out.println(resultado2);

		List<DatosPorTemporada> datosTemporada=new ArrayList<>();
		re=consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&apikey=2d969581");
		DatosPorTemporada datosPorTemporada=convertirDatos.convertirDatos(re,DatosPorTemporada.class);
		for(DatosEpisodio e:datosPorTemporada.episodios()){
			System.out.println(e);
		}

	}
}
