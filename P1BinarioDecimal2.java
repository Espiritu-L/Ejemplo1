import java.util.Scanner;
class P1BinarioDecimal {
   // para covertir
    static int convertir(int n){
        int s = 0;
        int ex = 0; 
        while (n != 0) {
            int u = n % 10; 
            if (u != 1 && u != 0) {
                return 0; // 
            }
            s += u * Math.pow(2, ex); 
            ex++; 
            n /= 10; 
        }
        return s; 
    }


    // para mostrar la matriz
    static void mostrar(int f,int c, int m[][]){
        
        for(int i=0; i<f; i++){
            for(int j=0; j<c; j++){
                System.out.print("  "+m[i][j]);
            }
            System.out.println();
        }  
    }

    public static void main(String[] args){
        Scanner e = new Scanner(System.in);

        int m[][], m1[][], f,c;
        System.out.println("INGRESE FILA "); f = e.nextInt();
        System.out.println("INGRESE COLUMNA "); c = e.nextInt();

        
        m = new int[f][c];
        m1 = new int[f][c];
        System.out.println("INGRESAR ELEMENTOS A LA MATRIZ");
        for(int i=0; i<f; i++){
            for(int j=0; j<c; j++){
                m[i][j] = e.nextInt();
            }
        }
        System.out.println("\n\n MATRIZ ORIGINAL");
        mostrar(f, c, m);
        
        for(int i=0; i<f; i++){
            for(int j=0; j<c; j++){
                m1[i][j] = convertir(m[i][j]);
            }
        }
        System.out.println("MATRIZ EN DECIMAL");
        mostrar(f, c, m1);
        e.close();

    }
}
