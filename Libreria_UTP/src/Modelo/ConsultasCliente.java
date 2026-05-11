package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasCliente extends Conexion {

    public boolean guardar(Clientes clie) {
        String sql = "INSERT INTO clientes (id, descripcion, direccion, telefono, ruc) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, clie.getId());
            ps.setString(2, clie.getDescripcion());
            ps.setString(3, clie.getDireccion());
            ps.setString(4, clie.getTelefono());
            ps.setString(5, clie.getRuc());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean editar(Clientes clie) {
        String sql = "UPDATE clientes SET descripcion=?, direccion=?, telefono=?, ruc=? WHERE id=?";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, clie.getDescripcion());
            ps.setString(2, clie.getDireccion());
            ps.setString(3, clie.getTelefono());
            ps.setString(4, clie.getRuc());
            ps.setInt(5, clie.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean eliminar(Clientes clie) {
        String sql = "DELETE FROM clientes WHERE id=?";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, clie.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean buscar(Clientes clie) {
        String sql = "SELECT * FROM clientes WHERE id=?";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, clie.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    clie.setId(rs.getInt("id"));
                    clie.setDescripcion(rs.getString("descripcion"));
                    clie.setDireccion(rs.getString("direccion"));
                    clie.setTelefono(rs.getString("telefono"));
                    clie.setRuc(rs.getString("ruc"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
    
    public List<Clientes> obtenerTodos() {
        List<Clientes> listaClientes = new ArrayList<>();
        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM clientes");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Clientes clientes = new Clientes();
                clientes.setId(rs.getInt("id"));
                clientes.setDescripcion(rs.getString("descripcion"));
                clientes.setDireccion(rs.getString("direccion"));
                clientes.setTelefono(rs.getString("telefono"));
                clientes.setRuc(rs.getString("ruc"));
                listaClientes.add(clientes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
}