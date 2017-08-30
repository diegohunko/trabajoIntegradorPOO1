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
import java.util.Calendar;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
/**
 *
 * @author Diego Raul Fernandez
 */
@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{
    @Id
    @TableGenerator(name="TABLE_GENERATOR_PEDIDO", table="ID_TABLE_PEDIDO", pkColumnName="ID_TABLE_NAME",
            pkColumnValue="PEDIDO_ID", valueColumnName="ID_TABLE_VALUE")
    //@SequenceGenerator(name="sec_pedido", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GENERATOR_PEDIDO")
    private Long idPedido;
    private Integer totalDeEntregas;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entregaInicial;
    private char periodicidad;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private final Calendar marcaDeTiempo;
    @ManyToOne
    private Cliente propietario;
    @OneToMany(mappedBy = "nroPedido")
    private List<Entrega> entregas;
    
    //Constructores de la clase
    public Pedido(){
        entregas = new ArrayList<>();
        marcaDeTiempo = Calendar.getInstance();
    }
    
    public Pedido(Cliente propietario, Date entregaInicial, 
            Integer totalDeEntregas, char periodicidad, Calendar marcaTiempo){
        entregas = new ArrayList<>();
        this.marcaDeTiempo = marcaTiempo;
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
    
    /*
    public List<Date> getFechasDeEntrega() {
        return fechasDeEntrega;
    }
    */
    
    public void setTotalDeEntregas(Integer totalDeEntregas){
        this.totalDeEntregas = totalDeEntregas;
    }
    
    public Integer getTotalDeEntregas(){
        return totalDeEntregas;
    }
    
    public void agregarEntrega(Entrega unaEntrega){
        this.entregas.add(unaEntrega);
        //this.fechasDeEntrega.add(unaEntrega.getFechaEntrega());
    }
    
    public void removerEntrega(Entrega unaEntrega){
        this.entregas.remove(unaEntrega);
        //this.fechasDeEntrega.remove(unaEntrega.getFechaEntrega());
    }

}
