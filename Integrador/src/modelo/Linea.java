/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="renglones")
public class Linea implements Serializable{
     @Id
     @GeneratedValue
     private Long idLinea;
     @ManyToOne
     private Entrega entrega;
     @OneToOne
     private Articulo descripcion;
     private Integer cantidad;
    @OneToOne
     private Envase envase;

    public Linea(){
        
    }
    
    public Linea(Entrega entrega, Articulo descripcion, 
            Integer cantidad, Envase envase){
        this.entrega = entrega;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.envase = envase;
    }
    
    public Long getIdLinea(){
        return idLinea;
    }
    
    public void setIdLinea(Long idLinea){
        this.idLinea = idLinea;
    }
    
    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Articulo getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Articulo descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public Envase getEnvase() {
        return envase;
    }

    public void setEnvase(Envase envase) {
        this.envase = envase;
    }
}
