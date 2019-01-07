package monitoreo;



/**
 *
 * @author Jharvar
 */
public class Formulario extends javax.swing.JFrame {

   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Formulario() {
        initComponents();
    }
                   
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Console = new javax.swing.JTextArea();
        area_comandos = new javax.swing.JTextField();
        botonEnviar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        botonSelect = new javax.swing.JButton();
        botonInsertInto = new javax.swing.JButton();
        botonUpdate = new javax.swing.JButton();
        botonDelete = new javax.swing.JButton();
        botonVALUES = new javax.swing.JButton();
        botonSet = new javax.swing.JButton();
        botonWhere = new javax.swing.JButton();
        botonFROM = new javax.swing.JButton();
        botonDrop = new javax.swing.JButton();
        botonTable = new javax.swing.JButton();
        botonDatabase = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemSalir = new javax.swing.JMenuItem();
        acciones_db = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Console.setColumns(20);
        Console.setRows(5);
        jScrollPane1.setViewportView(Console);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 700, 450));
        getContentPane().add(area_comandos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 570, 40));

        botonEnviar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        botonEnviar.setText("Enviar");
        getContentPane().add(botonEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 500, 110, 40));

        jToolBar1.setRollover(true);

        botonSelect.setText("SELECT");
        botonSelect.setFocusable(false);
        botonSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSelect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSelectActionPerformed(evt);
            }
        });
        jToolBar1.add(botonSelect);

        botonInsertInto.setText("INSERT INTO");
        botonInsertInto.setFocusable(false);
        botonInsertInto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonInsertInto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonInsertInto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertIntoActionPerformed(evt);
            }
        });
        jToolBar1.add(botonInsertInto);

        botonUpdate.setText("UPDATE");
        botonUpdate.setFocusable(false);
        botonUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUpdateActionPerformed(evt);
            }
        });
        jToolBar1.add(botonUpdate);

        botonDelete.setText("DELETE");
        botonDelete.setFocusable(false);
        botonDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(botonDelete);

        botonVALUES.setText("VALUES");
        botonVALUES.setFocusable(false);
        botonVALUES.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonVALUES.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonVALUES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVALUESActionPerformed(evt);
            }
        });
        jToolBar1.add(botonVALUES);

        botonSet.setText("SET");
        botonSet.setFocusable(false);
        botonSet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSetActionPerformed(evt);
            }
        });
        jToolBar1.add(botonSet);

        botonWhere.setText("WHERE");
        botonWhere.setFocusable(false);
        botonWhere.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonWhere.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonWhere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonWhereActionPerformed(evt);
            }
        });
        jToolBar1.add(botonWhere);

        botonFROM.setText("FROM");
        botonFROM.setFocusable(false);
        botonFROM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonFROM.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonFROM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFROMActionPerformed(evt);
            }
        });
        jToolBar1.add(botonFROM);

        botonDrop.setText("DROP");
        botonDrop.setFocusable(false);
        botonDrop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonDrop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDropActionPerformed(evt);
            }
        });
        jToolBar1.add(botonDrop);

        botonTable.setText("TABLE");
        botonTable.setFocusable(false);
        botonTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTableActionPerformed(evt);
            }
        });
        jToolBar1.add(botonTable);

        botonDatabase.setText("DATABASE");
        botonDatabase.setFocusable(false);
        botonDatabase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonDatabase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDatabaseActionPerformed(evt);
            }
        });
        jToolBar1.add(botonDatabase);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 30));

        menuArchivo.setText("Archivo");

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);

        jMenuBar1.add(menuArchivo);

        acciones_db.setText("Operaciones");
        jMenuBar1.add(acciones_db);

        setJMenuBar(jMenuBar1);

        pack();
    }                      

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
    }                                         

    private void botonSelectActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
    }                                           

    private void botonInsertIntoActionPerformed(java.awt.event.ActionEvent evt) {                                                
      
    }                                               

    private void botonDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                            
       
    }                                           

    private void botonUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                            
       
    }                                           

    private void botonVALUESActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
    }                                           

    private void botonSetActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }                                        

    private void botonWhereActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }                                          

    private void botonFROMActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void botonDropActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void botonTableActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }                                          

    private void botonDatabaseActionPerformed(java.awt.event.ActionEvent evt) {                                              
       
    }                                             

   
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

                      
    private javax.swing.JTextArea Console;
    private javax.swing.JMenu acciones_db;
    private javax.swing.JTextField area_comandos;
    private javax.swing.JButton botonDatabase;
    private javax.swing.JButton botonDelete;
    private javax.swing.JButton botonDrop;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonFROM;
    private javax.swing.JButton botonInsertInto;
    private javax.swing.JButton botonSelect;
    private javax.swing.JButton botonSet;
    private javax.swing.JButton botonTable;
    private javax.swing.JButton botonUpdate;
    private javax.swing.JButton botonVALUES;
    private javax.swing.JButton botonWhere;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuArchivo;
                     
}
