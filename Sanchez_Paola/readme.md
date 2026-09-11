<div align="center">
  <h1>Práctica de Lógica de Programación</h1>
  <p><strong>Estudiante:</strong> Karina Sanchez</p>
  <p><strong>Carrera:</strong> Ingeniería en Software</p>
  <p><strong>Curso:</strong> 1er Semestre "B"</p>
  <p><strong>Fecha:</strong> 11 de Septiembre, 2026</p>
</div>

---

## 📂 Estructura del Repositorio

El proyecto sigue la organización mínima sugerida para la entrega de las actividades:

*   **`ejercicio-1/`** - Carpeta del primer programa.
    *   `Ejercicio1.java` - Código fuente en Java.
*   **`ejercicio-2/`** - Carpeta del segundo programa.
    *   `Ejercicio2.java` - Código fuente en Java.
*   **`evidencia-manual/`** - Fotos o archivos PDF con el análisis, algoritmo y pruebas de escritorio.
*   **`capturas-ejecucion/`** - Imágenes que demuestran la compilación y ejecución correcta.

---

## 📝 Descripción de los Ejercicios

<details>
<summary><strong>🚀 Ejercicio 1: Competencia de programación por niveles</strong> (Clic para expandir)</summary>
<br>

Programa que califica el desempeño de un participante en una competencia académica evaluando tres retos, errores cometidos y tiempos de entrega.

*   **Datos de Entrada:**
    *   Puntajes de retos (1, 2 y 3).
    *   Número de errores cometidos.
    *   Tiempo total (minutos).
    *   Desafío extra (Sí/No) y Descalificación por copia (Sí/No).
*   **Proceso:**
    *   Suma de puntajes de los tres retos.
    *   Penalización de 4 puntos por cada error cometido.
    *   Bonificación de 15 puntos por desafío extra y 10 puntos por terminar en menos de 30 minutos.
    *   Determinación del nivel (Principiante, Básico, Intermedio, Avanzado, Experto o Descalificado).
*   **Datos de Salida:** Puntaje base, penalización, bonificación, puntaje final, nivel y observaciones.
</details>

<details>
<summary><strong>📊 Ejercicio 2: Calificación de Proyecto</strong> (Clic para expandir)</summary>
<br>

Programa que evalúa el resultado del desarrollo de un proyecto técnico basándose en notas por fases, porcentaje de avance real y entrega de evidencias formales.

*   **Datos de Entrada:**
    *   Notas de Análisis, Diseño y Codificación (Valores entre 0 y 10).
    *   Porcentaje de avance real.
    *   Número de errores detectados.
    *   Documentación completa (Sí/No) y Exposición final (Sí/No).
*   **Proceso:**
    *   Cálculo del promedio técnico.
    *   Resta de 0.5 puntos por cada error detectado.
    *   Suma de 0.5 puntos por documentación completa y 0.5 puntos por exposición final.
    *   Asignación de Estado (Excelente, Aprobado, Recuperación, Reprobado). *Nota: Si el avance es menor al 60%, no puede ser Excelente.*
*   **Datos de Salida:** Promedio técnico, ajustes aplicados, nota final, estado y observaciones.
</details>

---

## 🛠️ Instrucciones para Compilar y Ejecutar

Para correr estos programas en tu computadora, asegúrate de tener instalado el **Java Development Kit (JDK)** versión 11 o superior.

### 1. Clonar el repositorio
```bash
git clone https://github.com
cd prueba-practica-logica-Karing-Sanchez
```

### 2. Ejercicio 1 (Competencia de programación)
*   **Compilar:**
    ```bash
    javac ejercicio-1/Ejercicio1.java
    ```
*   **Ejecutar:**
    ```bash
    java ejercicio-1.Ejercicio1
    ```

### 3. Ejercicio 2 (Calificación de Proyecto)
*   **Compilar:**
    ```bash
    javac ejercicio-2/Ejercicio2.java
    ```
*   **Ejecutar:**
    ```bash
    java ejercicio-2.Ejercicio2
    ```

---

## 📷 Evidencias de Ejecución

A continuación se muestran las capturas de pantalla de los programas funcionando correctamente en la terminal de Visual Studio Code:

### Ejercicio 1:
<img src="capturas-ejecucion/ejercicio1_resultado.png" alt="Ejecución Ejercicio 1" width="600px">

### Ejercicio 2:
<img src="capturas-ejecucion/ejercicio2_resultado.png" alt="Ejecución Ejercicio 2" width="600px">
