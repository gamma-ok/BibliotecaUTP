package biblioteca.controlador;

import biblioteca.modelo.Libro;
import biblioteca.modelo.Proveedor;
import biblioteca.modelo.CompraProveedor;
import biblioteca.datos.ProveedorDAO;
import biblioteca.datos.CompraProveedorDAO;
import biblioteca.datos.LibroDAO;
import biblioteca.vista.frmGestionCompras;
import java.awt.event.*;
import java.text.DecimalFormat;
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

        // Listeners para calcular el monto total automáticamente
        java.awt.event.KeyAdapter keyAdapter = new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                calcularMontoTotal();
            }
        };
        vista.txtCantidad.addKeyListener(keyAdapter);
        vista.txtPrecioCompraUnitario.addKeyListener(keyAdapter);

        listarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.cbRucProveedor || e.getSource() == vista.cbIsbnLibro) {
            actualizarInformacion();
        } else if (e.getSource() == vista.txtCantidad || e.getSource() == vista.txtPrecioCompraUnitario) {
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
            String precioStr = vista.txtPrecioCompraUnitario.getText().trim();

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
                || vista.dtFechaCompra.getDate() == null
                || vista.txtCantidad.getText().trim().isEmpty()
                || vista.txtPrecioCompraUnitario.getText().trim().isEmpty()) {
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
            double precio = Double.parseDouble(vista.txtPrecioCompraUnitario.getText().trim());
            if (precio <= 0) {
                JOptionPane.showMessageDialog(vista, "El precio unitario debe ser mayor a 0.");
                return false;
            }

            // Validar que la fecha no sea en el pasado
            LocalDate fechaCompra = vista.dtFechaCompra.getDate().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate hoy = LocalDate.now();

            if (fechaCompra.isBefore(hoy)) {
                JOptionPane.showMessageDialog(vista, "La fecha de compra no puede ser anterior a hoy.");
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
                // Actualizar combos para reflejar nuevo stock
                actualizarCombos();
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
                JOptionPane.showMessageDialog(vista, "Compra eliminada correctamente.");
                limpiarFormulario();
                listarTabla();
                actualizarCombos();
            }
        }
    }

    private CompraProveedor crearCompraDesdeVista(int id) {
        Proveedor p = mapaProveedores.get(vista.cbRucProveedor.getSelectedItem());
        Libro l = mapaLibros.get(vista.cbIsbnLibro.getSelectedItem());
        LocalDate fechaCompra = vista.dtFechaCompra.getDate().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        int cantidad = Integer.parseInt(vista.txtCantidad.getText().trim());
        double precioCompraUnitario = Double.parseDouble(vista.txtPrecioCompraUnitario.getText().trim());

        return new CompraProveedor(id, p, l, fechaCompra, cantidad, precioCompraUnitario);
    }

    private void actualizarInformacion() {
        String ruc = (String) vista.cbRucProveedor.getSelectedItem();
        String isbn = (String) vista.cbIsbnLibro.getSelectedItem();

        if (ruc != null && !ruc.equals("Seleccione...") && isbn != null && !isbn.equals("Seleccione...")) {
            Proveedor p = mapaProveedores.get(ruc);
            Libro l = mapaLibros.get(isbn);

            if (p != null && l != null) {
                StringBuilder info = new StringBuilder();
                info.append("PROVEEDOR:\n");
                info.append("RUC: ").append(ruc).append("\n");
                info.append("Nombre: ").append(p.getNombre()).append("\n");
                info.append("Apellido: ").append(p.getApellido()).append("\n");
                info.append("Teléfono: ").append(p.getTelefono()).append("\n");
                info.append("Correo: ").append(p.getCorreo()).append("\n\n");

                info.append("LIBRO:\n");
                info.append("ISBN: ").append(isbn).append("\n");
                info.append("Título: ").append(l.getTitulo()).append("\n");
                info.append("Autor: ").append(l.getAutor()).append("\n");
                info.append("Precio Compra: S/.").append(String.format("%.2f", l.getPrecioCompra())).append("\n");
                info.append("Precio Venta: S/.").append(String.format("%.2f", l.getPrecioVenta())).append("\n");
                info.append("Stock actual: ").append(l.getCantidad());

                vista.taInformacion.setText(info.toString());
            }
        }
    }

    private void actualizarCombos() {
        // Actualizar lista de libros
        vista.cbIsbnLibro.removeAllItems();
        vista.cbIsbnLibro.addItem("Seleccione...");
        mapaLibros.clear();

        LibroDAO lDao = new LibroDAO();
        for (Libro l : lDao.listar()) {
            vista.cbIsbnLibro.addItem(l.getIsbn());
            mapaLibros.put(l.getIsbn(), l);
        }
    }

    private void limpiarFormulario() {
        vista.txtIdCompra.setText("");
        vista.cbRucProveedor.setSelectedIndex(0);
        vista.cbIsbnLibro.setSelectedIndex(0);
        vista.dtFechaCompra.setDate(null);
        vista.txtCantidad.setText("");
        vista.txtPrecioCompraUnitario.setText("");
        vista.txtMontoTotal.setText("");
        vista.taInformacion.setText("");
    }

    public void listarTabla() {
        DefaultTableModel model = (DefaultTableModel) vista.tGestionCompras.getModel();
        model.setRowCount(0);
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#.##");

        for (CompraProveedor cp : cpDao.listar()) {
            model.addRow(new Object[]{
                cp.getIdCompra(),
                cp.getProveedor().getRuc(),
                cp.getLibro().getIsbn(),
                cp.getFechaCompra().format(formatter),
                cp.getCantidad(),
                df.format(cp.getPrecioCompraUnitario()),
                df.format(cp.getMontoTotal())
            });
        }
    }
}
