package vista;

import vista.*;
import controlador.ControladorCRUDEstudiantes;
import controlador.ControladorCRUDEstudiantes;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class FrmEditarEstudiante extends javax.swing.JFrame {

    ControladorCRUDEstudiantes objControladorCRUDEst;

    public FrmEditarEstudiante(ControladorCRUDEstudiantes objCtrlCRUDEst) {
        initComponents();
        this.objControladorCRUDEst = objCtrlCRUDEst;
        this.deshabilitarCampos();
        this.habilitarCampos();
    }

    //Habiliar y deshabilitar los componentes
    private void deshabilitarCampos() {
        txtNombre.setEnabled(false);
        txtApellidos.setEnabled(false);
        cboSemestre.setEnabled(false);
        cboCarrera.setEnabled(false);
        rdbtnGrupoA.setEnabled(false);
        rdbtnGrupoB.setEnabled(false);
        rdbtnGrupoC.setEnabled(false);
        btnGuardarCambios.setEnabled(false);
    }

    private void habilitarCampos() {
        txtNombre.setEnabled(true);
        txtApellidos.setEnabled(true);
        cboSemestre.setEnabled(true);
        cboCarrera.setEnabled(true);
        rdbtnGrupoA.setEnabled(true);
        rdbtnGrupoB.setEnabled(true);
        rdbtnGrupoC.setEnabled(true);
        btnGuardarCambios.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        cboSemestre = new javax.swing.JComboBox<>();
        rdbtnGrupoA = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rdbtnGrupoB = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rdbtnGrupoC = new javax.swing.JRadioButton();
        txtNumControl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGuardarCambios = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        cboCarrera = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Registro");

        cboSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        cboSemestre.setEnabled(false);

        buttonGroup1.add(rdbtnGrupoA);
        rdbtnGrupoA.setSelected(true);
        rdbtnGrupoA.setText("A");
        rdbtnGrupoA.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tecnológico del Valle de Oaxaca");

        jLabel7.setText("Grupo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Eliminar Estudiante");

        buttonGroup1.add(rdbtnGrupoB);
        rdbtnGrupoB.setText("B");
        rdbtnGrupoB.setEnabled(false);

        jLabel1.setText("Num Control");

        buttonGroup1.add(rdbtnGrupoC);
        rdbtnGrupoC.setText("C");
        rdbtnGrupoC.setEnabled(false);

        txtNumControl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumControlKeyPressed(evt);
            }
        });

        jLabel8.setText("Carrera");

        jLabel4.setText("Nombre");

        btnGuardarCambios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar48px.png"))); // NOI18N
        btnGuardarCambios.setText("Editar");
        btnGuardarCambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarCambiosMouseClicked(evt);
            }
        });
        btnGuardarCambios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarCambiosKeyPressed(evt);
            }
        });

        txtNombre.setEnabled(false);

        cboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ing. Informática", "Ing. en TIC", "Ing. en Ciencia de Datos", "Ing. en Gestión Empresarial", "Ing. Forestal", "Ing. en Agronomía", "Lic. en Biología" }));
        cboCarrera.setEnabled(false);

        jLabel5.setText("Apellidos");

        txtApellidos.setEnabled(false);

        jLabel6.setText("Semestre");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar232px.png"))); // NOI18N
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbtnGrupoA)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbtnGrupoB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbtnGrupoC))
                                    .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnGuardarCambios)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnBuscar)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbtnGrupoA)
                        .addComponent(rdbtnGrupoB)
                        .addComponent(rdbtnGrupoC))
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(btnGuardarCambios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCambiosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarCambiosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            this.Editar();
    }//GEN-LAST:event_btnGuardarCambiosKeyPressed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            this.buscarRegistro();
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void txtNumControlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumControlKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            this.buscarRegistro();
    }//GEN-LAST:event_txtNumControlKeyPressed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
        this.buscarRegistro();
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnGuardarCambiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCambiosMouseClicked
        // TODO add your handling code here:
        this.Editar();
    }//GEN-LAST:event_btnGuardarCambiosMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarRegistro(); // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void buscarRegistro() {
        String numControl = txtNumControl.getText().trim();
        String[] datos = objControladorCRUDEst.buscarRegistro(numControl);

        if (datos != null) {
            txtNombre.setText(datos[1]);
            txtApellidos.setText(datos[2]);
            try {
                int semestre = Integer.parseInt(datos[3]);
                cboSemestre.setSelectedIndex(semestre - 1); // Combo index comienza en 0
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir semestre: " + datos[3]);
            }
            cboCarrera.setSelectedItem(datos[5]);
            switch (datos[4].charAt(0)) {
                case 'A':
                    rdbtnGrupoA.setSelected(true);
                    break;
                case 'B':
                    rdbtnGrupoB.setSelected(true);
                    break;
                case 'C':
                    rdbtnGrupoC.setSelected(true);
                    break;
            }

            habilitarCampos();
        } else {
            mostrarMensaje("Estudiante no encontrado.");
            limpiarFormulario(); // opcional, para limpiar cualquier dato previo
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        cboSemestre.setSelectedIndex(-1);
        rdbtnGrupoA.setSelected(false);
        rdbtnGrupoB.setSelected(false);
        rdbtnGrupoC.setSelected(false);
        cboCarrera.setSelectedIndex(-1);
    }

    private void Editar() {
        String nc = txtNumControl.getText().trim();
        String nom = txtNombre.getText().trim();
        String ape = txtApellidos.getText().trim();
        int sem = Integer.parseInt(cboSemestre.getSelectedItem().toString());
        char grupo = rdbtnGrupoA.isSelected() ? 'A'
                : rdbtnGrupoB.isSelected() ? 'B' : 'C';
        String carrera = cboCarrera.getSelectedItem().toString();

        boolean editado = objControladorCRUDEst.editarRegistro(nc, nom, ape, sem, grupo, carrera);

        if (editado) {
            JOptionPane.showMessageDialog(this, "Registro actualizado correctamente.");
            limpiarFormulario();
            objControladorCRUDEst.llenarTabla(); // IMPORTANTE: refrescar tabla
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar. El número de control no existe.");
        }
    }

// Método para limpiar y resetear el formulario a estado inicial
    private void limpiarFormulario() {
        txtNumControl.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        cboSemestre.setSelectedIndex(0);
        cboCarrera.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        deshabilitarCampos();
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private boolean esNumeroControlValido(String numControl) {
        return numControl != null && !numControl.trim().isEmpty();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboCarrera;
    private javax.swing.JComboBox<String> cboSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton rdbtnGrupoA;
    private javax.swing.JRadioButton rdbtnGrupoB;
    private javax.swing.JRadioButton rdbtnGrupoC;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumControl;
    // End of variables declaration//GEN-END:variables
}
