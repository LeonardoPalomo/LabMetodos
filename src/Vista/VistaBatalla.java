
package Vista;

import Controlador.ControladorPrincipal;
import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelPosicion = new javax.swing.JLabel();
        labelTerreno = new javax.swing.JLabel();
        labelAltura = new javax.swing.JLabel();
        labelPersonaje = new javax.swing.JLabel();
        labelDueño = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelLvl = new javax.swing.JLabel();
        labelHp = new javax.swing.JLabel();
        labelMana = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelMov = new javax.swing.JLabel();
        btnSurrender = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelVacio.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        panelVacio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelVacio.setPreferredSize(new java.awt.Dimension(625, 625));

        javax.swing.GroupLayout panelVacioLayout = new javax.swing.GroupLayout(panelVacio);
        panelVacio.setLayout(panelVacioLayout);
        panelVacioLayout.setHorizontalGroup(
            panelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );
        panelVacioLayout.setVerticalGroup(
            panelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMinimumSize(new java.awt.Dimension(134, 199));

        jLabel1.setText("Posición");

        jLabel2.setText("Terreno");

        jLabel3.setText("Altura");

        jLabel7.setText("Personaje");

        jLabel8.setText("Dueño");

        jLabel9.setText("Tipo");

        jLabel10.setText("Rol");

        jLabel4.setText("Nivel");

        jLabel5.setText("Puntos de Vida");

        jLabel6.setText("Puntos de Magia");

        jLabel11.setText("Puntos de Movimiento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTerreno, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelMov, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelAltura, labelDueño, labelLvl, labelPersonaje, labelPosicion, labelRol, labelTerreno, labelTipo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelHp, labelMana});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPosicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(labelTerreno, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAltura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDueño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(labelLvl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(labelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10))
                    .addComponent(labelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelHp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(labelMana, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelAltura, labelDueño, labelLvl, labelPersonaje, labelPosicion, labelRol, labelTerreno, labelTipo});

        btnSurrender.setText("Rendirse");
        btnSurrender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurrenderActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        areaInfo.setEditable(false);
        areaInfo.setColumns(20);
        areaInfo.setRows(5);
        jScrollPane1.setViewportView(areaInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(panelVacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMover, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUsar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAtacar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnSurrender))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAtacar, btnCancelar, btnEnd});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnMover, btnUsar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAtacar)
                            .addComponent(btnMover))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUsar)
                            .addComponent(btnEnd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(btnCancelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSurrender)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addComponent(panelVacio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel3});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSurrenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurrenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSurrenderActionPerformed
 
   public void setListener(ActionListener a){
       btnAceptar.addActionListener(a);
       btnCancelar.addActionListener(a);
       btnAtacar.addActionListener(a);
       btnMover.addActionListener(a);
       btnUsar.addActionListener(a);
       btnEnd.addActionListener(a);
       btnSurrender.addActionListener(a);
       for(int i=0;i<25;i++){
            for(int j=0; j<25;j++){
                tablero[i][j].addActionListener(a);
            }
        }
   }
   public void setMouseListener(MouseListener m){
       for(int i=0;i<25;i++){
            for(int j=0; j<25;j++){
                tablero[i][j].addMouseListener(m);
            }
        }
   }

    public JButton getBtnAtacar() {
        return btnAtacar;
    }
    public JButton getBtnEnd() {
        return btnEnd;
    }
    public JButton getBtnMover() {
        return btnMover;
    }
    public JButton getBtnSurrender() {
        return btnSurrender;
    }
    public JButton getBtnUsar() {
        return btnUsar;
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
    
    public void setTextArea(String texto){
        this.areaInfo.append(texto+"\n");
    }

    public void setLabelPosicion(int i, int j){
        String posicionStr = "["+String.valueOf(i)+","+String.valueOf(j)+"]";
        this.labelPosicion.setText(posicionStr);
    }
    public void setLabelAltura(int altura){
        String alturaStr = String.valueOf(altura);
        this.labelAltura.setText(alturaStr);
    }
    public void setLabelTerreno(String terreno){
        this.labelTerreno.setText(terreno);
    }
    public void setLabelPersonaje(String nombre){
        this.labelPersonaje.setText(nombre);
    }
    public void setLabelDueño(String dueño) {
        this.labelDueño.setText(dueño);
    }
    public void setLabelRol(String rol) {
        this.labelRol.setText(rol);
    }
    public void setLabelTipo(String tipo) {
        this.labelTipo.setText(tipo);
    }
    public void setLabelLvl(int lvl){
        String lvlStr = String.valueOf(lvl);
        this.labelLvl.setText(lvlStr);
    }
    public void setLabelHp(int hpActual, int hpTotal){
        String hpActualStr = String.valueOf(hpActual);
        String hpTotalStr = String.valueOf(hpTotal);
        this.labelHp.setText(hpActualStr+"/"+hpTotalStr);
    }
    public void setLabelMana(int manaActual, int manaTotal){
        String manaActualStr = String.valueOf(manaActual);
        String manaTotalStr = String.valueOf(manaTotal);
        this.labelMana.setText(manaActualStr+"/"+manaTotalStr);
    }
    public void setLabelMov(int movActual, int movTotal){
        String movActualStr = String.valueOf(movActual);
        String movTotalStr = String.valueOf(movTotal);
        this.labelMov.setText(movActualStr+"/"+movTotalStr);
    }

    //Sobrecarga
    public void setLabelPosicion(){
        this.labelPosicion.setText("");
    }
    public void setLabelAltura(){
        this.labelAltura.setText("");
    }
    public void setLabelTerreno(){
        this.labelTerreno.setText("");
    }
    public void setLabelPersonaje(){
        this.labelPersonaje.setText("");
    }
    public void setLabelDueño() {
        this.labelDueño.setText("");
    }
    public void setLabelRol() {
        this.labelRol.setText("");
    }
    public void setLabelTipo() {
        this.labelTipo.setText("");
    }
    public void setLabelLvl(){
        this.labelLvl.setText("");
    }
    public void setLabelHp(){
        this.labelHp.setText("");
    }
    public void setLabelMana(){
        this.labelMana.setText("");
    }
    public void setLabelMov(){
        this.labelMov.setText("");
    }

    public void disableButtons(){
        this.btnAtacar.setEnabled(false);
        this.btnMover.setEnabled(false);
        this.btnEnd.setEnabled(false);
        this.btnUsar.setEnabled(false);
    }
    public void enableButtons(){
        this.btnAtacar.setEnabled(true);
        this.btnMover.setEnabled(true);
        this.btnEnd.setEnabled(true);
        this.btnUsar.setEnabled(true);
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaInfo;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAtacar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnMover;
    private javax.swing.JButton btnSurrender;
    private javax.swing.JButton btnUsar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAltura;
    private javax.swing.JLabel labelDueño;
    private javax.swing.JLabel labelHp;
    private javax.swing.JLabel labelLvl;
    private javax.swing.JLabel labelMana;
    private javax.swing.JLabel labelMov;
    private javax.swing.JLabel labelPersonaje;
    private javax.swing.JLabel labelPosicion;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelTerreno;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JPanel panelVacio;
    // End of variables declaration//GEN-END:variables

    public void construirTablero(){
        tablero = new JButton[25][25];
        this.panelVacio.setLayout(new GridLayout(25,25));
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                tablero[i][j] = new JButton();  
                tablero[i][j].setHorizontalTextPosition(JButton.CENTER);
                tablero[i][j].setVerticalTextPosition(JButton.CENTER);
                panelVacio.add(tablero[i][j]);
            }
        }
    }
    
    public void ponerImagenTablero(String ruta, int i, int j){
        ImageIcon imagen = new ImageIcon(ruta);
        tablero[i][j].setIcon(imagen);
    }
    
    public void marcarZona(int sup, int izq, int inf, int der,Color color){
        Border borde = new LineBorder(color,2);
        for(int i=sup; i<=inf; i++){
            for(int j=izq; j<=der; j++){
                tablero[i][j].setBorder(borde);
                tablero[i][j].setEnabled(true);
            }
        }
    }
    public void marcarCasilla(int i, int j, boolean esCpu){
        Border borde;
        if(esCpu){
            borde = new LineBorder(RED,2);
        }
        else{
            borde = new LineBorder(BLUE,2);
        }
        tablero[i][j].setBorder(borde);
    }
    //Sobrecarga
    public void marcarCasilla(int[] pos, boolean esCpu){
        Border borde;
        if(esCpu){
            borde = new LineBorder(RED,2);
        }
        else{
            borde = new LineBorder(BLUE,2);
        }
        tablero[pos[0]][pos[1]].setBorder(borde);
    }
    public void desmarcarZona(int sup, int izq, int inf, int der){
        for(int i=sup; i<=inf; i++){
            for(int j=izq; j<=der; j++){
                tablero[i][j].setBorder(UIManager.getBorder("Button.border"));
            }
        }
    }
    public void desmarcarCasilla(int i, int j){
        tablero[i][j].setBorder(UIManager.getBorder("Button.border"));
    }
    //Sobrecarga
    public void desmarcarCasilla(int[] pos){
        tablero[pos[0]][pos[1]].setBorder(UIManager.getBorder("Button.border"));
    }
    public void eliminarBordesEscenario(){
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                tablero[i][j].setBorder(null);
            }
        }
    }
    public void eliminarBordesCasilla(int i, int j){
        tablero[i][j].setBorder(null);
    }
    //Sobrecarga
    public void eliminarBordesCasilla(int[] pos){
        tablero[pos[0]][pos[1]].setBorder(null);
    }
}
