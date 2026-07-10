package biblioteca.controlador;

import biblioteca.modelo.Proveedor;
import biblioteca.datos.ProveedorDAO;
import biblioteca.vista.frmGestionProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProveedorController implements ActionListener {

    private final Proveedor modelo;
    private final ProveedorDAO dao;
    private final frmGestionProveedores vista;

    public ProveedorController(Proveedor modelo, ProveedorDAO dao, frmGestionProveedores vista) {
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

    private boolean camposVacios() {
        return vista.txtRuc.getText().trim().isEmpty()
                || vista.txtNombre.getText().trim().isEmpty()
                || vista.txtApellido.getText().trim().isEmpty()
                || vista.txtTelefono.getText().trim().isEmpty()
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
                    JOptionPane.showMessageDialog(vista, "Proveedor guardado exitosamente.");
                    limpiarVista();
                    listarTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error: El RUC ya existe o hubo un problema al guardar.");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Datos inválidos (RUC 11 dígitos, Teléfono 9 dígitos, Correo con @).");
            }

        } else if (e.getSource() == vista.btnEditar) {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos para editar.");
                return;
            }

            actualizarModeloDesdeVista();

            if (!modelo.validarDatos()) {
                JOptionPane.showMessageDialog(vista, "Datos inválidos: Revise RUC, Teléfono y Correo.");
                return;
            }

            if (dao.editar(modelo)) {
                JOptionPane.showMessageDialog(vista, "Proveedor actualizado.");
                listarTabla();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar. Verifique que el RUC no haya cambiado.");
            }

        } else if (e.getSource() == vista.btnEliminar) {
            String ruc = vista.txtRuc.getText().trim();
            
            if (ruc.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese el RUC del proveedor a eliminar.");
                return;
            }

            int confirmar = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar este proveedor?", "Confirmación", JOptionPane.YES_NO_OPTION);
            
            if (confirmar == JOptionPane.YES_OPTION) {
                // DAO maneja la excepción de FK
                if (dao.eliminar(ruc)) {
                    JOptionPane.showMessageDialog(vista, "Proveedor eliminado.");
                    limpiarVista();
                    listarTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error: El proveedor tiene compras asociadas.", "Error de Integridad" ,JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (e.getSource() == vista.btnBuscar) {
            String ruc = vista.txtRuc.getText().trim();
            if (ruc.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese un RUC para buscar.");
                return;
            }
            modelo.setRuc(ruc);
            
            if (dao.buscar(modelo)) {
                vista.txtNombre.setText(modelo.getNombre());
                vista.txtApellido.setText(modelo.getApellido());
                vista.txtTelefono.setText(modelo.getTelefono());
                vista.txtCorreo.setText(modelo.getCorreo());
                vista.txtDireccion.setText(modelo.getDireccion());
            } else {
                JOptionPane.showMessageDialog(vista, "No se encontró el RUC.");
            }

        } else if (e.getSource() == vista.btnNuevo) {
            limpiarVista();
        }
    }

    private void actualizarModeloDesdeVista() {
        modelo.setNombre(vista.txtNombre.getText().trim());
        modelo.setApellido(vista.txtApellido.getText().trim());
        modelo.setRuc(vista.txtRuc.getText().trim());
        modelo.setTelefono(vista.txtTelefono.getText().trim());
        modelo.setCorreo(vista.txtCorreo.getText().trim());
        modelo.setDireccion(vista.txtDireccion.getText().trim());
    }

    private void limpiarVista() {
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtTelefono.setText("");
        vista.txtCorreo.setText("");
        vista.txtRuc.setText("");
        vista.txtDireccion.setText("");
    }

    private void listarTabla() {
        DefaultTableModel tbl = (DefaultTableModel) vista.tGestionProveedores.getModel();
        tbl.setRowCount(0);
        for (Proveedor p : dao.listar()) {
            tbl.addRow(new Object[]{p.getNombre(), p.getApellido(), p.getTelefono(), p.getCorreo(), p.getRuc(), p.getDireccion()});
        }
    }
}
