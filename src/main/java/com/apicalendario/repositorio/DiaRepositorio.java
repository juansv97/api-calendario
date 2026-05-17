package com.apicalendario.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apicalendario.modelo.Dia;

public interface DiaRepositorio extends JpaRepository<Dia, Long> {

    // Buscar todos los días de un año
    List<Dia> findByFechaStartingWith(String anio);

    // Buscar un día específico
    Dia findByFecha(String fecha);

}