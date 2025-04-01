import java.util.Arrays;

public class MetodoBurbuja {

    public int[] ordenarAsdBurbuja(int[] arreglo, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int contCambios = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean cambio = false;

            for (int j = 0; j < n - 1 - i; j++) {
                contComparaciones++;
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    cambio = true;
                    contCambios++;

                    if (conPasos) {
                        imprimirPaso(arreglo, contComparaciones, arreglo[j], arreglo[j + 1], true);
                    }
                } else if (conPasos) {
                    imprimirPaso(arreglo, contComparaciones, arreglo[j], arreglo[j + 1], false);
                }
            }

            if (!cambio) break;
        }

        return new int[]{contComparaciones, contCambios};
    }

    public int[] ordenarDesBurbuja(int[] arreglo, boolean conPasos) {
        int n = arreglo.length;
        int contComparaciones = 0;
        int contCambios = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean cambio = false;

            for (int j = 0; j < n - 1 - i; j++) {
                contComparaciones++;
                if (arreglo[j] < arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    cambio = true;
                    contCambios++;

                    if (conPasos) {
                        imprimirPaso(arreglo, contComparaciones, arreglo[j], arreglo[j + 1], true);
                    }
                } else if (conPasos) {
                    imprimirPaso(arreglo, contComparaciones, arreglo[j], arreglo[j + 1], false);
                }
            }

            if (!cambio) break;
        }

        return new int[]{contComparaciones, contCambios};
    }

    public void imprimirArreglo(int[] arreglo) {
        System.out.println(Arrays.toString(arreglo));
    }

    private void imprimirPaso(int[] arreglo, int comparacion, int valor1, int valor2, boolean intercambio) {
        System.out.println("-".repeat(100));
        System.out.println("Comparación " + comparacion + ": " + valor1 + (intercambio ? " <-> " : " <= ") + valor2);
        if (intercambio) {
            System.out.println("Intercambio realizado.");
        } else {
            System.out.println("No hay intercambio.");
        }
        System.out.println("Estado Actual: " + Arrays.toString(arreglo));
        System.out.println("-".repeat(100));
    }
}