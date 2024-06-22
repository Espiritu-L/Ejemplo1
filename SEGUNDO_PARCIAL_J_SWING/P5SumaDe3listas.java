package SEGUNDO_PARCIAL_J_SWING;

/*
ingresar numeros a 3 listas con diferents tamanios sumar todos los
 elementos hasta que una de listas finalize y grabar en otra lista los resultados
*/
import javax.swing.*;
public class P5SumaDe3listas{

    // implementacion de la lista
    public static class EDADES { // definiendo un nodo de lista enlazada
        int ed;     // almacena el valor entero
        EDADES sig; // sig apunta al siguiente nodo de la lista
    }
   
    // proceso de la lista
    public static class SOLUCION {
        EDADES Ingreso(EDADES p, EDADES u, String men){
            //  p = para la referencia la inicio\
            //  u = una referencia temporal para crear nuevos nodos en la lista
            String dat = "";

            do{
                if(p == null){ // si la lista esta vacia... se crea..
                    p = new EDADES(); // se crea un nuevo nodo y se asigna el valor ingresado al atributo ed
                    dat = JOptionPane.showInputDialog(men + "INGRESE EDAD ",15);
                    p.ed = Integer.parseInt(dat);
                    p.sig = null;
                    /*Se establece el atributo sig del nuevo nodo en 
                    null, ya que al ser el primer nodo 
                    de la lista no tiene un nodo siguiente.*/
                    
                }else{      // si la lista no esta vacia
                    u = new EDADES(); /* se crea un nuevo nodo, se le asigna el valor
                                     ingresado y se enlaza con la lista existente.*/
                    dat = JOptionPane.showInputDialog(men + "INGRESE EDAD ",15);
                    u.ed = Integer.parseInt(dat);
                    // enlazando
                    u.sig = p;
                    // p recibe u
                    p = u;
                    /*Se crea un nuevo bloque con la edad ingresada.
                    Se conecta al final de la fila.
                    La referencia al inicio se actualiza para apuntar al nuevo bloque.*/
   
                }

                dat = JOptionPane.showInputDialog("PRESIONE * PARA FINALIZAR");
            }while(dat.compareTo("*") != 0);
            ver(p, men);

            return p;

        }

        // funcion para mostrar
        void ver(EDADES x, String men){
            String res = "";
            while (x != null) {
                res = res + " " + x.ed + "\n";   
                x = x.sig;
            }
            JOptionPane.showMessageDialog(null, men + "\n" + res);
        }
   
        EDADES sumar(EDADES p1, EDADES p2, EDADES p3, EDADES p4, EDADES u4){

            String res = "";
            int r = 0;
            while (p1 != null && p2 != null && p3 != null) {
                r = 0;
                r = p1.ed + p2.ed + p3.ed;
                res = res + " " + p1.ed + " + " + p2.ed + " + " + p3.ed + " = " + r + "\n";

                // Crear un nuevo nodo para la suma
                // Si p4 está vacía, el nuevo nodo se convierte en el primer nodo de p4
                if (p4 == null) {
                    p4 = new EDADES(); 
                    p4.ed = r;
                    p4.sig = null;
               
                } else {
                    u4 = new EDADES();
                    u4.ed = r;

                    u4.sig = p4;

                    p4 = u4;
                }
                p1 = p1.sig;
                p2 = p2.sig;
                p3 = p3.sig;
            }
            JOptionPane.showMessageDialog(null, "\nSOLUCION\n" + res);

            //ver(p4, "\nLISTA 4");

            return p4;
            
        }

    }

    public static void main(String[] args){
        EDADES p1 = null, u1 = null, p2 = null, u2 = null,
               p3 = null, u3 = null, p4 = null, u4 = null;
        
        SOLUCION sol = new SOLUCION();

        String men = "";
        int op;

        do{
            men = JOptionPane.showInputDialog("1.- INGRESAR \n2.- SUMAR \n3.- VER LISTA \n4.- SALIR\n ELIJA OP.: ");
            op = Integer.parseInt(men);
            switch (op) {
                case 1: p1 = sol.Ingreso(p1, u1, "LISTA_1 ");
                        p2 = sol.Ingreso(p2, u2, "LISTA_2 ");
                        p3 = sol.Ingreso(p3, u3, "LISTA_3 ");
                break;
                case 2: sol.sumar(p1, p2, p3, p4, u4);
                break;
                case 3: 
                        sol.ver(p1, "LISTA_1 ");
                        sol.ver(p2, "LISTA_2 ");
                        sol.ver(p3, "LISTA_3 ");
                        p4 = sol.sumar(p1, p2, p3, p4, u4);
                        sol.ver(p4, "LISTA_4 ");
                break;
                case 4: JOptionPane.showMessageDialog(null, "\nSALIENDO DEL PROGRAMA");
                break;
            }
        }while(op != 4);

    }
    
}

