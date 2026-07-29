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

  static class MeasurementSensor implements AutoCloseable {
    public MeasurementSensor() {
      System.out.println("Sensor activado.");
    }

    @Override
    public void close() {
      System.out.println("Sensor apagado correctamente.");
    }
  }

  // http://localhost:8080/area-segura?longitud=10&ancho=5
  @GetMapping("/area-segura")
  public String areaSegura(@RequestParam double longitud, @RequestParam double ancho) {
    try (MeasurementSensor sensor = new MeasurementSensor()){
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
