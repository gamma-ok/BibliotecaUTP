package biblioteca.modelo;

import java.time.LocalDate;

public class Prestamo implements IValidar {

    // Atributos
    private int idPrestamo;
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private String estado;
    private double montoPagado;

    // Constructor para REGISTRAR nuevos préstamos (Lógica de formulario)
    public Prestamo(int idPrestamo, Usuario usuario, Libro libro, int diasPrestamo) {
        this.idPrestamo = idPrestamo;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = this.fechaPrestamo.plusDays(diasPrestamo);
        this.estado = "Prestado";
        this.montoPagado = libro.calcularPrecioFinal();
    }

    // Constructor para RECUPERAR préstamos (Lógica de base de datos)
    public Prestamo(int idPrestamo, Usuario usuario, Libro libro, LocalDate fechaPrestamo,
            LocalDate fechaDevolucion, String estado, double montoPagado) {
        this.idPrestamo = idPrestamo;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
        this.montoPagado = montoPagado;
    }

    // Getters y Setters
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Metodo
    @Override
    public boolean validarDatos() {
        return libro != null && usuario != null && libro.getStock() > 0;
    }
}
