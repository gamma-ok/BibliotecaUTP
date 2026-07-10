package biblioteca.modelo;

public abstract class Libro {

    // Atributos
    private int idLibro;
    private String isbn; // Codigo
    private String titulo;
    private String autor;
    private double precio;
    private int stock;
    private int anioPublicacion;
    private String tipoLibro;

    // Constructor parametrizado
    public Libro(int idLibro, String isbn, String titulo, String autor, double precio, int stock, int anioPublicacion, String tipoLibro) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    // Metodos abstracto
    public abstract double calcularPrecioFinal();

    public abstract String obtenerDetalle();

    // Valor para el Prestamo
    @Override
    public String toString() {
        return this.isbn;
    }
}
