package Practica2;

import javax.swing.JOptionPane;

/**
 *
 * @author Nancy
 */
public class ListaProducto {
    
    Producto[] productos = new Producto[4];

    public void listaProductos() {
        for (int i = 0; i < productos.length; i++) {
            Producto p = new Producto();
            p.setCodigo(JOptionPane.showInputDialog("Digite el código del producto " + (i + 1)));
            p.setDescripcion(JOptionPane.showInputDialog("Digite la descripción del producto " + (i + 1)));
            p.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad en inventario del producto " + (i + 1))));
            p.setPrecioUnitario(Double.parseDouble(JOptionPane.showInputDialog("Digite el precio unitario del producto " + (i + 1))));
            productos[i] = p;
        }
    }

    public void mostrarProductos(Producto[] productos) {
        if (productos != null && productos.length > 0) {
            String s = "";
            for (int i = 0; i < productos.length; i++) {
                if (productos[i] != null) { // por si hay espacios vacíos
                    s += "Código: " + productos[i].getCodigo()
                            + " | Desc: " + productos[i].getDescripcion()
                            + " | Cant: " + productos[i].getCantidad()
                            + " | Precio: " + productos[i].getPrecioUnitario()
                            + "\n---------------------------------\n";
                }
            }
            JOptionPane.showMessageDialog(null,
                    "Contenido de la lista de productos:\n\n" + s,
                    "Mostrar Productos",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se puede mostrar, la lista está vacía.",
                    "Lista Vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
