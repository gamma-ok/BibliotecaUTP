package biblioteca.modelo;

import biblioteca.modelo.Libro;

public class Enciclopedia extends Libro {

    // Atributo
    private int numeroTomo;

    // Constructor parametrizado abstracto
    public Enciclopedia(int idLibro, String isbn, String titulo, String autor, double precio,
            int stock, int anioPublicacion, String tipoLibro, int numeroTomo) {
        super(idLibro, isbn, titulo, autor, precio, stock, anioPublicacion, tipoLibro);
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
        return this.getPrecio() + 10.0; // Tienen un recargo extra de S/10
    }

    @Override
    public String obtenerDetalle() { // toString
        return "Enciclopedia: " + getTitulo() + " - Tomo: " + numeroTomo;
    }
}
