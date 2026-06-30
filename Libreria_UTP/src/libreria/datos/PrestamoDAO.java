package libreria.datos;

import libreria.modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO extends ConexionDB {

    public boolean registrar(Prestamo p) {
        String sql = "INSERT INTO prestamos (idCliente, idLibro, fechaPrestamo, fechaDevolucion, estado, montoPagado) VALUES (?,?,?,?,?,?)";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getCliente().getIdCliente());
            ps.setInt(2, p.getLibro().getIdLibro());
            ps.setDate(3, Date.valueOf(p.getFechaPrestamo()));
            ps.setDate(4, Date.valueOf(p.getFechaDevolucion()));
            ps.setString(5, p.getEstado());
            ps.setDouble(6, p.getMontoPagado());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modificar(Prestamo p) {
        String sql = "UPDATE prestamos SET idCliente=?, idLibro=?, fechaPrestamo=?, fechaDevolucion=?, estado=?, montoPagado=? WHERE idPrestamo=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getCliente().getIdCliente());
            ps.setInt(2, p.getLibro().getIdLibro());
            ps.setDate(3, Date.valueOf(p.getFechaPrestamo()));
            ps.setDate(4, Date.valueOf(p.getFechaDevolucion()));
            ps.setString(5, p.getEstado());
            ps.setDouble(6, p.getMontoPagado());
            ps.setInt(7, p.getIdPrestamo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM prestamos WHERE idPrestamo = ?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Prestamo> listar() {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT p.idPrestamo, p.idCliente, p.idLibro, p.fechaPrestamo, "
                + "p.fechaDevolucion, p.estado, p.montoPagado, "
                + "c.dni, l.isbn "
                + "FROM prestamos p "
                + "INNER JOIN clientes c ON p.idCliente = c.idCliente "
                + "INNER JOIN libros l ON p.idLibro = l.idLibro";

        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Aquí usamos los valores obtenidos del JOIN
                Prestamo p = new Prestamo(
                        rs.getInt("idPrestamo"),
                        new Cliente(rs.getInt("idCliente"), rs.getString("dni")),
                        new LibroLite(rs.getInt("idLibro"), rs.getString("isbn")),
                        rs.getDate("fechaPrestamo").toLocalDate(),
                        rs.getDate("fechaDevolucion").toLocalDate(),
                        rs.getString("estado"),
                        rs.getDouble("montoPagado")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error en listar prestamos: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
}
