package model;

public class Asiento {

    private String fila;
    private int numero;

    public Asiento(String fila, int numero) {
        this.fila = fila;
        this.numero = numero;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "fila='" + fila + '\'' +
                ", numero=" + numero +
                '}';
    }
}