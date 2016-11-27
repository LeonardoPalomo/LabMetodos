/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CasillaBuscaminas {

    //Atributos
    public CasillaBuscaminas[][] mapa1;//Mapa logico
    private int[][] mapa2;//Mapa resuelto
    private int[][] mapa3;
    private int rango;
    private int posicionX;//Posicion en x de la casilla.
    private int posicionY;//Posicion en y de la casilla.
    private boolean estado;//Casilla descubierta=true, CasillaBuscaminas no descubierta=false.
    private boolean estadoMina;//Mina posicionada o no
    private ArrayList<CasillaBuscaminas> abierto; 
    private ArrayList<CasillaBuscaminas> paraMostrar; 
    //Constructor
    public CasillaBuscaminas(int i, int j){//Casilla de el mapa
        this.estado = false;
        this.estadoMina = false;
        this.posicionX = i;
        this.posicionY = j;
    }
    public CasillaBuscaminas(int rango){//Sobrecarga para los arrays
        this.rango = rango;
        mapa1 = new CasillaBuscaminas[rango][rango];
        mapa2 = new int[rango][rango];
        mapa3 = new int[rango][rango];
        for(int i=0; i<rango;i++){
            for(int j=0; j<rango; j++){
                mapa2[i][j] = 0;
                mapa3[i][j] = 0;
                mapa1[i][j] = new CasillaBuscaminas(i,j);
            }
        }
    }
    
    //Metodos getter and setter
    public CasillaBuscaminas[][] getMapa1() {
        return mapa1;
    }
    public void setMapa1(CasillaBuscaminas[][] mapa1) {
        this.mapa1 = mapa1;
    }
    public int[][] getMapa2() {
        return mapa2;
    }
    public int[][] getMapa3(){
        return mapa3;
    }
    public int getPosicionX(){
        return posicionX;
    }
    public int getPosicionY(){
        return posicionY;
    }
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstadoMina() {
        return estadoMina;
    }

    public void setEstadoMina(boolean estadoMina) {
        this.estadoMina = estadoMina;
    }
    
    //Metodos
    public void marcarNumero(int i, int j, int[][] a){//Le asigna el numero de minas cercanas a la casilla(sin minas).
        int numero = 0;
        if(a[i][j]==0){
            try{
                if(a[i-1][j]==9){//Norte
                    numero++;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                //System.out.println("CasillaBuscaminas"+i+","+j+"con error de rango");
            }
            try{
                if(a[i+1][j]==9){//Sur
                    numero++;
                }
            }    
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                //System.out.println("CasillaBuscaminas"+i+","+j+"con error de rango");
            }
            try{
                if(a[i][j-1]==9){//Oeste(izquieda)
                    numero++;
                }
            }    
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                //System.out.println("CasillaBuscaminas"+i+","+j+"con error de rango");
            }
            try{
                if(a[i][j+1]==9){//Este(derecha)
                    numero++;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                //System.out.println("CasillaBuscaminas"+i+","+j+"con error de rango");
            }
            try{
                if(a[i-1][j-1]==9){//Noroeste
                    numero++;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                //System.out.println("CasillaBuscaminas"+i+","+j+"con error de rango");
            }
            try{
                if(a[i-1][j+1]==9){//Noreste
                    numero++;
                }
            }    
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                //System.out.println("CasillaBuscaminas"+i+","+j+"con error de rango");
            }
            try{
                if(a[i+1][j-1]==9){//Suroeste
                    numero++;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                //System.out.println("CasillaBuscaminas"+i+","+j+"con error de rango");
            }
            try{
                if(a[i+1][j+1]==9){//Sureste
                    numero++;
                }
            }    
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                //System.out.println("CasillaBuscaminas"+i+","+j+"con error de rango");
            }
        a[i][j] = numero;    
        }
    }
    
    public ArrayList<CasillaBuscaminas> transicion(int x, int y,ArrayList<CasillaBuscaminas> abierto,ArrayList<CasillaBuscaminas> paraMostrar, CasillaBuscaminas[][] a, int[][] b, boolean flag){
        if(flag == false){//Si es la primera vez que se llama al metodo
            abierto.add(a[x][y]);
            a[x][y].estado = true;
            transicion(x,y,abierto,paraMostrar,a,b,true);
            paraMostrar.add(a[x][y]);
        }    
        if(flag = true){//Si es solo una transicion de estado
            try{
                if(a[x][y+1].estado == false){//Derecha
                    if(b[x][y+1] == 0){
                        abierto.add(a[x][y+1]);
                        a[x][y].estado = true;
                        transicion(x,y+1,abierto,paraMostrar,a,b,true);
                        paraMostrar.add(a[x][y+1]);
                    }
                    else if(b[x][y+1] != 0){
                        paraMostrar.add(a[x][y+1]);
                        a[x][y+1].estado = true;
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
            }
            try{
                if(a[x][y-1].estado == false){//Izquierda
                    if(b[x][y-1] == 0){
                        abierto.add(a[x][y-1]);
                        a[x][y].estado = true;
                        transicion(x,y-1,abierto,paraMostrar,a,b,true);
                        paraMostrar.add(a[x][y-1]);
                    }
                    else if(b[x][y-1] != 0){
                        paraMostrar.add(a[x][y-1]);
                        a[x][y-1].estado = true;
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
            }
            try{
                if(a[x+1][y].estado == false){//Abajo
                    if(b[x+1][y] == 0){
                        abierto.add(a[x+1][y]);
                        a[x][y].estado = true;
                        transicion(x+1,y,abierto,paraMostrar,a,b,true);
                        paraMostrar.add(a[x+1][y]);
                    }
                    else if(b[x+1][y] != 0){
                        paraMostrar.add(a[x+1][y]);
                        a[x+1][y].estado = true;
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
            }
            try{
                if(a[x-1][y].estado == false){//Arriba
                    if(b[x-1][y] == 0){
                        abierto.add(a[x-1][y]);
                        a[x][y].estado = true;
                        transicion(x-1,y,abierto,paraMostrar,a,b,true);  
                        paraMostrar.add(a[x-1][y]);
                    }
                    else if(b[x-1][y] != 0){
                        paraMostrar.add(a[x-1][y]);
                        a[x-1][y].estado = true;
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
            }
        }
        for (CasillaBuscaminas paraMostrar1 : paraMostrar) {
            paraMostrar1.estado = true;
        }
        return paraMostrar;
    }
    public boolean revisarGanador(CasillaBuscaminas[][] mapa, int[][] logico){//malo
        boolean respuesta;
        respuesta = true;
        for(int i=0; i<rango; i++){
            for(int j=0; j<rango; j++){
                if((!(logico[i][j]>=0 && logico[i][j]<9) && mapa[i][j].estado==true)){
                    respuesta = false;
                    break;
                }
            }
            if(respuesta == false){
                break;
            }
        }
        return respuesta;
    }
    public boolean revisarGanador2(CasillaBuscaminas[][] mapa){//no esta funcionando...
        boolean respuesta;
        respuesta = true;
        for(int i=0; i<rango; i++){
            for(int j=0; j<rango; j++){
                if(mapa[i][j].estado != true){
                    respuesta = false;
                    break;
                }
            }
            if(respuesta == false){
                break;
            }
        }
        return respuesta;
    }
}
