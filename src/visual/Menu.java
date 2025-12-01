/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

/**
 *
 * @author Jimena
 */
import javax.swing.UIManager;

public class Menu extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    public Menu() {

        // Restaurado: sin modificar comportamiento del mouse
        // UIManager.put("Menu.delay", 200);  // <-- Eliminado

        initComponents();
        accionesMenu();
    }

    // ======================================================
    //      ACCIONES NORMALES: SOLO SE ABRE AL HACER CLIC
    // ======================================================
    private void accionesMenu() {

        // --- Abrir formulario Empleados ---
        jMenuEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Empleados emp = new Empleados();
                emp.setVisible(true);
                emp.setLocationRelativeTo(null);
            }
        });

        // --- Abrir formulario Administradores ---
        jMenuAdministradores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaAdministradores lista = new ListaAdministradores();
                lista.setVisible(true);
                lista.setLocationRelativeTo(null);
            }
        });

        // --- Abrir formulario Clientes ---
        jMenuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clientes cli = new Clientes();
                cli.setVisible(true);
                cli.setLocationRelativeTo(null);
            }
        });

        // --- Abrir formulario Vendedores ---
        jMenuVendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lisVendedores listaVen = new lisVendedores();
                listaVen.setVisible(true);
                listaVen.setLocationRelativeTo(null);
            }
        });

        // --- Abrir formulario Cotización ---
        jMenuCotizacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cotización cot = new Cotización();
                cot.setVisible(true);
                cot.setLocationRelativeTo(null);
            }
        });
        // --- Abrir formulario Promociones ---
        jMenuPromociones.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Promociones promo = new Promociones();
                promo.setVisible(true);
                promo.setLocationRelativeTo(null);
            }
});
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInicio = new javax.swing.JMenu();
        jMenuJAdministracion = new javax.swing.JMenu();
        jMenuEmpleados = new javax.swing.JMenu();
        jMenuAdministrador = new javax.swing.JMenu();
        jMenuAdministradores = new javax.swing.JMenu();
        jMenuVehiculos = new javax.swing.JMenu();
        jMenuPromociones = new javax.swing.JMenu();
        jMenuVendedor = new javax.swing.JMenu();
        jMenuClientes = new javax.swing.JMenu();
        jMenuVendedores = new javax.swing.JMenu();
        jMenuCotizacion = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU");

        jMenuInicio.setText("Inicio");
        jMenuBar1.add(jMenuInicio);

        jMenuJAdministracion.setText("J.Administración");

        jMenuEmpleados.setText("Lista de empleados");
        jMenuJAdministracion.add(jMenuEmpleados);

        jMenuBar1.add(jMenuJAdministracion);

        jMenuAdministrador.setText("Administrador");

        jMenuAdministradores.setText("Lista de administradores");
        jMenuAdministradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuAdministradoresMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuAdministradoresMousePressed(evt);
            }
        });
        jMenuAdministrador.add(jMenuAdministradores);

        jMenuVehiculos.setText("Vehiculos");
        jMenuAdministrador.add(jMenuVehiculos);

        jMenuPromociones.setText("Promociones");
        jMenuAdministrador.add(jMenuPromociones);

        jMenuBar1.add(jMenuAdministrador);

        jMenuVendedor.setText("Vendedor");

        jMenuClientes.setText("Registro de clientes");
        jMenuVendedor.add(jMenuClientes);

        jMenuVendedores.setText("Lista de vendedores");
        jMenuVendedor.add(jMenuVendedores);

        jMenuCotizacion.setText("Cotizacion");
        jMenuVendedor.add(jMenuCotizacion);

        jMenuBar1.add(jMenuVendedor);

        jMenu4.setText("Venta");
        jMenuBar1.add(jMenu4);

        jMenu2.setText("Reporte de venta");
        jMenuBar1.add(jMenu2);

        jMenu1.setText("Salida");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuAdministradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAdministradoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuAdministradoresMouseClicked

    private void jMenuAdministradoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAdministradoresMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuAdministradoresMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenuAdministrador;
    private javax.swing.JMenu jMenuAdministradores;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenu jMenuCotizacion;
    private javax.swing.JMenu jMenuEmpleados;
    private javax.swing.JMenu jMenuInicio;
    private javax.swing.JMenu jMenuJAdministracion;
    private javax.swing.JMenu jMenuPromociones;
    private javax.swing.JMenu jMenuVehiculos;
    private javax.swing.JMenu jMenuVendedor;
    private javax.swing.JMenu jMenuVendedores;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
