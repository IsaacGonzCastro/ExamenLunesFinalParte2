package examenfinalparte2;

import java.util.Scanner;

public class Principal {

    public static boolean esPrimo = false;

    public static void main(String arg[]) {
        int dig;
        int ndig;
        do {
            dig = introducirNumDigito();
            if (dig <= 0) {
                System.out.println("Ingrese como parámetro, un numero de digito correcto (mayor que 0): ");
            }
        } while (dig <= 0);
        for (int comparador = 1; comparador <= 99999; comparador++) {
            ndig = contarDivisiones(comparador);

            if (ndig == dig) {
                if (comparador < 4) {
                    esPrimo = true;
                } else if (comparador % 2 == 0) {
                    esPrimo = false;
                } else {
                    int countDivisores = 0;
                    int i = 1;
                    int limite = (comparador - 1) / 2;
                    if (limite % 2 == 0) {
                        limite--;
                    }

                    esPrimo = calcularDivisores(i, limite, comparador, countDivisores);
                }

                if (esPrimo == true) {
                    System.out.println(comparador);
                }
            }
        }
    }

    private static boolean calcularDivisores(int i, int limite, int comparador, int countDivisores) {
        boolean esPrimo = false;
        while (i <= limite) {
            if (comparador % i == 0) {
                countDivisores++;
            }
            i += 2;
            if (countDivisores == 2) {
                i = limite + 1;
            }
        }

        if (countDivisores == 1) {
            esPrimo = true;
        }

        return esPrimo;
    }

    private static int contarDivisiones(int comparador) {
        int aux = comparador;
        int contador = 0;
        while (aux != 0) {
            aux = aux / 10;
            contador++;
        }
        return contador;
    }

    public static int introducirNumDigito() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un dígito:");
        return teclado.nextInt();
    }
}
