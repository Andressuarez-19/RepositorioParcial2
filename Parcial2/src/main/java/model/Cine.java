package model;

import java.util.ArrayList;
import java.util.List;

public class Cine {

    private String nombre;
    private String nit;
    private String direccion;

    private List<Pelicula> listPeliculas;
    private List<Sala> listSalas;
    private List<Funcion> listFunciones;
    private List<Cliente> listClientes;
    private List<Operario> listOperarios;
    private List<Venta> listVentas;

    public Cine(String nombre, String nit, String direccion) {

        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;

        listPeliculas = new ArrayList<>();
        listSalas = new ArrayList<>();
        listFunciones = new ArrayList<>();
        listClientes = new ArrayList<>();
        listOperarios = new ArrayList<>();
        listVentas = new ArrayList<>();
    }

    // REGISTRAR Y CONSULTAR PELICULAS

    public boolean registrarPelicula(Pelicula pelicula) {

        if (pelicula == null
                || pelicula.getCodigo() == null
                || consultarPelicula(pelicula.getCodigo()) != null) {
            return false;
        }

        listPeliculas.add(pelicula);
        return true;
    }

    public Pelicula consultarPelicula(String codigo) {

        for (Pelicula pelicula : listPeliculas) {

            if (codigo != null
                    && pelicula.getCodigo().equalsIgnoreCase(codigo)) {
                return pelicula;
            }
        }

        return null;
    }

    public String consultarCartelera() {

        String resultado = "PELICULAS DISPONIBLES\n\n";

        for (Pelicula pelicula : listPeliculas) {
            resultado += pelicula.toString() + "\n";
        }

        if (listPeliculas.isEmpty()) {
            resultado += "No hay peliculas registradas.";
        }

        return resultado;
    }

    // REGISTRAR Y CONSULTAR SALAS

    public boolean registrarSala(Sala sala) {

        if (sala == null
                || sala.getCodigo() == null
                || consultarSala(sala.getCodigo()) != null
                || sala.getCapacidad() <= 0
                || sala.getListAsientos().size() != sala.getCapacidad()) {
            return false;
        }

        listSalas.add(sala);
        return true;
    }

    public Sala consultarSala(String codigo) {

        for (Sala sala : listSalas) {

            if (codigo != null
                    && sala.getCodigo().equalsIgnoreCase(codigo)) {
                return sala;
            }
        }

        return null;
    }

    public String consultarSalas() {

        String resultado = "SALAS REGISTRADAS\n\n";

        for (Sala sala : listSalas) {
            resultado += sala.toString() + "\n";
        }

        if (listSalas.isEmpty()) {
            resultado += "No hay salas registradas.";
        }

        return resultado;
    }

    // REGISTRAR Y CONSULTAR CLIENTES

    public boolean registrarCliente(Cliente cliente) {

        if (cliente == null
                || cliente.getDocumentoIdentidad() == null
                || consultarCliente(cliente.getDocumentoIdentidad()) != null) {
            return false;
        }

        listClientes.add(cliente);
        return true;
    }

    public Cliente consultarCliente(String documentoIdentidad) {

        for (Cliente cliente : listClientes) {

            if (documentoIdentidad != null
                    && cliente.getDocumentoIdentidad()
                    .equalsIgnoreCase(documentoIdentidad)) {
                return cliente;
            }
        }

        return null;
    }

    // REGISTRAR Y CONSULTAR OPERARIOS

    public boolean registrarOperario(Operario operario) {

        if (operario == null
                || operario.getDocumentoIdentidad() == null
                || operario.getCodigoEmpleado() == null
                || consultarOperario(
                operario.getDocumentoIdentidad()) != null
                || consultarOperarioPorCodigo(
                operario.getCodigoEmpleado()) != null) {
            return false;
        }

        listOperarios.add(operario);
        return true;
    }

    public Operario consultarOperario(String documentoIdentidad) {

        for (Operario operario : listOperarios) {

            if (documentoIdentidad != null
                    && operario.getDocumentoIdentidad()
                    .equalsIgnoreCase(documentoIdentidad)) {
                return operario;
            }
        }

        return null;
    }

    public Operario consultarOperarioPorCodigo(String codigoEmpleado) {

        for (Operario operario : listOperarios) {

            if (codigoEmpleado != null
                    && operario.getCodigoEmpleado()
                    .equalsIgnoreCase(codigoEmpleado)) {
                return operario;
            }
        }

        return null;
    }

    // PROGRAMAR FUNCIONES

