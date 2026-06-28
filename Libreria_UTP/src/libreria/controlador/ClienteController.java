package libreria.controlador;

import libreria.modelo.Cliente;
import libreria.datos.ClienteDAO;
import libreria.vista.frmGestionClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteController implements ActionListener {
    private final Cliente modelo;
    private final ClienteDAO dao;
    private final frmGestionClientes vista;

    public ClienteController(Cliente modelo, ClienteDAO dao, frmGestionClientes vista) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            actualizarModeloDesdeVista();
            if (modelo.validarDatos()) {
                if (dao.guardar(modelo)) {
                    JOptionPane.showMessageDialog(null, "Cliente guardado.");
                    limpiarVista();
                    listarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Datos inválidos (DNI 8 dígitos, Celular 9 dígitos).");
            }
        } else if (e.getSource() == vista.btnEditar) {
            actualizarModeloDesdeVista();
            if (dao.editar(modelo)) {
                JOptionPane.showMessageDialog(null, "Cliente actualizado.");
                listarTabla();
            }
        } else if (e.getSource() == vista.btnEliminar) {
            if (dao.eliminar(vista.txtDni.getText())) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado.");
                limpiarVista();
                listarTabla();
            }
        } else if (e.getSource() == vista.btnBuscar) {
            modelo.setDni(vista.txtDni.getText());
            if (dao.buscar(modelo)) {
                vista.txtNombre.setText(modelo.getNombre());
                vista.txtApellido.setText(modelo.getApellido());
                vista.txtCelular.setText(modelo.getCelular());
                vista.txtEmail.setText(modelo.getEmail());
                vista.txtDireccion.setText(modelo.getDireccion());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el DNI.");
            }
        } else if (e.getSource() == vista.btnNuevo) {
            limpiarVista();
        }
    }

    private void actualizarModeloDesdeVista() {
        modelo.setNombre(vista.txtNombre.getText());
        modelo.setApellido(vista.txtApellido.getText());
        modelo.setDni(vista.txtDni.getText());
        modelo.setCelular(vista.txtCelular.getText());
        modelo.setEmail(vista.txtEmail.getText());
        modelo.setDireccion(vista.txtDireccion.getText());
    }

    private void limpiarVista() {
        vista.limpiar();
    }

    private void listarTabla() {
        DefaultTableModel tbl = (DefaultTableModel) vista.tablaGestionClientes.getModel();
        tbl.setRowCount(0);
        for (Cliente c : dao.listar()) {
            tbl.addRow(new Object[]{c.getNombre(), c.getApellido(), c.getDni(), c.getCelular(), c.getEmail(), c.getDireccion()});
        }
    }
}