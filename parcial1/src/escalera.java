import java.util.Scanner;

public class escalera{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de niveles: ");
        int niveles = scanner.nextInt();

        if (niveles < 1) {
            System.out.println("Error: El número debe ser mayor o igual a 1.");
            return;
        }

        System.out.println("Escalera ascendente:");
        imprimirAscendente(niveles);

        System.out.println("Escalera descendente:");
        imprimirDescendenteRecursivo(niveles - 1); // Extra: recursividad
    }

    // Procedimiento: Escalera ascendente
    public static void imprimirAscendente(int niveles) {
        for (int i = 1; i <= niveles; i++) {
            imprimirLinea(i);
        }
    }

    // Procedimiento: Escalera descendente (recursiva)
    public static void imprimirDescendenteRecursivo(int nivel) {
        if (nivel < 1) return;
        imprimirLinea(nivel);
        imprimirDescendenteRecursivo(nivel - 1);
    }

    // Método sobrecargado: imprime línea con números
    public static void imprimirLinea(int nivel) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Método sobrecargado: imprime línea con símbolo
    public static void imprimirLinea(int nivel, char simbolo) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(simbolo + " ");
        }
        System.out.println();
    }
}
