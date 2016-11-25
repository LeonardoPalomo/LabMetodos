
package Controlador;

import Modelo.Personaje;
import Vista.VistaSelPjs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorSelPjs implements ActionListener{
    
    private VistaSelPjs vsp;
    private ArrayList<Personaje> pjsDisponibles;
    private ArrayList<Personaje> pjsSeleccionados;
    
    public ControladorSelPjs(){
        vsp = new VistaSelPjs();
        vsp.setVisible(true);
        vsp.setLocationRelativeTo(null);
        vsp.setPjsDisponibles(pjsDisponibles);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
