/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosbinariosproblemaventas;

import ficherosbinariosproblemaventas.newpackage.Menu;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class FicherosBinariosProblemaVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcion = 0;
        ArrayList<Venta> vVentas = Fichero.leerVentasDisco();
        
        do {            
            
            opcion = Menu.mostrareMenu();
            switch(opcion){
                
                case 1: //Mostrar el valor de las facturas de un cliente
                    System.out.println(Fichero.calcularFacturasCliente());
                    break;
                    
                case 2: //Mostrar el valor de las facturas de todos  los cliente
                    
                    for (Venta v : vVentas) {
                        System.out.println(v);
                    }
                    break;
                    
                case 3: //Mostrar la cantidad de clientes
                     ArrayList<String> vNombres = new ArrayList();
                    for (Venta v : vVentas) {
                       if (!vNombres.contains(v.getCliente())){
                           vNombres.add(v.getCliente());
                       }
                    }
                    System.out.println("Hay " + vNombres.size());
                    break;
                    
                case 4: // Guardar datos
                    Fichero.escribirVentaDisco(vVentas);
                    break;
                    
                case 5: //salir
                    System.out.println("Saliendo del programa");
                    Fichero.escribirVentaDisco(vVentas);
                    break;
                    
            }
        } while (opcion!=5);
        
        
        File f = new File("Ventas.txt");
        File copia = new File("Copia.txt");
        
        
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                
            }         
        }
        
        if (!copia.exists()) {
            try {
                copia.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error al crear el fichero");
            }
            
        }
        
        FileInputStream fi;
        DataInputStream leer;
        
        FileOutputStream fo;
        DataOutputStream escribir;
        
        
    }
    
}
