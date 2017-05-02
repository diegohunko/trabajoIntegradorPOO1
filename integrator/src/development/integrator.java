 /*Ensayos con hit hub v1.0 2.05.2017 */
package development;

/* @author Acer */
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextPane;
/*importamos las clases para el escaneo de valores y 
presentacion por pantalla*/
public class integrator {
//{clase integrador [ paquete development ]}
    public static void main(String[] args) {
        // TODO code application logic here
        int valor = 5;
        //variable entera
    while (valor == (5))  {
        //control ejecucion del programa
        System.out.println(" / Hola trabajo integrador / ");
        System.out.println(" / Prueba numero 1 en git hub con net beans / ");
        //Creamos una ventana
        JFrame miVentana = new JFrame();
        miVentana.setTitle (" - TRABAJO INTEGRADOR PRUEBA01 (هولا موندو) -"); //le ponemos título a nuestra ventana
        //Creamos un campo de texto
        JTextPane miCampoDeTexto = new JTextPane();
        miCampoDeTexto.setText("Prueba en Git Hub con NetBeans IDE 8.2; presentacion mensaje con inteface grafica "
        + "preparado a las 0:52 de la manana XD" );
        //ahora ingresamos el campo de texto en la ventana
        miVentana.add(miCampoDeTexto);
        //1- le decimos a la ventana que cierre el programa si alguien pulsa la X de cierre
        miVentana.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        //2- ponemos como tamaño de ventana el mínimo necesario para que se vea todo lo que contiene
        miVentana.pack();
        //3- decimos que la ventana sea visible
        miVentana.setVisible(true);
        // Cierre de aplicacion
        System.out.println(" / presione 0 para finalizar / ");
        // cerramos por consola la aplicacion
        Scanner entrada = new Scanner(System.in);
        valor = entrada.nextInt();
        // variable cierre de operaciones 
        }
    }
    
}
