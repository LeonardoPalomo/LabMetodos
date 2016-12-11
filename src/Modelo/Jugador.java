package Modelo;

import Controlador.ControladorLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Random;
public class Jugador {
    
   private String nombre;
   private int id;
   private String contrasena;
   private int oro;
   private int malla;
   private int[] asigAprobadas;
   private ArrayList<Personaje> personajes;
   private Item[] inventario;
   private String pjPrincipal;
   private int rolPjPrincipal;
   private int subrolPjPrincipal;
   private String pjSecundario;
   private int rolPjSecundario;
   private int subrolPjSecundario;
   private int victorias;
   private int derrotas;
   private int rd;
   
   public static String usuarioAdmin = "Admin";
   public static String passAdmin = "666";
   
    public Jugador(String nombre, String password) throws SQLException{
        this.nombre = nombre;
        this.contrasena = password;
    }
    
    public Jugador(String nombre, String password, int malla, String pjPrincipal, int rolPjPrincipal, int subrolPjPrincipal, String pjSecundario, int rolPjSecundario, int subrolPjSecundario, int oro, int victorias, int derrotas){
        this.nombre = nombre;
        this.contrasena = password;
        this.malla = malla;
        this.pjPrincipal = pjPrincipal;
        this.rolPjPrincipal = rolPjPrincipal;
        this.subrolPjPrincipal = subrolPjPrincipal;
        this.pjSecundario = pjSecundario;
        this.rolPjSecundario = rolPjSecundario;
        this.subrolPjSecundario = subrolPjSecundario;
        this.oro = oro;
        this.victorias = victorias;
        this.derrotas = derrotas;
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

    public int getMalla() {
        return malla;
    }

    public int[] getAsigAprobadas() {
        return asigAprobadas;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public Item[] getInventario() {
        return inventario;
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
   
    public void comprar(Item objeto) {}
   
    public void usarItem(Item item) {}
    
    // Funciones BDD
    
    public void save() throws SQLException{
        Conexion conexion = new Conexion();
        boolean resultado = conexion.conectar();
        Statement stmt = conexion.crearConsulta();
        final String consulta = "INSERT INTO USUARIO (NOMBRE_USUARIO,CONTRASEÑA,MALLA,PJ_PRINCIPAL,ROL_PJ_PRINCIPAL,SUBROL_PJ_PRINCIPAL,PJ_SECUNDARIO,ROL_PJ_SECUNDARIO,SUBROL_PJ_SECUNDARIO) VALUES " + "('" + this.nombre + "','" + this.contrasena + "'," + this.malla + ",'" + this.pjPrincipal + "'," + this.rolPjPrincipal + "," + this.subrolPjPrincipal + ",'" + this.pjSecundario + "'," + this.rolPjSecundario + "," + this.subrolPjSecundario + ")";
        stmt.executeUpdate(consulta);
        stmt.close();
    }
    
    public static void actualizarOro(int oro) throws SQLException {
        Conexion conexion = new Conexion();
        boolean resultado = conexion.conectar();
        Statement stmt = conexion.crearConsulta();
        final String consultaOro = "SELECT ORO FROM USUARIO WHERE NOMBRE_USUARIO = '" + ControladorLogin.usuarioActivo +"'";
       
        ResultSet resultados;
        resultados = stmt.executeQuery(consultaOro);
        
        if (resultados.next()==true) {
            int oroGuardado = resultados.getInt("ORO");
            resultados.close();
            stmt.close();
            int oroFinal = oroGuardado + oro;
            final String consultaUpdateOro = "UPDATE USUARIO SET ORO = " + oroFinal + " WHERE NOMBRE_USUARIO = '"+ ControladorLogin.usuarioActivo + "'";   
            Statement stmt2 = conexion.crearConsulta();
            stmt2.executeUpdate(consultaUpdateOro);
            stmt2.close();
            conexion.desconectar();
        }
        else {
            //System.out.println("No Existe");
            conexion.desconectar();
        }
    }
    
    public static Jugador obtener(String nombre,String password2) throws SQLException{
        Conexion conexion = new Conexion();
        boolean resultado = conexion.conectar();
        Statement stmt = conexion.crearConsulta();
        final String consulta = "SELECT NOMBRE_USUARIO,CONTRASEÑA,MALLA,PJ_PRINCIPAL,ROL_PJ_PRINCIPAL,SUBROL_PJ_PRINCIPAL,PJ_SECUNDARIO,ROL_PJ_SECUNDARIO,SUBROL_PJ_SECUNDARIO,ORO,VICTORIAS,DERROTAS FROM USUARIO WHERE NOMBRE_USUARIO = '" + nombre +"'";        
        
        ResultSet resultados;
        resultados = stmt.executeQuery(consulta);
        
        if (resultados.next()==true) {
            String nombre2 = resultados.getString("NOMBRE_USUARIO");
            String password = resultados.getString("CONTRASEÑA");
            int malla = resultados.getInt("MALLA");
            String pjPrinc = resultados.getString("PJ_PRINCIPAL");
            int rolPjPr = resultados.getInt("ROL_PJ_PRINCIPAL");
            int subrolPjPr = resultados.getInt("SUBROL_PJ_PRINCIPAL");
            String pjSecun = resultados.getString("PJ_SECUNDARIO");
            int rolPjSe = resultados.getInt("ROL_PJ_SECUNDARIO");
            int subrolPjSe = resultados.getInt("SUBROL_PJ_SECUNDARIO");
            int oro = resultados.getInt("ORO");
            int victorias = resultados.getInt("VICTORIAS");
            int derrotas = resultados.getInt("DERROTAS");
            resultados.close();
            stmt.close();
            conexion.desconectar();
            return new Jugador(nombre2, password,malla,pjPrinc,rolPjPr,subrolPjPr,pjSecun,rolPjSe,subrolPjSe,oro,victorias,derrotas);
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
    
   public static void actualizarJugadas(int valor) throws SQLException {
        Conexion conexion = new Conexion();
        boolean resultado = conexion.conectar();
        Statement stmt = conexion.crearConsulta();
        String consulta = "";
        if (valor ==0){
            consulta = "SELECT VICTORIAS FROM USUARIO WHERE NOMBRE_USUARIO = '" + ControladorLogin.usuarioActivo +"'";
        }
        else{
            consulta = "SELECT DERROTAS FROM USUARIO WHERE NOMBRE_USUARIO = '" + ControladorLogin.usuarioActivo +"'";    
        }
        ResultSet resultados;
        resultados = stmt.executeQuery(consulta);
        int resultadoGuardado;
        String columnyu="";
        if (resultados.next()==true) {
            if(valor==0){
                resultadoGuardado = resultados.getInt("VICTORIAS");
                columnyu="VICTORIAS";
            }
            else{
                resultadoGuardado = resultados.getInt("DERROTAS");
                columnyu="DERROTAS";
            }
            resultados.close();
            stmt.close();
            int resultadoG = 0;
            resultadoG = resultadoGuardado +1;
            
            final String consultaUpdate = "UPDATE USUARIO SET " +columnyu+" = " + resultadoG + " WHERE NOMBRE_USUARIO = '"+ ControladorLogin.usuarioActivo + "'";   
            Statement stmt2 = conexion.crearConsulta();
            stmt2.executeUpdate(consultaUpdate);
            stmt2.close();
            conexion.desconectar();
        }else {
            //System.out.println("No Existe");
            conexion.desconectar();
        }
    } 
    public boolean donarJugador (String[] listaCpu , String[] listaJugador){
        rd = new Random().nextInt(5);
        int largo= listaJugador.length;
        boolean comprobador =false;
        String personajeObtenido= listaCpu[rd];
        for(int i=0; i<largo;i++){
            if(listaJugador[i]!=null){

            }else{
                listaJugador[i]= personajeObtenido;
                comprobador= true;
                break;
             }

         }
        return comprobador;
    }
}
