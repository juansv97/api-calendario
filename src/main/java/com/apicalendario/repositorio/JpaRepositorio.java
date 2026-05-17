package com.apicalendario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apicalendario.modelo.Dia;

public interface JpaRepositorio extends JpaRepository<Dia, Long> {
}