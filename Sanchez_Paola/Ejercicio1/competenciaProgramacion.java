import java.util.Scanner;

public class competenciaProgramacion {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

        double reto1, reto2, reto3;
        int errores;
        double tiempo;
        String desafioExtra, copia;

        double puntajeBase;
        double penalizacion;
        double bonificacion = 0;
        double puntajeFinal;

        String nivel;
        String observacion = "Ninguna";

        // ENTRADAS
        System.out.print("Ingrese el puntaje del reto 1: ");
        reto1 = sc.nextDouble();

        System.out.print("Ingrese el puntaje del reto 2: ");
        reto2 = sc.nextDouble();

        System.out.print("Ingrese el puntaje del reto 3: ");
        reto3 = sc.nextDouble();

        System.out.print("Ingrese el numero de errores: ");
        errores = sc.nextInt();

        System.out.print("Ingrese el tiempo total en minutos: ");
        tiempo = sc.nextDouble();

        System.out.print("¿Resolvio el desafio extra? (Si/No): ");
        desafioExtra = sc.next();

        System.out.print("¿Fue descalificado por copia? (Si/No): ");
        copia = sc.next();

        // PROCESOS

        // Puntaje base
        puntajeBase = reto1 + reto2 + reto3;

        // Penalizacion
        penalizacion = errores * 4;

        // Bonificacion por desafio extra
        if (desafioExtra.equalsIgnoreCase("Si")) {
            bonificacion = bonificacion + 15;
        }

        // Bonificacion por tiempo
        if (tiempo < 30) {
            bonificacion = bonificacion + 10;
        }

        // Puntaje final
        puntajeFinal = puntajeBase - penalizacion + bonificacion;

        // El puntaje final no puede ser menor que 0
        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        // Determinar nivel
        if (puntajeFinal <= 29) {
            nivel = "Principiante";
        } else if (puntajeFinal <= 49) {
            nivel = "Basico";
        } else if (puntajeFinal <= 69) {
            nivel = "Intermedio";
        } else if (puntajeFinal <= 89) {
            nivel = "Avanzado";
        } else {
            nivel = "Experto";
        }

        // Descalificacion por copia
        if (copia.equalsIgnoreCase("Si")) {
            nivel = "Descalificado";
        }

        // SALIDAS
        System.out.println("\n----- RESULTADOS -----");
        System.out.println("Puntaje base: " + puntajeBase);
        System.out.println("Penalizacion: " + penalizacion);
        System.out.println("Bonificacion: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observacion: " + observacion);

        }
    }
} 
 
    

