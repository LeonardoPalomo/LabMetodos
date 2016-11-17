package Controlador;

import Modelo.Jugador;
import Modelo.Ahorcado;
import Vista.VistaAhorcado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ControladorAhorcado implements ActionListener{
    
    private VistaAhorcado va;
    private Ahorcado ahorcado;
    private String letra;

    
    public ControladorAhorcado(){
        va = new VistaAhorcado();
        ahorcado = new Ahorcado();
        va.setLocationRelativeTo(null);
        va.setVisible(true);
        va.setListener(this);
        
        String palabra = ahorcado.seleccionarPalabra(ahorcado.getPALABRA());
        System.out.println(palabra);
        String encriptado = ahorcado.arraylisttostring(ahorcado.inicializar(palabra));
        
        va.setPalabra(encriptado);
        va.setErrores(6);
        va.setRecompensa(1000);
        
        

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==va.getButtonAceptar()){
                letra = va.getLetra_elegida();
                System.out.println(letra);
                String caso = ahorcado.verificar(letra);
                va.setSituacion(caso);
                va.setErrores(ahorcado.getIntentos());
                va.setUsadas(ahorcado.getUsados());
                va.setLetra_elegida("");
                
            }
        
        else if (va.getSalir()==e.getSource()){
            String cerrado = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha cerrado el ahorcado";
            ControladorPrincipal.registrarAccion(cerrado);
            ahorcado.setPalabra("");
            va.setVisible(false);
            ControladorBibliotecaCentral cbc = new ControladorBibliotecaCentral();
            }
        
        else if (va.getPista()==e.getSource()){
            String cerrado = "El usuario "+Controlador.ControladorLogin.usuarioActivo+" ha pedido una pista";
            ControladorPrincipal.registrarAccion(cerrado);

            //funcion para reducir recompensa
            }
    }
    
}
