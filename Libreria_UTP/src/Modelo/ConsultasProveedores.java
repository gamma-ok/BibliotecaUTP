package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasProveedores extends Conexion {

    public boolean guardar(Proveedores prov) {
        String sql = "INSERT INTO proveedores (id, descripcion, direccion, telefono) VALUES(?, ?, ?, ?)";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, prov.getId());
            ps.setString(2, prov.getDescripcion());
            ps.setString(3, prov.getDireccion());
            ps.setString(4, prov.getTelefono());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean editar(Proveedores prov) {
        String sql = "UPDATE proveedores SET descripcion=?, direccion=?, telefono=? WHERE id=?";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, prov.getDescripcion());
            ps.setString(2, prov.getDireccion());
            ps.setString(3, prov.getTelefono());
            ps.setInt(4, prov.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean eliminar(Proveedores prov) {
        String sql = "DELETE FROM proveedores WHERE id=?";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, prov.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean buscar(Proveedores prov) {
        String sql = "SELECT * FROM proveedores WHERE id=?";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, prov.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    prov.setId(rs.getInt("id"));
                    prov.setDescripcion(rs.getString("descripcion"));
                    prov.setDireccion(rs.getString("direccion"));
                    prov.setTelefono(rs.getString("telefono"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
    
    public List<Proveedores> obtenerTodos() {
        List<Proveedores> listaProveedoreses = new ArrayList<>();
        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM proveedores");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proveedores proveedores = new Proveedores();
                proveedores.setId(rs.getInt("id"));
                proveedores.setDescripcion(rs.getString("descripcion"));
                proveedores.setDireccion(rs.getString("direccion"));
                proveedores.setTelefono(rs.getString("telefono"));
                listaProveedoreses.add(proveedores);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProveedoreses;
    }
}