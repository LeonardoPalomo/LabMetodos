
package Controlador;

import Modelo.JuegoAdivLaPal;
import Modelo.Jugador;
import Vista.VistaJuegoAdivLaPal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorJuegoAdivLaPal implements ActionListener, KeyListener {
    
    private VistaJuegoAdivLaPal vj;
    private JuegoAdivLaPal j;
    private String palabraCpu;
    private int dificultad = ControladorInicialAdivLaPal.dificultad;
    public static int cantidadLetras;
    private char[] palabraSeparada;
    private char[] intentoUsuario;
    //private char[] letrasCorrectas;
    public static int cantidadIntentos;
    public static int indiceLetra;
    
    public ControladorJuegoAdivLaPal(){
        if(dificultad == 1){
            cantidadLetras = 5;
        }
        else if(dificultad == 2){
            cantidadLetras = 6;
        }
        else if(dificultad == 3){
            cantidadLetras = 7;
        }
        
        vj = new VistaJuegoAdivLaPal();
        vj.setVisible(true);
        vj.setLocationRelativeTo(null);
        vj.agregarListener(this);
        vj.agregarKeyListener(this);
        j = new JuegoAdivLaPal();
        palabraCpu = j.obtenerPalabra(dificultad);
        System.out.println("La palabra elegida por la cpu es: "+palabraCpu);
        palabraSeparada = palabraCpu.toCharArray();
        System.out.println("La primera letra es: "+palabraSeparada[0]);
        cantidadIntentos = 0;
        intentoUsuario = new char[cantidadLetras];
        j.getLetrasCorrectas()[0] = palabraSeparada[0];
        vj.mostrarLetra(palabraSeparada[0]);
        vj.marcarCasilla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vj.getBotonOk() == e.getSource()){
            String intento = "Ha intentado adivinar la palabra";
            System.out.println(intento);
            vj.setTextArea(intento);
            boolean chequeo = true;
            for(char letra:intentoUsuario){
                if(letra=='\0'){
                    chequeo = false;
                }
                else{
                    System.out.println("Letra intentada: "+String.valueOf(letra));
                }
            }
            System.out.println(chequeo);
            if(chequeo){
                char[][] resultado = new char[2][intentoUsuario.length];
                resultado = j.revisarIntento(palabraSeparada,intentoUsuario);
                for(char letra:resultado[0]){
                    System.out.println("Letras correctas: "+String.valueOf(letra));
                }
                for(char letra:resultado[1]){
                    System.out.println("Letras encontradas: "+String.valueOf(letra));
                }
                ArrayList<Integer> indicesLetrasCorrectas;
                indicesLetrasCorrectas = j.ubicarLetraCorrecta(resultado[0]);
                ArrayList<Integer> indicesLetrasEncontradas;
                indicesLetrasEncontradas = j.ubicarLetrasEncontradas(resultado[1]);
                vj.mostrarAciertos(indicesLetrasCorrectas, indicesLetrasEncontradas);
                indiceLetra = 0;
                cantidadIntentos++;
                vj.marcarCasilla();
                if(j.getVictoria()){
                    int recompensa = j.getRecompensa();
                    try {
                        Jugador.actualizarOro(recompensa);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorJuegoAdivLaPal.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("BDD no conectada: No se pudo guardar recompensa.");
                    }
                    String msjeVictoria = "¡Has ganado! \nRecompensa: "+recompensa;
                    System.out.println(msjeVictoria);
                    JOptionPane.showMessageDialog(vj,msjeVictoria,"Victoria",JOptionPane.INFORMATION_MESSAGE);
                    vj.dispose();
                    ControladorPrincipalAdivLaPal cp = new ControladorPrincipalAdivLaPal();
                }
                else if(cantidadIntentos == 5){
                    String msjeDerrota = "Has perdido :( \nLa palabra era "+palabraCpu;
                    System.out.println(msjeDerrota);
                    JOptionPane.showMessageDialog(vj,msjeDerrota,"Derrota",JOptionPane.INFORMATION_MESSAGE);
                    vj.dispose();
                    ControladorPrincipalAdivLaPal cp = new ControladorPrincipalAdivLaPal();
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Debe ingresar " + cantidadLetras + " para realizar un intento.","Error",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(vj.getBotonBorrar() == e.getSource()){
            System.out.println("Ha presionado Borrar");
            if(indiceLetra == cantidadLetras-1){
                intentoUsuario[indiceLetra] = '\0';
                vj.mostrarLetra(false);
                indiceLetra--;
            }
            else if(indiceLetra>0 && indiceLetra<cantidadLetras-1){       
                intentoUsuario[indiceLetra-1] = '\0'; 
                vj.mostrarLetra(false);
                indiceLetra--;  
            }
            else{
                intentoUsuario[indiceLetra] = '\0';
                vj.mostrarLetra(false);
            }
            vj.marcarCasilla();
        }
        else if(vj.getLetraQ() == e.getSource()){
            System.out.println("Ha presionado Q");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'Q';
                vj.mostrarLetra('Q');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraW() == e.getSource()){
            System.out.println("Ha presionado W");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'W';
                vj.mostrarLetra('W');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraE() == e.getSource()){
            System.out.println("Ha presionado E");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'E';
                vj.mostrarLetra('E');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraR() == e.getSource()){
            System.out.println("Ha presionado R");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'R';
                vj.mostrarLetra('R');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraT() == e.getSource()){
            System.out.println("Ha presionado T");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'T';
                vj.mostrarLetra('T');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraY() == e.getSource()){
            System.out.println("Ha presionado Y");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'Y';
                vj.mostrarLetra('Y');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraU() == e.getSource()){
            System.out.println("Ha presionado U");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'U';
                vj.mostrarLetra('U');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraI() == e.getSource()){
            System.out.println("Ha presionado I");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'I';
                vj.mostrarLetra('I');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraO() == e.getSource()){
            System.out.println("Ha presionado O");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'O';
                vj.mostrarLetra('O');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraP() == e.getSource()){
            System.out.println("Ha presionado P");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'P';
                vj.mostrarLetra('P');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraA() == e.getSource()){
            System.out.println("Ha presionado A");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'A';
                vj.mostrarLetra('A');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraS() == e.getSource()){
            System.out.println("Ha presionado S");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'S';
                vj.mostrarLetra('S');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraD() == e.getSource()){
            System.out.println("Ha presionado D");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'D';
                vj.mostrarLetra('D');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraF() == e.getSource()){
            System.out.println("Ha presionado F");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'F';
                vj.mostrarLetra('F');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraG() == e.getSource()){
            System.out.println("Ha presionado G");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'G';
                vj.mostrarLetra('G');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraH() == e.getSource()){
            System.out.println("Ha presionado H");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'H';
                vj.mostrarLetra('H');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraJ() == e.getSource()){
            System.out.println("Ha presionado J");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'J';
                vj.mostrarLetra('J');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraK() == e.getSource()){
            System.out.println("Ha presionado K");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'K';
                vj.mostrarLetra('K');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraL() == e.getSource()){
            System.out.println("Ha presionado L");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'L';
                vj.mostrarLetra('L');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraZ() == e.getSource()){
            System.out.println("Ha presionado Z");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'Z';
                vj.mostrarLetra('Z');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraX() == e.getSource()){
            System.out.println("Ha presionado X");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'X';
                vj.mostrarLetra('X');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraC() == e.getSource()){
            System.out.println("Ha presionado C");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'C';
                vj.mostrarLetra('C');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraV() == e.getSource()){
            System.out.println("Ha presionado V");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'V';
                vj.mostrarLetra('V');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraB() == e.getSource()){
            System.out.println("Ha presionado B");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'B';
                vj.mostrarLetra('B');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraN() == e.getSource()){
            System.out.println("Ha presionado N");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'N';
                vj.mostrarLetra('N');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
        else if(vj.getLetraM() == e.getSource()){
            System.out.println("Ha presionado M");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'M';
                vj.mostrarLetra('M');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
                    vj.marcarCasilla();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            vj.getBotonBorrar().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_ENTER){
            vj.getBotonOk().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_A){
            vj.getLetraA().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_B){
            vj.getLetraB().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_C){
            vj.getLetraC().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_D){
            vj.getLetraD().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_E){
            vj.getLetraE().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_F){
            vj.getLetraF().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_G){
            vj.getLetraG().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_H){
            vj.getLetraH().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_I){
            vj.getLetraI().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_J){
            vj.getLetraJ().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_K){
            vj.getLetraK().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_L){
            vj.getLetraL().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_M){
            vj.getLetraM().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_N){
            vj.getLetraN().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_O){
            vj.getLetraO().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_P){
            vj.getLetraP().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_Q){
            vj.getLetraQ().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_R){
            vj.getLetraR().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_S){
            vj.getLetraS().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_T){
            vj.getLetraT().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_U){
            vj.getLetraU().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_V){
            vj.getLetraV().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_W){
            vj.getLetraW().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_X){
            vj.getLetraX().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_Y){
            vj.getLetraY().doClick();
        }
        else if(e.getKeyCode()==KeyEvent.VK_Z){
            vj.getLetraZ().doClick();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
