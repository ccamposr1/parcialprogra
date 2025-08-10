import java.util.Scanner;
public class temperaturas {

    static Scanner scanner = new Scanner(System.in);
    static double[] temperaturas = new double[7];
    static boolean datosIngresados = false;

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarTemperaturas();
                    break;
                case 2:
                    if (datosIngresados) {
                        mostrarTodas();
                    } else {
                        System.out.println("Primero debes ingresar las temperaturas.");
                    }
                    break;
                case 3:
                    if (datosIngresados) {
                        double max = obtenerMaxima(temperaturas);
                        int diaIndex = obtenerIndiceMaxima(temperaturas);
                        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
                        mostrarMaxima(max);
                        mostrarMaxima(max, dias[diaIndex]);
                    } else {
                        System.out.println("Primero debes ingresar las temperaturas.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                case 5: // Extra: suma recursiva
                    if (datosIngresados) {
                        double suma = sumaRecursiva(temperaturas, 0);
                        System.out.println("🔢 Suma total de temperaturas: " + suma);
                    } else {
                        System.out.println("Primero debes ingresar las temperaturas.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);
    }

    // Menú principal
    public static void mostrarMenu() {
        System.out.println("\nMENÚ DE OPCIONES");
        System.out.println("1. Ingresar temperaturas");
        System.out.println("2. Mostrar todas las temperaturas");
        System.out.println("3. Mostrar temperatura máxima");
        System.out.println("4. Salir");
        System.out.println("5. (Extra) Sumar temperaturas con recursividad");
        System.out.print("Selecciona una opción: ");
    }

    // Opción 1: Ingreso de temperaturas
    public static void ingresarTemperaturas() {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (int i = 0; i < 7; i++) {
            System.out.print("Ingrese temperatura máxima para " + dias[i] + ": ");
            temperaturas[i] = scanner.nextDouble();
        }
        datosIngresados = true;
    }

    // Opción 2: Mostrar todas las temperaturas
    public static void mostrarTodas() {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        System.out.println("\n1 Temperaturas registradas:");
        for (int i = 0; i < 7; i++) {
            System.out.println(dias[i] + ": " + temperaturas[i] + "°C");
        }
    }

    // Opción 3: Obtener temperatura máxima
    public static double obtenerMaxima(double[] arreglo) {
        double max = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
        }
        return max;
    }

    // Obtener índice del día con temperatura máxima
    public static int obtenerIndiceMaxima(double[] arreglo) {
        int indice = 0;
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > arreglo[indice]) {
                indice = i;
            }
        }
        return indice;
    }

    // Método sobrecargado sin día
    public static void mostrarMaxima(double temperatura) {
        System.out.println("Temperatura máxima registrada: " + temperatura + "°C");
    }

    // Método sobrecargado con día
    public static void mostrarMaxima(double temperatura, String dia) {
        System.out.println(" Temperatura máxima registrada fue el " + dia + ": " + temperatura + "°C");
    }

    // Extra: función recursiva para sumar temperaturas
    public static double sumaRecursiva(double[] arreglo, int index) {
        if (index == arreglo.length) {
            return 0;
        }
        return arreglo[index] + sumaRecursiva(arreglo, index + 1);
    }
}
