import java.util.Scanner;

public class    Prueba_Practica_competencia_retos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entradas
        int reto1, reto2, reto3, errores, tiempo;
        boolean extra, copia, docCompleta, expFinal;
        double avance;

        System.out.print("Ingrese puntaje reto 1 (0-10): ");
        reto1 = sc.nextInt();
        System.out.print("Ingrese puntaje reto 2 (0-10): ");
        reto2 = sc.nextInt();
        System.out.print("Ingrese puntaje reto 3 (0-10): ");
        reto3 = sc.nextInt();
        System.out.print("Ingrese número de errores: ");
        errores = sc.nextInt();
        System.out.print("Ingrese tiempo total en minutos: ");
        tiempo = sc.nextInt();
        System.out.print("¿Resolvió desafío extra? (true/false): ");
        extra = sc.nextBoolean();
        System.out.print("¿Descalificado por copia? (true/false): ");
        copia = sc.nextBoolean();
        System.out.print("¿Presentó documentación completa? (true/false): ");
        docCompleta = sc.nextBoolean();
        System.out.print("¿Realizó exposición final? (true/false): ");
        expFinal = sc.nextBoolean();
        System.out.print("Ingrese avance real (%): ");
        avance = sc.nextDouble();

        // --- Proceso requerido ---
        int puntajeBase = reto1 + reto2 + reto3;
        int penalizacion = errores * 4;
        int bonificacion = (extra ? 15 : 0) + (tiempo < 30 ? 10 : 0);

        int puntajeFinal = puntajeBase - penalizacion + bonificacion;
        if (puntajeFinal < 0) puntajeFinal = 0;

        String nivel;
        String observacion = "";

        if (copia) {
            nivel = "Descalificado";
        } else if (puntajeFinal <= 29) {
            nivel = "Principiante";
        } else if (puntajeFinal <= 49) {
            nivel = "Básico";
        } else if (puntajeFinal <= 69) {
            nivel = "Intermedio";
        } else if (puntajeFinal <= 89) {
            nivel = "Avanzado";
        } else {
            nivel = "Experto";
        }

        if (puntajeFinal >= 70 && errores > 10) {
            observacion = "Resultado inconsistente: revisar calidad de resolución";
        }

        // --- Evaluación académica complementaria ---
        double promedio = (reto1 + reto2 + reto3) / 3.0 - (errores * 0.5);
        if (docCompleta) promedio += 0.5;
        if (expFinal) promedio += 0.5;

        if (promedio > 10) promedio = 10;
        if (promedio < 0) promedio = 0;

        String estado;
        if (promedio >= 9) {
            estado = "Excelente";
        } else if (promedio >= 7) {
            estado = "Aprobado";
        } else if (promedio >= 5) {
            estado = "Recuperación";
        } else {
            estado = "Reprobado";
        }

        if (avance < 60 && estado.equals("Excelente")) {
            estado = "Aprobado (restricción por avance)";
        }

        if (promedio >= 7 && !docCompleta) {
            observacion = "Buen producto, pero mala formalidad";
        }

        // --- Salidas ---
        System.out.println("\n--- Resultados Competencia ---");
        System.out.println("Puntaje base: " + puntajeBase);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);

        System.out.println("\n--- Evaluación Académica ---");
        System.out.println("Promedio técnico: " + promedio);
        System.out.println("Estado final: " + estado);

        if (!observacion.isEmpty()) {
            System.out.println("Observación: " + observacion);
        }

        sc.close();
    }
}
