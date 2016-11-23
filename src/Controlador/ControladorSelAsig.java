
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
        try{
            if(vsac.getAtras()==e.getSource()){
                vsac.dispose();
                ControladorVistaPrincipal cvp = new ControladorVistaPrincipal();
            }
        } catch(NullPointerException n){
        }
        try {
            if (vsae.getAtras() == e.getSource()) {
                vsae.dispose();
                ControladorVistaPrincipal cvp = new ControladorVistaPrincipal();
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getAdminProySoft() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getAlgebra1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getAlgebra2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getAlgorAvanz() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getAlgorNum() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getAnalDatos() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getAntropIng() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getCalculo1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getCalculo2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getCalculo3() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getDirGestEmp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getDiseñoBdd() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getEcono() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getEcua() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getEda() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getElectro() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getEstadistica() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getEstructComp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getEvalProy() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getFinanzas() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getFingeso() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getFisica1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getFisica2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getFundaComp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getInferModEst() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getIngSist() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getIngSoc() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getIngles1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getIngles2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getIngles3() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getIngles4() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getIntroIng() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getLogTeoComp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getMacro() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getMetEstudio() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getMetIngSoft() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getMetOptim() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getMetodosProgra() == e.getSource()) {
                //Momentáneo~
                vsac.dispose();
                ControladorBatalla cb = new ControladorBatalla(3);
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getModelSimul() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getOrgaComp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getParadigmas() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getPiinfo() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getProcLeng() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getQuimica() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getRedesComp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getSegurAuditInf() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getSeminInfo() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getSistComun() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getSistDist() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getSistope() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTallerBdd() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTallerBdd() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTallerIngeso() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTdp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTdp2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTitul() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTopicos1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTopicos2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTopicos3() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTopicos4() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTopicos5() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsac.getTopicos6() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getAdminGestInfo() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getAlgebra1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getAlgebra2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getCalculo1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getCalculo2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getDiseñoBdd() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getEcono() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getEcua() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getEda() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getElectro() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getEstadistica() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getEstrucComp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getEvalGestProy() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getFingeso() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getFisica1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getFisica2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getFundComp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getInfoSoc() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getIngesis() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getIngles1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getIngles2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getIngles3() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getIngles4() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getIntroIng() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getMetEstud() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getMetProgra() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getOrgaComp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getParadigmas() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getProyIngSoft() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getQuimica() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getRedesComp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getSeminCompInfo() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getSistInfo() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getSistope() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getTallerBdd() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getTdp() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getTdp2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getTecIngSoft() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getTitul() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getTopicos1() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getTopicos2() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
        try {
            if (vsae.getTopicos3() == e.getSource()) {
                
            }
        } catch (NullPointerException n) {
        }
    }
    
}
