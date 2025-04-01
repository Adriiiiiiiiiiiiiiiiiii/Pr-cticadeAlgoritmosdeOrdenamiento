import java.util.Arrays;

public class MetodoInsercion {

    public int[] ordenarAsd(int[] arreglo, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int contCambios = 0;

        for (int i = 1; i < n; i++) {
            int aux = arreglo[i];
            int j = i - 1;

            if (conPasos) {
                System.out.println("i: " + i + ", aux: " + aux);
            }

            while (j >= 0 && arreglo[j] > aux) {
                contComparaciones++;
                arreglo[j + 1] = arreglo[j];
                j--;

                if (conPasos) {
                    System.out.println("-".repeat(100));
                    System.out.println("Comparación " + contComparaciones + ": " + arreglo[j + 1] + " > " + aux);
                    System.out.println("Estado Actual: " + Arrays.toString(arreglo));
                    System.out.println("-".repeat(100));
                }
            }

            arreglo[j + 1] = aux;
            contCambios++;

            if (conPasos) {
                System.out.println("Inserción: " + aux + " en posición " + (j + 1));
                System.out.println("Estado Actual: " + Arrays.toString(arreglo));
                System.out.println("-".repeat(100));
            }
        }

        return new int[]{contComparaciones, contCambios};
    }

    public int[] ordenarDes(int[] arreglo, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int contCambios = 0;

        for (int i = 1; i < n; i++) {
            int aux = arreglo[i];
            int j = i - 1;

            if (conPasos) {
                System.out.println("i: " + i + ", aux: " + aux);
            }

            while (j >= 0 && arreglo[j] < aux) {
                contComparaciones++;
                arreglo[j + 1] = arreglo[j];
                j--;

                if (conPasos) {
                    System.out.println("-".repeat(100));
                    System.out.println("Comparación " + contComparaciones + ": " + arreglo[j + 1] + " < " + aux);
                    System.out.println("Estado Actual: " + Arrays.toString(arreglo));
                    System.out.println("-".repeat(100));
                }
            }

            arreglo[j + 1] = aux;
            contCambios++;

            if (conPasos) {
                System.out.println("Inserción: " + aux + " en posición " + (j + 1));
                System.out.println("Estado Actual: " + Arrays.toString(arreglo));
                System.out.println("-".repeat(100));
            }
        }

        return new int[]{contComparaciones, contCambios};
    }

    public void imprimirArreglo(int[] arreglo) {
        System.out.println(Arrays.toString(arreglo));
    }
}