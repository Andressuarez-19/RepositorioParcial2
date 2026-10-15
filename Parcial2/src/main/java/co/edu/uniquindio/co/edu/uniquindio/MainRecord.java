package uniquindio.edu.co;

import uniquindio.edu.co.model.Cine;
import uniquindio.edu.co.model.Pelicula;
import uniquindio.edu.co.model.Sala;
import uniquindio.edu.co.model.TipoSala;
import uniquindio.edu.co.model.GeneroPelicula;

public class MainRecord {

    public static Cine crearCine() {

        Cine cine = new Cine(
                "CinePlus",
                "900123456",
                "Armenia, Quindío"
        );

        // Películas registradas inicialmente

        Pelicula pelicula1 = new Pelicula(
                "1",
                "Avengers",
                180,
                GeneroPelicula.ACCION,
                "12"
        );

        Pelicula pelicula2 = new Pelicula(
                "2",
                "Toy Story",
                90,
                GeneroPelicula.ANIMACION,
                "TODOS"
        );

        cine.registrarPelicula(pelicula1);
        cine.registrarPelicula(pelicula2);

        // Sala tradicional: 9 asientos

        Sala sala1 = new Sala(
                "1",
                "Sala tradicional",
                9,
                TipoSala.TRADICIONAL,
                3,
                3
        );

        // Sala VIP: 9 asientos

        Sala sala2 = new Sala(
                "2",
                "Sala VIP",
                9,
                TipoSala.VIP,
                3,
                3
        );

        // Sala 3D: 9 asientos

        Sala sala3 = new Sala(
                "3",
                "Sala 3D",
                9,
                TipoSala.TRES_D,
                3,
                3
        );

        cine.registrarSala(sala1);
        cine.registrarSala(sala2);
        cine.registrarSala(sala3);

        return cine;
    }
}