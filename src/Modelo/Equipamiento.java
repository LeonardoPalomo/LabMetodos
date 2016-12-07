package Modelo;

import java.util.*;

public class Equipamiento extends Item{

    private int rol;    //Rol al que se le puede equipar: 1 guerrero, 2 arquero, 3 ninja, 4 mago, 0 a todos
    private int tipo;   //Tipo de equipamiento: 1 arma, 2 armadura
    private int subtipo;    //Subtipo: para armas - 1 corta distancia, 2 larga distancia, 3 defensivo ; para armaduras - 1 cabeza, 2 torso, 3 piernas, 4 pies
    private int bonusAtkCerca;
    private int bonusAtkLejos;
    private int bonusSpAtkCerca;
    private int bonusSpAtkLejos;
    private int bonusDef;
    private int bonusSpDef;
    private int bonusVida;
    private int bonusMana;
    private int bonusSpeed;
    private int bonusMov;
    private int durabTotal;
    private int durabActual;
   
    //Constructor de prueba, para crear arco de prueba para arquero de prueba... prueba
   public Equipamiento(String nombre){
       this.nombre = nombre;
       this.rol = 2;
       this.tipo = 1;
       this.subtipo = 2;
       this.bonusAtkLejos = 100;
       this.durabTotal = 5;
       this.durabActual = durabTotal;
   }
   
   public boolean verificarRol(int rolUsuario, int rolEquip) {
      return false;
   }
   
   public boolean verificarDurabilidad(int durabActual, int durabTotal) {
      return false;
   }
   
}