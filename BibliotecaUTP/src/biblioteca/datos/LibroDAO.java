package biblioteca.datos;

import biblioteca.modelo.Libro;
import biblioteca.modelo.Novela;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO extends ConexionDB {

    public boolean guardar(Libro l) {
        String sql = "INSERT INTO libros (isbn, titulo, autor, precio, stock, anioPublicacion, tipoLibro) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getIsbn());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getAutor());
            ps.setDouble(4, l.getPrecio());
            ps.setInt(5, l.getStock());
            ps.setInt(6, l.getAnioPublicacion());
            ps.setString(7, l.getTipoLibro());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Esto dirá si hay un error de SQL
            return false;
        }
    }

    public boolean editar(Libro l) {
        String sql = "UPDATE libros SET titulo=?, autor=?, precio=?, stock=?, anioPublicacion=?, tipoLibro=? WHERE isbn=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setDouble(3, l.getPrecio());
            ps.setInt(4, l.getStock());
            ps.setInt(5, l.getAnioPublicacion());
            ps.setString(6, l.getTipoLibro());
            ps.setString(7, l.getIsbn());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Esto dirá si hay un error de SQL
            return false;
        }
    }

    public boolean eliminar(String isbn) {
        String sql = "DELETE FROM libros WHERE isbn=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, isbn);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                // Instanciación según el tipo (puedes expandir esto según tu lógica)
                Libro l = new Novela(rs.getInt("idLibro"), rs.getString("isbn"), rs.getString("titulo"),
                        rs.getString("autor"), rs.getDouble("precio"), rs.getInt("stock"),
                        rs.getInt("anioPublicacion"), rs.getString("tipoLibro"), "General");
                lista.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Esto dirá si hay un error de SQL
        }
        return lista;
    }

    public boolean buscar(Libro l) {
        String sql = "SELECT * FROM libros WHERE isbn=?";
        // Cambio realizado aquí: de getConexion() a conectar()
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getIsbn());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    l.setTitulo(rs.getString("titulo"));
                    l.setAutor(rs.getString("autor"));
                    l.setPrecio(rs.getDouble("precio"));
                    l.setStock(rs.getInt("stock"));
                    l.setAnioPublicacion(rs.getInt("anioPublicacion"));
                    l.setTipoLibro(rs.getString("tipoLibro"));
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
