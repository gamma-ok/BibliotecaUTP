package biblioteca.modelo;

public abstract class Libro {

    // Atributos
    private int idLibro;
    private String isbn; // Codigo
    private String titulo;
    private String autor;
    private double precioCompra;
    private double precioVenta;
    private int cantidad;
    private int anioPublicacion;
    private String tipoLibro;

    // Constructor parametrizado
    public Libro(int idLibro, String isbn, String titulo, String autor, double precioCompra, double precioVenta, int cantidad, int anioPublicacion, String tipoLibro) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.anioPublicacion = anioPublicacion;
        this.tipoLibro = tipoLibro;
    }

    // Getters y Setters
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(String tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    // Metodos abstractos
    public abstract double calcularPrecioFinal();

    public abstract String obtenerDetalle();

    // Valor para el Prestamo
    @Override
    public String toString() {
        return this.isbn;
    }
}