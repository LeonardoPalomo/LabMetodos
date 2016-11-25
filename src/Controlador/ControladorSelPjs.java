
package Controlador;

import Modelo.Personaje;
import Vista.VistaSelPjs;
import java.util.ArrayList;

public class ControladorSelPjs {
    
    private VistaSelPjs vsp;
    private ArrayList<Personaje> pjsDisponibles;
    private ArrayList<Personaje> pjsSeleccionados;
    
    public ControladorSelPjs(){
        
        vsp = new VistaSelPjs();
        
        
    }
    
}
