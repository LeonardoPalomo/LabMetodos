
package Vista;

import Controlador.ControladorPrincipal;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class VistaPrincipal extends javax.swing.JFrame {

    public VistaPrincipal() {
        initComponents();
        this.setTitle(ControladorPrincipal.titulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        Jugar = new javax.swing.JButton();
        CerrarSesion = new javax.swing.JButton();
        bibliotecaCentral = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Menú principal");

        Salir.setText("Salir");

        Jugar.setText("Jugar");

        CerrarSesion.setText("Cerrar sesión");

        bibliotecaCentral.setText("Biblioteca Central");
        bibliotecaCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bibliotecaCentralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CerrarSesion)
                            .addComponent(Salir))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(bibliotecaCentral)
                        .addGap(71, 71, 71))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jugar)
                    .addComponent(bibliotecaCentral))
                .addGap(18, 18, 18)
                .addComponent(CerrarSesion)
                .addGap(18, 18, 18)
                .addComponent(Salir)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bibliotecaCentralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bibliotecaCentralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bibliotecaCentralActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JButton Jugar;
    private javax.swing.JButton Salir;
    private javax.swing.JButton bibliotecaCentral;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public JButton getButtonJugar(){
        return this.Jugar;
    }
    
    public JButton getButtonBibliotecaCentral(){
        return this.bibliotecaCentral;
    }
    
    public JButton getButtonSalir(){
        return this.Salir;
    }
    
    public JButton getButtonCerrarSesion(){
        return this.CerrarSesion;
    }

    public void agregarListener(ActionListener al){
        this.Jugar.addActionListener(al);
        this.bibliotecaCentral.addActionListener(al);
        this.Salir.addActionListener(al);
        this.CerrarSesion.addActionListener(al);
    }
}
