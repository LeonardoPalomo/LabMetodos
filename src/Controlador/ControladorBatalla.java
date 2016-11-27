
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
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Random;

public class ControladorBatalla implements ActionListener, MouseListener {
    private VistaBatalla vb;
    private Batalla b;
    private Random distribAltura;
    public static int areaAsignatura;
    private Personaje[] pjsJugador;
    private Personaje[] pjsCpu;
    private int[] ultPosClick = new int[2];
    private int cantPjsUbicados = 0;
    private int cntTurno = 0;
    private boolean esperaClickMover = false;
    private boolean esperaClickAtacar = false;
    private boolean puedeMover = true;
    private boolean puedeAtacar = true;
    private boolean seMovio = false;
    private boolean ataco = false;
    
    //Constructor
    public ControladorBatalla(int areaAsignatura, ArrayList<Personaje> pjsJugador){
        ultPosClick[0] = -1;
        ultPosClick[1] = -1;
        this.areaAsignatura = areaAsignatura;
        vb = new VistaBatalla();
        vb.setVisible(true);
        vb.setListener(this);
        vb.setMouseListener(this);
        b = new Batalla();
        b.limpiarListaPjs(pjsJugador);
        this.pjsJugador = b.getPjsJugador();
        this.pjsCpu = b.getPjsCpu();
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
        if(!b.revisarAlturas()){
            System.out.println("Volviendo a generar escenario...");
            ArrayList<Personaje> pjsSeleccionados = new ArrayList<>(Arrays.asList(this.pjsJugador));
            vb.dispose();
            ControladorBatalla cb = new ControladorBatalla(ControladorBatalla.areaAsignatura,pjsSeleccionados);
        }
        else{
            b.ordenarTurnos();
            vb.disableButtons();
            vb.getBtnSurrender().setEnabled(false);
            vb.getbtnCancelar().setEnabled(false);
            vb.marcarZona(0,0,24,3,Color.WHITE);
            b.informarUbicarPjs(vb,this.pjsJugador[0]);
        }      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="Cancelar"){
            //System.out.println("Accion cancelar");
            if(ultPosClick[0] != -1 && ultPosClick[1] != -1){
                vb.marcarZona(ultPosClick[0], ultPosClick[1], ultPosClick[0], ultPosClick[1], Color.WHITE);
            }
            cantPjsUbicados--;
            ultPosClick[0] = this.pjsJugador[cantPjsUbicados].getPosicion()[0];
            ultPosClick[1] = this.pjsJugador[cantPjsUbicados].getPosicion()[1];
            String ruta = b.ponerRutaImagenesTerreno(ultPosClick[0],ultPosClick[1]);
            vb.ponerImagenTablero(ruta,ultPosClick[0],ultPosClick[1]);
            b.ubicarPersonaje(ultPosClick[0],ultPosClick[1]);
            b.informarUbicarPjs(vb,this.pjsJugador[cantPjsUbicados]);
            ultPosClick[0] = -1;
            ultPosClick[1] = -1;
            if(cantPjsUbicados == 0){
                vb.getbtnCancelar().setEnabled(false);
            }
        }
        if(e.getActionCommand()=="Aceptar"){
            //System.out.println("Accion aceptar");
            if(ultPosClick[0] != -1 && ultPosClick[1] != -1){
                String ruta = b.ubicarPersonaje(this.pjsJugador[cantPjsUbicados],ultPosClick[0],ultPosClick[1]);
                if(!ruta.equals("")){
                    vb.ponerImagenTablero(ruta,ultPosClick[0],ultPosClick[1]);
                    vb.marcarZona(ultPosClick[0], ultPosClick[1], ultPosClick[0], ultPosClick[1], Color.WHITE);
                    cantPjsUbicados++;
                    vb.getbtnCancelar().setEnabled(true);
                    if(cantPjsUbicados == this.pjsJugador.length){
                        //Inicia la batalla
                        JOptionPane.showMessageDialog(vb,"¡Ha comenzado la batalla!");
                        vb.getbtnAceptar().setEnabled(false);
                        vb.getbtnCancelar().setEnabled(false);
                        vb.desmarcarZona(0,0,24,3);
                        vb.eliminarBordesEscenario();
                        vb.enableButtons();
                        vb.getBtnSurrender().setEnabled(true);
                        String turnoActual = b.getOrdenTurnos()[cntTurno].getNombre();
                        vb.setTextArea("Turno "+(b.getTurno()+1)+" - Turno de "+turnoActual);
                        vb.marcarCasilla(b.getOrdenTurnos()[cntTurno].getPosicion(),b.getOrdenTurnos()[cntTurno].getEsCpu());
                    }
                    else{
                        b.informarUbicarPjs(vb,this.pjsJugador[cantPjsUbicados]);
                        ultPosClick[0] = -1;
                        ultPosClick[1] = -1;
                    }
                }
            }
        }
        if(e.getActionCommand()=="Atacar"){
            //System.out.println("Accion atacar");
            if(seMovio){
                puedeMover = false;
            }
        }
        if(e.getActionCommand()=="Mover"){
            //System.out.println("Accion mover");
            if(puedeMover){
                JOptionPane.showMessageDialog(vb,"<html><center>Haga click en la casilla a la que desea moverse"
                    + "<br><center> (debe ser adyacente al personaje)","Mover",JOptionPane.INFORMATION_MESSAGE);
                this.esperaClickMover = true;
            }
            
        }
        if(e.getActionCommand()=="Usar"){
            System.out.println("Accion usar");
        }
        if(e.getActionCommand()=="Finalizar turno"){
            //System.out.println("Accion terminar turno");
            cntTurno++;
            b.sumarTurno();
            if(cntTurno > b.getOrdenTurnos().length - 1){
                cntTurno = 0;
            }
            String turnoActual = b.getOrdenTurnos()[cntTurno].getNombre();
            vb.setTextArea("Turno "+(b.getTurno()+1)+" - Turno de "+turnoActual);
            vb.marcarCasilla(b.getOrdenTurnos()[cntTurno].getPosicion(),b.getOrdenTurnos()[cntTurno].getEsCpu());
            if(cntTurno == 0){
                vb.eliminarBordesCasilla(b.getOrdenTurnos()[b.getOrdenTurnos().length-1].getPosicion());
            }
            else{
                vb.eliminarBordesCasilla(b.getOrdenTurnos()[cntTurno-1].getPosicion());
            }
            if(b.getOrdenTurnos()[cntTurno].getEsCpu()){
                vb.disableButtons();
            }
            else{
                vb.enableButtons();
            }
        }
        if(vb.getBtnSurrender() == e.getSource()){
            int opcion = JOptionPane.showConfirmDialog(vb,"<html><center>¿Estás seguro/a que quieres rendirte?"
                    + "<br><center> Perderás cualquier avance y ganancias obtenidos en la batalla,"
                    + "<br><center> pero los items gastados y los daños recibidos permanecerán.",
                    "¿Acaso eres un gallina, McFly?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(opcion == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(vb,"Has perdido... :(","RIP",JOptionPane.INFORMATION_MESSAGE);
                vb.dispose();
                ControladorVistaPrincipal cvp = new ControladorVistaPrincipal();
            }
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
                    if(esperaClickMover){
                        int iAnterior = b.getOrdenTurnos()[cntTurno].getPosicion()[0];
                        int jAnterior = b.getOrdenTurnos()[cntTurno].getPosicion()[1];
                        if(b.getOrdenTurnos()[cntTurno].mover(i,j,b.verificarMover(i,j,cntTurno))){
                            String ruta = b.ubicarPersonaje(b.getOrdenTurnos()[cntTurno],i,j);
                            if(!ruta.equals("")){
                                vb.ponerImagenTablero(ruta,i,j);
                                vb.marcarCasilla(i,j,false);
                                vb.ponerImagenTablero(b.ponerRutaImagenesTerreno(iAnterior, jAnterior),iAnterior,jAnterior);
                                vb.eliminarBordesCasilla(iAnterior,jAnterior);
                                b.getTablero(iAnterior, jAnterior).setPersonaje();
                                seMovio = true;
                                if(ataco){
                                    puedeAtacar = false;
                                }
                                if(b.getOrdenTurnos()[cntTurno].getMovActual() == 0){
                                    vb.getBtnMover().setEnabled(false);
                                }
                            }
                        }
                        esperaClickMover = false;
                    }
                    if(cantPjsUbicados < this.pjsJugador.length){
                        //if(ubicandoPjs){
                            if(b.getTablero(i, j).getCaminable() ){
                                if(b.getTablero(i,j).getDisponible()){
                                    if(j < 4){
                                        if(ultPosClick[0] != -1 && ultPosClick[1] != -1){
                                            vb.marcarZona(ultPosClick[0], ultPosClick[1], ultPosClick[0], ultPosClick[1], Color.WHITE);
                                        }
                                        vb.marcarCasilla(i, j,b.getOrdenTurnos()[cntTurno].getEsCpu());
                                        this.ultPosClick[0] = i;
                                        this.ultPosClick[1] = j;
                                        
                                    }
                                    else{
                                        System.out.println("Casilla fuera del área permitida");
                                        JOptionPane.showMessageDialog(vb,"La casilla está fuera del área permitida.","ERROR",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else{
                                    System.out.println("Casilla no disponible");
                                    JOptionPane.showMessageDialog(vb,"La casilla no está disponible.","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else{
                                System.out.println("Casilla no caminable");
                                JOptionPane.showMessageDialog(vb,"El terreno Río no es válido para posicionar personajes.","ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                        //}
                    }
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
                    Casilla casilla = b.getTablero(i,j);
                    Personaje pj = casilla.getPersonaje();
                    int terreno = casilla.getTerreno();
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
                    vb.setLabelAltura(casilla.getAltura());
                    if(cantPjsUbicados == pjsJugador.length){
                        vb.marcarCasilla(i, j,b.getOrdenTurnos()[cntTurno].getEsCpu());
                    }
                    if(pj != null){
                        vb.setLabelPersonaje(pj.getNombre());
                        vb.setLabelDueño(pj.getDueno());
                        int tipo = pj.getTipo();
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
                        int rol = pj.getRol();
                        int subRol = pj.getSubRol();
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
                        vb.setLabelLvl(pj.getNivel());
                        vb.setLabelHp(pj.getHpActual(),pj.getHpTotal());
                        vb.setLabelMana(pj.getManaActual(),pj.getManaTotal());
                        vb.setLabelMov(pj.getMovActual(), pj.getMovTotal());
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
                    vb.setLabelLvl();
                    vb.setLabelHp();
                    vb.setLabelMana();
                    vb.setLabelMov();
                    if(cantPjsUbicados == pjsJugador.length){
                        if(b.getTablero(i, j).getPersonaje() != b.getOrdenTurnos()[cntTurno]){
                            vb.desmarcarCasilla(i, j);
                        }
                    }
                }
            }
        }
    }
    
}
