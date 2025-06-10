package com.edutech.cursosycontenidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.cursosycontenidos.models.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Integer>
{

}
