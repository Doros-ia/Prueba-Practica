#include <iostream>
#include <string>
using namespace std;

/*
ANÁLISIS DEL SISTEMA DE COMPETENCIA ACADÉMICA - VERSIÓN C++
En una competencia académica se califican tres retos y se determina
el nivel del participante según su desempeño, penalizaciones y bonificaciones.

Lo que hace es calcular:
- Puntaje base (suma de los tres retos)
- Penalización (4 puntos por cada error)
- Bonificación (15 puntos por desafío extra, 10 puntos si tiempo < 30 min)
- Puntaje final (ajustado a 0 si es negativo)
- Nivel según rango de puntaje, o "Descalificado" si copió
- Observación si el puntaje es alto pero hay demasiados errores
*/

// función auxiliar: como C++ no tiene equalsIgnoreCase como Java,
// convertimos el texto a minúsculas para poder compararlo sin importar
// si el usuario escribió con mayúsculas o minúsculas
string aMinusculas(string texto) {
    for (size_t i = 0; i < texto.length(); i++) {
        texto[i] = tolower(texto[i]);
    }
    return texto;
}

int main() {
    // DECLARAR TODAS LAS VARIABLES AL INICIO
    // Variables de entrada
    int reto1, reto2, reto3;
    int errores;
    int tiempo;
    string desafioExtra;
    string descalificado;

    // Variables de proceso
    int puntajeBase;
    int penalizacion;
    int bonificacion;
    int puntajeFinal;
    string nivel;
    string observacion;

    cout << "\nSISTEMA DE COMPETENCIA ACADEMICA\n" << endl;

    cout << "Ingrese el puntaje del reto 1: ";
    cin >> reto1;

    cout << "Ingrese el puntaje del reto 2: ";
    cin >> reto2;

    cout << "Ingrese el puntaje del reto 3: ";
    cin >> reto3;

    // validamos que el numero de errores no sea negativo
    do {
        cout << "Ingrese el numero de errores (no negativo): ";
        cin >> errores;
        if (errores < 0) {
            cout << "Ingrese un valor correcto para los errores." << endl;
        }
    } while (errores < 0);

    // validamos que el tiempo sea mayor a 0
    do {
        cout << "Ingrese el tiempo total en minutos (mayor a 0): ";
        cin >> tiempo;
        if (tiempo <= 0) {
            cout << "Ingrese un valor correcto para el tiempo." << endl;
        }
    } while (tiempo <= 0);

    cin.ignore(); // limpiar el buffer antes de leer texto

    // validamos que la respuesta sea Si o No, usando aMinusculas()
    do {
        cout << "¿Resolvio el desafio extra? (Si/No): ";
        getline(cin, desafioExtra);
        if (!(aMinusculas(desafioExtra) == "si" || aMinusculas(desafioExtra) == "no")) {
            cout << "Ingrese un valor correcto (Si/No)." << endl;
        }
    } while (!(aMinusculas(desafioExtra) == "si" || aMinusculas(desafioExtra) == "no"));

    do {
        cout << "¿Fue descalificado por copia? (Si/No): ";
        getline(cin, descalificado);
        if (!(aMinusculas(descalificado) == "si" || aMinusculas(descalificado) == "no")) {
            cout << "Ingrese un valor correcto (Si/No)." << endl;
        }
    } while (!(aMinusculas(descalificado) == "si" || aMinusculas(descalificado) == "no"));

    // CALCULAR PUNTAJE BASE
    puntajeBase = reto1 + reto2 + reto3;

    // CALCULAR PENALIZACION
    penalizacion = errores * 4;

    // CALCULAR BONIFICACION
    bonificacion = 0;
    if (aMinusculas(desafioExtra) == "si") {
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
    if (aMinusculas(descalificado) == "si") {
        nivel = "Descalificado";
    }

    // VERIFICAR SI HAY RESULTADO INCONSISTENTE
    if (puntajeFinal >= 70 && errores >= 5) {
        observacion = "Resultado inconsistente: revisar calidad de resolucion";
    } else {
        observacion = "Sin observaciones";
    }

    // MOSTRAR RESULTADO
    cout << "\n========== RESULTADO ==========" << endl;
    cout << "Reto 1: " << reto1 << endl;
    cout << "Reto 2: " << reto2 << endl;
    cout << "Reto 3: " << reto3 << endl;
    cout << "Errores: " << errores << endl;
    cout << "Tiempo: " << tiempo << " minutos" << endl;
    cout << "Desafio extra: " << desafioExtra << endl;
    cout << "Descalificado: " << descalificado << endl;
    cout << "---" << endl;
    cout << "Puntaje base: " << puntajeBase << endl;
    cout << "Penalizacion: " << penalizacion << endl;
    cout << "Bonificacion: " << bonificacion << endl;
    cout << "Puntaje final: " << puntajeFinal << endl;
    cout << "Nivel: " << nivel << endl;
    cout << "Observacion: " << observacion << endl;
    cout << "================================" << endl;

    return 0;
}
