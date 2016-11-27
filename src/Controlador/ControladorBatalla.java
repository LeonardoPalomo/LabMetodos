
package Controlador;


import Modelo.Batalla;
import Modelo.Casilla;
import Modelo.Personaje;
import Vista.VistaBatalla;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;

public class ControladorBatalla implements ActionListener, MouseListener {
    private VistaBatalla vb;
    private Batalla b;
    private Random distribAltura;
    public static int areaAsignatura;
    private Personaje[] pjsJugador;
    private Personaje[] pjsCpu;
    
    //Constructor
    public ControladorBatalla(int areaAsignatura, ArrayList<Personaje> pjsJugador){
        pjsJugador.toArray(this.pjsJugador);
        this.areaAsignatura = areaAsignatura;
        vb = new VistaBatalla();
        vb.setVisible(true);
        vb.setListener(this);
        vb.setMouseListener(this);
        b = new Batalla();
        b.setPjsJugador(this.pjsJugador);
        b.asignarTerrenos(areaAsignatura, distribAltura); //Asigna los terrenos en función del área de la asignatura.
        //Por ahora, el área está fija en 3. 1 es plan común, 2 es economía, 3 es especialidad.
        b.corregirTerrenosTodos(); //Corrige los ríos que están solos, para que siempre haya al menos dos juntos.
        do{
            b.asignarAlturas(distribAltura, areaAsignatura);//Se le atribuyen alturas a cada casilla(del tablero logico)
        } while(!b.revisarAlturas());//Mientras La comprobacion del terreno de un resultado "falso", se inicializa el proceso de distibucion de alturas
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                String ruta = b.ponerRutaImagenesTerreno(i, j);
                vb.ponerImagenTablero(ruta, i, j);
            }
        }
        b.corregirMontañas(b.contarTerrenos(), areaAsignatura);
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                String ruta = b.ponerRutaImagenesTerreno(i, j);
                vb.ponerImagenTablero(ruta, i, j);
            }
        }
        //aqui se colocan pjs de la cpu en el tablero
        String[] rutas = b.ubicarPersonajesCpu(b.obtenerPersonajesCpu());
        for(int k=0; k<rutas.length; k++){
            String rutaYCoord = rutas[k];
            String[] rutaYCoordSeparados = rutaYCoord.split("-");
            String ruta = rutaYCoordSeparados[0];
            int fila = Integer.parseInt(rutaYCoordSeparados[1]);
            int columna = Integer.parseInt(rutaYCoordSeparados[2]);
            vb.ponerImagenTablero(ruta, fila, columna);
        }
        b.contarTerrenos();
        System.out.println(b.revisarAlturas());
        
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
                    if(b.getTablero(i, j).getPersonaje()!=null){
                        vb.setLabelPersonaje(b.getTablero(i, j).getPersonaje().getNombre());
                        vb.setLabelDueño(b.getTablero(i, j).getPersonaje().getDueno());
                        int tipo = b.getTablero(i, j).getPersonaje().getTipo();
                        String tipoTexto = "";
                        switch(tipo){
                            case 1:
                                tipoTexto = "Alumno";
                                break;
                            case 2:
                                tipoTexto = "Ayudante";
                                break;
                            case 3:
                                tipoTexto = "Profesor";
                                break;
                        }
                        vb.setLabelTipo(tipoTexto);
                        int rol = b.getTablero(i,j).getPersonaje().getRol();
                        int subRol = b.getTablero(i,j).getPersonaje().getSubRol();
                        String rolTexto = "";
                        String subRolTexto = "";
                        switch(rol){
                            case 1:
                                rolTexto = "Guerrero";
                                break;
                            case 2:
                                rolTexto = "Arquero";
                                break;
                            case 3:
                                rolTexto = "Ninja";
                                break;
                            case 4:
                                rolTexto = "Mago";
                                break;
                        }
                        switch(subRol){
                            case 0:
                                subRolTexto = "";
                                break;
                            case 1:
                                subRolTexto = " Humanista";
                                break;
                            case 2:
                                subRolTexto = " Tecnólogo";
                                break;
                            case 3:
                                subRolTexto = " Médico";
                                break;
                        }
                        vb.setLabelRol(rolTexto+subRolTexto);
                    }
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
                    vb.setLabelPersonaje();
                    vb.setLabelDueño();
                    vb.setLabelTipo();
                    vb.setLabelRol();
                }
            }
        }
    }
    
}
