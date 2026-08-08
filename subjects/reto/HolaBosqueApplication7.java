package com.forestapp.hola_bosque;

import java.io.Serializable;
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

  static class BifrostSighting implements Serializable {
    private static final long serialVersionUID = 1L;
    private String location;
    private int intensity;

    public BifrostSighting(String location, int intensity) {
      this.location = location;
      this.intensity = intensity;
    }

    public String toJson() {
      return "{\"location\": \"" + location + "\", \"intensity\": " + intensity + "}";
    }
  }

  @GetMapping("/bifrost")
  public String bifrostSighting(@RequestParam String location, @RequestParam int intensity) {
    try {
      if (intensity <= 0) {
        throw new IllegalArgumentException("La intensidad debe ser positiva.");
      }
      BifrostSighting sighting = new BifrostSighting(location, intensity);
      return "Avistamiento registrado: " + sighting.toJson();
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  interface ShieldBearer {
    String motto();
  }

  class SteveRogers implements ShieldBearer {
    public String motto() {
      return "I can do this all day.";
    }
  }

  @GetMapping("/shield")
  public String shieldBearer(@RequestParam String name) {
    try {
      ShieldBearer bearer;
      if (name.equalsIgnoreCase("steve")) {
        bearer = new SteveRogers();
      } else if (name.equalsIgnoreCase("sam")) {
        bearer = new SamWilson();
      } else {
        throw new IllegalArgumentException("Unknown shield bearer: " + name);
      }
      return bearer.motto();
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }
  class SamWilson implements ShieldBearer {
    public String motto() {
      return "The shield doesn't belong to a man. It belongs to an idea.";
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