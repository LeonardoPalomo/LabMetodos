/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.ControladorPrincipalTresEnRaya;
import javax.swing.JButton;
/**
 *
 * @author HP 1
 */
public class TresEnRaya {
    ControladorPrincipalTresEnRaya cp;
    static int recompensa = 1000;

    /**
     * @param args the command line arguments
     
   public static void main(String[] args) {
        ControladorPrincipalTresEnRaya cp = new ControladorPrincipalTresEnRaya();
        System.out.println("nyuss");
        // TODO code application logic here
    }**/
   
   public String llevarTurnos(String simbolo){
       String nuevoSimbolo = "nyu";
       if((simbolo).equals("X")){
           nuevoSimbolo = "O";
        }
       if((simbolo).equals("O")){
           nuevoSimbolo = "X";
       }
       return nuevoSimbolo;
   }
   public String validarGanador(JButton[][] tablero){
       String resultado="";
       //fila 1 
       if (tablero[0][0].getText().equals(tablero[0][1].getText()) && tablero[0][0].getText().equals(tablero[0][2].getText())){
           switch (tablero[0][0].getText()) {
               case "O":
                   resultado="Gana CPU";
                   break;
               case "X":
                   resultado="Gana Jugador";
               
                   break;
           }
           //fila 2
       }else if (tablero[1][0].getText().equals(tablero[1][1].getText()) && tablero[1][0].getText().equals(tablero[1][2].getText())){
           switch (tablero[1][0].getText()) {
               case "O":
                   resultado="Gana CPU";
                   break;
               case "X":
                   resultado="Gana Jugador";
               
                   break;
           }
           //fila 3
       }else if (tablero[2][0].getText().equals(tablero[2][1].getText()) && tablero[2][0].getText().equals(tablero[2][2].getText())){
           switch (tablero[2][0].getText()) {
               case "O":
                   resultado="Gana CPU";
                   break;
               case "X":
                   resultado="Gana Jugador";
               
                   break;
           }
           //columna 1
       }else if (tablero[0][0].getText().equals(tablero[1][0].getText()) && tablero[0][0].getText().equals(tablero[2][0].getText())){
           switch (tablero[0][0].getText()) {
               case "O":
                   resultado="Gana CPU";
                   break;
               case "X":
                   resultado="Gana Jugador";
               
                   break;
           }
           //columna 2
       }else if (tablero[0][1].getText().equals(tablero[1][1].getText()) && tablero[0][1].getText().equals(tablero[2][1].getText())){
           switch (tablero[0][1].getText()) {
               case "O":
                   resultado="Gana CPU";
                   break;
               case "X":
                   resultado="Gana Jugador";
               
                   break;
           }
           //columna 3
       }else if (tablero[0][2].getText().equals(tablero[1][2].getText()) && tablero[0][2].getText().equals(tablero[2][2].getText())){
           switch (tablero[0][2].getText()) {
               case "O":
                   resultado="Gana CPU";
                   break;
               case "X":
                   resultado="Gana Jugador";
               
                   break;
           }
           //diagonal izq->der
       }else if (tablero[0][0].getText().equals(tablero[1][1].getText()) && tablero[0][0].getText().equals(tablero[2][2].getText())){
           switch (tablero[0][0].getText()) {
               case "O":
                   resultado="Gana CPU";
                   break;
               case "X":
                   resultado="Gana Jugador";
               
                   break;
           }
           //diagonal der->izq
       }else if (tablero[0][2].getText().equals(tablero[1][1].getText()) && tablero[0][2].getText().equals(tablero[2][0].getText())){
           switch (tablero[0][2].getText()) {
               case "O":
                   resultado="Gana CPU";
                   break;
               case "X":
                   resultado="Gana Jugador";
               
                   break;
           }
       }else{
           resultado="seguir juego";
       }
       return resultado;
   }
   public static int getRecompensa(){
        return recompensa;
    }
      
   
   
   
}
   
    

