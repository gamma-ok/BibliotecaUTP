package Controlador;

import Modelo.Clientes;
import Modelo.ConsultasProveedores;
import Modelo.Proveedores;
import Vista.frmProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ControlProveedores implements ActionListener {
    private final Proveedores modelo;
    private final ConsultasProveedores consultas;
    private final frmProveedores vista;

    public ControlProveedores(Proveedores modelo, ConsultasProveedores consultas, frmProveedores vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Gestión de Proveedores | By gamma");
        vista.setLocationRelativeTo(null);
        vista.setSize(745, 600);
        
        poblarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            if (validarCampos()) {
                modelo.setDescripcion(vista.txtDescripcion.getText());
                modelo.setDireccion(vista.txtDireccion.getText());
                try {
                    modelo.setId(Integer.parseInt(vista.txtId.getText()));
                    modelo.setTelefono(vista.txtTelefono.getText());

                    if (consultas.guardar(modelo)) {
                        JOptionPane.showMessageDialog(null, "¡Proveedor guardado exitosamente!", "¡Logrado!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al guardar el proveedor!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "¡ID del proveedor no válido!", "¡Error!", JOptionPane.ERROR_MESSAGE);;
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == vista.btnEditar) {
            if (validarCampos()) {
                modelo.setId(Integer.parseInt(vista.txtId.getText()));
                modelo.setDescripcion(vista.txtDescripcion.getText());
                modelo.setDireccion(vista.txtDireccion.getText());
                modelo.setTelefono(vista.txtTelefono.getText());
                try {
                    if (consultas.editar(modelo)) {
                        JOptionPane.showMessageDialog(null, "¡Proveedor actualizado exitosamente!", "¡Logrado!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al actualizar el proveedor!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "¡Proveedor no válido!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            if (vista.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Debe ingresar el ID del proveedor para eliminar!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "¡Proveedor eliminado exitosamente!", "¡Logrado!", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                poblarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar el proveedor!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            if (vista.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Debe ingresar el ID del proveedor para buscar!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if (consultas.buscar(modelo)) {
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtDescripcion.setText(modelo.getDescripcion());
                vista.txtDireccion.setText(modelo.getDireccion());
                vista.txtTelefono.setText(modelo.getTelefono());
            } else {
                JOptionPane.showMessageDialog(null, "¡Proveedor no encontrado!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }

        if (e.getSource() == vista.btnNuevo) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.txtId.setText(null);
        vista.txtDescripcion.setText(null);
        vista.txtDireccion.setText(null);
        vista.txtTelefono.setText(null);
    }

    private boolean validarCampos() {
        return !vista.txtId.getText().isEmpty() &&
               !vista.txtDescripcion.getText().isEmpty() &&
               !vista.txtDireccion.getText().isEmpty() &&
               !vista.txtTelefono.getText().isEmpty();
    }
    
    private void poblarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tablaProveedores.getModel();
        modeloTabla.setRowCount(0);
        List<Proveedores> listaProveedoreses = consultas.obtenerTodos();
        for (Proveedores proveedores : listaProveedoreses) {
            modeloTabla.addRow(new Object[]{
                proveedores.getId(),
                proveedores.getDescripcion(),
                proveedores.getDireccion(),
                proveedores.getTelefono()
            });
        }
    }
}