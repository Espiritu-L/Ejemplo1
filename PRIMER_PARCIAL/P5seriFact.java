package PRIMER_PARCIAL;
import java.util.Scanner;

public class P5seriFact {
    // para factorial
    static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la dimension del vector: ");
        int n = scanner.nextInt();

        int v[], v2[];
        v = new int[n];
        v2 = new int[n];
        int k =1;
        for (int i = 0; i < n; i++) {
            v[i] = factorial(k);
            k = k +2;
        }

        // serie 1
        int ss = 1;
        for(int i=0; i<n; i++){
            ss = ss +(3*i);
            v2[i] = ss;

        }
        System.out.println("SERIE UNO");
        for (int num : v2) {
            System.out.print(num + " ");
        }
        System.out.println("\nSerie Dos:");
        for (int num : v) {
            System.out.print(num + " ");
        }
       
        scanner.close();
    }
}
