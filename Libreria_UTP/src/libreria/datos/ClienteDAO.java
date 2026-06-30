package libreria.datos;

import libreria.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends ConexionDB {

    public boolean guardar(Cliente c) {
        String sql = "INSERT INTO clientes (nombre, apellido, dni, celular, email, direccion) VALUES (?,?,?,?,?,?)";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getCelular());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getDireccion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Esto dirá si hay un error de SQL
            return false;
        }
    }

    public boolean editar(Cliente c) {
        String sql = "UPDATE clientes SET nombre=?, apellido=?, celular=?, email=?, direccion=? WHERE dni=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getCelular());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getDireccion());
            ps.setString(6, c.getDni());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Esto dirá si hay un error de SQL
            return false;
        }
    }

    public boolean eliminar(String dni) {
        String sql = "DELETE FROM clientes WHERE dni=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente(rs.getInt("idCliente"), rs.getString("nombre"), rs.getString("apellido"),
                                        rs.getString("dni"), rs.getString("celular"), rs.getString("email"), rs.getString("direccion"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Esto dirá si hay un error de SQL
        }
        return lista;
    }

    public boolean buscar(Cliente c) {
        String sql = "SELECT * FROM clientes WHERE dni=?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getDni());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c.setIdCliente(rs.getInt("idCliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellido(rs.getString("apellido"));
                    c.setCelular(rs.getString("celular"));
                    c.setEmail(rs.getString("email"));
                    c.setDireccion(rs.getString("direccion"));
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }
}