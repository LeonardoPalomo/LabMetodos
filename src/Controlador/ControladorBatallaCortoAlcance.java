/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Batalla;
import Modelo.Personaje;
import Vista.VistaBatallaCorta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorBatallaCortoAlcance implements ActionListener{
    private VistaBatallaCorta vbc;
    private Batalla b;
    private int i;
    private int j;
    private ArrayList<Integer> eleccionCpu;
    private int cntTurno; 
    
    public ControladorBatallaCortoAlcance(int cntTurno, int i, int j){
        vbc = new VistaBatallaCorta();
        vbc.setVisible(true);
        vbc.aListener(this);
        this.i = i;
        this.j = j;
        this.cntTurno = cntTurno;
        int nivelAtacante = b.getOrdenTurnos()[cntTurno].getNivel();
        int nivelAtacado = b.getTablero(i, j).getPersonaje().getNivel();
        int visibles = b.ataquesVisibles(nivelAtacante, nivelAtacado);
        ArrayList<Integer> eleccionCpu = b.getTablero(i, j).getPersonaje().ataquesCpu();
        this.eleccionCpu = eleccionCpu;
        vbc.cambiarLabelEleccionCpu(eleccionCpu, visibles);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vbc.getBtnAceptar()==e.getSource()){
            ArrayList<Integer> eleccionUsuario = vbc.getEleccionMovimientos();
            int victorias = 0;
            int derrotas = 0;
            for(int k=0; k<eleccionUsuario.size(); k++){
                int resultado = b.dueloTriangular(eleccionUsuario.get(k), eleccionCpu.get(k));
                if(resultado == 1){
                    victorias++;
                }
                else if(resultado == 2){
                    derrotas++;
                }
            }
            ArrayList<Integer> damages = b.getOrdenTurnos()[cntTurno].atacarCerca(b.getTablero(i,j).getPersonaje(), victorias, derrotas);
        }
    }
}
