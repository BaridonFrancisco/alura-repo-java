package com.aluraSpring.screenmatch;
import Model.DatosEpisodio;
import Model.DatosPorTemporada;
import Model.DatosSerie;
import Principal.SeriesMenu;
import Service.ConsumoAPI;
import Service.ConvertirDatos;
import Service.IConvertirDatos;
import Service.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {
	@Autowired
	ISerieRepository iSerieRepository;
	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SeriesMenu seriesMenu=new SeriesMenu(iSerieRepository);
		seriesMenu.startMenu();


	}
}
