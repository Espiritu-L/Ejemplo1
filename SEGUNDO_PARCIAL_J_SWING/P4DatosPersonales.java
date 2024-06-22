/*mostrar datos con la lista  */

package SEGUNDO_PARCIAL_J_SWING;

import javax.swing.*;
public class P4DatosPersonales {

    // PARA IMPLEMETAR CLASES SIMPLEMENTE AUMENTAR public static class NOMBRE_CLASS
    // implemetacion de lista
    public static class PERSONA {
	    int ci;
	    String nombre, direccion, profersion;
	    float  sueldo;
	    PERSONA pun; // Puntero a la siguiente persona en la lista enlazada
    }

    // implementacion del proceso de la lista
    public static class Proceso {
        // declarando de tipo PERSONA para punteros
        PERSONA ingreso(PERSONA p1, PERSONA u1){
            String res = "", dat = "";
            
            do{
                if(p1 == null){
                    p1 = new PERSONA(); // creando nodo vacio para p1
                    dat = JOptionPane.showInputDialog("INGRESE CI: ",0);
                    p1.ci = Integer.parseInt(dat); // almacenando ci en p1
                    
                    p1.nombre = JOptionPane.showInputDialog("INGRESE NOMBRE: "); 
                        
                    p1.direccion = JOptionPane.showInputDialog("INGRESE DIRECCION: ");
                        
                    p1.profersion = JOptionPane.showInputDialog("INGRESE PROFESION: ");
                        
                    dat = JOptionPane.showInputDialog("INGRESE SUELDO: ",0);
                    p1.sueldo = Float.parseFloat(dat);
                        
                    //Creando el primer nodo
                    p1.pun = null;
                }
                else{
                    u1 = new PERSONA(); // creando nodo vacio para p1
                    dat = JOptionPane.showInputDialog("INGRESE CI: ",0);
                    u1.ci = Integer.parseInt(dat); // almacenando ci en p1
                    
                    u1.nombre = JOptionPane.showInputDialog("INGRESE NOMBRE: ",0);
                        
                    u1.direccion = JOptionPane.showInputDialog("INGRESE DIRECCION: ",0);
                        
                    u1.profersion = JOptionPane.showInputDialog("INGRESE PROFESION: ",0); 
                        
                    dat = JOptionPane.showInputDialog("INGRESE SUELDO: ",0);
                    u1.sueldo = Float.parseFloat(dat);
                    
                    // LA CLAVE PAR ANIDAR
                    u1.pun = p1;
                    p1 = u1;
                }
                res = JOptionPane.showInputDialog("PARA CONTINUAR PRESIONE *");
            }while(res.compareTo("*")!=0); // SI ES * SALE DEL SICLO
            
            
            return (p1); // retornar la direccion del nodo
        }
        
        void ver(PERSONA p1){
            String res = "";
            while(p1!=null){
                res = res + "CARNET: "+p1.ci + "\nNOMBRE: "+p1.nombre + "\nDIRECCION: "+p1.direccion+"\nPROFESION: "+p1.profersion +"\nSUELDO: "+p1.sueldo+"\n-----------------------------";
                
                p1 = p1.pun;
            }
            JOptionPane.showMessageDialog(null,"LISTA DE PERSONAS\n"+res);
        }
        
        void verprof(PERSONA p1){
        String res = "", prof = "";
        prof = JOptionPane.showInputDialog("ingrese profesion: ");
        while(p1!=null){
            if(prof.compareTo(p1.profersion)== 0){
        
                res = res + "CARNET: "+p1.ci + "\nNOMBRE: "+p1.nombre + "\nDIRECCION: "+p1.direccion+"\nPROFESION: "+p1.profersion +"\nSUELDO: "+p1.sueldo+"\n-----------------------------";
            
            }
            p1 = p1.pun;
        }
        JOptionPane.showMessageDialog(null,"LISTA DE PERSONAS\n"+res);
        }
    }
    
    public static void main(String[] args){
        //clase persona
        PERSONA p = null, u = null; // p y u son variables de puntero 
    
         // clase proceso
        Proceso pro = new Proceso();

        int op;
        String men = "";
        do{
    	    men = JOptionPane.showInputDialog(" 1.- INGRESO\n 2.- VER TODO\n 3.- BUSCAR POR PROFESION\n 4 .- SALIR\n\t ELIJA OPC.: ");
    	    op = Integer.parseInt(men);
    	    switch (op) {
   		        case 1: p = pro.ingreso(p,u);  break;
    	        case 2: pro.ver(p); // vamos con p ahi esta la dir de memoria e informacion
    	            break;
    	        case 3: pro.verprof(p); break;
    	        case 4: break;
		    }
        }while(op != 4);
    }
    
}

