package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Jugador {
    
   private String nombre;
   private int id;
   private String contrasena;
   private int oro;
   private Malla malla;
   private int tipoMalla;//no va
   private int[] asigAprobadas;
   private Personaje[] personajes;
   private Item[] inventario;
   private boolean tipo;//no va
   private String pjPrincipal;
   private int rolPjPrincipal;
   private String pjSecundario;
   private int rolPjSecundario;
   
    public Jugador(String nombre, String password) throws SQLException{
        this.nombre = nombre;
        this.contrasena = password;
    }
    
    public Jugador(String nombre, String password, int malla, String pjPrincipal, int rolPjPrincipal, String pjSecundario, int rolPjSecundario){
        this.nombre = nombre;
        this.contrasena = password;
        this.tipoMalla = malla;
        this.pjPrincipal = pjPrincipal;
        this.rolPjPrincipal = rolPjPrincipal;
        this.pjSecundario = pjSecundario;
        this.rolPjSecundario = rolPjSecundario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return contrasena;
    }

    public int getId(){
        return id;
    }
    
    public int getOro(){
        return oro;
    }

    public Malla getMalla() {
        return malla;
    }

    public int[] getAsigAprobadas() {
        return asigAprobadas;
    }

    public Personaje[] getPersonajes() {
        return personajes;
    }

    public Item[] getInventario() {
        return inventario;
    }

    public boolean isTipo() {
        return tipo;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.contrasena = password;
    }
    
    public boolean existeUsuario(String username) {
        if (username.equals(this.nombre)){
           return true;
        }
        else{
            return false;
        }
    }
   

    public boolean verificarPassword(String password, String verificacionPassword) {
        return false;
    }
   
    public boolean verificarDatos(String username, String password) {
        if (username.equals(this.nombre)){ 
                if (password.equals(this.contrasena)){
                    return true;
                }
                else{
                    return false;
                }
        }
        else{
           return false; 
        }
    }
   
    public void registrarDatos(String username, String password, int rolPjPrincipal, int rolPjAmigo, int malla) {}
   
    public void comprar(Item objeto) {}
   
    public void usarItem(Item item) {}
    
    // Funciones BDD
    
    public void save() throws SQLException{
        Conexion conexion = new Conexion();
        boolean resultado = conexion.conectar();
        Statement stmt = conexion.crearConsulta();
        final String consulta = "INSERT INTO USUARIO (NOMBRE_USUARIO,CONTRASEÑA,MALLA,PJ_PRINCIPAL,ROL_PJ_PRINCIPAL,PJ_SECUNDARIO,ROL_PJ_SECUNDARIO) VALUES " + "('" + this.nombre + "','" + this.contrasena + "'," + this.tipoMalla + ",'" + this.pjPrincipal + "'," + this.rolPjPrincipal + ",'" + this.pjSecundario + "'," + this.rolPjSecundario + ")";
        stmt.executeUpdate(consulta);
        stmt.close();
    }
    
    public static Jugador obtener(String nombre,String password2) throws SQLException{
        Conexion conexion = new Conexion();
        boolean resultado = conexion.conectar();
        Statement stmt = conexion.crearConsulta();
        final String consulta = "SELECT NOMBRE_USUARIO,CONTRASEÑA FROM USUARIO WHERE NOMBRE_USUARIO = '" + nombre +"'";        
        
        ResultSet resultados;
        resultados = stmt.executeQuery(consulta);
        
        if (resultados.next()==true) {
            String nombre2 = resultados.getString("NOMBRE_USUARIO");
            String password = resultados.getString("CONTRASEÑA");
            resultados.close();
            stmt.close();
            conexion.desconectar();
            return new Jugador(nombre2, password);
        }
        else {
            //System.out.println("No Existe");
            conexion.desconectar();
            return null;
        }
        
    }
    
    public static boolean obtener(String nombre) throws SQLException{
        Conexion conexion = new Conexion();
        boolean resultado = conexion.conectar();
        Statement stmt = conexion.crearConsulta();
        final String consulta = "SELECT NOMBRE_USUARIO FROM USUARIO WHERE NOMBRE_USUARIO = '" + nombre + "'";      
        
        ResultSet resultados;
        resultados = stmt.executeQuery(consulta);
        
        return resultados.next();
    }
}