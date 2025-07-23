/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2.Ejercicio2;

import javax.swing.JOptionPane;

/**
 *
 * @author XSF
 */
public class Menu {
      int op = 0;
    Pila p = new Pila();

    public void opciones() {
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Principal\n"
                + "\n1 - Agregar Estudiante"
                + "\n2- Borrar Estudiante"
                + "\n3 Mostrar Estudiante "
                + "\n4. Busqueda por Cedula"
                + "\n6. Salir"
                + "\n Digite una opcion: ", "Menu", JOptionPane.QUESTION_MESSAGE));

        switch (op) {
            case 1:
                p.apilar();
                opciones();
                break;
            case 2:
                p.desapilar();
                opciones();
                break;
            case 3:
                p.mostrar();
                opciones();
                break;
            case 4:
                p.busquedaCedula();
                opciones();
                break;
            case 6:
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Error opción invalida",
                        "error", JOptionPane.ERROR_MESSAGE);
                opciones();

        }

    }
}
