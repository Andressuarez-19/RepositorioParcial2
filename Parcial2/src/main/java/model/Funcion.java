package model;

import java.util.ArrayList;
import java.util.List;

public class Funcion {

    private String codigo;
    private String fecha;
    private String horaInicio;
    private double precioBase;
    private Pelicula pelicula;
    private Sala sala;
    private List<Venta> listVentas;

    public Funcion(String codigo, String fecha, String horaInicio,
                   double precioBase, Pelicula pelicula, Sala sala) {

        this.codigo = codigo;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.precioBase = precioBase;
        this.pelicula = pelicula;
        this.sala = sala;
        this.listVentas = new ArrayList<>();
    }

    public int convertirHoraAMinutos() {

        String[] partes = horaInicio.split(":");

        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);

        int horaEnMinutos = horas * 60 + minutos;

        return horaEnMinutos;
    }

    public int calcularHoraFinalizacion() {

        int horaInicial = convertirHoraAMinutos();
        int horaFinal = horaInicial + pelicula.getDuracion();

        return horaFinal;
    }

    public boolean seCruzaConFuncion(Funcion otraFuncion) {

        boolean seCruzan = false;

        if (fecha.equals(otraFuncion.getFecha())
                && sala.getCodigo().equalsIgnoreCase(
                otraFuncion.getSala().getCodigo())) {

            int inicioActual = convertirHoraAMinutos();
            int finActual = calcularHoraFinalizacion();

            int inicioOtra = otraFuncion.convertirHoraAMinutos();
            int finOtra = otraFuncion.calcularHoraFinalizacion();

            if (inicioActual < finOtra && inicioOtra < finActual) {
                seCruzan = true;
            }
        }

        return seCruzan;
    }

    public double calcularPrecioBasePorTipoSala() {

        double precio = precioBase;

        if (sala.getTipo() == TipoSala.VIP) {

            precio = precioBase + (precioBase * 30 / 100);

        } else if (sala.getTipo() == TipoSala.TRES_D) {

            precio = precioBase + (precioBase * 20 / 100);
        }

        return precio;
    }

    public int consultarBoletasVendidas() {

        int cantidad = 0;

        for (Venta venta : listVentas) {
            cantidad = cantidad + venta.getListBoletas().size();
        }

        return cantidad;
    }

    public int consultarAsientosDisponibles() {

        int disponibles = sala.consultarCantidadAsientos()
                - consultarBoletasVendidas();

        return disponibles;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Venta> getListVentas() {
        return listVentas;
    }

    public void setListVentas(List<Venta> listVentas) {
        this.listVentas = listVentas;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", duracionMinutos=" + pelicula.getDuracion() +
                ", precioBase=" + precioBase +
                ", precioConTipoSala=" + calcularPrecioBasePorTipoSala() +
                ", pelicula=" + pelicula.getTitulo() +
                ", sala=" + sala.getNombre() +
                ", asientosDisponibles=" + consultarAsientosDisponibles() +
                '}';
    }
}