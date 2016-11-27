/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.TresEnRaya;
import Vista.VistaTresEnRaya;
import java.util.Random;
import javax.swing.JOptionPane;

public class ControladorPrincipalTresEnRaya implements ActionListener{
    VistaTresEnRaya vp;
    TresEnRaya tresEnRaya;
    String simbolo = "X";
    int rd;
    
    public ControladorPrincipalTresEnRaya(){
        vp = new VistaTresEnRaya();
        tresEnRaya= new TresEnRaya();
        vp.setVisible(true);
        System.out.println("Ventana creada");
        vp.agregarListenerJugar(this);
       // JOptionPane.showMessageDialog(null, "Ganaste");
    }

    public String getSimbolo() {
        return simbolo;
    }
    
  public void actionPerformed (ActionEvent e){
      if(vp.getButtonJugar()== e.getSource()){
          System.out.println("El juego ha iniciado");
          vp.agregarListener(this);
          vp.getButtonJugar().setEnabled(false);
      }
      else if(vp.getTablero()[0][0]== e.getSource()){
          System.out.println("1");
          vp.ponerSimbolo(1, simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          boolean comprobador = true;
          while(comprobador){
              rd = new Random().nextInt(8)+1;
              if(vp.comprobacionSimbolo(rd).equals("")){
                  vp.ponerSimbolo(rd, simbolo);
                  comprobador = false;
                  simbolo = tresEnRaya.llevarTurnos(simbolo);
              }
          }
      }
      else if(vp.getTablero()[0][1]== e.getSource()){
          System.out.println("2");
          vp.ponerSimbolo(2, simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          boolean comprobador = true;
          while(comprobador){
              rd = new Random().nextInt(8)+1;
              if(vp.comprobacionSimbolo(rd).equals("")){
                  vp.ponerSimbolo(rd, simbolo);
                  comprobador = false;
                  simbolo = tresEnRaya.llevarTurnos(simbolo);
              }
          }
      }
      else if(vp.getTablero()[0][2]== e.getSource()){
          System.out.println("3");
          vp.ponerSimbolo(3, simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          boolean comprobador = true;
          while(comprobador){
              rd = new Random().nextInt(8)+1;
              if(vp.comprobacionSimbolo(rd).equals("")){
                  vp.ponerSimbolo(rd, simbolo);
                  comprobador = false;
                  simbolo = tresEnRaya.llevarTurnos(simbolo);
              }
          }
      }
      else if(vp.getTablero()[1][0]== e.getSource()){
          System.out.println("4");
          vp.ponerSimbolo(4, simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          boolean comprobador = true;
          while(comprobador){
              rd = new Random().nextInt(8)+1;
              if(vp.comprobacionSimbolo(rd).equals("")){
                  vp.ponerSimbolo(rd, simbolo);
                  comprobador = false;
                  simbolo = tresEnRaya.llevarTurnos(simbolo);
              }
          }
      }
      else if(vp.getTablero()[1][1]== e.getSource()){
          System.out.println("5");
          vp.ponerSimbolo(5, simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          boolean comprobador = true;
          while(comprobador){
              rd = new Random().nextInt(8)+1;
              if(vp.comprobacionSimbolo(rd).equals("")){
                  vp.ponerSimbolo(rd, simbolo);
                  comprobador = false;
                  simbolo = tresEnRaya.llevarTurnos(simbolo);
              }
          }
      }
      else if(vp.getTablero()[1][2]== e.getSource()){
          System.out.println("6");
          vp.ponerSimbolo(6, simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          boolean comprobador = true;
          while(comprobador){
              rd = new Random().nextInt(8)+1;
              if(vp.comprobacionSimbolo(rd).equals("")){
                  vp.ponerSimbolo(rd, simbolo);
                  comprobador = false;
                  simbolo = tresEnRaya.llevarTurnos(simbolo);
              }
          }
      }
      else if(vp.getTablero()[2][0]== e.getSource()){
          System.out.println("7");
          vp.ponerSimbolo(7, simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          boolean comprobador = true;
          while(comprobador){
              rd = new Random().nextInt(8)+1;
              if(vp.comprobacionSimbolo(rd).equals("")){
                  vp.ponerSimbolo(rd, simbolo);
                  comprobador = false;
                  simbolo = tresEnRaya.llevarTurnos(simbolo);
              }
          }
      }
      else if(vp.getTablero()[2][1]== e.getSource()){
          System.out.println("8");
          vp.ponerSimbolo(8, simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          boolean comprobador = true;
          while(comprobador){
              rd = new Random().nextInt(8)+1;
              if(vp.comprobacionSimbolo(rd).equals("")){
                  vp.ponerSimbolo(rd, simbolo);
                  comprobador = false;
                  simbolo = tresEnRaya.llevarTurnos(simbolo);
              }
          }
      }
      else if(vp.getTablero()[2][2]== e.getSource()){
          System.out.println("9");
          vp.ponerSimbolo(9, simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          boolean comprobador = true;
          while(comprobador){
              rd = new Random().nextInt(8)+1;
              if(vp.comprobacionSimbolo(rd).equals("")){
                  vp.ponerSimbolo(rd, simbolo);
                  comprobador = false;
                  simbolo = tresEnRaya.llevarTurnos(simbolo);
              }
          }
          //JOptionPane.showMessageDialog(null, "Ganaste");
      }

  }  
    //  else if (vp.getButtonSalir()== e.getSource()){
}     //    this.vp.setVisible(false);
        //  System.out.println("nyunyu
 