package biblioteca.modelo;

import java.time.LocalDate;

public class CompraProveedor {

    // Atributos
    private int idCompra;
    private Proveedor proveedor;
    private Libro libro;
    private LocalDate fechaCompra;
    private int cantidad;
    private double precioCompraUnitario;
    private double montoTotal;

    // Constructor para REGISTRAR nuevas compras (Lógica de formulario)
    public CompraProveedor(int idCompra, Proveedor proveedor, Libro libro, LocalDate fechaCompra, int cantidad, double precioCompraUnitario) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.libro = libro;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.precioCompraUnitario = precioCompraUnitario;
        this.montoTotal = this.cantidad * this.precioCompraUnitario;
    }

    // Constructor para RECUPERAR compras de la BD (incluye montoTotal)
    public CompraProveedor(int idCompra, Proveedor proveedor, Libro libro, LocalDate fechaCompra, int cantidad, double precioCompraUnitario, double montoTotal) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.libro = libro;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.precioCompraUnitario = precioCompraUnitario;
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

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.montoTotal = this.cantidad * this.precioCompraUnitario;
    }

    public double getPrecioCompraUnitario() {
        return precioCompraUnitario;
    }

    public void setPrecioCompraUnitario(double precioCompraUnitario) {
        this.precioCompraUnitario = precioCompraUnitario;
        this.montoTotal = this.cantidad * this.precioCompraUnitario;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}