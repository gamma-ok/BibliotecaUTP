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
import libreria.controlador.LibroController;
import libreria.modelo.LibroTexto;
import libreria.modelo.Novela;
import libreria.modelo.Enciclopedia;

public class frmGestionLibros extends javax.swing.JFrame {

    private LibroController controller;

    DefaultTableModel dtm = new DefaultTableModel();

    public frmGestionLibros() {
        initComponents();
        setResizable(false);
        transparenciaButton();
        txtIdLibro.setVisible(false);
        id.setVisible(false);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../recursos/products.png"));
        this.setIconImage(icon);

        String[] titulo = new String[]{"ISBN", "Tipo", "Título", "Autor", "Precio", "Stock", "Año"};
        dtm.setColumnIdentifiers(titulo);
        tablaGestionLibros.setModel(dtm);
        tablaGestionLibros.getTableHeader().setReorderingAllowed(false);
        tablaGestionLibros.setDefaultEditor(Object.class, null);

        centrarTabla();

        this.controller = controller;
    }

    private void abrirURL(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir la URL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiar() {
        txtIsbn.setText("");
        cbTipoLibro.setSelectedIndex(0);
        txtTitulo.setText("");
        txtAutor.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        dateAnioPublicacion.setYear(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR));
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
        JTableHeader header = tablaGestionLibros.getTableHeader();
        header.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        header.setForeground(Color.BLACK);
        header.setBackground(new Color(232, 240, 250));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablaGestionLibros.getColumnCount(); i++) {
            tablaGestionLibros.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloForm = new javax.swing.JLabel();
        infoForm = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        txtIdLibro = new javax.swing.JTextField();
        isbn = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        titulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        autor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        tipoLibro = new javax.swing.JLabel();
        cbTipoLibro = new javax.swing.JComboBox<>();
        precio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        stock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        anioPublicacion = new javax.swing.JLabel();
        dateAnioPublicacion = new com.toedter.calendar.JYearChooser();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tablaGestionLibros = new javax.swing.JTable();
        copyright = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Libros | By gamma");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 675));
        setName("frmProductos"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 675));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloForm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tituloForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloForm.setText("GESTIÓN DE LIBROS");
        getContentPane().add(tituloForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 900, 30));

        infoForm.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        infoForm.setText("Datos de Libro");
        getContentPane().add(infoForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setText("ID:");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 30, 20));

        txtIdLibro.setEditable(false);
        txtIdLibro.setBackground(new java.awt.Color(153, 153, 153));
        txtIdLibro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdLibro.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtIdLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 110, 20));

        isbn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        isbn.setText("ISBN:");
        getContentPane().add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 220, 20));

        txtIsbn.setBackground(new java.awt.Color(153, 153, 153));
        txtIsbn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIsbn.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 220, 20));

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo.setText("Título:");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 220, -1));

        txtTitulo.setBackground(new java.awt.Color(153, 153, 153));
        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 220, 20));

        autor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        autor.setText("Autor:");
        getContentPane().add(autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 150, -1));

        txtAutor.setBackground(new java.awt.Color(153, 153, 153));
        txtAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAutor.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 220, 20));

        tipoLibro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tipoLibro.setText("Tipo de Libro:");
        getContentPane().add(tipoLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 220, -1));

        cbTipoLibro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTipoLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "LibroTexto", "Novela", "Enciclopedia" }));
        getContentPane().add(cbTipoLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 220, 20));

        precio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        precio.setText("Precio");
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 220, -1));

        txtPrecio.setBackground(new java.awt.Color(153, 153, 153));
        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecio.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 220, 20));

        stock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stock.setText("Stock:");
        getContentPane().add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 220, -1));

        txtStock.setBackground(new java.awt.Color(153, 153, 153));
        txtStock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStock.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        getContentPane().add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 220, 20));

        anioPublicacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        anioPublicacion.setText("Año de Publicación:");
        getContentPane().add(anioPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 130, 20));
        getContentPane().add(dateAnioPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, 20));

        btnNuevo.setBackground(new java.awt.Color(68, 182, 251));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 80, 30));

        btnGuardar.setBackground(new java.awt.Color(68, 182, 251));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 80, 30));

        btnEditar.setBackground(new java.awt.Color(68, 182, 251));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 80, 30));

        btnEliminar.setBackground(new java.awt.Color(68, 182, 251));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 80, 30));

        btnBuscar.setBackground(new java.awt.Color(68, 182, 251));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 80, 30));

        btnVolver.setBackground(new java.awt.Color(51, 60, 78));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libreria/recursos/back.png"))); // NOI18N
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
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 40, 40));

        jScrollPane.setBorder(null);

        tablaGestionLibros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaGestionLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Tipo", "T´ítulo", "Autor", "Precio", "Stock", "Año"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGestionLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaGestionLibrosMousePressed(evt);
            }
        });
        jScrollPane.setViewportView(tablaGestionLibros);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 730, 190));

        copyright.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        copyright.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copyright.setText("Copyright © 2026 | Developed by gamma");
        copyright.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyright.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                copyrightMousePressed(evt);
            }
        });
        getContentPane().add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, 350, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuPrincipal volver = new MenuPrincipal();
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tablaGestionLibrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGestionLibrosMousePressed
        int row = tablaGestionLibros.getSelectedRow();
        if (row != -1) {
            txtIsbn.setText(tablaGestionLibros.getValueAt(row, 0).toString());
            cbTipoLibro.setSelectedItem(tablaGestionLibros.getValueAt(row, 1).toString());
            txtTitulo.setText(tablaGestionLibros.getValueAt(row, 2).toString());
            txtAutor.setText(tablaGestionLibros.getValueAt(row, 3).toString());
            txtPrecio.setText(tablaGestionLibros.getValueAt(row, 4).toString());
            txtStock.setText(tablaGestionLibros.getValueAt(row, 5).toString());
            int anio = Integer.parseInt(tablaGestionLibros.getValueAt(row, 6).toString());
            dateAnioPublicacion.setYear(anio);
        }
    }//GEN-LAST:event_tablaGestionLibrosMousePressed

    private void copyrightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMousePressed
        abrirURL("https://github.com/gamma-ok");
    }//GEN-LAST:event_copyrightMousePressed

    public void setController(LibroController controller) {
        this.controller = controller;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmGestionLibros().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anioPublicacion;
    private javax.swing.JLabel autor;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbTipoLibro;
    private javax.swing.JLabel copyright;
    public com.toedter.calendar.JYearChooser dateAnioPublicacion;
    public javax.swing.JLabel id;
    private javax.swing.JLabel infoForm;
    private javax.swing.JLabel isbn;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel stock;
    public javax.swing.JTable tablaGestionLibros;
    private javax.swing.JLabel tipoLibro;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel tituloForm;
    public javax.swing.JTextField txtAutor;
    public javax.swing.JTextField txtIdLibro;
    public javax.swing.JTextField txtIsbn;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtStock;
    public javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
