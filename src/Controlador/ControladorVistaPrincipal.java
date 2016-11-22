package Controlador;

import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVistaPrincipal implements ActionListener{
    private VistaPrincipal vp;

    public ControladorVistaPrincipal(){
        this.vp = new VistaPrincipal();
        vp.setLocationRelativeTo(null);
        vp.agregarListener(this);
        vp.setVisible(true);
        
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
            ControladorSelAsig csa = new ControladorSelAsig(1); //1 civil, 2 ejecu
            //ControladorBatalla cb = new ControladorBatalla();
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