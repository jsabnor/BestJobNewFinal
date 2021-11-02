package com.equipo2.BestJobNew.Repositories;

import com.equipo2.BestJobNew.Entities.Oferta;
import com.equipo2.BestJobNew.Entities.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que hereda de JpaRepository para los metodos CRUD
 * PROYECTO ALPHA BOOTCAMP
 * Entrada al programa
 * Equipo Back: Clemen & Josema
 * Equipo Front: Heyanabanana & Javier_scr
 * @author Clemen & Josema
 * @version 1.0
 */
@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long> {
}
