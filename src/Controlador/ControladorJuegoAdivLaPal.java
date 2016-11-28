
package Controlador;

import Modelo.JuegoAdivLaPal;
import Vista.VistaJuegoAdivLaPal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorJuegoAdivLaPal implements ActionListener {
    
    private VistaJuegoAdivLaPal vj;
    private JuegoAdivLaPal j;
    private String palabraCpu;
    private int dificultad = ControladorInicialAdivLaPal.dificultad;
    public static int cantidadLetras;
    private char[] palabraSeparada;
    private char[] intentoUsuario;
    private char[] letrasCorrectas;
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
        j = new JuegoAdivLaPal();
        palabraCpu = j.obtenerPalabra(dificultad);
        System.out.println("La palabra elegida por la cpu es: "+palabraCpu);
        palabraSeparada = palabraCpu.toCharArray();
        System.out.println("La primera letra es: "+palabraSeparada[0]);
        cantidadIntentos = 0;
        intentoUsuario = new char[cantidadLetras];
        letrasCorrectas = new char[cantidadLetras];
        letrasCorrectas[0] = palabraSeparada[0];
        vj.mostrarLetra(palabraSeparada[0]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vj.getBotonOk() == e.getSource()){
            System.out.println("Ha intentado adivinar la palabra");
            boolean chequeo = true;
            for(char letra:intentoUsuario){
                if(letra=='\0'){
                    chequeo = false;
                }
            }
            if(chequeo){
                char[] letrasEncontradas;
                letrasEncontradas = j.revisarIntento(palabraSeparada,intentoUsuario,letrasCorrectas);
                indiceLetra = 0;
                for(char letra:letrasCorrectas){
                    System.out.println(letra);
                    if(letra=='\0'){
                        vj.mostrarLetra(false);
                    }
                    else{
                        vj.mostrarLetra(letra);
                    }
                    indiceLetra++;
                }
                indiceLetra = 0;
                cantidadIntentos++;
            }
            else{
                JOptionPane.showMessageDialog(null,"Debe ingresar " + cantidadLetras + " para realizar un intento.","Error",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(vj.getBotonBorrar() == e.getSource()){
            System.out.println("Ha presionado Borrar");
            if(indiceLetra>0){
                vj.mostrarLetra(false);
                intentoUsuario[indiceLetra-1] = '\0';
                indiceLetra--;
            }
        }
        else if(vj.getLetraQ() == e.getSource()){
            System.out.println("Ha presionado Q");
            if(indiceLetra<cantidadLetras){
                intentoUsuario[indiceLetra] = 'Q';
                vj.mostrarLetra('Q');
                if(indiceLetra!=cantidadLetras-1){
                    indiceLetra++;
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
                }
            }
        }
    }
    
}
