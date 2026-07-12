package biblioteca.modelo;

public class Enciclopedia extends Libro {

    // Atributo
    private int numeroTomo;

    // Constructor parametrizado
    public Enciclopedia(int idLibro, String isbn, String titulo, String autor, double precioCompra, double precioVenta, int cantidad, int anioPublicacion, String tipoLibro, int numeroTomo) {
        super(idLibro, isbn, titulo, autor, precioCompra, precioVenta, cantidad, anioPublicacion, tipoLibro);
        this.numeroTomo = numeroTomo;
    }

    // Getters y Setters
    public int getNumeroTomo() {
        return numeroTomo;
    }

    public void setNumeroTomo(int numeroTomo) {
        this.numeroTomo = numeroTomo;
    }

    // Metodos
    @Override
    public double calcularPrecioFinal() {
        return this.getPrecioVenta() + 10.0; // Recargo extra de S/10 sobre el precio de venta
    }

    @Override
    public String obtenerDetalle() {
        return "Enciclopedia: " + getTitulo() + " - Tomo: " + numeroTomo;
    }
}