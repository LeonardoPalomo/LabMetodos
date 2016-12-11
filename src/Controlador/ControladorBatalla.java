
package Controlador;


import Modelo.Batalla;
import Modelo.Casilla;
import Modelo.Personaje;
import Vista.VistaBatalla;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class ControladorBatalla implements ActionListener, MouseListener {
    private VistaBatalla vb;
    private ControladorBatallaCortoAlcance cbc;
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
    private boolean instrucMover = true;
    private boolean instrucAtk = true;
    
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
            if(ultPosClick[0] != -1 && ultPosClick[1] != -1){
                String ruta = b.ubicarPersonaje(this.pjsJugador[cantPjsUbicados],ultPosClick[0],ultPosClick[1]);
                if(!ruta.equals("")){
                    vb.ponerImagenTablero(ruta,ultPosClick[0],ultPosClick[1]);
                    vb.marcarZona(ultPosClick[0], ultPosClick[1], ultPosClick[0], ultPosClick[1], Color.WHITE);
                    cantPjsUbicados++;
                    vb.getbtnCancelar().setEnabled(true);
                    if(cantPjsUbicados == this.pjsJugador.length){
                        //Inicia la batalla
                        String comienzo = "¡Ha comenzado la batalla!";
                        JOptionPane.showMessageDialog(vb,comienzo);
                        System.out.println(comienzo);
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
            if(puedeAtacar){
                if(esperaClickMover){
                    String cancelado = "Movimiento cancelado";
                    System.out.println(cancelado);
                    vb.setTextArea(cancelado);
                }
                this.esperaClickMover = false;
                if(instrucMover){
                    JOptionPane.showMessageDialog(vb,"<html><center>Haga click en el personaje que desea atacar. "
                            + "<br><center>En función de la distancia, se usará un ataque a corta o larga distancia. "
                            + "<br><center>-1 a 2 casillas de distancia - ataque a corta distancia-"
                            + "<br><center>-5 a 8 casillas de distancia - ataque a larga distancia-",
                            "Ataque",JOptionPane.INFORMATION_MESSAGE);
                    instrucMover = false;
                }
                this.esperaClickAtacar = true;
                String esperando = "Esperando ataque...";
                System.out.println(esperando);
                vb.setTextArea(esperando);
            }
        }
        if(e.getActionCommand()=="Mover"){
            if(puedeMover){
                if(esperaClickAtacar){
                    String cancelado = "Ataque cancelado";
                    System.out.println(cancelado);
                    vb.setTextArea(cancelado);
                }
                this.esperaClickAtacar = false;
                if(instrucAtk){
                    JOptionPane.showMessageDialog(vb,"<html><center>Haga click en la casilla a la que desea moverse"
                        + "<br><center> (debe ser adyacente al personaje)","Mover",JOptionPane.INFORMATION_MESSAGE);
                    instrucAtk = false;
                }
                this.esperaClickMover = true;
                String esperando = "Esperando movimiento...";
                System.out.println(esperando);
                vb.setTextArea(esperando);
            }
        }
        if(e.getActionCommand()=="Usar"){
            JOptionPane.showMessageDialog(vb,"Trabajo en progreso...","WIP",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getActionCommand()=="Finalizar turno"){
            b.getOrdenTurnos()[cntTurno].resetMov();
            int fila = b.getOrdenTurnos()[cntTurno].getPosicion()[0];
            int columna = b.getOrdenTurnos()[cntTurno].getPosicion()[1];
            if (b.getOrdenTurnos()[cntTurno].getRol() == 3 && b.getTablero(fila,columna).getTerreno() == 2){
                b.getOrdenTurnos()[cntTurno].setHpActual(0);
            }
            cntTurno++;
            this.puedeAtacar = true;
            this.puedeMover = true;
            this.ataco = false;
            this.seMovio = false;
            b.sumarTurno();
            if(cntTurno > b.getOrdenTurnos().length - 1){
                cntTurno = 0;
            }
            String turnoActual = b.getOrdenTurnos()[cntTurno].getNombre();
            b.getOrdenTurnos()[cntTurno].recuperarMana();
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
                ArrayList<int[]> recorrido = b.getOrdenTurnos()[cntTurno].moverCpu(b.getOrdenTurnos()[cntTurno].getPosicion(),b.getTablero());
                for(int i= 0; i<b.getOrdenTurnos()[cntTurno].getMovActual(); i++){
                    
                }
                for(int i=0; i<recorrido.size(); i++){
                    System.out.println("Movimiento"+i+": ["+ recorrido.get(i)[0]+","+recorrido.get(i)[1]+"]");
                }
                System.out.println("Largo del recorrido: "+ recorrido.size());
                int capacidadM = b.getOrdenTurnos()[cntTurno].getMovActual();
                if(capacidadM>0){
                    
                }
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
                        Personaje personajeActual = b.getOrdenTurnos()[cntTurno];
                        int iAnterior = b.getOrdenTurnos()[cntTurno].getPosicion()[0];
                        int jAnterior = b.getOrdenTurnos()[cntTurno].getPosicion()[1];
                        int rol = personajeActual.getRol();
                        String ruta = "";
                        boolean busquedaRuta = false;
                        if(rol == 1 || rol == 2){
                            if(personajeActual.mover(i,j,b.verificarMover(i,j,cntTurno))){
                                busquedaRuta = true;
                            }
                        }
                        else if(rol == 3){
                            if(personajeActual.moverNinja(i,j,b.verificarMoverAltura(i, j, cntTurno))){
                                busquedaRuta = true;
                            }
                        }
                        else{
                            if(personajeActual.moverMago(i,j,b.getTablero(i, j).getCaminable())){
                                busquedaRuta = true;
                            }
                        }
                        if(busquedaRuta){
                            ruta = b.ubicarPersonaje(b.getOrdenTurnos()[cntTurno],i,j);
                        }
                        if(!ruta.equals("")){
                            vb.ponerImagenTablero(ruta,i,j);
                            vb.marcarCasilla(i,j,false);
                            vb.ponerImagenTablero(b.ponerRutaImagenesTerreno(iAnterior, jAnterior),iAnterior,jAnterior);
                            vb.eliminarBordesCasilla(iAnterior,jAnterior);
                            b.getTablero(iAnterior, jAnterior).setPersonaje();
                            seMovio = true;
                            String movimiento = "Movimiento realizado.";
                            System.out.println(movimiento);
                            vb.setTextArea(movimiento);
                            if(ataco){
                                puedeAtacar = false;
                                vb.getBtnAtacar().setEnabled(false);
                            }
                            if(b.getOrdenTurnos()[cntTurno].getMovActual() == 0){
                                vb.getBtnMover().setEnabled(false);
                            }
                        }
                        else {
                            vb.setTextArea(b.getErrorMovimiento());
                            esperaClickMover = false;
                            vb.getBtnMover().doClick(); //simula apretar el boton mover
                        }
                    }
                    if(esperaClickAtacar){
                        if(b.getTablero(i, j).getPersonaje() != null){
                            int tipoAtk = b.getOrdenTurnos()[cntTurno].calcularRangoAtaque(b.getTablero(i, j).getPosicion());
                            System.out.println("El tipo de ataque es "+tipoAtk);
                            System.out.println("El personaje atacado es "+b.getTablero(i,j).getPersonaje().getNombre());
                            System.out.println("Su posicion es "+b.getTablero(i,j).getPosicion()[0]+","+b.getTablero(i,j).getPosicion()[1]);
                            System.out.println("Verificando posicion... "+b.getTablero(i,j).getPersonaje().getPosicion()[0]+","+b.getTablero(i,j).getPersonaje().getPosicion()[1]);
                            switch(tipoAtk){
                                case 0:
                                    System.out.println("El objetivo no está dentro del rango de ataque.");
                                    vb.setTextArea("El objetivo no está dentro del rango de ataque");
                                    vb.getBtnAtacar().doClick();
                                    break;
                                case 1:
                                    int alturaAtk;
                                    int alturaDef;
                                    int filaAtk = b.getOrdenTurnos()[cntTurno].getPosicion()[0];
                                    int columnaAtk = b.getOrdenTurnos()[cntTurno].getPosicion()[1];
                                    alturaAtk = b.getTablero(filaAtk, columnaAtk).getAltura();
                                    alturaDef = b.getTablero(i,j).getAltura();
                                    if(alturaAtk > alturaDef || alturaDef - alturaAtk <= 2){
                                        //Se ejecuta el duelo
                                        //vb.setVisible(false);
                                        cbc = new ControladorBatallaCortoAlcance(cntTurno,i,j,b,vb);
                                    }
                                    break;
                                case 2:
                                    int visibles = b.ataquesVisibles(1, 7);
                                    System.out.println("Visibles: "+visibles);
                                    boolean tieneArmaLargoAlcance = false;
                                    for(int arma=0; arma<2; arma++){
                                        if(b.getOrdenTurnos()[cntTurno].getEquipamiento()[arma].getTipo() == 1 && b.getOrdenTurnos()[cntTurno].getEquipamiento()[arma].getSubtipo() == 2){
                                            tieneArmaLargoAlcance = true;
                                        }
                                    }
                                    if(tieneArmaLargoAlcance){
                                        String ataque = "El personaje "+b.getOrdenTurnos()[cntTurno].getNombre()+" ataca a distancia al personaje "+b.getTablero(i,j).getPersonaje().getNombre();
                                        System.out.println(ataque);
                                        vb.setTextArea(ataque);
                                        int daño = b.getOrdenTurnos()[cntTurno].atacarLejos(b.getTablero(i,j).getPersonaje().getDef(),b.getTablero(i,j).getTerreno());
                                        if(daño == -1){
                                            String falloCritico = "¡"+b.getOrdenTurnos()[cntTurno].getNombre()+" ha fallado su ataque!";
                                            System.out.println(falloCritico);
                                            vb.setTextArea(falloCritico);
                                        }
                                        else{
                                            int hpRestante = b.getTablero(i,j).getPersonaje().aplicarDaño(daño);
                                            String dañoRecibido = b.getTablero(i,j).getPersonaje().getNombre()+" recibe "+daño+" puntos de daño.";
                                            System.out.println(dañoRecibido);
                                            vb.setTextArea(dañoRecibido);
                                            //System.out.println(vbc.getEleccion1());
                                        }
                                    }
                                    else{
                                        String noTieneArmaLA = b.getOrdenTurnos()[cntTurno].getNombre()+" no tiene un arma de largo alcance.";
                                        System.out.println(noTieneArmaLA);
                                        vb.setTextArea(noTieneArmaLA);
                                    }
                                    break;
                            }
                            if(tipoAtk == 1 || tipoAtk == 2){
                                ataco = true;
                                puedeAtacar = false;
                                vb.getBtnAtacar().setEnabled(false);
                                if(seMovio){
                                    puedeMover = false;
                                    vb.getBtnMover().setEnabled(false);
                                }
                            }
                            
                        }
                        esperaClickAtacar = false;
                    }
                    if(cantPjsUbicados < this.pjsJugador.length){
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
                        if(b.getTablero(i,j).getPersonaje() == b.getOrdenTurnos()[cntTurno]){
                            vb.marcarCasilla(i, j,b.getOrdenTurnos()[cntTurno].getEsCpu());
                        }
                        else if(esperaClickMover){
                            vb.marcarCasilla(i,j,Color.YELLOW);
                        }
                        else if(esperaClickAtacar){
                            vb.marcarCasilla(i, j, Color.GREEN);
                        }
                        else{
                            vb.marcarCasilla(i, j,b.getOrdenTurnos()[cntTurno].getEsCpu());
                        }
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
                            vb.eliminarBordesCasilla(i, j);
                        }
                    }
                }
            }
        }
    }
    
}
