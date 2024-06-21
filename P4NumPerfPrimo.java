import java.util.Scanner;

public class P4NumPerfPrimo {

    static int primo(int num) {
        int cont = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                cont++;
            }
        }

        if (cont == 2) {
            return 1; // Es primo
        } else {
            return 0; // No es primo
        }
    }

    static int perfecto(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num ? 1 : 0; // Devuelve 1 si es perfecto, 0 si no lo es
    }

    static void mostrarVector(int[] vector, int l) {
        System.out.println("\nElementos del vector:");
        for (int i = 0; i < l; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        int n;
        System.out.print("Ingrese la dimensión del vector: ");
        n = e.nextInt();
        int v[], v2[];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el elemento " + (i + 1) + " del vector: ");
            v[i] = e.nextInt();
        }

        mostrarVector(v, n);

        int cont2 = 0;
        v2 = new int[n]; 

        for (int i = 0; i < n; i++) {
            if (primo(v[i]) == 1 || perfecto(v[i]) == 1) {
                v2[cont2] = v[i];
                cont2++;
            }
        }

        mostrarVector(v2, cont2);

        e.close();
    }
}
