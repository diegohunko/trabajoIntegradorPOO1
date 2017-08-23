/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
    @Id
    @TableGenerator(name="TABLE_GENERATOR", table="ID_TABLE", pkColumnName="ID_TABLE_NAME",
            pkColumnValue="CLIENTE_ID", valueColumnName="ID_TABLE_VALUE")
    //@SequenceGenerator(name="sec_cliente", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GENERATOR")
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
    
    public Cliente(String razonSocial, String cuit, String calle, 
            String numero, String localidad, String provincia){
        pedidos = new ArrayList<>();
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        Direccion d = new Direccion(calle, numero, localidad, provincia);
        this.domicilioFiscal = d;
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
    
    //los mejore, los únicos los MÉTODOS piqueteros
    public void agregarPedido(Pedido p){
        this.pedidos.add(p);
    }
    
    public void quitarPedido(Pedido p){
        this.pedidos.remove(p);
    }
}
