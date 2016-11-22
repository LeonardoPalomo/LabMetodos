
package Controlador;

import Vista.VistaSelAsigCivil;
import Vista.VistaSelAsigEjecu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorSelAsig implements ActionListener{
    
    private VistaSelAsigCivil vsac;
    private VistaSelAsigEjecu vsae;
    
    public ControladorSelAsig(int malla){
        switch(malla){
            case 1:
                this.vsac = new VistaSelAsigCivil();
                vsac.setLocationRelativeTo(null);
                vsac.agregarListener(this);
                vsac.setVisible(true);
                break;
            case 2:
                this.vsae = new VistaSelAsigEjecu();
                vsae.setLocationRelativeTo(null);
                vsae.agregarListener(this);
                vsae.setVisible(true);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if(vsac.getAtras()==e.getSource()){
            vsac.dispose();
            ControladorVistaPrincipal cvp = new ControladorVistaPrincipal();
        }
        if(vsae.getAtras()==e.getSource()){
            vsae.dispose();
            ControladorVistaPrincipal cvp = new ControladorVistaPrincipal();
        }
        if(vsac.getAdminProySoft()==e.getSource()){
        
        }
        if(vsac.getAlgebra1()==e.getSource()){
        
        }
        if(vsac.getAlgebra2()==e.getSource()){
        
        }
        if(vsac.getAlgorAvanz()==e.getSource()){
        
        }
        if(vsac.getAlgorNum()==e.getSource()){
        
        }
        if(vsac.getAnalDatos()==e.getSource()){
        
        }
        if(vsac.getAntropIng()==e.getSource()){
        
        }
        if(vsac.getCalculo1()==e.getSource()){
        
        }
        if(vsac.getCalculo2()==e.getSource()){
        
        }
        if(vsac.getCalculo3()==e.getSource()){
        
        }
        if(vsac.getDirGestEmp()==e.getSource()){
        
        }
        if(vsac.getDiseñoBdd()==e.getSource()){
        
        }
        if(vsac.getEcono()==e.getSource()){
        
        }
        if(vsac.getEcua()==e.getSource()){
        
        }
        if(vsac.getEda()==e.getSource()){
        
        }
    }
    
}
