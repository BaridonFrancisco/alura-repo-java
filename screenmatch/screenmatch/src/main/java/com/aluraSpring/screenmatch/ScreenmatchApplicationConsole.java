package com.aluraSpring.screenmatch;

import com.aluraSpring.screenmatch.principal.SeriesMenu;
import com.aluraSpring.screenmatch.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ScreenmatchApplicationConsole   {
	// implementar implements CommandLineRunner
	/*@Autowired(required = true)
	private ISerieRepository iSerieRepository;

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplicationConsole.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SeriesMenu seriesMenu=new SeriesMenu(iSerieRepository);
		seriesMenu.startMenu();


	}*/
}
