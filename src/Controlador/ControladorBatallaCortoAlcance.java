
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
    private ControladorBatalla cb;
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
    public ControladorBatallaCortoAlcance(int cntTurno, int i, int j, Batalla b, VistaBatalla vista, ControladorBatalla cb){
        this.vb = vista;
        this.b = b;
        this.cb = cb;
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
        vbc.setHpPj(b.getOrdenTurnos()[cntTurno].getHpActual(),b.getOrdenTurnos()[cntTurno].getHpTotal());
        vbc.setHpCpu(b.getTablero(i, j).getPersonaje().getHpActual(),b.getTablero(i, j).getPersonaje().getHpTotal());
        vbc.setImgPj(b.ponerRutaPjSinFondo(b.getOrdenTurnos()[cntTurno]));
        vbc.setImgCpu(b.ponerRutaPjSinFondo(b.getTablero(i, j).getPersonaje()));
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
        int mePasePo=4;//Valor que no representa nada
        ArrayList<Integer> el = vbc.getEleccionMovimientos();
        for(int k=0; k<el.size(); k++){
            System.out.println("Movimiento "+k+" = "+el.get(k));
            System.out.println("--------");
            if(el.get(k)==0){
                cntB++;
            }
            else if(el.get(k)==1){
                cntM++;
            }
            else if(el.get(k)==2){
                cntA++;
            }
            else if(el.get(k)==3){
                cntE++;
            }
        }
        if(cntE>stockEspecial){
            verificador = false;
            mePasePo = 3;
        }
        else if(cntB>stockBajo){
            verificador = false;
            mePasePo = 0;
        }
        else if(cntM>stockMedio){
            verificador = false;
            mePasePo = 1;
        }
        else if(cntA>stockAlto){
            verificador = false;
            mePasePo = 2;
        }
        
        if(verificador==false){
            if(mePasePo==0){
                JOptionPane.showMessageDialog(vbc,"Has excedido el limite de stock de ataque Bajo");
            }
            else if(mePasePo==1){
                JOptionPane.showMessageDialog(vbc,"Has excedido el limite de stock de ataque Medio");
            }
            else if(mePasePo==2){
                JOptionPane.showMessageDialog(vbc,"Has excedido el limite de stock de ataque Alto");
            }
            else if(mePasePo==3){
                JOptionPane.showMessageDialog(vbc,"Has excedido el limite de stock de ataque Especial");
            }
            //JOptionPane.showMessageDialog(vbc,"Has excedido el limite de stock de ataque ");
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
                this.cb.comprobarPartida();
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
