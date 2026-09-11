/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.derisitos.ejerciciouno;

import java.util.Scanner;

/**
 *
 * @author Dereck
 */
public class EjercicioUno {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Datos de entrada
        double puntaje1, puntaje2, puntaje3;
        int errores, tiempo;
        String extra, copia;

        // Variables para los cálculos
        double base;
        double penalizacion;
        double bonificacion;
        double puntajeFinal;

        String nivel;
        String observacion;

        // Solicitar datos
        System.out.print("Ingrese el puntaje del reto 1: ");
        puntaje1 = entrada.nextDouble();

        System.out.print("Ingrese el puntaje del reto 2: ");
        puntaje2 = entrada.nextDouble();

        System.out.print("Ingrese el puntaje del reto 3: ");
        puntaje3 = entrada.nextDouble();

        System.out.print("Ingrese el número de errores: ");
        errores = entrada.nextInt();

        System.out.print("Ingrese el tiempo total en minutos: ");
        tiempo = entrada.nextInt();

        entrada.nextLine();

        System.out.print("¿Resolvió el desafío extra? (Si/No): ");
        extra = entrada.nextLine();

        System.out.print("¿Fue descalificado por copia? (Si/No): ");
        copia = entrada.nextLine();

        // 1. Calcular puntaje base
        base = puntaje1 + puntaje2 + puntaje3;

        // 2. Calcular penalización
        penalizacion = errores * 4;

        // Restar la penalización
        base = base - penalizacion;

        // 3. Inicializar bonificación
        bonificacion = 0;

        // 4. Bonificación por desafío extra
        if (extra.equalsIgnoreCase("Si")) {
            bonificacion = bonificacion + 15;
        }

        // 5. Bonificación por tiempo menor a 30 minutos
        if (tiempo < 30) {
            bonificacion = bonificacion + 10;
        }

        // 6. Calcular puntaje final
        puntajeFinal = base + bonificacion;

        // 7. Si el puntaje final es menor que 0, se convierte en 0
        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        // 8. Determinar el nivel
        if (copia.equalsIgnoreCase("Si")) {
            nivel = "Descalificado";
        } else if (puntajeFinal >= 90) {
            nivel = "Experto";
        } else if (puntajeFinal >= 70) {
            nivel = "Avanzado";
        } else if (puntajeFinal >= 50) {
            nivel = "Intermedio";
        } else if (puntajeFinal >= 30) {
            nivel = "Básico";
        } else {
            nivel = "Principiante";
        }

        // 9. Determinar la observación
        if (puntajeFinal >= 70 && errores > 5) {
            observacion = "Resultado inconsistente: revisar calidad de resolución";
        } else {
            observacion = "Ninguna";
        }

        // Mostrar resultados
        System.out.println("\n----- RESULTADOS -----");
        System.out.println("Puntaje base: " + base);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observación: " + observacion);

        entrada.close();
    }
}
