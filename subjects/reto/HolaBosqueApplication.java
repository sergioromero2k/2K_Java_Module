package com.forestapp.hola_bosque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HolaBosqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaBosqueApplication.class, args);
	}
  @GetMapping("/hola-bosque")
  public String holaBosque() {
    return "Bienvenido al sistema de gestión forestal";
  }
}
