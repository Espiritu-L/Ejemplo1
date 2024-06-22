/*almacenar en una lista nombres de personas, para luego pasar a otras dos listas
 La primera solo las vocales y la segunda lista solo las constantes
 mostrar las 3 listas
 */
import javax.swing.*;
public class P2SepVocalesY_Letras{
// creando la lisat
public static class Nombres {
    String no;
    Nombres sig;
}

//solucion
public static class Solucion {
    // para leer lista
    Nombres ingreso(Nombres p1, Nombres u1){
        String dat = "";
        do{
            if(p1 == null){ p1 = new Nombres();
                p1.no = JOptionPane.showInputDialog("INGRESE NOMBRE");
                p1.sig = null;

            }else{ u1 = new Nombres();
                u1.no = JOptionPane.showInputDialog("INGRESE NOMBRE");
                u1.sig = p1;
                p1 = u1;
            }
            dat = JOptionPane.showInputDialog("PARA SEGUIR PRESIONE ENTER\nPARA SALIR PRESION  *");
        }while(dat.compareTo("*") != 0);

        return p1;
    }

    // para ver la lista
    void ver(Nombres p1, String men){
        String dat =  "";

        while (p1 != null) {
            dat = dat + p1.no + "\n";
            p1 = p1.sig;
        }
        JOptionPane.showMessageDialog(null,men+"\n"+dat);
    }

    // para separar los vocales
    Nombres vocales(Nombres p1, Nombres p2, Nombres u2){
        while (p1 != null) {
            String s = p1.no, s2 = "";
            if(p2==null){ p2 = new Nombres();
                
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if ("AEIOUaeiou".indexOf(c) != -1) { // si existe una de esas vocales se almacena en s2
                        s2 = s2 + c;
                    }
                }
                p2.no = s2;
                p2.sig = null;
            }else{ u2 = new Nombres();

                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if ("aeiouAEIOU".indexOf(c) != -1) {
                        s2 = s2 + c;
                    }
                }

                u2.no = s2;
                u2.sig = p2;
                p2 = u2;
            }
            p1 = p1.sig;
        }
        return p2;
    }

    // separar las constantes
    Nombres novocales(Nombres p1, Nombres p3, Nombres u3){
        while (p1 != null) {
            String s = p1.no, s3 = "";

            if(p3 == null){ p3 = new Nombres();
                for(int i=0; i<s.length(); i++){
                    char c = s.charAt(i);
                    if("aeiouAEIOU".indexOf(c) != -1){
    
                    }else{
                        s3 = s3 + c;
                    }
                }

                p3.no = s3;
                p3.sig = null;

            }else{ u3 = new Nombres();
                for(int i=0; i<s.length(); i++){
                    char c = s.charAt(i);
                    if("aeiouAEIOU".indexOf(c) != -1){
    
                    }else{
                        s3 = s3 + c;
                    }
                }

                u3.no = s3;
                u3.sig = p3;
                p3 = u3;
            }

            p1 = p1.sig;
        }
        JOptionPane.showMessageDialog(null,"PROCESO REALIZADO");
        return p3;
    }


}
    public static void main(String[] args){

        Nombres p1 = null, u1 = null, p2 = null, u2 = null, p3 = null, u3 = null;
        Solucion sol = new Solucion();

        int op = 0;
        String  men = "";
        do{
            men = JOptionPane.showInputDialog("1.- ALMACENAR NOMBRES\n2.- SEPARAR\n3.- VER TODAS LAS LISTA\n4.- SALIR");
            op = Integer.parseInt(men);
            switch (op) {
                case 1: p1 = sol.ingreso(p1, u1); break;

                case 2: p2 = sol.vocales(p1, p2, u2);
                        p3 = sol.novocales(p1, p3, u3);
                        break;

                case 3: sol.ver(p1, "lista completo");
                        sol.ver(p2, "LISTA DE VOCALES"); 
                        sol.ver(p3, "LISTA SIN VOCALES");
                        break;

                case 4: break;
            }

        }while(op != 4);
    }
}
