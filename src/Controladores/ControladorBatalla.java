
package Controladores;

import Modelo.Tablero;
import Vista.VistaBatalla;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBatalla implements ActionListener {
    private VistaBatalla vb;
    public Tablero t;
    
    
    //Constructor
    public ControladorBatalla(){
        vb = new VistaBatalla();
        vb.setVisible(true);
        vb.setListener(this);
        t = new Tablero(vb.getPanel(),this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="Cancelar"){
            System.out.println("Accion cancelar");
        }
        else if(e.getActionCommand()=="Aceptar"){
            System.out.println("Accion aceptar");
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
