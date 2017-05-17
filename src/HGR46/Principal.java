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
        txtfbuscarequipo.setEnabled(false);
        txtfbuscarequipo.setEditable(false);
        TablaMostrar.setEnabled(false);
        botonActualizar.setEnabled(false);
        lblcontador.setVisible(true);
        internalframetareas.setVisible(false);
        radioEduardo.setVisible(false);
        radioCarlos.setVisible(false);
        radioCristal.setVisible(false);
        radioHernandez.setVisible(false);
        radioGrupal.setVisible(false);
        internalframependientes.setVisible(false);
        jTextImpresora.setEnabled(false);
        TablaImpresora.setEnabled(false);
        GuardarImpresora.setEnabled(false);
       
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadios = new javax.swing.ButtonGroup();
        grupoUsuarios = new javax.swing.ButtonGroup();
        grupotarea = new javax.swing.ButtonGroup();
        grupoImpresora = new javax.swing.ButtonGroup();
        combox = new javax.swing.JComboBox<>();
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
        jPanel2 = new javax.swing.JPanel();
        internalframetareas = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        TAREAS = new javax.swing.JTable();
        internalframependientes = new javax.swing.JInternalFrame();
        radioCarlos = new javax.swing.JRadioButton();
        radioCristal = new javax.swing.JRadioButton();
        radioHernandez = new javax.swing.JRadioButton();
        radioGrupal = new javax.swing.JRadioButton();
        radiopendientes = new javax.swing.JRadioButton();
        radionuevatarea = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        lblcontador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));

        combox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        combox.setForeground(new java.awt.Color(0, 204, 204));
        combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INVENTARIO...", "Consulta de inventario", "Actualiza inventario", "Consulta de usuario", "Consulta impresora", "USUARIO...", "Cambiar contraseña" }));
        combox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboxMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboxMousePressed(evt);
            }
        });
        combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxActionPerformed(evt);
            }
        });

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
        txtfbuscarequipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfbuscarequipoActionPerformed(evt);
            }
        });

        botonActualizar.setText("Actualizar equipo");
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
        jInternalFrame1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jInternalFrame1PropertyChange(evt);
            }
        });

        jScrollPane3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jScrollPane3PropertyChange(evt);
            }
        });

        TablaMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        TablaMostrar.setCellSelectionEnabled(true);
        TablaMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TablaMostrar.setDropMode(javax.swing.DropMode.INSERT);
        TablaMostrar.setFocusable(false);
        TablaMostrar.setGridColor(new java.awt.Color(0, 153, 255));
        TablaMostrar.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TablaMostrar);

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
                            .addComponent(RadioNNI)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(BotonMostrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(txtfbuscarequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(botonBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(35, 35, 35)
                        .addComponent(botonActualizar)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfbuscarequipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizar)
                    .addComponent(botonBuscar)
                    .addComponent(jButton1))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(406, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

        jTabbedPane1.addTab("CONSULTA USUARIO", Jframeconsultausuario);

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

        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 600));

        internalframetareas.setTitle("TAREAS");
        internalframetareas.setPreferredSize(new java.awt.Dimension(1093, 600));
        internalframetareas.setVisible(true);

        TAREAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane4.setViewportView(TAREAS);

        javax.swing.GroupLayout internalframetareasLayout = new javax.swing.GroupLayout(internalframetareas.getContentPane());
        internalframetareas.getContentPane().setLayout(internalframetareasLayout);
        internalframetareasLayout.setHorizontalGroup(
            internalframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
        );
        internalframetareasLayout.setVerticalGroup(
            internalframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalframetareasLayout.createSequentialGroup()
                .addGap(620, 620, 620)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        internalframependientes.setTitle("PENDIENTES");
        internalframependientes.setMinimumSize(new java.awt.Dimension(1000, 600));
        internalframependientes.setOpaque(true);
        internalframependientes.setPreferredSize(new java.awt.Dimension(1000, 600));
        internalframependientes.setVisible(true);

        javax.swing.GroupLayout internalframependientesLayout = new javax.swing.GroupLayout(internalframependientes.getContentPane());
        internalframependientes.getContentPane().setLayout(internalframependientesLayout);
        internalframependientesLayout.setHorizontalGroup(
            internalframependientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        internalframependientesLayout.setVerticalGroup(
            internalframependientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(internalframetareas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 107, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addComponent(internalframependientes, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(internalframetareas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(internalframependientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

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

        javax.swing.GroupLayout jframetareasLayout = new javax.swing.GroupLayout(jframetareas.getContentPane());
        jframetareas.getContentPane().setLayout(jframetareasLayout);
        jframetareasLayout.setHorizontalGroup(
            jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jframetareasLayout.createSequentialGroup()
                .addGroup(jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCarlos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioEduardo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jframetareasLayout.createSequentialGroup()
                        .addGroup(jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioGrupal)
                            .addComponent(radiopendientes)
                            .addComponent(radionuevatarea)
                            .addComponent(radioHernandez, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioCristal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jframetareasLayout.setVerticalGroup(
            jframetareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jframetareasLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(radionuevatarea)
                .addGap(18, 18, 18)
                .addComponent(radiopendientes)
                .addGap(153, 153, 153)
                .addComponent(radioGrupal)
                .addGap(18, 18, 18)
                .addComponent(radioEduardo)
                .addGap(18, 18, 18)
                .addComponent(radioCarlos)
                .addGap(18, 18, 18)
                .addComponent(radioCristal)
                .addGap(18, 18, 18)
                .addComponent(radioHernandez)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jframetareasLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addGap(651, 651, 651))
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
                        .addGap(229, 229, 229)
                        .addComponent(combox, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblcontador, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_regresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxActionPerformed
       
    }//GEN-LAST:event_comboxActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        
        Login login = new Login();
        login.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void comboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboxMouseClicked
       
        if(combox.getSelectedIndex()== 1){
            Mostrarequipos mostrar = new Mostrarequipos();
            mostrar.setVisible(true);
            dispose();
        }
        else if(combox.getSelectedItem() == "Actualiza inventario"){
            Actualizainventario actualiza = new Actualizainventario();
            actualiza.setVisible(true);
            dispose();
        }
        else if(combox.getSelectedItem() == "Consulta de usuario"){
            Mostrarequipos mostrar = new Mostrarequipos();
            mostrar.setVisible(true);
            dispose();
        }
        else if(combox.getSelectedItem() == "Consulta impresora"){
            Mostrarequipos mostrar = new Mostrarequipos();
            mostrar.setVisible(true);
            dispose();
        }
        
    }//GEN-LAST:event_comboxMouseClicked

    private void comboxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboxMousePressed
        
       
        
    }//GEN-LAST:event_comboxMousePressed

    private void RadioSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioSerieActionPerformed
        
        if (RadioSerie.isSelected()== true){
            botonActualizar.setEnabled(true);
            txtfbuscarequipo.setEnabled(true);
            txtfbuscarequipo.setEditable(true);
            botonBuscar.setEnabled(true);
            
        }
    }//GEN-LAST:event_RadioSerieActionPerformed

    private void RadioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioNombreActionPerformed

        if (RadioNombre.isSelected()== true){
            botonActualizar.setEnabled(true);
            txtfbuscarequipo.setEnabled(true);
            txtfbuscarequipo.setEditable(true);
            botonBuscar.setEnabled(true);
            
        }
        
        
    }//GEN-LAST:event_RadioNombreActionPerformed

    private void txtfbuscarequipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfbuscarequipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfbuscarequipoActionPerformed

    private void RadioNNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioNNIActionPerformed
        
        if(RadioNNI.isSelected()== true){
            botonActualizar.setEnabled(true);
            txtfbuscarequipo.setEnabled(true);
            txtfbuscarequipo.setEditable(true);
            botonBuscar.setEnabled(true);
        
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
          TablaMostrar.setEnabled(true);
            
            
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
          TablaMostrar.setEnabled(true);
            
            
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
        TablaMostrar.setEnabled(true);
            
            
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
        TablaMostrar.setEnabled(true);
        
            
            
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
    }//GEN-LAST:event_botonEditarActionPerformed

    private void jScrollPane3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jScrollPane3PropertyChange
       
        Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelo = new DefaultTableModel();
            
        TablaUsuario.setModel(modelo);
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
            
        
    }//GEN-LAST:event_jScrollPane3PropertyChange

    private void jInternalFrame1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jInternalFrame1PropertyChange
        
        Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelo = new DefaultTableModel();
            
        TablaUsuario.setModel(modelo);
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
            
        
    }//GEN-LAST:event_jInternalFrame1PropertyChange

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
            internalframetareas.setVisible(true);
            internalframependientes.setVisible(false);
            radioEduardo.setVisible(true);
            radioCarlos.setVisible(true);
            radioCristal.setVisible(true);
            radioHernandez.setVisible(true);
            radioGrupal.setVisible(true);
        }     
        
    }//GEN-LAST:event_radionuevatareaActionPerformed

    private void radiopendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiopendientesActionPerformed
       
        if (radiopendientes.isSelected()== true){
            internalframependientes.setVisible(true);
            internalframetareas.setVisible(false);
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
            BuscarImpresora.setEnabled(true);
            jTextImpresora.setEnabled(true);
            
        }
    }//GEN-LAST:event_jRadioNSerieActionPerformed

    private void jRadioConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioConexionActionPerformed

        if (jRadioConexion.isSelected()== true){
            BuscarImpresora.setEnabled(true);
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
        modelo.addColumn("cuenta usuario");
        modelo.addColumn("serie compu");
        modelo.addColumn("piso");
        modelo.addColumn("area");
        modelo.addColumn("nombre del equipo");            
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        
            try {
                stm = conex.getConnection().createStatement();
                 
                   rs = stm.executeQuery("select * from equipo " +
                    "where usuario = '" +BuscaUsuario.getText()+ "'");
                
                   if(rs.next()){
                   
                     modelo.addRow(new Object[]{rs.getString("usuario"), rs.getString("serie_compu"), rs.getString("piso"), 
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
    private javax.swing.JRadioButton RadioNNI;
    private javax.swing.JRadioButton RadioNombre;
    private javax.swing.JRadioButton RadioSerie;
    private javax.swing.JTable TAREAS;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable TablaImpresora;
    private javax.swing.JTable TablaMostrar;
    private javax.swing.JTable TablaUsuario;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JComboBox<String> combox;
    private javax.swing.ButtonGroup grupoImpresora;
    private javax.swing.ButtonGroup grupoRadios;
    private javax.swing.ButtonGroup grupoUsuarios;
    private javax.swing.ButtonGroup grupotarea;
    private javax.swing.JInternalFrame internalframependientes;
    private javax.swing.JInternalFrame internalframetareas;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioConexion;
    private javax.swing.JRadioButton jRadioNSerie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextImpresora;
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
