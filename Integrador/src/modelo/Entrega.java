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
import javax.persistence.GeneratedValue;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="entregas")
public class Entrega implements Serializable{
    @Id
    @GeneratedValue
    private Long idEntrega;
    @ManyToOne
    private Pedido nroPedido;
    @OneToMany(mappedBy = "entrega")
    private List<Linea> detalle;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEntrega;
    
    //Construtores
    public Entrega(){
        this.detalle = new ArrayList<>();
    }
    
    /**
     *
     * @param pedido : Pedido al que pertenece la entrega
     * @param fechaEntrega : Fecha en la que la entrega debe ser servida al cliente
     */
    public Entrega(Pedido pedido, Date fechaEntrega){
        this.detalle = new ArrayList<>();
        this.nroPedido = pedido;
        this.fechaEntrega = fechaEntrega;
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
    
    public void agregarLineaDetalle(Linea l){
        this.detalle.add(l);
    }
    
    public void quitarLineaDetalle(Linea l){
        this.detalle.remove(l);
    }
}