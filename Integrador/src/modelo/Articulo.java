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
import javax.persistence.OneToMany;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="articulos")
public class Articulo implements Serializable{
    @Id
    @GeneratedValue
    private Long codigo;
    private String descripcion;
    private Double largo;
    private Double ancho;
    private Double diametro;
    @OneToOne
    private Envase envase;
}
