package PRIMER_PARCIAL;
import java.util.Scanner;

public class P2multde3_5 {

    static void mostrar(int n, int c, int m[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("  " + m[i][j]);
            }
            System.out.println();
        }
    }
    // funcion par hacer el producto
    static int producto(int d){
        int producto = 1;
        while (d!=0) {
            int u = d % 10; 
            if(u!=0){
                producto = producto * u;
            }
            d/=10; 
        }

      return producto;
     }

     // funcion para invertir un numero
    static int invertirNumero(int num) {
        int invertido = 0;
        while (num != 0) {
            int digito = num % 10;
            invertido = invertido * 10 + digito;
            num /= 10;
        }
        return invertido;
    }

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        int m[][], m2[][];
        int n, c;
        System.out.println("INGRESE LA DIM DE LA MATRIZ: ");
        System.out.print("Filas: ");
        n = e.nextInt();
        System.out.print("Columnas: ");
        c = e.nextInt();
        m = new int[n][c];
        m2 = new int[n][c];
        System.out.println("INGRESE LOS ELEMENTOS");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = e.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                
                // si el numero es multiplo de 3
                if ((m[i][j] % 3) == 0) {
                    m2[i][j] = invertirNumero(m[i][j]);
                } 
                
                // si el numero es multiplo de 5
                else if ((m[i][j] % 5) == 0) {
                    m2[i][j] = producto(m[i][j]);
                } 
                
                else {
                    m2[i][j] = m[i][j];
                }
            }
        }

        System.out.println("MATRIZ ORIGINAL:");
        mostrar(n, c, m);

        System.out.println("MATRIZ MODIFICADA:");
        mostrar(n, c, m2);

        e.close();
    }
}
