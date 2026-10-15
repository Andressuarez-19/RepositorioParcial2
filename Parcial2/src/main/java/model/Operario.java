package model;

public class Operario extends Persona {

    private String codigoEmpleado;
    private String fechaContratacion;
    private double salarioBasico;

    public Operario(String documentoIdentidad, String nombreCompleto,
                    String correoElectronico, String numeroTelefono,
                    String codigoEmpleado, String fechaContratacion,
                    double salarioBasico) {
        super(documentoIdentidad, nombreCompleto,
                correoElectronico, numeroTelefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
    }

    public void registrarVenta(Venta venta, Cine cine) {
        cine.getListVentas().add(venta);
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    @Override
    public String toString() {
        return "Operario{" +
                "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", fechaContratacion='" + fechaContratacion + '\'' +
                ", salarioBasico=" + salarioBasico +
                ", documentoIdentidad='" + getDocumentoIdentidad() + '\'' +
                ", nombreCompleto='" + getNombreCompleto() + '\'' +
                ", correoElectronico='" + getCorreoElectronico() + '\'' +
                ", numeroTelefono='" + getNumeroTelefono() + '\'' +
                '}';
    }
}