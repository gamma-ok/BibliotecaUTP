package biblioteca.controlador;

import biblioteca.modelo.Usuario;
import biblioteca.datos.UsuarioDAO;
import biblioteca.vista.frmGestionUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioController implements ActionListener {

    private final Usuario modelo;
    private final UsuarioDAO dao;
    private final frmGestionUsuarios vista;

    public UsuarioController(Usuario modelo, UsuarioDAO dao, frmGestionUsuarios vista) {
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

    // Validar campos vacíos
    private boolean camposVacios() {
        return vista.txtDni.getText().trim().isEmpty()
                || vista.txtNombre.getText().trim().isEmpty()
                || vista.txtApellido.getText().trim().isEmpty()
                || vista.txtCelular.getText().trim().isEmpty()
                || vista.txtCorreo.getText().trim().isEmpty()
                || vista.txtDireccion.getText().trim().isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.");
                return;
            }

            actualizarModeloDesdeVista();

            if (modelo.validarDatos()) {
                if (dao.guardar(modelo)) {
                    JOptionPane.showMessageDialog(vista, "Cliente guardado exitosamente.");
                    limpiarVista();
                    listarTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error: El DNI ya existe o hubo un problema al guardar.");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Datos inválidos (DNI 8 dígitos, Celular 9 dígitos, Correo con @).");
            }

        } else if (e.getSource() == vista.btnEditar) {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos para editar.");
                return;
            }

            actualizarModeloDesdeVista();

            if (!modelo.validarDatos()) {
                JOptionPane.showMessageDialog(vista, "Datos inválidos: Revise DNI, Celular y Correo.");
                return;
            }

            if (dao.editar(modelo)) {
                JOptionPane.showMessageDialog(vista, "Cliente actualizado.");
                listarTabla();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar. Verifique que el DNI no haya cambiado.");
            }

        } else if (e.getSource() == vista.btnEliminar) {
            String dni = vista.txtDni.getText().trim();

            if (dni.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese el DNI del cliente a eliminar.");
                return;
            }

            int confirmar = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar a este cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION) {
                // DAO maneja la excepción de FK
                if (dao.eliminar(dni)) {
                    JOptionPane.showMessageDialog(vista, "Cliente eliminado.");
                    limpiarVista();
                    listarTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error: El cliente tiene préstamos asociados.",
                            "Error de Integridad", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (e.getSource() == vista.btnBuscar) {
            String dni = vista.txtDni.getText().trim();
            if (dni.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese un DNI para buscar.");
                return;
            }

            modelo.setDni(dni);

            if (dao.buscar(modelo)) {
                vista.txtNombre.setText(modelo.getNombre());
                vista.txtApellido.setText(modelo.getApellido());
                vista.txtCelular.setText(modelo.getCelular());
                vista.txtCorreo.setText(modelo.getCorreo());
                vista.txtDireccion.setText(modelo.getDireccion());
            } else {
                JOptionPane.showMessageDialog(vista, "No se encontró el DNI.");
            }

        } else if (e.getSource() == vista.btnNuevo) {
            limpiarVista();
        }
    }

    private void actualizarModeloDesdeVista() {
        modelo.setNombre(vista.txtNombre.getText().trim());
        modelo.setApellido(vista.txtApellido.getText().trim());
        modelo.setDni(vista.txtDni.getText().trim());
        modelo.setCelular(vista.txtCelular.getText().trim());
        modelo.setCorreo(vista.txtCorreo.getText().trim());
        modelo.setDireccion(vista.txtDireccion.getText().trim());
    }

    private void limpiarVista() {
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtDni.setText("");
        vista.txtCelular.setText("");
        vista.txtCorreo.setText("");
        vista.txtDireccion.setText("");
    }

    private void listarTabla() {
        DefaultTableModel tbl = (DefaultTableModel) vista.tGestionUsuarios.getModel();
        tbl.setRowCount(0);
        for (Usuario c : dao.listar()) {
            tbl.addRow(new Object[]{c.getNombre(), c.getApellido(), c.getDni(), c.getCelular(), c.getCorreo(), c.getDireccion()});
        }
    }
}
