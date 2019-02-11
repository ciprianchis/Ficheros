/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosbinariosproblemaventas.newpackage;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Menu {
    
    public static int mostrareMenu(){
        Scanner leer = new Scanner(System.in); 
        int opcion = 0;
        do{
            try{
                System.out.println(".......................MENU...............................");
                System.out.println(" 1. Mostrar el valor de las facturas de un cliente........");
                System.out.println(" 2. Mostrar el valor de las facturas de todos  los cliente");
                System.out.println(" 3. Mostrar la cantidad de clientes.......................");
                System.out.println(" 4. Guardar datos.........................................");
                System.out.println(" 5. Salir.................................................");
                System.out.println("..........................................................");
                opcion = leer.nextInt();

            }catch(Exception e){
                System.out.println("Opción no válida, elija otra");
                break;
            }
        }while((opcion<0) || (opcion>6));

        return opcion;
 
    }
    
    
    
}
