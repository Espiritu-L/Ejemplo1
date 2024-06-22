
/*Almacenar en una lista numeros enteros para luego pasar a otras
dos listas, los num. primos y perfectos
 */
package SEGUNDO_PARCIAL_J_SWING;

import javax.swing.*;
public class  P1Perfecto_Primo {

    // elementos que tendra el nodo
    public static class Numero {
        int dat;
        Numero sig;
    }

    public static class SOLUCION {
        // pare ingresar numeros
        Numero leer(Numero p1, Numero u1){
            String dat = "";
            int num;
            do{
                if(p1 == null){ p1 = new Numero();
                    dat = JOptionPane.showInputDialog("INGRESE UN NUMERO: ");
                    num = Integer.parseInt(dat);
                    p1.dat = num;
    
                    p1.sig = null;
                }else{ u1 = new Numero();
                    dat = JOptionPane.showInputDialog("INGRESE UN NUMERO: ");
                    num = Integer.parseInt(dat);
                    u1.dat = num;
    
                    u1.sig = p1;
                    p1 = u1;
                }
                dat = JOptionPane.showInputDialog("PRESIONE * PARA FINALIZAR INGRESO: ");
            }while(dat.compareTo("*")!= 0);
           
            return p1;
        }

        // para ver la lista
        void ver(Numero p1, String men){
            String dat = "";

            while (p1 != null) {
                dat = dat + " " + p1.dat;

                p1 = p1.sig;
            }

            JOptionPane.showMessageDialog(null, men + "\n" + dat);
        }

        // sol. del problema: teniendo la lista separar a otras dos lista los num. primos y perfectos

        boolean esprimo(int n){
            int cont=0;
            for(int i=1; i<=n; i++){
                if(n%i==0){
                    cont ++;
                }
            }
            if(cont == 2){
                return true; // es primo
            }else{
                return false; // no es primo
            }
        }
        // para verificar si el numero es perfecto
        boolean perfecto(int n){
            int suma=0,m = n;
            for(int i=1; i<(n); i++){
                if(m % i == 0){
                    suma = suma + i;
                }
            }
            if(suma == n){
                return true; // es numero perfecto
            }else{
                return false; // no es numero perfecto
            }
        }
        Numero Primo(Numero p, Numero p2, Numero u2){
            while (p != null) {
                if(esprimo(p.dat)){
                    if(p2 == null){ p2 = new Numero();
                        
                        p2.dat = p.dat;
        
                        p2.sig = null;
                    }else{ u2 = new Numero();
                        
                        u2.dat = p.dat;
        
                        u2.sig = p2;
                        p2 = u2;
                    }
                }
                p = p.sig;
            }
            JOptionPane.showMessageDialog(null,"SE REALIZO EL PASE NUM. PRIMOS");
            return p2;
        }
        Numero Perfecto(Numero p, Numero p3, Numero u3){
            while (p != null) {
                if(perfecto(p.dat)){
                    if(p3 == null){ p3 = new Numero();
                    
                        p3.dat = p.dat;

                        p3.sig = null;
                    }else{ u3 = new Numero();
                        
                        u3.dat = p.dat;
        
                        u3.sig = p3;
                        p3 = u3;
                    }
                }
                p = p.sig;
            }
            JOptionPane.showMessageDialog(null,"SE REALIZO EL PASE NUM. PERFECTOS");
            return p3;
        }  
    }
    public static void main(String[] args){

        Numero p1=null, u1 = null, p2 = null, u2 = null, p3 = null, u3 = null;

        SOLUCION sol = new SOLUCION();

        int op=0;
        String men = "";
    
        do{
            men = JOptionPane.showInputDialog(" 1.- INGRESAR A LA LISTA\n 2.- PASAR\n 3.- VER LISTAS\n 4.- SALIR ");
            op = Integer.parseInt(men);
            switch (op) {
                case 1: p1 = sol.leer(p1, u1); break;
                case 2: p2 = sol.Primo(p1, p2, u2);
                        p3 = sol.Perfecto(p1, p3, u3);
                break;
                case 3: sol.ver(p1, "LISTA 1");
                        sol.ver(p2, "LISTA DE NUMEROS PRIMOS");
                        sol.ver(p3, "LISTA DE NUMEROS PERFECTOS");
                break;
                case 4: break;       
            }
        }while(op != 4);

    }
    
}
