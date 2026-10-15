package model;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    private String codigo;
    private String fecha;
    private Cliente cliente;
    private Operario operario;
    private List<Boleta> listBoletas;

    public Venta(String codigo, String fecha, Cliente cliente,
                 Operario operario) {

        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.operario = operario;
        this.listBoletas = new ArrayList<>();
    }

    public boolean agregarBoleta(Boleta boleta) {

        boolean agregada = false;

        if (boleta != null
                && boleta.getVenta() == this
                && boleta.verificarAsiento()) {

            boolean asientoRepetido = false;

            for (Boleta boletaRegistrada : listBoletas) {

                if (boletaRegistrada.getFuncion().getCodigo()
                        .equalsIgnoreCase(
                                boleta.getFuncion().getCodigo())
                        && boletaRegistrada.getFila()
                        .equalsIgnoreCase(boleta.getFila())
                        && boletaRegistrada.getNumeroAsiento()
                        == boleta.getNumeroAsiento()) {

                    asientoRepetido = true;
                }
            }

            if (!asientoRepetido) {

                listBoletas.add(boleta);

                boolean funcionRegistrada = false;

                for (Venta venta : boleta.getFuncion().getListVentas()) {
                    if (venta == this) {
                        funcionRegistrada = true;
                    }
                }

                if (!funcionRegistrada) {
                    boleta.getFuncion().getListVentas().add(this);
                }

                agregada = true;
            }
        }

        return agregada;
    }

    public double calcularTotalVenta() {

        double total = 0;

        for (Boleta boleta : listBoletas) {
            total = total + boleta.getValorPagado();
        }

        return total;
    }

    public int consultarCantidadBoletas() {
        return listBoletas.size();
    }

    public String consultarBoletas() {

        String resultado = "";

        for (Boleta boleta : listBoletas) {
            resultado = resultado + boleta.toString() + "\n";
        }

        return resultado;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    public List<Boleta> getListBoletas() {
        return listBoletas;
    }

    public void setListBoletas(List<Boleta> listBoletas) {
        this.listBoletas = listBoletas;
    }

    @Override
    public String toString() {

        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", cliente=" + cliente.getNombreCompleto() +
                ", operario=" + operario.getNombreCompleto() +
                ", cantidadBoletas=" + listBoletas.size() +
                ", total=" + calcularTotalVenta() +
                '}';
    }
}
