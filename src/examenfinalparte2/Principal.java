package examenfinalparte2;

import java.util.Scanner;

/**
 * Introducimos un numero entero y el programa evalua si es primo o no.
 *
 * @author igonzalezcastro
 */
public class Principal {

    /**
     * variable que devuelve true si el numero es primo y false si el numero no
     * lo es.
     */
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

    /**
     * Este metodo calcula el numero de divisores.
     *
     * @param i es el divisor.
     * @param limite es el limite de divisores.
     * @param comparador es el numero del que se van a contar los divisores.
     * @param countDivisores es el contador de los divisores
     * @return devuelve el comparador si es primo o no.
     */
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

    /**
     * Este metodo cuenta las divisiones que se pueden con el numero que recibe
     * por parametros.
     *
     * @param comparador es el numero del que se van a contar los divisores.
     * @return devuelve el numero de divisiones que se pueden hacer.
     */
    private static int contarDivisiones(int comparador) {
        int aux = comparador;
        int contador = 0;
        while (aux != 0) {
            aux = aux / 10;
            contador++;
        }
        return contador;
    }

    /**
     * Introduce el numero entero por teclado.
     *
     * @return devuelve el numero que se introdujo por teclado.
     */
    public static int introducirNumDigito() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un dígito:");
        return teclado.nextInt();
    }
}
