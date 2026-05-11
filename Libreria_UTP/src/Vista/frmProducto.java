package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URI;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class frmProducto extends javax.swing.JFrame {
    
    DefaultTableModel dtm = new DefaultTableModel();
    

    public frmProducto() {
        initComponents();
        setResizable(false);
        transparenciaButton();
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Icons/products.png"));
        this.setIconImage(icon);

        String[] titulo = new String[] {"Código", "Nombre", "Marca", "Modelo", "Precio", "Cantidad"};
        dtm.setColumnIdentifiers(titulo);
        tablaProductos.setModel(dtm);
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        tablaProductos.setDefaultEditor(Object.class, null);
        
        centrarTabla();
    }
    
    private void abrirURL(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir la URL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    void guardar() {
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();
        String precio = txtPrecio.getText().trim();
        String cantidad = txtCantidad.getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || marca.isEmpty() || modelo.isEmpty() || precio.isEmpty() || cantidad.isEmpty()) {
            return;
        }

        dtm.addRow(new Object[]{codigo, nombre, marca, modelo, precio, cantidad});
        limpiar();
    }
    
    void editar() {
        int fila = tablaProductos.getSelectedRow();   
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();
        String precio = txtPrecio.getText().trim();
        String cantidad = txtCantidad.getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || marca.isEmpty() || modelo.isEmpty() || precio.isEmpty() || cantidad.isEmpty()) {
            return;
        }

        dtm.setValueAt(codigo, fila, 0);
        dtm.setValueAt(nombre, fila, 1);
        dtm.setValueAt(marca, fila, 2);
        dtm.setValueAt(modelo, fila, 3);
        dtm.setValueAt(precio, fila, 4);
        dtm.setValueAt(cantidad, fila, 5);

        limpiar();
    }
    
    void eliminar() {
        int filaSeleccionada = tablaProductos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            dtm.removeRow(filaSeleccionada);
            limpiar();
        }
    }
    
    public void limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }
    
    public void transparenciaButton() {
        btnNuevo.setOpaque(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setBorderPainted(false);
        btnGuardar.setOpaque(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setBorderPainted(false);
        btnEditar.setOpaque(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.setBorderPainted(false);
        btnEliminar.setOpaque(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setBorderPainted(false);
        btnBuscar.setOpaque(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setBorderPainted(false);
        btnVolver.setOpaque(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorderPainted(false);
    }
    
    public void centrarTabla() {
        JTableHeader header = tablaProductos.getTableHeader();
        header.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        header.setForeground(Color.BLACK);
        header.setBackground(new Color(232, 240, 250));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablaProductos.getColumnCount(); i++) {
            tablaProductos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        informacion = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        codigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        marca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        modelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        precio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        cantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        backgroundBtnNuevo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        backgroundBtnGuardar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        backgroundBtnEditar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        backgroundBtnEliminar = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        backgroundBtnBuscar = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        copyright = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Productos | By gamma");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(715, 525));
        setName("frmProductos"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("GESTIÓN DE PRODUCTOS");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 710, -1));

        informacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        informacion.setForeground(new java.awt.Color(255, 255, 255));
        informacion.setText("Datos de Producto");
        getContentPane().add(informacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("ID:");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 30, 20));

        txtId.setBackground(new java.awt.Color(232, 240, 250));
        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtId.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 110, 20));

        codigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codigo.setForeground(new java.awt.Color(255, 255, 255));
        codigo.setText("Código:");
        getContentPane().add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 110, 20));

        txtCodigo.setBackground(new java.awt.Color(232, 240, 250));
        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 110, 20));

        nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("Nombre:");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 230, -1));

        txtNombre.setBackground(new java.awt.Color(232, 240, 250));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 230, 20));

        marca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        marca.setForeground(new java.awt.Color(255, 255, 255));
        marca.setText("Marca:");
        getContentPane().add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 220, -1));

        txtMarca.setBackground(new java.awt.Color(232, 240, 250));
        txtMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMarca.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 220, 20));

        modelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modelo.setForeground(new java.awt.Color(255, 255, 255));
        modelo.setText("Modelo:");
        getContentPane().add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 230, -1));

        txtModelo.setBackground(new java.awt.Color(232, 240, 250));
        txtModelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtModelo.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 20));

        precio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        precio.setForeground(new java.awt.Color(255, 255, 255));
        precio.setText("Precio");
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 170, -1));

        txtPrecio.setBackground(new java.awt.Color(232, 240, 250));
        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecio.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 170, 20));

        cantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cantidad.setForeground(new java.awt.Color(255, 255, 255));
        cantidad.setText("Cantidad:");
        getContentPane().add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 170, -1));

        txtCantidad.setBackground(new java.awt.Color(232, 240, 250));
        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 170, 20));

        btnNuevo.setBackground(new java.awt.Color(68, 182, 251));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/new.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 80, 110));

        backgroundBtnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundBtnProductos.png"))); // NOI18N
        backgroundBtnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(backgroundBtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 80, 110));

        btnGuardar.setBackground(new java.awt.Color(68, 182, 251));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 80, 110));

        backgroundBtnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundBtnProductos.png"))); // NOI18N
        backgroundBtnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(backgroundBtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 80, 110));

        btnEditar.setBackground(new java.awt.Color(68, 182, 251));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 80, 110));

        backgroundBtnEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundBtnProductos.png"))); // NOI18N
        backgroundBtnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(backgroundBtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 80, 110));

        btnEliminar.setBackground(new java.awt.Color(68, 182, 251));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 80, 110));

        backgroundBtnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundBtnProductos.png"))); // NOI18N
        backgroundBtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(backgroundBtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 80, 110));

        btnBuscar.setBackground(new java.awt.Color(68, 182, 251));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 80, 110));

        backgroundBtnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundBtnProductos.png"))); // NOI18N
        backgroundBtnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(backgroundBtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 80, 110));

        btnVolver.setBackground(new java.awt.Color(51, 60, 78));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        btnVolver.setBorder(null);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setFocusable(false);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVolver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 40, 40));

        jScrollPane.setBorder(null);

        tablaProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Marca", "Modelo", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
        });
        jScrollPane.setViewportView(tablaProductos);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 640, 130));

        copyright.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        copyright.setForeground(new java.awt.Color(255, 255, 255));
        copyright.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copyright.setText("Copyright © 2024 | Developed by gamma");
        copyright.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                copyrightMousePressed(evt);
            }
        });
        getContentPane().add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 360, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundInicio.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 740, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmInicio volver = new frmInicio();
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed
        JTable table = (JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);

        if (evt.getClickCount() == 1) {
            txtCodigo.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0).toString());
            txtNombre.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 1).toString());
            txtMarca.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2).toString());
            txtModelo.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 3).toString());
            txtPrecio.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 4).toString());
            txtCantidad.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_tablaProductosMousePressed

    private void copyrightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMousePressed
        abrirURL("https://github.com/gamma-ok");
    }//GEN-LAST:event_copyrightMousePressed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmProducto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel backgroundBtnBuscar;
    private javax.swing.JLabel backgroundBtnEditar;
    private javax.swing.JLabel backgroundBtnEliminar;
    private javax.swing.JLabel backgroundBtnGuardar;
    private javax.swing.JLabel backgroundBtnNuevo;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel cantidad;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel copyright;
    public javax.swing.JLabel id;
    private javax.swing.JLabel informacion;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel marca;
    private javax.swing.JLabel modelo;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel precio;
    public javax.swing.JTable tablaProductos;
    private javax.swing.JLabel titulo;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtMarca;
    public javax.swing.JTextField txtModelo;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}