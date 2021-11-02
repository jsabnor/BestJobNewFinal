package com.equipo2.BestJobNew.Services;


import com.equipo2.BestJobNew.Entities.Tecnologia;
import com.equipo2.BestJobNew.Repositories.TecnologiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clase Service de Tecnologia. Capa que implementará el CRUD del Repository
 * PROYECTO ALPHA BOOTCAMP
 * Entrada al programa
 * Equipo Back: Clemen & Josema
 * Equipo Front: Heyanabanana & Javier_scr
 * @author Clemen & Josema
 * @version 1.0
 */
@Service
public class TecnologiaService {
    //ATRIBUTOS
    private final TecnologiaRepository tecnologiaRepository;

    //COSNTRUCTORES

    /**
     * Constructor con el parametro TecnologiaRepository
     * @param tecnologiaRepository Repositorio de Tecnologia
     */
    public TecnologiaService(TecnologiaRepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    //METODOS

    /**
     * Metodo que devuelve todas las tecnologias de la base de datos
     * @return lsita de todas las tecnologias
     */
    public List<Tecnologia> findAll(){
        return tecnologiaRepository.findAll();
    }

    /**
     * Metodo que devuelve una tecnologia buscada por la id
     * @param id de la tecnologia
     * @return la tecnologia buscada y si no existe lanza una excepcion
     */
    public Tecnologia findById(Long id){
        return tecnologiaRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    /**
     * Metodo que crea una tecnologia en la base de datos
     * @param tecnologia con todos los datos
     * @return tecnologia creada
     */
    public Tecnologia saveTecnologia(Tecnologia tecnologia){
        return tecnologiaRepository.save(tecnologia);
    }

    /**
     * Metodo que elimina la tecnologia pasada po id
     * @param id de la tecnologia
     */
    public void deleteTecnologia(Long id){
        tecnologiaRepository.deleteById(id);
    }

    /**
     * Método que elimina todas las tecnologia
     */
    public void deleteAll(){
        tecnologiaRepository.deleteAll();
    }

    /**
     * Metodo que actuliza una tecnologia
     * @param tecnologia con todos los datos
     * @return devulve la tecnologia
     */
    public Tecnologia updateTecnologia(Tecnologia tecnologia){
        return tecnologiaRepository.save(tecnologia);
    }

    /**
     * Metodo que comprueba que una tecnologia existe
     * @param id de la tecnologia
     * @return true si existe o false si no existe
     */
    public boolean existTecnologia(Long id){
        return tecnologiaRepository.existsById(id);
    }

    //GETTER Y SETTER


    public TecnologiaRepository getTecnologiaRepository() {
        return tecnologiaRepository;
    }
}

