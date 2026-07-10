package biblioteca.datos;

import biblioteca.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends ConexionDB {

    public boolean guardar(Usuario c) {
        String sql = "INSERT INTO usuarios (nombre, apellido, dni, celular, correo, direccion) VALUES (?,?,?,?,?,?)";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getCelular());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getDireccion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean editar(Usuario c) {
        String sql = "UPDATE usuarios SET nombre=?, apellido=?, celular=?, correo=?, direccion=? WHERE dni=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getCelular());
            ps.setString(4, c.getCorreo());
            ps.setString(5, c.getDireccion());
            ps.setString(6, c.getDni());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Esto dirá si hay un error de SQL
            return false;
        }
    }

    public boolean eliminar(String dni) {
        String sql = "DELETE FROM usuarios WHERE dni=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario c = new Usuario(
                        rs.getInt("idUsuario"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"),
                        rs.getString("dni"), 
                        rs.getString("celular"), 
                        rs.getString("correo"), 
                        rs.getString("direccion"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Esto dirá si hay un error de SQL
        }
        return lista;
    }

    public boolean buscar(Usuario c) {
        String sql = "SELECT * FROM usuarios WHERE dni=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getDni());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c.setIdUsuario(rs.getInt("idUsuario"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellido(rs.getString("apellido"));
                    c.setCelular(rs.getString("celular"));
                    c.setCorreo(rs.getString("correo"));
                    c.setDireccion(rs.getString("direccion"));
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
