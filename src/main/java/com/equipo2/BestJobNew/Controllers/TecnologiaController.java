package com.equipo2.BestJobNew.Controllers;

import com.equipo2.BestJobNew.Entities.Tecnologia;

import com.equipo2.BestJobNew.Services.TecnologiaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
public class TecnologiaController {
    //ATRIBUTOS
    private static final String API_BASE="/api/v1";
    private final Logger log= LoggerFactory.getLogger(TecnologiaController.class);

    private TecnologiaService tecnologiaService;

    //CONSTRUCTORES

    /**
     * Constructor con todos los parametros
     * @param tecnologiaService de Tecnologia
     */
    public TecnologiaController(TecnologiaService tecnologiaService) {
        this.tecnologiaService = tecnologiaService;
    }

    //METODOS

    /**
     * Metodo que muestra todas las ofertas en la base de datos
     * @return ResponseEntity con todas las ofertas en la base de datos
     */
    @GetMapping(API_BASE+"/tecnologias")
    @ApiOperation("Busca todas las tecnologias que hay en la base de datos")
    public ResponseEntity<List<Tecnologia>> muestraTodas(){
        log.info("Se van a mostrar todas las ofertas");
        return new ResponseEntity<>(tecnologiaService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que muestra la oferta pasado por id
     * @return ResponseEntity con la oferta pasada por id
     */
    @GetMapping(API_BASE+"/tecnologias/{id}")
    public ResponseEntity<Tecnologia> muestraOfertaId(@ApiParam("Clave primaria") @PathVariable("id")Long id){
        return new ResponseEntity<>(tecnologiaService.findById(id), HttpStatus.OK);

    }

    /**
     * Metodo que crea la tecnologia en la base de datos
     * @param tecnologia objeto tecnologia
     * @return ResponseEntity con la tecnologia si se ha creado manda HttPStatus Ok y si no un Not foud
     */
    @PostMapping(API_BASE+"/tecnologias")
    public ResponseEntity<Tecnologia> creartecnologia(@ApiParam("Parametros pasados por Json en el body") @RequestBody Tecnologia tecnologia){
        return new ResponseEntity<>(tecnologiaService.saveTecnologia(tecnologia),HttpStatus.CREATED);
    }

    /**
     * Metodo que actualiza una tecnologia de la base de datos
     * @param id de la tecnologia
     * @param tecnologia con todos los atributos
     * @return ResponseEntity con la tecnologia actualzada
     */
    @PutMapping(API_BASE+"/tecnologias/{id}")
    public ResponseEntity<Tecnologia> actualizarTecnologia(@ApiParam("Clave primaria") @PathVariable("id") Long id,
                                                           @ApiParam("Parametros pasados por Json en el body") @RequestBody Tecnologia tecnologia){
        if(tecnologiaService.existTecnologia(id)){
            return new ResponseEntity<>(tecnologiaService.saveTecnologia(tecnologia), HttpStatus.CREATED);
        }
        throw  new IllegalArgumentException("La tecnologia con id "+id+" no existe");
    }

    /**
     * Metodo que borra una tecnologia de la base de datos
     * @param id de la tecnologia
     * @return Response Entity con el estado NO Content
     */
    @DeleteMapping(API_BASE+"/tecnologias/{id}")
    public ResponseEntity<HttpStatus> borrarOferta(@ApiParam("Clave primaria") @PathVariable("id")Long id){
        tecnologiaService.deleteTecnologia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Metodo que elimina todas las tecnologias de la base de datos
     * @return ResponseEntity con el estado NO content
     */
    @DeleteMapping(API_BASE+"/tecnologias")
    public ResponseEntity<HttpStatus> borrarTodas(){
        tecnologiaService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //GETTER Y SETTER

    public Logger getLog() {
        return log;
    }

    public TecnologiaService gettecnologiaService() {
        return tecnologiaService;
    }

    public void settecnologiaService(TecnologiaService tecnologiaService) {
        this.tecnologiaService = tecnologiaService;
    }
}