/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HGR46;
import java.awt.Container;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author master EMM
 */
public class AgregarEquipo extends javax.swing.JDialog {

    /**
     * Creates new form AgregarEquipo
     */
    
     
    public AgregarEquipo() {
      
                    initComponents();
                    setResizable(false);
                    setLocationRelativeTo(null);
                    setSize(768,450);
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\master EMM\\Documents\\NetBeansProjects\\Empresa\\IMSS.jpg"));
                    setTitle("SISTEMA DE CONTROL DE INVENTARIO");
                   
    }
   
private boolean camposllenos(){
        if(txtfSerie_Compu.getText().length() > 0 && txtfPiso.getText().length() > 0 && txtfArea.getText().length() > 0
                && txtfConsultorio.getText().length() > 0 && txtfSubarea.getText().length() > 0 && txtfNombre.getText().length() > 0
                && txtfCuenta.getText().length() > 0 && txtfMarca.getText().length() > 0 && txtfModelo.getText().length() > 0
                && txtfMac.getText().length() > 0 && txtfNni.getText().length() > 0 && txtfDhcp.getText().length() > 0
                && txtfDireccion_Ip.getText().length() > 0 && txtfSerie_Impresora.getText().length() > 0)
        return true;
        else return false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtfDhcp = new javax.swing.JTextField();
        txtfDireccion_Ip = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtfSerie_Impresora = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_insertarequipo = new javax.swing.JButton();
        txtfSerie_Compu = new javax.swing.JTextField();
        txtfPiso = new javax.swing.JTextField();
        txtfArea = new javax.swing.JTextField();
        txtfConsultorio = new javax.swing.JTextField();
        txtfSubarea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfCuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtfMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfModelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtfMac = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfNni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_CargarAut = new javax.swing.JButton();
        txtfModificar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btn_Buscar = new javax.swing.JButton();
        cmbModificar = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        btn_Guardarcambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Control de Inventario ver.04");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(870, 550));
        setModal(true);
        setSize(new java.awt.Dimension(870, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfDhcp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfDhcpKeyTyped(evt);
            }
        });
        getContentPane().add(txtfDhcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 130, -1));

        txtfDireccion_Ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfDireccion_IpActionPerformed(evt);
            }
        });
        txtfDireccion_Ip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfDireccion_IpKeyTyped(evt);
            }
        });
        getContentPane().add(txtfDireccion_Ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 195, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("marca");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        txtfSerie_Impresora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfSerie_ImpresoraKeyTyped(evt);
            }
        });
        getContentPane().add(txtfSerie_Impresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 195, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("modelo");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("mac");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        cancelar.setText("Atras");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 113, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setText("nni");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("dhcp");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("direccion ip");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setText("serie impresora");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, -1));

        btn_insertarequipo.setText("Insertar equipo");
        btn_insertarequipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertarequipoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_insertarequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, -1, -1));

        txtfSerie_Compu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfSerie_CompuKeyTyped(evt);
            }
        });
        getContentPane().add(txtfSerie_Compu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 214, -1));

        txtfPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfPisoKeyTyped(evt);
            }
        });
        getContentPane().add(txtfPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 70, -1));

        txtfArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfAreaActionPerformed(evt);
            }
        });
        txtfArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfAreaKeyTyped(evt);
            }
        });
        getContentPane().add(txtfArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 214, -1));

        txtfConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfConsultorioActionPerformed(evt);
            }
        });
        txtfConsultorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfConsultorioKeyTyped(evt);
            }
        });
        getContentPane().add(txtfConsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 214, -1));

        txtfSubarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfSubareaKeyTyped(evt);
            }
        });
        getContentPane().add(txtfSubarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 214, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Agregar o modificar un equipo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 11, -1, -1));

        txtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfNombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 214, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("serie compu     *");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 120, -1));

        txtfCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfCuentaKeyTyped(evt);
            }
        });
        getContentPane().add(txtfCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 214, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("piso");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        txtfMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfMarcaKeyTyped(evt);
            }
        });
        getContentPane().add(txtfMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("area");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        txtfModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfModeloKeyTyped(evt);
            }
        });
        getContentPane().add(txtfModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("consultorio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        txtfMac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfMacKeyTyped(evt);
            }
        });
        getContentPane().add(txtfMac, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 195, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("subarea");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 62, -1));

        txtfNni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfNniKeyTyped(evt);
            }
        });
        getContentPane().add(txtfNni, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 195, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("nombre");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("cuenta");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        btn_CargarAut.setText("Cargar default");
        btn_CargarAut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CargarAutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CargarAut, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 150, -1));

        txtfModificar.setToolTipText("Equipo a buscar!!!");
        txtfModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfModificarKeyTyped(evt);
            }
        });
        getContentPane().add(txtfModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 140, -1));

        jLabel16.setText("Buscar equipo:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 90, -1));

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 100, -1));

        cmbModificar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero de serie", "NNI" }));
        getContentPane().add(cmbModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 180, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Localizar por:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btn_Guardarcambios.setText("Guardar cambios");
        btn_Guardarcambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarcambiosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Guardarcambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    
    private void btn_insertarequipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertarequipoActionPerformed

        

        if(camposllenos()==true){
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();

            try {
                stm = conex.getConnection().createStatement();

                stm.executeUpdate("INSERT INTO equipo (serie_compu,piso,area,consultorio,subarea,nombre,cuenta,marca,"
                    + "modelo,mac,nni,dhcp,direccion_ip,serie_impresora) "
                    + "VALUES ('" +txtfSerie_Compu.getText()+ "','" +txtfPiso.getText()+ "','" +txtfArea.getText()+ "','"
                    +txtfConsultorio.getText()+ "','" +txtfSubarea.getText()+ "','" +txtfNombre.getText()+ "','"
                    +txtfCuenta.getText()+ "','" +txtfMarca.getText()+ "','" +txtfModelo.getText()+ "','"
                    +txtfMac.getText()+ "','" +txtfNni.getText()+ "','" +txtfDhcp.getText()+ "','"
                    +txtfDireccion_Ip.getText()+ "','" +txtfSerie_Impresora.getText()+ "')");

            } catch (SQLException ex) {
                Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            showMessageDialog(null,"equipo añadido correctamente");

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            conex.desconectar();

            
/*
            Principal principal = new Principal();
            principal.actualizaequipo();
*/
        }else   showMessageDialog(null,"campos vacios!!!");

    }//GEN-LAST:event_btn_insertarequipoActionPerformed

    private void txtfDireccion_IpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfDireccion_IpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfDireccion_IpActionPerformed

    private void txtfAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfAreaActionPerformed

    private void txtfConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfConsultorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfConsultorioActionPerformed

    private void btn_CargarAutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CargarAutActionPerformed
        
                    txtfSerie_Compu.setText("SMXPRUEBA");
                    txtfPiso.setText("PB");
                    txtfArea.setText("PERSONAL");
                    txtfConsultorio.setText("N/A");
                    txtfSubarea.setText("N/A");
                    txtfNombre.setText("J14046");
                    txtfCuenta.setText("eduardo.moram");
                    txtfMarca.setText("HP");
                    txtfModelo.setText("6005");
                    txtfMac.setText("D4-85-64-A6-1C-49");
                    txtfNni.setText("2010800");
                    txtfDhcp.setText("DINAMICA");
                    txtfDireccion_Ip.setText("11.54.14.");
                    txtfSerie_Impresora.setText("S45145PHH");                  
        
    }//GEN-LAST:event_btn_CargarAutActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed

        if(txtfModificar.getText().length() > 0){
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();
            if(cmbModificar.getSelectedItem() == "Numero de serie") {
                try {
                    stm = conex.getConnection().createStatement();
                    rs = stm.executeQuery("select * " +
                        "from equipo " +
                        "where serie_compu = '"+txtfModificar.getText()+"'");
                    if(rs.next()){
                        txtfSerie_Compu.setText(rs.getString("serie_compu"));
                        txtfPiso.setText(rs.getString("piso"));
                        txtfArea.setText(rs.getString("area"));
                        txtfConsultorio.setText(rs.getString("consultorio"));
                        txtfSubarea.setText(rs.getString("subarea"));
                        txtfNombre.setText(rs.getString("nombre"));
                        txtfCuenta.setText(rs.getString("cuenta"));
                        txtfMarca.setText(rs.getString("marca"));
                        txtfModelo.setText(rs.getString("modelo"));
                        txtfMac.setText(rs.getString("mac"));
                        txtfNni.setText(rs.getString("nni"));
                        txtfDhcp.setText(rs.getString("dhcp"));
                        txtfDireccion_Ip.setText(rs.getString("direccion_ip"));
                        txtfSerie_Impresora.setText(rs.getString("serie_impresora"));
                    }
                    else showMessageDialog(null, "Equipo no se encuentra en la base de datos!!!", "Error", JOptionPane.ERROR_MESSAGE);
                    txtfModificar.setText("");

                    
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
                conex.desconectar();

            }else if(cmbModificar.getSelectedItem() == "NNI"){
                try {
                    stm = conex.getConnection().createStatement();
                    rs = stm.executeQuery("select * " +
                        "from equipo " +
                        "where nni = '"+txtfModificar.getText()+"'");
                    if(rs.next()){
                        txtfSerie_Compu.setText(rs.getString("serie_compu"));
                        txtfPiso.setText(rs.getString("piso"));
                        txtfArea.setText(rs.getString("area"));
                        txtfConsultorio.setText(rs.getString("consultorio"));
                        txtfSubarea.setText(rs.getString("subarea"));
                        txtfNombre.setText(rs.getString("nombre"));
                        txtfCuenta.setText(rs.getString("cuenta"));
                        txtfMarca.setText(rs.getString("marca"));
                        txtfModelo.setText(rs.getString("modelo"));
                        txtfMac.setText(rs.getString("mac"));
                        txtfNni.setText(rs.getString("nni"));
                        txtfDhcp.setText(rs.getString("dhcp"));
                        txtfDireccion_Ip.setText(rs.getString("direccion_ip"));
                        txtfSerie_Impresora.setText(rs.getString("serie_impresora"));
                    }
                    else showMessageDialog(null, "Equipo no se encuentra en la base de datos!!!", "Error", JOptionPane.ERROR_MESSAGE);

                } catch (SQLException ex) {
                    Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
                conex.desconectar();

            }

        }else showMessageDialog(null,"campo vacio o no existe registro en base de datos!!!");

    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_GuardarcambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarcambiosActionPerformed
       
        if(camposllenos()==true){
            Conexion conex = null;
            Statement stm = null;
            ResultSet rs = null;

            conex= new Conexion();

            try {
                stm = conex.getConnection().createStatement();

                stm.executeUpdate("UPDATE FROM equipo SET (serie_compu ='" +txtfSerie_Compu.getText()+ "',"
                        + "piso = '" +txtfPiso.getText()+ "', area = '" +txtfArea.getText()+ "', "
                        + "consultorio = '" +txtfConsultorio.getText()+ "', subarea = '" +txtfSubarea.getText()+ "',"
                        + "nombre = '" +txtfNombre.getText()+ "',cuenta = '" +txtfCuenta.getText()+ "',"
                        + "marca = '" +txtfMarca.getText()+ "',modelo = '" +txtfModelo.getText()+ "',"
                        + "mac = '" +txtfMac.getText()+ "',nni = '" +txtfNni.getText()+ "',"
                        + "dhcp = '" +txtfDhcp.getText()+ "',direccion_ip = '"+txtfDireccion_Ip.getText()+ "',"
                        + "serie_impresora = '" +txtfSerie_Impresora.getText()+ "'");
                  

            } catch (SQLException ex) {
                Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            showMessageDialog(null,"equipo modificado correctamente");
            
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AgregarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            conex.desconectar();

            
        }else   showMessageDialog(null,"campos vacios!!!");
        
    }//GEN-LAST:event_btn_GuardarcambiosActionPerformed

    private void txtfModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfModificarKeyTyped
       
        char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
        
    }//GEN-LAST:event_txtfModificarKeyTyped

    private void txtfSerie_CompuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfSerie_CompuKeyTyped
       
        char c = evt.getKeyChar();
        if(txtfSerie_Compu.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
        
    }//GEN-LAST:event_txtfSerie_CompuKeyTyped

    private void txtfPisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfPisoKeyTyped
        char c = evt.getKeyChar();
        if(txtfPiso.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfPisoKeyTyped

    private void txtfAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfAreaKeyTyped
        char c = evt.getKeyChar();
        if(txtfArea.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfAreaKeyTyped

    private void txtfConsultorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfConsultorioKeyTyped
       char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfConsultorioKeyTyped

    private void txtfSubareaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfSubareaKeyTyped
       char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfSubareaKeyTyped

    private void txtfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfNombreKeyTyped
        char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfNombreKeyTyped

    private void txtfCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfCuentaKeyTyped
       char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfCuentaKeyTyped

    private void txtfMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfMarcaKeyTyped
        char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfMarcaKeyTyped

    private void txtfModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfModeloKeyTyped
        char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfModeloKeyTyped

    private void txtfMacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfMacKeyTyped
        char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfMacKeyTyped

    private void txtfNniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfNniKeyTyped
      char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfNniKeyTyped

    private void txtfDhcpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfDhcpKeyTyped
      char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfDhcpKeyTyped

    private void txtfDireccion_IpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfDireccion_IpKeyTyped
       char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfDireccion_IpKeyTyped

    private void txtfSerie_ImpresoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfSerie_ImpresoraKeyTyped
        char c = evt.getKeyChar();
        if(txtfModificar.getText().trim().length() == 30|| Character.isSpaceChar(c) || Character.isWhitespace(c)){
          getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtfSerie_ImpresoraKeyTyped

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarEquipo().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_CargarAut;
    private javax.swing.JButton btn_Guardarcambios;
    private javax.swing.JButton btn_insertarequipo;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> cmbModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtfArea;
    private javax.swing.JTextField txtfConsultorio;
    private javax.swing.JTextField txtfCuenta;
    private javax.swing.JTextField txtfDhcp;
    private javax.swing.JTextField txtfDireccion_Ip;
    private javax.swing.JTextField txtfMac;
    private javax.swing.JTextField txtfMarca;
    private javax.swing.JTextField txtfModelo;
    private javax.swing.JTextField txtfModificar;
    private javax.swing.JTextField txtfNni;
    private javax.swing.JTextField txtfNombre;
    private javax.swing.JTextField txtfPiso;
    private javax.swing.JTextField txtfSerie_Compu;
    private javax.swing.JTextField txtfSerie_Impresora;
    private javax.swing.JTextField txtfSubarea;
    // End of variables declaration//GEN-END:variables
}
