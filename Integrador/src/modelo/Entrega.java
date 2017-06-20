/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
/**
 *
 * @author Diego Raul Fernandez
 */
public class Entrega implements Serializable{
    @Id
    private Long idEntrega;
    private Pedido nroPedido;
    private List<Linea> detalle;
    private Date fechaEntrega;
}
