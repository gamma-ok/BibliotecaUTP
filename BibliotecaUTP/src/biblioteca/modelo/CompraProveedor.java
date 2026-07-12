package biblioteca.modelo;

import java.time.LocalDate;

public class CompraProveedor {

    // Atributos
    private int idCompra;
    private Proveedor proveedor;
    private Libro libro;
    private LocalDate fechaEntrega;
    private int cantidad;
    private double precioUnitario;
    private double montoTotal;

    // Constructor para REGISTRAR nuevas compras (Lógica de formulario)
    public CompraProveedor(int idCompra, Proveedor proveedor, Libro libro, LocalDate fechaEntrega,
            int cantidad, double precioUnitario) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.libro = libro;
        this.fechaEntrega = fechaEntrega;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.montoTotal = this.cantidad * this.precioUnitario; // MontoTotal automatico al crear el objeto
    }

    // Constructor para RECUPERAR compras de la BD (incluye montoTotal)
    public CompraProveedor(int idCompra, Proveedor proveedor, Libro libro, LocalDate fechaEntrega,
            int cantidad, double precioUnitario, double montoTotal) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.libro = libro;
        this.fechaEntrega = fechaEntrega;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.montoTotal = montoTotal;
    }

    // Getters y Setters
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.montoTotal = this.cantidad * this.precioUnitario; // Recalcular si cambia
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.montoTotal = this.cantidad * this.precioUnitario; // Recalcular si cambia
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}
