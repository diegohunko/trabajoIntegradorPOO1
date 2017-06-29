/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vistas.VentanaPrincipal;
/**
 *
 * @author Diego Raul Fernandez
 */
public class Sistema {
    public static void main(String args[]){
        //TODO codigo aqui.
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("IntegradorPU");
        VentanaPrincipal miVentanaInicio = new VentanaPrincipal();
        miVentanaInicio.setVisible(true);
    }
}
