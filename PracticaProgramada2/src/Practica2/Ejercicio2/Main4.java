/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2.Ejercicio2;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Main4 {
    public static void main(String[] args) {
        Pila pila = new Pila();         // Pila de estudiantes
        ColaNotas notas = new ColaNotas(); // Cola para registrar notas

        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "MENÚ PARTE 4 - Registro de Calificaciones\n\n"
                    + "1. Agregar estudiante a la pila\n"
                    + "2. Registrar nota (verificando cédula)\n"
                    + "3. Mostrar listado final\n"
                    + "4. Salir", "Parte 4", JOptionPane.QUESTION_MESSAGE));

            switch (opcion) {
                case 1:
                    pila.apilar();
                    break;
                case 2:
                    notas.agregarNota(pila);
                    break;
                case 3:
                    notas.mostrar();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Fin del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (opcion != 4);
    }
}

