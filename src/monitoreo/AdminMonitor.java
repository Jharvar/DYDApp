package monitoreo;

/**
 *
 * @author Jharvar
 */
public class AdminMonitor extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form AdminMonitor
     */
    public AdminMonitor() {
        initComponents();
        setTitle("Monitoreo");
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemGuardarInformacion = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        menuAcciones = new javax.swing.JMenu();
        itemFormularioBaseDeDatos = new javax.swing.JMenuItem();
        menuFiltro = new javax.swing.JMenu();
        itemFiltroNombre = new javax.swing.JMenuItem();
        itemFiltroClase = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1260, 470));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 510));

        menuArchivo.setText("Archivo");

        itemGuardarInformacion.setText("Guardar Informacion");
        itemGuardarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarInformacionActionPerformed(evt);
            }
        });
        menuArchivo.add(itemGuardarInformacion);

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);

        jMenuBar2.add(menuArchivo);

        menuAcciones.setText("Acciones");

        itemFormularioBaseDeDatos.setText("Base De Datos");
        itemFormularioBaseDeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFormularioBaseDeDatosActionPerformed(evt);
            }
        });
        menuAcciones.add(itemFormularioBaseDeDatos);

        jMenuBar2.add(menuAcciones);

        menuFiltro.setText("Filtros");

        itemFiltroNombre.setText("Filtro Nombre");
        itemFiltroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFiltroNombreActionPerformed(evt);
            }
        });
        menuFiltro.add(itemFiltroNombre);

        itemFiltroClase.setText("Filtro Clase");
        itemFiltroClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFiltroClaseActionPerformed(evt);
            }
        });
        menuFiltro.add(itemFiltroClase);

        jMenuBar2.add(menuFiltro);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>                        

    private void itemFormularioBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }                                                         

    private void itemFiltroNombreActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void itemFiltroClaseActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void itemGuardarInformacionActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

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
            java.util.logging.Logger.getLogger(AdminMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMonitor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem itemFiltroClase;
    private javax.swing.JMenuItem itemFiltroNombre;
    private javax.swing.JMenuItem itemFormularioBaseDeDatos;
    private javax.swing.JMenuItem itemGuardarInformacion;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menuAcciones;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuFiltro;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration                   
}

