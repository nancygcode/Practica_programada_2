/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2;

import javax.swing.JOptionPane;

/**
 *
 * @author fabii
 */
public class Cola {

    private Nodo inicio;
    private Nodo fin;

    public Cola() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void encolar() {
        //crea el objet que inserto en nodo
        Cliente c = new Cliente();
        c.setNombre(JOptionPane.showInputDialog("Digite el nombre: "));
        c.setApellido1(JOptionPane.showInputDialog("Digite el primer apellido: "));
        c.setApellido2(JOptionPane.showInputDialog("Digite el segundo apellido: "));
        c.setCedula(Integer.parseInt(JOptionPane.showInputDialog("Digite la cédula: ")));

        //agregamos el objeto estudiante en el nuevo nodo
        Nodo nuevo = new Nodo();
        //agrego el cliente al nodo nuevo
        nuevo.setElemento(c);
        //insertamos el nodo en la cola
        if (vacia()) { //si esta vacia, coloco el unico nodo ahi
            inicio = nuevo;
            fin = nuevo;
        } else { //si ya tenia nodos guardados
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

    }

    public void desencolar() {
        if (!vacia()) {
            System.out.println("Extraido: " + inicio.getElemento().getNombre());
            inicio = inicio.getSiguiente();
            JOptionPane.showMessageDialog(null, "Cliente extraido", "Desencolar",
                    JOptionPane.CLOSED_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede extraer cliente",
                    "Cola Vacia", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar() {
        if (!vacia()) {
            String s = "";
            Nodo aux = inicio;
            while (aux != null) {
                s += "Cédula: " + aux.getElemento().getCedula() + " - "
                        + aux.getElemento().getNombre() + " "
                        + aux.getElemento().getApellido1() + " "
                        + aux.getElemento().getApellido2() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Contenido de la cola: \n\n" + s,
                    "Mostrar Clientes", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar", "Cola Vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public Cliente buscarClientePorCedula(int cedula) {
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.getElemento().getCedula() == cedula) {
                return aux.getElemento();
            }
            aux = aux.getSiguiente();
        }
        return null; // no encontrado
    }
}
