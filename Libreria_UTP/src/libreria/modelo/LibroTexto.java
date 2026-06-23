package libreria.modelo;

public class LibroTexto extends Libro {

    // Atributo
    private String nivelAcademico;

    // Constructor parametrizado abstracto
    public LibroTexto(int idLibro, String isbn, String titulo, String autor, double precio,
            int stock, int anioPublicacion, String tipoLibro, String nivelAcademico) {
        super(idLibro, isbn, titulo, autor, precio, stock, anioPublicacion, tipoLibro);
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
        return this.getPrecio();
    }

    @Override
    public String obtenerDetalle() { // toString
        return "Libro académico de nivel: " + nivelAcademico;
    }
}
