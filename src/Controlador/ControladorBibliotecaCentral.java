
package Controlador;

import Vista.VistaBibliotecaCentral;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; //si se borra este import la linea 9 no funciona


public class ControladorBibliotecaCentral implements ActionListener{
    private VistaBibliotecaCentral vbc;
    
     public ControladorBibliotecaCentral(){
        vbc = new VistaBibliotecaCentral();
        vbc.setLocationRelativeTo(null);
        vbc.setVisible(true);
        vbc.agregarListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (vbc.getButtonVolver()==e.getSource()){
            String volver = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha vuelto al menú principal.";
            ControladorPrincipal.registrarAccion(volver);
            vbc.dispose();
            ControladorVistaPrincipal cvp = new ControladorVistaPrincipal();
        }
        else if(vbc.getButtonAhorcado()==e.getSource()){
            String ahorcadoIniciado = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha iniciado misión extra ahorcado";
            ControladorPrincipal.registrarAccion(ahorcadoIniciado);
            vbc.setVisible(false);
            ControladorAhorcado ca = new ControladorAhorcado();
        }
     
    }
}
