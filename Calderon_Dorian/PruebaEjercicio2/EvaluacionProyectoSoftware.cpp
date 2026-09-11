#include <iostream>
#include <iomanip>
#include <string>
using namespace std;
int main() {
    double notaAnalisis, notaDiseno, notaCodificacion, avance;
    double promedioTecnico, penalizacion, bonificacion, ajusteNeto, notaFinal;
    int errores, documentacion, exposicion;
    string estado, observacion;
    do {
        cout << "Nota de analisis (0 a 10): "; cin >> notaAnalisis;
        if (notaAnalisis < 0 || notaAnalisis > 10) cout << "Nota invalida.\n";
    } while (notaAnalisis < 0 || notaAnalisis > 10);
    do {
        cout << "Nota de diseno (0 a 10): "; cin >> notaDiseno;
        if (notaDiseno < 0 || notaDiseno > 10) cout << "Nota invalida.\n";
    } while (notaDiseno < 0 || notaDiseno > 10);
    do {
        cout << "Nota de codificacion (0 a 10): "; cin >> notaCodificacion;
        if (notaCodificacion < 0 || notaCodificacion > 10) cout << "Nota invalida.\n";
    } while (notaCodificacion < 0 || notaCodificacion > 10);
    do {
        cout << "Porcentaje de avance real (0 a 100): "; cin >> avance;
        if (avance < 0 || avance > 100) cout << "Porcentaje invalido.\n";
    } while (avance < 0 || avance > 100);
    do {
        cout << "Numero de errores detectados: "; cin >> errores;
        if (errores < 0) cout << "Los errores no pueden ser negativos.\n";
    } while (errores < 0);
    do {
        cout << "¿Documentacion completa? (1 Si, 0 No): "; cin >> documentacion;
        if (documentacion != 0 && documentacion != 1) cout << "Respuesta invalida.\n";
    } while (documentacion != 0 && documentacion != 1);
    do {
        cout << "¿Realizo exposicion final? (1 Si, 0 No): "; cin >> exposicion;
        if (exposicion != 0 && exposicion != 1) cout << "Respuesta invalida.\n";
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
    else if (notaFinal >= 5) estado = "Recuperacion";
    else estado = "Reprobado";
    if (avance < 60 && estado == "Excelente") estado = "Aprobado";
    if (notaFinal >= 7 && documentacion == 0)
        observacion = "Buen producto, pero mala formalidad";
    else
        observacion = "Sin observaciones";
    cout << fixed << setprecision(2);
    cout << "\n--- RESULTADOS DEL PROYECTO ---\n";
    cout << "Promedio tecnico: " << promedioTecnico << '\n';
    cout << "Penalizacion por errores: -" << penalizacion << '\n';
    cout << "Bonificaciones: +" << bonificacion << '\n';
    cout << "Ajuste neto: " << ajusteNeto << '\n';
    cout << "Nota final: " << notaFinal << '\n';
    cout << "Estado: " << estado << '\n';
    cout << "Observacion: " << observacion << '\n';
    return 0;
}
