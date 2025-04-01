
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[] datos = {12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3, 27, -30, 14, 7, -1, 41, 20, -11, 8};

        MetodoBurbuja burbuja = new MetodoBurbuja();
        MetodoSeleccion seleccion = new MetodoSeleccion();
        MetodoInsercion insercion = new MetodoInsercion();
        MetodoBurbujaMejorado burbujaMejorada = new MetodoBurbujaMejorado();

        Scanner input = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            System.out.println("\n===== MENÚ DE ORDENAMIENTO =====");
            System.out.println("1. Burbuja");
            System.out.println("2. Selección");
            System.out.println("3. Inserción");
            System.out.println("4. Burbuja Mejorada");
            System.out.println("5. Salir");

            int opcion = obtenerNumero(input, "Seleccione una opción (1-5)");

            if (opcion == 5) {
                System.out.println("¡Hasta luego!");
                seguir = false;
                break;
            } else if (opcion < 1 || opcion > 5) {
                System.out.println("Opción inválida, intente de nuevo.");
                continue;
            }

            int[] arreglo = datos.clone(); // Copiar arreglo original

            boolean mostrarPasos = obtenerBooleano(input, "¿Mostrar los pasos? (true/false, t/f): ");
            boolean ascendente = obtenerOrden(input, "Orden Ascendente (A) o Descendente (D): ");

            int[] resultados = new int[2];

            switch (opcion) {
                case 1:
                    imprimirTitulo("Método Burbuja");
                    burbuja.imprimirArreglo(arreglo);
                    resultados = ascendente ? burbuja.ordenarAsdBurbuja(arreglo, mostrarPasos)
                            : burbuja.ordenarDesBurbuja(arreglo, mostrarPasos);
                    burbuja.imprimirArreglo(arreglo);
                    break;

                case 2:
                    imprimirTitulo("Método Selección");
                    seleccion.imprimirArreglo(arreglo);
                    resultados = ascendente ? seleccion.ordenarAsdSeleccion(arreglo, mostrarPasos)
                            : seleccion.ordenarDesSeleccion(arreglo, mostrarPasos);
                    seleccion.imprimirArreglo(arreglo);
                    break;

                case 3:
                    imprimirTitulo("Método Inserción");
                    insercion.imprimirArreglo(arreglo);
                    resultados = ascendente ? insercion.ordenarAsd(arreglo, mostrarPasos)
                            : insercion.ordenarDes(arreglo, mostrarPasos);
                    insercion.imprimirArreglo(arreglo);
                    break;

                case 4:
                    imprimirTitulo("Método Burbuja Mejorado");
                    burbujaMejorada.imprimirArreglo(arreglo);
                    resultados = ascendente ? burbujaMejorada.ordenarAsdBurbuja(arreglo, mostrarPasos)
                            : burbujaMejorada.ordenarDescendente(arreglo, mostrarPasos);
                    burbujaMejorada.imprimirArreglo(arreglo);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println(" Comparaciones: " + resultados[0]);
            System.out.println(" Cambios realizados: " + resultados[1]);
        }

        input.close();
    }

    public static int obtenerNumero(Scanner scanner, String mensaje) {
        int num;
        do {
            System.out.print(mensaje + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println(" Entrada inválida. Ingrese un número.");
                System.out.print(mensaje + ": ");
                scanner.next();
            }
            num = scanner.nextInt();
            if (num <= 0) {
                System.out.println(" Ingrese un número válido.");
            }
        } while (num <= 0);
        return num;
    }

    public static boolean obtenerBooleano(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.next().toLowerCase();
            if (entrada.equals("true") || entrada.equals("t") || entrada.equals("1") || entrada.equals("si") || entrada.equals("s")) {
                return true;
            } else if (entrada.equals("false") || entrada.equals("f") || entrada.equals("0") || entrada.equals("no") || entrada.equals("n")) {
                return false;
            } else {
                System.out.println("⚠ Entrada inválida. Ingrese true/false o t/f.");
            }
        }
    }

    public static boolean obtenerOrden(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.next().toLowerCase();
            if (entrada.equals("a") || entrada.equals("asc") || entrada.equals("ascendente")) {
                return true;
            } else if (entrada.equals("d") || entrada.equals("desc") || entrada.equals("descendente")) {
                return false;
            } else {
                System.out.println("⚠ Entrada inválida. Ingrese A (ascendente) o D (descendente).");
            }
        }
    }

    public static void imprimirTitulo(String titulo) {
        System.out.println("\n" + "-".repeat(20) + " " + titulo + " " + "-".repeat(20));
    }
}
