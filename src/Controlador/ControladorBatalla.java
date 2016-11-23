
package Controlador;


import Modelo.Batalla;
import Modelo.Casilla;
import Vista.VistaBatalla;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.util.Random;

public class ControladorBatalla implements ActionListener, MouseListener {
    private VistaBatalla vb;
    private Batalla b;
    private Random distribAltura;
    private int areaAsignatura;
    
    //Constructor
    public ControladorBatalla(int areaAsignatura){
        this.areaAsignatura = areaAsignatura;
        vb = new VistaBatalla();
        vb.setVisible(true);
        vb.setListener(this);
        vb.setMouseListener(this);
        b = new Batalla();
        b.asignarTerrenos(areaAsignatura, distribAltura); //Asigna los terrenos en función del área de la asignatura.
        //Por ahora, el área está fija en 3.
        b.corregirRios(); //Corrige los ríos que están solos, para que siempre haya al menos dos juntos.
        do{
            b.asignarAlturas(distribAltura);//Se le atribuyen alturas a cada casilla(del tablero logico)
        } while(!b.revisarAlturas());//Mientras La comprobacion del terreno de un resultado "falso", se inicializa el proceso de distibucion de alturas
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                String ruta = b.ponerRutaImagenesTerreno(i, j);
                vb.ponerImagenesTerrenoVista(ruta, i, j);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="Cancelar"){
            System.out.println("Accion cancelar");
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
                if(e.getSource() == vb.getTablero()[i][j]){
                    int terreno = b.getTablero(i,j).getTerreno();
                    String nombreTerreno = "nada prro :v";
                    switch(terreno){
                        case 1:
                            nombreTerreno = "Tierra";
                            break;
                        case 2:
                            nombreTerreno = "Río";
                            break;
                        case 3:
                            nombreTerreno = "Bosque";
                            break;
                        case 4:
                            nombreTerreno = "Montaña";
                    }
                    System.out.println("Posición ["+i+"], ["+j+"]. Su terreno es "+nombreTerreno+", y su altura es "+b.getTablero(i,j).getAltura()+".");
                    //vb.getTablero()[i][j].setBackground(Color.red);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        for(int i=0;i<25;i++){
            for(int j=0; j<25;j++){
                if(e.getSource() == vb.getTablero()[i][j]){
                    int terreno = b.getTablero(i,j).getTerreno();
                    String nombreTerreno = "nada prro :v";
                    switch(terreno){
                        case 1:
                            nombreTerreno = "Tierra";
                            break;
                        case 2:
                            nombreTerreno = "Río";
                            break;
                        case 3:
                            nombreTerreno = "Bosque";
                            break;
                        case 4:
                            nombreTerreno = "Montaña";
                            break;
                    }
                    vb.setLabelPosicion(i, j);
                    vb.setLabelTerreno(nombreTerreno);
                    vb.setLabelAltura(b.getTablero(i,j).getAltura());
                    //vb.setLabelPersonaje(); Implementar
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        for(int i=0;i<25;i++){
            for(int j=0; j<25;j++){
                if(e.getSource() == vb.getTablero()[i][j]){
                    vb.setLabelPosicion();
                    vb.setLabelTerreno();
                    vb.setLabelAltura();
                    //vb.setLabelPersonaje(); Implementar
                }
            }
        }
    }
    
}
