/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HGR46;

//import empresa.Insertar;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author master EMM
 */
public class Principal extends javax.swing.JFrame {

    DefaultTableModel modelo;
     DefaultTableModel modelom;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);   
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\master EMM\\Documents\\NetBeansProjects\\Empresa\\IMSS.jpg"));
        setTitle("SISTEMA DE CONTROL DE INVENTARIO");
        grupoRadios.add(RadioSerie);
        grupoRadios.add(RadioNombre);
        grupoRadios.add(RadioNNI);
        grupoUsuarios.add(radioEduardo);
        grupoUsuarios.add(radioCarlos);
        grupoUsuarios.add(radioCristal);
        grupoUsuarios.add(radioHernandez);
        grupoUsuarios.add(radioGrupal);
        grupotarea.add(radionuevatarea);
        grupotarea.add(radiopendientes);
        grupoImpresora.add(jRadioNSerie);
        grupoImpresora.add(jRadioConexion);
        grupoRespaldo.add(RUsuarios);
        grupoRespaldo.add(RCuentas);
        grupoRespaldo.add(REquipos);
        grupoRespaldo.add(RImpresora);
        txtfbuscarequipo.setEnabled(false);
        TablaMostrar.setEnabled(false);
        botonActualizar.setEnabled(false);
        lblcontador.setVisible(true);
        Tareas.setVisible(false);
        radioEduardo.setVisible(false);
        radioCarlos.setVisible(false);
        radioCristal.setVisible(false);
        radioHernandez.setVisible(false);
        radioGrupal.setVisible(false);
        Pendientes.setVisible(false);
        jTextImpresora.setEnabled(false);
        TablaImpresora.setEnabled(false);
        GuardarImpresora.setEnabled(false);
        RespaldoUsuarios.setVisible(false);
        RespaldoImpresora.setVisible(false);
        RespaldoEquipos.setVisible(false);
        RespaldoCuentas.setVisible(false);
       
        formatoequipo();
        
//Conteo de equipos de computo 
        Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion(); 
             

            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select count(serie_compu) from equipo ");
                  if(rs.next()){
                      String contador = rs.getString("count(serie_compu)");
                      lblcontador.setText(contador + "");
                  }
                   
                   
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
//Fin de conteo de equipos de computo


       // tablaActualizar.setEditingColumn(0);
    }
