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
public class Menu {

    //iniciar cola
    Cola c = new Cola();
    ListaProducto productos = new ListaProducto();

    int op;

    String botones[] = {"Encolar \nCliente", "Desencolar \nCliente",
        "Agregar \nProductos", "Mostrar \nProductos", "Generar \nFactura", "Salir"};

    public void opciones() {

        do {

            op = JOptionPane.showOptionDialog(null, "Escoja su opción: ", "Menu Principal",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);

            switch (op) {

                case 0:
                    for (int i = 0; i < 4; i++) {
                        c.encolar();
                    }
                    break;

                case 1:

                    c.desencolar();

                    break;

                case 2:
                    productos.listaProductos();
                    break;

                case 3:
                    productos.mostrarProductos(productos.productos);
                    break;

                case 4:
                    generarFactura();

                    break;

                default:

                    System.exit(0);

            }

        } while (op != 5);

    }

    public void generarFactura() {

        String cod = JOptionPane.showInputDialog("Digite el código de producto a facturar:");
        Producto p = productos.buscarProductoPorCodigo(cod);

        if (p == null) {
            JOptionPane.showMessageDialog(null, "El producto no existe.");
            return;
        }

        // pedir cédula de cliente
        int ced = Integer.parseInt(JOptionPane.showInputDialog("Digite la cédula del cliente:"));
        Cliente cliente = c.buscarClientePorCedula(ced);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "El cliente no existe.");
            return;
        }

        // pedir cantidad a comprar
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad a comprar:"));
        if (cant > p.getCantidad()) {
            JOptionPane.showMessageDialog(null, "No hay suficiente cantidad en inventario.");
            return;
        }

        // calcular total
        double total = cant * p.getPrecioUnitario();

        // actualizar stock
        p.setCantidad(p.getCantidad() - cant);

        // mostrar factura
        String factura = "===== FACTURA =====\n"
                + "Cliente: " + cliente.getNombre() + " " + cliente.getApellido1() + " " + cliente.getApellido2() + "\n"
                + "Cédula: " + cliente.getCedula() + "\n"
                + "Producto: " + p.getDescripcion() + "\n"
                + "Código: " + p.getCodigo() + "\n"
                + "Cantidad: " + cant + "\n"
                + "Precio Unitario: " + p.getPrecioUnitario() + "\n"
                + "TOTAL: " + total;

        JOptionPane.showMessageDialog(null, factura, "Factura Generada", JOptionPane.INFORMATION_MESSAGE);
    }

}
