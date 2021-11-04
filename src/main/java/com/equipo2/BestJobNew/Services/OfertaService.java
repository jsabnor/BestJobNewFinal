package com.equipo2.BestJobNew.Services;
import com.equipo2.BestJobNew.Entities.Oferta;
import com.equipo2.BestJobNew.Repositories.OfertaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clase Service de Oferta. Capa que implementará el CRUD del Repository
 * PROYECTO ALPHA BOOTCAMP
 * Entrada al programa
 * Equipo Back: Clemen & Josema
 * Equipo Front: Heyanabanana & Javier_scr
 * @author Clemen & Josema
 * @version 1.0
 */
@Service
public class OfertaService {

    //ATRIBUTOS
    private final OfertaRepository ofertaRepository;
    private static final String API_BASE="/api/v1";

    //CONSTRUCTORES

    /**
     * Constructor con el parametro de OfertaRepository
     * @param ofertaRepository Repositorio de Oferta
     */
    public OfertaService(OfertaRepository ofertaRepository) {
        this.ofertaRepository = ofertaRepository;
    }

    //METODOS

    /**
     * Metodo que devulve todas las ofertas en la base de datos
     * @return Lista con todas las ofertas
     */
    public List<Oferta> findAll(){
        return ofertaRepository.findAll();
    }

    /**
     * Metodo que busca una oferta por el id de la oferta
     * @param id de la oferta
     * @return La oferta si la encuentra y si no la encuentra devulve una excepcion de
     * no haber encontrado el elemento
     */
    public Oferta findById(Long id){
        return ofertaRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    /**
     * Metodo que crea una oferta en la base de datos
     * @param oferta con todos los datos
     * @return oferta creada
     */
    public Oferta saveOferta(Oferta oferta){

        return ofertaRepository.save(oferta);
    }

    /**
     * Metodo que elimina la oferta pasada po id
     * @param id de la oferta
     */
    public void deleteOferta(Long id){
        ofertaRepository.deleteById(id);
    }

    /**
     * Método que elimina todas las ofertas
     */
    public void deleteAll(){
        ofertaRepository.deleteAll();
    }

    /**
     * Metodo que actuliza una oferta
     * @param oferta con todos los datos
     * @return devuelve la oferta
     */
    public Oferta updateOferta(Oferta oferta){
        return ofertaRepository.save(oferta);
    }

    /**
     * Metodo que comprueba que una oferta existe
     * @param id de la oferta
     * @return true si existe o false si no existe
     */
    public boolean existOferta(Long id){
        return ofertaRepository.existsById(id);

    }


    //GETTER Y SETTER


    public OfertaRepository getOfertaRepository() {
        return ofertaRepository;
    }
}
