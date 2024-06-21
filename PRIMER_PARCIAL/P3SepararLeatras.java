package PRIMER_PARCIAL;
import java.util.Scanner;

public class P3SepararLeatras {

    // para separar los caracreres 
    public static String separar(String s){
        String nom = "";
        for(int i=0; i<s.length(); i++){
            // Verificar si el carct. en pos. i de cadena s es una letra (mayuscula o minuscula).
            if (Character.isLetter(s.charAt(i))){
                nom = nom + s.charAt(i);
            }

        }
        return nom;
        /*
            StringBuilder nom = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetter(s.charAt(i))) {
                    nom.append(s.charAt(i));
                }
            }
            return nom.toString();

             */

    }

    // para mostrar la matriz
    static void mostrar(int f,int c, String m[][]){
        
        for(int i=0; i<f; i++){
            for(int j=0; j<c; j++){
                System.out.print("  "+m[i][j]);
            }
            System.out.println();
        }  
    }

    public static void main(String[] args){
        Scanner e = new Scanner(System.in);

        String m[][], m1[][]; int f,c;
        System.out.println("INGRESE FILA "); f = e.nextInt();
        System.out.println("INGRESE COLUMNA "); c = e.nextInt();

        
        m = new String[f][c];
        m1 = new String[f][c];
        System.out.println("INGRESAR ELEMENTOS A LA MATRIZ");
        for(int i=0; i<f; i++){
            for(int j=0; j<c; j++){
                m[i][j] = e.nextLine(); // almacenando oraciones (cadenas con espacio)
            }
        }
        System.out.println("\n\n MATRIZ ORIGINAL");
        mostrar(f, c, m);
        
        for(int i=0; i<f; i++){
            for(int j=0; j<c; j++){
                m1[i][j] = separar(m[i][j]);
            }
        }
        System.out.println("MATRIZ CON RACTERES");
        mostrar(f, c, m1);
        e.close();

    } 
}