    public boolean programarFuncion(Funcion funcion) {

        if (funcion == null
                || funcion.getCodigo() == null
                || funcion.getPelicula() == null
                || funcion.getSala() == null
                || consultarFuncion(funcion.getCodigo()) != null
                || consultarPelicula(
                funcion.getPelicula().getCodigo()) == null
                || consultarSala(
                funcion.getSala().getCodigo()) == null
                || funcion.getPrecioBase() <= 0
                || !verificarHora(funcion.getHoraInicio())
                || !verificarFecha(funcion.getFecha())) {
            return false;
        }

        boolean disponible = true;

        for (Funcion funcionRegistrada : listFunciones) {

            if (funcion.seCruzaConFuncion(funcionRegistrada)) {
                disponible = false;
            }
        }

        if (disponible) {
            listFunciones.add(funcion);
            return true;
        }

        return false;
    }

    public Funcion consultarFuncion(String codigo) {

        for (Funcion funcion : listFunciones) {

            if (codigo != null
                    && funcion.getCodigo().equalsIgnoreCase(codigo)) {
                return funcion;
            }
        }

        return null;
    }

    public String consultarFunciones() {

        String resultado = "FUNCIONES PROGRAMADAS\n\n";

        for (Funcion funcion : listFunciones) {
            resultado += funcion.toString() + "\n";
        }

        if (listFunciones.isEmpty()) {
            resultado += "No hay funciones programadas.";
        }

        return resultado;
    }

    // VALIDAR HORA

    public boolean verificarHora(String hora) {

        if (hora == null
                || !hora.matches("[0-9]{2}:[0-9]{2}")) {
            return false;
        }

        String[] partes = hora.split(":");

        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);

