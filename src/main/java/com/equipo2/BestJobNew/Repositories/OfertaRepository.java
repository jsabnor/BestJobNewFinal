package com.equipo2.BestJobNew.Repositories;

import com.equipo2.BestJobNew.Entities.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

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
public interface OfertaRepository extends JpaRepository<Oferta, Long> {
}