public void actualizaequipo(){
    
     Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
         modelom = new DefaultTableModel();
            
        TablaMostrar.setModel(modelom);
        modelom.addColumn("serie compu");
        modelom.addColumn("piso");
        modelom.addColumn("area");
        modelom.addColumn("consultorio");
        modelom.addColumn("subarea");
        modelom.addColumn("nombre");
        modelom.addColumn("cuenta");
        modelom.addColumn("marca");
        modelom.addColumn("modelo");
        modelom.addColumn("mac");
        modelom.addColumn("nni");
        modelom.addColumn("ip");
        modelom.addColumn("direccion ip");
        modelom.addColumn("serie impresora");
        modelom.addColumn("id usuario");
            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from equipo ");
                
                   if(rs.next()){
                   
                     modelom.addRow(new Object[]{rs.getString("serie_compu"), rs.getString("piso"), rs.getString("area"), 
                      rs.getString("consultorio"), rs.getString("subarea"), rs.getString("nombre"), rs.getString("cuenta"),
                      rs.getString("marca"), rs.getString("modelo"), rs.getString("mac"), rs.getString("nni"),
                      rs.getString("ip"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
                   else{
                       showMessageDialog(null, "No se encuentra en la base de datos!!!");
                       txtfbuscarequipo.setText("");
                     
                   }
                   /*modelom.addTableModelListener(new TableModelListener() {
                       
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        if(e.getType() == TableModelEvent.UPDATE){
                            int columna = e.getColumn();
                             int fila = e.getFirstRow();
                             if(columna == 1){
                                 String sql = "Update equipo set piso = '"+TablaMostrar.getValueAt(fila, columna)+"'";
                                 
                             }
                        }
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });*/
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
    
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadios = new javax.swing.ButtonGroup();
        grupoUsuarios = new javax.swing.ButtonGroup();
        grupotarea = new javax.swing.ButtonGroup();
        grupoImpresora = new javax.swing.ButtonGroup();
        grupoRespaldo = new javax.swing.ButtonGroup();
        btn_regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Jfconsultainventario = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Jfactualizainventario = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        RadioSerie = new javax.swing.JRadioButton();
        RadioNombre = new javax.swing.JRadioButton();
        RadioNNI = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtfbuscarequipo = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        BotonMostrar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaMostrar = new javax.swing.JTable();
        Jframeconsultausuario = new javax.swing.JInternalFrame();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaUsuario = new javax.swing.JTable();
        BuscaUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BuscarUsuario = new javax.swing.JButton();
        Jframeconsultaimpresora = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaImpresora = new javax.swing.JTable();
        jTextImpresora = new javax.swing.JTextField();
        BuscarImpresora = new javax.swing.JButton();
        MostrarTodoImpresora = new javax.swing.JButton();
        GuardarImpresora = new javax.swing.JButton();
        jRadioNSerie = new javax.swing.JRadioButton();
        jRadioConexion = new javax.swing.JRadioButton();
        EditarImpresora = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jframetareas = new javax.swing.JInternalFrame();
        radioEduardo = new javax.swing.JRadioButton();
        radioCarlos = new javax.swing.JRadioButton();
        radioCristal = new javax.swing.JRadioButton();
        radioHernandez = new javax.swing.JRadioButton();
        radioGrupal = new javax.swing.JRadioButton();
        radiopendientes = new javax.swing.JRadioButton();
        radionuevatarea = new javax.swing.JRadioButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        Pendientes = new javax.swing.JInternalFrame();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Tareas = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jframeRespaldo = new javax.swing.JInternalFrame();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        RespaldoUsuarios = new javax.swing.JInternalFrame();
        jScrollPane9 = new javax.swing.JScrollPane();
        TablaRespaldoUsuarios = new javax.swing.JTable();
        RespaldoImpresora = new javax.swing.JInternalFrame();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaRespaldoImpresora = new javax.swing.JTable();
        RespaldoCuentas = new javax.swing.JInternalFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaRespaldoCuentas = new javax.swing.JTable();
        RespaldoEquipos = new javax.swing.JInternalFrame();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablasRespaldoEquipos = new javax.swing.JTable();
        RUsuarios = new javax.swing.JRadioButton();
        REquipos = new javax.swing.JRadioButton();
        RCuentas = new javax.swing.JRadioButton();
        RImpresora = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblcontador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));

        btn_regresar.setBackground(new java.awt.Color(255, 255, 255));
        btn_regresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_regresar.setForeground(new java.awt.Color(0, 204, 204));
        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Selecciona una opción?");

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1267, 719));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1267, 400));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        Jfconsultainventario.setMinimumSize(new java.awt.Dimension(1262, 600));
        Jfconsultainventario.setPreferredSize(new java.awt.Dimension(1262, 600));
        Jfconsultainventario.setVisible(true);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        Tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout JfconsultainventarioLayout = new javax.swing.GroupLayout(Jfconsultainventario.getContentPane());
        Jfconsultainventario.getContentPane().setLayout(JfconsultainventarioLayout);
        JfconsultainventarioLayout.setHorizontalGroup(
            JfconsultainventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        );
        JfconsultainventarioLayout.setVerticalGroup(
            JfconsultainventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfconsultainventarioLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CONSULTA INVENTARIO", Jfconsultainventario);

        Jfactualizainventario.setVisible(true);
        Jfactualizainventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JfactualizainventarioMouseEntered(evt);
            }
        });

        jPanel1.setToolTipText("");

        RadioSerie.setText("Serie");
        RadioSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioSerieActionPerformed(evt);
            }
        });

        RadioNombre.setText("Nombre");
        RadioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioNombreActionPerformed(evt);
            }
        });

        RadioNNI.setText("NNI");
        RadioNNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioNNIActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Buscar por:");

        txtfbuscarequipo.setToolTipText("Equipo a buscar!!!");
        txtfbuscarequipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfbuscarequipoKeyTyped(evt);
            }
        });

        botonActualizar.setText("Guardar Cambios");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.setEnabled(false);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jButton1.setText("Insertar equipo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BotonMostrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BotonMostrar.setText("Mostrar todo");
        BotonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMostrarActionPerformed(evt);
            }
        });

        botonEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        jInternalFrame1.setVisible(true);

        TablaMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TablaMostrar.setDropMode(javax.swing.DropMode.INSERT);
        TablaMostrar.setFocusable(false);
        TablaMostrar.setGridColor(new java.awt.Color(0, 153, 255));
        TablaMostrar.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TablaMostrar);
        if (TablaMostrar.getColumnModel().getColumnCount() > 0) {
            TablaMostrar.getColumnModel().getColumn(0).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(1).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(2).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(3).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(4).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(5).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(6).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(7).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(8).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(9).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(10).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(11).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(12).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(13).setResizable(false);
            TablaMostrar.getColumnModel().getColumn(14).setResizable(false);
        }

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1096, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RadioSerie)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RadioNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RadioNNI))
                        .addGap(107, 107, 107)
                        .addComponent(txtfbuscarequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(botonBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(BotonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfbuscarequipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RadioSerie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RadioNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadioNNI)
                        .addGap(46, 46, 46)
                        .addComponent(BotonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(254, Short.MAX_VALUE))
                    .addComponent(jInternalFrame1)))
        );

        javax.swing.GroupLayout JfactualizainventarioLayout = new javax.swing.GroupLayout(Jfactualizainventario.getContentPane());
        Jfactualizainventario.getContentPane().setLayout(JfactualizainventarioLayout);
        JfactualizainventarioLayout.setHorizontalGroup(
            JfactualizainventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JfactualizainventarioLayout.setVerticalGroup(
            JfactualizainventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ACTUALIZA INVENTARIO", Jfactualizainventario);

        Jframeconsultausuario.setVisible(true);

        jInternalFrame3.setVisible(true);

        TablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane2.setViewportView(TablaUsuario);

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 204, Short.MAX_VALUE))
        );

        BuscaUsuario.setToolTipText("Buscar a un Usuario!!");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Buscar Usuario");

        BuscarUsuario.setText("Buscar");
        BuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JframeconsultausuarioLayout = new javax.swing.GroupLayout(Jframeconsultausuario.getContentPane());
        Jframeconsultausuario.getContentPane().setLayout(JframeconsultausuarioLayout);
        JframeconsultausuarioLayout.setHorizontalGroup(
            JframeconsultausuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JframeconsultausuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame3)
                .addContainerGap())
            .addGroup(JframeconsultausuarioLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(BuscaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BuscarUsuario)
                .addContainerGap(592, Short.MAX_VALUE))
        );
        JframeconsultausuarioLayout.setVerticalGroup(
            JframeconsultausuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JframeconsultausuarioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(JframeconsultausuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarUsuario)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );

        jTabbedPane1.addTab("CONSULTA CUENTA DE USUARIO", Jframeconsultausuario);

        Jframeconsultaimpresora.setVisible(true);
        Jframeconsultaimpresora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JframeconsultaimpresoraMouseEntered(evt);
            }
        });

        jInternalFrame2.setVisible(true);

        TablaImpresora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(TablaImpresora);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTextImpresora.setToolTipText("Buscar Impresoras");
        jTextImpresora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextImpresoraKeyTyped(evt);
            }
        });

        BuscarImpresora.setText("buscar");
        BuscarImpresora.setEnabled(false);
        BuscarImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarImpresoraActionPerformed(evt);
            }
        });

        MostrarTodoImpresora.setText("mostrar todo");
        MostrarTodoImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarTodoImpresoraActionPerformed(evt);
            }
        });

        GuardarImpresora.setText("guardar cambios");
        GuardarImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarImpresoraActionPerformed(evt);
            }
        });

        jRadioNSerie.setText("serie");
        jRadioNSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNSerieActionPerformed(evt);
            }
        });

        jRadioConexion.setText("conexion");
        jRadioConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioConexionActionPerformed(evt);
            }
        });

        EditarImpresora.setText("Editar Tabla");
        EditarImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarImpresoraActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Buscar por:");

        javax.swing.GroupLayout JframeconsultaimpresoraLayout = new javax.swing.GroupLayout(Jframeconsultaimpresora.getContentPane());
        Jframeconsultaimpresora.getContentPane().setLayout(JframeconsultaimpresoraLayout);
        JframeconsultaimpresoraLayout.setHorizontalGroup(
            JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JframeconsultaimpresoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jRadioConexion)
                        .addComponent(MostrarTodoImpresora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GuardarImpresora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditarImpresora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioNSerie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JframeconsultaimpresoraLayout.createSequentialGroup()
                        .addComponent(jTextImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BuscarImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jInternalFrame2))
                .addContainerGap())
        );
        JframeconsultaimpresoraLayout.setVerticalGroup(
            JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JframeconsultaimpresoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BuscarImpresora)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JframeconsultaimpresoraLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jRadioNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioConexion)
                        .addGap(27, 27, 27)
                        .addComponent(MostrarTodoImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(EditarImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GuardarImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
        );

        jTabbedPane1.addTab("CONSULTA IMPRESORA", Jframeconsultaimpresora);

        jframetareas.setMinimumSize(new java.awt.Dimension(1366, 600));
        jframetareas.setPreferredSize(new java.awt.Dimension(1366, 600));
        jframetareas.setVisible(true);

        radioEduardo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioEduardo.setText("Eduardo Mora");
        radioEduardo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEduardoActionPerformed(evt);
            }
        });

        radioCarlos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioCarlos.setText("Carlos Lopez");

        radioCristal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioCristal.setText("Cristal Montiel");

        radioHernandez.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioHernandez.setText("Carlos Hernandez");

        radioGrupal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioGrupal.setText("Grupal");

        radiopendientes.setText("PENDIENTES");
        radiopendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiopendientesActionPerformed(evt);
            }
        });

        radionuevatarea.setText("NUEVA TAREA");
        radionuevatarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radionuevatareaActionPerformed(evt);
            }
        });

        jDesktopPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pendientes.setTitle("Pendientes");
        Pendientes.setAlignmentX(0.0F);
        Pendientes.setVisible(true);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(jTable2);

        javax.swing.GroupLayout PendientesLayout = new javax.swing.GroupLayout(Pendientes.getContentPane());
        Pendientes.getContentPane().setLayout(PendientesLayout);
        PendientesLayout.setHorizontalGroup(
            PendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE)
        );
        PendientesLayout.setVerticalGroup(
            PendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        );

        jDesktopPane2.add(Pendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1103, 652));

        Tareas.setTitle("Tareas");
        Tareas.setAlignmentX(0.0F);
        Tareas.setAlignmentY(0.0F);
        Tareas.setVisible(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        javax.swing.GroupLayout TareasLayout = new javax.swing.GroupLayout(Tareas.getContentPane());
        Tareas.getContentPane().setLayout(TareasLayout);
        TareasLayout.setHorizontalGroup(
            TareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE)
        );
        TareasLayout.setVerticalGroup(
            TareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        jDesktopPane2.add(Tareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1103, 650));

        javax.swing.GroupLayout jframetareasLayout = new javax.swing.GroupLayout(jframetareas.getContentPane());
        jframetareas.getContentPane().setLayout(jframetareasLayout);
        jframetareasLayout.setHorizontalGroup(
            jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jframetareasLayout.createSequentialGroup()
                .addGroup(jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCarlos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioEduardo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioGrupal)
                    .addComponent(radiopendientes)
                    .addComponent(radioHernandez, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioCristal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radionuevatarea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jframetareasLayout.setVerticalGroup(
            jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jframetareasLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(radionuevatarea)
                .addGap(20, 20, 20)
                .addComponent(radiopendientes)
                .addGap(153, 153, 153)
                .addComponent(radioGrupal)
                .addGap(18, 18, 18)
                .addComponent(radioEduardo)
                .addGap(18, 18, 18)
                .addComponent(radioCarlos)
                .addGap(19, 19, 19)
                .addComponent(radioCristal)
                .addGap(18, 18, 18)
                .addComponent(radioHernandez)
                .addContainerGap(165, Short.MAX_VALUE))
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("TAREAS", jframetareas);

        jframeRespaldo.setVisible(true);

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RespaldoUsuarios.setTitle("Respaldo Usuario");
        RespaldoUsuarios.setAlignmentX(0.0F);
        RespaldoUsuarios.setAlignmentY(0.0F);
        RespaldoUsuarios.setVisible(true);

        TablaRespaldoUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane9.setViewportView(TablaRespaldoUsuarios);

        javax.swing.GroupLayout RespaldoUsuariosLayout = new javax.swing.GroupLayout(RespaldoUsuarios.getContentPane());
        RespaldoUsuarios.getContentPane().setLayout(RespaldoUsuariosLayout);
        RespaldoUsuariosLayout.setHorizontalGroup(
            RespaldoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
            .addGroup(RespaldoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE))
        );
        RespaldoUsuariosLayout.setVerticalGroup(
            RespaldoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
            .addGroup(RespaldoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
        );

        jDesktopPane1.add(RespaldoUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1065, 656));

        RespaldoImpresora.setTitle("Respaldo Impresora");
        RespaldoImpresora.setVisible(true);

        TablaRespaldoImpresora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane8.setViewportView(TablaRespaldoImpresora);

        javax.swing.GroupLayout RespaldoImpresoraLayout = new javax.swing.GroupLayout(RespaldoImpresora.getContentPane());
        RespaldoImpresora.getContentPane().setLayout(RespaldoImpresoraLayout);
        RespaldoImpresoraLayout.setHorizontalGroup(
            RespaldoImpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
        );
        RespaldoImpresoraLayout.setVerticalGroup(
            RespaldoImpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        jDesktopPane1.add(RespaldoImpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1065, 656));

        RespaldoCuentas.setTitle("Respaldo Cuentas");
        RespaldoCuentas.setVisible(true);

        TablaRespaldoCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(TablaRespaldoCuentas);

        javax.swing.GroupLayout RespaldoCuentasLayout = new javax.swing.GroupLayout(RespaldoCuentas.getContentPane());
        RespaldoCuentas.getContentPane().setLayout(RespaldoCuentasLayout);
        RespaldoCuentasLayout.setHorizontalGroup(
            RespaldoCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
        );
        RespaldoCuentasLayout.setVerticalGroup(
            RespaldoCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        jDesktopPane1.add(RespaldoCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1065, 656));

        RespaldoEquipos.setTitle("Respaldo Equipos");
        RespaldoEquipos.setVisible(true);

        TablasRespaldoEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18"
            }
        ));
        jScrollPane7.setViewportView(TablasRespaldoEquipos);

        javax.swing.GroupLayout RespaldoEquiposLayout = new javax.swing.GroupLayout(RespaldoEquipos.getContentPane());
        RespaldoEquipos.getContentPane().setLayout(RespaldoEquiposLayout);
        RespaldoEquiposLayout.setHorizontalGroup(
            RespaldoEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
        );
        RespaldoEquiposLayout.setVerticalGroup(
            RespaldoEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        );

        jDesktopPane1.add(RespaldoEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1065, 652));

        RUsuarios.setText("Respaldo Usuarios");
        RUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUsuariosActionPerformed(evt);
            }
        });

        REquipos.setText("Respaldo Equipos");
        REquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REquiposActionPerformed(evt);
            }
        });

        RCuentas.setText("Respaldo Cuentas");
        RCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCuentasActionPerformed(evt);
            }
        });

        RImpresora.setText("Respaldo Impresora");
        RImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RImpresoraActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Selecione el");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("respaldo a mostrar");

        javax.swing.GroupLayout jframeRespaldoLayout = new javax.swing.GroupLayout(jframeRespaldo.getContentPane());
        jframeRespaldo.getContentPane().setLayout(jframeRespaldoLayout);
        jframeRespaldoLayout.setHorizontalGroup(
            jframeRespaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jframeRespaldoLayout.createSequentialGroup()
                .addGroup(jframeRespaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jframeRespaldoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jframeRespaldoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jframeRespaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(REquipos)
                            .addComponent(RCuentas)
                            .addComponent(RImpresora)
                            .addComponent(RUsuarios)))
                    .addGroup(jframeRespaldoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jDesktopPane1))
        );
        jframeRespaldoLayout.setVerticalGroup(
            jframeRespaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jframeRespaldoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(RUsuarios)
                .addGap(18, 18, 18)
                .addComponent(REquipos)
                .addGap(18, 18, 18)
                .addComponent(RCuentas)
                .addGap(18, 18, 18)
                .addComponent(RImpresora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("RESPALDO", jframeRespaldo);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Total de equipos :");

        lblcontador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblcontador.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblcontadorAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblcontador.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                lblcontadorComponentShown(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblcontador, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_regresar)
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblcontador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        
        Login login = new Login();
        login.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void RadioSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioSerieActionPerformed
        
        if (RadioSerie.isSelected()== true){
            txtfbuscarequipo.setEnabled(true);
            
        }
    }//GEN-LAST:event_RadioSerieActionPerformed

    private void RadioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioNombreActionPerformed

        if (RadioNombre.isSelected()== true){
            txtfbuscarequipo.setEnabled(true);
        }
        
        
    }//GEN-LAST:event_RadioNombreActionPerformed

    private void RadioNNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioNNIActionPerformed
        
        if(RadioNNI.isSelected()== true){
            txtfbuscarequipo.setEnabled(true);
        
        }
        
    }//GEN-LAST:event_RadioNNIActionPerformed

    
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        
      //if(!"".equals(txtfbuscarequipo.getText())){
          if(RadioSerie.isSelected() == true){
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
         modelom = new DefaultTableModel();
            
        TablaMostrar.setModel(modelom);
        modelom.addColumn("serie compu");
        modelom.addColumn("piso");
        modelom.addColumn("area");
        modelom.addColumn("consultorio");
        modelom.addColumn("subarea");
        modelom.addColumn("nombre");
        modelom.addColumn("cuenta");
        modelom.addColumn("marca");
        modelom.addColumn("modelo");
        modelom.addColumn("mac");
        modelom.addColumn("nni");
        modelom.addColumn("ip");
        modelom.addColumn("direccion ip");
        modelom.addColumn("serie impresora");
        modelom.addColumn("id usuario");
            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from equipo " +
                    "where serie_compu = '" +txtfbuscarequipo.getText()+ "'");
                
                   if(rs.next()){
                   
                     modelom.addRow(new Object[]{rs.getString("serie_compu"), rs.getString("piso"), rs.getString("area"), 
                      rs.getString("consultorio"), rs.getString("subarea"), rs.getString("nombre"), rs.getString("cuenta"),
                      rs.getString("marca"), rs.getString("modelo"), rs.getString("mac"), rs.getString("nni"),
                      rs.getString("ip"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
                   else{
                       showMessageDialog(null, "No se encuentra en la base de datos!!!");
                       txtfbuscarequipo.setText("");
                     
                   }
                   /*modelom.addTableModelListener(new TableModelListener() {
                       
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        if(e.getType() == TableModelEvent.UPDATE){
                            int columna = e.getColumn();
                             int fila = e.getFirstRow();
                             if(columna == 1){
                                 String sql = "Update equipo set piso = '"+TablaMostrar.getValueAt(fila, columna)+"'";
                                 
                             }
                        }
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });*/
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
                    
      
      }else if(RadioNombre.isSelected() == true){
          Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
         modelom = new DefaultTableModel();
            
        TablaMostrar.setModel(modelom);
        modelom.addColumn("serie compu");
        modelom.addColumn("piso");
        modelom.addColumn("area");
        modelom.addColumn("consultorio");
        modelom.addColumn("subarea");
        modelom.addColumn("nombre");
        modelom.addColumn("cuenta");
        modelom.addColumn("marca");
        modelom.addColumn("modelo");
        modelom.addColumn("mac");
        modelom.addColumn("nni");
        modelom.addColumn("ip");
        modelom.addColumn("direccion ip");
        modelom.addColumn("serie impresora");
        modelom.addColumn("id usuario");
            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from equipo " +
                    "where nombre = '" +txtfbuscarequipo.getText()+ "'");
                
                   if(rs.next()){
                   
                     modelom.addRow(new Object[]{rs.getString("serie_compu"), rs.getString("piso"), rs.getString("area"), 
                      rs.getString("consultorio"), rs.getString("subarea"), rs.getString("nombre"), rs.getString("cuenta"),
                      rs.getString("marca"), rs.getString("modelo"), rs.getString("mac"), rs.getString("nni"),
                      rs.getString("ip"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
                   else{
                       showMessageDialog(null, "No se encuentra en la base de datos!!!");
                       txtfbuscarequipo.setText("");
                     
                   }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
                    
          
      }else if(RadioNNI.isSelected() == true){
          Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
         modelo = new DefaultTableModel();
            
        TablaMostrar.setModel(modelo);
        modelo.addColumn("serie compu");
        modelo.addColumn("piso");
        modelo.addColumn("area");
        modelo.addColumn("consultorio");
        modelo.addColumn("subarea");
        modelo.addColumn("nombre");
        modelo.addColumn("cuenta");
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        modelo.addColumn("mac");
        modelo.addColumn("nni");
        modelo.addColumn("ip");
        modelo.addColumn("direccion ip");
        modelo.addColumn("serie impresora");
        modelo.addColumn("id usuario");
            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from equipo " +
                    "where nni = '" +txtfbuscarequipo.getText()+ "'");
                
                   if(rs.next()){
                   
                     modelo.addRow(new Object[]{rs.getString("serie_compu"), rs.getString("piso"), rs.getString("area"), 
                      rs.getString("consultorio"), rs.getString("subarea"), rs.getString("nombre"), rs.getString("cuenta"),
                      rs.getString("marca"), rs.getString("modelo"), rs.getString("mac"), rs.getString("nni"),
                      rs.getString("ip"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
                   else{
                       showMessageDialog(null, "No se encuentra en la base de datos!!!");
                       txtfbuscarequipo.setText("");
                     
                   }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
                    
      }else if("".equals(txtfbuscarequipo.getText())){
            showMessageDialog(null, "Campo vacio");
        }
         
      //}
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
      
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelo = new DefaultTableModel();
            
        Tabla.setModel(modelo);
        modelo.addColumn("serie compu");
        modelo.addColumn("piso");
        modelo.addColumn("area");
        modelo.addColumn("consultorio");
        modelo.addColumn("subarea");
        modelo.addColumn("nombre");
        modelo.addColumn("cuenta");
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        modelo.addColumn("mac");
        modelo.addColumn("nni");
        modelo.addColumn("ip");
        modelo.addColumn("direccion ip");
        modelo.addColumn("serie impresora");
        modelo.addColumn("id usuario");
         
            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from equipo ");
                
                   for(int i = 0 ;rs.next(); i++){
                   
                     modelo.addRow(new Object[]{rs.getString("serie_compu"), rs.getString("piso"), rs.getString("area"), 
                      rs.getString("consultorio"), rs.getString("subarea"), rs.getString("nombre"), rs.getString("cuenta"),
                      rs.getString("marca"), rs.getString("modelo"), rs.getString("mac"), rs.getString("nni"),
                      rs.getString("ip"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getString("id_usuario")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
        
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

        TablaMostrar.setEnabled(false);
        botonEditar.setEnabled(true);
        botonActualizar.setEnabled(false);
        BotonMostrar.setEnabled(true);
        
         Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelom = new DefaultTableModel();
            
        TablaMostrar.setModel(modelom);
        modelom.addColumn("serie compu");
        modelom.addColumn("piso");
        modelom.addColumn("area");
        modelom.addColumn("consultorio");
        modelom.addColumn("subarea");
        modelom.addColumn("nombre");
        modelom.addColumn("cuenta");
        modelom.addColumn("marca");
        modelom.addColumn("modelo");
        modelom.addColumn("mac");
        modelom.addColumn("nni");
        modelom.addColumn("ip");
        modelom.addColumn("direccion ip");
        modelom.addColumn("serie impresora");
        modelom.addColumn("id usuario");
         
            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from equipo ");
                 
                if(rs.next()){
                    if(showConfirmDialog(new JFrame(), "Alerta!!"
                                + "\nDesea sobreecribir la informacion?", "Informacion", YES_NO_OPTION) == YES_OPTION){
                            stm.executeUpdate("Update equipo set serie_compu = '"+ rs.getString("serie_compu") +"'"
                                    + ", piso = '"+ rs.getString("piso") +"', area = '"+ rs.getString("area") +"'"
                                    + ", consultorio = '"+ rs.getString("consultorio") +"', subarea = '"+ rs.getString("subarea") + "'"
                                    + ", nombre = '"+ rs.getString("nombre") +"', cuenta = '" + rs.getString("cuenta") + "', marca = '"+ rs.getString("marca") +"'"
                                    + ", modelo = '"+ rs.getString("modelo") +"', mac = '" + rs.getString("mac") + "'"
                                    + ", nni = '"+ rs.getString("nni") +"', ip = '" + rs.getString("ip") + "'"
                                    + ", direccion_ip = '"+ rs.getString("direccion_ip") +"', serie_impresora = '" + rs.getString("serie_impresora") + "'"
                                    + ", id_usuario = '"+ rs.getInt("id_usuario") + "'"
                                    + ",where serie_compu = '"+ rs.getString("serie_compu") +"'");
                        }
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                   txtfbuscarequipo.setText("");
                }
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
        
        
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void BotonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMostrarActionPerformed
       
        Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
             
         modelom = new DefaultTableModel();
            
        TablaMostrar.setModel(modelom);
        modelom.addColumn("serie compu");
        modelom.addColumn("piso");
        modelom.addColumn("area");
        modelom.addColumn("consultorio");
        modelom.addColumn("subarea");
        modelom.addColumn("nombre");
        modelom.addColumn("cuenta");
        modelom.addColumn("marca");
        modelom.addColumn("modelo");
        modelom.addColumn("mac");
        modelom.addColumn("nni");
        modelom.addColumn("ip");
        modelom.addColumn("direccion ip");
        modelom.addColumn("serie impresora");
        modelom.addColumn("id usuario");
        
            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from equipo ");
                
                   for(int i= 0; rs.next(); i++){
                   
                     modelom.addRow(new Object[]{rs.getString("serie_compu"), rs.getString("piso"), rs.getString("area"), 
                      rs.getString("consultorio"), rs.getString("subarea"), rs.getString("nombre"), rs.getString("cuenta"),
                      rs.getString("marca"), rs.getString("modelo"), rs.getString("mac"), rs.getString("nni"),
                      rs.getString("ip"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
        
        
    }//GEN-LAST:event_BotonMostrarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        TablaMostrar.setEnabled(true);
        botonActualizar.setEnabled(true);
        botonEditar.setEnabled(false);
        BotonMostrar.setEnabled(false);
    }//GEN-LAST:event_botonEditarActionPerformed

    private void lblcontadorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblcontadorAncestorAdded
                
    }//GEN-LAST:event_lblcontadorAncestorAdded

    private void lblcontadorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_lblcontadorComponentShown
         Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion(); 
             

            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select count(serie_compu) from equipo ");
                  if(rs.next()){
                      String contador = rs.getString("count(serie_compu)");
                      lblcontador.setText(contador);
                  }
                   
                   
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
    }//GEN-LAST:event_lblcontadorComponentShown

    private void radioEduardoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEduardoActionPerformed
       
        if (radioEduardo.isSelected()== true){
            botonActualizar.setEnabled(true);
            txtfbuscarequipo.setEnabled(true);
            txtfbuscarequipo.setEditable(true);
            botonBuscar.setEnabled(true);
            
        }        
        
    }//GEN-LAST:event_radioEduardoActionPerformed

    private void radionuevatareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radionuevatareaActionPerformed
        
        if (radionuevatarea.isSelected()== true){
            Tareas.setVisible(true);
            Pendientes.setVisible(false);
            radioEduardo.setVisible(true);
            radioCarlos.setVisible(true);
            radioCristal.setVisible(true);
            radioHernandez.setVisible(true);
            radioGrupal.setVisible(true);
        }     
        
    }//GEN-LAST:event_radionuevatareaActionPerformed

    private void radiopendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiopendientesActionPerformed
       
        if (radiopendientes.isSelected()== true){
            Pendientes.setVisible(true);
            Tareas.setVisible(false);
            radioEduardo.setVisible(true);
            radioCarlos.setVisible(true);
            radioCristal.setVisible(true);
            radioHernandez.setVisible(true);
            radioGrupal.setVisible(true);
        }     
        
    }//GEN-LAST:event_radiopendientesActionPerformed

    private void MostrarTodoImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarTodoImpresoraActionPerformed
      
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelo = new DefaultTableModel();
            
        TablaImpresora.setModel(modelo);
        modelo.addColumn("Serie Impresora");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Conexion");
         
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from impresora ");
                
                   for(int i = 0 ;rs.next(); i++){
                   
                     modelo.addRow(new Object[]{rs.getString("serie_impresora"), rs.getString("marca"), rs.getString("modelo"), 
                      rs.getString("conexion")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
              
    }//GEN-LAST:event_MostrarTodoImpresoraActionPerformed

    private void jRadioNSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNSerieActionPerformed
        
        if (jRadioNSerie.isSelected()== true){
            jTextImpresora.setEnabled(true);
            
        }
    }//GEN-LAST:event_jRadioNSerieActionPerformed

    private void jRadioConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioConexionActionPerformed

        if (jRadioConexion.isSelected()== true){
            jTextImpresora.setEnabled(true);
            
        }
    }//GEN-LAST:event_jRadioConexionActionPerformed

    private void JfactualizainventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JfactualizainventarioMouseEntered
        RadioSerie.transferFocus();
    }//GEN-LAST:event_JfactualizainventarioMouseEntered

    private void JframeconsultaimpresoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JframeconsultaimpresoraMouseEntered
        jRadioNSerie.transferFocus();
    }//GEN-LAST:event_JframeconsultaimpresoraMouseEntered

    private void BuscarImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarImpresoraActionPerformed
        
        if(jRadioNSerie.isSelected() == true){
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
         modelo = new DefaultTableModel();
            
        TablaImpresora.setModel(modelo);
        modelo.addColumn("serie impresora");
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        modelo.addColumn("conexion");
          TablaMostrar.setEnabled(true);
            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from impresora " +
                    "where serie_impresora = '" +jTextImpresora.getText()+ "'");
                
                   if(rs.next()){
                   
                     modelo.addRow(new Object[]{rs.getString("serie_impresora"), rs.getString("marca"), rs.getString("modelo"), 
                      rs.getString("conexion")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
                   else{
                       showMessageDialog(null, "No se encuentra en la base de datos!!!");
                       txtfbuscarequipo.setText("");
                     
                   }
                   /*modelom.addTableModelListener(new TableModelListener() {
                       
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        if(e.getType() == TableModelEvent.UPDATE){
                            int columna = e.getColumn();
                             int fila = e.getFirstRow();
                             if(columna == 1){
                                 String sql = "Update equipo set piso = '"+TablaMostrar.getValueAt(fila, columna)+"'";
                                 
                             }
                        }
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });*/
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
                    
      
      }
   else if(jRadioConexion.isSelected() == true){
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
         modelo = new DefaultTableModel();
            
        TablaMostrar.setModel(modelo);
        modelo.addColumn("serie impresora");
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        modelo.addColumn("conexion");

            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from impresora " +
                    "where conexion = '" +jTextImpresora.getText()+ "'");
                
                   if(rs.next()){
                   
                     modelo.addRow(new Object[]{rs.getString("serie_impresora"), rs.getString("marca"), rs.getString("modelo"), 
                      rs.getString("conexion")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
                   else{
                       showMessageDialog(null, "No se encuentra en la base de datos!!!");
                       txtfbuscarequipo.setText("");
                     
                   }
                   /*modelom.addTableModelListener(new TableModelListener() {
                       
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        if(e.getType() == TableModelEvent.UPDATE){
                            int columna = e.getColumn();
                             int fila = e.getFirstRow();
                             if(columna == 1){
                                 String sql = "Update equipo set piso = '"+TablaMostrar.getValueAt(fila, columna)+"'";
                                 
                             }
                        }
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });*/
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
                    
      
      }
    }//GEN-LAST:event_BuscarImpresoraActionPerformed

    private void GuardarImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarImpresoraActionPerformed

        TablaImpresora.setEnabled(false);
         
         Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelo = new DefaultTableModel();
            
        TablaMostrar.setModel(modelo);
        modelo.addColumn("serie impresora");
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        modelo.addColumn("conexion");            
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from impresora ");
                 
                if(rs.next()){
                    if(showConfirmDialog(new JFrame(), "Alerta!!"
                                + "\nDesea sobreecribir la informacion?", "Informacion", YES_NO_OPTION) == YES_OPTION){
                            stm.executeUpdate("Update equipo set serie_impresora = '"+ rs.getString("serie_impresora") +"'"
                                    + ", marca = '"+ rs.getString("marca") +"', modelo = '"+ rs.getString("modelo") +"'"
                                    + ", conexion = '"+ rs.getString("conexion") +"'");
                        }
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                   jTextImpresora.setText("");
                }
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
        
        
    }//GEN-LAST:event_GuardarImpresoraActionPerformed

    private void EditarImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarImpresoraActionPerformed
        GuardarImpresora.setEnabled(true);
        TablaImpresora.setEnabled(true);
    }//GEN-LAST:event_EditarImpresoraActionPerformed

    private void BuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarUsuarioActionPerformed

            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
         modelo = new DefaultTableModel();
            
        TablaUsuario.setModel(modelo);
        modelo.addColumn("cuenta de usuario");
        modelo.addColumn("serie compu");
        modelo.addColumn("piso");
        modelo.addColumn("area");
        modelo.addColumn("nombre del equipo");            
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from equipos " +
                    "where cuenta = '" +BuscaUsuario.getText()+ "'");
                
                   if(rs.next()){
                   
                     modelo.addRow(new Object[]{rs.getString("cuenta"), rs.getString("serie_compu"), rs.getString("piso"), 
                      rs.getString("area"),rs.getString("nombre"),rs.getString("marca"),rs.getString("modelo")});
                        //JOptionPane.showMessageDialog(null, "El alumno ya tiene registrada una modalidad","Información",JOptionPane.INFORMATION_MESSAGE);
                    //Tabla.setColumnModel().setText(rs.getString("id_cliente"));
                }
                   else{
                       showMessageDialog(null, "No se encuentra en la base de datos!!!");
                       BuscaUsuario.setText("");
                     
                   }
                   /*modelom.addTableModelListener(new TableModelListener() {
                       
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        if(e.getType() == TableModelEvent.UPDATE){
                            int columna = e.getColumn();
                             int fila = e.getFirstRow();
                             if(columna == 1){
                                 String sql = "Update equipo set piso = '"+TablaMostrar.getValueAt(fila, columna)+"'";
                                 
                             }
                        }
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });*/
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
                      
    }//GEN-LAST:event_BuscarUsuarioActionPerformed

    private void RUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUsuariosActionPerformed
        RespaldoUsuarios.setVisible(true);
        
        RespaldoImpresora.setVisible(false);
        RespaldoEquipos.setVisible(false);
        RespaldoCuentas.setVisible(false);
    }//GEN-LAST:event_RUsuariosActionPerformed

    private void REquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REquiposActionPerformed
        RespaldoEquipos.setVisible(true);
        
        RespaldoUsuarios.setVisible(false);
        RespaldoImpresora.setVisible(false);
        RespaldoCuentas.setVisible(false);    
    }//GEN-LAST:event_REquiposActionPerformed

    private void RCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCuentasActionPerformed
        RespaldoCuentas.setVisible(true);
        
        RespaldoUsuarios.setVisible(false);
        RespaldoImpresora.setVisible(false);
        RespaldoEquipos.setVisible(false);        
    }//GEN-LAST:event_RCuentasActionPerformed

    private void RImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RImpresoraActionPerformed
        RespaldoImpresora.setVisible(true);
        
        RespaldoUsuarios.setVisible(false);
        RespaldoEquipos.setVisible(false);
        RespaldoCuentas.setVisible(false);        
    }//GEN-LAST:event_RImpresoraActionPerformed

    private void txtfbuscarequipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfbuscarequipoKeyTyped
        int evitador_de_espacios;
        evitador_de_espacios = evt.getKeyCode();
        if(txtfbuscarequipo.equals(" ") || evitador_de_espacios == 32){
            botonBuscar.setEnabled(false);
        }
        else{
            botonBuscar.setEnabled(true);
        }
    }//GEN-LAST:event_txtfbuscarequipoKeyTyped

    private void jTextImpresoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextImpresoraKeyTyped
        int evitador_de_espacios;
        evitador_de_espacios=evt.getKeyCode();
        if(jTextImpresora.equals(" ") || evitador_de_espacios == 32){
            BuscarImpresora.setEnabled(false);
        }
        else{
         BuscarImpresora.setEnabled(true);
        }
    }//GEN-LAST:event_jTextImpresoraKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         InsertarEquipo insertarequipo= new InsertarEquipo();
         insertarequipo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void formatoequipo(){
        Tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
        Tabla.getColumnModel().getColumn(1).setPreferredWidth(20);
        Tabla.getColumnModel().getColumn(2).setPreferredWidth(110);
        Tabla.getColumnModel().getColumn(3).setPreferredWidth(120);
        Tabla.getColumnModel().getColumn(4).setPreferredWidth(120);
        Tabla.getColumnModel().getColumn(5).setPreferredWidth(110);
        Tabla.getColumnModel().getColumn(6).setPreferredWidth(120);
        Tabla.getColumnModel().getColumn(7).setPreferredWidth(120);
        Tabla.getColumnModel().getColumn(8).setPreferredWidth(120);
        Tabla.getColumnModel().getColumn(9).setPreferredWidth(120);
        Tabla.getColumnModel().getColumn(10).setPreferredWidth(120);
        Tabla.getColumnModel().getColumn(11).setPreferredWidth(120);
    }
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonMostrar;
    private javax.swing.JTextField BuscaUsuario;
    private javax.swing.JButton BuscarImpresora;
    private javax.swing.JButton BuscarUsuario;
    private javax.swing.JButton EditarImpresora;
    private javax.swing.JButton GuardarImpresora;
    private javax.swing.JInternalFrame Jfactualizainventario;
    private javax.swing.JInternalFrame Jfconsultainventario;
    private javax.swing.JInternalFrame Jframeconsultaimpresora;
    private javax.swing.JInternalFrame Jframeconsultausuario;
    private javax.swing.JButton MostrarTodoImpresora;
    private javax.swing.JInternalFrame Pendientes;
    private javax.swing.JRadioButton RCuentas;
    private javax.swing.JRadioButton REquipos;
    private javax.swing.JRadioButton RImpresora;
    private javax.swing.JRadioButton RUsuarios;
    private javax.swing.JRadioButton RadioNNI;
    private javax.swing.JRadioButton RadioNombre;
    private javax.swing.JRadioButton RadioSerie;
    private javax.swing.JInternalFrame RespaldoCuentas;
    private javax.swing.JInternalFrame RespaldoEquipos;
    private javax.swing.JInternalFrame RespaldoImpresora;
    private javax.swing.JInternalFrame RespaldoUsuarios;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable TablaImpresora;
    private javax.swing.JTable TablaMostrar;
    private javax.swing.JTable TablaRespaldoCuentas;
    private javax.swing.JTable TablaRespaldoImpresora;
    private javax.swing.JTable TablaRespaldoUsuarios;
    private javax.swing.JTable TablaUsuario;
    private javax.swing.JTable TablasRespaldoEquipos;
    private javax.swing.JInternalFrame Tareas;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.ButtonGroup grupoImpresora;
    private javax.swing.ButtonGroup grupoRadios;
    private javax.swing.ButtonGroup grupoRespaldo;
    private javax.swing.ButtonGroup grupoUsuarios;
    private javax.swing.ButtonGroup grupotarea;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioConexion;
    private javax.swing.JRadioButton jRadioNSerie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextImpresora;
    private javax.swing.JInternalFrame jframeRespaldo;
    private javax.swing.JInternalFrame jframetareas;
    private javax.swing.JLabel lblcontador;
    private javax.swing.JRadioButton radioCarlos;
    private javax.swing.JRadioButton radioCristal;
    private javax.swing.JRadioButton radioEduardo;
    private javax.swing.JRadioButton radioGrupal;
    private javax.swing.JRadioButton radioHernandez;
    private javax.swing.JRadioButton radionuevatarea;
    private javax.swing.JRadioButton radiopendientes;
    private javax.swing.JTextField txtfbuscarequipo;
    // End of variables declaration//GEN-END:variables
}