        return horas >= 0 && horas <= 23
                && minutos >= 0 && minutos <= 59;
    }

    // VALIDAR FECHA

    public boolean verificarFecha(String fecha) {

        if (fecha == null
                || !fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            return false;
        }

        String[] partes = fecha.split("/");

        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        if (anio < 1 || mes < 1 || mes > 12) {
            return false;
        }

        int diasMes = 31;

        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            diasMes = 30;

        } else if (mes == 2) {

            diasMes = 28;

            if (anio % 400 == 0
                    || (anio % 4 == 0 && anio % 100 != 0)) {
                diasMes = 29;
            }
        }

        return dia >= 1 && dia <= diasMes;
    }

    // VERIFICAR DISPONIBILIDAD DE ASIENTOS

    public boolean verificarAsientoDisponible(
            Funcion funcion, String fila, int numeroAsiento) {

        if (funcion == null
                || funcion.getSala() == null
                || !funcion.getSala().verificarAsiento(
                fila, numeroAsiento)) {
            return false;
        }

        for (Venta venta : listVentas) {

            for (Boleta boleta : venta.getListBoletas()) {

                if (boleta.getFuncion() != null
                        && boleta.getFuncion().getCodigo()
                        .equalsIgnoreCase(funcion.getCodigo())
                        && boleta.getFila().equalsIgnoreCase(fila)
                        && boleta.getNumeroAsiento() == numeroAsiento) {
                    return false;
                }
            }
        }

        return true;
    }

    // VERIFICAR DISPONIBILIDAD DURANTE UNA VENTA

    public boolean verificarAsientoDisponible(
            Funcion funcion,
            String fila,
            int numeroAsiento,
            Venta ventaActual) {

        if (!verificarAsientoDisponible(
                funcion, fila, numeroAsiento)) {
            return false;
        }

        if (ventaActual != null) {

            for (Boleta boleta : ventaActual.getListBoletas()) {

                if (boleta.getFuncion() != null
                        && boleta.getFuncion().getCodigo()
                        .equalsIgnoreCase(funcion.getCodigo())
                        && boleta.getFila().equalsIgnoreCase(fila)
                        && boleta.getNumeroAsiento() == numeroAsiento) {
                    return false;
                }
            }
        }

        return true;
    }

    // MOSTRAR ASIENTOS DISPONIBLES Y OCUPADOS

    public String consultarDisponibilidadAsientos(Funcion funcion) {

        if (funcion == null || funcion.getSala() == null) {
            return "La funcion o su sala no existen.";
        }

        String resultado = "FUNCION: " + funcion.getCodigo()
                + "\nPELICULA: "
                + funcion.getPelicula().getTitulo()
                + "\nSALA: " + funcion.getSala().getNombre()
                + "\n\nDISTRIBUCION DE ASIENTOS\n\n";

        int disponibles = 0;
        int ocupados = 0;
        int columnas = funcion.getSala().getColumnas();

        for (Asiento asiento : funcion.getSala().getListAsientos()) {

            boolean disponible = verificarAsientoDisponible(
                    funcion, asiento.getFila(), asiento.getNumero());

            resultado += "[" + asiento.getFila()
                    + asiento.getNumero() + "] "
                    + (disponible ? "Disponible" : "Ocupado")
                    + "    ";

            if (disponible) {
                disponibles++;
            } else {
                ocupados++;
            }

            if (asiento.getNumero() == columnas) {
                resultado += "\n";
            }
        }

        resultado += "\nTotal de asientos: "
                + funcion.getSala().getCapacidad()
                + "\nDisponibles: " + disponibles
                + "\nOcupados: " + ocupados;

        return resultado;
    }

    // REGISTRAR VENTAS

    public boolean realizarVenta(Venta venta) {

        if (venta == null
                || venta.getCodigo() == null
                || consultarVenta(venta.getCodigo()) != null
                || venta.getCliente() == null
                || consultarCliente(
                venta.getCliente().getDocumentoIdentidad()) == null
                || venta.getOperario() == null
                || consultarOperario(
                venta.getOperario().getDocumentoIdentidad()) == null
                || venta.getListBoletas().isEmpty()) {
            return false;
        }

        // Validar todos los asientos antes de registrar la venta.

        for (int i = 0; i < venta.getListBoletas().size(); i++) {

            Boleta boleta = venta.getListBoletas().get(i);

            if (boleta == null
                    || boleta.getFuncion() == null
                    || consultarFuncion(
                    boleta.getFuncion().getCodigo()) == null
                    || !boleta.verificarAsiento()
                    || !verificarAsientoDisponible(
                    boleta.getFuncion(),
                    boleta.getFila(),
                    boleta.getNumeroAsiento())) {
                return false;
            }

            // Evitar repetir asientos dentro de la venta.

            for (int j = i + 1;
                 j < venta.getListBoletas().size(); j++) {

                Boleta otraBoleta = venta.getListBoletas().get(j);

                if (otraBoleta.getFuncion() != null
                        && boleta.getFuncion().getCodigo()
                        .equalsIgnoreCase(
                                otraBoleta.getFuncion().getCodigo())
                        && boleta.getFila().equalsIgnoreCase(
                        otraBoleta.getFila())
                        && boleta.getNumeroAsiento()
                        == otraBoleta.getNumeroAsiento()) {
                    return false;
                }
            }
        }

        // Registrar la venta solamente cuando todas las validaciones pasen.

        listVentas.add(venta);

        for (Boleta boleta : venta.getListBoletas()) {

            Funcion funcion = boleta.getFuncion();

            if (!funcion.getListVentas().contains(venta)) {
                funcion.getListVentas().add(venta);
            }
        }

        return true;
    }

    public Venta consultarVenta(String codigo) {

        for (Venta venta : listVentas) {

            if (codigo != null
                    && venta.getCodigo().equalsIgnoreCase(codigo)) {
                return venta;
            }
        }

        return null;
    }

    // CONSULTAR OCUPACION E INGRESOS

    public int consultarOcupacionSala(String codigoFuncion) {

        Funcion funcion = consultarFuncion(codigoFuncion);

        if (funcion == null) {
            return 0;
        }

        int ocupados = 0;

        for (Venta venta : listVentas) {

            for (Boleta boleta : venta.getListBoletas()) {

                if (boleta.getFuncion() != null
                        && boleta.getFuncion().getCodigo()
                        .equalsIgnoreCase(codigoFuncion)) {
                    ocupados++;
                }
            }
        }

        return ocupados;
    }

    public double calcularIngresosFuncion(String codigoFuncion) {

        double totalIngresos = 0;

        for (Venta venta : listVentas) {

            for (Boleta boleta : venta.getListBoletas()) {

                if (boleta.getFuncion() != null
                        && boleta.getFuncion().getCodigo()
                        .equalsIgnoreCase(codigoFuncion)) {

                    totalIngresos += boleta.getValorPagado();
                }
            }
        }

        return totalIngresos;
    }

    public double consultarIngresosFuncion(String codigoFuncion) {
        return calcularIngresosFuncion(codigoFuncion);
    }

    // GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Pelicula> getListPeliculas() {
        return listPeliculas;
    }

    public void setListPeliculas(List<Pelicula> listPeliculas) {
        this.listPeliculas = listPeliculas;
    }

    public List<Sala> getListSalas() {
        return listSalas;
    }

    public void setListSalas(List<Sala> listSalas) {
        this.listSalas = listSalas;
    }

    public List<Funcion> getListFunciones() {
        return listFunciones;
    }

    public void setListFunciones(List<Funcion> listFunciones) {
        this.listFunciones = listFunciones;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public List<Operario> getListOperarios() {
        return listOperarios;
    }

    public void setListOperarios(List<Operario> listOperarios) {
        this.listOperarios = listOperarios;
    }

    public List<Venta> getListVentas() {
        return listVentas;
    }

    public void setListVentas(List<Venta> listVentas) {
        this.listVentas = listVentas;
    }

    @Override
    public String toString() {

        return "Cine{"
                + "nombre='" + nombre + '\''
                + ", nit='" + nit + '\''
                + ", direccion='" + direccion + '\''
                + ", peliculas=" + listPeliculas.size()
                + ", salas=" + listSalas.size()
                + ", funciones=" + listFunciones.size()
                + ", clientes=" + listClientes.size()
                + ", operarios=" + listOperarios.size()
                + ", ventas=" + listVentas.size()
                + '}';
    }
}