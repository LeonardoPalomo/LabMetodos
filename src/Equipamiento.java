/***********************************************************************
 * Module:  Equipamiento.java
 * Author:  MoisésJoshua
 * Purpose: Defines the Class Equipamiento
 ***********************************************************************/

import java.util.*;

public class Equipamiento extends Item{

   private int rol;
   private int tipo;
   private int subtipo;
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
   
   public boolean verificarRol(int rolUsuario, int rolEquip) {
      return false;
   }
   
   public boolean verificarDurabilidad(int durabActual, int durabTotal) {
      return false;
   }

}