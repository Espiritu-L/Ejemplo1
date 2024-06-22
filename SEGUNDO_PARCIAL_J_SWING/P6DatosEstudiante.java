/*
 crear una lista para almacenar informacion de un estudiante
 */
package SEGUNDO_PARCIAL_J_SWING;
import javax.swing.*;
public class P6DatosEstudiante {

    public static class Estudiante {
    
        int ci;
        String nombre, carrera, facultad;
        float nota;
        Estudiante pun; // Puntero al siguiente Estudiante en la lista enlazada
    
    }

    // implementacion del proceso de la lista
    public static class Proceso {
        // funcion para ingresar datos del estudiante
        Estudiante Ingresar( Estudiante e1, Estudiante e2){

            String res = "", dat = "";

            do{
                if(e1 == null){
                    e1 = new Estudiante(); // creando nodo vacio para estudiante

                    e1.nombre = JOptionPane.showInputDialog("INGRESE NOMBRE");

                    dat = JOptionPane.showInputDialog("INGRESE CI",0);
                    e1.ci = Integer.parseInt(dat);

                    e1.facultad = JOptionPane.showInputDialog("NOMBRE DE FACULTAD",0);

                    e1.carrera = JOptionPane.showInputDialog("NOMBRE DE CARRERA",0);

                    dat = JOptionPane.showInputDialog("INGRESE LA NOTA",0);
                    e1.nota = Float.parseFloat(dat);

                    //creando el primer nodo, ojo si esto es vacio apunta al nul

                    e1.pun = null;

                }else{
                    // si no esta vacio
                    e2 = new Estudiante(); // creando nodo vacio para e2

                    e2.nombre = JOptionPane.showInputDialog("INGRESE NOMBRE");

                    dat = JOptionPane.showInputDialog("INGRESE CI",0);
                    e2.ci = Integer.parseInt(dat);

                    e2.facultad = JOptionPane.showInputDialog("NOMBRE DE FACULTAD", 0);

                    e2.carrera = JOptionPane.showInputDialog("NOMBRE DE CARRERA",0);

                    dat = JOptionPane.showInputDialog("INGRESE NOTA",0);
                    e2.nota = Float.parseFloat(dat);

                    // si el nodo no esta vacio, anidar

                    e2.pun = e1;
                    e1 = e2;
                   
                }
                res = JOptionPane.showInputDialog("PARA CONTINUAR PRESIONE *");
            }while(res.compareTo("*") != 0);
            
            return e1; // retornar la direcion de memoria

        }

        void ver(Estudiante e1){
            String res = "";
            while (e1 != null) {
                res = res + "\n------------------\n"
                + "CARNET: " + e1.ci 
                + "\nNOMBRE: " + e1.nombre + "\nFACULTAD: " + e1.facultad
                + "\nCARRERA: " + e1.carrera + "\nNOTA: " + e1.nota
                + "\n------------------";

                e1 = e1.pun;
            }

            JOptionPane.showMessageDialog(null, "LISTA DE ESTUDIANTES " + res);

        }

        void vercarrera(Estudiante e1){
            String res = "", carr = "";
            carr = JOptionPane.showInputDialog("INGRESE CARRERA");
            // mientras la lista no este vacia
            while (e1 != null) {
                if(carr.compareTo(e1.carrera) == 0){ // si existe de esa carrera
                res = res + "\n------------------\n"
                + "CARNET: " + e1.ci 
                + "\nNOMBRE: " + e1.nombre + "\nFACULTAD: " + e1.facultad
                + "\nCARRERA: " + e1.carrera + "\nNOTA: " + e1.nota
                + "\n------------------";
                }

                e1 = e1.pun;
            }
            JOptionPane.showMessageDialog(null, "LISTA DE ESTUDIANTES CON CARRERA "+ carr + "\n" + res);

        }

    }
    public static void main(String[] args){

        Estudiante p = null, u = null; // variables de puntero vacios
        
        Proceso pro = new Proceso();

        int op;
        String men = "";

        do{
    	    men = JOptionPane.showInputDialog(" 1.- INGRESAR\n 2.- VER TODO\n 3.- BUSCAR POR CARRERA\n 4 .- SALIR\n\t ELIJA OPC.: ");
    	    op = Integer.parseInt(men);
    	    switch (op) {
   		        case 1: p = pro.Ingresar(p,u);  break;
    	        case 2: pro.ver(p); // vamos con p ahi esta la dir de memoria e informacion
    	            break;
    	        case 3: pro.vercarrera(p); break;
    	        case 4: break;
		    }
        }while(op != 4);


    }
    
}

