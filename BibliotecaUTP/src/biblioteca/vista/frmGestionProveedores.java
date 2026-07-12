package biblioteca.vista;

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
import biblioteca.controlador.ProveedorController;

public class frmGestionProveedores extends javax.swing.JFrame {

    private ProveedorController controller;

    DefaultTableModel dtm = new DefaultTableModel();

    public frmGestionProveedores() {
        initComponents();
        setResizable(false);
        transparenciaButton();
        txtIdProveedor.setVisible(false);
        id.setVisible(false);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../recursos/iconBibliotecaFrm.png"));
        this.setIconImage(icon);

        String[] titulo = new String[]{"Nombre", "Apellido", "Teléfono", "Correo", "RUC", "Dirección"};
        dtm.setColumnIdentifiers(titulo);
        tGestionProveedores.setModel(dtm);
        tGestionProveedores.getTableHeader().setReorderingAllowed(false);
        tGestionProveedores.setDefaultEditor(Object.class, null);

        centrarTabla();

        this.controller = controller;
    }

    public void setController(ProveedorController controller) {
        this.controller = controller;
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
        JTableHeader header = tGestionProveedores.getTableHeader();
        header.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        header.setForeground(Color.BLACK);
        header.setBackground(new Color(250, 235, 215));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tGestionProveedores.getColumnCount(); i++) {
            tGestionProveedores.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloForm = new javax.swing.JLabel();
        infoForm = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        apellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        telefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        correo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        ruc = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        direccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        bgBtnNuevo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        bgBtnGuardar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        bgBtnEditar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        bgBtnEliminar = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        bgBtnBuscar = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tGestionProveedores = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        copyright = new javax.swing.JLabel();
        bg2 = new javax.swing.JLabel();
        bg3 = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Clientes | By gamma");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("frmProductos"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloForm.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        tituloForm.setForeground(new java.awt.Color(255, 140, 5));
        tituloForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloForm.setText("Gestión de Proveedores");
        getContentPane().add(tituloForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 880, 60));

        infoForm.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        infoForm.setForeground(new java.awt.Color(255, 255, 255));
        infoForm.setText("Datos de Proveedor");
        getContentPane().add(infoForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        id.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("ID:");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 30, 20));

        txtIdProveedor.setEditable(false);
        txtIdProveedor.setBackground(new java.awt.Color(255, 255, 255));
        txtIdProveedor.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtIdProveedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 310, 20));

        nombre.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("Nombre:");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 340, 20));

        txtNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 340, 20));

        apellido.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        apellido.setForeground(new java.awt.Color(255, 255, 255));
        apellido.setText("Apellido:");
        getContentPane().add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 340, -1));

        txtApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 340, 20));

        telefono.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        telefono.setForeground(new java.awt.Color(255, 255, 255));
        telefono.setText("Teléfono:");
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 340, -1));

        txtTelefono.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 340, 20));

        correo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        correo.setForeground(new java.awt.Color(255, 255, 255));
        correo.setText("Correo:");
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 340, -1));

        txtCorreo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtCorreo.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 340, 20));

        ruc.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ruc.setForeground(new java.awt.Color(255, 255, 255));
        ruc.setText("RUC:");
        getContentPane().add(ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 340, -1));

        txtRuc.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtRuc.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 340, 20));

        direccion.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        direccion.setForeground(new java.awt.Color(255, 255, 255));
        direccion.setText("Dirección:");
        getContentPane().add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 340, -1));

        txtDireccion.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 340, 20));

        btnNuevo.setBackground(new java.awt.Color(255, 140, 5));
        btnNuevo.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/clean.png"))); // NOI18N
        btnNuevo.setText(" Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 130, 40));

        bgBtnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 130, 40));

        btnGuardar.setBackground(new java.awt.Color(255, 140, 5));
        btnGuardar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/save.png"))); // NOI18N
        btnGuardar.setText(" Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 130, 40));

        bgBtnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 130, 40));

        btnEditar.setBackground(new java.awt.Color(255, 140, 5));
        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/edit.png"))); // NOI18N
        btnEditar.setText(" Editar");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 130, 40));

        bgBtnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnEditar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 130, 40));

        btnEliminar.setBackground(new java.awt.Color(255, 140, 5));
        btnEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/delete.png"))); // NOI18N
        btnEliminar.setText(" Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 130, 40));

        bgBtnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 130, 40));

        btnBuscar.setBackground(new java.awt.Color(255, 140, 5));
        btnBuscar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/search.png"))); // NOI18N
        btnBuscar.setText(" Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 410, 130, 40));

        bgBtnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 410, 130, 40));

        jScrollPane.setBorder(null);

        tGestionProveedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tGestionProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Teléfono", "Correo", "RUC", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tGestionProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tGestionProveedoresMousePressed(evt);
            }
        });
        jScrollPane.setViewportView(tGestionProveedores);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 820, 240));

        btnVolver.setBackground(new java.awt.Color(38, 38, 38));
        btnVolver.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgVolver.png"))); // NOI18N
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
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, 50, 40));

        copyright.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        copyright.setForeground(new java.awt.Color(255, 255, 255));
        copyright.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copyright.setText("Copyright © 2026 | Developed by gamma");
        copyright.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyright.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                copyrightMousePressed(evt);
            }
        });
        getContentPane().add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 790, 290, 30));

        bg2.setForeground(new java.awt.Color(255, 255, 255));
        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 880, 250));

        bg3.setForeground(new java.awt.Color(255, 255, 255));
        bg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 880, 280));

        bg1.setForeground(new java.awt.Color(255, 255, 255));
        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 880, 60));

        bg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgFrm.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1000, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tGestionProveedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tGestionProveedoresMousePressed
        int row = tGestionProveedores.getSelectedRow();
        if (row != -1) {
            txtNombre.setText(tGestionProveedores.getValueAt(row, 0).toString());
            txtApellido.setText(tGestionProveedores.getValueAt(row, 1).toString());
            txtTelefono.setText(tGestionProveedores.getValueAt(row, 2).toString());
            txtCorreo.setText(tGestionProveedores.getValueAt(row, 3).toString());
            txtRuc.setText(tGestionProveedores.getValueAt(row, 4).toString());
            txtDireccion.setText(tGestionProveedores.getValueAt(row, 5).toString());
        }
    }//GEN-LAST:event_tGestionProveedoresMousePressed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuPrincipal volver = new MenuPrincipal();
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void copyrightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMousePressed
        abrirURL("https://github.com/gamma-ok/BibliotecaUTP");
    }//GEN-LAST:event_copyrightMousePressed

    private void abrirURL(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir la URL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmGestionProveedores().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel bg3;
    private javax.swing.JLabel bgBtnBuscar;
    private javax.swing.JLabel bgBtnEditar;
    private javax.swing.JLabel bgBtnEliminar;
    private javax.swing.JLabel bgBtnGuardar;
    private javax.swing.JLabel bgBtnNuevo;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel direccion;
    public javax.swing.JLabel id;
    private javax.swing.JLabel infoForm;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel ruc;
    public javax.swing.JTable tGestionProveedores;
    private javax.swing.JLabel telefono;
    private javax.swing.JLabel tituloForm;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtIdProveedor;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtRuc;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
