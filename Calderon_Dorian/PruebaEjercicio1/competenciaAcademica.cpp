#include <iostream>
#include <iomanip>
#include <string>
using namespace std;
int main() {
    double reto1, reto2, reto3, tiempo;
    double puntajeBase, penalizacion, bonificacion, puntajeFinal;
    int errores, desafioExtra, descalificado;
    string nivel, observacion;
    // Se validan puntajes no negativos porque no se indicó un máximo.
    do {
        cout << "Puntaje del reto 1: "; cin >> reto1;
        if (reto1 < 0) cout << "El puntaje no puede ser negativo.\n";
    } while (reto1 < 0);
    do {
        cout << "Puntaje del reto 2: "; cin >> reto2;
        if (reto2 < 0) cout << "El puntaje no puede ser negativo.\n";
    } while (reto2 < 0);
    do {
        cout << "Puntaje del reto 3: "; cin >> reto3;
        if (reto3 < 0) cout << "El puntaje no puede ser negativo.\n";
    } while (reto3 < 0);
    do {
        cout << "Numero de errores: "; cin >> errores;
        if (errores < 0) cout << "Los errores no pueden ser negativos.\n";
    } while (errores < 0);
    do {
        cout << "Tiempo total en minutos: "; cin >> tiempo;
        if (tiempo < 0) cout << "El tiempo no puede ser negativo.\n";
    } while (tiempo < 0);
    do {
        cout << "¿Resolvio el desafio extra? (1 Si, 0 No): "; cin >> desafioExtra;
        if (desafioExtra != 0 && desafioExtra != 1) cout << "Respuesta invalida.\n";
    } while (desafioExtra != 0 && desafioExtra != 1);
    do {
        cout << "¿Fue descalificado por copia? (1 Si, 0 No): "; cin >> descalificado;
        if (descalificado != 0 && descalificado != 1) cout << "Respuesta invalida.\n";
    } while (descalificado != 0 && descalificado != 1);
    puntajeBase = reto1 + reto2 + reto3;
    penalizacion = errores * 4;
    bonificacion = 0;
    if (desafioExtra == 1) bonificacion += 15;
    if (tiempo < 30) bonificacion += 10;
    puntajeFinal = puntajeBase - penalizacion + bonificacion;
    if (puntajeFinal < 0) puntajeFinal = 0;
    if (puntajeFinal < 30) nivel = "Principiante";
    else if (puntajeFinal < 50) nivel = "Basico";
    else if (puntajeFinal < 70) nivel = "Intermedio";
    else if (puntajeFinal < 90) nivel = "Avanzado";
    else nivel = "Experto";
    if (descalificado == 1) nivel = "Descalificado";
    if (puntajeFinal >= 70 && errores >= 5)
        observacion = "Resultado inconsistente: revisar calidad de resolucion";
    else
        observacion = "Sin observaciones";
    cout << fixed << setprecision(2);
    cout << "\n--- RESULTADOS ---\n";
    cout << "Puntaje base: " << puntajeBase << '\n';
    cout << "Penalizacion: " << penalizacion << '\n';
    cout << "Bonificacion: " << bonificacion << '\n';
    cout << "Puntaje final: " << puntajeFinal << '\n';
    cout << "Nivel: " << nivel << '\n';
    cout << "Observacion: " << observacion << '\n';
    return 0;
}
