package Controlador;

import Modelo.Conexion;
import Vista.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Jugador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorRegistro implements ActionListener{
    private VistaRegistro vr;
    private ControladorLogin cl;
    private Jugador usuario;
    private Conexion conexion;
    public ControladorRegistro(ControladorLogin cl){
        vr = new VistaRegistro();
        vr.setVisible(true);
        vr.setLocationRelativeTo(null);
        vr.agregarListener(this);
        
        this.cl = cl;
    }

    public void actionPerformed(ActionEvent e) {
        if(vr.getButtonAtras()==e.getSource()){
            vr.dispose();
            cl.setVista(true);
            
        }
        else if (vr.getButtonRegistrarse()==e.getSource()){
            try {
                conexion = new Conexion();
                conexion.conectar();
                if(vr.getPassword().equals(vr.getPassword2())){
                    if(Jugador.obtener(vr.getUsuario())){
                        String intentoRegistro1 = "Intento fallido de registro: el usuario "+vr.getUsuario()+" ya existe.";
                        ControladorPrincipal.registrarAccion(intentoRegistro1);
                        JOptionPane.showMessageDialog(null,intentoRegistro1);
                    }
                    else{
                        usuario = new Jugador(vr.getUsuario(), vr.getPassword(), vr.getSeleccionMalla(), vr.getPjPrincipal(), vr.getSeleccionRolPrincipal(), vr.getPjSecundario(), vr.getSeleccionRolSecundario());
                        usuario.save();
                        String registroExitoso = "El usuario "+vr.getUsuario()+" fue registrado exitosamente.";
                        ControladorPrincipal.registrarAccion(registroExitoso);
                        JOptionPane.showMessageDialog(null,registroExitoso);
                        vr.dispose();
                        cl.setVista(true);
                    }
                }
                else{
                    String intentoRegistro2 = "Intento fallido de registro: las contraseñas no coinciden, intente denuevo.";
                    System.out.println(intentoRegistro2);
                    JOptionPane.showMessageDialog(null,intentoRegistro2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}