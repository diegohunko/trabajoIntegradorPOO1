/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="articulos")
public class Articulo implements Serializable{
    @Id
    @GeneratedValue
    private Long idArticulo;
    private String descripcion;
    private Double largo;
    private Double ancho;
    private Double diametro;
    @ManyToOne
    private Envase envase;
    @OneToOne
    private TipoArticulo tipo;
    
    
    public Articulo() {
    }
    
     public Articulo(Long codigo, String descripcion, Double largo, Double ancho,
             Double diametro, Envase envase, TipoArticulo tipo) {
        this.idArticulo = codigo;
        this.descripcion = descripcion;
        this.largo = largo;
        this.ancho = ancho;
        this.diametro = diametro;
        this.envase = envase;
        this.tipo = tipo;
    }
    
    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getDiametro() {
        return diametro;
    }

    public void setDiametro(Double diametro) {
        this.diametro = diametro;
    }

    public Envase getEnvase() {
        return envase;
    }

    public void setEnvase(Envase envase) {
        this.envase = envase;
    }

    public TipoArticulo getTipo() {
        return tipo;
    }

    public void setTipo(TipoArticulo tipo) {
        this.tipo = tipo;
    }
}
