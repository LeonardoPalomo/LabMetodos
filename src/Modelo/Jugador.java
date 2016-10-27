package Modelo;

/***********************************************************************
 * Module:  Jugador.java
 * Author:  MoisésJoshua
 * Purpose: Defines the Class Jugador
 ***********************************************************************/

import java.util.*;

public class Jugador {
    
   private String nombre;
   private int id;
   private String contrasena;
   private int oro;
   private Malla malla;
   private int[] asigAprobadas;
   private Personaje[] personajes;
   private Item[] inventario;
   

   public boolean existeUsuario(String username) {
      return false;
   }
   

   public boolean verificarPassword(String password, String verificacionPassword) {
      return false;
   }
   
   public boolean verificarDatos(String username, String password) {
      return false;
   }
   
   public void registrarDatos(String username, String password, int rolPjPrincipal, int rolPjAmigo, int malla) {}
   
   public void comprar(Item objeto) {}
   
   public void usarItem(Item item) {}

}