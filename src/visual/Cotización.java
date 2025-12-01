/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;
import Cliente.ClienteArray;
import Cliente.Cliente;
import Persona.Empleado;
import Persona.EmpleadoArray;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cotización extends javax.swing.JFrame {

    private DefaultTableModel modeloClientes;
    private DefaultTableModel modeloVendedores;
    private DefaultTableModel modeloVehiculos;
    private DefaultTableModel modeloPromociones;

    public Cotización() {
        initComponents();

        configurarTablaClientes();
        configurarTablaVendedores();
        configurarTablaVehiculos();
        configurarTablaPromociones();
        configurarTablaCotizacion();

        cargarClientes();
        cargarVendedores();
        cargarVehiculos();
        cargarPromociones();
    }

    private void configurarTablaCotizacion() {
        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{"Tipo", "C1", "C2", "C3", "C4", "C5", "C6", "C7"},
                0
        );
        tbCotizacion.setModel(modelo);
    }

    private String safe(Object o) {
        return (o == null) ? "" : o.toString();
    }

    private void seleccionarTodo() {

        DefaultTableModel modelo = (DefaultTableModel) tbCotizacion.getModel();

        int filaCliente = jTableCliente.getSelectedRow();
        if (filaCliente == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un CLIENTE.");
            return;
        }
        modelo.addRow(new Object[]{
                "CLIENTE",
                safe(jTableCliente.getValueAt(filaCliente, 0)),
                safe(jTableCliente.getValueAt(filaCliente, 1)),
                safe(jTableCliente.getValueAt(filaCliente, 2)),
                safe(jTableCliente.getValueAt(filaCliente, 3)),
                safe(jTableCliente.getValueAt(filaCliente, 4)),
                safe(jTableCliente.getValueAt(filaCliente, 5)),
                safe(jTableCliente.getValueAt(filaCliente, 6))
        });

        int filaVendedor = jTableVendedor.getSelectedRow();
        if (filaVendedor == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un VENDEDOR.");
            return;
        }
        modelo.addRow(new Object[]{
                "VENDEDOR",
                safe(jTableVendedor.getValueAt(filaVendedor, 0)),
                safe(jTableVendedor.getValueAt(filaVendedor, 1)),
                safe(jTableVendedor.getValueAt(filaVendedor, 2)),
                safe(jTableVendedor.getValueAt(filaVendedor, 3)),
                "", "", ""
        });

        int filaVeh = jTableVehículo.getSelectedRow();
        if (filaVeh == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un VEHÍCULO.");
            return;
        }
        modelo.addRow(new Object[]{
                "VEHÍCULO",
                safe(jTableVehículo.getValueAt(filaVeh, 0)),
                safe(jTableVehículo.getValueAt(filaVeh, 1)),
                safe(jTableVehículo.getValueAt(filaVeh, 2)),
                safe(jTableVehículo.getValueAt(filaVeh, 3)),
                safe(jTableVehículo.getValueAt(filaVeh, 4)),
                safe(jTableVehículo.getValueAt(filaVeh, 5)),
                safe(jTableVehículo.getValueAt(filaVeh, 6))
        });

        int filaPromo = jTablePromocion.getSelectedRow();
        if (filaPromo == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una PROMOCIÓN.");
            return;
        }
        modelo.addRow(new Object[]{
                "PROMOCIÓN",
                safe(jTablePromocion.getValueAt(filaPromo, 0)),
                safe(jTablePromocion.getValueAt(filaPromo, 1)),
                safe(jTablePromocion.getValueAt(filaPromo, 2)),
                safe(jTablePromocion.getValueAt(filaPromo, 3)),
                safe(jTablePromocion.getValueAt(filaPromo, 4)),
                "", ""
        });

        JOptionPane.showMessageDialog(this, "Datos agregados correctamente.");
    }

    private void configurarTablaClientes() {
        modeloClientes = new DefaultTableModel(
                new String[]{"DNI", "Nombre", "Apellido Pat.", "Apellido Mat.", "Dirección", "Teléfono", "Correo"}, 0
        );
        jTableCliente.setModel(modeloClientes);
    }

    private void cargarClientes() {
        modeloClientes.setRowCount(0);
        for (int i = 0; i < ClienteArray.contador; i++) {
            Cliente c = ClienteArray.clientes[i];
            if (c != null) {
                modeloClientes.addRow(new Object[]{
                        c.getDNI(), c.getNombre(), c.getApellidoPaterno(),
                        c.getApellidoMaterno(), c.getDireccion(),
                        c.getTelefono(), c.getCorreo()
                });
            }
        }
    }

    private void configurarTablaVendedores() {
        modeloVendedores = new DefaultTableModel(
                new String[]{"Nombre", "DNI", "Apellido Pat.", "Apellido Mat."}, 0
        );
        jTableVendedor.setModel(modeloVendedores);
    }

    private void cargarVendedores() {
        modeloVendedores.setRowCount(0);
        for (int i = 0; i < EmpleadoArray.contadorVendedores; i++) {
            Empleado v = EmpleadoArray.vendedores[i];
            if (v != null) {
                modeloVendedores.addRow(new Object[]{
                        v.getNombre(),
                        v.getDNI(),
                        v.getApellidoPaterno(),
                        v.getApellidoMaterno()
                });
            }
        }
    }

    private void configurarTablaVehiculos() {
        modeloVehiculos = new DefaultTableModel(
                new String[]{"Código","Marca","Modelo","Color","Año Fab.","Tipo","Precio Base","Disponibilidad"}, 0
        );
        jTableVehículo.setModel(modeloVehiculos);
    }

    private void cargarVehiculos() {

        DefaultTableModel modeloExtern = Vehiculos.getModeloVehiculos();
        if (modeloExtern == null) {
            modeloVehiculos.setRowCount(0);
            return;
        }

        modeloVehiculos.setRowCount(0);

        for (int i = 0; i < modeloExtern.getRowCount(); i++) {
            modeloVehiculos.addRow(new Object[]{
                    modeloExtern.getValueAt(i, 0),
                    modeloExtern.getValueAt(i, 1),
                    modeloExtern.getValueAt(i, 2),
                    modeloExtern.getValueAt(i, 3),
                    modeloExtern.getValueAt(i, 4),
                    modeloExtern.getValueAt(i, 5),
                    modeloExtern.getValueAt(i, 6),
                    modeloExtern.getValueAt(i, 7)
            });
        }
    }

    private void configurarTablaPromociones() {
        modeloPromociones = new DefaultTableModel(
                new String[]{"Código","Nombre","Descripción","Descuento","Vigencia"}, 0
        );
        jTablePromocion.setModel(modeloPromociones);
    }

    private void cargarPromociones() {

        DefaultTableModel modeloExtern = Promociones.getModelPromociones();
        if (modeloExtern == null) {
            modeloPromociones.setRowCount(0);
            return;
        }

        modeloPromociones.setRowCount(0);

        for (int i = 0; i < modeloExtern.getRowCount(); i++) {
            modeloPromociones.addRow(new Object[]{
                    modeloExtern.getValueAt(i, 0),
                    modeloExtern.getValueAt(i, 1),
                    modeloExtern.getValueAt(i, 2),
                    modeloExtern.getValueAt(i, 3),
                    modeloExtern.getValueAt(i, 4)
            });
        }
    }


    @SuppressWarnings("unchecked")
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCotizacion = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablePromocion = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableVendedor = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableVehículo = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        btLimpiar = new javax.swing.JButton();
        btCrear = new javax.swing.JButton();
        btAprobarCotizacion = new javax.swing.JButton();
        btComprobante = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Datos de la Cotización");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbCotizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbCotizacion.setToolTipText("");
        tbCotizacion.setName(""); // NOI18N
        jScrollPane3.setViewportView(tbCotizacion);

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCliente);

        jTablePromocion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTablePromocion);

        jTableVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTableVendedor);

        jTableVehículo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTableVehículo);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Datos de la Cotización");

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        btCrear.setText("Crear");
        btCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearActionPerformed(evt);
            }
        });

        btAprobarCotizacion.setText("Aprobar Cotización");
        btAprobarCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAprobarCotizacionActionPerformed(evt);
            }
        });

        btComprobante.setText("Imprimir Comprobante");
        btComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprobanteActionPerformed(evt);
            }
        });

        jLabel1.setText("Cliente");

        jLabel2.setText("Vendedor");

        jLabel3.setText("Promociones");

        jLabel4.setText("Vehículo");

        jLabel5.setText("COTIZACIÓN");

        btnSeleccionar.setText("selecionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(btAprobarCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(135, 135, 135))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btCrear)
                                        .addGap(114, 114, 114)
                                        .addComponent(btLimpiar)
                                        .addGap(177, 177, 177))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeleccionar)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 967, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(251, 251, 251)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btLimpiar)
                                        .addComponent(btCrear)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(53, 53, 53)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btComprobante)
                        .addComponent(btAprobarCotizacion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionar)
                .addContainerGap())
        );

        jLabel17.setBackground(new java.awt.Color(22, 65, 97));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setText("Gestión de Cotización");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprobanteActionPerformed
        // TODO add your handling code here:

        javax.swing.JOptionPane.showMessageDialog(this,
            "Comprobante generado.");
    }//GEN-LAST:event_btComprobanteActionPerformed

    private void btAprobarCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAprobarCotizacionActionPerformed
        // TODO add your handling code here:

        javax.swing.JOptionPane.showMessageDialog(this,
            "Cotización aprobada correctamente.");
    }//GEN-LAST:event_btAprobarCotizacionActionPerformed

    private void btCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearActionPerformed
        // TODO add your handling code here:

    

        // Precio de ejemplo (puedes modificar según tu sistema)
        double precioVehiculo = 10000;
        double descuento = 0;
        double precioFinal = precioVehiculo - descuento;

        DefaultTableModel modelo = (DefaultTableModel) tbCotizacion.getModel();

       
    }//GEN-LAST:event_btCrearActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionarTodo();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cotización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cotización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cotización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cotización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cotización().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAprobarCotizacion;
    private javax.swing.JButton btComprobante;
    private javax.swing.JButton btCrear;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTablePromocion;
    private javax.swing.JTable jTableVehículo;
    private javax.swing.JTable jTableVendedor;
    private javax.swing.JTable tbCotizacion;
    // End of variables declaration//GEN-END:variables
}
