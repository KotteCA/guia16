package cl.accenture.programatufuturo.guia16.dao;

import cl.accenture.programatufuturo.guia16.Exception.DriverException;
import cl.accenture.programatufuturo.guia16.Exception.SinConexionException;
import cl.accenture.programatufuturo.guia16.Exception.StatementException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String direccionIP;
    private int puerto;
    private String nombre, usuario, password;


    public Conexion(){
        this.puerto =0;
        this.direccionIP="";
        this.nombre="";
        this.usuario="";
        this.password="";
    }

    public Conexion(String direccionIP,int puerto, String nombre, String usuario, String password) {
        this.puerto = puerto;
        this.direccionIP = direccionIP;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public int getPuerto() {
        return puerto;
    }
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    public String getDireccionIP() {
        return direccionIP;
    }
    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    public Connection obtenerConexion()throws DriverException, SinConexionException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conct = DriverManager.getConnection(
                    "jdbc:mysql;//" + this.direccionIP + ":" + this.puerto + "/" + this.nombre, this.usuario, this.password);
            return conct;
        }catch (ClassNotFoundException e){
            throw new DriverException("No se ha podido cargar el driver",e);
        }catch (SQLException e){
            throw new SinConexionException("Error al conectar con la base",e);
        }
    }


}
