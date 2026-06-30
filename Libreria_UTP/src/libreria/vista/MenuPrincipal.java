package libreria.vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URI;
import javax.swing.JOptionPane;
import libreria.controlador.ClienteController;
import libreria.controlador.LibroController;
import libreria.controlador.PrestamoController;
import libreria.datos.ClienteDAO;
import libreria.datos.LibroDAO;
import libreria.datos.PrestamoDAO;
import libreria.modelo.Cliente;
import libreria.modelo.Libro;
import libreria.modelo.Novela;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
        setResizable(false);
        transparenciaButton();

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../recursos/iconLibreriaFrm.png")); //icon del frm
        this.setIconImage(icon);

        this.setLocationRelativeTo(null);
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

        tituloForm = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        btnGestionLibros = new javax.swing.JButton();
        bgBtnGestionLibros = new javax.swing.JLabel();
        btnGestionClientes = new javax.swing.JButton();
        bgBtnGestionClientes = new javax.swing.JLabel();
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
        setMinimumSize(new java.awt.Dimension(543, 800));
        setName("frmInicio"); // NOI18N
        setPreferredSize(new java.awt.Dimension(543, 800));
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

        btnGestionLibros.setBackground(new java.awt.Color(255, 140, 5));
        btnGestionLibros.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        btnGestionLibros.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/iconGestionLibros.png"))); // NOI18N
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
        getContentPane().add(btnGestionLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 280, 50));

        bgBtnGestionLibros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBtnMenuFrm.png"))); // NOI18N
        bgBtnGestionLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 420, 70));

        btnGestionClientes.setBackground(new java.awt.Color(255, 140, 5));
        btnGestionClientes.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        btnGestionClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/iconGestionClientes.png"))); // NOI18N
        btnGestionClientes.setText(" Gestión de Clientes");
        btnGestionClientes.setBorder(null);
        btnGestionClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionClientes.setFocusPainted(false);
        btnGestionClientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGestionClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 280, 50));

        bgBtnGestionClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBtnMenuFrm.png"))); // NOI18N
        bgBtnGestionClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 420, 70));

        btnGestionPrestamos.setBackground(new java.awt.Color(255, 140, 5));
        btnGestionPrestamos.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        btnGestionPrestamos.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/iconGestionPrestamos.png"))); // NOI18N
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
        getContentPane().add(btnGestionPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 280, 50));

        bgBtnGestionPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBtnMenuFrm.png"))); // NOI18N
        bgBtnGestionPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 420, 70));

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
        getContentPane().add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 720, -1, 30));

        bg1.setForeground(new java.awt.Color(255, 255, 255));
        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 420, 60));

        bg2.setForeground(new java.awt.Color(255, 255, 255));
        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 420, 80));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgFrm.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 550, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionLibrosActionPerformed
        // Instanciar el modelo, el DAO a la vista
        // Clase hija Novela como instancia para el modelo
        Libro modelo = new Novela(0, "", "", "", 0.0, 0, 2026, "Novela", "General");
        LibroDAO dao = new LibroDAO();
        frmGestionLibros vista = new frmGestionLibros();

        // Instanciar el controlador
        LibroController ctrl = new LibroController(modelo, dao, vista);

        // Mostrar frm
        vista.setVisible(true);
        vista.setLocationRelativeTo(null); // Centrar frm
        this.dispose(); // Cerrar vista actual
    }//GEN-LAST:event_btnGestionLibrosActionPerformed

    private void btnGestionClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionClientesActionPerformed
        // Instanciar el modelo, el DAO a la vista
        // Datos vacíos iniciales para el cliente
        Cliente modelo = new Cliente(0, "", "", "", "", "", "");
        ClienteDAO dao = new ClienteDAO();
        frmGestionClientes vista = new frmGestionClientes();

        // Instanciar el controlador
        ClienteController ctrl = new ClienteController(modelo, dao, vista);

        // Mostrar frm
        vista.setVisible(true);
        vista.setLocationRelativeTo(null); // Centrar frm
        this.dispose(); // Cerrar vista actual
    }//GEN-LAST:event_btnGestionClientesActionPerformed

    private void btnGestionPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPrestamosActionPerformed
        // Instanciamos vista
        frmGestionPrestamos vistaPrestamos = new frmGestionPrestamos();

        // Instanciar los DAOs
        PrestamoDAO pDao = new PrestamoDAO();
        ClienteDAO cDao = new ClienteDAO();
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
        abrirURL("https://github.com/gamma-ok");
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
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel bgBtnGestionClientes;
    private javax.swing.JLabel bgBtnGestionLibros;
    private javax.swing.JLabel bgBtnGestionPrestamos;
    private javax.swing.JButton btnGestionClientes;
    private javax.swing.JButton btnGestionLibros;
    private javax.swing.JButton btnGestionPrestamos;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel info;
    private javax.swing.JLabel tituloForm;
    // End of variables declaration//GEN-END:variables
}
