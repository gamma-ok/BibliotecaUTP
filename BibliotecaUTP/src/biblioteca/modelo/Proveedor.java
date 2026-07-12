package biblioteca.modelo;

public class Proveedor implements IValidar {

    // Atributos
    private int idProveedor;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String ruc;
    private String direccion;

    // Constructor parametrizado
    public Proveedor(int idProveedor, String nombre, String apellido, String telefono, String correo, String ruc, String direccion) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.ruc = ruc;
        this.direccion = direccion;
    }
    
    // Constructor simplificado para ComboBox
    public Proveedor(int idProveedor, String ruc) {
        this.idProveedor = idProveedor;
        this.ruc = ruc;
    }

    // Getters y Setters
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String email) {
        this.correo = email;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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
        // Validaciones: RUC de 11 dígitos, telefono de 9 dígitos, uso del @ en correo
        boolean telefonoValido = (telefono != null && telefono.length() == 8);
        boolean correoValido = (correo != null && correo.contains("@"));
        boolean rucValido = (ruc != null && ruc.length() == 11);

        return rucValido && correoValido && telefonoValido;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + " (RUC: " + this.ruc + ")";
    }
}
