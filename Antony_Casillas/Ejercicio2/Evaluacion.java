import java.util.Scanner;

public class Evaluacion {
    /*
    ANÁLISIS DEL SISTEMA DE EVALUACIÓN DE PROYECTO
    Se desea evaluar el resultado de un proyecto desarrollado por un estudiante,
    considerando rendimiento técnico, formalidad y restricciones del caso.

    Se solicita:
    - Nota de análisis, diseño y codificación (cada una validada entre 0 y 10)
    - Porcentaje de avance real
    - Número de errores detectados
    - Si presentó documentación completa (Si/No)
    - Si realizó exposición final (Si/No)

    Lo que hace es calcular:
    - Promedio técnico de las tres notas
    - Ajustes: -0.5 por cada error, +0.5 por documentación, +0.5 por exposición
    - Nota final (ajustada entre 0 y 10)
    - Estado según el rango de la nota final
    - Si el avance real es menor al 60%, no puede quedar en Excelente
    - Observación si tiene buena nota pero no presentó documentación
    */
    public static void main(String[] args) {
        // DECLARAR TODAS LAS VARIABLES AL INICIO
        // Variables de entrada
        double analisis, diseno, codificacion;
        double avanceReal;
        int errores;
        String documentacion;
        String exposicion;

        // Variables de proceso
        double promedioTecnico;
        double ajusteErrores;
        double ajusteDoc;
        double ajusteExposicion;
        double notaFinal;
        String estado;
        String observacion;

        // creamos el scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSISTEMA DE EVALUACION DE PROYECTO\n");

        // validamos que la nota de analisis este entre 0 y 10
        // uso do-while para que vuelva a preguntar hasta que el dato sea correcto
        do {
            System.out.print("Ingrese la nota de analisis (0-10): ");
            analisis = scanner.nextDouble();
            if (analisis < 0 || analisis > 10) {
                System.out.println("Ingrese un valor correcto para la nota de analisis.");
            }
        } while (analisis < 0 || analisis > 10);

        // validamos que la nota de diseno este entre 0 y 10
        do {
            System.out.print("Ingrese la nota de diseno (0-10): ");
            diseno = scanner.nextDouble();
            if (diseno < 0 || diseno > 10) {
                System.out.println("Ingrese un valor correcto para la nota de diseno.");
            }
        } while (diseno < 0 || diseno > 10);

        // validamos que la nota de codificacion este entre 0 y 10
        do {
            System.out.print("Ingrese la nota de codificacion (0-10): ");
            codificacion = scanner.nextDouble();
            if (codificacion < 0 || codificacion > 10) {
                System.out.println("Ingrese un valor correcto para la nota de codificacion.");
            }
        } while (codificacion < 0 || codificacion > 10);

        System.out.print("Ingrese el porcentaje de avance real: ");
        avanceReal = scanner.nextDouble();

        // validamos que el numero de errores no sea negativo
        do {
            System.out.print("Ingrese el numero de errores detectados (no negativo): ");
            errores = scanner.nextInt();
            if (errores < 0) {
                System.out.println("Ingrese un valor correcto para los errores.");
            }
        } while (errores < 0);

        scanner.nextLine(); // limpiar el buffer antes de leer texto

        // validamos que la respuesta sea Si o No, usando equalsIgnoreCase
        // para que no importe si el usuario escribe mayusculas o minusculas
        do {
            System.out.print("¿Presento documentacion completa? (Si/No): ");
            documentacion = scanner.nextLine();
            if (!(documentacion.equalsIgnoreCase("Si") || documentacion.equalsIgnoreCase("No"))) {
                System.out.println("Ingrese un valor correcto (Si/No).");
            }
        } while (!(documentacion.equalsIgnoreCase("Si") || documentacion.equalsIgnoreCase("No")));

        do {
            System.out.print("¿Realizo exposicion final? (Si/No): ");
            exposicion = scanner.nextLine();
            if (!(exposicion.equalsIgnoreCase("Si") || exposicion.equalsIgnoreCase("No"))) {
                System.out.println("Ingrese un valor correcto (Si/No).");
            }
        } while (!(exposicion.equalsIgnoreCase("Si") || exposicion.equalsIgnoreCase("No")));

        // CALCULAR PROMEDIO TECNICO
        promedioTecnico = (analisis + diseno + codificacion) / 3;

        // CALCULAR AJUSTES
        ajusteErrores = errores * 0.5;

        ajusteDoc = 0;
        if (documentacion.equalsIgnoreCase("Si")) {
            ajusteDoc = 0.5;
        }

        ajusteExposicion = 0;
        if (exposicion.equalsIgnoreCase("Si")) {
            ajusteExposicion = 0.5;
        }

        // CALCULAR NOTA FINAL
        notaFinal = promedioTecnico - ajusteErrores + ajusteDoc + ajusteExposicion;

        // AJUSTAR SI SE PASA DE 10 O ES MENOR QUE 0
        if (notaFinal > 10) {
            notaFinal = 10;
        }
        if (notaFinal < 0) {
            notaFinal = 0;
        }

        // ASIGNAR ESTADO SEGUN EL RANGO DE LA NOTA FINAL
        if (notaFinal >= 9) {
            estado = "Excelente";
        } else if (notaFinal >= 7) {
            estado = "Aprobado";
        } else if (notaFinal >= 5) {
            estado = "Recuperacion";
        } else {
            estado = "Reprobado";
        }

        // SI EL AVANCE REAL ES MENOR AL 60%, NO PUEDE QUEDAR EN EXCELENTE
        if (avanceReal < 60 && estado.equals("Excelente")) {
            estado = "Aprobado";
        }

        // OBSERVACION POR BUENA NOTA SIN DOCUMENTACION
        if (notaFinal >= 7 && documentacion.equalsIgnoreCase("No")) {
            observacion = "Buen producto, pero mala formalidad";
        } else {
            observacion = "Sin observaciones";
        }

        // MOSTRAR RESULTADO
        System.out.println("\n========== RESULTADO ==========");
        System.out.println("Nota de analisis: " + analisis);
        System.out.println("Nota de diseno: " + diseno);
        System.out.println("Nota de codificacion: " + codificacion);
        System.out.println("Avance real: " + avanceReal + "%");
        System.out.println("Errores detectados: " + errores);
        System.out.println("Documentacion completa: " + documentacion);
        System.out.println("Exposicion final: " + exposicion);
        System.out.println("---");
        System.out.println("Promedio tecnico: " + promedioTecnico);
        System.out.println("Ajuste por errores: -" + ajusteErrores);
        System.out.println("Ajuste por documentacion: +" + ajusteDoc);
        System.out.println("Ajuste por exposicion: +" + ajusteExposicion);
        System.out.println("Nota final: " + notaFinal);
        System.out.println("Estado: " + estado);
        System.out.println("Observacion: " + observacion);
        System.out.println("================================");

        scanner.close();
    }
}