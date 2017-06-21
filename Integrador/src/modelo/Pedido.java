/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{
    @Id 
    private Long idPedido;
    private Integer totalDeEntregas;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entregaInicial;
    private char periodicidad;
    //private List<Date> fechasDeEntrega;//es necesario este atributo?
    @OneToOne
    private Cliente propietario;
    @OneToMany(mappedBy = "nroPedido")
    private List<Entrega> entregas;
    
    public Pedido(){
        entregas = new ArrayList<>();
    }

}
