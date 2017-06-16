/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Diego Raul Fernandez
 */
public class Pedido {
     private Long idPedido;
     private Integer totalDeEntregas;
     private Date entregaInicial;
     private char periodicidad;
     private List<Date> fechasDeEntrega;//es necesario este atributo?
     private Cliente propietario;
     private List<Entrega> entregas;

}
