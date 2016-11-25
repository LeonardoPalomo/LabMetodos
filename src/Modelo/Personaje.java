package Modelo;

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
   private int tipo; //1 alumno, 2 ayudante, 3 profesor
   private int rol; //1 guerrero, 2 arquero, 3 ninja, 4 mago
   private int subRol; //sólo para mago: 1 humanista, 2 tecnologo, 3 medico, 0 para no mago
   private int[] stock = new int[4]; //Array de ints: [0] atkBajo, [1] atkMedio, [2] atkAlto, [3] especial
   private int precio;
   private String dueno;
   private int[] posicion;
   private boolean esCpu; //true es cpu, false es del jugador

   //Constructor provisorios
   public Personaje(){}
   
   public Personaje(int i){
       this.nombre = "Genérico "+i;
       this.hpTotal = i*10;
       this.hpActual = hpTotal;
       this.manaTotal = i*5;
       this.manaActual = manaTotal;
       this.atkCerca = i*2;
       this.atkLejos = (int)Math.round(i*1.5);
       this.spAtkCerca = (int)Math.round(i*2.5);
       this.spAtkLejos = i;
       this.def = (int)Math.round(i/2);
       this.spDef = i;
       this.nivel = i;
       this.movTotal = 10-i;
       this.movActual = movTotal;
       this.ptsTraicion = 0;
       this.velocidad = i;
       this.tipo = (i % 3)+1;
       this.rol = (i<4)?i:4;
       this.subRol = (i<4)?0:i-3;
       this.stock[0] = 3;
       this.stock[1] = 3;
       this.stock[2] = 3;
       this.stock[3] = 1;
       this.esCpu = true;
       setDueño();
   }
   
   /**public Personaje(int hp, int mana, int atkCerca, int atkLejos, int def){
       this.hpTotal = hp;
       this.manaTotal = mana;
       this.atkCerca = atkCerca;
       this.atkLejos = atkLejos;
       this.def = def;
   }**/

   
    public String getNombre() {
        return nombre;
    }

    public int getHpTotal() {
        return hpTotal;
    }

    public int getHpActual() {
        return hpActual;
    }

    public int getManaTotal() {
        return manaTotal;
    }

    public int getManaActual() {
        return manaActual;
    }

    public int getAtkCerca() {
        return atkCerca;
    }

    public int getAtkLejos() {
        return atkLejos;
    }

    public int getSpAtkCerca() {
        return spAtkCerca;
    }

    public int getSpAtkLejos() {
        return spAtkLejos;
    }

    public int getDef() {
        return def;
    }

    public int getSpDef() {
        return spDef;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public int getMovTotal() {
        return movTotal;
    }

    public int getMovActual() {
        return movActual;
    }

    public int getPtsTraicion() {
        return ptsTraicion;
    }

    public Equipamiento[] getEquipamiento() {
        return equipamiento;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getTipo() {
        return tipo;
    }

    public int getRol() {
        return rol;
    }

    public int getSubRol() {
        return subRol;
    }

    public int[] getStock() {
        return stock;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDueno() {
        return dueno;
    }

    public boolean getEsCpu() {
        return esCpu;
    }
    
    public void setDueño(String dueño){
        if(this.esCpu){
            this.dueno = "CPU";
        }
        else{
            this.dueno = dueño;
        }
    }
    //Sobrecarga
    public void setDueño(){
        this.dueno = "CPU";
    }
    
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
       difFila = abs(posicion[1] - posObjetivo[1]); //no estoy seguro si es this.posicion
       difColumna = abs(posicion[0] - posObjetivo[0]);
       suma = difFila + difColumna;
       return suma == 5 || suma == 6;
    }
   
   /**
    * Funcion que verifica si es posible el ataque a corto alcance
    * @param posObjetivo arreglo que indica la posicion del objetivo
    * @return 
    */
    public boolean verificarAtacarCorto(int[] posObjetivo) {
       int difFila; //diferencia de fila
       int difColumna; //diferencia de columna
       int suma;
       difFila = abs(posicion[1] - posObjetivo[1]); //no estoy seguro si es this.posicion
       difColumna = abs(posicion[0] - posObjetivo[0]);
       suma = difFila + difColumna;
       return suma == 1 || suma == 2;
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
    //public boolean posibleMover(int[] posInicial, int[] posFinal)
}
