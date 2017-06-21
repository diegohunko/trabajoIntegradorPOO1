/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.Table;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
    @Id
    @SequenceGenerator(name="sec_cliente", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_cliente")
    private Long nroCliente;
    @OneToMany(mappedBy = "propietario")//
    private List<Pedido> pedidos;
    private String cuit;
    private String razonSocial;
    @Embedded
    private Direccion domicilioFiscal;
    
    //constructores
    public Cliente(){
        pedidos = new ArrayList<>();
    }
    
    public Cliente(String razonSocial, String cuit, Direccion domicilioFiscal){
        pedidos = new ArrayList<>();
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.domicilioFiscal = domicilioFiscal;
    }
    
    public Long getNroCliente() {
        return nroCliente;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public String getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public Direccion getDomicilioFiscal() {
        return domicilioFiscal;
    }
    
    public void setNroCliente(Long nroCliente) {
        this.nroCliente = nroCliente;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setDomicilioFiscal(Direccion domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }
    
    
    
}
