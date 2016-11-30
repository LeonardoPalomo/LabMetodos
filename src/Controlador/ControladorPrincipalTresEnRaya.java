/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaPrincipalTresEnRaya;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.TresEnRaya;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControladorPrincipalTresEnRaya implements ActionListener{
    VistaPrincipalTresEnRaya vp;
    TresEnRaya tresEnRaya;
    String simbolo = "X";
    int rd;
    JButton[][] tablero;
    String resultado;
    int contadorEspacios;
    
    
    public ControladorPrincipalTresEnRaya(){
        vp = new VistaPrincipalTresEnRaya();
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
          vp.agregarListenerTablero(this);
          vp.getButtonJugar().setEnabled(false);
      }
      else if(vp.getTablero()[0][0]== e.getSource()){
          
          System.out.println("1");
          vp.ponerSimbolo(1, simbolo);
          System.out.println("Contador actual antes de marca x");
          System.out.println(contadorEspacios);
          contadorEspacios++;
          System.out.println("Contador actual despues de marca x");
          System.out.println(contadorEspacios);
          System.out.print(simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          System.out.print(simbolo);
          tablero= vp.getTablero();
          resultado= tresEnRaya.validarGanador(tablero);
          
          
          if(resultado.equals("Gana Jugador")){
              JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
          }else if(resultado.equals("Gana CPU")){
              JOptionPane.showMessageDialog(null, "Perdiste :c");
          }else{
            if(contadorEspacios<9){
                
            boolean comprobador = true;
            System.out.println("Contador actual antes de marca O");
            System.out.println(contadorEspacios);
            contadorEspacios++;
            System.out.println("Contador actual despues de marca O");
            System.out.println(contadorEspacios);
            while(comprobador){
                 rd = new Random().nextInt(8)+1;
                if(vp.comprobacionSimbolo(rd).equals("")){
                    vp.ponerSimbolo(rd, simbolo);
                    System.out.print(simbolo);
                    simbolo = tresEnRaya.llevarTurnos(simbolo);
                    System.out.print(simbolo);
                    tablero=vp.getTablero();
                    resultado=tresEnRaya.validarGanador(tablero);
                    
                    if(resultado.equals("Gana Jugador")){
                        JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
                        comprobador = false;
                    }else if(resultado.equals("Gana CPU")){
                        JOptionPane.showMessageDialog(null, "Perdiste :c");
                        comprobador = false;
                    }else{
                        comprobador = false;
                        
                    }
                    
              }
          
            }
            }else if(contadorEspacios==9){
                    JOptionPane.showMessageDialog(null, "Empate :o");
                }
            
          }
      }
      else if(vp.getTablero()[0][1]== e.getSource()){
          System.out.println("2");
          vp.ponerSimbolo(2, simbolo);
          System.out.println("Contador actual antes de marca x");
          System.out.println(contadorEspacios);
          contadorEspacios++;
          System.out.println("Contador actual despues de marca x");
          System.out.println(contadorEspacios);
          System.out.print(simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          System.out.print(simbolo);
          tablero= vp.getTablero();
          resultado= tresEnRaya.validarGanador(tablero);
          
          if(resultado.equals("Gana Jugador")){
              JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
          }else if(resultado.equals("Gana CPU")){
              JOptionPane.showMessageDialog(null, "Perdiste :c");
          }else{
            if(contadorEspacios<9){
                
            boolean comprobador = true;
            System.out.println("Contador actual antes de marca O");
            System.out.println(contadorEspacios);
            contadorEspacios++;
            System.out.println("Contador actual despues de marca O");
            System.out.println(contadorEspacios);

            while(comprobador){
                 rd = new Random().nextInt(8)+1;
                if(vp.comprobacionSimbolo(rd).equals("")){
                    vp.ponerSimbolo(rd, simbolo);
                    System.out.print(simbolo);
                    simbolo = tresEnRaya.llevarTurnos(simbolo);
                    System.out.print(simbolo);
                    tablero=vp.getTablero();
                    resultado=tresEnRaya.validarGanador(tablero);
                    
                    if(resultado.equals("Gana Jugador")){
                        JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
                        comprobador = false;
                    }else if(resultado.equals("Gana CPU")){
                        JOptionPane.showMessageDialog(null, "Perdiste :c");
                        comprobador = false;
                    }else{
                        comprobador = false;
                        
                    }
                    
              }
          
            }
            }else if(contadorEspacios==9){
                    JOptionPane.showMessageDialog(null, "Empate :o");
                }
          }
      }
      else if(vp.getTablero()[0][2]== e.getSource()){
          System.out.println("3");
          vp.ponerSimbolo(3, simbolo);
          System.out.println("Contador actual antes de marca x");
          System.out.println(contadorEspacios);

          contadorEspacios++;
          System.out.println("Contador actual despues de marca x");
          System.out.println(contadorEspacios);
          System.out.print(simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          System.out.print(simbolo);
          tablero= vp.getTablero();
          resultado= tresEnRaya.validarGanador(tablero);
          
          if(resultado.equals("Gana Jugador")){
              JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
          }else if(resultado.equals("Gana CPU")){
              JOptionPane.showMessageDialog(null, "Perdiste :c");
          }else{
            if(contadorEspacios<9){
                
            boolean comprobador = true;
            System.out.println("Contador actual antes de marca O");
            System.out.println(contadorEspacios);
            contadorEspacios++;
            System.out.println("Contador actual despues de marca O");
            System.out.println(contadorEspacios);
            while(comprobador){
                 rd = new Random().nextInt(8)+1;
                if(vp.comprobacionSimbolo(rd).equals("")){
                    vp.ponerSimbolo(rd, simbolo);
                    System.out.print(simbolo);
                    simbolo = tresEnRaya.llevarTurnos(simbolo);
                    System.out.print(simbolo);
                    tablero=vp.getTablero();
                    resultado=tresEnRaya.validarGanador(tablero);
                    
                    if(resultado.equals("Gana Jugador")){
                        JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
                        comprobador = false;
                    }else if(resultado.equals("Gana CPU")){
                        JOptionPane.showMessageDialog(null, "Perdiste :c");
                        comprobador = false;
                    }else{
                        comprobador = false;
                        
                    }
                    
              }
          
            }
            }else if(contadorEspacios==9){
                    JOptionPane.showMessageDialog(null, "Empate :o");
                }
          }
      }
      else if(vp.getTablero()[1][0]== e.getSource()){
          System.out.println("4");
          vp.ponerSimbolo(4, simbolo);
          System.out.println("Contador actual antes de marca x");
          System.out.println(contadorEspacios);
          contadorEspacios++;
          System.out.println("Contador actual despues de marca x");
          System.out.println(contadorEspacios);
          System.out.print(simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          System.out.print(simbolo);
          tablero= vp.getTablero();
          resultado= tresEnRaya.validarGanador(tablero);
          
          if(resultado.equals("Gana Jugador")){
              JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
          }else if(resultado.equals("Gana CPU")){
              JOptionPane.showMessageDialog(null, "Perdiste :c");
          }else{
            if(contadorEspacios<9){
                
            boolean comprobador = true;
            System.out.println("Contador actual antes de marca O");
            System.out.println(contadorEspacios);
            contadorEspacios++;
            System.out.println("Contador actual despues de marca O");
            System.out.println(contadorEspacios);
            while(comprobador){
                 rd = new Random().nextInt(8)+1;
                if(vp.comprobacionSimbolo(rd).equals("")){
                    vp.ponerSimbolo(rd, simbolo);
                    System.out.print(simbolo);
                    simbolo = tresEnRaya.llevarTurnos(simbolo);
                    System.out.print(simbolo);
                    tablero=vp.getTablero();
                    resultado=tresEnRaya.validarGanador(tablero);
                    
                    if(resultado.equals("Gana Jugador")){
                        JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
                        comprobador = false;
                    }else if(resultado.equals("Gana CPU")){
                        JOptionPane.showMessageDialog(null, "Perdiste :c");
                        comprobador = false;
                    }else{
                        comprobador = false;
                        
                    }
                    
              }
            }
            }else if(contadorEspacios==9){
                    JOptionPane.showMessageDialog(null, "Empate :o");
                }
          
          }
      }
      else if(vp.getTablero()[1][1]== e.getSource()){
          System.out.println("5");
          vp.ponerSimbolo(5, simbolo);
          System.out.println("Contador actual antes de marca x");
          System.out.println(contadorEspacios);
          contadorEspacios++;
          System.out.println("Contador actual despues de marca x");
          System.out.println(contadorEspacios);
          System.out.print(simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          System.out.print(simbolo);
          tablero= vp.getTablero();
          resultado= tresEnRaya.validarGanador(tablero);
          
          if(resultado.equals("Gana Jugador")){
              JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
          }else if(resultado.equals("Gana CPU")){
              JOptionPane.showMessageDialog(null, "Perdiste :c");
          }else{
            if(contadorEspacios<9){
                
            boolean comprobador = true;
            System.out.println("Contador actual antes de marca O");
            System.out.println(contadorEspacios);
            contadorEspacios++;
            System.out.println("Contador actual despues de marca O");
            System.out.println(contadorEspacios);
            while(comprobador){
                 rd = new Random().nextInt(8)+1;
                if(vp.comprobacionSimbolo(rd).equals("")){
                    vp.ponerSimbolo(rd, simbolo);
                    System.out.print(simbolo);
                    simbolo = tresEnRaya.llevarTurnos(simbolo);
                    System.out.print(simbolo);
                    tablero=vp.getTablero();
                    resultado=tresEnRaya.validarGanador(tablero);
                    
                    if(resultado.equals("Gana Jugador")){
                        JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
                        comprobador = false;
                    }else if(resultado.equals("Gana CPU")){
                        JOptionPane.showMessageDialog(null, "Perdiste :c");
                        comprobador = false;
                    }else{
                        comprobador = false;
                        
                    }
                    
              }
          
            }
            }else if(contadorEspacios==9){
                    JOptionPane.showMessageDialog(null, "Empate :o");
                }
          }
      }
      else if(vp.getTablero()[1][2]== e.getSource()){
          System.out.println("6");
          vp.ponerSimbolo(6, simbolo);
          System.out.println("Contador actual antes de marca x");
          System.out.println(contadorEspacios);
          contadorEspacios++;
          System.out.println("Contador actual despues de marca x");
          System.out.println(contadorEspacios);
          System.out.print(simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          System.out.print(simbolo);
          tablero= vp.getTablero();
          resultado= tresEnRaya.validarGanador(tablero);
          
          if(resultado.equals("Gana Jugador")){
              JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
          }else if(resultado.equals("Gana CPU")){
              JOptionPane.showMessageDialog(null, "Perdiste :c");
          }else{
            if(contadorEspacios<9){
                
            boolean comprobador = true;
            System.out.println("Contador actual antes de marca O");
            System.out.println(contadorEspacios);
            contadorEspacios++;
            System.out.println("Contador actual despues de marca O");
            System.out.println(contadorEspacios);
            while(comprobador){
                 rd = new Random().nextInt(8)+1;
                if(vp.comprobacionSimbolo(rd).equals("")){
                    vp.ponerSimbolo(rd, simbolo);
                    System.out.print(simbolo);
                    simbolo = tresEnRaya.llevarTurnos(simbolo);
                    System.out.print(simbolo);
                    tablero=vp.getTablero();
                    resultado=tresEnRaya.validarGanador(tablero);
                    
                    if(resultado.equals("Gana Jugador")){
                        JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
                        comprobador = false;
                    }else if(resultado.equals("Gana CPU")){
                        JOptionPane.showMessageDialog(null, "Perdiste :c");
                        comprobador = false;
                    }else{
                        comprobador = false;
                        
                    }
                    
              }
          
            }
            }else if(contadorEspacios==9){
                    JOptionPane.showMessageDialog(null, "Empate :o");
                }
          }
      }
      else if(vp.getTablero()[2][0]== e.getSource()){
          System.out.println("7");
          vp.ponerSimbolo(7, simbolo);
          System.out.println("Contador actual antes de marca x");
          System.out.println(contadorEspacios);
          contadorEspacios++;
          System.out.println("Contador actual despues de marca x");
          System.out.println(contadorEspacios);
          System.out.print(simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          System.out.print(simbolo);
          tablero= vp.getTablero();
          resultado= tresEnRaya.validarGanador(tablero);
          
          if(resultado.equals("Gana Jugador")){
              JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
          }else if(resultado.equals("Gana CPU")){
              JOptionPane.showMessageDialog(null, "Perdiste :c");
          }else{
            if(contadorEspacios<9){
                
            boolean comprobador = true;
            System.out.println("Contador actual antes de marca O");
            System.out.println(contadorEspacios);
            contadorEspacios++;
            System.out.println("Contador actual despues de marca O");
            System.out.println(contadorEspacios);
            while(comprobador){
                 rd = new Random().nextInt(8)+1;
                if(vp.comprobacionSimbolo(rd).equals("")){
                    vp.ponerSimbolo(rd, simbolo);
                    System.out.print(simbolo);
                    simbolo = tresEnRaya.llevarTurnos(simbolo);
                    System.out.print(simbolo);
                    tablero=vp.getTablero();
                    resultado=tresEnRaya.validarGanador(tablero);
                    
                    if(resultado.equals("Gana Jugador")){
                        JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
                        comprobador = false;
                    }else if(resultado.equals("Gana CPU")){
                        JOptionPane.showMessageDialog(null, "Perdiste :c");
                        comprobador = false;
                    }else{
                        comprobador = false;
                        
                    }
                    
              }
          
            }
            }else if(contadorEspacios==9){
                    JOptionPane.showMessageDialog(null, "Empate :o");
                }
          }
      }
      else if(vp.getTablero()[2][1]== e.getSource()){
          System.out.println("8");
          vp.ponerSimbolo(8, simbolo);
          System.out.println("Contador actual antes de marca x");
          System.out.println(contadorEspacios);
          contadorEspacios++;
          System.out.println("Contador actual despues de marca x");
          System.out.println(contadorEspacios);
          System.out.print(simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          System.out.print(simbolo);
          tablero= vp.getTablero();
          resultado= tresEnRaya.validarGanador(tablero);
          
          if(resultado.equals("Gana Jugador")){
              JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
          }else if(resultado.equals("Gana CPU")){
              JOptionPane.showMessageDialog(null, "Perdiste :c");
          }else{
            if(contadorEspacios<9){
                
            boolean comprobador = true;
            System.out.println("Contador actual antes de marca O");
            System.out.println(contadorEspacios);
            contadorEspacios++;
            System.out.println("Contador actual despues de marca O");
            System.out.println(contadorEspacios);
            while(comprobador){
                 rd = new Random().nextInt(8)+1;
                if(vp.comprobacionSimbolo(rd).equals("")){
                    vp.ponerSimbolo(rd, simbolo);
                    System.out.print(simbolo);
                    simbolo = tresEnRaya.llevarTurnos(simbolo);
                    System.out.print(simbolo);
                    tablero=vp.getTablero();
                    resultado=tresEnRaya.validarGanador(tablero);
                    
                    if(resultado.equals("Gana Jugador")){
                        JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
                        comprobador = false;
                    }else if(resultado.equals("Gana CPU")){
                        JOptionPane.showMessageDialog(null, "Perdiste :c");
                        comprobador = false;
                    }else{
                        comprobador = false;
                        
                    }
                    
              }
          
            }
            }else if(contadorEspacios==9){
                    JOptionPane.showMessageDialog(null, "Empate :o");
                }
          }
      }
      else if(vp.getTablero()[2][2]== e.getSource()){
          System.out.println("9");
          vp.ponerSimbolo(9, simbolo);
          System.out.println("Contador actual antes de marca x");
          System.out.println(contadorEspacios);
          contadorEspacios++;
          System.out.println("Contador actual despues de marca x");
          System.out.println(contadorEspacios);
          System.out.print(simbolo);
          simbolo = tresEnRaya.llevarTurnos(simbolo);
          System.out.print(simbolo);
          tablero= vp.getTablero();
          resultado= tresEnRaya.validarGanador(tablero);
          
          if(resultado.equals("Gana Jugador")){
              JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
          }else if(resultado.equals("Gana CPU")){
              JOptionPane.showMessageDialog(null, "Perdiste :c");
          }else{
            if(contadorEspacios<9){
                
            boolean comprobador = true;
            System.out.println("Contador actual antes de marca O");
            System.out.println(contadorEspacios);
            contadorEspacios++;
            System.out.println("Contador actual despues de marca O");
            System.out.println(contadorEspacios);
            while(comprobador){
                 rd = new Random().nextInt(8)+1;
                if(vp.comprobacionSimbolo(rd).equals("")){
                    vp.ponerSimbolo(rd, simbolo);
                    System.out.print(simbolo);
                    simbolo = tresEnRaya.llevarTurnos(simbolo);
                    System.out.print(simbolo);
                    tablero=vp.getTablero();
                    resultado=tresEnRaya.validarGanador(tablero);
                    
                    if(resultado.equals("Gana Jugador")){
                        JOptionPane.showMessageDialog(null, "Ganaste!!!!!");
                        comprobador = false;
                    }else if(resultado.equals("Gana CPU")){
                        JOptionPane.showMessageDialog(null, "Perdiste :c");
                        comprobador = false;
                    }else{
                        comprobador = false;
                        
                    }
                    
              }
                
          
            }
            }else if(contadorEspacios==9){
                    JOptionPane.showMessageDialog(null, "Empate :o");
            }else{
                
            }
          }
          //JOptionPane.showMessageDialog(null, "Ganaste");
      }

  }  
    //  else if (vp.getButtonSalir()== e.getSource()){
}     //    this.vp.setVisible(false);
        //  System.out.println("nyunyu
 