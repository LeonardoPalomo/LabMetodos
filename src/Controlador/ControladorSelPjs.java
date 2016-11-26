
package Controlador;

import Modelo.Personaje;
import Vista.VistaSelPjs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorSelPjs implements ActionListener, ListSelectionListener{
    
    private VistaSelPjs vsp;
    private ArrayList<Personaje> pjsDisponibles;
    private ArrayList<Personaje> pjsSeleccionados;
    private int cantPjsSel = 0;
    
    public ControladorSelPjs(){
        pjsDisponibles = ControladorVistaPrincipal.pjsJugador;
        pjsSeleccionados = new ArrayList();
        vsp = new VistaSelPjs();
        vsp.agregarListener(this);
        vsp.setVisible(true);
        vsp.setLocationRelativeTo(null);
        vsp.setPjsDisponibles(pjsDisponibles);
        vsp.getQuitar().setEnabled(false);
        vsp.getListo().setEnabled(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if(vsp.getAgregar() == e.getSource()){
            if(vsp.getListaPjsDisponibles().getSelectedValue() != null){
                ArrayList aRemover = new ArrayList();
                for(Personaje pj:pjsDisponibles){
                    if(pj.getNombre() == vsp.getListaPjsDisponibles().getSelectedValue()){
                        pjsSeleccionados.add(pj);
                        aRemover.add(pj);
                    }
                }
                pjsDisponibles.removeAll(aRemover);
                vsp.setPjsDisponibles(pjsDisponibles);
                vsp.setPjsSeleccionados(pjsSeleccionados);
                cantPjsSel++;
                vsp.getQuitar().setEnabled(true);
            }
            if(cantPjsSel == 5){
                vsp.getAgregar().setEnabled(false);
                vsp.getListo().setEnabled(true);
            }
        }
        if(vsp.getListo() == e.getSource()){
            vsp.dispose();
            ControladorBatalla cb = new ControladorBatalla(ControladorBatalla.areaAsignatura);
        }
        if(vsp.getQuitar() == e.getSource()){
            if(vsp.getListaPjsSeleccionados().getSelectedValue() != null){
                ArrayList aRemover = new ArrayList();
                for(Personaje pj:pjsSeleccionados){
                    if(pj.getNombre() == vsp.getListaPjsSeleccionados().getSelectedValue()){
                        pjsDisponibles.add(pj);
                        aRemover.add(pj);
                    }
                }
                pjsSeleccionados.removeAll(aRemover);
                vsp.setPjsDisponibles(pjsDisponibles);
                vsp.setPjsSeleccionados(pjsSeleccionados);
                cantPjsSel--;
            }
            if(cantPjsSel == 0){
                vsp.getQuitar().setEnabled(false);
            }
        }
        if(vsp.getVolver() == e.getSource()){
            vsp.dispose();
            ControladorSelAsig csa = new ControladorSelAsig(ControladorLogin.malla);
        }
    }
    
}
