package Vista;

import Controlador.ControlCliente;
import Controlador.ControlProducto;
import Controlador.ControlProveedores;
import Modelo.Clientes;
import Modelo.ConsultasCliente;
import Modelo.ConsultasProducto;
import Modelo.ConsultasProveedores;
import Modelo.Producto;
import Modelo.Proveedores;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URI;
import javax.swing.JOptionPane;

public class frmInicio extends javax.swing.JFrame {

    public frmInicio() {
        initComponents();
        setResizable(false);
        transparenciaButton();
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Icons/management.png")); //icon del frm
        this.setIconImage(icon);
        
        this.setTitle("Gestión de Formularios | By gamma");
        this.setLocationRelativeTo(null);
        this.setSize(470, 600);
    }
    
    private void abrirURL(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir la URL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void transparenciaButton() {
        btnProductos.setOpaque(false);
        btnProductos.setContentAreaFilled(false);
        btnProductos.setBorderPainted(false);
        btnClientes.setOpaque(false);
        btnClientes.setContentAreaFilled(false);
        btnClientes.setBorderPainted(false);
        btnProveedores.setOpaque(false);
        btnProveedores.setContentAreaFilled(false);
        btnProveedores.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        informacion = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        backgroundBtnProductos = new javax.swing.JLabel();
        btnClientes = new javax.swing.JButton();
        backgroundBtnClientes = new javax.swing.JLabel();
        btnProveedores = new javax.swing.JButton();
        backgroundBtnProveedores = new javax.swing.JLabel();
        copyright = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Formularios | By gamma");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(450, 570));
        setName("frmInicio"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("GESTIÓN DE FORMULARIOS");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 430, -1));

        informacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        informacion.setForeground(new java.awt.Color(255, 255, 255));
        informacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informacion.setText("<html><center>Centraliza la administración de funciones<p>clave para optimizar operaciones.<center><html>");
        getContentPane().add(informacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 350, 40));

        btnProductos.setBackground(new java.awt.Color(68, 182, 251));
        btnProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setFocusPainted(false);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        getContentPane().add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 230, 30));

        backgroundBtnProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundBtnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundBtnInicio.png"))); // NOI18N
        backgroundBtnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(backgroundBtnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 330, 50));

        btnClientes.setBackground(new java.awt.Color(68, 182, 251));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setText("Clientes");
        btnClientes.setBorder(null);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setFocusPainted(false);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 230, 30));

        backgroundBtnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundBtnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundBtnInicio.png"))); // NOI18N
        backgroundBtnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(backgroundBtnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 330, 50));

        btnProveedores.setBackground(new java.awt.Color(68, 182, 251));
        btnProveedores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorder(null);
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.setFocusPainted(false);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 230, 30));

        backgroundBtnProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundBtnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundBtnInicio.png"))); // NOI18N
        backgroundBtnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(backgroundBtnProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 330, 50));

        copyright.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        copyright.setForeground(new java.awt.Color(255, 255, 255));
        copyright.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copyright.setText("Copyright © 2024 | Developed by gamma");
        copyright.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyright.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                copyrightMousePressed(evt);
            }
        });
        getContentPane().add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 450, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backgroundInicio.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 470, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        Producto modelo = new Producto();
        ConsultasProducto consulta = new ConsultasProducto();
        frmProducto vista = new frmProducto();

        ControlProducto ctrl = new ControlProducto(modelo, consulta, vista);
        ctrl.iniciar();
        
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        Clientes modelo = new Clientes();
        ConsultasCliente consulta = new ConsultasCliente();
        frmCliente vista = new frmCliente();

        ControlCliente ctrl = new ControlCliente(modelo, consulta, vista);
        ctrl.iniciar();
        
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        Proveedores modelo = new Proveedores();
        ConsultasProveedores consulta = new ConsultasProveedores();
        frmProveedores vista = new frmProveedores();

        ControlProveedores ctrl = new ControlProveedores(modelo, consulta, vista);
        ctrl.iniciar();
    
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void copyrightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMousePressed
        abrirURL("https://github.com/gamma-ok");
    }//GEN-LAST:event_copyrightMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmInicio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel backgroundBtnClientes;
    private javax.swing.JLabel backgroundBtnProductos;
    private javax.swing.JLabel backgroundBtnProveedores;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}