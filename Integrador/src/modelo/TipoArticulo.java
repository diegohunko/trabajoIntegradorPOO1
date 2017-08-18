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
    @GeneratedValue
    private Long idTipoArticulo;
    private String descripción;
    @OneToMany(mappedBy = "tipoArticulo")
    private List<Envase> envases;
    @OneToOne(mappedBy = "tipo")
    private Articulo articulo;

    public TipoArticulo(){
        this.envases = new ArrayList<>();
    }
    
    public TipoArticulo(String descripcion){
        this.descripción = descripcion;
        this.envases = new ArrayList<>();
    }
    
    public Long getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(Long idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
    
    public List<Envase> getEnvases() {
        return envases;
    }

    public void setEnvases(List<Envase> envases) {
        this.envases = envases;
    }
}
