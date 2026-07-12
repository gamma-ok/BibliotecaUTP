package biblioteca.modelo;

public class Novela extends Libro {

    // Atributo
    private String genero;

    // Constructor parametrizado
    public Novela(int idLibro, String isbn, String titulo, String autor, double precioCompra, double precioVenta, int cantidad, int anioPublicacion, String tipoLibro, String genero) {
        super(idLibro, isbn, titulo, autor, precioCompra, precioVenta, cantidad, anioPublicacion, tipoLibro);
        this.genero = genero;
    }

    // Getters y Setters
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Metodos
    @Override
    public double calcularPrecioFinal() {
        return this.getPrecioVenta() * 0.85; // 15% de descuento sobre el precio de venta
    }

    @Override
    public String obtenerDetalle() {
        return "Novela de género: " + genero + " - Título: " + getTitulo();
    }
}