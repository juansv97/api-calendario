package com.apicalendario.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apicalendario.modelo.Dia;
import com.apicalendario.servicio.CalendarioServicio;

@RestController
@RequestMapping("/calendario")
public class CalendarioControlador {

    @Autowired
    private CalendarioServicio calendarioServicio;

    // Generar calendario del año
    @PostMapping("/generar/{anio}")
    public boolean generar(@PathVariable int anio){
        return calendarioServicio.generarCalendario(anio);
    }

    // Obtener calendario completo de un año
    @GetMapping("/{anio}")
    public List<Dia> obtener(@PathVariable String anio){
        return calendarioServicio.obtenerCalendario(anio);
    }

    // Obtener un día específico
    @GetMapping("/dia/{fecha}")
    public Dia obtenerDia(@PathVariable String fecha){
        return calendarioServicio.obtenerDia(fecha);
    }

}