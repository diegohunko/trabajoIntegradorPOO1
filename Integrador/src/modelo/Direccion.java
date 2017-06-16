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
}
