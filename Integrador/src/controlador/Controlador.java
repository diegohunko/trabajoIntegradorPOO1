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
    
    public List listarClientes(){
        return this.persistencia.buscarTodosOrdenadosPor(Cliente.class, 
                Cliente_.nroCliente);
        
    }
}
