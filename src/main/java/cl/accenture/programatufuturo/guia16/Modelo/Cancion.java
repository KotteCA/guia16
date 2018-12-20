package cl.accenture.programatufuturo.guia16.Modelo;

public class Cancion {
    private int idCancion, duracion;
    private String nombre, autor,genero;

    public Cancion (){
        this.idCancion= 0;
        this.duracion =0;
        this.nombre="";
        this.autor="";
        this.genero="";
    }
    public Cancion(int idCancion, int duracion, String nombre, String autor, String genero) {
        this.idCancion = idCancion;
        this.duracion = duracion;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
    }

    public int getIdCancion() {
        return idCancion;
    }
    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cancion)) return false;
        Cancion cancion = (Cancion) o;
        return idCancion == cancion.idCancion;
    }

}
