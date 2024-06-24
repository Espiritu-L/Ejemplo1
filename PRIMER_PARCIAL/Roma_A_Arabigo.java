package PRIMER_PARCIAL;

import java.util.Scanner;

public class Roma_A_Arabigo {

    /* cad = DCCIX -> 709 = 500 + 100 + 100 - 1 + 50 = 709
        D -> 500
        C -> 100
        C -> 100
        I -> 1
        X -> 50
        
        SI CHAR ACTUAL ES MAYOR O IGUAL AL CHAR(+1) SU SUMA, CASO CONTRARIO SE RESTA
     * 
     */

    public static int valor(char cad){
        int val = 0;
        switch (cad) {
            case 'M':
                val  = 1000;
                break;
            case 'D':
                val  = 500;
                break;
            case 'C':
                val  = 100;
                break;
            case 'L':
                val  = 50;
                break;
            case 'X':
                val  = 10;
                break;
            case 'V':
                val  = 5;
                break;
            case 'I':
                val = 1;
                break;

        }

        return val;

    }

    public static int romArabigo (String cad){
        int n = 0;
        for(int i=0; i<cad.length()-1; i++){

            if(valor(cad.charAt(i)) >= valor(cad.charAt(i+1))){
                n += valor(cad.charAt(i));
            }else{
                n -= valor(cad.charAt(i));
            }
            

        }
        n+= valor(cad.charAt(cad.length()-1));
        return n;
    }
    public static void main(String args[]){
        Scanner e = new Scanner(System.in);
        int n, m;
        System.out.println("INGRESE EL TAMANIO DE LA FILA: ");
        n = e.nextInt();
        System.out.println("INGRESE EL TAMANIO DE COLUMNA: ");
        m = e.nextInt();

        e.nextLine(); // leer una linia mas, para pasar a leer String

        String ma[][] = new String[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print("POS ["+i+"]["+j+"]: ");
                ma[i][j] = e.nextLine();
            }
        }
        System.out.println("LA MATRIZ ES");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.printf("%7s", ma[i][j]);
            }System.out.println();
        }
        int vec[] = new int[n];
        for(int i = 0; i<n; i++){
            vec[i] = romArabigo(ma[i][i]);
        }
        System.out.println("\nEL VECTOR RESULTANTE ES");
        for(int i = 0; i<n; i++){
            System.out.print(vec[i]+" ");
        }
        e.close();
    }   
}
