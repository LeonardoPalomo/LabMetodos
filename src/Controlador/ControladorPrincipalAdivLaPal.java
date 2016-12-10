
package Controlador;

import Vista.VistaPrincipalAdivLaPal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipalAdivLaPal implements ActionListener {

    private VistaPrincipalAdivLaPal vp;
    
    public ControladorPrincipalAdivLaPal(){
        
        System.out.println("Generando vista principal: Adivina La Palabra...");
        vp = new VistaPrincipalAdivLaPal();
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
        vp.agregarListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = "";
        if(vp.getBotonInstrucciones() == e.getSource()){
            accion = "El usuario "+ControladorLogin.usuarioActivo+" ha seleccionado: Instrucciones";
            System.out.println(accion);
            ControladorPrincipal.registrarAccion(accion);
            vp.mostrarInstrucciones();
        }
        else if(vp.getBotonSalir() == e.getSource()){
            accion = "El usuario "+ControladorLogin.usuarioActivo+" ha seleccionado: Salir";
            System.out.println(accion);
            ControladorPrincipal.registrarAccion(accion);
            vp.dispose();
            ControladorBibliotecaCentral cbc = new ControladorBibliotecaCentral();
        }
        else if(vp.getBotonFacil() == e.getSource()){
            accion = "El usuario "+ControladorLogin.usuarioActivo+" ha seleccionado: Dificultad Fácil";
            System.out.println(accion);
            ControladorPrincipal.registrarAccion(accion);
            ControladorInicialAdivLaPal.dificultad = 1;
            vp.dispose();
            ControladorJuegoAdivLaPal cj = new ControladorJuegoAdivLaPal();
        }
        else if(vp.getBotonNormal() == e.getSource()){
            accion = "El usuario "+ControladorLogin.usuarioActivo+" ha seleccionado: Dificultad Normal";
            System.out.println(accion);
            ControladorPrincipal.registrarAccion(accion);
            ControladorInicialAdivLaPal.dificultad = 2;
            vp.dispose();
            ControladorJuegoAdivLaPal cj = new ControladorJuegoAdivLaPal();
        }
        else if(vp.getBotonDificil() == e.getSource()){
            accion = "El usuario "+ControladorLogin.usuarioActivo+" ha seleccionado: Dificultad Difícil";
            System.out.println(accion);
            ControladorPrincipal.registrarAccion(accion);
            ControladorInicialAdivLaPal.dificultad = 3;
            vp.dispose();
            ControladorJuegoAdivLaPal cj = new ControladorJuegoAdivLaPal();
        }
    }
}
