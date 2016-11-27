package Modelo;

import Controlador.ControladorLogin;
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
   private int[] posicion = new int[2];
   private boolean esCpu; //true es cpu, false es del jugador

   //Constructor provisorios
   public Personaje(){
       this.nombre = "null";
       this.hpTotal = 0;
       this.hpActual = hpTotal;
       this.manaTotal = 0;
       this.manaActual = manaTotal;
       this.atkCerca = 0;
       this.atkLejos = 0;
       this.spAtkCerca = 0;
       this.spAtkLejos = 0;
       this.def = 0;
       this.spDef = 0;
       this.experiencia = 0;
       this.nivel = 0;
       this.movTotal = 0;
       this.movActual = movTotal;
       this.ptsTraicion = 0;
       this.velocidad = 0;
       this.tipo = 0;
       this.rol = 0;
       this.subRol = 0;
       this.dueno = "null";
       this.esCpu = true;
   }
   
   public Personaje(String nombre, int rol, int subRol){
       this.nombre = nombre;
       switch(rol){
           case 1:
               this.hpTotal = 100;
               this.hpActual = hpTotal;
               this.manaTotal = 0;
               this.manaActual = manaTotal;
               this.atkCerca = 20;
               this.atkLejos = 5;
               this.def = 8;
               this.spDef = 6;
               this.nivel = 1;
               this.movTotal = 8;
               this.movActual = movTotal;
               this.velocidad = 10;
               this.tipo = 1;
               this.rol = rol;
               this.subRol = 0;
               this.stock[0] = 3;
               this.stock[1] = 3;
               this.stock[2] = 3;
               this.stock[3] = 1;
               this.esCpu = false;
               this.setDueño(ControladorLogin.usuarioActivo);
               break;
           case 2:
               this.hpTotal = 80;
               this.hpActual = hpTotal;
               this.manaTotal = 0;
               this.manaActual = manaTotal;
               this.atkCerca = 5;
               this.atkLejos = 20;
               this.def = 6;
               this.spDef = 5;
               this.nivel = 1;
               this.movTotal = 8;
               this.movActual = movTotal;
               this.velocidad = 11;
               this.tipo = 1;
               this.rol = rol;
               this.subRol = 0;
               this.stock[0] = 3;
               this.stock[1] = 3;
               this.stock[2] = 3;
               this.stock[3] = 1;
               this.esCpu = false;
               this.setDueño(ControladorLogin.usuarioActivo);
               break;
           case 3:
               this.hpTotal = 90;
               this.hpActual = hpTotal;
               this.manaTotal = 10;
               this.manaActual = manaTotal;
               this.atkCerca = 15;
               this.atkLejos = 8;
               this.spAtkCerca = 10;
               this.spAtkLejos = 6;
               this.def = 7;
               this.spDef = 6;
               this.nivel = 1;
               this.movTotal = 10;
               this.movActual = movTotal;
               this.velocidad = 12;
               this.tipo = 1;
               this.rol = rol;
               this.subRol = 0;
               this.stock[0] = 3;
               this.stock[1] = 3;
               this.stock[2] = 3;
               this.stock[3] = 1;
               this.esCpu = false;
               this.setDueño(ControladorLogin.usuarioActivo);
               break;
           case 4:
               this.hpTotal = 70;
               this.hpActual = hpTotal;
               this.manaTotal = 30;
               this.manaActual = manaTotal;
               this.atkCerca = 5;
               this.atkLejos = 5;
               this.def = 5;
               this.spDef = 8;
               this.nivel = 1;
               this.movTotal = 6;
               this.movActual = movTotal;
               this.velocidad = 9;
               this.tipo = 1;
               this.rol = rol;
               switch(subRol){
                   case 1:
                       this.spAtkCerca = 20;
                       this.spAtkLejos = 10;
                       break;
                   case 2:
                       this.spAtkCerca = 10;
                       this.spAtkLejos = 20;
                       break;
                   case 3:
                       this.spAtkCerca = 10;
                       this.spAtkLejos = 10;
               }
               this.subRol = subRol;
               this.stock[0] = 3;
               this.stock[1] = 3;
               this.stock[2] = 3;
               this.stock[3] = 1;
               this.esCpu = false;
               this.setDueño(ControladorLogin.usuarioActivo);
               break;
       }
       
   }
   
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

    public String[] getDatosSelPj(){
        String[] datos = new String[15];
        datos[0] = this.getNombre();
        datos[1] = String.valueOf(this.getNivel());
        datos[2] = String.valueOf(this.getExperiencia());
        String tipo = "";
        switch(this.getTipo()){
            case 1:
                tipo = "Alumno";
                break;
            case 2:
                tipo = "Ayudante";
                break;
            case 3:
                tipo = "Profesor";
                break;
        }
        datos[3] = tipo;
        String rol = "";
        switch(this.getRol()){
            case 1:
                rol = "Guerrero";
                break;
            case 2:
                rol = "Arquero";
                break;
            case 3:
                rol = "Ninja";
                break;
            case 4:
                rol = "Mago";
                break;
        }
        datos[4] = rol;
        String subRol = "";
        switch(this.getSubRol()){
            case 1:
                subRol = "Humanista";
                break;
            case 2:
                subRol = "Tecnólogo";
                break;
            case 3:
                subRol = "Médico";
                break;
            case 0:
                subRol = "";
                break;
        }
        datos[5] = subRol;
        datos[6] = String.valueOf(this.getHpTotal());
        datos[7] = String.valueOf(this.getManaTotal());
        datos[8] = String.valueOf(this.getAtkCerca());
        datos[9] = String.valueOf(this.getAtkLejos());
        datos[10] = String.valueOf(this.getSpAtkCerca());
        datos[11] = String.valueOf(this.getSpAtkLejos());
        datos[12] = String.valueOf(this.getDef());
        datos[13] = String.valueOf(this.getSpDef());
        datos[14] = String.valueOf(this.getVelocidad());
        return datos;
    }
   
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
    
    public int[] getPosicion(){
        return posicion;
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
    
    public void setPosicion(int[] posicion){
        this.posicion = posicion;
    }
    //Sobrecarga
    public void setPosicion(int i, int j){
        this.posicion[0] = i;
        this.posicion[1] = j;
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
