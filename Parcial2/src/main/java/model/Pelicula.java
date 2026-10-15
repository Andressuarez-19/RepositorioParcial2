package model;

public class Pelicula {

    private String codigo;
    private String titulo;
    private int duracion;
    private GeneroPelicula genero;
    private String clasificacionEdad;

    public Pelicula(String codigo, String titulo, int duracion,
                    GeneroPelicula genero, String clasificacionEdad) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public GeneroPelicula getGenero() {
        return genero;
    }

    public void setGenero(GeneroPelicula genero) {
        this.genero = genero;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", genero=" + genero +
                ", clasificacionEdad='" + clasificacionEdad + '\'' +
                '}';
    }
}