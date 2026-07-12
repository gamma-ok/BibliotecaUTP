package biblioteca.controlador;

import biblioteca.modelo.Libro;
import biblioteca.modelo.Novela;
import biblioteca.modelo.LibroTexto;
import biblioteca.modelo.Enciclopedia;
import biblioteca.datos.LibroDAO;
import biblioteca.vista.frmGestionLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LibroController implements ActionListener {

    private final Libro modelo;
    private final LibroDAO dao;
    private final frmGestionLibros vista;

    public LibroController(Libro modelo, LibroDAO dao, frmGestionLibros vista) {
        this.modelo = modelo;
        this.dao = dao;
        this.vista = vista;
        this.vista.setController(this);

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);

        listarTabla();
    }

    // Validar campos vacíos y formatos numéricos
    private boolean esFormularioValido() {
        try {
            // Validar campos de texto y ComboBox
            if (vista.txtIsbn.getText().trim().isEmpty()
                    || vista.txtTitulo.getText().trim().isEmpty()
                    || vista.txtAutor.getText().trim().isEmpty()
                    || vista.txtPrecioCompra.getText().trim().isEmpty()
                    || vista.txtPrecioVenta.getText().trim().isEmpty()
                    || vista.txtCantidad.getText().trim().isEmpty()
                    || vista.cbTipoLibro.getSelectedIndex() == 0) {

                if (vista.cbTipoLibro.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(vista, "Debe seleccionar un tipo de libro válido.");
                } else {
                    JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.");
                }
                return false;
            }

            // Validar formatos numéricos
            Double.parseDouble(vista.txtPrecioCompra.getText());
            Double.parseDouble(vista.txtPrecioVenta.getText());
            Integer.parseInt(vista.txtCantidad.getText());

            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Los precios y la cantidad deben ser valores numéricos válidos.");
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            if (!esFormularioValido()) {
                return;
            }

            actualizarModeloDesdeVista();

            if (dao.guardar(modelo)) {
                JOptionPane.showMessageDialog(null, "Libro guardado con éxito.");
                limpiarVista();
                listarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error: El ISBN ya existe en el sistema.");
            }

        } else if (e.getSource() == vista.btnEditar) {
            if (!esFormularioValido()) {
                return;
            }

            actualizarModeloDesdeVista();

            if (dao.editar(modelo)) {
                JOptionPane.showMessageDialog(null, "Libro actualizado.");
                listarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar. Verifique los datos.");
            }

        } else if (e.getSource() == vista.btnEliminar) {
            String isbn = vista.txtIsbn.getText().trim();
            if (isbn.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese el ISBN del libro a eliminar.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar este libro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (dao.eliminar(isbn)) {
                    JOptionPane.showMessageDialog(vista, "Libro eliminado.");
                    limpiarVista();
                    listarTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "No se puede eliminar: El libro tiene préstamos asociados.",
                            "Error de Integridad", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (e.getSource() == vista.btnBuscar) {
            String isbn = vista.txtIsbn.getText().trim();
            if (isbn.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese un ISBN para buscar.");
                return;
            }
            modelo.setIsbn(isbn);
            if (dao.buscar(modelo)) {
                vista.txtTitulo.setText(modelo.getTitulo());
                vista.txtAutor.setText(modelo.getAutor());
                vista.txtPrecioCompra.setText(String.valueOf(modelo.getPrecioCompra()));
                vista.txtPrecioVenta.setText(String.valueOf(modelo.getPrecioVenta()));
                vista.txtCantidad.setText(String.valueOf(modelo.getCantidad()));
                vista.cbTipoLibro.setSelectedItem(modelo.getTipoLibro());
                vista.dateAnioPublicacion.setYear(modelo.getAnioPublicacion());
            } else {
                JOptionPane.showMessageDialog(vista, "No se encontró el ISBN.");
            }
        } else if (e.getSource() == vista.btnNuevo) {
            limpiarVista();
        }
    }

    private void actualizarModeloDesdeVista() {
        modelo.setIsbn(vista.txtIsbn.getText().trim());
        modelo.setTitulo(vista.txtTitulo.getText().trim());
        modelo.setAutor(vista.txtAutor.getText().trim());
        modelo.setPrecioCompra(Double.parseDouble(vista.txtPrecioCompra.getText()));
        modelo.setPrecioVenta(Double.parseDouble(vista.txtPrecioVenta.getText()));
        modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
        modelo.setAnioPublicacion(vista.dateAnioPublicacion.getYear());
        modelo.setTipoLibro(vista.cbTipoLibro.getSelectedItem().toString());
    }

    private void limpiarVista() {
        vista.txtIsbn.setText("");
        vista.txtTitulo.setText("");
        vista.txtAutor.setText("");
        vista.txtPrecioCompra.setText("");
        vista.txtPrecioVenta.setText("");
        vista.txtCantidad.setText("");
        vista.cbTipoLibro.setSelectedIndex(0);
        vista.dateAnioPublicacion.setYear(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR));
    }

    private void listarTabla() {
        DefaultTableModel tbl = (DefaultTableModel) vista.tGestionLibros.getModel();
        tbl.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#.##"); // Formato con 2 decimales

        for (Libro l : dao.listar()) {
            tbl.addRow(new Object[]{
                l.getIsbn(),
                l.getTipoLibro(),
                l.getTitulo(),
                l.getAutor(),
                df.format(l.getPrecioCompra()),
                df.format(l.getPrecioVenta()),
                l.getCantidad(),
                l.getAnioPublicacion()
            });
        }
    }
}
