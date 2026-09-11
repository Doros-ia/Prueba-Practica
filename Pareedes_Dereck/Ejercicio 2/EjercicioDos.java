/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.derisitos.ejerciciodos;

import java.util.Scanner;

/**
 *
 * @author Dereck
 */
public class EjercicioDos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double notaAnalisis, notaDiseno, notaCodificacion;
        double avance, promedio, ajuste, bonificacion, notaFinal;
        int errores;
        String documentacion, exposicion;
        String estado, observacion;

        System.out.print("Nota de analisis: ");
        notaAnalisis = entrada.nextDouble();

        System.out.print("Nota de diseno: ");
        notaDiseno = entrada.nextDouble();

        System.out.print("Nota de codificacion: ");
        notaCodificacion = entrada.nextDouble();

        System.out.print("Porcentaje de avance real: ");
        avance = entrada.nextDouble();

        System.out.print("Numero de errores detectados: ");
        errores = entrada.nextInt();

        entrada.nextLine();

        System.out.print("¿Presento documentacion completa? (Si/No): ");
        documentacion = entrada.nextLine();

        System.out.print("¿Realizo exposicion final? (Si/No): ");
        exposicion = entrada.nextLine();

        // Validar notas
        if (notaAnalisis < 0 || notaAnalisis > 10 ||
            notaDiseno < 0 || notaDiseno > 10 ||
            notaCodificacion < 0 || notaCodificacion > 10) {

            System.out.println("Error: las notas deben estar entre 0 y 10.");
        } else {

            promedio = (notaAnalisis + notaDiseno + notaCodificacion) / 3;

            ajuste = errores * 0.5;
            bonificacion = 0;

            if (documentacion.equalsIgnoreCase("Si")) {
                bonificacion += 0.5;
            }

            if (exposicion.equalsIgnoreCase("Si")) {
                bonificacion += 0.5;
            }

            notaFinal = promedio - ajuste + bonificacion;

            if (notaFinal > 10) {
                notaFinal = 10;
            }

            if (notaFinal < 0) {
                notaFinal = 0;
            }

            if (notaFinal >= 9) {
                estado = "Excelente";
            } else if (notaFinal >= 7) {
                estado = "Aprobado";
            } else if (notaFinal >= 5) {
                estado = "Recuperacion";
            } else {
                estado = "Reprobado";
            }

            // Menos de 60% de avance impide quedar en Excelente
            if (avance < 60 && estado.equals("Excelente")) {
                estado = "Aprobado";
            }

            if (notaFinal >= 7 &&
                documentacion.equalsIgnoreCase("No")) {
                observacion = "Buen producto, pero mala formalidad";
            } else {
                observacion = "Ninguna";
            }

            System.out.println("\n----- RESULTADOS -----");
            System.out.printf("Promedio tecnico: %.2f%n", promedio);
            System.out.printf("Ajustes aplicados: %.2f%n", ajuste);
            System.out.printf("Bonificaciones: %.2f%n", bonificacion);
            System.out.printf("Nota final: %.2f%n", notaFinal);
            System.out.println("Estado: " + estado);
            System.out.println("Observacion: " + observacion);
        }

        entrada.close();
    }
}
