package biblioteca.modelo;

public class LibroLite extends Libro {

    public LibroLite(int idLibro, String isbn) {
        // Valores vacíos para esta clase "ligera"
        super(idLibro, isbn, "", "", 0.0, 0, 0, "");
    }

    @Override
    public double calcularPrecioFinal() {
        return 0.0;
    }

    @Override
    public String obtenerDetalle() {
        return "";
    }
}
