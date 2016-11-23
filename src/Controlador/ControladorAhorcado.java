package Controlador;

import Modelo.Jugador;
import Modelo.Ahorcado;
import Vista.VistaAhorcado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControladorAhorcado implements ActionListener{
    
    private VistaAhorcado va;
    private Ahorcado ahorcado;
    private String palabra;
    private ArrayList<String> separado;
    private String letra;
    private int conjunto;
    private ArrayList<String> actual;
    private ArrayList<String> encriptadoLista;
    private String encriptado;
    private int[] mayor;

    
    public ControladorAhorcado(){
        
        va = new VistaAhorcado();
        ahorcado = new Ahorcado();
        va.setLocationRelativeTo(null);
        va.setVisible(true);
        va.setListener(this);
        
        conjunto = ahorcado.getConjunto();
        palabra = ahorcado.seleccionarPalabra(ahorcado.PALABRA, conjunto);
        System.out.println(palabra);
        encriptadoLista = ahorcado.inicializar(palabra);
        encriptado = ahorcado.arraylisttostring(encriptadoLista);
        mayor = ahorcado.cantidadLetras(ahorcado.PALABRA[ahorcado.getConjunto()]);
        
        va.setPalabra(encriptado);
        va.setErrores(6);
        va.setRecompensa(ahorcado.getRecompensa());

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==va.getButtonAceptar()){
                letra = va.getLetra_elegida();
                separado = new ArrayList(Arrays.asList(this.palabra.split("")));
                if(letra.equals(""))return;
                System.out.println(letra);
                String caso = ahorcado.verificar(letra, separado);
                va.setSituacion(caso);
                va.setErrores(ahorcado.getIntentos());
                va.setUsadas(ahorcado.getUsados());
                va.setLetra_elegida("");
                actual = ahorcado.actualizar(letra, encriptadoLista, separado);
                va.setPalabra(ahorcado.arraylisttostring(actual));
                
                Object[] options = { "SI", "NO" }; //para el panel que aparece al terminar el juego
                if(ahorcado.getVictoria() == 1){
                    String cerrado = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ganado el ahorcado. Recompensa: "+ahorcado.getRecompensa();
                    ControladorPrincipal.registrarAccion(cerrado);
                    
                    va.setSituacion("Has ganado!");
                    int opcion = JOptionPane.showOptionDialog(null,
                    "Has ganado! Recompensa: " + ahorcado.getRecompensa() + "\n ¿Quieres jugar otra partida?",
                    "Victoria",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
                    if(opcion == 0){
                        va.dispose();
                        ControladorCategoria cc = new ControladorCategoria();
                    }
                    else if(opcion == 1){
                        va.getSalir().doClick();
                    }
                }
                else if(ahorcado.getIntentos() == 0){
                    String cerrado = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha perdido el ahorcado";
                    ControladorPrincipal.registrarAccion(cerrado);

                    va.setSituacion("Has perdido...");
                    int opcion = JOptionPane.showOptionDialog(null,
                    "Has perdido... \n ¿Quieres jugar otra partida?",
                    "Derrota",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
                    if(opcion == 0){
                        va.dispose();
                        ControladorCategoria cc = new ControladorCategoria();
                    }
                    else if(opcion == 1){
                        va.getSalir().doClick();
                    }
                }
                
            }
        
        else if (va.getSalir()==e.getSource()){
            String cerrado = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha cerrado el ahorcado";
            ControladorPrincipal.registrarAccion(cerrado);
            va.dispose();
            ControladorBibliotecaCentral cbc = new ControladorBibliotecaCentral();
            }
        
        else if (va.getPista()==e.getSource()){
            
            if(ahorcado.getRecompensa() > 0){
                String cerrado = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha pedido una pista";
                ControladorPrincipal.registrarAccion(cerrado);
                va.setRecompensa(ahorcado.getRecompensa());
                
                ArrayList<String> usadosaux = new ArrayList(Arrays.asList(ahorcado.getUsados().split("")));

                if (!usadosaux.contains(letra)){
                    ahorcado.setRecompensa(250); //cantidad a restar de la recompensa actual
                    String elegido = ahorcado.seleccionarLetra(mayor);
                    va.setSituacion("Letra recomendada: " + elegido);
                }
                else{
                    mayor[ahorcado.posicion(letra)] = 0;
                    String elegido = ahorcado.seleccionarLetra(mayor);
                    va.setSituacion("Letra recomendada: " + elegido);
                }
                
            }
            else {
                va.setSituacion("No puedes pedir más pistas");  
            }         
        }
    }
    
}