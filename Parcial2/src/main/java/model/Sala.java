package model;

import java.util.ArrayList;
import java.util.List;

public class Sala {

    private String codigo;
    private String nombre;
    private int capacidad;
    private TipoSala tipo;
    private int filas;
    private int columnas;
    private List<Asiento> listAsientos;

    public Sala(String codigo, String nombre, int capacidad,
                TipoSala tipo, int filas, int columnas) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.filas = filas;
        this.columnas = columnas;

        listAsientos = new ArrayList<>();

        for (int i = 0; i < filas; i++) {

            String letraFila = String.valueOf((char) ('A' + i));

            for (int j = 1; j <= columnas; j++) {

                if (listAsientos.size() < capacidad) {
                    Asiento asiento = new Asiento(letraFila, j);
                    listAsientos.add(asiento);
                }
            }
        }
    }

    public boolean verificarAsiento(String fila, int numero) {

        boolean encontrado = false;

        for (Asiento asiento : listAsientos) {

            if (asiento.getFila().equalsIgnoreCase(fila)
                    && asiento.getNumero() == numero) {

                encontrado = true;
            }
        }

        return encontrado;
    }

    public int consultarCantidadAsientos() {
        return listAsientos.size();
    }

    public String mostrarAsientos() {

        String resultado = "";

        for (Asiento asiento : listAsientos) {
            resultado += asiento.toString() + "\n";
        }

        return resultado;
    }

    public String consultarDistribucionAsientos() {

        String resultado = "";

        for (Asiento asiento : listAsientos) {
            resultado += "[" + asiento.getFila()
                    + asiento.getNumero() + "] ";

            if (asiento.getNumero() == columnas) {
                resultado += "\n";
            }
        }

        return resultado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public TipoSala getTipo() {
        return tipo;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public List<Asiento> getListAsientos() {
        return listAsientos;
    }

    public void setListAsientos(List<Asiento> listAsientos) {
        this.listAsientos = listAsientos;
    }

    @Override
    public String toString() {

        return "Sala{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", tipo=" + tipo +
                ", filas=" + filas +
                ", columnas=" + columnas +
                ", cantidadAsientos=" + listAsientos.size() +
                '}';
    }
}