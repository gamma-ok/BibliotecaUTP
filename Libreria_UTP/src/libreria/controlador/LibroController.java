package libreria.controlador;

import libreria.modelo.*;
import libreria.datos.LibroDAO;
import libreria.vista.frmGestionLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.vista.setController(this); // Necesitamos este método en la vista

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        
        listarTabla(); // Cargar datos al iniciar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            actualizarModeloDesdeVista();
            if (dao.guardar(modelo)) {
                JOptionPane.showMessageDialog(null, "Libro guardado con éxito.");
                limpiarVista();
                listarTabla();
            }
        } else if (e.getSource() == vista.btnEditar) {
            actualizarModeloDesdeVista();
            if (dao.editar(modelo)) {
                JOptionPane.showMessageDialog(null, "Libro actualizado.");
                listarTabla();
            }
        } else if (e.getSource() == vista.btnEliminar) {
            if (dao.eliminar(vista.txtIsbn.getText())) {
                JOptionPane.showMessageDialog(null, "Libro eliminado.");
                limpiarVista();
                listarTabla();
            }
        } else if (e.getSource() == vista.btnBuscar) {
            modelo.setIsbn(vista.txtIsbn.getText());
            if (dao.buscar(modelo)) {
                vista.txtTitulo.setText(modelo.getTitulo());
                vista.txtAutor.setText(modelo.getAutor());
                vista.txtPrecio.setText(String.valueOf(modelo.getPrecio()));
                vista.txtStock.setText(String.valueOf(modelo.getStock()));
                vista.cbTipoLibro.setSelectedItem(modelo.getTipoLibro());
                vista.dateAnioPublicacion.setYear(modelo.getAnioPublicacion());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el ISBN.");
            }
        } else if (e.getSource() == vista.btnNuevo) {
            limpiarVista();
        }
    }

    private void actualizarModeloDesdeVista() {
        modelo.setIsbn(vista.txtIsbn.getText());
        modelo.setTitulo(vista.txtTitulo.getText());
        modelo.setAutor(vista.txtAutor.getText());
        modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
        modelo.setStock(Integer.parseInt(vista.txtStock.getText()));
        modelo.setAnioPublicacion(vista.dateAnioPublicacion.getYear());
        modelo.setTipoLibro(vista.cbTipoLibro.getSelectedItem().toString());
    }

    private void limpiarVista() {
        vista.txtIsbn.setText("");
        vista.txtTitulo.setText("");
        vista.txtAutor.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
        vista.cbTipoLibro.setSelectedIndex(0);
        vista.dateAnioPublicacion.setYear(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR));
    }

    private void listarTabla() {
        DefaultTableModel tbl = (DefaultTableModel) vista.tablaGestionLibros.getModel();
        tbl.setRowCount(0);
        for (Libro l : dao.listar()) {
            tbl.addRow(new Object[]{l.getIsbn(), l.getTipoLibro(), l.getTitulo(),
                l.getAutor(), l.getPrecio(), l.getStock(), l.getAnioPublicacion()});
        }
    }
}