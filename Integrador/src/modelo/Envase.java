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
    private Articulo tipoArticulo;
}
