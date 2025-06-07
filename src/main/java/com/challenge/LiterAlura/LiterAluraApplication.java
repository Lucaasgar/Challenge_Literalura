package com.challenge.LiterAlura;

import com.challenge.LiterAlura.Principal.Principal;
import com.challenge.LiterAlura.Repository.AutorRepository;
import com.challenge.LiterAlura.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private Principal main;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		main.aplicacion();
	}
}
