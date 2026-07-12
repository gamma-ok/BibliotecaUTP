package biblioteca.vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URI;
import javax.swing.JOptionPane;
import biblioteca.controlador.UsuarioController;
import biblioteca.controlador.LibroController;
import biblioteca.controlador.PrestamoController;
import biblioteca.controlador.ProveedorController;
import biblioteca.controlador.CompraProveedorController;
import biblioteca.datos.UsuarioDAO;
import biblioteca.datos.LibroDAO;
import biblioteca.datos.PrestamoDAO;
import biblioteca.datos.ProveedorDAO;
import biblioteca.datos.CompraProveedorDAO;
import biblioteca.modelo.Usuario;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Novela;
import biblioteca.modelo.Proveedor;
import biblioteca.modelo.CompraProveedor;
import java.time.LocalDate;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
        setResizable(false);
        transparenciaButton();

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../recursos/iconBibliotecaFrm.png")); //icon del frm
        this.setIconImage(icon);

        this.setLocationRelativeTo(null);
    }

    public void transparenciaButton() {
        btnGestionProveedores.setOpaque(false);
        btnGestionProveedores.setContentAreaFilled(false);
        btnGestionProveedores.setBorderPainted(false);
        btnGestionCompras.setOpaque(false);
        btnGestionCompras.setContentAreaFilled(false);
        btnGestionCompras.setBorderPainted(false);
        btnGestionLibros.setOpaque(false);
        btnGestionLibros.setContentAreaFilled(false);
        btnGestionLibros.setBorderPainted(false);
        btnGestionUsuarios.setOpaque(false);
        btnGestionUsuarios.setContentAreaFilled(false);
        btnGestionUsuarios.setBorderPainted(false);
        btnGestionPrestamos.setOpaque(false);
        btnGestionPrestamos.setContentAreaFilled(false);
        btnGestionPrestamos.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloForm = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        btnGestionProveedores = new javax.swing.JButton();
        bgBtnGestionProveedores = new javax.swing.JLabel();
        btnGestionCompras = new javax.swing.JButton();
        bgBtnGestionCompras = new javax.swing.JLabel();
        btnGestionLibros = new javax.swing.JButton();
        bgBtnGestionLibros = new javax.swing.JLabel();
        btnGestionUsuarios = new javax.swing.JButton();
        bgBtnGestionUsuarios = new javax.swing.JLabel();
        btnGestionPrestamos = new javax.swing.JButton();
        bgBtnGestionPrestamos = new javax.swing.JLabel();
        copyright = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();
        bg2 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal | By gamma");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frmMenuPrincipal"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloForm.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        tituloForm.setForeground(new java.awt.Color(255, 140, 5));
        tituloForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloForm.setText("Menú Principal");
        getContentPane().add(tituloForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 420, 60));

        info.setBackground(new java.awt.Color(255, 255, 255));
        info.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        info.setForeground(new java.awt.Color(255, 255, 255));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("<html><center>Centraliza la administración de funciones<p>clave para optimizar operaciones.<center><html>");
        getContentPane().add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 420, 80));

        btnGestionProveedores.setBackground(new java.awt.Color(255, 140, 5));
        btnGestionProveedores.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        btnGestionProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/iconGestionProveedores.png"))); // NOI18N
        btnGestionProveedores.setText(" Gestión de Proveedores");
        btnGestionProveedores.setBorder(null);
        btnGestionProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionProveedores.setFocusPainted(false);
        btnGestionProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGestionProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionProveedoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 280, 50));

        bgBtnGestionProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnMenuFrm.png"))); // NOI18N
        bgBtnGestionProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 420, 70));

        btnGestionCompras.setBackground(new java.awt.Color(255, 140, 5));
        btnGestionCompras.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        btnGestionCompras.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/iconGestionCompras.png"))); // NOI18N
        btnGestionCompras.setText(" Gestión de Compras");
        btnGestionCompras.setBorder(null);
        btnGestionCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionCompras.setFocusPainted(false);
        btnGestionCompras.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGestionCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionComprasActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 280, 50));

        bgBtnGestionCompras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnMenuFrm.png"))); // NOI18N
        bgBtnGestionCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 420, 70));

        btnGestionLibros.setBackground(new java.awt.Color(255, 140, 5));
        btnGestionLibros.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        btnGestionLibros.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/iconGestionLibros.png"))); // NOI18N
        btnGestionLibros.setText(" Gestión de Libros");
        btnGestionLibros.setBorder(null);
        btnGestionLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionLibros.setFocusPainted(false);
        btnGestionLibros.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGestionLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionLibrosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 280, 50));

        bgBtnGestionLibros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnMenuFrm.png"))); // NOI18N
        bgBtnGestionLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 420, 70));

        btnGestionUsuarios.setBackground(new java.awt.Color(255, 140, 5));
        btnGestionUsuarios.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        btnGestionUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/iconGestionClientes.png"))); // NOI18N
        btnGestionUsuarios.setText(" Gestión de Usuarios");
        btnGestionUsuarios.setBorder(null);
        btnGestionUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionUsuarios.setFocusPainted(false);
        btnGestionUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, 280, 50));

        bgBtnGestionUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnMenuFrm.png"))); // NOI18N
        bgBtnGestionUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 420, 70));

        btnGestionPrestamos.setBackground(new java.awt.Color(255, 140, 5));
        btnGestionPrestamos.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        btnGestionPrestamos.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/iconGestionPrestamos.png"))); // NOI18N
        btnGestionPrestamos.setText(" Gestión de Préstamos");
        btnGestionPrestamos.setBorder(null);
        btnGestionPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionPrestamos.setFocusPainted(false);
        btnGestionPrestamos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGestionPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPrestamosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 670, 280, 50));

        bgBtnGestionPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnMenuFrm.png"))); // NOI18N
        bgBtnGestionPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 420, 70));

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
        getContentPane().add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 790, -1, 30));

        bg1.setForeground(new java.awt.Color(255, 255, 255));
        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 420, 60));

        bg2.setForeground(new java.awt.Color(255, 255, 255));
        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 420, 80));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgFrm.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 560, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionLibrosActionPerformed
        // Instanciar el modelo, el DAO a la vista
        // Clase hija Novela como instancia para el modelo
        Libro modelo = new Novela(0, "", "", "", 0.0, 0.0, 0, 2026, "Novela", "General");
        LibroDAO dao = new LibroDAO();
        frmGestionLibros vista = new frmGestionLibros();

        // Instanciar el controlador
        LibroController ctrl = new LibroController(modelo, dao, vista);

        // Mostrar frm
        vista.setVisible(true);
        vista.setLocationRelativeTo(null); // Centrar frm
        this.dispose(); // Cerrar vista actual
    }//GEN-LAST:event_btnGestionLibrosActionPerformed

    private void btnGestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionUsuariosActionPerformed
        // Instanciar el modelo, el DAO a la vista
        // Datos vacíos iniciales para el cliente
        Usuario modelo = new Usuario(0, "", "", "", "", "", "");
        UsuarioDAO dao = new UsuarioDAO();
        frmGestionUsuarios vista = new frmGestionUsuarios();

        // Instanciar el controlador
        UsuarioController ctrl = new UsuarioController(modelo, dao, vista);

        // Mostrar frm
        vista.setVisible(true);
        vista.setLocationRelativeTo(null); // Centrar frm
        this.dispose(); // Cerrar vista actual
    }//GEN-LAST:event_btnGestionUsuariosActionPerformed

    private void btnGestionPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPrestamosActionPerformed
        // Instanciamos vista
        frmGestionPrestamos vistaPrestamos = new frmGestionPrestamos();

        // Instanciar los DAOs
        PrestamoDAO pDao = new PrestamoDAO();
        UsuarioDAO cDao = new UsuarioDAO();
        LibroDAO lDao = new LibroDAO();

        // Instanciar controlador
        // Llenado del combo box en el frm
        new PrestamoController(vistaPrestamos, cDao, lDao);

        // Mostrar frm
        vistaPrestamos.setVisible(true);
        vistaPrestamos.setLocationRelativeTo(null); // Centrar frm
        this.dispose(); // Cerrar vista actual
    }//GEN-LAST:event_btnGestionPrestamosActionPerformed

    private void copyrightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMousePressed
        abrirURL("https://github.com/gamma-ok/BibliotecaUTP");
    }//GEN-LAST:event_copyrightMousePressed

    private void btnGestionProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionProveedoresActionPerformed
        // Instanciar el modelo, el DAO a la vista
        // Datos vacíos iniciales para el cliente
        Proveedor modelo = new Proveedor(0, "", "", "", "", "", "");
        ProveedorDAO dao = new ProveedorDAO();
        frmGestionProveedores vista = new frmGestionProveedores();

        // Instanciar el controlador
        ProveedorController ctrl = new ProveedorController(modelo, dao, vista);

        // Mostrar frm
        vista.setVisible(true);
        vista.setLocationRelativeTo(null); // Centrar frm
        this.dispose(); // Cerrar vista actual
    }//GEN-LAST:event_btnGestionProveedoresActionPerformed

    private void btnGestionComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionComprasActionPerformed
        // Instanciamos vista
        frmGestionCompras vistaCompras = new frmGestionCompras();

        // Instanciar los DAOs
        CompraProveedorDAO pDao = new CompraProveedorDAO();
        ProveedorDAO cDao = new ProveedorDAO();
        LibroDAO lDao = new LibroDAO();

        // Instanciar controlador
        // Llenado del combo box en el frm
        new CompraProveedorController(vistaCompras, cDao, lDao);

        // Mostrar frm
        vistaCompras.setVisible(true);
        vistaCompras.setLocationRelativeTo(null); // Centrar frm
        this.dispose(); // Cerrar vista actual
    }//GEN-LAST:event_btnGestionComprasActionPerformed

    private void abrirURL(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir la URL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel bgBtnGestionCompras;
    private javax.swing.JLabel bgBtnGestionLibros;
    private javax.swing.JLabel bgBtnGestionPrestamos;
    private javax.swing.JLabel bgBtnGestionProveedores;
    private javax.swing.JLabel bgBtnGestionUsuarios;
    private javax.swing.JButton btnGestionCompras;
    private javax.swing.JButton btnGestionLibros;
    private javax.swing.JButton btnGestionPrestamos;
    private javax.swing.JButton btnGestionProveedores;
    private javax.swing.JButton btnGestionUsuarios;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel info;
    private javax.swing.JLabel tituloForm;
    // End of variables declaration//GEN-END:variables
}
