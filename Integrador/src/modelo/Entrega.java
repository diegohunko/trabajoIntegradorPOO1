/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;
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
    @ManyToOne
    private Pedido nroPedido;
    @OneToMany(mappedBy = "idEntrega")
    private List<Linea> detalle;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEntrega;
    
    //Construtores
    public Entrega(){
        detalle = new ArrayList<>();
    }
    
    //Accesores y Mutadores
    public Long getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Long idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Pedido getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(Pedido nroPedido) {
        this.nroPedido = nroPedido;
    }

    public List<Linea> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Linea> detalle) {
        this.detalle = detalle;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}