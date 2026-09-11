#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>

using namespace std;

// Función auxiliar para comparar cadenas ignorando mayúsculas y minúsculas (equivalente a equalsIgnoreCase)
bool equalsIgnoreCase(const string& str1, const string& str2) {
    if (str1.length() != str2.length()) return false;
    for (size_t i = 0; i < str1.length(); ++i) {
        if (tolower(str1[i]) != tolower(str2[i])) return false;
    }
    return true;
}

int main() {
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

    // DECLARAR TODAS LAS VARIABLES AL INICIO
    // Variables de entrada
    double analisis, diseno, codificacion;
    double avanceReal;
    int errores;
    string documentacion;
    string exposicion;

    // Variables de proceso
    double promedioTecnico;
    double ajusteErrores;
    double ajusteDoc;
    double ajusteExposicion;
    double notaFinal;
    string estado;
    string observacion;

    cout << "\nSISTEMA DE EVALUACION DE PROYECTO\n" << endl;

    // validamos que la nota de analisis este entre 0 y 10
    // uso do-while para que vuelva a preguntar hasta que el dato sea correcto
    do {
        cout << "Ingrese la nota de analisis (0-10): ";
        cin >> analisis;
        if (analisis < 0 || analisis > 10) {
            cout << "Ingrese un valor correcto para la nota de analisis." << endl;
        }
    } while (analisis < 0 || analisis > 10);

    // validamos que la nota de diseno este entre 0 y 10
    do {
        cout << "Ingrese la nota de diseno (0-10): ";
        cin >> diseno;
        if (diseno < 0 || diseno > 10) {
            cout << "Ingrese un valor correcto para la nota de diseno." << endl;
        }
    } while (diseno < 0 || diseno > 10);

    // validamos que la nota de codificacion este entre 0 y 10
    do {
        cout << "Ingrese la nota de codificacion (0-10): ";
        cin >> codificacion;
        if (codificacion < 0 || codificacion > 10) {
            cout << "Ingrese un valor correcto para la nota de codificacion." << endl;
        }
    } while (codificacion < 0 || codificacion > 10);

    cout << "Ingrese el porcentaje de avance real: ";
    cin >> avanceReal;

    // validamos que el numero de errores no sea negativo
    do {
        cout << "Ingrese el numero de errores detectados (no negativo): ";
        cin >> errores;
        if (errores < 0) {
            cout << "Ingrese un valor correcto para los errores." << endl;
        }
    } while (errores < 0);

    // Limpiar el buffer de entrada antes de usar getline
    cin.ignore(1000, '\n');

    // validamos que la respuesta sea Si o No, usando equalsIgnoreCase
    do {
        cout << "¿Presento documentacion completa? (Si/No): ";
        getline(cin, documentacion);
        if (!(equalsIgnoreCase(documentacion, "Si") || equalsIgnoreCase(documentacion, "No"))) {
            cout << "Ingrese un valor correcto (Si/No)." << endl;
        }
    } while (!(equalsIgnoreCase(documentacion, "Si") || equalsIgnoreCase(documentacion, "No")));

    do {
        cout << "¿Realizo exposicion final? (Si/No): ";
        getline(cin, exposicion);
        if (!(equalsIgnoreCase(exposicion, "Si") || equalsIgnoreCase(exposicion, "No"))) {
            cout << "Ingrese un valor correcto (Si/No)." << endl;
        }
    } while (!(equalsIgnoreCase(exposicion, "Si") || equalsIgnoreCase(exposicion, "No")));

    // CALCULAR PROMEDIO TECNICO
    promedioTecnico = (analisis + diseno + codificacion) / 3.0;

    // CALCULAR AJUSTES
    ajusteErrores = errores * 0.5;

    ajusteDoc = 0;
    if (equalsIgnoreCase(documentacion, "Si")) {
        ajusteDoc = 0.5;
    }

    ajusteExposicion = 0;
    if (equalsIgnoreCase(exposicion, "Si")) {
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
    if (avanceReal < 60 && estado == "Excelente") {
        estado = "Aprobado";
    }

    // OBSERVACION POR BUENA NOTA SIN DOCUMENTACION
    if (notaFinal >= 7 && equalsIgnoreCase(documentacion, "No")) {
        observacion = "Buen producto, pero mala formalidad";
    } else {
        observacion = "Sin observaciones";
    }

    // MOSTRAR RESULTADO
    cout << "\n========== RESULTADO ==========" << endl;
    cout << "Nota de analisis: " << analisis << endl;
    cout << "Nota de diseno: " << diseno << endl;
    cout << "Nota de codificacion: " << codificacion << endl;
    cout << "Avance real: " << avanceReal << "%" << endl;
    cout << "Errores detectados: " << errores << endl;
    cout << "Documentacion completa: " << documentacion << endl;
    cout << "Exposicion final: " << exposicion << endl;
    cout << "---" << endl;
    cout << "Promedio tecnico: " << promedioTecnico << endl;
    cout << "Ajuste por errores: -" << ajusteErrores << endl;
    cout << "Ajuste por documentacion: +" << ajusteDoc << endl;
    cout << "Ajuste por exposicion: +" << ajusteExposicion << endl;
    cout << "Nota final: " << notaFinal << endl;
    cout << "Estado: " << estado << endl;
    cout << "Observacion: " << observacion << endl;
    cout << "================================" << endl;

    return 0;
}
