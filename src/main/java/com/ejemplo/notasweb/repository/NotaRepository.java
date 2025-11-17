package com.ejemplo.notasweb.repository;

import com.ejemplo.notasweb.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}