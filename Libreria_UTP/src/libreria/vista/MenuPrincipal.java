package libreria.vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URI;
import javax.swing.JOptionPane;
import libreria.controlador.LibroController;
import libreria.datos.LibroDAO;
import libreria.modelo.Libro;
import libreria.modelo.Novela;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
        setResizable(false);
        transparenciaButton();
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../recursos/management.png")); //icon del frm
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
        btnGestionLibros.setOpaque(false);
        btnGestionLibros.setContentAreaFilled(false);
        btnGestionLibros.setBorderPainted(false);
        btnGestionClientes.setOpaque(false);
        btnGestionClientes.setContentAreaFilled(false);
        btnGestionClientes.setBorderPainted(false);
        btnGestionPrestamos.setOpaque(false);
        btnGestionPrestamos.setContentAreaFilled(false);
        btnGestionPrestamos.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        informacion = new javax.swing.JLabel();
        btnGestionLibros = new javax.swing.JButton();
        bgBtnGestionLibros = new javax.swing.JLabel();
        btnGestionClientes = new javax.swing.JButton();
        bgBtnGestionClientes = new javax.swing.JLabel();
        btnGestionPrestamos = new javax.swing.JButton();
        bgBtnGestionPrestamos = new javax.swing.JLabel();
        copyright = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

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

        btnGestionLibros.setBackground(new java.awt.Color(68, 182, 251));
        btnGestionLibros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGestionLibros.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionLibros.setText("Gestión de Libros");
        btnGestionLibros.setBorder(null);
        btnGestionLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionLibros.setFocusPainted(false);
        btnGestionLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionLibrosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 230, 30));

        bgBtnGestionLibros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/backgroundBtnInicio.png"))); // NOI18N
        bgBtnGestionLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 330, 50));

        btnGestionClientes.setBackground(new java.awt.Color(68, 182, 251));
        btnGestionClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGestionClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionClientes.setText("Gestión de Clientes");
        btnGestionClientes.setBorder(null);
        btnGestionClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionClientes.setFocusPainted(false);
        btnGestionClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 230, 30));

        bgBtnGestionClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/backgroundBtnInicio.png"))); // NOI18N
        bgBtnGestionClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 330, 50));

        btnGestionPrestamos.setBackground(new java.awt.Color(68, 182, 251));
        btnGestionPrestamos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGestionPrestamos.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionPrestamos.setText("Gestión de Préstamos");
        btnGestionPrestamos.setBorder(null);
        btnGestionPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionPrestamos.setFocusPainted(false);
        btnGestionPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPrestamosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 230, 30));

        bgBtnGestionPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/backgroundBtnInicio.png"))); // NOI18N
        bgBtnGestionPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 330, 50));

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

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/backgroundInicio.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 470, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionLibrosActionPerformed
        // 1. Instanciamos el modelo, el DAO y la vista
        // Usamos Novela como instancia concreta para el modelo
        Libro modelo = new Novela(0, "", "", "", 0.0, 0, 2026, "Novela", "General");
        LibroDAO dao = new LibroDAO();
        frmGestionLibros vista = new frmGestionLibros();

        // 2. Instanciamos el controlador
        LibroController ctrl = new LibroController(modelo, dao, vista);

        // 3. Mostramos la vista
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnGestionLibrosActionPerformed

    private void btnGestionClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionClientesActionPerformed
        //Clientes modelo = new Clientes();
        //ConsultasCliente consulta = new ConsultasCliente();
        //frmGestionClientes vista = new frmGestionClientes();

        //ControlCliente ctrl = new ControlCliente(modelo, consulta, vista);
        //ctrl.iniciar();
        
        //vista.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_btnGestionClientesActionPerformed

    private void btnGestionPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPrestamosActionPerformed
        //Proveedores modelo = new Proveedores();
        //ConsultasProveedores consulta = new ConsultasProveedores();
        //frmGestionPrestamos vista = new frmGestionPrestamos();

        //ControlProveedores ctrl = new ControlProveedores(modelo, consulta, vista);
        //ctrl.iniciar();
    
        //vista.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_btnGestionPrestamosActionPerformed

    private void copyrightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMousePressed
        abrirURL("https://github.com/gamma-ok");
    }//GEN-LAST:event_copyrightMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bgBtnGestionClientes;
    private javax.swing.JLabel bgBtnGestionLibros;
    private javax.swing.JLabel bgBtnGestionPrestamos;
    private javax.swing.JButton btnGestionClientes;
    private javax.swing.JButton btnGestionLibros;
    private javax.swing.JButton btnGestionPrestamos;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}