package biblioteca.controlador;

import biblioteca.modelo.Libro;
import biblioteca.modelo.Proveedor;
import biblioteca.modelo.CompraProveedor;
import biblioteca.datos.ProveedorDAO;
import biblioteca.datos.CompraProveedorDAO;
import biblioteca.datos.LibroDAO;
import biblioteca.vista.frmGestionCompras;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CompraProveedorController implements ActionListener {

    private final frmGestionCompras vista;
    private final CompraProveedorDAO cpDao = new CompraProveedorDAO();
    private final Map<String, Proveedor> mapaProveedores = new HashMap<>();
    private final Map<String, Libro> mapaLibros = new HashMap<>();

    public CompraProveedorController(frmGestionCompras vista, ProveedorDAO pDao, LibroDAO lDao) {
        this.vista = vista;

        // Carga de datos del ComboBox de Proveedores
        for (Proveedor p : pDao.listar()) {
            vista.cbRucProveedor.addItem(p.getRuc());
            mapaProveedores.put(p.getRuc(), p);
        }

        // Carga de datos del ComboBox de Libros
        for (Libro l : lDao.listar()) {
            vista.cbIsbnLibro.addItem(l.getIsbn());
            mapaLibros.put(l.getIsbn(), l);
        }

        // Listeners
        vista.cbRucProveedor.addActionListener(this);
        vista.cbIsbnLibro.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnNuevo.addActionListener(e -> limpiarFormulario());

        // Listeners para calcular el monto total automáticamente (más dinámico)
        java.awt.event.KeyAdapter keyAdapter = new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                calcularMontoTotal();
            }
        };
        vista.txtCantidad.addKeyListener(keyAdapter);
        vista.txtPrecioUnitario.addKeyListener(keyAdapter);

        listarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.cbRucProveedor || e.getSource() == vista.cbIsbnLibro) {
            actualizarInformacion();
        } else if (e.getSource() == vista.txtCantidad || e.getSource() == vista.txtPrecioUnitario) {
            calcularMontoTotal();
        } else if (e.getSource() == vista.btnGuardar) {
            if (esValido()) {
                guardarCompra();
            }
        } else if (e.getSource() == vista.btnEditar) {
            if (validarSeleccionTabla() && esValido()) {
                editarCompra();
            }
        } else if (e.getSource() == vista.btnEliminar) {
            if (validarSeleccionTabla()) {
                eliminarCompra();
            }
        }
    }

    private void calcularMontoTotal() {
        try {
            String cantidadStr = vista.txtCantidad.getText().trim();
            String precioStr = vista.txtPrecioUnitario.getText().trim();

            if (!cantidadStr.isEmpty() && !precioStr.isEmpty()) {
                int cantidad = Integer.parseInt(cantidadStr);
                double precio = Double.parseDouble(precioStr);
                double total = cantidad * precio;
                vista.txtMontoTotal.setText(String.format("%.2f", total));
            }
        } catch (NumberFormatException ex) {
            // Si hay error de formato, no actualizar el monto total
        }
    }

    private boolean esValido() {
        // Validar campos obligatorios
        if (vista.cbRucProveedor.getSelectedIndex() <= 0
                || vista.cbIsbnLibro.getSelectedIndex() <= 0
                || vista.dtFechaEntrega.getDate() == null
                || vista.txtCantidad.getText().trim().isEmpty()
                || vista.txtPrecioUnitario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.");
            return false;
        }

        try {
            // Validar que cantidad sea número positivo
            int cantidad = Integer.parseInt(vista.txtCantidad.getText().trim());
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(vista, "La cantidad debe ser mayor a 0.");
                return false;
            }

            // Validar que precio sea número positivo
            double precio = Double.parseDouble(vista.txtPrecioUnitario.getText().trim());
            if (precio <= 0) {
                JOptionPane.showMessageDialog(vista, "El precio unitario debe ser mayor a 0.");
                return false;
            }

            // Validación de stock disponible
            String isbn = vista.cbIsbnLibro.getSelectedItem().toString();
            Libro libro = mapaLibros.get(isbn);
            if (libro != null) {
                int stockActual = libro.getStock();
                if (cantidad > stockActual) {
                    JOptionPane.showMessageDialog(vista,
                            "No hay suficiente stock.\n"
                            + "Stock disponible: " + stockActual + "\n"
                            + "Cantidad solicitada: " + cantidad,
                            "Alerta",
                            JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }

            // Validar que la fecha de entrega no sea en el pasado
            LocalDate fechaEntrega = vista.dtFechaEntrega.getDate().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate hoy = LocalDate.now();

            if (fechaEntrega.isBefore(hoy)) {
                JOptionPane.showMessageDialog(vista, "La fecha de entrega no puede ser anterior a hoy.");
                return false;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Cantidad y Precio deben ser valores numéricos válidos.");
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Datos inválidos. Verifique los campos.");
            return false;
        }

        return true;
    }

    private boolean validarSeleccionTabla() {
        if (vista.txtIdCompra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una compra de la tabla.");
            return false;
        }
        return true;
    }

    private void guardarCompra() {
        try {
            CompraProveedor cp = crearCompraDesdeVista(0);
            if (cpDao.registrar(cp)) {
                JOptionPane.showMessageDialog(vista, "Compra registrada exitosamente.");
                limpiarFormulario();
                listarTabla();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al guardar la compra.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Ocurrió un error inesperado.");
        }
    }

    private void editarCompra() {
        try {
            int id = Integer.parseInt(vista.txtIdCompra.getText());
            CompraProveedor cp = crearCompraDesdeVista(id);
            if (cpDao.modificar(cp)) {
                JOptionPane.showMessageDialog(vista, "Compra actualizada exitosamente.");
                limpiarFormulario();
                listarTabla();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar la compra.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ocurrió un error al actualizar.");
        }
    }

    private void eliminarCompra() {
        int confirm = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar esta compra?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(vista.txtIdCompra.getText());
            if (cpDao.eliminar(id)) {
                JOptionPane.showMessageDialog(vista, "Compra eliminado correctamente.");
                limpiarFormulario();
                listarTabla();
            }
        }
    }

    private CompraProveedor crearCompraDesdeVista(int id) {
        Proveedor p = mapaProveedores.get(vista.cbRucProveedor.getSelectedItem());
        Libro l = mapaLibros.get(vista.cbIsbnLibro.getSelectedItem());
        LocalDate fechaEntrega = vista.dtFechaEntrega.getDate().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        int cantidad = Integer.parseInt(vista.txtCantidad.getText().trim());
        double precioUnitario = Double.parseDouble(vista.txtPrecioUnitario.getText().trim());

        return new CompraProveedor(id, p, l, fechaEntrega, cantidad, precioUnitario);
    }

    private void actualizarInformacion() {
        String ruc = (String) vista.cbRucProveedor.getSelectedItem();
        String isbn = (String) vista.cbIsbnLibro.getSelectedItem();

        if (ruc != null && !ruc.equals("Seleccione...") && isbn != null && !isbn.equals("Seleccione...")) {
            Proveedor p = mapaProveedores.get(ruc);
            Libro l = mapaLibros.get(isbn);
            vista.taInformacion.setText(
                            "PROVEEDOR:" + 
                            "\nRUC Proveedor: " + ruc + 
                            "\nNombre: " + p.getNombre() + 
                            "\nApellido: " + p.getApellido() + 
                            "\nTeléfono: " + p.getTelefono()+ 
                            "\nCorreo: " + p.getCorreo()+ 
                            "\n\nLIBRO:" + 
                            "\nISBN Libro: " + isbn + 
                            "\nTítulo: " + l.getTitulo() + 
                            "\nAutor: " + l.getAutor()+ 
                            "\nPrecio: S/" + String.format("%.2f", l.getPrecio()) +
                            "\nStock: " + l.getStock());
        }
    }

    private void limpiarFormulario() {
        vista.txtIdCompra.setText("");
        vista.cbRucProveedor.setSelectedIndex(0);
        vista.cbIsbnLibro.setSelectedIndex(0);
        vista.dtFechaEntrega.setDate(null);
        vista.txtCantidad.setText("");
        vista.txtPrecioUnitario.setText("");
        vista.txtMontoTotal.setText("");
        vista.taInformacion.setText("");
    }

    public void listarTabla() {
        DefaultTableModel model = (DefaultTableModel) vista.tGestionCompras.getModel();
        model.setRowCount(0);
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (CompraProveedor cp : cpDao.listar()) {
            model.addRow(new Object[]{cp.getIdCompra(), cp.getProveedor().getRuc(), cp.getLibro().getIsbn(),
                cp.getFechaEntrega().format(formatter), cp.getCantidad(),
                cp.getPrecioUnitario(), cp.getMontoTotal()});
        }
    }
}
