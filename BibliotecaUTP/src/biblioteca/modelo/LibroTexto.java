package biblioteca.modelo;

public class LibroTexto extends Libro {

    // Atributo
    private String nivelAcademico;

    // Constructor parametrizado
    public LibroTexto(int idLibro, String isbn, String titulo, String autor, double precioCompra, double precioVenta, int cantidad, int anioPublicacion, String tipoLibro, String nivelAcademico) {
        super(idLibro, isbn, titulo, autor, precioCompra, precioVenta, cantidad, anioPublicacion, tipoLibro);
        this.nivelAcademico = nivelAcademico;
    }

    // Getters y Setters
    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    // Metodos
    @Override
    public double calcularPrecioFinal() {
        return this.getPrecioVenta();
    }

    @Override
    public String obtenerDetalle() {
        return "Libro académico de nivel: " + nivelAcademico;
    }
}