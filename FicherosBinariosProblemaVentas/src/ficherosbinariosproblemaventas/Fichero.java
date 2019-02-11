/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosbinariosproblemaventas;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Fichero {
    
    
    public static String calcularFacturasCliente(){
        Scanner leer = new Scanner(System.in);
        String cliente = null;
        int numero;
        String frase = null;
        double total=0;
        ArrayList<Venta> vVentas = new ArrayList();
        File f = new File("Ventas.txt");
        try {
            FileInputStream fi = new FileInputStream(f);
            DataInputStream leerF = new DataInputStream(fi);
            while (true) {
                Venta v = new Venta(leerF.readUTF(), leerF.readInt(), leerF.readInt(), leerF.readDouble());
                vVentas.add(v);
                
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("fin de lectra");;
        } catch (IOException ex) {
            System.out.println("Fin de lectura");;
        }
        
        
        
        
        System.out.println("Dime el nombre del cliente para calcular sus facturas");
        cliente = leer.nextLine();
        for (int i = 0; i < vVentas.size(); i++) {
            if(cliente.equalsIgnoreCase(vVentas.get(i).getCliente())){
                total+=vVentas.get(i).getCantidad()*vVentas.get(i).getPrecioUnitario();
            }
            
        }
        
        
        
        
        
        
        return "El usuario " + cliente + " ha gastado " + total;  
        
    } 
    
    
    public static ArrayList<Venta> leerVentasDisco(){
        File f = new File("Ventas.txt");
        FileInputStream fi;   
        DataInputStream leer = null;
        ArrayList<Venta> vVentas= new ArrayList();
        
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error al crear el fichero");
            }
        }
        
        try{
          
                fi = new FileInputStream(f);
                leer = new DataInputStream(fi);
            
                while (true){
                    Venta v = new Venta(leer.readUTF(), leer.readInt(), leer.readInt(), leer.readDouble());
                    vVentas.add(v);
                }
                
            
            } catch (FileNotFoundException ex) {
                System.out.println("Fichero no encontrado");
            } catch (IOException ex) {
            System.out.println("Fin de lectura del fichero");;
        }finally{
                try {
                    leer.close();
                } catch (IOException ex) {
                    System.out.println("Chapamos programa, error a saber cual");
            }
        }
        
        return vVentas;
    }
    
    public static void escribirVentaDisco(ArrayList<Venta> vVentas){
        File f = new File("Ventas.txt");
        FileOutputStream fo;
        DataOutputStream escribir = null;
         
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error al crear el fichero");
            }
        }
        
        try {
            fo = new FileOutputStream(f);
            escribir = new DataOutputStream(fo);
            
            for (Venta v : vVentas) {
                escribir.writeUTF(v.getCliente());
                escribir.writeInt(v.getProducto());
                escribir.writeInt(v.getCantidad());
                escribir.writeDouble(v.getPrecioUnitario());
            }
          
           
           
           
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error al encontrar el fichero");
        } catch (IOException ex) {
            System.out.println("Error al escribir en el fichero");
        }finally{
            try {
                escribir.close();
            } catch (IOException ex) {
                System.out.println("Error al escribir en el fichero");
            }
        }
          
        
    }
}
