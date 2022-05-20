/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package petcare;

/**
 *
 * @author Julian Lara
 */
public class jPnVariables extends javax.swing.JPanel {

    /**
     * Creates new form jPnVariables
     */
    public jPnVariables() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbTabla = new javax.swing.JComboBox<>();
        lbNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbAnimales = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listVariables = new javax.swing.JList<>();
        btnMod = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        cbAnimal = new javax.swing.JComboBox<>();
        lbRaza = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        lbServicio = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        lbCosto = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(500, 450));
        setPreferredSize(new java.awt.Dimension(500, 450));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione la tabla a editar:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Variables");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 550, 10));

        cbTabla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Servicios", "Animales", "Razas" }));
        cbTabla.setSelectedIndex(-1);
        add(cbTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 135, -1));

        lbNombre.setText("Nombre");
        add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 132, -1));

        lbAnimales.setText("Animales");
        add(lbAnimales, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jScrollPane1.setViewportView(listVariables);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 200, 190));

        btnMod.setText("Modificar");
        add(btnMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        add(cbAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 132, -1));

        lbRaza.setText("Raza");
        add(lbRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        add(txtRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 132, -1));

        lbServicio.setText("Servicio");
        add(lbServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));
        add(txtServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 132, -1));

        lbCosto.setText("Costo");
        add(lbCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 132, -1));

        btnConsulta.setText("Consultar");
        add(btnConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petcare/Img/limpiar.png"))); // NOI18N
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 50, 30));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petcare/Img/bin.png"))); // NOI18N
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnConsulta;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnMod;
    public javax.swing.JComboBox<String> cbAnimal;
    public javax.swing.JComboBox<String> cbTabla;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lbAnimales;
    public javax.swing.JLabel lbCosto;
    public javax.swing.JLabel lbNombre;
    public javax.swing.JLabel lbRaza;
    public javax.swing.JLabel lbServicio;
    public javax.swing.JList<String> listVariables;
    public javax.swing.JTextField txtCosto;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtRaza;
    public javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
