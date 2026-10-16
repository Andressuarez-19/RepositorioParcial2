package co.edu.uniquindio;

import co.edu.uniquindio.model.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Cine cine = MainRecord.crearCine();

        int opcion = 0;

        while (opcion != 12) {

            String menu = "BIENVENIDO A CINEPLUS\n\n"
                    + "1. Mostrar peliculas\n"
                    + "2. Mostrar salas\n"
                    + "3. Registrar pelicula\n"
                    + "4. Registrar cliente\n"
                    + "5. Registrar operario\n"
                    + "6. Programar funcion\n"
                    + "7. Consultar funciones\n"
                    + "8. Vender boletas\n"
                    + "9. Consultar ventas\n"
                    + "10. Consultar ocupacion e ingresos\n"
                    + "11. Informacion del cine\n"
                    + "12. Salir\n\n"
                    + "Seleccione una opcion:";

            String entrada = JOptionPane.showInputDialog(menu);

            if (entrada == null) {
                break;
            }

            try {

                opcion = Integer.parseInt(entrada);

                switch (opcion) {

                    case 1:
                        JOptionPane.showMessageDialog(
                                null, cine.consultarCartelera());
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(
                                null, cine.consultarSalas());
                        break;

                    case 3:
                        registrarPelicula(cine);
                        break;

                    case 4:
                        registrarCliente(cine);
                        break;

                    case 5:
                        registrarOperario(cine);
                        break;

                    case 6:
                        programarFuncion(cine);
                        break;

                    case 7:
                        consultarFunciones(cine);
                        break;

                    case 8:
                        venderBoletas(cine);
                        break;

                    case 9:
                        consultarVentas(cine);
                        break;

                    case 10:
                        consultarOcupacionIngresos(cine);
                        break;

                    case 11:
                        JOptionPane.showMessageDialog(
                                null, cine.toString());
                        break;

                    case 12:
                        JOptionPane.showMessageDialog(
                                null, "Gracias por utilizar CinePlus.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(
                                null, "Seleccione una opcion entre 1 y 12.");
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null, "Debe ingresar un numero valido.");
            }
        }
    }

    // SELECCIONAR PELICULA POR CODIGO

    public static Pelicula seleccionarPelicula(Cine cine) {

        if (cine.getListPeliculas().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, "No hay peliculas registradas.");
            return null;
        }

        String opciones = "PELICULAS REGISTRADAS\n\n";

        for (Pelicula pelicula : cine.getListPeliculas()) {

            opciones += "Codigo: " + pelicula.getCodigo()
                    + "\nTitulo: " + pelicula.getTitulo()
                    + "\n-----------------------------\n";
        }

        opciones += "\nEscriba el codigo de la pelicula:";

        String codigo = JOptionPane.showInputDialog(opciones);

        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }

        Pelicula pelicula = cine.consultarPelicula(codigo.trim());

        if (pelicula == null) {
            JOptionPane.showMessageDialog(
                    null, "No existe una pelicula con ese codigo.");
        }

        return pelicula;
    }

    // SELECCIONAR SALA POR CODIGO

    public static Sala seleccionarSala(Cine cine) {

        if (cine.getListSalas().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, "No hay salas registradas.");
            return null;
        }

        String opciones = "SALAS REGISTRADAS\n\n";

        for (Sala sala : cine.getListSalas()) {

            opciones += "Codigo: " + sala.getCodigo()
                    + "\nNombre: " + sala.getNombre()
                    + "\nTipo: " + sala.getTipo()
                    + "\nCapacidad: " + sala.getCapacidad()
                    + "\n-----------------------------\n";
        }

        opciones += "\nEscriba el codigo de la sala:";

        String codigo = JOptionPane.showInputDialog(opciones);

        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }

        Sala sala = cine.consultarSala(codigo.trim());

        if (sala == null) {
            JOptionPane.showMessageDialog(
                    null, "No existe una sala con ese codigo.");
        }

        return sala;
    }

    // SELECCIONAR CLIENTE POR DOCUMENTO

    public static Cliente seleccionarCliente(Cine cine) {

        if (cine.getListClientes().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, "No hay clientes registrados.");
            return null;
        }

        String opciones = "CLIENTES REGISTRADOS\n\n";

        for (Cliente cliente : cine.getListClientes()) {

            opciones += "Documento: " + cliente.getDocumentoIdentidad()
                    + "\nNombre: " + cliente.getNombreCompleto()
                    + "\nAfiliacion: " + cliente.getCodigoAfiliacion()
                    + "\nDescuento: " + cliente.getPorcentajeDescuento() + "%"
                    + "\n-----------------------------\n";
        }

        opciones += "\nEscriba el documento del cliente:";

        String documento = JOptionPane.showInputDialog(opciones);

        if (documento == null || documento.trim().isEmpty()) {
            return null;
        }

        Cliente cliente = cine.consultarCliente(documento.trim());

        if (cliente == null) {
            JOptionPane.showMessageDialog(
                    null, "No existe un cliente con ese documento.");
        }

        return cliente;
    }

    // SELECCIONAR OPERARIO POR CODIGO DE EMPLEADO

    public static Operario seleccionarOperario(Cine cine) {

        if (cine.getListOperarios().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, "No hay operarios registrados.");
            return null;
        }

        String opciones = "OPERARIOS REGISTRADOS\n\n";

        for (Operario operario : cine.getListOperarios()) {

            opciones += "Codigo de empleado: "
                    + operario.getCodigoEmpleado()
                    + "\nNombre: " + operario.getNombreCompleto()
                    + "\nDocumento: " + operario.getDocumentoIdentidad()
                    + "\n-----------------------------\n";
        }

        opciones += "\nEscriba el codigo del empleado:";

        String codigo = JOptionPane.showInputDialog(opciones);

        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }

        Operario operario =
                cine.consultarOperarioPorCodigo(codigo.trim());

        if (operario == null) {
            JOptionPane.showMessageDialog(
                    null, "No existe un operario con ese codigo.");
        }

        return operario;
    }

    // SELECCIONAR FUNCION POR CODIGO

    public static Funcion seleccionarFuncion(Cine cine) {

        if (cine.getListFunciones().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, "No hay funciones programadas.");
            return null;
        }

        String opciones = "FUNCIONES PROGRAMADAS\n\n";

        for (Funcion funcion : cine.getListFunciones()) {

            opciones += "Codigo: " + funcion.getCodigo()
                    + "\nPelicula: " + funcion.getPelicula().getTitulo()
                    + "\nFecha: " + funcion.getFecha()
                    + "\nHora: " + funcion.getHoraInicio()
                    + "\nSala: " + funcion.getSala().getNombre()
                    + "\n-----------------------------\n";
        }

        opciones += "\nEscriba el codigo de la funcion:";

        String codigo = JOptionPane.showInputDialog(opciones);

        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }

        Funcion funcion = cine.consultarFuncion(codigo.trim());

        if (funcion == null) {
            JOptionPane.showMessageDialog(
                    null, "No existe una funcion con ese codigo.");
        }

        return funcion;
    }

    // REGISTRAR PELICULA

    public static void registrarPelicula(Cine cine) {

        String codigo = JOptionPane.showInputDialog(
                "Codigo de la pelicula:");

        if (codigo == null || codigo.trim().isEmpty()) {
            return;
        }

        String titulo = JOptionPane.showInputDialog(
                "Titulo de la pelicula:");

        if (titulo == null || titulo.trim().isEmpty()) {
            return;
        }

        try {

            String entradaDuracion = JOptionPane.showInputDialog(
                    "Duracion en minutos:");

            if (entradaDuracion == null) {
                return;
            }

            int duracion = Integer.parseInt(entradaDuracion);

            if (duracion <= 0) {
                JOptionPane.showMessageDialog(
                        null, "La duracion debe ser mayor que cero.");
                return;
            }

            String entradaGenero = JOptionPane.showInputDialog(
                    "Seleccione el genero:\n"
                            + "1. Accion\n"
                            + "2. Comedia\n"
                            + "3. Drama\n"
                            + "4. Terror\n"
                            + "5. Animacion");

            if (entradaGenero == null) {
                return;
            }

            GeneroPelicula genero;

            switch (Integer.parseInt(entradaGenero)) {
                case 1:
                    genero = GeneroPelicula.ACCION;
                    break;
                case 2:
                    genero = GeneroPelicula.COMEDIA;
                    break;
                case 3:
                    genero = GeneroPelicula.DRAMA;
                    break;
                case 4:
                    genero = GeneroPelicula.TERROR;
                    break;
                case 5:
                    genero = GeneroPelicula.ANIMACION;
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null, "Genero no valido.");
                    return;
            }

            String clasificacion = JOptionPane.showInputDialog(
                    "Clasificacion por edad:");

            if (clasificacion == null
                    || clasificacion.trim().isEmpty()) {
                return;
            }

            Pelicula pelicula = new Pelicula(
                    codigo.trim(),
                    titulo.trim(),
                    duracion,
                    genero,
                    clasificacion.trim()
            );

            if (cine.registrarPelicula(pelicula)) {
                JOptionPane.showMessageDialog(
                        null, "Pelicula registrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(
                        null, "No fue posible registrar la pelicula. "
                                + "Verifique que el codigo no este repetido.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null, "Debe ingresar un numero valido.");
        }
    }

    // REGISTRAR CLIENTE

    public static void registrarCliente(Cine cine) {

        String documento = JOptionPane.showInputDialog(
                "Documento de identidad:");

        if (documento == null || documento.trim().isEmpty()) {
            return;
        }

        String nombre = JOptionPane.showInputDialog(
                "Nombre completo:");

        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }

        String correo = JOptionPane.showInputDialog(
                "Correo electronico:");

        if (correo == null || correo.trim().isEmpty()) {
            return;
        }

        String telefono = JOptionPane.showInputDialog(
                "Numero de telefono:");

        if (telefono == null || telefono.trim().isEmpty()) {
            return;
        }

        String entradaAfiliacion = JOptionPane.showInputDialog(
                "Seleccione el tipo de afiliacion:\n\n"
                        + "1. Sin descuento (0%)\n"
                        + "2. Afiliacion del 10%\n"
                        + "3. Afiliacion del 15%\n"
                        + "4. Afiliacion del 20%\n\n"
                        + "Ingrese el numero de la opcion:");

        if (entradaAfiliacion == null) {
            return;
        }

        String afiliacion;

        switch (entradaAfiliacion.trim()) {
            case "1":
                afiliacion = "SIN";
                break;
            case "2":
                afiliacion = "AFIL10";
                break;
            case "3":
                afiliacion = "AFIL15";
                break;
            case "4":
                afiliacion = "AFIL20";
                break;
            default:
                JOptionPane.showMessageDialog(
                        null, "La opcion de afiliacion no es valida.");
                return;
        }

        Cliente cliente = new Cliente(
                documento.trim(),
                nombre.trim(),
                correo.trim(),
                telefono.trim(),
                afiliacion
        );

        if (cine.registrarCliente(cliente)) {
            JOptionPane.showMessageDialog(
                    null, "Cliente registrado correctamente.\n"
                            + "Afiliacion: " + afiliacion
                            + "\nDescuento: "
                            + cliente.getPorcentajeDescuento() + "%");
        } else {
            JOptionPane.showMessageDialog(
                    null, "No fue posible registrar el cliente. "
                            + "Verifique que el documento no este repetido.");
        }
    }

    // REGISTRAR OPERARIO

    public static void registrarOperario(Cine cine) {

        String documento = JOptionPane.showInputDialog(
                "Documento de identidad:");

        if (documento == null || documento.trim().isEmpty()) {
            return;
        }

        String nombre = JOptionPane.showInputDialog(
                "Nombre completo:");

        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }

        String correo = JOptionPane.showInputDialog(
                "Correo electronico:");

        if (correo == null || correo.trim().isEmpty()) {
            return;
        }

        String telefono = JOptionPane.showInputDialog(
                "Numero de telefono:");

        if (telefono == null || telefono.trim().isEmpty()) {
            return;
        }

        String codigoEmpleado = JOptionPane.showInputDialog(
                "Codigo del empleado:");

        if (codigoEmpleado == null || codigoEmpleado.trim().isEmpty()) {
            return;
        }

        String fecha = JOptionPane.showInputDialog(
                "Fecha de contratacion (dd/MM/yyyy):");

        if (fecha == null || !cine.verificarFecha(fecha)) {
            JOptionPane.showMessageDialog(
                    null, "Fecha de contratacion no valida.");
            return;
        }

        try {

            String entradaSalario = JOptionPane.showInputDialog(
                    "Salario basico:");

            if (entradaSalario == null) {
                return;
            }

            double salario = Double.parseDouble(entradaSalario);

            if (salario < 0) {
                JOptionPane.showMessageDialog(
                        null, "El salario no puede ser negativo.");
                return;
            }

            Operario operario = new Operario(
                    documento.trim(),
                    nombre.trim(),
                    correo.trim(),
                    telefono.trim(),
                    codigoEmpleado.trim(),
                    fecha.trim(),
                    salario
            );

            if (cine.registrarOperario(operario)) {
                JOptionPane.showMessageDialog(
                        null, "Operario registrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(
                        null, "No fue posible registrar el operario. "
                                + "Verifique los datos ingresados.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null, "El salario debe ser numerico.");
        }
    }

    // PROGRAMAR FUNCION

    public static void programarFuncion(Cine cine) {

        Pelicula pelicula = seleccionarPelicula(cine);

        if (pelicula == null) {
            return;
        }

        Sala sala = seleccionarSala(cine);

        if (sala == null) {
            return;
        }

        String codigo = JOptionPane.showInputDialog(
                "Codigo de la funcion:");

        if (codigo == null || codigo.trim().isEmpty()) {
            return;
        }

        String fecha = JOptionPane.showInputDialog(
                "Fecha de la funcion (dd/MM/yyyy):");

        if (fecha == null || !cine.verificarFecha(fecha)) {
            JOptionPane.showMessageDialog(
                    null, "Fecha no valida.");
            return;
        }

        String hora = JOptionPane.showInputDialog(
                "Hora de inicio (HH:mm):");

        if (hora == null || !cine.verificarHora(hora)) {
            JOptionPane.showMessageDialog(
                    null, "Hora no valida.");
            return;
        }

        try {

            String entradaPrecio = JOptionPane.showInputDialog(
                    "Precio base de la boleta:");

            if (entradaPrecio == null) {
                return;
            }

            double precio = Double.parseDouble(entradaPrecio);

            Funcion funcion = new Funcion(
                    codigo.trim(),
                    fecha.trim(),
                    hora.trim(),
                    precio,
                    pelicula,
                    sala
            );

            if (cine.programarFuncion(funcion)) {
                JOptionPane.showMessageDialog(
                        null, "Funcion programada correctamente.");
            } else {
                JOptionPane.showMessageDialog(
                        null, "No fue posible programar la funcion. "
                                + "Compruebe que no exista un cruce de horario "
                                + "o que el codigo no este repetido.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null, "El precio debe ser numerico.");
        }
    }

    // CONSULTAR FUNCIONES

    public static void consultarFunciones(Cine cine) {

        String resultado = obtenerFunciones(cine);

        if (resultado.isEmpty()) {
            resultado = "No hay funciones programadas.";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    public static String obtenerFunciones(Cine cine) {

        String resultado = "";

        for (Funcion funcion : cine.getListFunciones()) {

            resultado += "Codigo: " + funcion.getCodigo()
                    + "\nPelicula: "
                    + funcion.getPelicula().getTitulo()
                    + "\nFecha: " + funcion.getFecha()
                    + "\nHora: " + funcion.getHoraInicio()
                    + "\nSala: " + funcion.getSala().getNombre()
                    + "\nAsientos disponibles: "
                    + funcion.consultarAsientosDisponibles()
                    + "\n\n";
        }

        return resultado;
    }

    // VENDER BOLETAS

    public static void venderBoletas(Cine cine) {

        if (cine.getListClientes().isEmpty()
                || cine.getListOperarios().isEmpty()
                || cine.getListFunciones().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null, "Debe registrar clientes, operarios "
                            + "y funciones antes de vender boletas.");
            return;
        }

        String codigoVenta = JOptionPane.showInputDialog(
                "Codigo de la venta:");

        if (codigoVenta == null || codigoVenta.trim().isEmpty()) {
            return;
        }

        String fecha = JOptionPane.showInputDialog(
                "Fecha de la venta (dd/MM/yyyy):");

        if (fecha == null || !cine.verificarFecha(fecha)) {
            JOptionPane.showMessageDialog(
                    null, "Fecha no valida.");
            return;
        }

        Cliente cliente = seleccionarCliente(cine);

        if (cliente == null) {
            return;
        }

        Operario operario = seleccionarOperario(cine);

        if (operario == null) {
            return;
        }

        Funcion funcion = seleccionarFuncion(cine);

        if (funcion == null) {
            return;
        }

        Venta venta = new Venta(
                codigoVenta.trim(), fecha.trim(), cliente, operario);

        int numeroBoleta = 1;
        boolean continuar = true;

        while (continuar) {

            JOptionPane.showMessageDialog(
                    null, mostrarDisponibilidadAsientos(
                            cine, funcion, venta));

            String fila = JOptionPane.showInputDialog(
                    "Ingrese la fila del asiento (A, B o C):");

            if (fila == null || fila.trim().isEmpty()) {
                break;
            }

            fila = fila.trim().toUpperCase();

            String entradaNumero = JOptionPane.showInputDialog(
                    "Ingrese el numero del asiento (1, 2 o 3):");

            if (entradaNumero == null) {
                break;
            }

            try {

                int numero = Integer.parseInt(entradaNumero);

                boolean disponible = cine.verificarAsientoDisponible(
                        funcion, fila, numero);

                for (Boleta boleta : venta.getListBoletas()) {

                    if (boleta.getFuncion().getCodigo().equalsIgnoreCase(
                            funcion.getCodigo())
                            && boleta.getFila().equalsIgnoreCase(fila)
                            && boleta.getNumeroAsiento() == numero) {

                        disponible = false;
                    }
                }

                if (!funcion.getSala().verificarAsiento(fila, numero)) {

                    JOptionPane.showMessageDialog(
                            null, "Ese asiento no existe.");

                } else if (!disponible) {

                    JOptionPane.showMessageDialog(
                            null, "Ese asiento ya esta ocupado "
                                    + "o fue seleccionado en esta venta.");

                } else {

                    Boleta boleta = new Boleta(
                            codigoVenta.trim() + "-" + numeroBoleta,
                            fila,
                            numero,
                            funcion,
                            venta
                    );

                    if (venta.agregarBoleta(boleta)) {

                        numeroBoleta++;

                        JOptionPane.showMessageDialog(
                                null, "Boleta agregada.\n"
                                        + "Asiento: " + fila + numero
                                        + "\nPrecio: $" + boleta.getValorPagado());

                    } else {
                        JOptionPane.showMessageDialog(
                                null, "No fue posible agregar la boleta.");
                    }
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null, "El numero debe ser numerico.");
            }

            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea comprar otra boleta para esta funcion?",
                    "Venta de boletas",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta != JOptionPane.YES_OPTION) {
                continuar = false;
            }
        }

        if (venta.getListBoletas().isEmpty()) {

            funcion.getListVentas().remove(venta);

            JOptionPane.showMessageDialog(
                    null, "La venta fue cancelada.");
            return;
        }

        if (cine.realizarVenta(venta)) {

            JOptionPane.showMessageDialog(
                    null, "VENTA REALIZADA\n\n"
                            + "Cliente: " + cliente.getNombreCompleto()
                            + "\nBoletas: " + venta.consultarCantidadBoletas()
                            + "\nTotal: $" + venta.calcularTotalVenta());

        } else {

            funcion.getListVentas().remove(venta);

            JOptionPane.showMessageDialog(
                    null, "No fue posible completar la venta.");
        }
    }

    // MOSTRAR DISPONIBILIDAD ACTUALIZADA

    public static String mostrarDisponibilidadAsientos(
            Cine cine, Funcion funcion, Venta ventaActual) {

        String resultado = "FUNCION: "
                + funcion.getPelicula().getTitulo()
                + "\nCodigo: " + funcion.getCodigo()
                + "\nSala: " + funcion.getSala().getNombre()
                + "\n\n";

        int columnas = funcion.getSala().getColumnas();

        for (Asiento asiento : funcion.getSala().getListAsientos()) {

            boolean disponible = cine.verificarAsientoDisponible(
                    funcion, asiento.getFila(), asiento.getNumero());

            for (Boleta boleta : ventaActual.getListBoletas()) {

                if (boleta.getFuncion().getCodigo().equalsIgnoreCase(
                        funcion.getCodigo())
                        && boleta.getFila().equalsIgnoreCase(
                        asiento.getFila())
                        && boleta.getNumeroAsiento() == asiento.getNumero()) {

                    disponible = false;
                }
            }

            resultado += "[" + asiento.getFila()
                    + asiento.getNumero() + "] "
                    + (disponible ? "Disponible" : "Ocupado")
                    + "    ";

            if (asiento.getNumero() == columnas) {
                resultado += "\n";
            }
        }

        return resultado;
    }

    // CONSULTAR VENTAS

    public static void consultarVentas(Cine cine) {

        if (cine.getListVentas().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, "No hay ventas registradas.");
            return;
        }

        String resultado = "VENTAS REGISTRADAS\n\n";

        for (Venta venta : cine.getListVentas()) {

            resultado += "Codigo: " + venta.getCodigo()
                    + "\nFecha: " + venta.getFecha()
                    + "\nCliente: "
                    + venta.getCliente().getNombreCompleto()
                    + "\nOperario: "
                    + venta.getOperario().getNombreCompleto()
                    + "\nBoletas:\n" + venta.consultarBoletas()
                    + "\nTotal: $" + venta.calcularTotalVenta()
                    + "\n-----------------------------\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    // CONSULTAR OCUPACION E INGRESOS

    public static void consultarOcupacionIngresos(Cine cine) {

        Funcion funcion = seleccionarFuncion(cine);

        if (funcion == null) {
            return;
        }

        int capacidad = funcion.getSala().consultarCantidadAsientos();
        int disponibles = funcion.consultarAsientosDisponibles();
        int vendidos = capacidad - disponibles;

        double ingresos = cine.calcularIngresosFuncion(
                funcion.getCodigo());

        String resultado = "OCUPACION E INGRESOS\n\n"
                + "Codigo de funcion: " + funcion.getCodigo()
                + "\nPelicula: " + funcion.getPelicula().getTitulo()
                + "\nSala: " + funcion.getSala().getNombre()
                + "\nCapacidad: " + capacidad
                + "\nBoletas vendidas: " + vendidos
                + "\nAsientos disponibles: " + disponibles
                + "\nPorcentaje de ocupacion: "
                + (capacidad > 0 ? vendidos * 100.0 / capacidad : 0)
                + "%"
                + "\nIngresos: $" + ingresos;

        JOptionPane.showMessageDialog(null, resultado);
    }
}