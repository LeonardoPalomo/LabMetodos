package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

public class Personaje {
   private String nombre;
   private int hpTotal;
   private int hpActual;
   private int manaTotal;
   private int manaActual;
   private int atkCerca;
   private int atkLejos;
   private int spAtkCerca;
   private int spAtkLejos;
   private int def;
   private int spDef;
   private int experiencia;
   private int nivel;
   private int movTotal;
   private int movActual;
   private int ptsTraicion;
   private Equipamiento[] equipamiento;
   private int velocidad;
   private int tipo;
   private int stock;
   private int precio;
   private String dueno;
   
   public void atacarCerca(int[] posObjetivo) {}
   
   public void atacarLejos(int[] posObjetivo) {}
  
   public void mover(int[] posInicial, int[] posFinal) {}
   
}
