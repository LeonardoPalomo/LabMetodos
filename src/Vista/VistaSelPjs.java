
package Vista;

import Modelo.Personaje;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VistaSelPjs extends javax.swing.JFrame {

    public VistaSelPjs() {
        initComponents();
        this.pjsDisponibles.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  labelNombre.setText(pjsDisponibles.getSelectedValue().toString());
                }
            }
        });
        //add(dataList);
        //add(label);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        listo = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelLvl = new javax.swing.JLabel();
        labelXp = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        labelHp = new javax.swing.JLabel();
        labelMana = new javax.swing.JLabel();
        labelAtkCercaLejos = new javax.swing.JLabel();
        labelSpAtkCercaLejos = new javax.swing.JLabel();
        labelDef = new javax.swing.JLabel();
        labelSpDef = new javax.swing.JLabel();
        labelVelocidad = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pjsSeleccionados = new javax.swing.JList();
        quitar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pjsDisponibles = new javax.swing.JList();
        agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(502, 452));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Seleccione sus personajes (máximo 5)");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(185, 345));

        listo.setText("¡Listo!");
        listo.setMaximumSize(new java.awt.Dimension(85, 23));
        listo.setMinimumSize(new java.awt.Dimension(85, 23));
        listo.setPreferredSize(new java.awt.Dimension(85, 23));

        volver.setText("Volver");
        volver.setMaximumSize(new java.awt.Dimension(85, 23));
        volver.setMinimumSize(new java.awt.Dimension(85, 23));
        volver.setPreferredSize(new java.awt.Dimension(85, 23));

        jLabel2.setText("Nombre");

        jLabel3.setText("Tipo");

        jLabel4.setText("Rol");

        jLabel5.setText("Puntos de Vida");

        jLabel6.setText("Puntos de Magia");

        jLabel7.setText("Ataque (Cerca/Lejos)");

        jLabel8.setText("Defensa");

        jLabel9.setText("Velocidad");

        jLabel10.setText("Atk Mágico (Cerca/Lejos)");

        jLabel11.setText("Def Mágica");

        jLabel12.setText("Nivel");

        jLabel13.setText("Experiencia");

        labelNombre.setFocusable(false);
        labelNombre.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelLvl.setFocusable(false);
        labelLvl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelXp.setFocusable(false);
        labelXp.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelTipo.setFocusable(false);
        labelTipo.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelRol.setFocusable(false);
        labelRol.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelHp.setFocusable(false);
        labelHp.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelMana.setFocusable(false);
        labelMana.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelAtkCercaLejos.setFocusable(false);
        labelAtkCercaLejos.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelSpAtkCercaLejos.setFocusable(false);
        labelSpAtkCercaLejos.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelDef.setFocusable(false);
        labelDef.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelSpDef.setFocusable(false);
        labelSpDef.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelVelocidad.setFocusable(false);
        labelVelocidad.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLvl)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelXp)
                    .addComponent(labelTipo)
                    .addComponent(labelRol)
                    .addComponent(labelHp)
                    .addComponent(labelMana)
                    .addComponent(labelAtkCercaLejos)
                    .addComponent(labelSpAtkCercaLejos)
                    .addComponent(labelDef)
                    .addComponent(labelSpDef)
                    .addComponent(labelVelocidad))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(listo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelAtkCercaLejos, labelDef, labelHp, labelLvl, labelMana, labelNombre, labelRol, labelSpAtkCercaLejos, labelSpDef, labelTipo, labelVelocidad, labelXp});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLvl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelXp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelHp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAtkCercaLejos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSpAtkCercaLejos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSpDef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(labelVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pjsSeleccionados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pjsSeleccionados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " ", " ", " ", " ", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        pjsSeleccionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        pjsSeleccionados.setMaximumSize(new java.awt.Dimension(260, 100));
        pjsSeleccionados.setMinimumSize(new java.awt.Dimension(260, 100));
        pjsSeleccionados.setPreferredSize(new java.awt.Dimension(260, 100));
        jScrollPane2.setViewportView(pjsSeleccionados);

        quitar.setText("Quitar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(quitar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quitar)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(260, 121));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(260, 121));

        pjsDisponibles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pjsDisponibles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        pjsDisponibles.setPreferredSize(new java.awt.Dimension(260, 0));
        jScrollPane1.setViewportView(pjsDisponibles);

        agregar.setText("Agregar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(agregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(agregar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAtkCercaLejos;
    private javax.swing.JLabel labelDef;
    private javax.swing.JLabel labelHp;
    private javax.swing.JLabel labelLvl;
    private javax.swing.JLabel labelMana;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelSpAtkCercaLejos;
    private javax.swing.JLabel labelSpDef;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelVelocidad;
    private javax.swing.JLabel labelXp;
    private javax.swing.JButton listo;
    private javax.swing.JList pjsDisponibles;
    private javax.swing.JList pjsSeleccionados;
    private javax.swing.JButton quitar;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
    
    public JButton getAgregar() {
        return agregar;
    }

    public JButton getListo() {
        return listo;
    }
    
    public JList getListaPjsDisponibles(){
        return this.pjsDisponibles;
    }
    
    public JList getListaPjsSeleccionados(){
        return this.pjsSeleccionados;
    }

    /*
    public String getPjsDisponibles() {
        String seleccionado = pjsDisponibles.getSelectedValue().toString();
        return seleccionado;
    }

    public Personaje[] getPjsSeleccionados() {
        Personaje[] pjsSel;
        ListModel listaPjsSel = this.pjsSeleccionados.getModel();
        int largoListaPjsSel;
        largoListaPjsSel = listaPjsSel.getSize();
        pjsSel = new Personaje[largoListaPjsSel];
        for(int i=0; i<largoListaPjsSel; i++){
            pjsSel[i] = (Personaje)listaPjsSel.getElementAt(i);
        }
        return pjsSel;
    }
    */

    public JButton getQuitar() {
        return quitar;
    }

    public JButton getVolver() {
        return volver;
    }

    public void setLabelAtkCercaLejos(String atkCercaLejos) {
        this.labelAtkCercaLejos.setText(atkCercaLejos);
    }

    public void setLabelDef(String def) {
        this.labelDef.setText(def);
    }

    public void setLabelHp(String hp) {
        this.labelHp.setText(hp);
    }

    public void setLabelLvl(String lvl) {
        this.labelLvl.setText(lvl);
    }

    public void setLabelMana(String mana) {
        this.labelMana.setText(mana);
    }

    public void setLabelNombre(String nombre) {
        this.labelNombre.setText(nombre);
    }

    public void setLabelRol(String rol) {
        this.labelRol.setText(rol);
    }

    public void setLabelSpAtkCercaLejos(String spAtkCercaLejos) {
        this.labelSpAtkCercaLejos.setText(spAtkCercaLejos);
    }

    public void setLabelSpDef(String spDef) {
        this.labelSpDef.setText(spDef);
    }

    public void setLabelTipo(String tipo) {
        this.labelTipo.setText(tipo);
    }

    public void setLabelVelocidad(String velocidad) {
        this.labelVelocidad.setText(velocidad);
    }

    public void setLabelXp(String xp) {
        this.labelXp.setText(xp);
    }

    
    public void setPjsDisponibles(ArrayList<Personaje> pjsDispon) {
         DefaultListModel listModel = new DefaultListModel();
         for(Personaje pj:pjsDispon){
             listModel.addElement(pj.getNombre());
         }
         this.pjsDisponibles.setModel(listModel);
    }

    public void setPjsSeleccionados(ArrayList<Personaje> pjsSelec) {
        DefaultListModel listModel = new DefaultListModel();
        for(Personaje pj:pjsSelec){
            listModel.addElement(pj.getNombre());
        }
        this.pjsSeleccionados.setModel(listModel);
    }
    
    public void agregarPjsASeleccion(ArrayList<Personaje> pjsSelec){
        DefaultListModel listModel = new DefaultListModel();
        for(Personaje pj:pjsSelec){
            listModel.addElement(pj.getNombre());
        }
        this.pjsSeleccionados.setModel(listModel);
    }

    public void agregarListener(ActionListener a){
        this.agregar.addActionListener(a);
        this.listo.addActionListener(a);
        this.quitar.addActionListener(a);
        this.volver.addActionListener(a);
    }

}
