package libreria.modelo;

import java.time.LocalDate;

public class Prestamo implements IValidable {

    // Atributos
    private int idPrestamo;
    private Cliente cliente;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private String estado;
    private double montoPagado;

    // Constructor para REGISTRAR nuevos préstamos (Lógica de formulario)
    public Prestamo(int idPrestamo, Cliente cliente, Libro libro, int diasPrestamo) {
        this.idPrestamo = idPrestamo;
        this.cliente = cliente;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = this.fechaPrestamo.plusDays(diasPrestamo);
        this.estado = "Prestado";
        this.montoPagado = libro.calcularPrecioFinal();
    }

    // Constructor para RECUPERAR préstamos (Lógica de base de datos)
    public Prestamo(int idPrestamo, Cliente cliente, Libro libro, LocalDate fechaPrestamo,
            LocalDate fechaDevolucion, String estado, double montoPagado) {
        this.idPrestamo = idPrestamo;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
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
        return libro != null && cliente != null && libro.getStock() > 0;
    }
}
