package libreria.modelo;

public class Novela extends Libro {

    // Atributo
    private String genero;

    // Constructor parametrizado abstracto
    public Novela(int idLibro, String isbn, String titulo, String autor, double precio,
            int stock, int anioPublicacion, String tipoLibro, String genero) {
        super(idLibro, isbn, titulo, autor, precio, stock, anioPublicacion, tipoLibro);
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
    public double calcularPrecioFinal() { // Polimorfismo
        return this.getPrecio() * 0.85; // Tienen un 15% de descuento
    }

    @Override
    public String obtenerDetalle() { // toString
        return "Novela de género: " + genero + " - Título: " + getTitulo();
    }
}
