/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Buscaminas;
import Modelo.CasillaBuscaminas;
import Modelo.Jugador;
import Vista.VistaTableroBuscaminas;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class ControladorTableroBuscaminas implements MouseListener{
    private ControladorBuscaminas cb;
    private int minas;
    private int numeroMin;//Label de la vista
    private VistaTableroBuscaminas vt;
    private CasillaBuscaminas[][] mapaJugador;
    private int rango;
    private Buscaminas buscaminas;
    private CasillaBuscaminas casilla;
    private int [][] mapaResuelto;//Mapa resuelto
    private int aleatorioX;
    private int aleatorioY;
    private int cantidadTotalMinas;
    
    //Constructor
    public ControladorTableroBuscaminas(int rango){
       buscaminas = new Buscaminas();
       casilla = new CasillaBuscaminas(rango);
       cantidadTotalMinas = buscaminas.cantidadTotalMinas(rango);
       vt = new VistaTableroBuscaminas(rango,cantidadTotalMinas);
       vt.setVisible(true);
       vt.bListener(this);
       mapaJugador = casilla.getMapa1();
       this.rango = vt.getRango();
       numeroMin = buscaminas.cantidadTotalMinas(rango);
       mapaResuelto = casilla.getMapa2();
       for(int x=0; x<cantidadTotalMinas; x++){//Setea las minas en coordenadas aleatorias
           aleatorioX = buscaminas.posicionMinaX(rango);
           aleatorioY = buscaminas.posicionMinaY(rango);
           
           for (int i=0; i<rango; i++){
               for(int j=0; j<rango; j++){
                    if(i == aleatorioX && j == aleatorioY){
                        System.out.println("tengo una mina en:"+i+","+j);
                        mapaResuelto[i][j] = 9;
                        //System.out.println(""+ mapaResuelto[i][j]);
                        
                    }
                }
            }
        }
       for(int i=0; i<rango; i++){
           for(int j=0;j<rango; j++){
                //System.out.println(""+ mapa1[i][j].getPosicionX());
                casilla.marcarNumero(i, j, mapaResuelto);
                System.out.println("Estado casilla: "+i+","+j+" valor: "+mapaResuelto[i][j]);
            }
       }
    }   
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== vt.getBtnCancelar()){//Accion boton cancelar
            if(e.getModifiers()==InputEvent.BUTTON1_MASK){
                cb = new ControladorBuscaminas();
                vt.dispose();
                System.out.println("Se ha cancelado el juego");
            }
        }
        for(int i=0; i<rango; i++){
            for(int j=0; j<rango; j++){
                if(e.getSource() == vt.getMapa1()[i][j]){
                    if (e.getModifiers() == InputEvent.BUTTON1_MASK){//Descubrir
                        System.out.println(i+","+j);
                        System.out.println(""+mapaResuelto[i][j]);
                        if(mapaResuelto[i][j]<9 && mapaResuelto[i][j]>0){//Si hay un numero
                            vt.mostrar(i, j, mapaResuelto[i][j], true);
                            mapaJugador[i][j].setEstado(true);//Se indica que la casilla ha sido descubierta
                        }
                        else if(mapaResuelto[i][j] == 0){//Si el jugador presiona un lugar vacio
                            //vt.mostrar(i, j, mapaResuelto[i][j], false);
                            //mapaJugador[i][j].setEstado(true);//Se indica que la casilla ha sido descubierta
                            ArrayList<CasillaBuscaminas> abierto = new ArrayList();
                            ArrayList<CasillaBuscaminas> paraMostrar = new ArrayList();
                            ArrayList<CasillaBuscaminas> listaParaMostrar = casilla.transicion(i, j,abierto,paraMostrar, mapaJugador, mapaResuelto,false);
                            for(int k=0;k<listaParaMostrar.size();k++){
                                CasillaBuscaminas casillita = listaParaMostrar.get(k);
                                int numeritoX = casillita.getPosicionX();
                                int numeritoY = casillita.getPosicionY();
                                vt.mostrar(numeritoX, numeritoY,mapaResuelto[numeritoX][numeritoY], true);
                                //System.out.println("Estado casilla: "+casillita.getEstado());
                            }
                        }
                        else if(mapaResuelto[i][j] == 9){//Si el jugador presiona una casilla que contiene una mina, pierde.
                            JOptionPane.showMessageDialog(vt,"Has perdido");
                            System.out.println("Se acabo el juego");
                            vt.dispose();
                            cb = new ControladorBuscaminas();
                            }
                    }
                    else if(e.getModifiers()== InputEvent.BUTTON3_MASK){//Marcar mina
                        System.out.println(i+","+j);
                        if(mapaJugador[i][j].getEstadoMina() == false && mapaJugador[i][j].getEstado() == false){//Si la casilla esta vacia y no se ha descubierto
                            if(numeroMin>0){
                                //System.out.println("estado antes:"+ mapaJugador[i][j].getEstadoMina());
                                vt.posicionarMina(i, j, 0);//Se posiciona una mina
                                mapaJugador[i][j].setEstadoMina(true);//Se le indica al mapa que se marco una mina
                                numeroMin = buscaminas.minasRestantes(numeroMin,true);
                                vt.setNumeroMinas(numeroMin);
                                mapaJugador[i][j].setEstado(true);
                                //System.out.println("estado despues:"+ mapaJugador[i][j].getEstadoMina());
                            }
                        }
                        else if(mapaJugador[i][j].getEstadoMina() == true){//si en la casilla hay una mina posicionada por el jugador
                            System.out.println("Que waaa");
                            vt.posicionarMina(i, j, 1);//Se quita una mina
                            mapaJugador[i][j].setEstadoMina(false);//Se le indica al mapa que se quito la mina
                            mapaJugador[i][j].setEstado(false);
                            if(numeroMin>=0){
                                numeroMin = buscaminas.minasRestantes(numeroMin,false);
                                vt.setNumeroMinas(numeroMin);
                            }
                        }
                    }
                    //Se comprueba si se ha ganado.
                    boolean ganador = casilla.revisarGanador2(mapaJugador);
                    if(ganador==true){//jugador gana
                        if(cantidadTotalMinas==15){
                            JOptionPane.showMessageDialog(vt,"¡Has ganado!\n tu recomepensa es: "+ buscaminas.getRecompensaF());
                            try{
                                Jugador.actualizarOro(buscaminas.getRecompensaF());
                            }  
                            catch (SQLException ex) {
                                Logger.getLogger(ControladorTableroBuscaminas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if(cantidadTotalMinas==40){
                            JOptionPane.showMessageDialog(vt,"¡Has ganado!\n tu recomepensa es: "+ buscaminas.getRecompensaI());
                            try {
                                Jugador.actualizarOro(buscaminas.getRecompensaI());
                            } 
                            catch (SQLException ex) {
                                Logger.getLogger(ControladorTableroBuscaminas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if(cantidadTotalMinas==100){
                            JOptionPane.showMessageDialog(vt,"¡Has ganado!\n tu recomepensa es: "+ buscaminas.getRecompensaD());
                            try {
                                Jugador.actualizarOro(buscaminas.getRecompensaD());
                            }
                            catch (SQLException ex) {
                                Logger.getLogger(ControladorTableroBuscaminas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        System.out.println("Se acabo el juego");
                        vt.dispose();
                        cb = new ControladorBuscaminas();
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
//El mapa1 es el panel con botones que presiona el usuario
//El mapa 2 es un mapa logico que segun los eventos ocurridos en el mapa1, conserva sus estados
//El mapa 3 es el mapa con las resuelto, el contenido de cada casilla en el