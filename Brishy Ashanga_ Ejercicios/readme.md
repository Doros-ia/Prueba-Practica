<div align="center">
  <h1>Prueba Práctica de Lógica de Programación</h1>
  <p><strong>Universidad Técnica de Ambato</strong></p>
  <p><strong>Carrera:</strong> Software | <strong>Asignatura:</strong> Fundamentos de Programación</p>
</div>

---

## 👤 Datos del Estudiante

<table>
  <tr>
    <td><strong>Estudiante:</strong></td>
    <td>Brishy Anahy Yumbo Ashanga </td>
  </tr>
  <tr>
    <td><strong>Curso / Semestre:</strong></td>
    <td>1er Semestre</td>
  </tr>
  <tr>
    <td><strong>Fecha:</strong></td>
    <td>9/11/2026</td>
  </tr>
  <tr>
    <td><strong>Repositorio:</strong></td>
    <td><code>prueba-practica-logica-programacion</code></td>
  </tr>
</table>

---

## 📁 Estructura del Repositorio

```text
├── README.md
├── Ejercicio1.java
├── EvaluacionProyecto.java
├── evidencia-manual/
│   ├── analisis-algoritmo.pdf
│   └── prueba-escritorio.pdf
└── capturas-ejecucion/
    ├── terminal-ejercicio1.png
    └── terminal-evaluacion-proyecto.png
```

---

## 📝 Descripción de los Ejercicios

### 🔹 Ejercicio 1: Competencia de programación por niveles
* **Descripción:** Determina el nivel de desempeño de un participante en una competencia considerando los puntajes de tres retos, penalizaciones por fallos, bonificaciones por tiempo/reto extra y causales de descalificación.
* **Entradas:**
  * `reto1`, `reto2`, `reto3`: Enteros en el rango `[0, 10]`.
  * `errores`: Entero no negativo.
  * `tiempo`: Entero en minutos.
  * `extra`: Booleano / respuesta (`S`/`N`) para desafío extra.
  * `copia`: Booleano / respuesta (`S`/`N`) para descalificación por copia.
* **Reglas y Proceso:**
  * **Puntaje base:** $\text{reto1} + \text{reto2} + \text{reto3}$.
  * **Penalización:** $\text{errores} \times 4$.
  * **Bonificaciones:** $+15$ si completó el desafío extra; $+10$ si el tiempo total es $< 30$ minutos.
  * **Puntaje final:** $\text{base} - \text{penalización} + \text{bonificaciones}$ (si el resultado es $< 0$, se fija en $0$).
  * **Nivel según rango:** 
    * `0` a `29`: Principiante
    * `30` a `49`: Básico
    * `50` a `69`: Intermedio
    * `70` a `89`: Avanzado
    * $\ge 90$: Experto
  * **Condiciones especiales:**
    * Si hubo copia, el nivel resultante es **"Descalificado"**.
    * Si $\text{puntajeFinal} \ge 70$ y $\text{errores} > 10$, se emite la observación: *"Resultado inconsistente: revisar calidad de resolución"*.
* **Salidas:** Puntaje base, penalización, bonificación, puntaje final, nivel y observación.

### 🔹 Ejercicio 2: Evaluación de la calidad de un proyecto de software
* **Descripción:** Calcula la calificación técnica final de un proyecto considerando tres notas parciales, penalizaciones por errores, bonificaciones por formalidad (documentación y defensa) y restricciones de avance.
* **Entradas:**
  * `notaAnalisis`, `notaDiseño`, `notaCodificacion`: Reales en el rango `[0, 10]`.
  * `avance`: Porcentaje real en el rango `[0, 100]`.
  * `errores`: Entero $\ge 0$.
  * `docCompleta`: Carácter / Booleano (`S`/`N`).
  * `expoFinal`: Carácter / Booleano (`S`/`N`).
* **Reglas y Proceso:**
  * **Promedio técnico:** $(\text{análisis} + \text{diseño} + \text{codificación}) / 3$.
  * **Ajustes:** $-0.5$ por cada error, $+0.5$ si entregó documentación completa y $+0.5$ si realizó exposición final.
  * **Límites de nota final:** La nota se ajusta obligatoriamente dentro del rango $[0, 10]$.
  * **Escala de estado académico:**
    * $9.0$ a $10.0$: Excelente
    * $7.0$ a $8.99$: Aprobado
    * $5.0$ a $6.99$: Recuperación
    * $< 5.0$: Reprobado
  * **Condiciones especiales:**
    * Si $\text{avance} < 60\%$ y el estado alcanzado es `Excelente`, se degrada a **Aprobado** (restricción por avance).
    * Si $\text{notaFinal} \ge 7$ y no presentó documentación completa (`docCompleta = 'N'`), la observación es: *"Buen producto, pero mala formalidad"*.
* **Salidas:** Promedio técnico, desglose de ajustes aplicados, nota final, estado académico y observación.

---

## 🚀 Instrucciones para Compilar y Ejecutar

Ambos programas están desarrollados en **Java** y fueron verificados mediante consola.

### 🛠️ Requisitos Previos
* JDK (Java Development Kit) 11 o superior instalado.
* Consola o terminal de comandos configurada con el compilador `javac`.

---

### 🖥️ Ejercicio 1: Competencia de Programación

1. **Compilación:**
   ```bash
   javac Ejercicio1.java
   ```
2. **Ejecución:**
   ```bash
   java Ejercicio1
   ```

---

### 🖥️ Ejercicio 2: Evaluación de Calidad de Proyecto

1. **Compilación:**
   ```bash
   javac EvaluacionProyecto.java
   ```
2. **Ejecución:**
   ```bash
   java EvaluacionProyecto
   ```
