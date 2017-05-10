package HGR46;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.*;
import java.awt.Toolkit;

/**
 *
 * @author master EMM
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\master EMM\\Documents\\NetBeansProjects\\Empresa\\IMSS.jpg"));
        setTitle("SISTEMA DE CONTROL DE INVENTARIO");
    }
    private void ingresar(){
        if(camposLlenos()){
            Conexion con = null;
            Statement stm = null; 
            ResultSet rs = null;
            
            con= new Conexion();
            try {
                stm = con.getConnection().createStatement();
                rs = stm.executeQuery("select * " +
                                        "from usuarios " +
                                        "where usuario = '"+txtf_usuario.getText()+"'" +
                                        "and contrasena = '"+String.valueOf(txtf_pass.getPassword())+"'");
                //showMessageDialog(null, "Conexion","establecida!!!",INFORMATION_MESSAGE);
                if(rs.next()){
                    Principal principal = new Principal();
                    principal.setVisible(true);
                    dispose();
                    /*Principal principal = new Principal();
                    
                    if(txtf_usuario.getText() == "eduardo.moram"){
                        principal.combox_usuario.setVisible(true);
                        principal.setVisible(true);
                        dispose();
                    }else {
                    //showMessageDialog(null, "Existe","Información",INFORMATION_MESSAGE);
                    principal.combox_usuario.setVisible(false);
                    principal.setVisible(true);
                    dispose();
                    }*/
                }
                else{
                    rs = stm.executeQuery("select * " +
                                            "from usuarios " +
                                            "where usuario = '"+txtf_usuario.getText()+"'");
                    if(rs.next()){
                         
                        showMessageDialog(null, "Contraseña incorrecta, no te apendejes!!!","Información",INFORMATION_MESSAGE);
                        txtf_pass.setText("");
                    }
                    else{
                        showMessageDialog(null, "Datos erróneos","Error",ERROR_MESSAGE);
                    }
                }
                stm.close();
                rs.close();
                con.desconectar();    
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                showMessageDialog(null, "No se encontro el usuario");
            }
        }
        else{
            showMessageDialog(null, "Campos vacios");
        }
    }

    public boolean camposLlenos(){
        if(txtf_usuario.getText().length() > 0 && String.valueOf(txtf_pass.getPassword()).length() > 0)
            return true;
        return false;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_usuario = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_hgr46 = new javax.swing.JLabel();
        txtf_usuario = new javax.swing.JTextField();
        boton_ingresar = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();
        txtf_pass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        lbl_autor = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lbl_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HGR46/iconos/user.png"))); // NOI18N

        lbl_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HGR46/iconos/lock.png"))); // NOI18N

        lbl_titulo.setFont(new java.awt.Font("gargi", 0, 36)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(0, 204, 204));
        lbl_titulo.setText("Informática");

        lbl_hgr46.setFont(new java.awt.Font("gargi", 0, 18)); // NOI18N
        lbl_hgr46.setForeground(new java.awt.Color(0, 204, 204));
        lbl_hgr46.setText("HGR 46");

        txtf_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf_usuarioActionPerformed(evt);
            }
        });

        boton_ingresar.setBackground(new java.awt.Color(255, 255, 255));
        boton_ingresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton_ingresar.setForeground(new java.awt.Color(0, 204, 204));
        boton_ingresar.setText("Ingresar");
        boton_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ingresarActionPerformed(evt);
            }
        });

        boton_salir.setBackground(new java.awt.Color(255, 255, 255));
        boton_salir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton_salir.setForeground(new java.awt.Color(0, 204, 204));
        boton_salir.setText("Salir");
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HGR46/Logo.jpg"))); // NOI18N

        lbl_autor.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbl_autor.setForeground(new java.awt.Color(0, 204, 204));
        lbl_autor.setText("Desarrollado por: Eduardo Mora Martínez");

        jMenu1.setText("Archivo");

        jMenu3.setText("Usuario");

        jMenuItem1.setText("Agregar");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Eliminar");
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Modificar");
        jMenu3.add(jMenuItem3);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Acerca de");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_autor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtf_pass)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boton_ingresar)
                                .addGap(59, 59, 59)
                                .addComponent(boton_salir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_titulo)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(lbl_hgr46)
                                .addGap(13, 13, 13)))))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 123, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_hgr46)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(lbl_autor))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ingresarActionPerformed
        
        ingresar();
        
    }//GEN-LAST:event_boton_ingresarActionPerformed

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
       int valor = showConfirmDialog(null, "seguto que quieres salir? ");
        if (valor == YES_NO_OPTION) {
           System.exit(0);
        } 
        
    }//GEN-LAST:event_boton_salirActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

        
       
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        showMessageDialog(null, " Programa desarrollado por "
                + "\n Ing. Eduardo Mora Martínez "
                + "\n Estudiante CuTonala UdeG"
                + "\n correo: eduardo.mmoram@imss.gob.mx"
                + "\n web: www.github.com");
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void txtf_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf_usuarioActionPerformed
      
        txtf_usuario.transferFocus();
        
    }//GEN-LAST:event_txtf_usuarioActionPerformed

 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_ingresar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JLabel lbl_autor;
    private javax.swing.JLabel lbl_hgr46;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPasswordField txtf_pass;
    public javax.swing.JTextField txtf_usuario;
    // End of variables declaration//GEN-END:variables
}
