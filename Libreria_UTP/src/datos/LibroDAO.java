package Datos;

import Modelo.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    // Método para insertar cualquier tipo de libro (Polimorfismo aplicado)
    public boolean insertar(Libro libro) {
        String sql = "INSERT INTO libros (isbn, titulo, autor, precio, stock, anioPublicacion, tipoLibro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setDouble(4, libro.getPrecio());
            ps.setInt(5, libro.getStock());
            ps.setInt(6, libro.getAnioPublicacion());
            ps.setString(7, libro.getTipoLibro());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar libro: " + e.getMessage());
            return false;
        }
    }

    // Método para listar todos los libros
    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                // Aquí es donde más adelante instanciarás el objeto real 
                // basándote en la columna 'tipoLibro'
                System.out.println("Libro encontrado: " + rs.getString("titulo"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar libros: " + e.getMessage());
        }
        return lista;
    }
}