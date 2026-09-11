package PruebaEjercicio1;

import java.util.Scanner;
public class CompetenciaAcademica {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double reto1, reto2, reto3, tiempo;
        double puntajeBase, penalizacion, bonificacion, puntajeFinal;
        int errores, desafioExtra, descalificado;
        String nivel, observacion;
        // Se validan puntajes no negativos porque no se indicó un máximo.
        do {
            System.out.print("Puntaje del reto 1: ");
            reto1 = entrada.nextDouble();
            if (reto1 < 0) System.out.println("El puntaje no puede ser negativo.");
        } while (reto1 < 0);
        do {
            System.out.print("Puntaje del reto 2: ");
            reto2 = entrada.nextDouble();
            if (reto2 < 0) System.out.println("El puntaje no puede ser negativo.");
        } while (reto2 < 0);
        do {
            System.out.print("Puntaje del reto 3: ");
            reto3 = entrada.nextDouble();
            if (reto3 < 0) System.out.println("El puntaje no puede ser negativo.");
        } while (reto3 < 0);
        do {
            System.out.print("Número de errores: ");
            errores = entrada.nextInt();
            if (errores < 0) System.out.println("Los errores no pueden ser negativos.");
        } while (errores < 0);
        do {
            System.out.print("Tiempo total en minutos: ");
            tiempo = entrada.nextDouble();
            if (tiempo < 0) System.out.println("El tiempo no puede ser negativo.");
        } while (tiempo < 0);
        do {
            System.out.print("¿Resolvió el desafío extra? (1 Sí, 0 No): ");
            desafioExtra = entrada.nextInt();
            if (desafioExtra != 0 && desafioExtra != 1)
                System.out.println("Respuesta inválida.");
        } while (desafioExtra != 0 && desafioExtra != 1);
        do {
            System.out.print("¿Fue descalificado por copia? (1 Sí, 0 No): ");
            descalificado = entrada.nextInt();
            if (descalificado != 0 && descalificado != 1)
                System.out.println("Respuesta inválida.");
        } while (descalificado != 0 && descalificado != 1);
        puntajeBase = reto1 + reto2 + reto3;
        penalizacion = errores * 4;
        bonificacion = 0;
        if (desafioExtra == 1) bonificacion += 15;
        if (tiempo < 30) bonificacion += 10;
        puntajeFinal = puntajeBase - penalizacion + bonificacion;
        if (puntajeFinal < 0) puntajeFinal = 0;
        if (puntajeFinal < 30) nivel = "Principiante";
        else if (puntajeFinal < 50) nivel = "Básico";
        else if (puntajeFinal < 70) nivel = "Intermedio";
        else if (puntajeFinal < 90) nivel = "Avanzado";
        else nivel = "Experto";
        if (descalificado == 1) nivel = "Descalificado";
        if (puntajeFinal >= 70 && errores >= 5)
            observacion = "Resultado inconsistente: revisar calidad de resolución";
        else
            observacion = "Sin observaciones";
        System.out.println("\n--- RESULTADOS ---");
        System.out.printf("Puntaje base: %.2f%n", puntajeBase);
        System.out.printf("Penalización: %.2f%n", penalizacion);
        System.out.printf("Bonificación: %.2f%n", bonificacion);
        System.out.printf("Puntaje final: %.2f%n", puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observación: " + observacion);
        entrada.close();
    }
}

