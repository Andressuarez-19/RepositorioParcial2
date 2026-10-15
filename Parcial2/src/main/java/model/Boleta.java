package model;

public class Boleta {

    private String codigo;
    private String fila;
    private int numeroAsiento;
    private double valorPagado;
    private Funcion funcion;
    private Venta venta;

    public Boleta(String codigo, String fila, int numeroAsiento,
                  Funcion funcion, Venta venta) {

        this.codigo = codigo;
        this.fila = fila;
        this.numeroAsiento = numeroAsiento;
        this.funcion = funcion;
        this.venta = venta;

        double precio = funcion.calcularPrecioBasePorTipoSala();

        this.valorPagado = venta.getCliente().aplicarDescuento(precio);
    }

    public boolean verificarAsiento() {

        boolean asientoValido = false;

        if (funcion != null && funcion.getSala() != null) {
            if (funcion.getSala().verificarAsiento(fila, numeroAsiento)) {
                asientoValido = true;
            }
        }

        return asientoValido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "codigo='" + codigo + '\'' +
                ", fila='" + fila + '\'' +
                ", numeroAsiento=" + numeroAsiento +
                ", valorPagado=" + valorPagado +
                ", funcion=" + funcion.getCodigo() +
                '}';
    }
}