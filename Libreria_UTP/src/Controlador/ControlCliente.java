package Controlador;

import Modelo.ConsultasCliente;
import Modelo.Clientes;
import Vista.frmCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlCliente implements ActionListener {
    private final Clientes modelo;
    private final ConsultasCliente consultas;
    private final frmCliente vista;

    public ControlCliente(Clientes modelo, ConsultasCliente consultas, frmCliente vista) {
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
        vista.setTitle("Gestión de Clientes | By gamma");
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
                    modelo.setRuc(vista.txtRuc.getText());
                    
                    if (consultas.guardar(modelo)) {
                        JOptionPane.showMessageDialog(null, "¡Cliente guardado exitosamente!", "¡Logrado!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al guardar el cliente!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "¡ID del cliente no válido!", "¡Error!", JOptionPane.ERROR_MESSAGE);;
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
                modelo.setRuc(vista.txtRuc.getText());
                try {
                    if (consultas.editar(modelo)) {
                        JOptionPane.showMessageDialog(null, "¡Cliente actualizado exitosamente!", "¡Logrado!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al actualizar el cliente!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "¡Cliente no válido!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            if (vista.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Debe ingresar el ID del cliente para eliminar!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "¡Cliente eliminado exitosamente!", "¡Logrado!", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                poblarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar el cliente!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            if (vista.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Debe ingresar el ID del cliente para buscar!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if (consultas.buscar(modelo)) {
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtDescripcion.setText(modelo.getDescripcion());
                vista.txtDireccion.setText(modelo.getDireccion());
                vista.txtTelefono.setText(modelo.getTelefono());
                vista.txtRuc.setText(modelo.getTelefono());
            } else {
                JOptionPane.showMessageDialog(null, "¡Cliente no encontrado!", "¡Error!", JOptionPane.ERROR_MESSAGE);
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
        vista.txtRuc.setText(null);
    }

    private boolean validarCampos() {
        return !vista.txtId.getText().isEmpty() &&
               !vista.txtDescripcion.getText().isEmpty() &&
               !vista.txtDireccion.getText().isEmpty() &&
               !vista.txtTelefono.getText().isEmpty() &&
               !vista.txtRuc.getText().isEmpty();
    }
    
    private void poblarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tablaClientes.getModel();
        modeloTabla.setRowCount(0);
        List<Clientes> listaClientes = consultas.obtenerTodos();
        for (Clientes clientes : listaClientes) {
            modeloTabla.addRow(new Object[]{
                clientes.getId(),
                clientes.getDescripcion(),
                clientes.getDireccion(),
                clientes.getTelefono(),
                clientes.getRuc()
            });
        }
    }
}