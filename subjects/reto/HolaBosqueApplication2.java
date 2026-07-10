package com.forestapp.hola_bosque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/area")
  public String caclularArea(@RequestParam double longitud, @RequestParam double ancho) {
    double area = longitud * ancho;
    return "El área de la sección de reforestación es: " + area + " m²";
  }
  @GetMapping("/area-segura")
  public String areaSegura(@RequestParam double longitud, @RequestParam double ancho) {
    try {
      if (longitud <= 0 || ancho <= 0) {
        throw new IllegalArgumentException("Longitud y ancho deben ser positivos.");
      }
      double area = longitud * ancho;
      return "El área de la sección de reforestación es: " + area + " m²";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }
}
