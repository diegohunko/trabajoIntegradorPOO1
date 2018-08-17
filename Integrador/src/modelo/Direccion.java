/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import javax.persistence.Embeddable;
/**
 *
 * @author Diego Raul Fernandez
 */
@Embeddable
public class Direccion implements Serializable{

    
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
    
    public Direccion(){
        
    }
    
    public Direccion(String calle, String numero, String localidad, 
            String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    @Override
    public String toString(){
        return this.calle + " " +
                this.numero + ", " +
                this.localidad + " " +
                this.provincia;
    }
}
