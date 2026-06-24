package libreria.controlador;

import libreria.modelo.Cliente;
import libreria.datos.ClienteDAO;
import java.util.List;

public class ClienteController {
    
    private final ClienteDAO clienteDAO;

   
    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public boolean registrarCliente(String dni, String nombre, String apellido, String telefono, String correo) {
        
        if (dni == null || dni.trim().isEmpty() || dni.length() < 8) {
            System.out.println("Error: El DNI debe tener un formato válido.");
            return false;
        }
        if (nombre == null || nombre.trim().isEmpty() || apellido == null || apellido.trim().isEmpty()) {
            System.out.println("Error: El nombre y apellido son obligatorios.");
            return false;
        }

     
        Cliente nuevoCliente = new Cliente(dni.trim(), nombre.trim(), apellido.trim(), telefono.trim(), correo.trim());
        
      
        return clienteDAO.insertar(nuevoCliente);
    }

    
    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }

   
    public boolean actualizarCliente(String dni, String nombre, String apellido, String telefono, String correo) {
        if (dni == null || dni.trim().isEmpty()) {
            return false;
        }
        
        Cliente clienteActualizado = new Cliente(dni.trim(), nombre.trim(), apellido.trim(), telefono.trim(), correo.trim());
        return clienteDAO.actualizar(clienteActualizado);
    }

    
    public boolean eliminarCliente(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            return false;
        }
        return clienteDAO.eliminar(dni.trim());
    }

    public Cliente buscarCliente(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            return null;
        }
        return clienteDAO.buscarPorDni(dni.trim());
    }
}
