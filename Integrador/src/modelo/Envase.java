/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="envases")
public class Envase implements Serializable{

    
    @Id
    @GeneratedValue
    private Long codigo;
    private Double capacidad;
    @OneToOne(mappedBy="codigo")
    private Articulo articulo;
    @ManyToOne
    private TipoArticulo tipoArticulo;
    @OneToOne(mappedBy = "envase")
    private Linea lineaEntrega;
    
    public Envase(){
        
    }
    
    public Envase(Double capacidad, Articulo articulo,
            TipoArticulo tipoArticulo) {
        this.capacidad = capacidad;
        this.articulo = articulo;
        this.tipoArticulo = tipoArticulo;
    }
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public Linea getLineaEntrega() {
        return lineaEntrega;
    }

    public void setLineaEntrega(Linea lineaEntrega) {
        this.lineaEntrega = lineaEntrega;
    }
}
