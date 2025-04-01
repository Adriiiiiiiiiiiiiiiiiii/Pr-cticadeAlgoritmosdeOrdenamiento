import java.util.Arrays;

public class MetodoSeleccion {

    public void ordenar(int[] arreglo, boolean isDes, boolean conPasos) {
        if (isDes) {
            ordenarDesSeleccion(arreglo, conPasos);
        } else {
            ordenarAsdSeleccion(arreglo, conPasos);
        }
    }

    public int[] ordenarDesSeleccion(int[] arreglo, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int cambios = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;

            for (int j = i + 1; j < n; j++) {
                contComparaciones++;
                if (arreglo[maxIdx] < arreglo[j]) {
                    maxIdx = j;
                }
            }

            if (maxIdx != i) {
                int aux = arreglo[maxIdx];
                arreglo[maxIdx] = arreglo[i];
                arreglo[i] = aux;
                cambios++;
            }

            if (conPasos) {
                System.out.println("-".repeat(100));
                System.out.println("Estado Actual: " + Arrays.toString(arreglo));
                System.out.println("-".repeat(100));
            }
        }

        return new int[]{contComparaciones, cambios};
    }

    public int[] ordenarAsdSeleccion(int[] arreglo, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int cambios = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                contComparaciones++;
                if (arreglo[minIdx] > arreglo[j]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int aux = arreglo[minIdx];
                arreglo[minIdx] = arreglo[i];
                arreglo[i] = aux;
                cambios++;
            }

            if (conPasos) {
                System.out.println("-".repeat(100));
                System.out.println("Estado Actual: " + Arrays.toString(arreglo));
                System.out.println("-".repeat(100));
            }
        }

        return new int[]{contComparaciones, cambios};
    }

    public void imprimirArreglo(int[] arreglo) {
        System.out.println(Arrays.toString(arreglo));
    }
}