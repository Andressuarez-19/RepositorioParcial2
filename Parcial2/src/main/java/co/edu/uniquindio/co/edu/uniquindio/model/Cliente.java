package uniquindio.edu.co.model;

public class Cliente extends Persona {

    private String codigoAfiliacion;
    private double porcentajeDescuento;

    public Cliente(String documentoIdentidad, String nombreCompleto,
                   String correoElectronico, String numeroTelefono,
                   String codigoAfiliacion) {

        super(documentoIdentidad, nombreCompleto,
                correoElectronico, numeroTelefono);

        this.codigoAfiliacion = codigoAfiliacion;

        if (codigoAfiliacion != null) {

            if (codigoAfiliacion.equalsIgnoreCase("SIN")) {
                porcentajeDescuento = 0;

            } else if (codigoAfiliacion.equalsIgnoreCase("AFIL10")) {
                porcentajeDescuento = 10;

            } else if (codigoAfiliacion.equalsIgnoreCase("AFIL15")) {
                porcentajeDescuento = 15;

            } else if (codigoAfiliacion.equalsIgnoreCase("AFIL20")) {
                porcentajeDescuento = 20;

            } else {
                porcentajeDescuento = 0;
            }

        } else {
            porcentajeDescuento = 0;
        }
    }

    public double aplicarDescuento(double valor) {

        double descuento = valor * porcentajeDescuento / 100;
        double valorFinal = valor - descuento;

        return valorFinal;
    }

    public void consultarDatos() {
        System.out.println(toString());
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {

        this.codigoAfiliacion = codigoAfiliacion;

        if (codigoAfiliacion != null) {

            if (codigoAfiliacion.equalsIgnoreCase("SIN")) {
                porcentajeDescuento = 0;

            } else if (codigoAfiliacion.equalsIgnoreCase("AFIL10")) {
                porcentajeDescuento = 10;

            } else if (codigoAfiliacion.equalsIgnoreCase("AFIL15")) {
                porcentajeDescuento = 15;

            } else if (codigoAfiliacion.equalsIgnoreCase("AFIL20")) {
                porcentajeDescuento = 20;

            } else {
                porcentajeDescuento = 0;
            }

        } else {
            porcentajeDescuento = 0;
        }
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public String toString() {

        return "Cliente{" +
                "codigoAfiliacion='" + codigoAfiliacion + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                ", documentoIdentidad='" + getDocumentoIdentidad() + '\'' +
                ", nombreCompleto='" + getNombreCompleto() + '\'' +
                ", correoElectronico='" + getCorreoElectronico() + '\'' +
                ", numeroTelefono='" + getNumeroTelefono() + '\'' +
                '}';
    }
}