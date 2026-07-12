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

public class frmGestionCompras extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();

    public frmGestionCompras() {
        initComponents();
        setResizable(false);
        transparenciaButton();
        txtIdCompra.setVisible(false);
        id.setVisible(false);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../recursos/iconBibliotecaFrm.png"));
        this.setIconImage(icon);

        String[] titulo = new String[]{"ID", "Proveedor", "Libro", "F. Compra", "Cantidad", "Precio", "Total"};
        dtm.setColumnIdentifiers(titulo);
        tGestionCompras.setModel(dtm);
        tGestionCompras.getTableHeader().setReorderingAllowed(false);
        tGestionCompras.setDefaultEditor(Object.class, null);

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
        JTableHeader header = tGestionCompras.getTableHeader();
        header.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        header.setForeground(Color.BLACK);
        header.setBackground(new Color(250, 235, 215));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tGestionCompras.getColumnCount(); i++) {
            tGestionCompras.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloForm = new javax.swing.JLabel();
        infoForm = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        txtIdCompra = new javax.swing.JTextField();
        rucProveedor = new javax.swing.JLabel();
        cbRucProveedor = new javax.swing.JComboBox<>();
        isbnLibro = new javax.swing.JLabel();
        cbIsbnLibro = new javax.swing.JComboBox<>();
        fechaCompra = new javax.swing.JLabel();
        dtFechaCompra = new com.toedter.calendar.JDateChooser();
        cantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        precioUnitario = new javax.swing.JLabel();
        txtPrecioCompraUnitario = new javax.swing.JTextField();
        montoTotal = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        informacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taInformacion = new javax.swing.JTextArea();
        btnNuevo = new javax.swing.JButton();
        bgBtnNuevo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        bgBtnGuardar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        bgBtnEditar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        bgBtnEliminar = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tGestionCompras = new javax.swing.JTable();
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
        tituloForm.setText("Gestión de Compras");
        getContentPane().add(tituloForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 880, 60));

        infoForm.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        infoForm.setForeground(new java.awt.Color(255, 255, 255));
        infoForm.setText("Datos de Compra");
        getContentPane().add(infoForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        id.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("ID:");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 30, 20));

        txtIdCompra.setEditable(false);
        txtIdCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtIdCompra.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtIdCompra.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtIdCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 160, 20));

        rucProveedor.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rucProveedor.setForeground(new java.awt.Color(255, 255, 255));
        rucProveedor.setText("RUC de Proveedor:");
        getContentPane().add(rucProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 190, 20));

        cbRucProveedor.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cbRucProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        getContentPane().add(cbRucProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 190, 20));

        isbnLibro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        isbnLibro.setForeground(new java.awt.Color(255, 255, 255));
        isbnLibro.setText("ISBN de Libro:");
        getContentPane().add(isbnLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 190, 20));

        cbIsbnLibro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cbIsbnLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        getContentPane().add(cbIsbnLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 190, 20));

        fechaCompra.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        fechaCompra.setForeground(new java.awt.Color(255, 255, 255));
        fechaCompra.setText("Fecha de Compra:");
        getContentPane().add(fechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 190, -1));

        dtFechaCompra.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        getContentPane().add(dtFechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 190, 20));

        cantidad.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cantidad.setForeground(new java.awt.Color(255, 255, 255));
        cantidad.setText("Cantidad:");
        getContentPane().add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 190, -1));

        txtCantidad.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 190, 20));

        precioUnitario.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioUnitario.setForeground(new java.awt.Color(255, 255, 255));
        precioUnitario.setText("Precio de Compra Unitario:");
        getContentPane().add(precioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 190, -1));

        txtPrecioCompraUnitario.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtPrecioCompraUnitario.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtPrecioCompraUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 190, 20));

        montoTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        montoTotal.setForeground(new java.awt.Color(255, 255, 255));
        montoTotal.setText("Monto Total:");
        getContentPane().add(montoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 190, -1));

        txtMontoTotal.setEditable(false);
        txtMontoTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtMontoTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtMontoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 190, 20));

        informacion.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        informacion.setForeground(new java.awt.Color(255, 255, 255));
        informacion.setText("Información:");
        getContentPane().add(informacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 260, -1));

        taInformacion.setEditable(false);
        taInformacion.setColumns(20);
        taInformacion.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        taInformacion.setRows(5);
        jScrollPane1.setViewportView(taInformacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 260, 140));

        btnNuevo.setBackground(new java.awt.Color(255, 140, 5));
        btnNuevo.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/clean.png"))); // NOI18N
        btnNuevo.setText(" Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 130, 40));

        bgBtnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 130, 40));

        btnGuardar.setBackground(new java.awt.Color(255, 140, 5));
        btnGuardar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/save.png"))); // NOI18N
        btnGuardar.setText(" Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 130, 40));

        bgBtnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 130, 40));

        btnEditar.setBackground(new java.awt.Color(255, 140, 5));
        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/edit.png"))); // NOI18N
        btnEditar.setText(" Editar");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 130, 40));

        bgBtnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnEditar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 130, 40));

        btnEliminar.setBackground(new java.awt.Color(255, 140, 5));
        btnEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/delete.png"))); // NOI18N
        btnEliminar.setText(" Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 130, 40));

        bgBtnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bgBtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/recursos/bgBtnFrm.png"))); // NOI18N
        getContentPane().add(bgBtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 130, 40));

        jScrollPane.setBorder(null);

        tGestionCompras.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tGestionCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Proveedor", "Libro", "F. Compra", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tGestionCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tGestionComprasMousePressed(evt);
            }
        });
        jScrollPane.setViewportView(tGestionCompras);

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

    private void tGestionComprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tGestionComprasMousePressed
        int row = tGestionCompras.getSelectedRow();
        if (row != -1) {
            txtIdCompra.setText(tGestionCompras.getValueAt(row, 0).toString());
            cbRucProveedor.setSelectedItem(tGestionCompras.getValueAt(row, 1).toString());
            cbIsbnLibro.setSelectedItem(tGestionCompras.getValueAt(row, 2).toString());
            try {
                // Mismo formato que de la tabla (dd/MM/yyyy)
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

                String fechaC = tGestionCompras.getValueAt(row, 3).toString();

                java.time.LocalDate ldP = java.time.LocalDate.parse(fechaC, formatter);
                
                // Convertir LocalDate a java.util.Date para el JDateChooser
                dtFechaCompra.setDate(java.sql.Date.valueOf(ldP));

            } catch (Exception e) {
                System.err.println("Error al parsear fechas: " + e.getMessage());
                e.printStackTrace();
            }
            txtCantidad.setText(tGestionCompras.getValueAt(row, 4).toString());
            txtPrecioCompraUnitario.setText(tGestionCompras.getValueAt(row, 5).toString());
            txtMontoTotal.setText(tGestionCompras.getValueAt(row, 6).toString());
        }
    }//GEN-LAST:event_tGestionComprasMousePressed

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
            new frmGestionCompras().setVisible(true);
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
    private javax.swing.JLabel cantidad;
    public javax.swing.JComboBox<String> cbIsbnLibro;
    public javax.swing.JComboBox<String> cbRucProveedor;
    private javax.swing.JLabel copyright;
    public com.toedter.calendar.JDateChooser dtFechaCompra;
    private javax.swing.JLabel fechaCompra;
    public javax.swing.JLabel id;
    private javax.swing.JLabel infoForm;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel isbnLibro;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel montoTotal;
    private javax.swing.JLabel precioUnitario;
    private javax.swing.JLabel rucProveedor;
    public javax.swing.JTable tGestionCompras;
    public javax.swing.JTextArea taInformacion;
    private javax.swing.JLabel tituloForm;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtIdCompra;
    public javax.swing.JTextField txtMontoTotal;
    public javax.swing.JTextField txtPrecioCompraUnitario;
    // End of variables declaration//GEN-END:variables
}
