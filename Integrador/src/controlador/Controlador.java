/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.metamodel.SingularAttribute;
import javax.swing.JOptionPane;
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
    public Cliente buscarCliente(Object criterioBusqueda){
        return this.persistencia.buscar(Cliente.class, criterioBusqueda);
    }
    
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
    
    public void modificarCliente(Cliente c, String razonSocial, String calle, 
            String numero, String localidad, String provincia){
        if (c != null){
            this.persistencia.iniciarTransaccion();
            try{
                Direccion nuevoDomicilio = c.getDomicilioFiscal();
                nuevoDomicilio.setCalle(calle.toUpperCase());
                nuevoDomicilio.setNumero(numero.toUpperCase());
                nuevoDomicilio.setLocalidad(localidad.toUpperCase());
                nuevoDomicilio.setProvincia(provincia.toUpperCase());
                c.setRazonSocial(razonSocial.toUpperCase());
                c.setDomicilioFiscal(nuevoDomicilio);
                this.persistencia.modificar(c);
                this.persistencia.confirmarTransaccion();
            }catch(Exception ex){
                this.persistencia.descartarTransaccion();
            }
        }
    }
    
    public void eliminarCliente(){
        
    }
    
    //Controlador de Pedidos
    public Pedido buscarPedido(Object criterioBusqueda){
        return this.persistencia.buscar(Pedido.class, criterioBusqueda);
    }

    /**
     *
     * @param c
     * @return
     */
    public List listarPedidosCliente(Cliente c){
        return this.persistencia.buscarTodosOrdenadosPor(Pedido.class, Pedido_.propietario);
    }
    
    /**
     *
     * @param cuitOwner
     * @param entregaInicial
     * @param totalDeEntregas
     * @param periodicidad
     * @param marcaTiempo
     * @return idPedido si tiene éxito; -1 en caso de argumento ilegal; 
     * -2 si no se encuentran resultados, al buscar el propietario del pedido;
     * -3 en caso de puntero a null y
     * -4 en cualquier otro caso.
     */
    public Long nuevoPedido(String cuitOwner, Date entregaInicial, 
            Integer totalDeEntregas, char periodicidad, Calendar marcaTiempo){
        this.persistencia.iniciarTransaccion();
        try{
            //DO SOMETHING
            Cliente unPropietario;
            unPropietario = this.persistencia.buscarClientePorCuit(cuitOwner);
            Pedido unPedido, elMismoPedido;
            unPedido = new Pedido(unPropietario, entregaInicial,
                    totalDeEntregas, periodicidad, marcaTiempo);
            //unPedido.setPropietario(unPropietario);
            unPropietario.agregarPedido(unPedido);
            this.persistencia.modificar(unPropietario);
            this.persistencia.insertar(unPedido);
            this.persistencia.confirmarTransaccion();
            elMismoPedido = this.persistencia.buscarPedidoPerdido(cuitOwner,
                    entregaInicial, totalDeEntregas, periodicidad, marcaTiempo);
            return elMismoPedido.getIdPedido();
        } catch(IllegalArgumentException ex){
            this.persistencia.descartarTransaccion();
            return 0xffffffffffffffffL; //retorna -1
        } catch(NoResultException ex){
            this.persistencia.descartarTransaccion();
            return 0xfffffffffffffffeL; //retorna -2
        }catch (NullPointerException ex){
            this.persistencia.descartarTransaccion();
            return 0xfffffffffffffffdL; //retorna -3
        } catch (Exception ex){
            this.persistencia.descartarTransaccion();
            return 0xfffffffffffffffcL; //retorna -4
        }
    }
    
    public List mostrarPedidos(){
        return this.persistencia.vistaPedido();
    }
    
    //Controlador de Entrega

    /**
     *
     * @param pedido
     * @param fechaEntrega
     */
    public void nuevaEntrega(Object pedido, Date fechaEntrega){
        try{
            this.persistencia.iniciarTransaccion();
            Pedido unPedido;
            //recuperar el pedido al que pertenece la entrega
            unPedido = (Pedido) this.persistencia.buscar(Pedido.class, pedido);
            Entrega unaEntrega;
            //Crear una nueva entrega para el pedido
            unaEntrega = new Entrega(unPedido, fechaEntrega);
            //Agregar la entrega al array de netregas del Pedido.
            unPedido.agregarEntrega(unaEntrega);
            //Insertar la entregaen la base de datos y actualizar(?) el pedido
            this.persistencia.insertar(unaEntrega);
            this.persistencia.refrescar(unPedido);
            this.persistencia.confirmarTransaccion();
        }catch(Exception ex){
            this.persistencia.descartarTransaccion();
        }
    }
    /**
     * 
     * @param fechaEntrega : Fecha en la que debe ser entregado el pedido
     * @param idEntrega : Entrega a la que pertenece esta linea
     * @param cantidad : Cantidad de un artículo para esta entrega
     * @param articulo : El artículo para esta entrega
     * @param envase : envase para este artículo
     */
    public void agregarLineaEntrega(Date fechaEntrega, Object idEntrega,
            Integer cantidad, //Object tipoArticulo,
            Object articulo, Object envase){
        try{
            //Inicia la transaccion
            this.persistencia.iniciarTransaccion();
            //Recuperar los objetos para crear un objeto de tipo Linea
            Entrega unaEntrega;
            unaEntrega = (Entrega) this.persistencia.buscar(Entrega.class, idEntrega);
            Articulo unArticulo;
            unArticulo = (Articulo) this.persistencia.buscar(Articulo.class, articulo);
            Envase unEnvase;
            unEnvase = (Envase) this.persistencia.buscar(Envase.class, envase);
            
            //Creamos la linea para la entrega
            Linea unaLinea;
            unaLinea = new Linea(unaEntrega, unArticulo, cantidad, unEnvase);
            
            //Agregamos la linea a la entrega
            unaEntrega.agregarLineaDetalle(unaLinea);
            
            //Insertar la nueva linea en la tabla renglones en la base de datos
            this.persistencia.insertar(unaLinea);
            //actualizar la tabla entregas
            this.persistencia.refrescar(unaEntrega);
            this.persistencia.confirmarTransaccion();
        }catch(Exception ex){
            this.persistencia.descartarTransaccion();
        }
    }
    
    /**
     * Recupera todos los tipos de artículo de la base de datos.
     * @return lista que contiene los tipos de artículo.
     */
    public List listarTipoArticulo(){
        return this.persistencia.buscarTodosOrdenadosPor(TipoArticulo.class, TipoArticulo_.descripcion);
    }
    
    /**
     * Agrea un nuevo envase a la base de datos.
     * @param capacidad
     * @param tipoArticulo
     */
    public void agregarNuevoEnvase(Double capacidad, TipoArticulo tipoArticulo){
        try{
            this.persistencia.iniciarTransaccion();
            Envase nuevoEnvase;
            nuevoEnvase = new Envase(capacidad, tipoArticulo);
            this.persistencia.insertar(nuevoEnvase);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e){
            this.persistencia.descartarTransaccion();
        }
        
    }
    
    public Envase buscarEnvaseCapacidadTipo(Double capacidad, TipoArticulo ta){
        return this.persistencia.buscarEnvaseCapTipo(capacidad, ta);
    }

    public ArrayList<Articulo> buscarArticulos(Object metaModelo, Object criterio) {
        return (ArrayList<Articulo>) this.persistencia.buscarPorClaseCampoYCriterio(Articulo.class, (SingularAttribute)metaModelo, criterio);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
