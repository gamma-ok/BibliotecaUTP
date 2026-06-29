package libreria.datos;

import libreria.modelo.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrestamoDAO {

    public boolean registrarPrestamo(String dni, String isbn, int dias) {
        String sql = "INSERT INTO prestamos (dni_cliente, isbn_libro, dias_prestamo, fecha_prestamo, estado) VALUES (?, ?, ?, NOW(), 'Prestado')";
        try (Connection conn = ConexionDB.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            ps.setString(2, isbn);
            ps.setInt(3, dias);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar prestamo DAO: " + e.getMessage());
            return false;
        }
    }
}