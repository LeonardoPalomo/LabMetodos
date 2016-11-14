
package Controlador;


import Vista.VistaBatalla;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorBatalla implements ActionListener {
    private VistaBatalla vb;
    public ControladorTablero t;
    
    
    //Constructor
    public ControladorBatalla(){
        vb = new VistaBatalla();
        vb.setVisible(true);
        vb.setListener(this);
        t = new ControladorTablero(vb.getPanelVacio(),this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="Cancelar"){
            System.out.println("Accion cancelar");
            //JOptionPane.showMessageDialog(vb,"WENAAA");
        }
        else if(e.getActionCommand()=="Aceptar"){
            System.out.println("Accion aceptar");
        }
        else if(e.getActionCommand()=="Atacar"){
            System.out.println("Accion atacar");
        }
        else if(e.getActionCommand()=="Mover"){
            System.out.println("Accion mover");
        }
        else if(e.getActionCommand()=="Usar"){
            System.out.println("Accion usar");
        }
        else if(e.getActionCommand()=="Finalizar turno"){
            System.out.println("Accion terminar turno");
        }
        for(int i=0;i<25;i++){
            for(int j=0; j<25;j++)
            {
                if(e.getSource() == t.terreno[i][j]){
                    System.out.println(i+","+j);
                    t.terreno[i][j].setBackground(Color.red);
                }
            }
        }
    }
    
}
