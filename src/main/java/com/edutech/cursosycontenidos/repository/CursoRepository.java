package com.edutech.cursosycontenidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.cursosycontenidos.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>
{

}
