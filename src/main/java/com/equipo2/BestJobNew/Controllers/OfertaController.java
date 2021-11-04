package com.equipo2.BestJobNew.Controllers;

import com.equipo2.BestJobNew.Entities.Oferta;
import com.equipo2.BestJobNew.Services.OfertaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Clase Controller de ofertas donde se controlara las peticiones y las respuestas de la API
 * PROYECTO ALPHA BOOTCAMP
 * Entrada al programa
 * Equipo Back: Clemen & Josema
 * Equipo Front: Heyanabanana & Javier_scr
 * @author Clemen & Josema
 * @version 1.0
 */
@RestController
public class OfertaController {

    //ATRIBUTOS
    private static final String API_BASE="/api/v1";
    private final OfertaService ofertaService;

    //CONTRUCTORES

    /**
     * Constructor con el parametro de ofertaService
     * @param ofertaService Servicio de Ofertas
     */
    public OfertaController(OfertaService ofertaService) {
        this.ofertaService = ofertaService;
    }

    //METODOS

    /**
     * Metodo que devulve todas las ofertas que hay en la base de datos
     * @return ResponseEntity con la lista de ofertas
     */

    @GetMapping(API_BASE + "/ofertas")
    @ApiOperation("Busca todas las ofertas que hay en la base de datos")
    public ResponseEntity<List<Oferta>> mostrarTodas(){
        return new ResponseEntity<>(ofertaService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que devulve una oferta buscada en la base de datos pasando la id
     * @param id de la oferta
     * @return ResponseEntity con la oferta buscada
     */
    @GetMapping(API_BASE+"/ofertas/{id}")
    @ApiOperation("Busca una oferta por el id")
    public ResponseEntity<Oferta> muestraOfertaId(@ApiParam("Clave primaria") @PathVariable("id") Long id){
        return new ResponseEntity<>(ofertaService.findById(id),HttpStatus.OK);
    }

    /**
     * Metodo que crea una oferta
     * @param oferta con todos los atributos
     * @return RepsonseEntity con la oferta creada
     */
    @PostMapping(value = API_BASE+"/ofertas")
    @ApiOperation("Crea una oferta en la base de datos")
    public ResponseEntity<Oferta> crearOferta(@ApiParam("Parametros pasados por Json en el body") @RequestBody Oferta oferta){
        return new ResponseEntity<>(ofertaService.saveOferta(oferta), HttpStatus.CREATED);

    }

    /**
     * Metodo que actualiza una oferta pasada por id
     * @param id de la oferta
     * @param oferta con todos los atributos
     * @return Responseentity con la oferta actualizada
     */
    @PutMapping(API_BASE+"/ofertas/{id}")
    @ApiOperation("Actualiza los atributos de una oferta de la base de datos pasando el id")
    public ResponseEntity<Oferta> actualizaOferta(@ApiParam("Clave primaria") @PathVariable("id") Long id,
                                                  @ApiParam("Parametros pasados por Json en el body") @RequestBody Oferta oferta){
        if(ofertaService.existOferta(id)){
            return new ResponseEntity<>(ofertaService.saveOferta(oferta), HttpStatus.CREATED);
        }
        throw  new IllegalArgumentException("La oferta con id "+id+" no existe");
    }

    /**
     * Metodo que elimina una oferta de la base de datos
     * @param id de la oferta
     * @return Response Entity con el estado de No Content
     */
    @DeleteMapping(API_BASE+"/ofertas/{id}")
    @ApiOperation("Elimina una oferta de la base de datos pasandole el id")
    public ResponseEntity<HttpStatus> borrarOferta(@ApiParam("Clave primaria")@PathVariable("id") Long id){
        //Borramos la oferta
        ofertaService.deleteOferta(id);
        //Devolvemos el Response entity con el estado No content
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Metodo que elimina una oferta de la base de datos
     * @return Response Entity con el estado de No Content
     */
    @DeleteMapping(API_BASE+"/ofertas")
    @ApiOperation("Elimina todas las ofertas de la base de datos")
    public ResponseEntity<HttpStatus> borrarTodas(){
        //Borramos todas las ofertas
        ofertaService.deleteAll();
        //Devolvemos el Response entity con el estado No content
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //GETTER Y SETTER


    public OfertaService getOfertaService() {
        return ofertaService;
    }
}

