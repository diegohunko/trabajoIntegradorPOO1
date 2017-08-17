/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.*;
import persistencia.*;
/**
 *
 * @author Diego Raul Fernandez
 */
public class Controlador {
    Persistencia persistencia;
    
    public Controlador(Persistencia p) {
        this.persistencia = p;
    }
    
    //Controlador de clientes
    public List listarClientes(){
        return this.persistencia.buscarTodosOrdenadosPor(Cliente.class, 
                Cliente_.nroCliente);
        
    }
    
    public void nuevoCliente(String razonSocial, String cuit, String calle, 
            String numero, String localidad, String provincia){
        Cliente cliente;
        cliente = new Cliente(razonSocial, cuit, calle, numero, localidad, provincia);
        this.persistencia.iniciarTransaccion();
        try{
            this.persistencia.insertar(cliente);
            this.persistencia.confirmarTransaccion();
        }catch(Exception ex){
            this.persistencia.descartarTransaccion();
        }
    }
    
    //Controlador de Pedidos
    public void nuevoPedido(String propietario, Date entregaInicial, 
            Integer totalDeEntregas, char periodicidad){
        this.persistencia.iniciarTransaccion();
        try{
            //DO SOMETHING
            Cliente unPropietario;
            unPropietario = this.persistencia.buscar(Cliente.class, propietario);
            Pedido unPedido;
            unPedido = new Pedido(unPropietario, entregaInicial,
                    totalDeEntregas, periodicidad);
            unPedido.setPropietario(unPropietario);
            unPropietario.agregarPedido(unPedido);
            this.persistencia.modificar(unPropietario);
            this.persistencia.insertar(unPedido);
            this.persistencia.confirmarTransaccion();
        } catch(Exception ex){
            this.persistencia.descartarTransaccion();
        }
    }
    
    //Controlador de Entrega
    public void nuevaEntrega(){
        
    }
}
