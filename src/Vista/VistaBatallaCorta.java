
package Vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class VistaBatallaCorta extends javax.swing.JFrame {
    Random rnd;

    public VistaBatallaCorta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        eCpu6 = new javax.swing.JLabel();
        eCpu7 = new javax.swing.JLabel();
        eCpu3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        eCpu4 = new javax.swing.JLabel();
        eCpu2 = new javax.swing.JLabel();
        eCpu1 = new javax.swing.JLabel();
        eCpu5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        eleccion3 = new javax.swing.JComboBox<>();
        eleccion4 = new javax.swing.JComboBox<>();
        eleccion7 = new javax.swing.JComboBox<>();
        eleccion5 = new javax.swing.JComboBox<>();
        eleccion6 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        eleccion1 = new javax.swing.JComboBox<>();
        eleccion2 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        stockB = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        stockA = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        stockM = new javax.swing.JLabel();
        stockE = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        labelImgCpu = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelHpCpu = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelImgPj = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelHpPj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAceptar.setText("aceptar");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        eCpu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eCpu6.setText("X");

        eCpu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eCpu7.setText("X");

        eCpu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eCpu3.setText("M");

        jLabel1.setText("Oponente:");

        eCpu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eCpu4.setText("B");

        eCpu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eCpu2.setText("B");

        eCpu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eCpu1.setText("A");

        eCpu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eCpu5.setText("A");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eCpu1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eCpu2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eCpu3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eCpu4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eCpu5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eCpu6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eCpu7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eCpu1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCpu2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCpu3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCpu4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCpu5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCpu6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCpu7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        eleccion3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "M", "B", "E" }));

        eleccion4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "M", "B", "E" }));

        eleccion7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "M", "B", "E" }));

        eleccion5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "M", "B", "E" }));

        eleccion6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "M", "B", "E" }));

        jLabel2.setText("Jugador:");

        eleccion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "M", "B", "E" }));

        eleccion2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "M", "B", "E" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(eleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eleccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eleccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eleccion4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eleccion5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eleccion6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eleccion7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(eleccion7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eleccion6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eleccion5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eleccion4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eleccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eleccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        stockB.setText("x2");

        jLabel3.setText("Stock:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("A");

        stockA.setText("x4");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("M");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("B");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("E");

        stockM.setText("x3");

        stockE.setText("x1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(stockA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(stockE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(stockM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(stockB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(stockB)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockM)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelImgCpu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelImgCpu.setPreferredSize(new java.awt.Dimension(25, 25));

        jLabel11.setText("HP:");

        labelHpCpu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHpCpu.setText("100/100");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelImgCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelHpCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelImgCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHpCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(189, 89));

        labelImgPj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelImgPj.setPreferredSize(new java.awt.Dimension(25, 25));

        jLabel5.setText("HP:");

        labelHpPj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHpPj.setText("100/100");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelHpPj, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelImgPj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(labelHpPj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(labelImgPj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAceptar)
                                .addGap(173, 173, 173))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnAceptar)))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JComboBox<String> getEleccion1() {
        return eleccion1;
    }

    public JComboBox<String> getEleccion2() {
        return eleccion2;
    }

    public JComboBox<String> getEleccion3() {
        return eleccion3;
    }

    public JComboBox<String> getEleccion4() {
        return eleccion4;
    }

    public JComboBox<String> getEleccion5() {
        return eleccion5;
    }

    public JComboBox<String> getEleccion6() {
        return eleccion6;
    }

    /**
     * @param args the command line arguments
     */
    public JComboBox<String> getEleccion7() {
        return eleccion7;
    }

    public JLabel geteCpu1() {
        return eCpu1;
    }

    public void seteCpu1(JLabel eCpu1) {
        this.eCpu1 = eCpu1;
    }

    public JLabel geteCpu2() {
        return eCpu2;
    }

    public void seteCpu2(JLabel eCpu2) {
        this.eCpu2 = eCpu2;
    }

    public JLabel geteCpu3() {
        return eCpu3;
    }

    public void seteCpu3(JLabel eCpu3) {
        this.eCpu3 = eCpu3;
    }

    public JLabel geteCpu4() {
        return eCpu4;
    }

    public void seteCpu4(JLabel eCpu4) {
        this.eCpu4 = eCpu4;
    }

    public JLabel geteCpu5() {
        return eCpu5;
    }

    public void seteCpu5(JLabel eCpu5) {
        this.eCpu5 = eCpu5;
    }

    public JLabel geteCpu6() {
        return eCpu6;
    }

    public void seteCpu6(JLabel eCpu6) {
        this.eCpu6 = eCpu6;
    }

    public JLabel geteCpu7() {
        return eCpu7;
    }

    public void seteCpu7(JLabel eCpu7) {
        this.eCpu7 = eCpu7;
    }

    public JLabel getStockA() {
        return stockA;
    }

    public void setStockA(JLabel stockA) {
        this.stockA = stockA;
    }

    public JLabel getStockB() {
        return stockB;
    }

    public void setStockB(JLabel stockB) {
        this.stockB = stockB;
    }

    public JLabel getStockE() {
        return stockE;
    }

    public void setStockE(JLabel stockE) {
        this.stockE = stockE;
    }

    public JLabel getStockM() {
        return stockM;
    }

    public void setStockM(JLabel stockM) {
        this.stockM = stockM;
    }
    
    public void setHpPj(int hpActual, int hpTotal){
        this.labelHpPj.setText(hpActual+"/"+hpTotal);
    }
    public void setHpCpu(int hpActual, int hpTotal){
        this.labelHpCpu.setText(hpActual+"/"+hpTotal);
    }
    
    public void setImgPj(String ruta){
        this.labelImgPj.setIcon(new ImageIcon(ruta));
    }
    public void setImgCpu(String ruta){
        this.labelImgCpu.setIcon(new ImageIcon(ruta));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel eCpu1;
    private javax.swing.JLabel eCpu2;
    private javax.swing.JLabel eCpu3;
    private javax.swing.JLabel eCpu4;
    private javax.swing.JLabel eCpu5;
    private javax.swing.JLabel eCpu6;
    private javax.swing.JLabel eCpu7;
    private javax.swing.JComboBox<String> eleccion1;
    private javax.swing.JComboBox<String> eleccion2;
    private javax.swing.JComboBox<String> eleccion3;
    private javax.swing.JComboBox<String> eleccion4;
    private javax.swing.JComboBox<String> eleccion5;
    private javax.swing.JComboBox<String> eleccion6;
    private javax.swing.JComboBox<String> eleccion7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelHpCpu;
    private javax.swing.JLabel labelHpPj;
    private javax.swing.JLabel labelImgCpu;
    private javax.swing.JLabel labelImgPj;
    private javax.swing.JLabel stockA;
    private javax.swing.JLabel stockB;
    private javax.swing.JLabel stockE;
    private javax.swing.JLabel stockM;
    // End of variables declaration//GEN-END:variables

    public void cambiarLabelEleccionCpu(ArrayList<Integer> elecciones, boolean[] noVisibles){
        for(int eleccion=0; eleccion<elecciones.size(); eleccion++){
            if(eleccion==0){//Si es la primera eleccion
                if(elecciones.get(eleccion)==0){
                    eCpu1.setText("B");
                }
                else if(elecciones.get(eleccion)==1){
                    eCpu1.setText("M");
                }
                else if(elecciones.get(eleccion)==2){
                    eCpu1.setText("A");
                }
                else if(elecciones.get(eleccion)==3){
                    eCpu1.setText("E");
                }
            }
            else if(eleccion==1){//Si es la segunda eleccion
                if(elecciones.get(eleccion)==0){
                    eCpu2.setText("B");
                }
                else if(elecciones.get(eleccion)==1){
                    eCpu2.setText("M");
                }
                else if(elecciones.get(eleccion)==2){
                    eCpu2.setText("A");
                }
                else if(elecciones.get(eleccion)==3){
                    eCpu2.setText("E");
                }
            }
            else if(eleccion==2){//Si es la tercera eleccion
                if(elecciones.get(eleccion)==0){
                    eCpu3.setText("B");
                }
                else if(elecciones.get(eleccion)==1){
                    eCpu3.setText("M");
                }
                else if(elecciones.get(eleccion)==2){
                    eCpu3.setText("A");
                }
                else if(elecciones.get(eleccion)==3){
                    eCpu3.setText("E");
                }
            }
            else if(eleccion==3){//Si es la cuarta eleccion
                if(elecciones.get(eleccion)==0){
                    eCpu4.setText("B");
                }
                else if(elecciones.get(eleccion)==1){
                    eCpu4.setText("M");
                }
                else if(elecciones.get(eleccion)==2){
                    eCpu4.setText("A");
                }
                else if(elecciones.get(eleccion)==3){
                    eCpu4.setText("E");
                }
            }
            else if(eleccion==4){//Si es la quinta eleccion
                if(elecciones.get(eleccion)==0){
                    eCpu5.setText("B");
                }
                else if(elecciones.get(eleccion)==1){
                    eCpu5.setText("M");
                }
                else if(elecciones.get(eleccion)==2){
                    eCpu5.setText("A");
                }
                else if(elecciones.get(eleccion)==3){
                    eCpu5.setText("E");
                }
            }
            else if(eleccion==5){//Si es la sexta eleccion
                if(elecciones.get(eleccion)==0){
                    eCpu6.setText("B");
                }
                else if(elecciones.get(eleccion)==1){
                    eCpu6.setText("M");
                }
                else if(elecciones.get(eleccion)==2){
                    eCpu6.setText("A");
                }
                else if(elecciones.get(eleccion)==3){
                    eCpu6.setText("E");
                }
            }
            else if(eleccion==6){//Si es la septima eleccion
                if(elecciones.get(eleccion)==0){
                    eCpu7.setText("B");
                }
                else if(elecciones.get(eleccion)==1){
                    eCpu7.setText("M");
                }
                else if(elecciones.get(eleccion)==2){
                    eCpu7.setText("A");
                }
                else if(elecciones.get(eleccion)==3){
                    eCpu7.setText("E");
                }
            }
        }
        
        if(noVisibles[0]==false){
            eCpu1.setText("X");
        }
        if(noVisibles[1]==false){
            eCpu2.setText("X");
        }
        if(noVisibles[2]==false){
            eCpu3.setText("X");
        }
        if(noVisibles[3]==false){
            eCpu4.setText("X");
        }
        if(noVisibles[4]==false){
            eCpu5.setText("X");
        }
        if(noVisibles[5]==false){
            eCpu6.setText("X");
        }
        if(noVisibles[6]==false){
            eCpu7.setText("X");
        }
        
        /*int noVisibles = 7-visibles;
        ArrayList<Integer> noMostradas = new ArrayList();
        rnd = new Random();
        for(int k=0; k<noVisibles; k++){
            boolean verificador = true;
            int i;
            do{
                i = (int)(rnd.nextDouble()*7 + 0);
                if(!noMostradas.contains(i)){
                    noMostradas.add(i);
                    verificador = false;
                }    
            }
            while(verificador = true);
            if(i==0){
                eCpu1.setText("X");
            }
            else if(i==1){
                eCpu2.setText("X");
            }
            else if(i==2){
                eCpu3.setText("X");
            }
            else if(i==3){
                eCpu4.setText("X");
            }
            else if(i==4){
                eCpu5.setText("X");
            }
            else if(i==5){
                eCpu6.setText("X");
            }
            else if(i==6){
                eCpu7.setText("X");
            }
        }*/
    }
    public ArrayList<Integer> getEleccionMovimientos(){//Bajo=0, Medio=1, Alto=2; Especial=3
        ArrayList<Integer> movimientos = new ArrayList();
        if(eleccion1.getSelectedItem().toString()== "B"){
            movimientos.add(0);
        }
        else if(eleccion1.getSelectedItem().toString()== "M"){
            movimientos.add(1);
        }
        else if(eleccion1.getSelectedItem().toString()== "A"){
            movimientos.add(2);
        }
        else if(eleccion1.getSelectedItem().toString()== "E"){
            movimientos.add(3);
        }
        if(eleccion2.getSelectedItem().toString()== "B"){
            movimientos.add(0);
        }
        else if(eleccion2.getSelectedItem().toString()== "M"){
            movimientos.add(1);
        }
        else if(eleccion2.getSelectedItem().toString()== "A"){
            movimientos.add(2);
        }
        else if(eleccion2.getSelectedItem().toString()== "E"){
            movimientos.add(3);
        }
        if(eleccion3.getSelectedItem().toString()== "B"){
            movimientos.add(0);
        }
        else if(eleccion3.getSelectedItem().toString()== "M"){
            movimientos.add(1);
        }
        else if(eleccion3.getSelectedItem().toString()== "A"){
            movimientos.add(2);
        }
        else if(eleccion3.getSelectedItem().toString()== "E"){
            movimientos.add(3);
        }
        if(eleccion4.getSelectedItem().toString()== "B"){
            movimientos.add(0);
        }
        else if(eleccion4.getSelectedItem().toString()== "M"){
            movimientos.add(1);
        }
        else if(eleccion4.getSelectedItem().toString()== "A"){
            movimientos.add(2);
        }
        else if(eleccion4.getSelectedItem().toString()== "E"){
            movimientos.add(3);
        }
        if(eleccion5.getSelectedItem().toString()== "B"){
            movimientos.add(0);
        }
        else if(eleccion5.getSelectedItem().toString()== "M"){
            movimientos.add(1);
        }
        else if(eleccion5.getSelectedItem().toString()== "A"){
            movimientos.add(2);
        }
        else if(eleccion5.getSelectedItem().toString()== "E"){
            movimientos.add(3);
        }
        if(eleccion6.getSelectedItem().toString()== "B"){
            movimientos.add(0);
        }
        else if(eleccion6.getSelectedItem().toString()== "M"){
            movimientos.add(1);
        }
        else if(eleccion6.getSelectedItem().toString()== "A"){
            movimientos.add(2);
        }
        else if(eleccion6.getSelectedItem().toString()== "E"){
            movimientos.add(3);
        }
        if(eleccion7.getSelectedItem().toString()== "B"){
            movimientos.add(0);
        }
        else if(eleccion7.getSelectedItem().toString()== "M"){
            movimientos.add(1);
        }
        else if(eleccion7.getSelectedItem().toString()== "A"){
            movimientos.add(2);
        }
        else if(eleccion7.getSelectedItem().toString()== "E"){
            movimientos.add(3);
        }
        return movimientos;
    }
    public void cambiarStocks(int bajo, int medio, int alto, int especial){
        stockB.setText("x"+bajo);
        stockM.setText("x"+medio);
        stockA.setText("x"+alto);
        stockE.setText("x"+especial);
    }
    public void aListener(ActionListener a){
        btnAceptar.addActionListener(a);
    }
}
