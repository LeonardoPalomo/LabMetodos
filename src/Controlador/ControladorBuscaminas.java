/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Buscaminas;
import Vista.VistaBuscaminas;
import Vista.VistaTableroBuscaminas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;



/**
 *
 * @author Usuario
 */
public class ControladorBuscaminas implements ActionListener{
    ControladorTableroBuscaminas ct;
    VistaBuscaminas vb;
    VistaTableroBuscaminas vt;
    Buscaminas bus;
    ControladorBibliotecaCentral cbc;
    //Constructor
    public ControladorBuscaminas(){
        vb = new VistaBuscaminas();
        vb.setSize(730,560);
        vb.setVisible(true);
        vb.agregarListener(this);
        //bus = new Buscaminas();
              
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vb.getbtnFacil()==(JButton)e.getSource()){//Si preciona el boton facil
            vb.setVisible(false);//Hace visible la vista Buscaminas
            ct = new ControladorTableroBuscaminas(10);//Inicializa el controlador Tablero            
            System.out.println("Se a seleccionado mapa: Facil");
            System.out.println("Si al finalizar el juego encuenta menos minas que las indicadas, es por que se ha posicionado mas de una mina en una posicion");
        }
        if (vb.getbtnIntermedio()==(JButton)e.getSource()){//Si preciona el boton intermedio
            vb.setVisible(false);
            ct = new ControladorTableroBuscaminas(20);
            System.out.println("Se a seleccionado mapa: Intermedio");  
        }
        if (vb.getbtnDificil()==(JButton)e.getSource()){//Si preciona el boton dificil
            vb.setVisible(false);
            ct = new ControladorTableroBuscaminas(30);
            System.out.println("Se a seleccionado mapa: Dificil");
        }
        if (vb.getBtnSalir()==(JButton)e.getSource()){//Si desea salir del minijuego
            vb.dispose();
            cbc = new ControladorBibliotecaCentral();
            String terminado = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha finalizado misión extra buscaminas";
            ControladorPrincipal.registrarAccion(terminado);
        }

    }
    
}
