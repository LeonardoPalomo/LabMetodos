package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static java.lang.Math.abs;
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
   private int[] posicion;
   
   /**public Personaje(int hp, int mana, int atkCerca, int atkLejos, int def){
       this.hpTotal = hp;
       this.manaTotal = mana;
       this.atkCerca = atkCerca;
       this.atkLejos = atkLejos;
       this.def = def;
   }**/
   
   public void atacarCerca(int[] posObjetivo) {}
   
   /**
    * Funcion que verifica si es posible el ataque a larga distancia
    * @param posObjetivo arreglo que indica la posicion del objetivo
     * @return true si se puede o false si no se puede
    */
   public boolean verificarAtacarLejos(int[] posObjetivo) {
       int difFila; //diferencia de fila
       int difColumna; //diferencia de columna
       int suma;
       difFila = abs(posicion[1] - posObjetivo[1]);
       difColumna = abs(posicion[0] - posObjetivo[0]);
       suma = difFila + difColumna;
       return suma == 5 || suma == 6;
   }
   
   /**
    * Funcion que realiza el ataque lejos
    * @param def la defensa del personaje objetivo
    * @return el daño realizado (restar despues con el hp)
    */
   public int atacarLejos(int def){
       int damage;
       damage = this.atkLejos - def;
       if (damage < 0){
           damage = 0;
       }
       return damage;
   }
  
   public void mover(int[] posInicial, int[] posFinal) {}
   
}
