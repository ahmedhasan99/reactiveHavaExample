package com.example.reactivJava;


import com.example.reactivJava.model.TourPackage;
import com.example.reactivJava.service.ReactiveDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ReactiveApplication implements CommandLineRunner {
	@Autowired
	private ReactiveDbService reactiveDbService;
	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}
	private void createTour(){
		reactiveDbService.saveTour("01","Ahmed");
		reactiveDbService.saveTour("02","Mohamed");
		reactiveDbService.saveTour("03","Zaghloul");
		reactiveDbService.saveTour("04","ElSayedd");
	}
	@Override
	public void run(String... args) throws Exception {
		createTour();
	}
}
