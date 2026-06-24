package libreria.datos;

import libreria.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // Consultas SQL preparadas
    private final String SQL_INSERT = "INSERT INTO clientes(dni, nombre, apellido, telefono, correo) VALUES(?, ?, ?, ?, ?)";
    private final String SQL_SELECT = "SELECT * FROM clientes";
    private final String SQL_UPDATE = "UPDATE clientes SET nombre=?, apellido=?, telefono=?, correo=? WHERE dni=?";
    private final String SQL_DELETE = "DELETE FROM clientes WHERE dni=?";
    private final String SQL_SELECT_BY_DNI = "SELECT * FROM clientes WHERE dni=?";

    
    public boolean insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionDB.getConnection(); 
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getDni());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getCorreo());
            
            int registros = stmt.executeUpdate();
            return registros > 0; 
            
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones(conn, stmt, null);
        }
    }

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            conn = ConexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                
                Cliente cliente = new Cliente(dni, nombre, apellido, telefono, correo);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        } finally {
            cerrarConexiones(conn, stmt, rs);
        }
        return clientes;
    }

   
    public boolean actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getCorreo());
            stmt.setString(5, cliente.getDni()); 
            
            int registros = stmt.executeUpdate();
            return registros > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones(conn, stmt, null);
        }
    }

    public boolean eliminar(String dni) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, dni);
            
            int registros = stmt.executeUpdate();
            return registros > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones(conn, stmt, null);
        }
    }

    public Cliente buscarPorDni(String dni) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        
        try {
            conn = ConexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_DNI);
            stmt.setString(1, dni);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                
                cliente = new Cliente(dni, nombre, apellido, telefono, correo);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        } finally {
            cerrarConexiones(conn, stmt, rs);
        }
        return cliente;
    }

    private void cerrarConexiones(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexiones: " + e.getMessage());
        }
    }
}

