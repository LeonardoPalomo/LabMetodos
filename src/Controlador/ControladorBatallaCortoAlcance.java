
package Controlador;

import Modelo.Batalla;
import Modelo.Personaje;
import Vista.VistaBatalla;
import Vista.VistaBatallaCorta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorBatallaCortoAlcance implements ActionListener{
    private VistaBatallaCorta vbc;
    private VistaBatalla vb;
    private Batalla b;
    private int i;
    private int j;
    int stockBajo;
    int stockMedio;
    int stockAlto;
    int stockEspecial;
    private ArrayList<Integer> eleccionCpu;
    private int cntTurno;
    private int dañoAtacado;
    private int dañoAtacante;
    public ControladorBatallaCortoAlcance(int cntTurno, int i, int j, Batalla b, VistaBatalla vista){
        this.vb = vista;
        this.b = b;
        vb.setVisible(false);
        vbc = new VistaBatallaCorta();
        vbc.setVisible(true);
        vbc.setLocationRelativeTo(null);
        vbc.aListener(this);
        this.i = i;
        this.j = j;
        this.cntTurno = cntTurno;
        int nivelAtacante = b.getOrdenTurnos()[cntTurno].getNivel();
        int nivelAtacado = b.getTablero(i, j).getPersonaje().getNivel();
        int visibles = b.ataquesVisibles(nivelAtacante, nivelAtacado);
        ArrayList<Integer> eleccionCpu = b.getTablero(i, j).getPersonaje().ataquesCpu();
        this.eleccionCpu = eleccionCpu;
        boolean[] noVisibles = b.noVisibles(visibles);
        vbc.cambiarLabelEleccionCpu(eleccionCpu, noVisibles);
        
        this.stockBajo = b.getOrdenTurnos()[cntTurno].getStock()[0];
        this.stockMedio = b.getOrdenTurnos()[cntTurno].getStock()[1];
        this.stockAlto = b.getOrdenTurnos()[cntTurno].getStock()[2];
        this.stockEspecial = b.getOrdenTurnos()[cntTurno].getStock()[3];
        vbc.cambiarStocks(stockBajo, stockMedio, stockAlto, stockEspecial);
        //Prints para saber cuantos movimientos de la Cpu son visibles y cuales son los visibles y no visibles(Ya funciona)
        /*System.out.println("Visibles: "+ visibles);
        for(int k=0; k<noVisibles.length; k++){
            if(noVisibles[k]){
                System.out.println("Movimiento "+k+" SI es visible");
            }
            else if(!noVisibles[k]){
                System.out.println("Movimiento "+k+" NO es visible");
            }
        }*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean verificador = true;
        int cntB = 0;
        int cntM = 0;
        int cntA = 0;
        int cntE = 0;
        ArrayList<Integer> el = vbc.getEleccionMovimientos();
        for(int k=0; k<el.size(); k++){
            if(el.get(k)==0){
                cntB++;
            }
            else if(el.get(k)==1){
                cntM++;
            }
            else if(el.get(k)==2){
                cntA++;
            }
            else if(el.get(k)==2){
                cntE++;
            }
        }
        if(cntE>stockEspecial || cntB>stockBajo || cntM>stockMedio || cntA>stockAlto){
            verificador = false;
        }
        if(verificador==false){
            JOptionPane.showMessageDialog(vbc,"Has excedido el limite de stock de algun ataque");
        }
        if(verificador == true){
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
                this.dañoAtacante = damages.get(0);
                this.dañoAtacado = damages.get(1);
            

                int hpRestanteAtacado = b.getTablero(i,j).getPersonaje().aplicarDaño(dañoAtacado);
                String dañoRecibidoAtacado = b.getTablero(i,j).getPersonaje().getNombre()+" recibe "+dañoAtacado+" puntos de daño.";
                System.out.println(dañoRecibidoAtacado);
                vb.setTextArea(dañoRecibidoAtacado);
                //----
                int hpRestanteAtacante = b.getOrdenTurnos()[cntTurno].aplicarDaño(dañoAtacante);
                String dañoRecibidoAtacante = b.getOrdenTurnos()[cntTurno].getNombre()+" recibe "+dañoAtacante+" puntos de daño.";
                System.out.println(dañoRecibidoAtacado);
                vb.setTextArea(dañoRecibidoAtacante);
            
                vbc.dispose();
                vb.setVisible(true);
            }    
        }
    }
    public int getDañoAtacado() {
        return dañoAtacado;
    }

    public int getDañoAtacante() {
        return dañoAtacante;
    }
}
