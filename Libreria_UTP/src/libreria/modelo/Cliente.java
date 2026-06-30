package libreria.modelo;

import libreria.modelo.IValidar;

public class Cliente implements IValidar {

    // Atribtuso
    private int idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String celular;
    private String email;
    private String direccion;

    // Constructor parametrizado
    public Cliente(int idCliente, String nombre, String apellido, String dni, String celular, String email, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
    }

    // Constructor parametrizado solo para el ComboBox del frm Prestamo
    public Cliente(int idCliente, String dni) {
        this.idCliente = idCliente;
        this.dni = dni;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Metodo 
    @Override
    public boolean validarDatos() {
        // Validaciones básicas: DNI de 8 dígitos y un celular de 9 dígitos
        boolean dniValido = (dni != null && dni.length() == 8);
        boolean celularValido = (celular != null && celular.length() == 9);
        boolean emailValido = (email != null && email.contains("@"));

        return dniValido && celularValido && emailValido;
    }

    // Valor para el Prestamo
    @Override
    public String toString() {
        return this.dni;
    }
}
