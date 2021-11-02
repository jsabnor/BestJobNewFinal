package com.equipo2.BestJobNew.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Oferta
 * PROYECTO ALPHA BOOTCAMP
 * Entrada al programa
 * Equipo Back: Clemen & Josema
 * Equipo Front: Heyanabanana & Javier_scr
 * @author Clemen & Josema
 * @version 1.0
 */
@Entity
@Table(name="ofertas")
public class Oferta {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("Clave primaria")
    private Long id;
    @ApiModelProperty("Titulo de la oferta")
    private String titulo;
    @ApiModelProperty("Detalle de la oferta")
    private String detalle;
    @ApiModelProperty("Años de experiencia del candidato que se requiere en la oferta")
    private Integer anyosExperiencia;
    @ApiModelProperty("Salario de la oferta")
    private double salario;
    @ApiModelProperty("Empresa que solicita el puesto de la oferta")
    private String empresa;
    @ApiModelProperty("Telefono de contacto de la empresa")
    private String telefono;
    @ApiModelProperty("Email de contacto de la empresa")
    private String email;
    @ApiModelProperty("Si el trabajo se realizaria en remoto")
    private Boolean remoto;

    @JsonManagedReference
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="rel_ofertas_tecnologias",
            joinColumns = @JoinColumn(name = "fk_oferta"),
            inverseJoinColumns = @JoinColumn(name = "fk_tecnologia")
    )
    private List<Tecnologia> tecnologias=new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Constructor vacio
     */
    public Oferta() {
    }

    /**
     * Constructor con todos los parametros
     * @param id de la oferta es la clave primaria
     * @param titulo de la oferta
     * @param detalle de la oferta
     * @param anyosExperiencia años de experiencia solicitado
     * @param salario de la oferta
     * @param empresa de la oferta
     * @param telefono de la empresa
     * @param email de la empresa
     * @param remoto si el trabajo es en remoto o no
     */
    public Oferta(Long id, String titulo, String detalle, Integer anyosExperiencia, double salario,
                  String empresa, String telefono, String email, Boolean remoto) {
        this.id = id;
        this.titulo = titulo;
        this.detalle = detalle;
        this.anyosExperiencia = anyosExperiencia;
        this.salario = salario;
        this.empresa = empresa;
        this.telefono = telefono;
        this.email = email;
        this.remoto = remoto;
    }

    //METODOS

    /**
     * Metodo toString para mostrar todos los atributos de clase
     * @return todos los atributos
     */
    @Override
    public String toString() {
        return "Ofertas{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", detalle='" + detalle + '\'' +
                ", anyosExperiencia=" + anyosExperiencia +
                ", salario=" + salario +
                ", empresa='" + empresa + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", remoto=" + remoto +
                ", tecnologias=" + tecnologias +
                '}';
    }

    /**
     * Metodo para añadir las tecnologias
     * @param tecnologia a añadir
     */
    public void addTecnologias(Tecnologia tecnologia){
        tecnologias.add(tecnologia);
        tecnologia.getOfertas().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oferta offers = (Oferta) o;
        return id.equals(offers.id);
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getAnyosExperiencia() {
        return anyosExperiencia;
    }

    public void setAnyosExperiencia(Integer anyosExperiencia) {
        this.anyosExperiencia = anyosExperiencia;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRemoto() {
        return remoto;
    }

    public void setRemoto(Boolean remoto) {
        this.remoto = remoto;
    }

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }
}
