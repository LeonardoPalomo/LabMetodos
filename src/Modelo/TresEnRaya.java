/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.ControladorPrincipal;
import Vista.VistaPrincipal;
import java.util.Random;
/**
 *
 * @author HP 1
 */
public class TresEnRaya {
    ControladorPrincipal cp;
    VistaPrincipal vp;

    /**
     * @param args the command line arguments
     */
   /*public static void main(String[] args) {
        ControladorPrincipal cp = new ControladorPrincipal();
        System.out.println("nyuss");
        // TODO code application logic here
    }*/
   
   public String llevarTurnos(String simbolo){
       String nuevoSimbolo = "8=D";
       if((simbolo).equals("X")){
           nuevoSimbolo = "O";
        }
       if((simbolo).equals("O")){
           nuevoSimbolo = "X";
       }
       return nuevoSimbolo;
   }
   
   
   
   
}
   
    

