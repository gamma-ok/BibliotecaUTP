package libreria.vista;

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

public class frmGestionPrestamos extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();

    public frmGestionPrestamos() {
        initComponents();
        setResizable(false);
        transparenciaButton();
        txtIdPrestamo.setVisible(false);
        id.setVisible(false);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../recursos/iconLibreriaFrm.png"));
        this.setIconImage(icon);

        String[] titulo = new String[]{"ID", "Cliente", "Libro", "F. Préstamo", "F. Devolución", "Estado", "Monto"};
        dtm.setColumnIdentifiers(titulo);
        tGestionPrestamos.setModel(dtm);
        tGestionPrestamos.getTableHeader().setReorderingAllowed(false);
        tGestionPrestamos.setDefaultEditor(Object.class, null);

        centrarTabla();
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
        btnVolver.setOpaque(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorderPainted(false);
    }

    public void centrarTabla() {
        JTableHeader header = tGestionPrestamos.getTableHeader();
        header.setFont(new Font("Century Gothic", Font.BOLD, 14));
        header.setForeground(Color.BLACK);
        header.setBackground(new Color(250, 235, 215));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tGestionPrestamos.getColumnCount(); i++) {
            tGestionPrestamos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloForm = new javax.swing.JLabel();
        infoForm = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        txtIdPrestamo = new javax.swing.JTextField();
        codCliente = new javax.swing.JLabel();
        cbDniCliente = new javax.swing.JComboBox<>();
        isbnLibro = new javax.swing.JLabel();
        cbIsbnLibro = new javax.swing.JComboBox<>();
        fechaPrestamo = new javax.swing.JLabel();
        dtFechaPrestamo = new com.toedter.calendar.JDateChooser();
        fechaDevolucion = new javax.swing.JLabel();
        dtFechaDevolucion = new com.toedter.calendar.JDateChooser();
        estado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        montoPagado = new javax.swing.JLabel();
        txtMontoPagado = new javax.swing.JTextField();
        resumen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResumen = new javax.swing.JTextArea();
        btnNuevo = new javax.swing.JButton();
        bgBtnNuevo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        bgBtnGuardar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        bgBtnEditar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        bgBtnEliminar = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tGestionPrestamos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        copyright = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();
        bg2 = new javax.swing.JLabel();
        bg3 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Prestamos | By gamma");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(998, 800));
        setName("frmProductos"); // NOI18N
        setPreferredSize(new java.awt.Dimension(998, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloForm.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        tituloForm.setForeground(new java.awt.Color(255, 140, 5));
        tituloForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloForm.setText("Gestión de Prestamos");
        getContentPane().add(tituloForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 880, 60));

        infoForm.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        infoForm.setForeground(new java.awt.Color(255, 255, 255));
        infoForm.setText("Datos de Prestamo");
        getContentPane().add(infoForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        id.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("ID:");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 30, 20));

        txtIdPrestamo.setEditable(false);
        txtIdPrestamo.setBackground(new java.awt.Color(255, 255, 255));
        txtIdPrestamo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtIdPrestamo.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtIdPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 160, 20));

        codCliente.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        codCliente.setForeground(new java.awt.Color(255, 255, 255));
        codCliente.setText("DNI de Cliente:");
        getContentPane().add(codCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 190, 20));

        cbDniCliente.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cbDniCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        getContentPane().add(cbDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 190, 20));

        isbnLibro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        isbnLibro.setForeground(new java.awt.Color(255, 255, 255));
        isbnLibro.setText("ISBN de Libro:");
        getContentPane().add(isbnLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 190, -1));

        cbIsbnLibro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cbIsbnLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        getContentPane().add(cbIsbnLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 190, 20));

        fechaPrestamo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        fechaPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        fechaPrestamo.setText("Fecha de Prestamo:");
        getContentPane().add(fechaPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 190, -1));

        dtFechaPrestamo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        getContentPane().add(dtFechaPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 190, 20));

        fechaDevolucion.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        fechaDevolucion.setForeground(new java.awt.Color(255, 255, 255));
        fechaDevolucion.setText("Fecha de Devolución:");
        getContentPane().add(fechaDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 190, -1));

        dtFechaDevolucion.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        getContentPane().add(dtFechaDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 190, 20));

        estado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        estado.setForeground(new java.awt.Color(255, 255, 255));
        estado.setText("Estado:");
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 190, -1));

        cbEstado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Activo", "Devuelto", "Vencido" }));
        getContentPane().add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 190, 20));

        montoPagado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        montoPagado.setForeground(new java.awt.Color(255, 255, 255));
        montoPagado.setText("Monto Pagado:");
        getContentPane().add(montoPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 190, -1));

        txtMontoPagado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtMontoPagado.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtMontoPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 190, 20));

        resumen.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        resumen.setForeground(new java.awt.Color(255, 255, 255));
        resumen.setText("Resumen:");
        getContentPane().add(resumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 260, -1));

        taResumen.setEditable(false);
        taResumen.setColumns(20);
        taResumen.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        taResumen.setRows(5);
        jScrollPane1.setViewportView(taResumen);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 260, 140));

        btnNuevo.setBackground(new java.awt.Color(255, 140, 5));
        btnNuevo.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/clean.png"))); // NOI18N
        btnNuevo.setText(" Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 130, 40));

        bgBtnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 130, 40));

        btnGuardar.setBackground(new java.awt.Color(255, 140, 5));
        btnGuardar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/save.png"))); // NOI18N
        btnGuardar.setText(" Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 130, 40));

        bgBtnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 130, 40));

        btnEditar.setBackground(new java.awt.Color(255, 140, 5));
        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/edit.png"))); // NOI18N
        btnEditar.setText(" Editar");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 130, 40));

        bgBtnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnEditar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 130, 40));

        btnEliminar.setBackground(new java.awt.Color(255, 140, 5));
        btnEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/delete.png"))); // NOI18N
        btnEliminar.setText(" Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 130, 40));

        bgBtnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 130, 40));

        jScrollPane.setBorder(null);

        tGestionPrestamos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tGestionPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Libro", "F. Préstamo", "F. Devolución", "Estado", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tGestionPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tGestionPrestamosMousePressed(evt);
            }
        });
        jScrollPane.setViewportView(tGestionPrestamos);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 820, 190));

        btnVolver.setBackground(new java.awt.Color(38, 38, 38));
        btnVolver.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgVolver.png"))); // NOI18N
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
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 710, 40, 40));

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
        getContentPane().add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 720, 290, 30));

        bg1.setForeground(new java.awt.Color(255, 255, 255));
        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 880, 60));

        bg2.setForeground(new java.awt.Color(255, 255, 255));
        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 880, 250));

        bg3.setForeground(new java.awt.Color(255, 255, 255));
        bg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgBoxFrm.png"))); // NOI18N
        getContentPane().add(bg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 880, 230));

        bg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/bgFrm.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1000, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuPrincipal volver = new MenuPrincipal();
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void abrirURL(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir la URL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void copyrightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMousePressed
        abrirURL("https://github.com/gamma-ok");
    }//GEN-LAST:event_copyrightMousePressed

    private void tGestionPrestamosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tGestionPrestamosMousePressed
        int row = tGestionPrestamos.getSelectedRow();
        if (row != -1) {
            txtIdPrestamo.setText(tGestionPrestamos.getValueAt(row, 0).toString());
            cbDniCliente.setSelectedItem(tGestionPrestamos.getValueAt(row, 1).toString());
            cbIsbnLibro.setSelectedItem(tGestionPrestamos.getValueAt(row, 2).toString());
            try {
                // Mismo formato que de la tabla (dd/MM/yyyy)
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

                String fechaP = tGestionPrestamos.getValueAt(row, 3).toString();
                String fechaD = tGestionPrestamos.getValueAt(row, 4).toString();

                java.time.LocalDate ldP = java.time.LocalDate.parse(fechaP, formatter);
                java.time.LocalDate ldD = java.time.LocalDate.parse(fechaD, formatter);

                // Convertir LocalDate a java.util.Date para el JDateChooser
                dtFechaPrestamo.setDate(java.sql.Date.valueOf(ldP));
                dtFechaDevolucion.setDate(java.sql.Date.valueOf(ldD));

            } catch (Exception e) {
                System.err.println("Error al parsear fechas: " + e.getMessage());
                e.printStackTrace();
            }
            cbEstado.setSelectedItem(tGestionPrestamos.getValueAt(row, 5).toString());
            txtMontoPagado.setText(tGestionPrestamos.getValueAt(row, 6).toString());
        }
    }//GEN-LAST:event_tGestionPrestamosMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmGestionPrestamos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel bg3;
    private javax.swing.JLabel bgBtnEditar;
    private javax.swing.JLabel bgBtnEliminar;
    private javax.swing.JLabel bgBtnGuardar;
    private javax.swing.JLabel bgBtnNuevo;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbDniCliente;
    public javax.swing.JComboBox<String> cbEstado;
    public javax.swing.JComboBox<String> cbIsbnLibro;
    private javax.swing.JLabel codCliente;
    private javax.swing.JLabel copyright;
    public com.toedter.calendar.JDateChooser dtFechaDevolucion;
    public com.toedter.calendar.JDateChooser dtFechaPrestamo;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel fechaDevolucion;
    private javax.swing.JLabel fechaPrestamo;
    public javax.swing.JLabel id;
    private javax.swing.JLabel infoForm;
    private javax.swing.JLabel isbnLibro;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel montoPagado;
    private javax.swing.JLabel resumen;
    public javax.swing.JTable tGestionPrestamos;
    public javax.swing.JTextArea taResumen;
    private javax.swing.JLabel tituloForm;
    public javax.swing.JTextField txtIdPrestamo;
    public javax.swing.JTextField txtMontoPagado;
    // End of variables declaration//GEN-END:variables
}
