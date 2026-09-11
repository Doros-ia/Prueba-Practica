import java.util.Scanner;

public class EJERCICIO2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double notaAnalisis = 0;
        double notaDiseno = 0;
        double notaCodificacion = 0;
        double promedioTecnico;
        double notaFinal;
        double avance;
        int errores;

        String documentacion;
        String exposicion;
        String estado;
        String observacion = "Ninguna";

        // 1. Leer y validar las tres notas
        for (int i = 1; i <= 3; i++) {

            double nota;

            do {
                System.out.print("Ingrese la nota " + i + " (0-10): ");
                nota = sc.nextDouble();

                if (nota < 0 || nota > 10) {
                    System.out.println("Nota inválida. Debe estar entre 0 y 10.");
                }

            } while (nota < 0 || nota > 10);

            switch (i) {
                case 1 -> notaAnalisis = nota;
                case 2 -> notaDiseno = nota;
                default -> notaCodificacion = nota;
            }
        }

        // 2. Calcular promedio técnico
        promedioTecnico =
                (notaAnalisis + notaDiseno + notaCodificacion) / 3;

        // 3. Leer datos adicionales
        System.out.print("Ingrese el porcentaje de avance real: ");
        avance = sc.nextDouble();

        System.out.print("Ingrese el número de errores detectados: ");
        errores = sc.nextInt();

        System.out.print("¿Presentó documentación completa? (S/N): ");
        documentacion = sc.next();

        System.out.print("¿Realizó exposición final? (S/N): ");
        exposicion = sc.next();

        // 4. Calcular nota final
        notaFinal = promedioTecnico;

        // Penalización por errores
        notaFinal = notaFinal - (errores * 0.5);

        // Bonificación por documentación
        if (documentacion.equalsIgnoreCase("S")) {
            notaFinal = notaFinal + 0.5;
        }

        // Bonificación por exposición
        if (exposicion.equalsIgnoreCase("S")) {
            notaFinal = notaFinal + 0.5;
        }

        // 5. Validar nota final
        if (notaFinal > 10) {
            notaFinal = 10;
        }

        if (notaFinal < 0) {
            notaFinal = 0;
        }

        // 6. Asignar estado
        if (notaFinal >= 9 && notaFinal <= 10) {
            estado = "Excelente";

        } else if (notaFinal >= 7 && notaFinal < 9) {
            estado = "Aprobado";

        } else if (notaFinal >= 5 && notaFinal < 7) {
            estado = "Recuperación";

        } else {
            estado = "Reprobado";
        }

        // 7. Restricción por porcentaje de avance
        if (avance < 60 && estado.equals("Excelente")) {
            estado = "Aprobado";
        }

        // 8. Observación
        if (notaFinal >= 7 && notaFinal <= 10
                && documentacion.equalsIgnoreCase("N")) {

            observacion = "Buen producto, pero mala formalidad";
        }

        // 9. Mostrar resultados
        System.out.println("\n========== RESULTADOS ==========");

        System.out.printf("Promedio técnico: %.2f%n", promedioTecnico);

        System.out.println("Ajustes aplicados:");
        System.out.printf("Penalización por errores: -%.2f%n",
                errores * 0.5);

        if (documentacion.equalsIgnoreCase("S")) {
            System.out.println("Bonificación por documentación: +0.50");
        } else {
            System.out.println("Bonificación por documentación: +0.00");
        }

        if (exposicion.equalsIgnoreCase("S")) {
            System.out.println("Bonificación por exposición: +0.50");
        } else {
            System.out.println("Bonificación por exposición: +0.00");
        }

        System.out.printf("Nota final: %.2f%n", notaFinal);
        System.out.println("Estado: " + estado);
        System.out.println("Observación: " + observacion);

        System.out.println("================================");

        sc.close();
    }
}