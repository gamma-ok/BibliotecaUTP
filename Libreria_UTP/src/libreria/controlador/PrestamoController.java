package libreria.controlador;

import libreria.modelo.Prestamo;
import libreria.datos.PrestamoDAO;
import libreria.vista.frmGestionPrestamos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PrestamoController implements ActionListener {
    private final Prestamo modelo;
    private final PrestamoDAO dao;
    private final frmGestionPrestamos vista;

    public PrestamoController(Prestamo modelo, PrestamoDAO dao, frmGestionPrestamos vista) {
        this.modelo = modelo;
        this.dao = dao;
        this.vista = vista;
        this.vista.setController(this);
        
        if (this.vista.btnRegistrar != null) {
            this.vista.btnRegistrar.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnRegistrar != null && e.getSource() == vista.btnRegistrar) {
            try {
                String dni = vista.txtDniCliente.getText();
                String isbn = vista.txtIsbnLibro.getText();
                int dias = Integer.parseInt(vista.txtDias.getText());
                
                if (dao.registrarPrestamo(dni, isbn, dias)) {
                    JOptionPane.showMessageDialog(null, "Prestamo procesado con exito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar prestamo.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un numero valido de dias.");
            }
        }
    }
}