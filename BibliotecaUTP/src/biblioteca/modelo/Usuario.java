package biblioteca.modelo;

public class Usuario implements IValidar {

    // Atributos
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String dni;
    private String celular;
    private String correo;
    private String direccion;

    // Constructor parametrizado
    public Usuario(int idUsuario, String nombre, String apellido, String dni, 
                   String celular, String correo, String direccion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
    }

    // Constructor simplificado para ComboBox
    public Usuario(int idUsuario, String dni) {
        this.idUsuario = idUsuario;
        this.dni = dni;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String email) {
        this.correo = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean validarDatos() {
        boolean dniValido = (dni != null && dni.length() == 8);
        boolean celularValido = (celular != null && celular.length() == 9);
        boolean correoValido = (correo != null && correo.contains("@"));
        return dniValido && celularValido && correoValido;
    }

    @Override
    public String toString() {
        return this.dni;
    }
}