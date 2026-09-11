import java.util.Scanner;

public class EvaluacionProyectoSoftware {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double notaAnalisis, notaDiseno, notaCodificacion;
        double avance;
        int errores;

        String documentacion, exposicion;

        double promedioTecnico;
        double penalizacion;
        double bonificacion = 0;
        double ajustes;
        double notaFinal;

        String estado;
        String observacion = "Ninguna";

        // ENTRADAS
        System.out.print("Ingrese la nota de analisis: ");
        notaAnalisis = sc.nextDouble();

        System.out.print("Ingrese la nota de diseno: ");
        notaDiseno = sc.nextDouble();

        System.out.print("Ingrese la nota de codificacion: ");
        notaCodificacion = sc.nextDouble();

        System.out.print("Ingrese el porcentaje de avance real: ");
        avance = sc.nextDouble();

        System.out.print("Ingrese el numero de errores detectados: ");
        errores = sc.nextInt();

        System.out.print("¿Presento documentacion completa? (Si/No): ");
        documentacion = sc.next();

        System.out.print("¿Realizo la exposicion final? (Si/No): ");
        exposicion = sc.next();

        // VALIDACION DE NOTAS
        if (notaAnalisis < 0 || notaAnalisis > 10 ||
            notaDiseno < 0 || notaDiseno > 10 ||
            notaCodificacion < 0 || notaCodificacion > 10) {

            System.out.println("Error: las notas deben estar entre 0 y 10.");

        } else if (avance < 0 || avance > 100) {

            System.out.println("Error: el porcentaje de avance debe estar entre 0 y 100.");

        } else if (errores < 0) {

            System.out.println("Error: el numero de errores no puede ser negativo.");

        } else {

            // PROMEDIO TECNICO
            promedioTecnico = (notaAnalisis + notaDiseno + notaCodificacion) / 3;

            // PENALIZACION
            penalizacion = errores * 0.5;

            // BONIFICACIONES
            if (documentacion.equalsIgnoreCase("Si")) {
                bonificacion = bonificacion + 0.5;
            }

            if (exposicion.equalsIgnoreCase("Si")) {
                bonificacion = bonificacion + 0.5;
            }

            // NOTA FINAL
            notaFinal = promedioTecnico - penalizacion + bonificacion;

            // LIMITES DE LA NOTA
            if (notaFinal > 10) {
                notaFinal = 10;
            }

            if (notaFinal < 0) {
                notaFinal = 0;
            }

            // AJUSTES APLICADOS
            ajustes = bonificacion - penalizacion;

            // ASIGNAR ESTADO
            if (notaFinal >= 9) {
                estado = "Excelente";
            } else if (notaFinal >= 7) {
                estado = "Aprobado";
            } else if (notaFinal >= 5) {
                estado = "Recuperacion";
            } else {
                estado = "Reprobado";
            }

            // RESTRICCION DEL AVANCE
            if (avance < 60 && estado.equals("Excelente")) {
                estado = "Aprobado";
            }

            // OBSERVACION
            if (notaFinal >= 7 && documentacion.equalsIgnoreCase("No")) {
                observacion = "Buen producto, pero mala formalidad";
            }

            // SALIDAS
            System.out.println("\n========== RESULTADOS ==========");
            System.out.println("Promedio tecnico: " + promedioTecnico);
            System.out.println("Ajustes aplicados: " + ajustes);
            System.out.println("Nota final: " + notaFinal);
            System.out.println("Estado: " + estado);
            System.out.println("Observacion: " + observacion);
            System.out.println("================================");

        }

        sc.close();
    }
}
