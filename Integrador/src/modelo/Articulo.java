/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
/**
 *
 * @author Diego Raul Fernandez
 */
public class Articulo implements Serializable{
    private Long codigo;
    private String descripcion;
    private Double largo;
    private Double ancho;
    private Double diametro;
    private Envase envase;
}
