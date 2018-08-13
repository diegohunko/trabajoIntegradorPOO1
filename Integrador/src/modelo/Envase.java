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
import java.util.Set;
import java.util.HashSet;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="envases")
public class Envase implements Serializable{
    @Id
    //@GeneratedValue
    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GENERATOR")
    private Long idEnvase;
    private Double capacidad;
    @OneToMany(mappedBy="envase")
    private Set<Articulo> articulos;
    @ManyToOne
    private TipoArticulo tipoArticulo;
    @OneToOne
    private Linea lineaEntrega;
    
    public Envase(){
        this.articulos = new HashSet<>();
    }
    
    public Envase(Double capacidad, TipoArticulo tipoArticulo) {
        this.capacidad = capacidad;
        this.tipoArticulo = tipoArticulo;
        this.articulos = new HashSet<>();
    }
    
    public Long getIdEnvase() {
        return idEnvase;
    }

    public void setIdEnvase(Long idEnvase) {
        this.idEnvase = idEnvase;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public Set<Articulo> getArticulo() {
        return articulos;
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
    
    public void agregarArticulo(Articulo articulo) {
        this.articulos.add(articulo);
    }
    
    public void quitarArticulo(Articulo articulo){
        this.articulos.remove(articulo);
    }
    
    @Override
    public String toString(){
        return this.idEnvase + " " +this.capacidad;
    }
}