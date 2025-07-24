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
public class ColaNotas {


    Nodo inicio;
    Nodo fin;

    public ColaNotas() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void agregarNota(Pila pila) {
        int cedulaBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite la cédula del estudiante:"));
        Nodo nodoPila = pila.cima;
        boolean encontrado = false;

        while (nodoPila != null) {
            if (nodoPila.getAlumno().getCedula() == cedulaBuscar) {

                double nota = Double.parseDouble(JOptionPane.showInputDialog("Digite la nota final:"));

                Estudiante e = new Estudiante();
                e.setCedula(nodoPila.getAlumno().getCedula());
                e.setNombre(nodoPila.getAlumno().getNombre());
                e.setApellidos(nodoPila.getAlumno().getApellidos());
                e.setCurso(nodoPila.getAlumno().getCurso() + " - Nota: " + nota);

                Nodo nuevo = new Nodo();
                nuevo.setAlumno(e);

                if (vacia()) {
                    inicio = nuevo;
                    fin = nuevo;
                } else {
                    fin.setSiguiente(nuevo);
                    fin = nuevo;
                }

                JOptionPane.showMessageDialog(null, "Nota registrada correctamente.");
                encontrado = true;
                break;
            }

            nodoPila = nodoPila.getSiguiente();
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }

    public void mostrar() {
        if (!vacia()) {
            String texto = "";
            Nodo actual = inicio;

            while (actual != null) {
                Estudiante e = actual.getAlumno();
                texto += "Cédula: " + e.getCedula() + "\n";
                texto += "Nombre: " + e.getNombre() + "\n";
                texto += "Apellidos: " + e.getApellidos() + "\n";
                texto += "Curso y Nota: " + e.getCurso() + "\n";
                texto += "--------------------------\n";
                actual = actual.getSiguiente();
            }

            JOptionPane.showMessageDialog(null, texto);
        } else {
            JOptionPane.showMessageDialog(null, "No hay notas registradas.");
        }
    }
    }

