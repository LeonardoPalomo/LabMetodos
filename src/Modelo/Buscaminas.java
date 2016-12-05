/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public class Buscaminas {
    
    //Atributos
    private int cantidadMinas;
    private final int recompensaF = 7000;
    private final int recompensaI = 15000;
    private final int recompensaD = 30000;
    
    //getter
    public int getRecompensaF() {
        return recompensaF;
    }

    public int getRecompensaI() {
        return recompensaI;
    }
    public int getRecompensaD() {
        return recompensaD;
    }
    //Metodos
    public int posicionMinaX(int rango){
        
        Random rnd = new Random();
        int i = (int)(rnd.nextDouble()*rango + 0);
        return i;
    }
    public int posicionMinaY(int rango){
        Random rnd = new Random();
        int j = (int)(rnd.nextDouble()*rango + 0);
        return j;
    }
    public int cantidadTotalMinas(int rango){
        if(rango == 10){
            return 15;
        }
        else if(rango == 20){
            return 40;
        }
        else{
           return 100; 
        }
    }
    
    public int minasRestantes(int minas, boolean opcion){
        if(opcion == true){
            this.cantidadMinas = minas - 1;
        }
        if(opcion == false){
            this.cantidadMinas = minas + 1;
        }
        return cantidadMinas;
    }
}
