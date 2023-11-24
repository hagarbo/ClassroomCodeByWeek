package com.example.juego.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final String PERSONAJE = "Gates";
    private final String PISTA1 = "Apellido del magnate americano que hizo su fortuna en el sector tecnológico";
    private final String PISTA2 = "Siempre le gustaron las 'ventanas'";
    private final String PISTA3 = "Fundador de Microsoft";

    private int consultas_api = 0;
    private int aciertos_api = 0;
    private int fallos_api = 0;
    private int puntuacion = 0;

    @GetMapping("/")
    public boolean is_up() {
        this.consultas_api++;
        return true;
    }

    @GetMapping("/statistics")
    public String statistics() {
        this.consultas_api++;
        return "Consultas: " + consultas_api + " , Aciertos: " + aciertos_api + " , Fallos " + fallos_api;
    }

    @GetMapping("/pista1")
    public String primeraPista() {
        this.consultas_api++;
        return PISTA1;
    }

    @GetMapping("/pista2")
    public String segundaPista() {
        this.consultas_api++;
        return PISTA2;
    }

    @GetMapping("/pista3")
    public String terceraPista() {
        this.consultas_api++;
        return PISTA3;
    }

    @GetMapping("/resolver/{respuesta}")
    public boolean resultado(@PathVariable String respuesta) {
        this.consultas_api++;

        if (this.PERSONAJE.equalsIgnoreCase(respuesta)) {
            this.aciertos_api++;
            return true;
        } else {
            this.fallos_api++;
            return false;
        }
    }

    @GetMapping("/score")
    public int score() {
        this.consultas_api++;
        return this.puntuacion;
    }

    @GetMapping("/score/percebeiro10/{new_score}")
    public void set_score(@PathVariable int new_score) {
        this.consultas_api++;
        this.puntuacion = new_score;
    }

}