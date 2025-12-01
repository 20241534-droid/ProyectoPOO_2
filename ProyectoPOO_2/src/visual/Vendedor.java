/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vendedor extends javax.swing.JFrame {

    

    // ==============================
    // ARREGLOS DE CLIENTES
    // ==============================
    private String[] dni = new String[100];
    private String[] nombre = new String[100];
    private String[] apellidoPat = new String[100];
    private String[] apellidoMat = new String[100];
    private String[] direccion = new String[100];
    private String[] telefono = new String[100];
    private String[] correo = new String[100];

    private int contador = 0;

    public Vendedor() {
        initComponents();
        inicializarTabla();
        accionesBotones();
        cargarFilaSeleccionada();
        aplicarPermisosPorCargo(); // aplicar permisos según selección inicial
    }

    // ==============================
    // INICIALIZAR TABLA
    // ==============================
    private void inicializarTabla() {
        String[] columnas = {"DNI", "Nombre", "A. Paterno", "A. Materno", "Dirección", "Teléfono", "Correo"};
        jTableDatos.setModel(new DefaultTableModel(new Object[][]{}, columnas));
    }

    // ==============================
    // ES VENDEDOR?
    // ==============================
    private boolean esVendedor() {
        Object sel = jComboBoxCargo.getSelectedItem();
        return sel != null && sel.toString().equals("Vendedor");
    }

    // ==============================
    // APLICAR PERMISOS SEGÚN CARGO
    // ==============================
    private void aplicarPermisosPorCargo() {
        boolean vendedor = esVendedor();

        // Habilitar o deshabilitar botones
        btnAgregar.setEnabled(vendedor);
        btnModificar.setEnabled(vendedor);
        btnEliminar.setEnabled(vendedor);

        // Habilitar o deshabilitar edición de campos
        txtDNI.setEditable(vendedor);
        txtNombre.setEditable(vendedor);
        txtApellidoPaterno.setEditable(vendedor);
        txtApellidoMaterno.setEditable(vendedor);
        txtDireccion.setEditable(vendedor);
        txtTelefono.setEditable(vendedor);
        txtCorreoElectronico.setEditable(vendedor);
    }

    // ==============================
    // ACCIONES BOTONES
    // ==============================
    private void accionesBotones() {

        // BOTÓN AGREGAR
        btnAgregar.addActionListener(e -> {
            if (!esVendedor()) {
                JOptionPane.showMessageDialog(this, "Solo el Vendedor puede agregar.");
                return;
            }

            if (contador >= 100) {
                JOptionPane.showMessageDialog(this, "Límite de clientes alcanzado.");
                return;
            }

            String sDni = txtDNI.getText().trim();
            String sNombre = txtNombre.getText().trim();

            if (sDni.isEmpty() || sNombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "DNI y Nombre son obligatorios.");
                return;
            }

            dni[contador] = sDni;
            nombre[contador] = sNombre;
            apellidoPat[contador] = txtApellidoPaterno.getText().trim();
            apellidoMat[contador] = txtApellidoMaterno.getText().trim();
            direccion[contador] = txtDireccion.getText().trim();
            telefono[contador] = txtTelefono.getText().trim();
            correo[contador] = txtCorreoElectronico.getText().trim();

            DefaultTableModel model = (DefaultTableModel) jTableDatos.getModel();
            model.addRow(new Object[]{
                    dni[contador],
                    nombre[contador],
                    apellidoPat[contador],
                    apellidoMat[contador],
                    direccion[contador],
                    telefono[contador],
                    correo[contador]
            });

            contador++;
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Cliente agregado.");
        });

        // BOTÓN MODIFICAR
        btnModificar.addActionListener(e -> {
            if (!esVendedor()) {
                JOptionPane.showMessageDialog(this, "Solo el Vendedor puede modificar.");
                return;
            }

            int fila = jTableDatos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente.");
                return;
            }

            dni[fila] = txtDNI.getText().trim();
            nombre[fila] = txtNombre.getText().trim();
            apellidoPat[fila] = txtApellidoPaterno.getText().trim();
            apellidoMat[fila] = txtApellidoMaterno.getText().trim();
            direccion[fila] = txtDireccion.getText().trim();
            telefono[fila] = txtTelefono.getText().trim();
            correo[fila] = txtCorreoElectronico.getText().trim();

            DefaultTableModel model = (DefaultTableModel) jTableDatos.getModel();
            model.setValueAt(dni[fila], fila, 0);
            model.setValueAt(nombre[fila], fila, 1);
            model.setValueAt(apellidoPat[fila], fila, 2);
            model.setValueAt(apellidoMat[fila], fila, 3);
            model.setValueAt(direccion[fila], fila, 4);
            model.setValueAt(telefono[fila], fila, 5);
            model.setValueAt(correo[fila], fila, 6);

            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Cliente modificado.");
        });

        // BOTÓN ELIMINAR
        btnEliminar.addActionListener(e -> {
            if (!esVendedor()) {
                JOptionPane.showMessageDialog(this, "Solo el Vendedor puede eliminar.");
                return;
            }

            int fila = jTableDatos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente.");
                return;
            }

            // Correr los datos en los arreglos
            for (int i = fila; i < contador - 1; i++) {
                dni[i] = dni[i + 1];
                nombre[i] = nombre[i + 1];
                apellidoPat[i] = apellidoPat[i + 1];
                apellidoMat[i] = apellidoMat[i + 1];
                direccion[i] = direccion[i + 1];
                telefono[i] = telefono[i + 1];
                correo[i] = correo[i + 1];
            }

            // limpiar última posición opcional
            int last = contador - 1;
            if (last >= 0) {
                dni[last] = null;
                nombre[last] = null;
                apellidoPat[last] = null;
                apellidoMat[last] = null;
                direccion[last] = null;
                telefono[last] = null;
                correo[last] = null;
            }

            contador--;

            DefaultTableModel model = (DefaultTableModel) jTableDatos.getModel();
            model.removeRow(fila);

            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Cliente eliminado.");
        });

        // Cuando cambie cargo desde el combo, aplicamos permisos
        jComboBoxCargo.addActionListener(e -> aplicarPermisosPorCargo());
    }

    // ==============================
    // CARGAR DATOS DE LA TABLA A LOS CAMPOS
    // ==============================
    private void cargarFilaSeleccionada() {
        jTableDatos.getSelectionModel().addListSelectionListener(e -> {
            int fila = jTableDatos.getSelectedRow();
            if (fila >= 0 && fila < contador) {
                txtDNI.setText(dni[fila] == null ? "" : dni[fila]);
                txtNombre.setText(nombre[fila] == null ? "" : nombre[fila]);
                txtApellidoPaterno.setText(apellidoPat[fila] == null ? "" : apellidoPat[fila]);
                txtApellidoMaterno.setText(apellidoMat[fila] == null ? "" : apellidoMat[fila]);
                txtDireccion.setText(direccion[fila] == null ? "" : direccion[fila]);
                txtTelefono.setText(telefono[fila] == null ? "" : telefono[fila]);
                txtCorreoElectronico.setText(correo[fila] == null ? "" : correo[fila]);
            }
        });
    }

    // --------------------------------------
    // Limpia los campos del formulario
    // --------------------------------------
    private void limpiarCampos() {
        txtDNI.setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
        jTableDatos.clearSelection();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jComboBoxCargo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtCorreoElectronico = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JToggleButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Administrador" }));
        jComboBoxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCargoActionPerformed(evt);
            }
        });

        jLabel1.setText("Direccion");

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane2.setViewportView(jTableDatos);

        jLabel2.setText("DNI");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apelido Paterno");

        jLabel5.setText("Apellido Materno");

        jLabel7.setText("¿Aque cargo perteneces?");

        jLabel8.setText("Telefono");

        jLabel9.setText("Correo electronico ");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");

        btnModificar.setText("Modificar");

        btnEliminar.setText("Eliminar");

        jLabel10.setText("Datos del cliente");

        btnAtras.setText("Volver a Menu");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnAgregar)
                        .addGap(45, 45, 45)
                        .addComponent(btnModificar)
                        .addGap(51, 51, 51)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnAtras)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtras)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCargoActionPerformed
        
    }//GEN-LAST:event_jComboBoxCargoActionPerformed
    
    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Vendedor().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JToggleButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> jComboBoxCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
