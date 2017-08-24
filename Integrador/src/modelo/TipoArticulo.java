/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Diego Raul Fernandez
 */

@Entity
@Table(name="tipos_articulos")
public class TipoArticulo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GENERATOR")
    private Long idTipoArticulo;
    @Column(length = 100, nullable = false)
    private String descripcion;
    @OneToMany(mappedBy = "tipoArticulo")
    private List<Envase> envases;
    @OneToMany(mappedBy = "tipo")
    private List<Articulo> articulos;
    
    public TipoArticulo(){
        this.envases = new ArrayList<>();
        this.articulos = new ArrayList<>();
    }
    
    public TipoArticulo(String descripcion){
        this.descripcion = descripcion;
        this.envases = new ArrayList<>();
        this.articulos = new ArrayList<>();
    }
    
    public Long getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(Long idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Envase> getEnvases() {
        return envases;
    }

    public void setEnvases(List<Envase> envases) {
        this.envases = envases;
    }
    
     public List<Articulo> getArticulo() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    public void agregarEnvase(Envase nuevoEnvase){
        this.envases.add(nuevoEnvase);
    }
    
    public void eliminarEnvase(Envase viejoEnvase){
        this.envases.remove(viejoEnvase);
    }
    
    
    public void agregarArticulo(Articulo nuevoArticulo){
        this.articulos.add(nuevoArticulo);
    }
    
    public void eliminarArticulo(Articulo viejoArticulo){
        this.articulos.remove(viejoArticulo);
    }
}
