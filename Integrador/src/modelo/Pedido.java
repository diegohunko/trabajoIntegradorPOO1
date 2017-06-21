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
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{
    @Id
    @GeneratedValue
    private Long idPedido;
    private Integer totalDeEntregas;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entregaInicial;
    private char periodicidad;
    private List<Date> fechasDeEntrega;//es necesario este atributo?
    @ManyToOne
    private Cliente propietario;
    @OneToMany(mappedBy = "idPedido")
    private List<Entrega> entregas;
    
    //Constructores de la clase
    public Pedido(){
        entregas = new ArrayList<>();
        fechasDeEntrega = new ArrayList<>();
    }
    
    public Pedido(Cliente propietario, Date entregaInicial, 
            Integer totalDeEntregas, char periodicidad){
        entregas = new ArrayList<>();
        fechasDeEntrega = new ArrayList<>();
        this.propietario = propietario;
        this.entregaInicial = entregaInicial;
        this.totalDeEntregas = totalDeEntregas;
        this.periodicidad = periodicidad;
    }
    //Métodos de acceso y modificación de los atributos.
    
    public Long getIdPedido() {
        return idPedido;
    }
    
    public Cliente getPropietario(){
        return propietario;
    }
    
    public void setPropietario(Cliente nuevoCliente){
        this.propietario = nuevoCliente;
    }
    
    public List<Entrega> getEntregas(){
        return entregas;
    }
    
    public void setEntregas(List<Entrega> listaEntregas){
        this.entregas = listaEntregas;
    }
    
    public Date getEntregaInicial(){
        return new Date (entregaInicial.getTime());
    }
    
    public void setEntregaInicial(Date nuevaFechaEntregaInicial){
        this.entregaInicial = nuevaFechaEntregaInicial;
    }
    
    public char getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(char periodicidad) {
        this.periodicidad = periodicidad;
    }
    
    public List<Date> getFechasDeEntrega() {
        return fechasDeEntrega;
    }
    
    public void setTotalDeEntregas(Integer totalDeEntregas){
        this.totalDeEntregas = totalDeEntregas;
    }
    
    public Integer getTotalDeEntregas(){
        return totalDeEntregas;
    }

}
