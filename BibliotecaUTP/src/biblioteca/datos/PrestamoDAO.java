package biblioteca.datos;

import biblioteca.modelo.Usuario;
import biblioteca.modelo.LibroLite;
import biblioteca.modelo.Prestamo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO extends ConexionDB {

    public boolean registrar(Prestamo p) {
        String sql = "INSERT INTO prestamos (idUsuario, idLibro, fechaPrestamo, fechaDevolucion, estado, montoPagado) VALUES (?,?,?,?,?,?)";
        Connection conn = null;
        try {
            conn = conectar();
            conn.setAutoCommit(false);

            // Registrar el préstamo
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, p.getUsuario().getIdUsuario());
                ps.setInt(2, p.getLibro().getIdLibro());
                ps.setDate(3, Date.valueOf(p.getFechaPrestamo()));
                ps.setDate(4, Date.valueOf(p.getFechaDevolucion()));
                ps.setString(5, p.getEstado());
                ps.setDouble(6, p.getMontoPagado());
                ps.executeUpdate();
            }

            // Disminuir el stock del libro
            String sqlUpdate = "UPDATE libros SET cantidad = cantidad - 1 WHERE idLibro = ? AND cantidad > 0";
            try (PreparedStatement ps2 = conn.prepareStatement(sqlUpdate)) {
                ps2.setInt(1, p.getLibro().getIdLibro());
                int filasActualizadas = ps2.executeUpdate();
                
                if (filasActualizadas == 0) {
                    throw new SQLException("No hay stock disponible para este libro");
                }
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

    public boolean modificar(Prestamo p) {
        String sql = "UPDATE prestamos SET idUsuario=?, idLibro=?, fechaPrestamo=?, fechaDevolucion=?, estado=?, montoPagado=? WHERE idPrestamo=?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getUsuario().getIdUsuario());
            ps.setInt(2, p.getLibro().getIdLibro());
            ps.setDate(3, Date.valueOf(p.getFechaPrestamo()));
            ps.setDate(4, Date.valueOf(p.getFechaDevolucion()));
            ps.setString(5, p.getEstado());
            ps.setDouble(6, p.getMontoPagado());
            ps.setInt(7, p.getIdPrestamo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM prestamos WHERE idPrestamo = ?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Prestamo> listar() {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT p.idPrestamo, p.idUsuario, p.idLibro, p.fechaPrestamo, "
                + "p.fechaDevolucion, p.estado, p.montoPagado, "
                + "u.dni, l.isbn "
                + "FROM prestamos p "
                + "INNER JOIN usuarios u ON p.idUsuario = u.idUsuario "
                + "INNER JOIN libros l ON p.idLibro = l.idLibro";

        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Prestamo p = new Prestamo(
                        rs.getInt("idPrestamo"),
                        new Usuario(rs.getInt("idUsuario"), rs.getString("dni")),
                        new LibroLite(rs.getInt("idLibro"), rs.getString("isbn")),
                        rs.getDate("fechaPrestamo").toLocalDate(),
                        rs.getDate("fechaDevolucion").toLocalDate(),
                        rs.getString("estado"),
                        rs.getDouble("montoPagado")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para devolver un libro (actualizar stock y estado)
    public boolean devolverLibro(int idPrestamo) {
        String sqlGetPrestamo = "SELECT idLibro FROM prestamos WHERE idPrestamo = ?";
        String sqlUpdatePrestamo = "UPDATE prestamos SET estado = 'Devuelto' WHERE idPrestamo = ?";
        String sqlUpdateStock = "UPDATE libros SET cantidad = cantidad + 1 WHERE idLibro = ?";

        Connection conn = null;
        try {
            conn = conectar();
            conn.setAutoCommit(false);

            // Obtener el idLibro del préstamo
            int idLibro = 0;
            try (PreparedStatement ps1 = conn.prepareStatement(sqlGetPrestamo)) {
                ps1.setInt(1, idPrestamo);
                try (ResultSet rs = ps1.executeQuery()) {
                    if (rs.next()) {
                        idLibro = rs.getInt("idLibro");
                    } else {
                        throw new SQLException("Préstamo no encontrado");
                    }
                }
            }

            // Actualizar estado del préstamo
            try (PreparedStatement ps2 = conn.prepareStatement(sqlUpdatePrestamo)) {
                ps2.setInt(1, idPrestamo);
                ps2.executeUpdate();
            }

            // Actualizar stock del libro
            try (PreparedStatement ps3 = conn.prepareStatement(sqlUpdateStock)) {
                ps3.setInt(1, idLibro);
                ps3.executeUpdate();
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
}