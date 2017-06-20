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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="entregas")
public class Entrega implements Serializable{
    @Id
    private Long idEntrega;
    @Id //?
    @ManyToOne
    private Pedido nroPedido;
    @OneToMany(mappedBy = "entrega")
    private List<Linea> detalle;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEntrega;
}