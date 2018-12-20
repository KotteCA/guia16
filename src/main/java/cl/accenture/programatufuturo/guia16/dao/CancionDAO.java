package cl.accenture.programatufuturo.guia16.dao;

import cl.accenture.programatufuturo.guia16.Exception.DriverException;
import cl.accenture.programatufuturo.guia16.Exception.SinConexionException;
import cl.accenture.programatufuturo.guia16.Exception.StatementException;
import cl.accenture.programatufuturo.guia16.Modelo.Cancion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CancionDAO {
    private Conexion conect;

    public CancionDAO() {
        this.conect = new Conexion();
    }

    public CancionDAO(Conexion conect) {
        this.conect = conect;
    }

    public Conexion getConect() {
        return conect;
    }

    public void setConect(Conexion conect) {
        this.conect = conect;
    }

    //Almacenar Cancion
    public void almacenarCancion(Cancion a) throws DriverException, SinConexionException, StatementException {
        try {
            PreparedStatement pstatementInsert = getConect().obtenerConexion().prepareStatement("INSERT INTO cancion(idCancion,nombre,autor,genero,duración)" + "VALUES(?,?,?,?,?)");
            pstatementInsert.setInt(1, a.getIdCancion());
            pstatementInsert.setString(2, a.getNombre());
            pstatementInsert.setString(3, a.getAutor());
            pstatementInsert.setString(4, a.getGenero());
            pstatementInsert.setInt(5, a.getDuracion());
            pstatementInsert.executeUpdate();
        } catch (SQLException e) {
            throw new StatementException("Error al ingresar la cancion", e);
        }
    }

    //obtener todas las canciones
    public void obtener() throws DriverException, SinConexionException, StatementException {
        try {
            PreparedStatement preparedStatement = getConect().obtenerConexion().prepareStatement("SELECT nombre FROM canciones");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new StatementException("Error ", e);
        }
    }

    public LinkedList<Cancion> obtenerCancion(String a) throws DriverException, SinConexionException, StatementException {
        try {
            LinkedList<Cancion> cancions = new LinkedList<Cancion>();
            PreparedStatement preparedStatement = getConect().obtenerConexion().prepareStatement("SELECT nombre FROM cancion WHERE nombre=?");
            preparedStatement.setString(1, a);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setNombre(rs.getString("nombre"));
                cancions.add(cancion);
            }
            return cancions;
        } catch (SQLException e) {
            throw new StatementException("Error al obtener cancion", e);
        }
    }

    public LinkedList<Cancion> Buscar(String nombre) throws SinConexionException, DriverException, StatementException {
        try {
            LinkedList<Cancion> cancions = new LinkedList<Cancion>();
            PreparedStatement preparedStatement = getConect().obtenerConexion().prepareStatement("SELECT nombre FROM cancion WHERE nombre=?");
            preparedStatement.setString(1, nombre);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setNombre(rs.getString("nombre"));
                cancions.add(cancion);
            }
            return cancions;
        } catch (SQLException e) {
            throw new StatementException("Error al buscar cancion", e);
        }
    }

}
