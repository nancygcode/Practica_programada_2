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
public class Pila {
    Nodo cima;

    public Pila() {
        this.cima = null;
    }

    public boolean vacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }

    public void apilar() {
        // cedula, nombre, apeliidos, curso
        Estudiante e = new Estudiante();
        e.setCedula(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del estudiante")));
        e.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del estudiante"));
        e.setApellidos(JOptionPane.showInputDialog("Ingrese los apellidos del estudiante"));
        e.setCurso(JOptionPane.showInputDialog("Ingrese el curso que pertenece el estudiante"));

        Nodo nuevo = new Nodo();
        nuevo.setAlumno(e);

        if (vacia()) {

            cima = nuevo;

        } else {

            nuevo.setSiguiente(cima);

            cima = nuevo;
        }
    }

    public void desapilar() {
        if (!vacia()) {
            JOptionPane.showMessageDialog(null, "Estudiante Borrado: " + cima.getAlumno().getCedula());
            cima = cima.getSiguiente();
            System.out.println("El estudiante fue borrado");

        } else {
            JOptionPane.showMessageDialog(null, "Error: no se puede extraer", "pila vacia", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar() {
        if (!vacia()) {
            String s = " ";
            Nodo aux = cima; //recorre la pila
            while (aux != null) {
                s = s + "--------------------------------------------------\n" + "Cédula: " + aux.getAlumno().getCedula()+ "\n"
                        + "Nombre: " + aux.getAlumno().getNombre()+ "\n"
                        + "Apellidos: " + aux.getAlumno().getApellidos()+ "\n"
                        + "Curso: " + aux.getAlumno().getCurso()+ "\n"
                        + "--------------------------------------------------\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La Pila contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "Error: no se puede mostrar",
                    "Pila Vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void busquedaCedula() {
        if (!vacia()) {
            String busqueda = JOptionPane.showInputDialog("Ingrese la cédula´para buscar al estudiante");
            boolean encontrado = false;
            Nodo aux = cima;
            while (aux != null) {
                if (busqueda.equals(aux.getAlumno().getCedula())) {
                    System.out.println("Estudiante encontrado");
                    System.out.println(cima.getAlumno().getCedula());
                    JOptionPane.showInputDialog("--------------------------------------------------\n"
                           + "Cédula: " + aux.getAlumno().getCedula()+ "\n"
                        + "Nombre: " + aux.getAlumno().getNombre()+ "\n"
                        + "Apellidos: " + aux.getAlumno().getApellidos()+ "\n"
                        + "Curso: " + aux.getAlumno().getCurso()+ "\n"
                        + "--------------------------------------------------\n");
                    encontrado = true;
                }
                aux = aux.getSiguiente();
                if (!encontrado) {
                    System.out.println("Estudiante no encontrado");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error, no se puede buscar,", "Pila vacia", JOptionPane.ERROR_MESSAGE);

        }
    }
}
