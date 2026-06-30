package libreria.controlador;

import libreria.modelo.*;
import libreria.datos.*;
import libreria.vista.frmGestionPrestamos;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrestamoController implements ActionListener {

    private final frmGestionPrestamos vista;
    private final PrestamoDAO pDao = new PrestamoDAO();
    private final Map<String, Cliente> mapaClientes = new HashMap<>();
    private final Map<String, Libro> mapaLibros = new HashMap<>();

    public PrestamoController(frmGestionPrestamos vista, ClienteDAO cDao, LibroDAO lDao) {
        this.vista = vista;

        // Carga de datos del ComboBox
        for (Cliente c : cDao.listar()) {
            vista.cbDniCliente.addItem(c.getDni());
            mapaClientes.put(c.getDni(), c);
        }

        // Carga de datos del ComboBox
        for (Libro l : lDao.listar()) {
            vista.cbIsbnLibro.addItem(l.getIsbn());
            mapaLibros.put(l.getIsbn(), l);
        }

        // Listeners
        vista.cbDniCliente.addActionListener(this);
        vista.cbIsbnLibro.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnNuevo.addActionListener(e -> limpiarFormulario());

        listarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.cbDniCliente || e.getSource() == vista.cbIsbnLibro) {
            actualizarResumen();
        } else if (e.getSource() == vista.btnGuardar) {
            if (esValido()) {
                guardarPrestamo();
            }
        } else if (e.getSource() == vista.btnEditar) {
            if (validarSeleccionTabla() && esValido()) {
                editarPrestamo();
            }
        } else if (e.getSource() == vista.btnEliminar) {
            if (validarSeleccionTabla()) {
                eliminarPrestamo();
            }
        }
    }

    private boolean esValido() {
        if (vista.cbDniCliente.getSelectedIndex() <= 0
                || vista.cbIsbnLibro.getSelectedIndex() <= 0
                || vista.cbEstado.getSelectedIndex() <= 0
                || vista.dtFechaPrestamo.getDate() == null
                || vista.dtFechaDevolucion.getDate() == null
                || vista.txtMontoPagado.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.");
            return false;
        }

        try {
            Double.parseDouble(vista.txtMontoPagado.getText());
            LocalDate fP = vista.dtFechaPrestamo.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fD = vista.dtFechaDevolucion.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (fD.isBefore(fP)) {
                JOptionPane.showMessageDialog(vista, "La fecha de devolución no puede ser anterior a la de préstamo.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Datos inválidos (Monto o Fechas incorrectas).");
            return false;
        }
        return true;
    }

    private boolean validarSeleccionTabla() {
        if (vista.txtIdPrestamo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione un préstamo de la tabla.");
            return false;
        }
        return true;
    }

    private void guardarPrestamo() {
        try {
            Prestamo p = crearPrestamoDesdeVista(0);
            if (pDao.registrar(p)) {
                JOptionPane.showMessageDialog(vista, "Préstamo registrado exitosamente.");
                limpiarFormulario();
                listarTabla();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al guardar el préstamo.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ocurrió un error inesperado.");
        }
    }

    private void editarPrestamo() {
        try {
            int id = Integer.parseInt(vista.txtIdPrestamo.getText());
            Prestamo p = crearPrestamoDesdeVista(id);
            if (pDao.modificar(p)) {
                JOptionPane.showMessageDialog(vista, "Préstamo actualizado exitosamente.");
                limpiarFormulario();
                listarTabla();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar el préstamo.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ocurrió un error al actualizar.");
        }
    }

    private void eliminarPrestamo() {
        int confirm = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar este préstamo?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(vista.txtIdPrestamo.getText());
            if (pDao.eliminar(id)) {
                JOptionPane.showMessageDialog(vista, "Préstamo eliminado correctamente.");
                limpiarFormulario();
                listarTabla();
            }
        }
    }

    private Prestamo crearPrestamoDesdeVista(int id) {
        Cliente c = mapaClientes.get(vista.cbDniCliente.getSelectedItem());
        Libro l = mapaLibros.get(vista.cbIsbnLibro.getSelectedItem());
        LocalDate fP = vista.dtFechaPrestamo.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fD = vista.dtFechaDevolucion.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        double monto = Double.parseDouble(vista.txtMontoPagado.getText());
        return new Prestamo(id, c, l, fP, fD, vista.cbEstado.getSelectedItem().toString(), monto);
    }

    private void actualizarResumen() {
        String dni = (String) vista.cbDniCliente.getSelectedItem();
        String isbn = (String) vista.cbIsbnLibro.getSelectedItem();

        if (dni != null && !dni.equals("Seleccione...") && isbn != null && !isbn.equals("Seleccione...")) {
            Cliente c = mapaClientes.get(dni);
            Libro l = mapaLibros.get(isbn);
            vista.taResumen.setText("DNI Cliente: " + dni + "\nNombre: " + c.getNombre() + " " + c.getApellido()
                    + "\nISBN Libro: " + isbn + "\nTítulo: " + l.getTitulo()
                    + "\nPrecio base: S/ " + String.format("%.2f", l.getPrecio()));
        }
    }

    private void limpiarFormulario() {
        vista.txtIdPrestamo.setText("");
        vista.cbDniCliente.setSelectedIndex(0);
        vista.cbIsbnLibro.setSelectedIndex(0);
        vista.dtFechaPrestamo.setDate(null);
        vista.dtFechaDevolucion.setDate(null);
        vista.cbEstado.setSelectedIndex(0);
        vista.txtMontoPagado.setText("");
        vista.taResumen.setText("");
    }

    public void listarTabla() {
        DefaultTableModel model = (DefaultTableModel) vista.tGestionPrestamos.getModel();
        model.setRowCount(0);
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Prestamo p : pDao.listar()) {
            model.addRow(new Object[]{p.getIdPrestamo(), p.getCliente().getDni(), p.getLibro().getIsbn(),
                p.getFechaPrestamo().format(formatter), p.getFechaDevolucion().format(formatter),
                p.getEstado(), p.getMontoPagado()});
        }
    }
}
