
package Controlador;

import Vista.VistaPrincipalAdivLaPal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipalAdivLaPal implements ActionListener {

    private VistaPrincipalAdivLaPal vp;
    
    public ControladorPrincipalAdivLaPal(){
        
        System.out.println("Generando vista principal...");
        vp = new VistaPrincipalAdivLaPal();
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
        vp.agregarListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vp.getBotonInstrucciones() == e.getSource()){
            System.out.println("El usuario ha seleccionado: Instrucciones");
            vp.mostrarInstrucciones();
        }
        else if(vp.getBotonSalir() == e.getSource()){
            System.out.println("El usuario ha seleccionado: Salir");
            vp.dispose();
            ControladorBibliotecaCentral cbc = new ControladorBibliotecaCentral();
        }
        else if(vp.getBotonFacil() == e.getSource()){
            System.out.println("El usuario ha seleccionado: Dificultad Fácil");
            ControladorInicialAdivLaPal.dificultad = 1;
            vp.dispose();
            ControladorJuegoAdivLaPal cj = new ControladorJuegoAdivLaPal();
        }
        else if(vp.getBotonNormal() == e.getSource()){
            System.out.println("El usuario ha seleccionado: Dificultad Normal");
            ControladorInicialAdivLaPal.dificultad = 2;
            vp.dispose();
            ControladorJuegoAdivLaPal cj = new ControladorJuegoAdivLaPal();
        }
        else if(vp.getBotonDificil() == e.getSource()){
            System.out.println("El usuario ha seleccionado: Dificultad Difícil");
            ControladorInicialAdivLaPal.dificultad = 3;
            vp.dispose();
            ControladorJuegoAdivLaPal cj = new ControladorJuegoAdivLaPal();
        }
    }
}
