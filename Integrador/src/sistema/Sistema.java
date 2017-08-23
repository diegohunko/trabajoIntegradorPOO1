/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vistas.VentanaPrincipal;
import persistencia.Persistencia;
import controlador.Controlador;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Diego Raul Fernandez
 */
public class Sistema {
    public static void main(String args[]){
        //TODO codigo aqui.
        try{
            EntityManagerFactory emf;
            emf = Persistence.createEntityManagerFactory("IntegradorPU");
            Persistencia persistencia = new Persistencia(emf);
            Controlador c = new Controlador(persistencia);
            VentanaPrincipal miVentanaInicio;
            miVentanaInicio = new VentanaPrincipal(c);
            miVentanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            miVentanaInicio.setVisible(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, 
                    e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
