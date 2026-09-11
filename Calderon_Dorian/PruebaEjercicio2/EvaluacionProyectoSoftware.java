package PruebaEjercicio2;

import java.util.Scanner;
public class EvaluacionProyectoSoftware {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double notaAnalisis, notaDiseno, notaCodificacion, avance;
        double promedioTecnico, penalizacion, bonificacion, ajusteNeto, notaFinal;
        int errores, documentacion, exposicion;
        String estado, observacion;
        do {
            System.out.print("Nota de análisis (0 a 10): ");
            notaAnalisis = entrada.nextDouble();
            if (notaAnalisis < 0 || notaAnalisis > 10) System.out.println("Nota inválida.");
        } while (notaAnalisis < 0 || notaAnalisis > 10);
        do {
            System.out.print("Nota de diseño (0 a 10): ");
            notaDiseno = entrada.nextDouble();
            if (notaDiseno < 0 || notaDiseno > 10) System.out.println("Nota inválida.");
        } while (notaDiseno < 0 || notaDiseno > 10);
        do {
            System.out.print("Nota de codificación (0 a 10): ");
            notaCodificacion = entrada.nextDouble();
            if (notaCodificacion < 0 || notaCodificacion > 10) System.out.println("Nota inválida.");
        } while (notaCodificacion < 0 || notaCodificacion > 10);
        do {
            System.out.print("Porcentaje de avance real (0 a 100): ");
            avance = entrada.nextDouble();
            if (avance < 0 || avance > 100) System.out.println("Porcentaje inválido.");
        } while (avance < 0 || avance > 100);
        do {
            System.out.print("Número de errores detectados: ");
            errores = entrada.nextInt();
            if (errores < 0) System.out.println("Los errores no pueden ser negativos.");
        } while (errores < 0);
        do {
            System.out.print("¿Documentación completa? (1 Sí, 0 No): ");
            documentacion = entrada.nextInt();
            if (documentacion != 0 && documentacion != 1) System.out.println("Respuesta inválida.");
        } while (documentacion != 0 && documentacion != 1);
        do {
            System.out.print("¿Realizó exposición final? (1 Sí, 0 No): ");
            exposicion = entrada.nextInt();
            if (exposicion != 0 && exposicion != 1) System.out.println("Respuesta inválida.");
        } while (exposicion != 0 && exposicion != 1);
        promedioTecnico = (notaAnalisis + notaDiseno + notaCodificacion) / 3;
        penalizacion = errores * 0.5;
        bonificacion = 0;
        if (documentacion == 1) bonificacion += 0.5;
        if (exposicion == 1) bonificacion += 0.5;
        ajusteNeto = bonificacion - penalizacion;
        notaFinal = promedioTecnico + ajusteNeto;
        if (notaFinal > 10) notaFinal = 10;
        if (notaFinal < 0) notaFinal = 0;
        if (notaFinal >= 9) estado = "Excelente";
        else if (notaFinal >= 7) estado = "Aprobado";
        else if (notaFinal >= 5) estado = "Recuperación";
        else estado = "Reprobado";
        if (avance < 60 && estado.equals("Excelente")) estado = "Aprobado";
        if (notaFinal >= 7 && documentacion == 0)
            observacion = "Buen producto, pero mala formalidad";
        else
            observacion = "Sin observaciones";
        System.out.println("\n--- RESULTADOS DEL PROYECTO ---");
        System.out.printf("Promedio técnico: %.2f%n", promedioTecnico);
        System.out.printf("Penalización por errores: -%.2f%n", penalizacion);
        System.out.printf("Bonificaciones: +%.2f%n", bonificacion);
        System.out.printf("Ajuste neto: %+.2f%n", ajusteNeto);
        System.out.printf("Nota final: %.2f%n", notaFinal);
        System.out.println("Estado: " + estado);
        System.out.println("Observación: " + observacion);
        entrada.close();
    }
}
