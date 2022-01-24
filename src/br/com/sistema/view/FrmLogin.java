/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.view;


import br.com.sistema.dao.FuncionariosDAO;
import br.com.sistema.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author Tampelini
 */
public class FrmLogin extends javax.swing.JFrame {

    //Conexao
    private Connection con;    
    
    public FrmLogin() {
        this.con = new ConnectionFactory().getConnection();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo = new keeptoo.KGradientPanel();
        panellogin = new javax.swing.JPanel();
        txtemail = new javax.swing.JTextField();
        nomesistema = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        txtsenha = new javax.swing.JPasswordField();
        btnentrar = new com.k33ptoo.components.KButton();
        btnsair = new com.k33ptoo.components.KButton();
        esquecisenha = new javax.swing.JLabel();
        textosuperior = new javax.swing.JLabel();
        textoinferior = new javax.swing.JLabel();
        figura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seja bem vindo ao Sistema - Autenticação");
        setPreferredSize(new java.awt.Dimension(1200, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        fundo.setkEndColor(new java.awt.Color(52, 55, 115));
        fundo.setkStartColor(new java.awt.Color(63, 106, 191));
        fundo.setPreferredSize(new java.awt.Dimension(1200, 800));

        panellogin.setBackground(new java.awt.Color(242, 242, 242));

        txtemail.setBackground(new java.awt.Color(242, 242, 242));
        txtemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtemail.setForeground(new java.awt.Color(63, 106, 197));
        txtemail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 106, 191)));
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        nomesistema.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nomesistema.setForeground(new java.awt.Color(63, 106, 191));
        nomesistema.setText("SEM SISTEMAS");

        email.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        email.setForeground(new java.awt.Color(109, 142, 242));
        email.setText("e-mail");

        senha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        senha.setForeground(new java.awt.Color(109, 142, 242));
        senha.setText("senha");

        txtsenha.setBackground(new java.awt.Color(242, 242, 242));
        txtsenha.setForeground(new java.awt.Color(63, 106, 197));
        txtsenha.setText("jPasswordField1");
        txtsenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 106, 191)));

        btnentrar.setText("Entrar");
        btnentrar.setkBackGroundColor(new java.awt.Color(52, 55, 115));
        btnentrar.setkEndColor(new java.awt.Color(63, 106, 191));
        btnentrar.setkForeGround(new java.awt.Color(242, 242, 242));
        btnentrar.setkHoverColor(new java.awt.Color(242, 242, 242));
        btnentrar.setkHoverEndColor(new java.awt.Color(63, 106, 191));
        btnentrar.setkHoverForeGround(new java.awt.Color(242, 242, 242));
        btnentrar.setkHoverStartColor(new java.awt.Color(52, 55, 115));
        btnentrar.setkIndicatorColor(new java.awt.Color(242, 242, 242));
        btnentrar.setkPressedColor(new java.awt.Color(63, 106, 191));
        btnentrar.setkSelectedColor(new java.awt.Color(52, 55, 115));
        btnentrar.setkStartColor(new java.awt.Color(87, 170, 242));
        btnentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentrarActionPerformed(evt);
            }
        });

        btnsair.setText("Sair");
        btnsair.setkBackGroundColor(new java.awt.Color(52, 55, 115));
        btnsair.setkEndColor(new java.awt.Color(63, 106, 191));
        btnsair.setkForeGround(new java.awt.Color(242, 242, 242));
        btnsair.setkHoverColor(new java.awt.Color(242, 242, 242));
        btnsair.setkHoverEndColor(new java.awt.Color(63, 106, 191));
        btnsair.setkHoverForeGround(new java.awt.Color(242, 242, 242));
        btnsair.setkHoverStartColor(new java.awt.Color(52, 55, 115));
        btnsair.setkPressedColor(new java.awt.Color(63, 106, 191));
        btnsair.setkSelectedColor(new java.awt.Color(52, 55, 115));
        btnsair.setkStartColor(new java.awt.Color(87, 170, 242));
        btnsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsairActionPerformed(evt);
            }
        });

        esquecisenha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        esquecisenha.setForeground(new java.awt.Color(109, 142, 242));
        esquecisenha.setText("Esqueci minha senha");
        esquecisenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        esquecisenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                esquecisenhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelloginLayout = new javax.swing.GroupLayout(panellogin);
        panellogin.setLayout(panelloginLayout);
        panelloginLayout.setHorizontalGroup(
            panelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelloginLayout.createSequentialGroup()
                .addGroup(panelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelloginLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(panelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senha)
                            .addComponent(email)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelloginLayout.createSequentialGroup()
                                    .addComponent(btnentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelloginLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(esquecisenha))
                    .addGroup(panelloginLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(nomesistema)))
                .addGap(45, 45, 45))
        );
        panelloginLayout.setVerticalGroup(
            panelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelloginLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(nomesistema)
                .addGap(35, 35, 35)
                .addComponent(email)
                .addGap(0, 0, 0)
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(senha)
                .addGap(0, 0, 0)
                .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(esquecisenha)
                .addGap(18, 18, 18)
                .addGroup(panelloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnentrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        textosuperior.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textosuperior.setForeground(new java.awt.Color(242, 242, 242));
        textosuperior.setText("GERENCIE O SEU MERCADO DE FORMA");

        textoinferior.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textoinferior.setForeground(new java.awt.Color(242, 242, 242));
        textoinferior.setText("SIMPLES E ÁGIL  ");

        figura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Online Groceries-rafiki (1).png"))); // NOI18N

        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoinferior)
                    .addComponent(textosuperior))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(figura)
                .addGap(89, 89, 89)
                .addComponent(panellogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(textosuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoinferior, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(figura, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panellogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void btnentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentrarActionPerformed
        // TODO add your handling code here:
        // Botao entrar
        try {
            String email, senha;

            email = txtemail.getText();
            //senha = txtsenha.getText();
            senha = new String(txtsenha.getPassword());

            FuncionariosDAO dao = new FuncionariosDAO();

            dao.efetuaLogin(email, senha);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro");
        }

    }//GEN-LAST:event_btnentrarActionPerformed

    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
        // TODO add your handling code here:
        int op;

        op = JOptionPane.showConfirmDialog(null, "Você tem certeza que desja sair?");

        if (op == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnsairActionPerformed

    private void esquecisenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esquecisenhaMouseClicked
        // TODO add your handling code here:
        FuncionariosDAO dao = new FuncionariosDAO();
        dao.esqueciMinhaSenha();

    }//GEN-LAST:event_esquecisenhaMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnentrar;
    private com.k33ptoo.components.KButton btnsair;
    private javax.swing.JLabel email;
    private javax.swing.JLabel esquecisenha;
    private javax.swing.JLabel figura;
    private keeptoo.KGradientPanel fundo;
    private javax.swing.JLabel nomesistema;
    private javax.swing.JPanel panellogin;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel textoinferior;
    private javax.swing.JLabel textosuperior;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables
}
