package PRIMER_PARCIAL;
import java.util.Scanner;

class P1DecimalBinario {
    // Método para convertir un número decimal a binario
    static String convertir(int n) {
        if (n == 0) {
            return "0";
        }
        
        StringBuilder r = new StringBuilder();
        while (n > 0) {
            r.append(n % 2); //r.append(): Añade este bit al final de StringBuilder.
            n = n / 2;
        }
        
        return r.reverse().toString(); //r.reverse(): Invierte el contenido de StringBuilder
        // porque los bits se han añadido en orden inverso 
    }

    // Método para mostrar una matriz de enteros
    static void mostrar(int f, int c, int m[][]) {
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para mostrar una matriz de cadenas
    static void mostrar(int f, int c, String m[][]) {
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        int m[][]; 
        String m1[][];
        int f, c;

        System.out.println("INGRESE FILA: ");
        f = e.nextInt();
        System.out.println("INGRESE COLUMNA: ");
        c = e.nextInt();

        m = new int[f][c]; 
        m1 = new String[f][c];

        System.out.println("INGRESE LOS ELEMENTOS DE LA MATRIZ:");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = e.nextInt();
            }
        }

        System.out.println("\n\nMATRIZ ORIGINAL:");
        mostrar(f, c, m);

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                m1[i][j] = convertir(m[i][j]);
            }
        }

        System.out.println("MATRIZ EN BINARIO:");
        mostrar(f, c, m1);
        e.close();
    }
}

