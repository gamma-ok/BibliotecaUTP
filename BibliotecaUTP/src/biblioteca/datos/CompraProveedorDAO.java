package biblioteca.datos;

import biblioteca.modelo.Proveedor;
import biblioteca.modelo.LibroLite; // no se si sea necesario, ya que LibroLite es la clase hija de Libro, pero en este caso no se si sirva
import biblioteca.modelo.CompraProveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraProveedorDAO extends ConexionDB {

    public boolean registrar(CompraProveedor cp) {
        String sql = "INSERT INTO compras_proveedor (idProveedor, idLibro, fechaEntrega, cantidad, precioUnitario, montoTotal) VALUES (?,?,?,?,?,?)";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cp.getProveedor().getIdProveedor());
            ps.setInt(2, cp.getLibro().getIdLibro());
            ps.setDate(3, Date.valueOf(cp.getFechaEntrega()));
            ps.setInt(4, cp.getCantidad());
            ps.setDouble(5, cp.getPrecioUnitario());
            ps.setDouble(6, cp.getMontoTotal());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modificar(CompraProveedor cp) {
        String sql = "UPDATE compras_proveedor SET idProveedor=?, idLibro=?, fechaEntrega=?, cantidad=?, precioUnitario=?, montoTotal=? WHERE idCompra=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cp.getProveedor().getIdProveedor());
            ps.setInt(2, cp.getLibro().getIdLibro());
            ps.setDate(3, Date.valueOf(cp.getFechaEntrega()));
            ps.setInt(4, cp.getCantidad());
            ps.setDouble(5, cp.getPrecioUnitario());
            ps.setDouble(6, cp.getMontoTotal());
            ps.setInt(7, cp.getIdCompra());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM compras_proveedor WHERE idCompra = ?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<CompraProveedor> listar() {
        List<CompraProveedor> lista = new ArrayList<>();
        String sql = "SELECT cp.idCompra, cp.idProveedor, cp.idLibro, cp.fechaEntrega, "
                + "cp.cantidad, cp.precioUnitario, cp.montoTotal, "
                + "p.ruc, l.isbn "
                + "FROM compras_proveedor cp "
                + "INNER JOIN proveedores p ON cp.idProveedor = p.idProveedor "
                + "INNER JOIN libros l ON cp.idLibro = l.idLibro";

        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Aquí usamos los valores obtenidos del JOIN
                CompraProveedor cp = new CompraProveedor(
                        rs.getInt("idCompra"),
                        new Proveedor(rs.getInt("idProveedor"), rs.getString("ruc")),
                        new LibroLite(rs.getInt("idLibro"), rs.getString("isbn")),
                        rs.getDate("fechaEntrega").toLocalDate(),
                        rs.getInt("cantidad"),
                        rs.getDouble("precioUnitario")
                );
                lista.add(cp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}