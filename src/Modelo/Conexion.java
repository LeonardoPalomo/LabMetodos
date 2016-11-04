
package Modelo;

import java.sql.*;

public class Conexion {
    private static final String SERVIDOR = "localhost";
    private static final String PUERTO = "1527";
    private static final String NOMBRE_BD = "Metodos 2 2016";
    private static final String USUARIO = "moises";
    private static final String PASSWORD = "1234";
    public static final String URL_CONEXION = "jdbc:derby://" + SERVIDOR + ":"+ PUERTO +"/"+ NOMBRE_BD +";user="+ USUARIO +";password=" + PASSWORD;
    
    private Connection conexion = null;
    
    public boolean conectar() throws SQLException
    {
        this.conexion = DriverManager.getConnection(URL_CONEXION);
        if(this.conexion != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void desconectar() throws SQLException
    {
        if(this.conexion != null)
        {
            this.conexion.close();
        }
    }
    
    public Statement crearConsulta() throws SQLException
    {
        if(this.conexion != null)
        {
            return this.conexion.createStatement();
        }
        else
        {
            return null;
        }
    }
}
