
package Vista;

import Controlador.ControladorPrincipal;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VistaBatalla extends javax.swing.JFrame {
    
    private JButton[][] tablero;
    
    public VistaBatalla() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(ControladorPrincipal.titulo);
        construirTablero();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVacio = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAtacar = new javax.swing.JButton();
        btnMover = new javax.swing.JButton();
        btnUsar = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelVacio.setPreferredSize(new java.awt.Dimension(625, 625));

        javax.swing.GroupLayout panelVacioLayout = new javax.swing.GroupLayout(panelVacio);
        panelVacio.setLayout(panelVacioLayout);
        panelVacioLayout.setHorizontalGroup(
            panelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        panelVacioLayout.setVerticalGroup(
            panelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        btnAceptar.setText("Aceptar");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAtacar.setLabel("Atacar");

        btnMover.setLabel("Mover");

        btnUsar.setLabel("Usar");

        btnEnd.setLabel("Finalizar turno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAceptar)
                        .addGap(44, 44, 44)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panelVacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUsar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAtacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelVacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnAtacar)
                        .addGap(28, 28, 28)
                        .addComponent(btnMover)
                        .addGap(32, 32, 32)
                        .addComponent(btnUsar)
                        .addGap(26, 26, 26)
                        .addComponent(btnEnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed
 
   public void setListener(ActionListener a){
       btnAceptar.addActionListener(a);
       btnCancelar.addActionListener(a);
       btnAtacar.addActionListener(a);
       btnMover.addActionListener(a);
       btnUsar.addActionListener(a);
       btnEnd.addActionListener(a);
       for(int i=0;i<25;i++){
            for(int j=0; j<25;j++){
                tablero[i][j].addActionListener(a);
            }
        }
   }
   
   public JButton getbtnAceptar(){
       return btnAceptar;
       
    }
   public JButton getbtnCancelar(){
       return btnCancelar;
   }   
   public JPanel getPanelVacio() {
        return panelVacio;
    }
   public JButton[][] getTablero() {
        return tablero;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAtacar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnMover;
    private javax.swing.JButton btnUsar;
    private javax.swing.JPanel panelVacio;
    // End of variables declaration//GEN-END:variables

    public void construirTablero(){
        tablero = new JButton[25][25];
        this.panelVacio.setLayout(new GridLayout(25,25));
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                tablero[i][j] = new JButton();
                //tablero[i][j].setBorderPainted(true);        
                tablero[i][j].setHorizontalTextPosition(JButton.CENTER);
                tablero[i][j].setVerticalTextPosition(JButton.CENTER);
                panelVacio.add(tablero[i][j]);
            }
        }
        //return tablero;
    }
    
    public void ponerImagenesTerrenoVista(String ruta, int i, int j){
        ImageIcon imagen = new ImageIcon(ruta);
        tablero[i][j].setIcon(imagen);
    }
}
