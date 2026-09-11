import java.util.Scanner;

public class CompetenciaAcademica {
    /*
    ANÁLISIS DEL SISTEMA DE COMPETENCIA ACADÉMICA
    En una competencia académica se califican tres retos y se determina
    el nivel del participante según su desempeño, penalizaciones y bonificaciones.

    Se solicita:
    - Puntaje de los tres retos
    - Número de errores
    - Tiempo total en minutos
    - Si resolvió el desafío extra (Si/No)
    - Si fue descalificado por copia (Si/No)

    Lo que hace es calcular:
    - Puntaje base (suma de los tres retos)
    - Penalización (4 puntos por cada error)
    - Bonificación (15 puntos por desafío extra, 10 puntos si tiempo < 30 min)
    - Puntaje final (ajustado a 0 si es negativo)
    - Nivel según rango de puntaje, o "Descalificado" si copió
    - Observación si el puntaje es alto pero hay demasiados errores
    */
    public static void main(String[] args) {
        // DECLARAR TODAS LAS VARIABLES AL INICIO
        // Variables de entrada
        int reto1, reto2, reto3;
        int errores;
        int tiempo;
        String desafioExtra;
        String descalificado;

        // Variables de proceso
        int puntajeBase;
        int penalizacion;
        int bonificacion;
        int puntajeFinal;
        String nivel;
        String observacion;

        // creamos el scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSISTEMA DE COMPETENCIA ACADEMICA\n");

        // pedimos los puntajes de los tres retos
        System.out.print("Ingrese el puntaje del reto 1: ");
        reto1 = scanner.nextInt();

        System.out.print("Ingrese el puntaje del reto 2: ");
        reto2 = scanner.nextInt();

        System.out.print("Ingrese el puntaje del reto 3: ");
        reto3 = scanner.nextInt();

        // validamos que el numero de errores no sea negativo
        // uso do-while para que vuelva a preguntar hasta que el dato sea correcto
        do {
            System.out.print("Ingrese el numero de errores (no negativo): ");
            errores = scanner.nextInt();
            if (errores < 0) {
                System.out.println("Ingrese un valor correcto para los errores.");
            }
        } while (errores < 0);

        // validamos que el tiempo sea mayor a 0
        do {
            System.out.print("Ingrese el tiempo total en minutos (mayor a 0): ");
            tiempo = scanner.nextInt();
            if (tiempo <= 0) {
                System.out.println("Ingrese un valor correcto para el tiempo.");
            }
        } while (tiempo <= 0);

        scanner.nextLine(); // limpiar el buffer antes de leer texto

        // validamos que la respuesta sea Si o No, usando equalsIgnoreCase
        // para que no importe si el usuario escribe mayusculas o minusculas
        do {
            System.out.print("¿Resolvio el desafio extra? (Si/No): ");
            desafioExtra = scanner.nextLine();
            if (!(desafioExtra.equalsIgnoreCase("Si") || desafioExtra.equalsIgnoreCase("No"))) {
                System.out.println("Ingrese un valor correcto (Si/No).");
            }
        } while (!(desafioExtra.equalsIgnoreCase("Si") || desafioExtra.equalsIgnoreCase("No")));

        do {
            System.out.print("¿Fue descalificado por copia? (Si/No): ");
            descalificado = scanner.nextLine();
            if (!(descalificado.equalsIgnoreCase("Si") || descalificado.equalsIgnoreCase("No"))) {
                System.out.println("Ingrese un valor correcto (Si/No).");
            }
        } while (!(descalificado.equalsIgnoreCase("Si") || descalificado.equalsIgnoreCase("No")));

        // CALCULAR PUNTAJE BASE
        puntajeBase = reto1 + reto2 + reto3;

        // CALCULAR PENALIZACION
        penalizacion = errores * 4;

        // CALCULAR BONIFICACION
        bonificacion = 0;
        if (desafioExtra.equalsIgnoreCase("Si")) {
            bonificacion = bonificacion + 15;
        }
        if (tiempo < 30) {
            bonificacion = bonificacion + 10;
        }

        // CALCULAR PUNTAJE FINAL
        puntajeFinal = puntajeBase - penalizacion + bonificacion;

        // AJUSTAR SI ES NEGATIVO
        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        // ASIGNAR NIVEL SEGUN EL RANGO
        if (puntajeFinal >= 90) {
            nivel = "Experto";
        } else if (puntajeFinal >= 70) {
            nivel = "Avanzado";
        } else if (puntajeFinal >= 50) {
            nivel = "Intermedio";
        } else if (puntajeFinal >= 30) {
            nivel = "Basico";
        } else {
            nivel = "Principiante";
        }

        // SI FUE DESCALIFICADO, EL NIVEL CAMBIA SIN IMPORTAR EL PUNTAJE
        if (descalificado.equalsIgnoreCase("Si")) {
            nivel = "Descalificado";
        }

        // VERIFICAR SI HAY RESULTADO INCONSISTENTE
        if (puntajeFinal >= 70 && errores >= 5) {
            observacion = "Resultado inconsistente: revisar calidad de resolucion";
        } else {
            observacion = "Sin observaciones";
        }

        // MOSTRAR RESULTADO
        System.out.println("\n========== RESULTADO ==========");
        System.out.println("Reto 1: " + reto1);
        System.out.println("Reto 2: " + reto2);
        System.out.println("Reto 3: " + reto3);
        System.out.println("Errores: " + errores);
        System.out.println("Tiempo: " + tiempo + " minutos");
        System.out.println("Desafio extra: " + desafioExtra);
        System.out.println("Descalificado: " + descalificado);
        System.out.println("---");
        System.out.println("Puntaje base: " + puntajeBase);
        System.out.println("Penalizacion: " + penalizacion);
        System.out.println("Bonificacion: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observacion: " + observacion);
        System.out.println("================================");

        scanner.close();
    }
}