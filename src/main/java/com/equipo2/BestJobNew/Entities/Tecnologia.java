package com.equipo2.BestJobNew.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Tecnologia
 * PROYECTO ALPHA BOOTCAMP
 * Entrada al programa
 * Equipo Back: Clemen & Josema
 * Equipo Front: Heyanabanana & Javier_scr
 * @author Clemen & Josema
 * @version 1.0
 */
@Entity
@Table(name = "tecnologias")
public class Tecnologia {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria")
    private Long id;
    @ApiModelProperty("Nombre ")
    private String nombre;
    @JsonBackReference
    @ManyToMany(mappedBy = "tecnologias", cascade = CascadeType.ALL)
    private List<Oferta> ofertas=new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Constructor sin parametros
     */
    public Tecnologia() {
    }

    /**
     * Constructor con todos los atributos
     * @param id de la tecnologia es la clave primaria
     * @param nombre de la tecnologia
     */
    public Tecnologia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //METODOS

    /**
     * Metodo toString para mostrar todos los atributos de clase
     * @return todos los atributos
     */
    @Override
    public String toString() {
        return "Tecnologia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tecnologia that = (Tecnologia) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //GETTER Y SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
}
