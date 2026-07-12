package biblioteca.datos;

import biblioteca.modelo.Proveedor;
import biblioteca.modelo.LibroLite;
import biblioteca.modelo.CompraProveedor;
import biblioteca.modelo.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraProveedorDAO extends ConexionDB {

    public boolean registrar(CompraProveedor cp) {
        String sql = "INSERT INTO compras_proveedor (idProveedor, idLibro, fechaCompra, cantidad, precioCompraUnitario, montoTotal) VALUES (?,?,?,?,?,?)";
        Connection conn = null;
        try {
            conn = conectar();
            conn.setAutoCommit(false);

            // 1. Registrar la compra
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, cp.getProveedor().getIdProveedor());
                ps.setInt(2, cp.getLibro().getIdLibro());
                ps.setDate(3, Date.valueOf(cp.getFechaCompra()));
                ps.setInt(4, cp.getCantidad());
                ps.setDouble(5, cp.getPrecioCompraUnitario());
                ps.setDouble(6, cp.getMontoTotal());
                ps.executeUpdate();
            }

            // 2. Actualizar el stock del libro
            LibroDAO libroDAO = new LibroDAO();
            Libro libro = cp.getLibro();
            int nuevaCantidad = libro.getCantidad() + cp.getCantidad();
            
            // Actualizar el precioCompra promedio
            double precioCompraActual = libro.getPrecioCompra();
            int cantidadActual = libro.getCantidad();
            double nuevoPrecioCompra = 0;
            
            if (cantidadActual == 0) {
                nuevoPrecioCompra = cp.getPrecioCompraUnitario();
            } else {
                nuevoPrecioCompra = (precioCompraActual * cantidadActual + cp.getPrecioCompraUnitario() * cp.getCantidad()) 
                                    / (cantidadActual + cp.getCantidad());
            }

            String sqlUpdate = "UPDATE libros SET cantidad=?, precioCompra=? WHERE idLibro=?";
            try (PreparedStatement ps2 = conn.prepareStatement(sqlUpdate)) {
                ps2.setInt(1, nuevaCantidad);
                ps2.setDouble(2, nuevoPrecioCompra);
                ps2.setInt(3, cp.getLibro().getIdLibro());
                ps2.executeUpdate();
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            e.printStackTrace();
            return false;
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public boolean modificar(CompraProveedor cp) {
        String sql = "UPDATE compras_proveedor SET idProveedor=?, idLibro=?, fechaCompra=?, cantidad=?, precioCompraUnitario=?, montoTotal=? WHERE idCompra=?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cp.getProveedor().getIdProveedor());
            ps.setInt(2, cp.getLibro().getIdLibro());
            ps.setDate(3, Date.valueOf(cp.getFechaCompra()));
            ps.setInt(4, cp.getCantidad());
            ps.setDouble(5, cp.getPrecioCompraUnitario());
            ps.setDouble(6, cp.getMontoTotal());
            ps.setInt(7, cp.getIdCompra());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM compras_proveedor WHERE idCompra = ?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<CompraProveedor> listar() {
        List<CompraProveedor> lista = new ArrayList<>();
        String sql = "SELECT cp.idCompra, cp.idProveedor, cp.idLibro, cp.fechaCompra, "
                + "cp.cantidad, cp.precioCompraUnitario, cp.montoTotal, "
                + "p.ruc, l.isbn "
                + "FROM compras_proveedor cp "
                + "INNER JOIN proveedores p ON cp.idProveedor = p.idProveedor "
                + "INNER JOIN libros l ON cp.idLibro = l.idLibro";

        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CompraProveedor cp = new CompraProveedor(
                        rs.getInt("idCompra"),
                        new Proveedor(rs.getInt("idProveedor"), rs.getString("ruc")),
                        new LibroLite(rs.getInt("idLibro"), rs.getString("isbn")),
                        rs.getDate("fechaCompra").toLocalDate(),
                        rs.getInt("cantidad"),
                        rs.getDouble("precioCompraUnitario")
                );
                lista.add(cp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}