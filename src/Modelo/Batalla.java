package Modelo;

/***********************************************************************
 * Module:  Batalla.java
 * Author:  Leo
 * Purpose: Defines the Class Batalla
 ***********************************************************************/

import java.util.*;

public class Batalla {
    
   private int turno;
   private Jugador jugador;
   private Personaje[] pjsJugador;
   private Personaje[] pjsCpu;
   private Casilla[][] tablero;
   
   public Batalla(){
       tablero = new Casilla[25][25];
       for(int i=0;i<25;i++){
           for(int j=0;j<25;j++){
               tablero[i][j] = new Casilla();
           }
       }
   }
   
   public void terminarTurno() {}
   
   public int verificarGanador(Personaje[] pjsJugador, Personaje[] pjsCpu) {
      return 0;
   }
   
    public void asignarAlturas(Random distribAltura){
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                int altura=0;
                do{
                    altura = (int)Math.round(distribAltura.nextGaussian()*1+5);
                }while(altura<0||altura>10);
                this.getTablero(i,j).setAltura(altura);
                System.out.println("La altura de ["+i+", "+j+"] es "+tablero[i][j].getAltura());
            }
        }
    }
   
    public boolean revisarAlturas(){
        boolean comprobador = true;//Mientras sea cierto, la distribucion es valida
        for(int i=0; i<25; i++){
            if(!comprobador){
                break;
            }
            for(int j=0; j<25; j++){
                int contador = 0;
                try{
                    if(Math.abs(tablero[i][j-1].getAltura() - tablero[i][j].getAltura())>2){//Si la casilla a la izquierda tiene una diferencia de altura mayor o igual a 2
                        contador++;
                        if(contador>=4){//Si ninguna casilla adyacente cumple con la condicion
                            comprobador = false;
                            System.out.println("Generando otra vez...");
                            break;
                        }
                    }
                    else if(Math.abs(tablero[i][j+1].getAltura() - tablero[i][j].getAltura())>2){
                        contador++;
                        if(contador>=4){
                            comprobador = false;
                            System.out.println("Generando otra vez...");
                            break;
                        }
                    }
                    else if(Math.abs(tablero[i+1][j].getAltura() - tablero[i][j].getAltura())>2){
                        contador++;
                        if(contador>=4){
                            comprobador = false;
                            System.out.println("Generando otra vez...");
                            break;
                        }
                    }
                    else if(Math.abs(tablero[i-1][j].getAltura() - tablero[i][j].getAltura())>2){
                        contador++;
                        if(contador>=4){
                            comprobador = false;
                            System.out.println("Generando otra vez...");
                            break;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                }
            }
        }
        return comprobador;
    }

    public Casilla getTablero(int i, int j) {
        return tablero[i][j];
    }

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }

}