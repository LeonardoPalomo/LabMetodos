/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ahorcado;
import Vista.VistaCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorCategoria implements ActionListener{
    private VistaCategoria vc;
    private Ahorcado ahorcado;
    private int conjunto;
        
    
    public ControladorCategoria(){
        ahorcado = new Ahorcado();
        vc = new VistaCategoria();
        vc.setLocationRelativeTo(null);
        vc.setVisible(true);
        vc.setListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vc.getAnimal()){
            ahorcado.setConjunto(0);
            vc.dispose();
            ControladorAhorcado ca = new ControladorAhorcado();
        }
        if(e.getSource()==vc.getCiudad()){
            ahorcado.setConjunto(1);
            vc.dispose();
            ControladorAhorcado ca = new ControladorAhorcado();
            
        }
        if(e.getSource()==vc.getPais()){
            ahorcado.setConjunto(2);
            vc.dispose();
            ControladorAhorcado ca = new ControladorAhorcado();
        }
    
    }
    
    public int getConjunto(){
        return this.conjunto;
    }

}

