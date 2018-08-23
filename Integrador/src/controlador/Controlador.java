/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.metamodel.SingularAttribute;
//import javax.swing.JOptionPane;
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

    /**
     * Busca un cliente dado su ID.
     * @param criterioBusqueda : ID del cliente a buscar.
     * @return Cliente.
     */
    public Cliente buscarCliente(Object criterioBusqueda){
        return this.persistencia.buscar(Cliente.class, criterioBusqueda);
    }
    
    public Cliente buscarClienteCUIT(String cuit){
        return this.persistencia.buscarClientePorCuit(cuit);
    }
    
    /**
     *
     * @return Retorna una lista con los clientes
     */
    public List listarClientes(){
        return this.persistencia.buscarTodosOrdenadosPor(Cliente.class, 
                Cliente_.nroCliente);
        
    }
    
    /**
     *
     * @param razonSocial
     * @param cuit
     * @param calle
     * @param numero
     * @param localidad
     * @param provincia
     */
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
    
    public void eliminarCliente(Cliente c) throws Exception{
        if (c.getPedidos().isEmpty()){
            this.persistencia.iniciarTransaccion();
            this.persistencia.eliminar(c);
            this.persistencia.confirmarTransaccion();
        } else {
            throw new Exception("El cliente aún tiene pedidos");
            
        }
        
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
    
    public List buscarPedidos(Object metaModelo, Object criterio){
        try{
            return this.persistencia.buscarPorClaseCampoYCriterio(Pedido.class, (SingularAttribute)metaModelo, criterio);
        }catch(Exception e){
            
        }
            
       throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    //Controlador de Entrega

    /**
     * Agrega una nueva entrega a la base de datos
     * @param idPedido
     * @param fechaEntrega
     */
    public void nuevaEntrega(Object idPedido, Date fechaEntrega){
        try{
            this.persistencia.iniciarTransaccion();
            Pedido unPedido;
            //recuperar el pedido al que pertenece la entrega
            unPedido = (Pedido) this.persistencia.buscar(Pedido.class, idPedido);
            Entrega unaEntrega;
            //Crear una nueva entrega para el pedido
            unaEntrega = new Entrega(unPedido, fechaEntrega);
            //Insertar la entrega en la base de datos y actualizar(?) el pedido
            this.persistencia.insertar(unaEntrega);
            //Agregar la entrega al array de netregas del Pedido.
            unPedido.agregarEntrega(unaEntrega);
            this.persistencia.modificar(unPedido);
            this.persistencia.confirmarTransaccion();
            //return unaEntrega;
        }catch(Exception ex){
            this.persistencia.descartarTransaccion();
            //return null;
        }
    }
    
    public Entrega buscarEntrega(Object criterioBusqueda){
        return this.persistencia.buscar(Entrega.class, criterioBusqueda);
    }
    
    /**
     * Busca una entrega dada la fecha y el id del pedido al que pertenece.
     * @param fechaEnt
     * @param idPedido
     * @return Retorna la entrega que se busca.
     */
    public Entrega buscarEntrega(Date fechaEnt, Long idPedido){
        return this.persistencia.buscarEntrega(fechaEnt, idPedido);
        
    }

    /**
     * Crea una nueva linea de articulo para una entraga.
     * @param fechaEntrega : Fecha en la que debe ser entregado el pedido
     * @param entrega : Entrega a la que pertenece esta linea 
     * @param cantidad : Cantidad de un artículo para esta entrega
     * @param articulo : El artículo para esta entrega
     * @param envase : envase para este artículo
     */
    public void agregarLineaEntrega(Date fechaEntrega, Entrega entrega,
            Integer cantidad, //Object tipoArticulo,
            Articulo articulo, Envase envase){
        try{
            //Inicia la transaccion
            this.persistencia.iniciarTransaccion();
            //Recuperar los objetos para crear un objeto de tipo Linea
            /*Entrega unaEntrega;
            unaEntrega = (Entrega) this.persistencia.buscar(Entrega.class, idEntrega);*/
            /*Articulo unArticulo;
            unArticulo = (Articulo) this.persistencia.buscar(Articulo.class, articulo);
            Envase unEnvase;
            unEnvase = (Envase) this.persistencia.buscar(Envase.class, envase);*/
            
            //Creamos la linea para la entrega
            Linea unaLinea;
            unaLinea = new Linea(entrega, articulo, cantidad, envase);
            //Insertar la nueva linea en la tabla renglones en la base de datos
            this.persistencia.insertar(unaLinea);
            //Agregamos la linea a la entrega
            entrega.agregarLineaDetalle(unaLinea);
            //actualizar la tabla entregas
            this.persistencia.modificar(entrega);
            this.persistencia.confirmarTransaccion();
        }catch(Exception ex){
            this.persistencia.descartarTransaccion();
        }
    }
    
    /**
     * Devuelve el detalle de una entrega.
     * @param entrega Entrega de la que se quiere recuperar el detalle.
     * @return Lista conteniendo el detalle de la entrega pasada como parámetro.
     */
    public List listarDetalleEntrega(Entrega entrega){
        return this.persistencia.buscarPorClaseCampoYCriterio(Linea.class, Linea_.entrega, entrega);
    }
    
    /**
     * Recupera todos los tipos de artículo de la base de datos.
     * @return lista que contiene los tipos de artículo.
     */
    public List listarTipoArticulo(){
        return this.persistencia.buscarTodosOrdenadosPor(TipoArticulo.class, TipoArticulo_.idTipoArticulo);
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
            tipoArticulo.agregarEnvase(nuevoEnvase);
            this.persistencia.modificar(tipoArticulo);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e){
            this.persistencia.descartarTransaccion();
        }
        
    }
    
    /**
     * Devuelve un Envase segun su capacidad y tipo
     * @param capacidad
     * @param ta
     * @return
     */
    public Envase buscarEnvaseCapacidadTipo(Double capacidad, TipoArticulo ta){
        return this.persistencia.buscarEnvaseCapTipo(capacidad, ta);
    }

    /**
     * Busca los artículos según una columna de la tabla.
     * @param metaModelo Se obtiene del metamodelo generado por EclipseLink
     * @param criterio Lo que se quiere buscar
     * @return List de artículos que coinciden con criterio.
     */
    public List buscarArticulos(Object metaModelo, Object criterio) {
        return this.persistencia.buscarPorClaseCampoYCriterio(Articulo.class, (SingularAttribute)metaModelo, criterio);
    }

    public void nuevoArticulo(
            String descripcion,
            Double largo,
            Double ancho,
            Double diametro,
            //Envase envase,
            TipoArticulo tipo) {
        try {
            this.persistencia.iniciarTransaccion();
            Articulo unArticulo;
            unArticulo = new Articulo(
                    descripcion,
                    largo,
                    ancho,
                    diametro,
                    tipo);
            
            this.persistencia.insertar(unArticulo);
            tipo.agregarArticulo(unArticulo);
            this.persistencia.modificar(tipo);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.out.println("Error, en nuevo articulo.");
            throw e;
        }
    }

    public List buscarEnvaseTipo(TipoArticulo ta) {
        return this.persistencia.buscarPorClaseCampoYCriterio(Envase.class, Envase_.tipoArticulo, ta);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void nuevoTipoArticulo(String text) {
        try {
            TipoArticulo ta;
            ta = new TipoArticulo(text);
            this.persistencia.iniciarTransaccion();
            this.persistencia.insertar(ta);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }

    /*public void nuevoArticulo(String text, double parseDouble, double parseDouble0, double parseDouble1, List<Envase> env, TipoArticulo ta) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public List listarArticulos(){
        return this.persistencia.buscarTodos(Articulo.class);
    }

    public void eliminarArticulo(Articulo articulo) {
        try {
            this.persistencia.iniciarTransaccion();
            this.persistencia.eliminar(articulo);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            throw e;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editarArticulo(Articulo art, String newDescripcion,
            double newLargo, double newAncho,
            double newDiametro) {
        
        try {
            this.persistencia.iniciarTransaccion();
            art.setDescripcion(newDescripcion);
            art.setLargo(newLargo);
            art.setAncho(newAncho);
            art.setDiametro(newDiametro);
            this.persistencia.modificar(art);
            this.persistencia.confirmarTransaccion();
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
            throw ex;
        }
 //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Convierte un String a Date.
     * @param fecha cadena de texto a ser convertida en fecha
     * @return Date
     * @throws ParseException
     */
    public Date dateParser(String fecha) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(fecha);
        } catch (ParseException ex) {
            throw ex;
        }
    }

    public void eliminarTipoArticulo(TipoArticulo ta) {
        if (ta.getArticulo().isEmpty() && ta.getEnvases().isEmpty()) {
            this.persistencia.iniciarTransaccion();
            this.persistencia.eliminar(ta);
            this.persistencia.confirmarTransaccion();
        }else{
            throw new UnsupportedOperationException("No se pudo eliminar, hay elementos relacionados.");
        }
    }
}
