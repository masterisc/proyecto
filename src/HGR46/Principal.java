/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HGR46;

import empresa.Insertar;
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
        txtfbuscarequipo.setEnabled(false);
        txtfbuscarequipo.setEditable(false);
        TablaMostrar.setEnabled(true);
        botonActualizar.setEnabled(false);
        lblcontador.setVisible(true);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_ejem = new javax.swing.JTable();
        Jframeconsultaimpresora = new javax.swing.JInternalFrame();
        Jframeayuda = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        radioEduardo = new javax.swing.JRadioButton();
        radioCarlos = new javax.swing.JRadioButton();
        radioCristal = new javax.swing.JRadioButton();
        radioHernandez = new javax.swing.JRadioButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        lblcontador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
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

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1234, Short.MAX_VALUE)
        );
        JfconsultainventarioLayout.setVerticalGroup(
            JfconsultainventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("CONSULTA INVENTARIO", Jfconsultainventario);

        Jfactualizainventario.setVisible(true);
        Jfactualizainventario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JfactualizainventarioPropertyChange(evt);
            }
        });

        jPanel1.setToolTipText("");

        RadioSerie.setText("Serie");
        RadioSerie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RadioSerieItemStateChanged(evt);
            }
        });
        RadioSerie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadioSerieMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RadioSerieMousePressed(evt);
            }
        });
        RadioSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioSerieActionPerformed(evt);
            }
        });

        RadioNombre.setText("Nombre");
        RadioNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadioNombreMouseClicked(evt);
            }
        });
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
                        .addContainerGap(380, Short.MAX_VALUE))
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

        Tabla_ejem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        Tabla_ejem.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                Tabla_ejemComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla_ejem);

        javax.swing.GroupLayout JframeconsultausuarioLayout = new javax.swing.GroupLayout(Jframeconsultausuario.getContentPane());
        Jframeconsultausuario.getContentPane().setLayout(JframeconsultausuarioLayout);
        JframeconsultausuarioLayout.setHorizontalGroup(
            JframeconsultausuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1234, Short.MAX_VALUE)
        );
        JframeconsultausuarioLayout.setVerticalGroup(
            JframeconsultausuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("CONSULTA USUARIO", Jframeconsultausuario);

        Jframeconsultaimpresora.setVisible(true);

        javax.swing.GroupLayout JframeconsultaimpresoraLayout = new javax.swing.GroupLayout(Jframeconsultaimpresora.getContentPane());
        Jframeconsultaimpresora.getContentPane().setLayout(JframeconsultaimpresoraLayout);
        JframeconsultaimpresoraLayout.setHorizontalGroup(
            JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JframeconsultaimpresoraLayout.setVerticalGroup(
            JframeconsultaimpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("CONSULTA IMPRESORA", Jframeconsultaimpresora);

        Jframeayuda.setVisible(true);

        javax.swing.GroupLayout JframeayudaLayout = new javax.swing.GroupLayout(Jframeayuda.getContentPane());
        Jframeayuda.getContentPane().setLayout(JframeayudaLayout);
        JframeayudaLayout.setHorizontalGroup(
            JframeayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1234, Short.MAX_VALUE)
        );
        JframeayudaLayout.setVerticalGroup(
            JframeayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("NUEVA TAREA", Jframeayuda);

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab7", jInternalFrame2);

        jInternalFrame6.setVisible(true);

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

        jInternalFrame3.setVisible(true);

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jInternalFrame6Layout = new javax.swing.GroupLayout(jInternalFrame6.getContentPane());
        jInternalFrame6.getContentPane().setLayout(jInternalFrame6Layout);
        jInternalFrame6Layout.setHorizontalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(radioHernandez, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(radioCristal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioCarlos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioEduardo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jInternalFrame6Layout.setVerticalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(radioEduardo)
                .addGap(15, 15, 15)
                .addComponent(radioCarlos)
                .addGap(18, 18, 18)
                .addComponent(radioCristal)
                .addGap(18, 18, 18)
                .addComponent(radioHernandez)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PENDIENTES", jInternalFrame6);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btn_regresar)
                .addGap(19, 19, 19))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 634, Short.MAX_VALUE)
                        .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
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

    private void RadioSerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioSerieMouseClicked
       
        
        
        
    }//GEN-LAST:event_RadioSerieMouseClicked

    private void RadioNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioNombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioNombreMouseClicked

    private void RadioSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioSerieActionPerformed
        RadioSerie.transferFocus();
        
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

    private void RadioSerieMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioSerieMousePressed
       
       
        
    }//GEN-LAST:event_RadioSerieMousePressed

    private void RadioSerieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RadioSerieItemStateChanged
       
        
             
    }//GEN-LAST:event_RadioSerieItemStateChanged

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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
        
        
    }//GEN-LAST:event_BotonMostrarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
         
    }//GEN-LAST:event_botonEditarActionPerformed

    private void Tabla_ejemComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_Tabla_ejemComponentAdded
   
        
        
                              
        
    }//GEN-LAST:event_Tabla_ejemComponentAdded

    private void JfactualizainventarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JfactualizainventarioPropertyChange
       
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelo = new DefaultTableModel();
            
        Tabla_ejem.setModel(modelo);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
        
        
    }//GEN-LAST:event_JfactualizainventarioPropertyChange

    private void jScrollPane3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jScrollPane3PropertyChange
       
        Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelo = new DefaultTableModel();
            
        Tabla_ejem.setModel(modelo);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                conex.desconectar();
            
        
    }//GEN-LAST:event_jScrollPane3PropertyChange

    private void jInternalFrame1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jInternalFrame1PropertyChange
        
        Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            modelo = new DefaultTableModel();
            
        Tabla_ejem.setModel(modelo);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JInternalFrame Jfactualizainventario;
    private javax.swing.JInternalFrame Jfconsultainventario;
    private javax.swing.JInternalFrame Jframeayuda;
    private javax.swing.JInternalFrame Jframeconsultaimpresora;
    private javax.swing.JInternalFrame Jframeconsultausuario;
    private javax.swing.JRadioButton RadioNNI;
    private javax.swing.JRadioButton RadioNombre;
    private javax.swing.JRadioButton RadioSerie;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable TablaMostrar;
    private javax.swing.JTable Tabla_ejem;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JComboBox<String> combox;
    private javax.swing.ButtonGroup grupoRadios;
    private javax.swing.ButtonGroup grupoUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblcontador;
    private javax.swing.JRadioButton radioCarlos;
    private javax.swing.JRadioButton radioCristal;
    private javax.swing.JRadioButton radioEduardo;
    private javax.swing.JRadioButton radioHernandez;
    private javax.swing.JTextField txtfbuscarequipo;
    // End of variables declaration//GEN-END:variables
}
