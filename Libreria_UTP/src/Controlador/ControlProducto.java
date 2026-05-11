package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ControlProducto implements ActionListener {
    private final Producto modelo;
    private final ConsultasProducto consultas;
    private final frmProducto vista;

    public ControlProducto(Producto modelo, ConsultasProducto consultas, frmProducto vista) {
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
        vista.setTitle("Gestión de Productos | By gamma");
        vista.setLocationRelativeTo(null);
        vista.setSize(745, 600);
        vista.id.setVisible(false);
        vista.txtId.setVisible(false);
        
        poblarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            if (validarCampos()) {
                modelo.setCodigo(vista.txtCodigo.getText());
                modelo.setNombre(vista.txtNombre.getText());
                modelo.setMarca(vista.txtMarca.getText());
                modelo.setModelo(vista.txtModelo.getText());
                try {
                    modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
                    modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));

                    if (consultas.guardar(modelo)) {
                        JOptionPane.showMessageDialog(null, "¡Producto guardado exitosamente!", "¡Logrado!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al guardar el producto!", "¡Error!", JOptionPane.ERROR_MESSAGE);;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "¡Precio o cantidad no válidos!", "¡Error!", JOptionPane.ERROR_MESSAGE);;
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == vista.btnEditar) {
            if (validarCampos()) {
                modelo.setId(Integer.parseInt(vista.txtId.getText()));
                modelo.setCodigo(vista.txtCodigo.getText());
                modelo.setNombre(vista.txtNombre.getText());
                modelo.setMarca(vista.txtMarca.getText());
                modelo.setModelo(vista.txtModelo.getText());
                modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
                modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
                try {
                    if (consultas.editar(modelo)) {
                        JOptionPane.showMessageDialog(null, "¡Producto actualizado exitosamente!", "¡Logrado!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al actualizar el producto!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "¡Precio, cantidad o ID no válidos!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            if (vista.txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Debe ingresar el código del cliente para eliminar!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            modelo.setCodigo(vista.txtCodigo.getText());

            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "¡Producto eliminado exitosamente!", "¡Logrado!", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                poblarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar el producto!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            if (vista.txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Debe ingresar el código del cliente para buscar!", "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            modelo.setCodigo(vista.txtCodigo.getText());

            if (consultas.buscar(modelo)) {
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtCodigo.setText(modelo.getCodigo());
                vista.txtNombre.setText(modelo.getNombre());
                vista.txtMarca.setText(modelo.getMarca());
                vista.txtModelo.setText(modelo.getModelo());
                vista.txtPrecio.setText(String.valueOf(modelo.getPrecio()));
                vista.txtCantidad.setText(String.valueOf(modelo.getCantidad()));
            } else {
                JOptionPane.showMessageDialog(null, "¡Producto no encontrado!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }

        if (e.getSource() == vista.btnNuevo) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.txtId.setText(null);
        vista.txtCodigo.setText(null);
        vista.txtNombre.setText(null);
        vista.txtMarca.setText(null);
        vista.txtModelo.setText(null);
        vista.txtPrecio.setText(null);
        vista.txtCantidad.setText(null);
    }

    private boolean validarCampos() {
        return !vista.txtCodigo.getText().isEmpty() &&
               !vista.txtNombre.getText().isEmpty() &&
               !vista.txtMarca.getText().isEmpty() &&
               !vista.txtModelo.getText().isEmpty() &&
               !vista.txtPrecio.getText().isEmpty() &&
               !vista.txtCantidad.getText().isEmpty();
    }
    
    private void poblarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tablaProductos.getModel();
        modeloTabla.setRowCount(0);
        List<Producto> listaProductos = consultas.obtenerTodos();
        for (Producto producto : listaProductos) {
            modeloTabla.addRow(new Object[]{
                producto.getCodigo(),
                producto.getNombre(),
                producto.getMarca(),
                producto.getModelo(),
                producto.getPrecio(),
                producto.getCantidad()
            });
        }
    }
}