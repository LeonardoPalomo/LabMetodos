package Controlador;

import Modelo.Conexion;
import Modelo.Jugador;
import Vista.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
            if(vr.getUsuario().equals("") || vr.getPassword().equals("") || vr.getPjPrincipal().equals("") || vr.getPjSecundario().equals("")){
                System.out.println("Hay campos sin llenar, no se puede realizar el registro");
                JOptionPane.showMessageDialog(vr,"Debe llenar todos los campos.","ERROR: Campos vacíos",JOptionPane.ERROR_MESSAGE);
            }
            else if(vr.getPjPrincipal().equalsIgnoreCase(vr.getPjSecundario())){
                System.out.println("El nombre del Pj Principal y del Pj Secundario deben ser diferentes");
                JOptionPane.showMessageDialog(vr,"Los nombres de los personajes deben ser diferentes entre sí.","ERROR: Nombres iguales",JOptionPane.ERROR_MESSAGE);
            }
            else if(vr.getUsuario().length() > 12){
                System.out.println("El nombre del usuario es muy largo");
                JOptionPane.showMessageDialog(vr,"El nombre de usuario debe tener hasta 12 caracteres máximo.","ERROR: Exceso de caracteres",JOptionPane.ERROR_MESSAGE);
                vr.clearUsuario();
            }
            else if(vr.getPassword().length() > 12){
                System.out.println("La contraseña es muy larga");
                JOptionPane.showMessageDialog(vr,"La contraseña debe tener hasta 12 caracteres máximo.","ERROR: Exceso de caracteres",JOptionPane.ERROR_MESSAGE);
                vr.clearPassword();
            }
            else if(vr.getPjPrincipal().length() > 12){
                System.out.println("El nombre del personaje principal es muy largo");
                JOptionPane.showMessageDialog(vr,"Los nombres de personajes deben tener hasta 12 caracteres máximo.","ERROR: Exceso de caracteres",JOptionPane.ERROR_MESSAGE);
                vr.clearPjPrincipal();
            }
            else if(vr.getPjSecundario().length() > 12){
                System.out.println("El nombre del personaje secundario es muy largo");
                JOptionPane.showMessageDialog(vr,"Los nombres de personajes deben tener hasta 12 caracteres máximo.","ERROR: Exceso de caracteres",JOptionPane.ERROR_MESSAGE);
                vr.clearPjSecundario();
            }
            else{
                try {
                    conexion = new Conexion();
                    boolean comprobador = conexion.conectar();
                    if(!comprobador){
                        System.out.println("La base de datos no está conectada.");
                        JOptionPane.showMessageDialog(vr,"No se pudo acceder a la base de datos.","ERROR: Base de datos no conectada",JOptionPane.ERROR_MESSAGE);
                    }
                    if(vr.getPassword().equals(vr.getPassword2())){
                        if(Jugador.obtener(vr.getUsuario())){
                            String intentoRegistro1 = "Intento fallido de registro: el usuario "+vr.getUsuario()+" ya existe.";
                            ControladorPrincipal.registrarAccion(intentoRegistro1);
                            JOptionPane.showMessageDialog(null,intentoRegistro1);
                        }
                        else{
                            usuario = new Jugador(vr.getUsuario(), vr.getPassword(), vr.getSeleccionMalla(), vr.getPjPrincipal(), vr.getSeleccionRolPrincipal(), vr.getSeleccionSubrolPrincipal(), vr.getPjSecundario(), vr.getSeleccionRolSecundario(), vr.getSeleccionSubrolSecundario(),0,0,0);
                            usuario.save();
                            String registroExitoso = "El usuario "+vr.getUsuario()+" fue registrado exitosamente.";
                            ControladorPrincipal.registrarAccion(registroExitoso);
                            JOptionPane.showMessageDialog(null,registroExitoso);
                            vr.dispose();
                            cl.setVista(true);
                        }
                    }
                    else{
                        String intentoRegistro2 = "Intento fallido de registro: las contraseñas no coinciden, intente de nuevo.";
                        System.out.println(intentoRegistro2);
                        JOptionPane.showMessageDialog(null,intentoRegistro2);
                    }
                } catch (SQLException ex) {
                    System.out.println("Fallo al tratar de acceder a BDD");
                    Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
    } 
}