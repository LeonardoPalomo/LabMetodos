
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
        Batalla = new javax.swing.JButton();
        CerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menú principal");

        Salir.setText("Salir");

        Batalla.setText("Batalla");

        CerrarSesion.setText("Cerrar sesión");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(162, 162, 162))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CerrarSesion)
                    .addComponent(Batalla)
                    .addComponent(Salir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(Batalla)
                .addGap(18, 18, 18)
                .addComponent(CerrarSesion)
                .addGap(18, 18, 18)
                .addComponent(Salir)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Batalla;
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public JButton getButtonBatalla(){
        return this.Batalla;
    }
    
    public JButton getButtonSalir(){
        return this.Salir;
    }
    
    public JButton getButtonCerrarSesion(){
        return this.CerrarSesion;
    }

    public void agregarListener(ActionListener al){
        this.Batalla.addActionListener(al);
        this.Salir.addActionListener(al);
        this.CerrarSesion.addActionListener(al);
    }
}
