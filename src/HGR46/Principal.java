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
import java.util.Date;
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
        TablaImpresora.setEnabled(true);
        grupoRadios.add(RadioNombre);
        grupoRadios.add(RadioNNI);
        grupoUsuarios.add(radioEduardo);
        grupoUsuarios.add(radioCarlos);
        grupoUsuarios.add(radioCristal);
        grupoUsuarios.add(radioHernandez);
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
        lbl_contadorusuarios.setVisible(true);
        lbl_contadorimpresoras.setVisible(true);
        radioEduardo.setVisible(false);
        radioCarlos.setVisible(false);
        radioCristal.setVisible(false);
        radioHernandez.setVisible(false);
        Pendientes.setVisible(false);
        jTextImpresora.setEnabled(false);
        TablaImpresora.setEnabled(false);
        EditarImpresoras.setEnabled(false);
        RespaldoUsuarios.setVisible(false);
        RespaldoImpresora.setVisible(false);
        RespaldoEquipos.setVisible(false);
        RespaldoCuentas.setVisible(false);
        AsignarTarea.setVisible(false);
        lblfecha.setVisible(false);
        lbldescripcion.setVisible(false);
        txtDescripcion.setVisible(false);
        btnInsertarTarea.setVisible(false);
        btnCancelarTarea.setVisible(false);
        datefecha.setVisible(false);
        txtIdusuario.setVisible(false);
        lblusu.setVisible(false);
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
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select count(cuenta_usuario) from cuenta");
                  if(rs.next()){
                      String contador = rs.getString("count(cuenta_usuario)");
                      lbl_contadorusuarios.setText(contador + "");
                  }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select count(serie_impresora) from impresora");
                  if(rs.next()){
                      String contador = rs.getString("count(serie_impresora)");
                      lbl_contadorimpresoras.setText(contador + "");
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
        modelom.addColumn("dhcp");
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
                      rs.getString("dhcp"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
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
        jLabel11 = new javax.swing.JLabel();
        lbl_contadorusuarios = new javax.swing.JLabel();
        Jframeconsultaimpresora = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaImpresora = new javax.swing.JTable();
        jTextImpresora = new javax.swing.JTextField();
        BuscarImpresora = new javax.swing.JButton();
        MostrarTodoImpresora = new javax.swing.JButton();
        EditarImpresoras = new javax.swing.JButton();
        jRadioNSerie = new javax.swing.JRadioButton();
        jRadioConexion = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_contadorimpresoras = new javax.swing.JLabel();
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
        jframetareas = new javax.swing.JInternalFrame();
        radioEduardo = new javax.swing.JRadioButton();
        radioCarlos = new javax.swing.JRadioButton();
        radioCristal = new javax.swing.JRadioButton();
        radioHernandez = new javax.swing.JRadioButton();
        radiopendientes = new javax.swing.JRadioButton();
        radionuevatarea = new javax.swing.JRadioButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        Pendientes = new javax.swing.JInternalFrame();
        jScrollPane10 = new javax.swing.JScrollPane();
        TablaPendientes = new javax.swing.JTable();
        AsignarTarea = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        lbldescripcion = new javax.swing.JLabel();
        btnInsertarTarea = new javax.swing.JButton();
        btnCancelarTarea = new javax.swing.JButton();
        lblfecha = new javax.swing.JLabel();
        lblusu = new javax.swing.JLabel();
        txtIdusuario = new javax.swing.JTextField();
        datefecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        lblcontador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
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
                .addGap(0, 81, Short.MAX_VALUE))
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
        txtfbuscarequipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfbuscarequipoActionPerformed(evt);
            }
        });
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
                        .addContainerGap(262, Short.MAX_VALUE))
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaUsuario.getTableHeader().setReorderingAllowed(false);
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
                .addGap(0, 1158, Short.MAX_VALUE))
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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Total de Usuarios :");

        lbl_contadorusuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_contadorusuarios.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lbl_contadorusuariosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lbl_contadorusuarios.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                lbl_contadorusuariosComponentShown(evt);
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
                .addGap(118, 118, 118)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_contadorusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        JframeconsultausuarioLayout.setVerticalGroup(
            JframeconsultausuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JframeconsultausuarioLayout.createSequentialGroup()
                .addGroup(JframeconsultausuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JframeconsultausuarioLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(JframeconsultausuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BuscaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarUsuario)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JframeconsultausuarioLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_contadorusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
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
        TablaImpresora.setCellSelectionEnabled(true);
        jScrollPane5.setViewportView(TablaImpresora);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
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

        EditarImpresoras.setText("Editar Impresoras");
        EditarImpresoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarImpresorasActionPerformed(evt);
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Buscar por:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Total de Impresoras:");

        lbl_contadorimpresoras.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_contadorimpresoras.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lbl_contadorimpresorasAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lbl_contadorimpresoras.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                lbl_contadorimpresorasComponentShown(evt);
            }
        });

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
                        .addComponent(EditarImpresoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioNSerie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JframeconsultaimpresoraLayout.createSequentialGroup()
                        .addComponent(jTextImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BuscarImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(347, 347, 347)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_contadorimpresoras, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jInternalFrame2))
                .addContainerGap())
        );
        JframeconsultaimpresoraLayout.setVerticalGroup(
            JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JframeconsultaimpresoraLayout.createSequentialGroup()
                .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JframeconsultaimpresoraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BuscarImpresora)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(lbl_contadorimpresoras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JframeconsultaimpresoraLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jRadioNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioConexion)
                        .addGap(27, 27, 27)
                        .addComponent(MostrarTodoImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(EditarImpresoras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
        );

        jTabbedPane1.addTab("CONSULTA IMPRESORA", Jframeconsultaimpresora);

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
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
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
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(RespaldoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
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
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
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
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        jDesktopPane1.add(RespaldoCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1065, 656));

        RespaldoEquipos.setTitle("Respaldo Equipos");
        RespaldoEquipos.setVisible(true);

        TablasRespaldoEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17"
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
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
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
                .addContainerGap(369, Short.MAX_VALUE))
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("RESPALDO", jframeRespaldo);

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
        radioCarlos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCarlosActionPerformed(evt);
            }
        });

        radioCristal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioCristal.setText("Cristal Montiel");
        radioCristal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCristalActionPerformed(evt);
            }
        });

        radioHernandez.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioHernandez.setText("Carlos Hernandez");
        radioHernandez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioHernandezActionPerformed(evt);
            }
        });

        radiopendientes.setText("TAREAS PENDIENTES");
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
        Pendientes.setEnabled(false);
        Pendientes.setVisible(true);

        TablaPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(TablaPendientes);

        javax.swing.GroupLayout PendientesLayout = new javax.swing.GroupLayout(Pendientes.getContentPane());
        Pendientes.getContentPane().setLayout(PendientesLayout);
        PendientesLayout.setHorizontalGroup(
            PendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
        );
        PendientesLayout.setVerticalGroup(
            PendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PendientesLayout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPane2.add(Pendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        AsignarTarea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AsignarTarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecciona usuario...", "Eduardo Mora", "Carlos Lopez", "Cristal Montiel", "Carlos Hernandez" }));
        AsignarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarTareaActionPerformed(evt);
            }
        });
        AsignarTarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AsignarTareaKeyPressed(evt);
            }
        });

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        lbldescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbldescripcion.setText("Descripcion:");

        btnInsertarTarea.setText("Insertar");
        btnInsertarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarTareaActionPerformed(evt);
            }
        });

        btnCancelarTarea.setText("Cancelar");
        btnCancelarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTareaActionPerformed(evt);
            }
        });

        lblfecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblfecha.setText("Fecha Automatica:");

        lblusu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblusu.setText("ID Usuario:");

        javax.swing.GroupLayout jframetareasLayout = new javax.swing.GroupLayout(jframetareas.getContentPane());
        jframetareas.getContentPane().setLayout(jframetareasLayout);
        jframetareasLayout.setHorizontalGroup(
            jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jframetareasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCarlos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioEduardo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioHernandez, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(radioCristal, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addGroup(jframetareasLayout.createSequentialGroup()
                        .addGroup(jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(radiopendientes)
                            .addComponent(radionuevatarea)
                            .addComponent(lbldescripcion)
                            .addGroup(jframetareasLayout.createSequentialGroup()
                                .addComponent(btnInsertarTarea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelarTarea))
                            .addComponent(lblfecha)
                            .addComponent(txtDescripcion)
                            .addComponent(AsignarTarea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jframetareasLayout.createSequentialGroup()
                                .addComponent(lblusu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdusuario))
                            .addComponent(datefecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jframetareasLayout.setVerticalGroup(
            jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jframetareasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(radionuevatarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AsignarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusu)
                    .addComponent(txtIdusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblfecha)
                .addGap(2, 2, 2)
                .addComponent(datefecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarTarea)
                    .addComponent(btnCancelarTarea))
                .addGap(18, 18, 18)
                .addComponent(radiopendientes)
                .addGap(33, 33, 33)
                .addComponent(radioEduardo)
                .addGap(18, 18, 18)
                .addComponent(radioCarlos)
                .addGap(19, 19, 19)
                .addComponent(radioCristal)
                .addGap(18, 18, 18)
                .addComponent(radioHernandez)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("TAREAS", jframetareas);

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
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_regresar)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcontador, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblcontador, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        modelom.addColumn("dhcp");
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
                      rs.getString("dhcp"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
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
        modelom.addColumn("dhcp");
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
                      rs.getString("dhcp"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
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
        modelo.addColumn("dhcp");
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
                      rs.getString("dhcp"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
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
        modelo.addColumn("dhcp");
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
                      rs.getString("dhcp"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getString("id_usuario")});
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
        modelom.addColumn("dhcp");
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
                                    + ", nni = '"+ rs.getString("nni") +"', dhcp = '" + rs.getString("dhcp") + "'"
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
        modelom.addColumn("dhcp");
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
                      rs.getString("dhcp"), rs.getString("direccion_ip"), rs.getString("serie_impresora"), rs.getInt("id_usuario")});
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
                      lblcontador.setText(contador + "");
                  }
                   
                   
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select count(cuenta_usuario) from cuenta");
                  if(rs.next()){
                      String contador = rs.getString("count(cuenta_usuario)");
                      lbl_contadorusuarios.setText(contador + "");
                      //lbl_contadorusuarios.setText();
                  }
                   
                   
                   
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select count(serie_impresora) from impresora");
                  if(rs.next()){
                      String contador = rs.getString("count(serie_impresora)");
                      lbl_contadorimpresoras.setText(contador + "");
                      //lbl_contadorusuarios.setText();
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

    private void CargarTareasEduardo(){
        
        Conexion con = new Conexion();
        Statement stmt=null; 
        ResultSet rs = null;
       
        DefaultTableModel modelo= new DefaultTableModel();
        
        TablaPendientes.setModel(modelo);
        modelo.addColumn("Id_Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripcion");
        
        try {    
            stmt = con.getConnection().createStatement();
            
            rs = stmt.executeQuery("SELECT *FROM tareas WHERE nombre like '%Eduardo%' ");
            
            for(int i=0; rs.next();i++ ){
                
                modelo.addRow(new Object[]{rs.getInt("id_usuario"),rs.getString("nombre"),rs.getString("fecha"),rs.getString("descripcion")});
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "sss ");
        }
        
        try{
            stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    private void CargarTareasCarlos(){
        
        Conexion con = new Conexion();
        Statement stmt=null; 
        ResultSet res = null;
        
        DefaultTableModel modelo= new DefaultTableModel();
        
        TablaPendientes.setModel(modelo);
        modelo.addColumn("Id_Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripcion");
        
        try {    
            stmt = con.getConnection().createStatement();
            
            res = stmt.executeQuery("SELECT *FROM tareas WHERE nombre like '%Lopez%' ");
            
            for(int i=0; res.next();i++ ){
                
                modelo.addRow(new Object[]{res.getString("id_usuario"),res.getString("nombre"),res.getString("fecha"),res.getString("descripcion")});
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "sss ");
        }
        
        try{
            stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void CargarTareasCristal(){
        
        Conexion con = new Conexion();
        Statement stmt=null; 
        ResultSet res = null;
        
        DefaultTableModel modelo= new DefaultTableModel();
        
        TablaPendientes.setModel(modelo);
        modelo.addColumn("Id_Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripcion");
        
        try {    
            stmt = con.getConnection().createStatement();
            
            res = stmt.executeQuery("SELECT *FROM tareas WHERE nombre like '%Cristal%' ");
            
            for(int i=0; res.next();i++ ){
                
                modelo.addRow(new Object[]{res.getString("id_usuario"),res.getString("nombre"),res.getString("fecha"),res.getString("descripcion")});
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "sss ");
        }
        
        try{
            stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void CargarTareasHernandez(){
        
        Conexion con = new Conexion();
        Statement stmt=null; 
        ResultSet res = null;
        
        DefaultTableModel modelo= new DefaultTableModel();
        
        TablaPendientes.setModel(modelo);
        modelo.addColumn("Id_Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripcion");
        
        try {    
            stmt = con.getConnection().createStatement();
            
            res = stmt.executeQuery("SELECT *FROM tareas WHERE nombre like '%Hernandez%' ");
            
            for(int i=0; res.next();i++ ){
                
                modelo.addRow(new Object[]{res.getString("id_usuario"),res.getString("nombre"),res.getString("fecha"),res.getString("descripcion")});
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "sss ");
        }
        
        try{
            stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void CargarTareas(){
        
        Conexion con = new Conexion();
        Statement stmt=null; 
        ResultSet res = null;
        
        DefaultTableModel modelo= new DefaultTableModel();
        
        TablaPendientes.setModel(modelo);
        modelo.addColumn("Id_Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripcion");
        
        try {    
            stmt = con.getConnection().createStatement();
            
            res = stmt.executeQuery("SELECT *FROM tareas");
            
            for(int i=0; res.next();i++ ){
                
                modelo.addRow(new Object[]{res.getString("id_usuario"),res.getString("nombre"),res.getString("fecha"),res.getString("descripcion")});
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "sss ");
        }
        
        try{
            stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void radioEduardoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEduardoActionPerformed
       
        CargarTareasEduardo();    
        
    }//GEN-LAST:event_radioEduardoActionPerformed

    private void radionuevatareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radionuevatareaActionPerformed
        
        if (radionuevatarea.isSelected()== true){
            Pendientes.setVisible(false);
            radioEduardo.setVisible(false);
            radioCarlos.setVisible(false);
            radioCristal.setVisible(false);
            radioHernandez.setVisible(false);
            AsignarTarea.setVisible(true);
        }     
        
    }//GEN-LAST:event_radionuevatareaActionPerformed

    private void radiopendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiopendientesActionPerformed
       
        if (radiopendientes.isSelected()== true){
            Pendientes.setVisible(true);
            radioEduardo.setVisible(true);
            radioCarlos.setVisible(true);
            radioCristal.setVisible(true);
            radioHernandez.setVisible(true);
            AsignarTarea.setVisible(false);
            ocultar();
        }     
        CargarTareas();
        
    }//GEN-LAST:event_radiopendientesActionPerformed

    private void MostrarTodoImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarTodoImpresoraActionPerformed
      
        EditarImpresoras.setEnabled(true);
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelo = new DefaultTableModel();
        TablaImpresora.setEnabled(true);
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

    private void EditarImpresorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarImpresorasActionPerformed

        AgregarImpresoras agimpre = new AgregarImpresoras();
        
        agimpre.setVisible(true);
        
    }//GEN-LAST:event_EditarImpresorasActionPerformed

    private void BuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarUsuarioActionPerformed

        Conexion conex = null;
        Statement stm = null;
        ResultSet res = null;

        conex= new Conexion();
        modelo = new DefaultTableModel();
            
        TablaUsuario.setModel(modelo);
        modelo.addColumn("Cuenta de usuario");
        modelo.addColumn("Serie compu");
        modelo.addColumn("Piso");
        modelo.addColumn("Area");
        modelo.addColumn("Mombre del equipo");            
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        
            try {
                stm = conex.getConnection().createStatement();
                res = stm.executeQuery("SELECT *FROM equipo WHERE cuenta = '" +BuscaUsuario.getText()+ "'");
                
                for(int i=0; res.next();i++ )
                {
                modelo.addRow(new Object[]{res.getString("cuenta"),res.getString("serie_compu")
                ,res.getString("piso"),res.getString("area"),res.getString("nombre"),res.getString("marca"),res.getString("modelo")});
            
                }
            
                  
            } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "s");
        }
        try{
            stm.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BuscarUsuarioActionPerformed

    
    private void CargarTablaCuentas(){
        
        Conexion con = new Conexion();
        Statement stmt=null; 
        ResultSet res = null;
        
        DefaultTableModel modelo= new DefaultTableModel();
        
        TablaRespaldoCuentas.setModel(modelo);
        modelo.addColumn("Cuenta_Usuario");
        modelo.addColumn("Cuenta_Contrasena");
        modelo.addColumn("Fecha");
        modelo.addColumn("Accion");
    
        try {    
            stmt = con.getConnection().createStatement();
            
            res = stmt.executeQuery("SELECT *FROM cuenta_respaldo");
            
            for(int i=0; res.next();i++ ){
                
                modelo.addRow(new Object[]{res.getString("cuenta_usuario"),res.getString("cuenta_contrasena"),res.getString("fecha"),res.getString("accion")});
            
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "Clientes Mostrando");
        }
        
        try{
            stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void CargarTablaEquipos(){
        
        Conexion con = new Conexion();
        Statement stmt=null; 
        ResultSet res = null;
        
        DefaultTableModel modelo= new DefaultTableModel();
        
        TablasRespaldoEquipos.setModel(modelo);
        modelo.addColumn("Serie_Compu");
        modelo.addColumn("Piso");
        modelo.addColumn("Area");
        modelo.addColumn("Consultorio");
        modelo.addColumn("Subarea");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cuenta");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Mac");
        modelo.addColumn("Nni");
        modelo.addColumn("dhcp");
        modelo.addColumn("Direccion_Ip");
        modelo.addColumn("Serie_Impresora");
        modelo.addColumn("Id_Usuario");
        modelo.addColumn("Fecha");
        modelo.addColumn("Accion");
    
        try {    
            stmt = con.getConnection().createStatement();
            
            res = stmt.executeQuery("SELECT *FROM equipo_respaldo");
            
            for(int i=0; res.next();i++ ){
                
                modelo.addRow(new Object[]{res.getString("serie_compu"),res.getString("piso"),res.getString("area"),res.getString("consultorio")
                ,res.getString("subarea"),res.getString("nombre"),res.getString("cuenta"),res.getString("marca"),res.getString("modelo")
                ,res.getString("mac"),res.getString("nni"),res.getString("dhcp"),res.getString("direccion_ip"),res.getString("serie_impresora"),res.getInt("id_usuario")
                ,res.getString("fecha"),res.getString("accion")});
            
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "sss ");
        }
        
        try{
            stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void CargarTablaImpresoras(){
        
        Conexion con = new Conexion();
        Statement stmt=null; 
        ResultSet res = null;
        
        DefaultTableModel modelo= new DefaultTableModel();
        
        TablaRespaldoImpresora.setModel(modelo);
        modelo.addColumn("Serie_Impresora");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Conexion");
        modelo.addColumn("Fecha");
        modelo.addColumn("Accion");
    
        try {    
            stmt = con.getConnection().createStatement();
            
            res = stmt.executeQuery("SELECT *FROM impresora_respaldo");
            
            for(int i=0; res.next();i++ ){
                
                modelo.addRow(new Object[]{res.getString("serie_impresora"),res.getString("marca")
                ,res.getString("modelo"),res.getString("conexion"),res.getString("fecha"),res.getString("accion")});
            
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "ssss");
        }
        
        try{
            stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
    private void CargarTablaUsuarios(){
        
        Conexion con = new Conexion();
        Statement stmt=null; 
        ResultSet res = null;
        
        DefaultTableModel modelo= new DefaultTableModel();
        
        TablaRespaldoUsuarios.setModel(modelo);
        modelo.addColumn("Nombre");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contrasena");
        modelo.addColumn("Tipo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Accion");
    
        try {    
            stmt = con.getConnection().createStatement();
            
            res = stmt.executeQuery("SELECT *FROM usuarios_respaldo");
            
            for(int i=0; res.next();i++ ){
                
                modelo.addRow(new Object[]{res.getString("nombre"),res.getString("usuario"),res.getString("contrasena"),res.getString("tipo"),res.getString("fecha"),res.getString("accion")});
            
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "dsdds");
        }
        
        try{
            stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
        
    
    private void RUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUsuariosActionPerformed
        RespaldoUsuarios.setVisible(true);
    
        RespaldoImpresora.setVisible(false);
        RespaldoEquipos.setVisible(false);
        RespaldoCuentas.setVisible(false);
        
        CargarTablaUsuarios();
    }//GEN-LAST:event_RUsuariosActionPerformed
    
    private void REquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REquiposActionPerformed
        RespaldoEquipos.setVisible(true);
        
        RespaldoUsuarios.setVisible(false);
        RespaldoImpresora.setVisible(false);
        RespaldoCuentas.setVisible(false);   
        
        CargarTablaEquipos();
    }//GEN-LAST:event_REquiposActionPerformed

    private void RCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCuentasActionPerformed
        RespaldoCuentas.setVisible(true);
        RespaldoUsuarios.setVisible(false);
        RespaldoImpresora.setVisible(false);
        RespaldoEquipos.setVisible(false);   
        CargarTablaCuentas();
    }//GEN-LAST:event_RCuentasActionPerformed

    private void RImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RImpresoraActionPerformed
        RespaldoImpresora.setVisible(true);
        RespaldoUsuarios.setVisible(false);
        RespaldoEquipos.setVisible(false);
        RespaldoCuentas.setVisible(false);  
        
        CargarTablaImpresoras();
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
         AgregarEquipo insertarequipo= new AgregarEquipo();
         insertarequipo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbl_contadorimpresorasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lbl_contadorimpresorasAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_contadorimpresorasAncestorAdded

    private void lbl_contadorimpresorasComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_lbl_contadorimpresorasComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_contadorimpresorasComponentShown

    private void lbl_contadorusuariosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lbl_contadorusuariosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_contadorusuariosAncestorAdded

    private void lbl_contadorusuariosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_lbl_contadorusuariosComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_contadorusuariosComponentShown

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        char c = evt.getKeyChar();
        if(txtDescripcion.getText().trim().length() == 50|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void btnCancelarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTareaActionPerformed
            
            txtDescripcion.setText("");
            datefecha.setDateFormatString("");
            AsignarTarea.setVisible(false);
            ocultar();
            
    }//GEN-LAST:event_btnCancelarTareaActionPerformed

    private void btnInsertarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarTareaActionPerformed
            
        
       if( txtDescripcion.getText().equals(""))
       {
           showMessageDialog(null,"Algun campo esta vacio");
           
       }else{Conexion conex = null;
        Statement stm = null;
        ResultSet rs = null;

            conex= new Conexion();

            try {
                stm = conex.getConnection().createStatement();

                stm.executeUpdate("INSERT INTO tareas (id_usuario,nombre,fecha,descripcion ) VALUES"
                        + "('"+txtIdusuario.getText()+"','"+AsignarTarea.getSelectedItem()+"','"+datefecha.getDate()+"','"+txtDescripcion.getText()+"')");
                
                txtDescripcion.setText("");
                datefecha.setDateFormatString("");
                AsignarTarea.setVisible(false);
                ocultar();
            
                showMessageDialog(null,"La tarea fue añadidacorrectamente");
                
            } catch (SQLException ex) {
                Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            conex.desconectar();
           
       }
        
        
    }//GEN-LAST:event_btnInsertarTareaActionPerformed

    private void AsignarTareaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AsignarTareaKeyPressed
        
        
           
           
    }//GEN-LAST:event_AsignarTareaKeyPressed

    private void ocultar(){
           
        lblfecha.setVisible(false);
        datefecha.setVisible(false);
        lbldescripcion.setVisible(false);
        txtDescripcion.setVisible(false);
        btnInsertarTarea.setVisible(false);
        btnCancelarTarea.setVisible(false);
        AsignarTarea.setSelectedIndex(0);
        txtIdusuario.setVisible(false);
        lblusu.setVisible(false);
    }
    private void mostrar(){
           
        lblfecha.setVisible(true);
        datefecha.setVisible(true);
        btnInsertarTarea.setVisible(true);
        btnCancelarTarea.setVisible(true);
        lbldescripcion.setVisible(true);
        txtDescripcion.setVisible(true);
        txtIdusuario.setVisible(true);
        lblusu.setVisible(true);
        datefecha.setEnabled(true);
    }
    
    
    
    private void AsignarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarTareaActionPerformed
        
        datefecha.setDateFormatString("d/mm/yyyy");
        lblusu.setVisible(true);
        txtIdusuario.setVisible(true);
        txtIdusuario.setEditable(false);
        
        
        if(AsignarTarea.getSelectedItem() == "selecciona usuario..."){
            txtIdusuario.setText("");
            ocultar();
        }else if(AsignarTarea.getSelectedItem() == "Eduardo Mora"){
            txtIdusuario.setText("1");
            mostrar();
        }else if(AsignarTarea.getSelectedItem() == "Carlos Lopez"){
            txtIdusuario.setText("2");
            mostrar();
        }else if(AsignarTarea.getSelectedItem() == "Cristal Montiel"){
            txtIdusuario.setText("3");
            mostrar();
        }else if(AsignarTarea.getSelectedItem() == "Carlos Hernandez"){
            txtIdusuario.setText("4");
            mostrar();
        }
        
        
        
    }//GEN-LAST:event_AsignarTareaActionPerformed

    private void radioCarlosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCarlosActionPerformed
        CargarTareasCarlos();
    }//GEN-LAST:event_radioCarlosActionPerformed

    private void radioCristalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCristalActionPerformed
        CargarTareasCristal();
    }//GEN-LAST:event_radioCristalActionPerformed

    private void radioHernandezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioHernandezActionPerformed
        CargarTareasHernandez();
    }//GEN-LAST:event_radioHernandezActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void datefechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datefechaMouseClicked
        
        
    }//GEN-LAST:event_datefechaMouseClicked

    private void datefechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datefechaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_datefechaMousePressed

    private void txtfbuscarequipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfbuscarequipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfbuscarequipoActionPerformed

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
    private javax.swing.JComboBox<String> AsignarTarea;
    private javax.swing.JButton BotonMostrar;
    private javax.swing.JTextField BuscaUsuario;
    private javax.swing.JButton BuscarImpresora;
    private javax.swing.JButton BuscarUsuario;
    private javax.swing.JButton EditarImpresoras;
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
    private javax.swing.JTable TablaPendientes;
    private javax.swing.JTable TablaRespaldoCuentas;
    private javax.swing.JTable TablaRespaldoImpresora;
    private javax.swing.JTable TablaRespaldoUsuarios;
    private javax.swing.JTable TablaUsuario;
    private javax.swing.JTable TablasRespaldoEquipos;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton btnCancelarTarea;
    private javax.swing.JButton btnInsertarTarea;
    private javax.swing.JButton btn_regresar;
    private com.toedter.calendar.JDateChooser datefecha;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextImpresora;
    private javax.swing.JInternalFrame jframeRespaldo;
    private javax.swing.JInternalFrame jframetareas;
    private javax.swing.JLabel lbl_contadorimpresoras;
    private javax.swing.JLabel lbl_contadorusuarios;
    private javax.swing.JLabel lblcontador;
    private javax.swing.JLabel lbldescripcion;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblusu;
    private javax.swing.JRadioButton radioCarlos;
    private javax.swing.JRadioButton radioCristal;
    private javax.swing.JRadioButton radioEduardo;
    private javax.swing.JRadioButton radioHernandez;
    private javax.swing.JRadioButton radionuevatarea;
    private javax.swing.JRadioButton radiopendientes;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdusuario;
    private javax.swing.JTextField txtfbuscarequipo;
    // End of variables declaration//GEN-END:variables
}
