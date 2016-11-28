package Controlador;

import Modelo.Personaje;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorVistaPrincipal implements ActionListener{
    public static ArrayList<Personaje> pjsJugador;
    private VistaPrincipal vp;

    public ControladorVistaPrincipal(){
        pjsJugador = new ArrayList();
        this.vp = new VistaPrincipal();
        vp.setLocationRelativeTo(null);
        vp.agregarListener(this);
        vp.setVisible(true);
        //Se crea ArrayList de pjs provisorio, a futuro recibirá los pjs desde la BDD
        Personaje pj1 = new Personaje("Pinky",1,0);
        Personaje pj2 = new Personaje("Viru",2,0);
        Personaje pj3 = new Personaje("Ulloa",3,0);
        Personaje pj4 = new Personaje("Oveja",4,1);
        Personaje pj5 = new Personaje("Oink",4,2);
        Personaje pj6 = new Personaje("Mumu",4,3);
        pjsJugador.add(pj1);
        pjsJugador.add(pj2);
        pjsJugador.add(pj3);
        pjsJugador.add(pj4);
        pjsJugador.add(pj5);
        pjsJugador.add(pj6);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (vp.getButtonCerrarSesion()==e.getSource()){
            String sesionCerrada = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha cerrado sesión.";
            ControladorPrincipal.registrarAccion(sesionCerrada);
            vp.dispose();
            ControladorLogin cl = new ControladorLogin();
        }
        else if(vp.getButtonJugar()==e.getSource()){
            String seleccionAsignatura = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" va a seleccionar una asignatura.";
            ControladorPrincipal.registrarAccion(seleccionAsignatura);
            vp.setVisible(false);
            ControladorSelAsig csa = new ControladorSelAsig(ControladorLogin.malla); //1 civil, 2 ejecu
        }
        else if(vp.getButtonBibliotecaCentral()==e.getSource()){
            String biblioteca = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha accedido a biblioteca central";
            ControladorPrincipal.registrarAccion(biblioteca);
            vp.setVisible(false);
            ControladorBibliotecaCentral cbc = new ControladorBibliotecaCentral();
        }
        else if(vp.getButtonSalir()==e.getSource()){
            String salidaUsuario = "El usuario "+ Controlador.ControladorLogin.usuarioActivo +" ha salido del programa.";
            ControladorPrincipal.registrarAccion(salidaUsuario);
            System.exit(0);
        }
     
    }

}