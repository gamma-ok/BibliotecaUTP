package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasProducto extends Conexion {
    
    public boolean guardar(Producto pro) {
        String sql = "INSERT INTO producto (codigo, nombre, marca, modelo, precio, cantidad) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getMarca());
            ps.setString(4, pro.getModelo());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getCantidad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean editar(Producto pro) {
        String sql = "UPDATE producto SET codigo=?, nombre=?, marca=?, modelo=?, precio=?, cantidad=? WHERE id=?";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getMarca());
            ps.setString(4, pro.getModelo());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getCantidad());
            ps.setInt(7, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean eliminar(Producto pro) {
        String sql = "DELETE FROM producto WHERE codigo=?";

        try (Connection conn = getConexion();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pro.getCodigo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean buscar(Producto pro) {
        String sql = "SELECT * FROM producto WHERE codigo=?";

        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pro.getCodigo());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pro.setId(rs.getInt("id"));
                    pro.setCodigo(rs.getString("codigo"));
                    pro.setNombre(rs.getString("nombre"));
                    pro.setMarca(rs.getString("marca"));
                    pro.setModelo(rs.getString("modelo"));
                    pro.setPrecio(rs.getDouble("precio"));
                    pro.setCantidad(rs.getInt("cantidad"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
    
    public List<Producto> obtenerTodos() {
        List<Producto> listaProductos = new ArrayList<>();
        try (Connection conn = getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM producto");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setModelo(rs.getString("modelo"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                listaProductos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
}