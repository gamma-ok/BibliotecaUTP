package biblioteca.datos;

import biblioteca.modelo.Libro;
import biblioteca.modelo.Novela;
import biblioteca.modelo.LibroTexto;
import biblioteca.modelo.Enciclopedia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO extends ConexionDB {

    public boolean guardar(Libro l) {
        String sql = "INSERT INTO libros (isbn, titulo, autor, precioCompra, precioVenta, cantidad, anioPublicacion, tipoLibro) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getIsbn());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getAutor());
            ps.setDouble(4, l.getPrecioCompra());
            ps.setDouble(5, l.getPrecioVenta());
            ps.setInt(6, l.getCantidad());
            ps.setInt(7, l.getAnioPublicacion());
            ps.setString(8, l.getTipoLibro());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editar(Libro l) {
        String sql = "UPDATE libros SET titulo=?, autor=?, precioCompra=?, precioVenta=?, cantidad=?, anioPublicacion=?, tipoLibro=? WHERE isbn=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setDouble(3, l.getPrecioCompra());
            ps.setDouble(4, l.getPrecioVenta());
            ps.setInt(5, l.getCantidad());
            ps.setInt(6, l.getAnioPublicacion());
            ps.setString(7, l.getTipoLibro());
            ps.setString(8, l.getIsbn());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
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
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                String tipoLibro = rs.getString("tipoLibro");
                Libro libro = null;
                
                switch (tipoLibro) {
                    case "Novela":
                        libro = new Novela(
                            rs.getInt("idLibro"),
                            rs.getString("isbn"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getDouble("precioCompra"),
                            rs.getDouble("precioVenta"),
                            rs.getInt("cantidad"),
                            rs.getInt("anioPublicacion"),
                            rs.getString("tipoLibro"),
                            "General"  // Género por defecto
                        );
                        break;
                    case "LibroTexto":
                        libro = new LibroTexto(
                            rs.getInt("idLibro"),
                            rs.getString("isbn"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getDouble("precioCompra"),
                            rs.getDouble("precioVenta"),
                            rs.getInt("cantidad"),
                            rs.getInt("anioPublicacion"),
                            rs.getString("tipoLibro"),
                            "General"  // Nivel académico por defecto
                        );
                        break;
                    case "Enciclopedia":
                        libro = new Enciclopedia(
                            rs.getInt("idLibro"),
                            rs.getString("isbn"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getDouble("precioCompra"),
                            rs.getDouble("precioVenta"),
                            rs.getInt("cantidad"),
                            rs.getInt("anioPublicacion"),
                            rs.getString("tipoLibro"),
                            1  // Número de tomo por defecto
                        );
                        break;
                    default:
                        // Si no se reconoce el tipo, crear como Novela por defecto
                        libro = new Novela(
                            rs.getInt("idLibro"),
                            rs.getString("isbn"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getDouble("precioCompra"),
                            rs.getDouble("precioVenta"),
                            rs.getInt("cantidad"),
                            rs.getInt("anioPublicacion"),
                            rs.getString("tipoLibro"),
                            "General"
                        );
                        break;
                }
                lista.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean buscar(Libro l) {
        String sql = "SELECT * FROM libros WHERE isbn=?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, l.getIsbn());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    l.setTitulo(rs.getString("titulo"));
                    l.setAutor(rs.getString("autor"));
                    l.setPrecioCompra(rs.getDouble("precioCompra"));
                    l.setPrecioVenta(rs.getDouble("precioVenta"));
                    l.setCantidad(rs.getInt("cantidad"));
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

    // Método para actualizar el stock después de una compra
    public boolean actualizarCantidad(String isbn, int nuevaCantidad) {
        String sql = "UPDATE libros SET cantidad=? WHERE isbn=?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, nuevaCantidad);
            ps.setString(2, isbn);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener el precioCompra de un libro
    public double obtenerPrecioCompra(String isbn) {
        String sql = "SELECT precioCompra FROM libros WHERE isbn=?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, isbn);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("precioCompra");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}