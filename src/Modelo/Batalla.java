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
   
    public void asignarTerrenos(int areaAsignatura, Random numeroRandom){
        numeroRandom = new Random();
        int cntSuelo = 0;
        int cntBosque = 0;
        int cntRio = 0;
        int maxSuelo = 0;
        int maxBosque = 0;
        int maxRio = 0;
        switch(areaAsignatura){
            case 1://Área Plan Común
                maxSuelo = 469;
                maxRio = 156;
                break;
            case 2://Área Economía
                maxSuelo = 446;
                maxRio = 179;
                break;
            case 3://Área Especialidad
                maxSuelo = 312;
                maxRio = 125;
                maxBosque = 188;
                break;
        }
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                int numero = 0;
                numero = numeroRandom.nextInt(3)+1;
                switch(numero){
                    case 1://Pone un suelo
                        if(cntSuelo < maxSuelo){
                            cntSuelo++;
                            tablero[i][j].setTerreno(1);
                            break;
                        }
                    case 2://Pone un rio
                        if(cntRio < maxRio){
                            cntRio++;
                            tablero[i][j].setTerreno(2);
                            break;
                        }
                    case 3://Pone un bosque
                        if(cntBosque < maxBosque){
                            cntBosque++;
                            tablero[i][j].setTerreno(3);
                            break;
                        }
                    default:
                        j--;
                }
            }
        }
    }
    
    public void corregirRios(){
        int riosCerca;
        int cntTierra = 0;
        int cntRio = 0;
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                riosCerca = 0;
                try{
                    if(tablero[i][j].getTerreno() == 2){
                        if(tablero[i][j-1].getTerreno() == 2){
                            riosCerca++;
                        }
                        if(tablero[i][j+1].getTerreno() == 2){
                            riosCerca++;
                        }
                        if(tablero[i-1][j].getTerreno() == 2){
                            riosCerca++;
                        }
                        if(tablero[i+1][j].getTerreno() == 2){
                            riosCerca++;
                        }
                        if(riosCerca == 0){
                            cntRio--;
                            tablero[i][j].setTerreno(1);
                            cntTierra++;
                        }
                    }
                    if(tablero[i][j].getTerreno() == 1 && cntTierra != 0){
                        if(tablero[i][j-1].getTerreno() == 2){
                            riosCerca++;
                        }
                        if(tablero[i][j+1].getTerreno() == 2){
                            riosCerca++;
                        }
                        if(tablero[i-1][j].getTerreno() == 2){
                            riosCerca++;
                        }
                        if(tablero[i+1][j].getTerreno() == 2){
                            riosCerca++;
                        }
                        if(riosCerca > 0){
                            tablero[i][j].setTerreno(2);
                            cntTierra--;
                            cntRio++;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){
                }
            }
        }
    }
   
    public void asignarAlturas(Random distribAltura){
        distribAltura = new Random();
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                int altura=0;
                do{
                    altura = (int)Math.round(distribAltura.nextGaussian()*1+5);
                }while(altura<0||altura>10);
                this.getTablero(i,j).setAltura(altura);
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
    
    public String ponerRutaImagenesTerreno(int i, int j){
        String ruta = "";
        if(tablero[i][j].getTerreno() == 1){//Tierra
            if(tablero[i][j].getAltura() == 0 || tablero[i][j].getAltura() == 1){
                ruta = "/Imagen/Tierra01.png";
            }
            else if(tablero[i][j].getAltura() == 2 || tablero[i][j].getAltura() == 3){
                ruta = "/Imagen/Tierra23.png";
            }
            else if(tablero[i][j].getAltura() == 4 || tablero[i][j].getAltura() == 5){
                ruta = "/Imagen/Tierra45.png";
            }
        }
        else if(tablero[i][j].getTerreno() == 2){//Río
            if(tablero[i][j].getAltura() <= 5){
                ruta = "/src/Imagen/Rio05.png";
            }
            else if(tablero[i][j].getAltura() > 6){
                ruta = "/src/Imagen/Rio610.png";
            }
        }
        else if(tablero[i][j].getTerreno() == 3){//Bosque
            if(tablero[i][j].getAltura() == 0 || tablero[i][j].getAltura() == 1){
                ruta = "/src/Imagen/Bosque01.png";
            }
            else if(tablero[i][j].getAltura() == 2 || tablero[i][j].getAltura() == 3){
                ruta = "/src/Imagen/Bosque23.png";
            }
            else if(tablero[i][j].getAltura() == 4 || tablero[i][j].getAltura() == 5){
                ruta = "/src/Imagen/Bosque45.png";
            }
            else if(tablero[i][j].getAltura() == 6 || tablero[i][j].getAltura() == 7){
                ruta = "/src/Imagen/Bosque67.png";
            }
            else if(tablero[i][j].getAltura() == 8 || tablero[i][j].getAltura() == 9){
                ruta = "/src/Imagen/Bosque89.png";
            }
            else if(tablero[i][j].getAltura() == 10){
                ruta = "/src/Imagen/Bosque10.png";
            }
        }
        else if(tablero[i][j].getTerreno() == 4){ //Montaña
            if(tablero[i][j].getAltura() == 6 || tablero[i][j].getAltura() == 7){
                ruta = "/src/Imagen/Montaña67.png";
            }
            else if(tablero[i][j].getAltura() == 8 || tablero[i][j].getAltura() == 9){
                ruta = "/src/Imagen/Montaña89.png";
            }
            else if(tablero[i][j].getAltura() == 10){
                ruta = "/src/Imagen/Montaña10.png";
            }
        }
        return ruta;
    }

    public Casilla getTablero(int i, int j) {
        return tablero[i][j];
    }

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }

}