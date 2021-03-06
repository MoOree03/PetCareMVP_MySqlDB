/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package petcare;

/**
 *
 * @author Julian Lara
 */
public class jPnPropietario extends javax.swing.JPanel {

    /**
     * Creates new form jPnPropietario
     */
    public jPnPropietario() {
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

        txtIniciarSesion = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        txtPropietario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPropietarios = new javax.swing.JList<>();
        btnModificar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(500, 450));
        setPreferredSize(new java.awt.Dimension(500, 450));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIniciarSesion.setText("Registro de Propietarios");
        add(txtIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 18, -1, -1));

        txtUsuario.setText("Usuario:");
        add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPropietarioActionPerformed(evt);
            }
        });
        add(txtPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 179, -1));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setText("Telefono:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 179, -1));

        btnRegistrar.setText("Registrar");
        add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 530, 12));

        jScrollPane1.setViewportView(listPropietarios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 200, 192));

        btnModificar.setText("Modificar");
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        btnConsultar.setText("Consultar");
        add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 90, -1));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petcare/Img/limpiar.png"))); // NOI18N
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 80, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPropietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPropietarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnConsultar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JList<String> listPropietarios;
    private javax.swing.JLabel txtIniciarSesion;
    public javax.swing.JTextField txtPropietario;
    public javax.swing.JTextField txtTelefono;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
