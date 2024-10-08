/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment;

import static assignment.staff.countlines;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class forgetpassword extends javax.swing.JFrame {

    /**
     * Creates new form forgetpassword
     */
    public forgetpassword() {
        initComponents();
        forgetNewpw.setVisible(false);
        forgetpw1.setVisible(false);
        forgetNewpw2.setVisible(false);
        forgetpw2.setVisible(false);
        forgetConfirmbutton.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
    }
    
    //counts to be iterates in login.txt
    static int countlines() throws FileNotFoundException{
        File file = new File("Login.txt");
        Scanner scanner = new Scanner(file);
        int count = 0;
        int line = 0;
            
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }
        scanner.close();
            
        return count/6+1;
                   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        forgetTopic = new javax.swing.JLabel();
        forgetEmaillabel = new javax.swing.JLabel();
        forgetEmail = new javax.swing.JTextField();
        forgetSecuritylabel = new javax.swing.JLabel();
        forgetSecurity = new javax.swing.JTextField();
        forgetNextbutton = new javax.swing.JButton();
        forgetNewpw = new javax.swing.JLabel();
        forgetNewpw2 = new javax.swing.JLabel();
        forgetpw1 = new javax.swing.JPasswordField();
        forgetpw2 = new javax.swing.JPasswordField();
        forgetConfirmbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        forgetBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        forgetTopic.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        forgetTopic.setText("Forget Password");
        getContentPane().add(forgetTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 13, -1, -1));

        forgetEmaillabel.setText("Email :");
        getContentPane().add(forgetEmaillabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 77, -1, -1));
        getContentPane().add(forgetEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 74, 233, -1));

        forgetSecuritylabel.setText("Security Code: ");
        getContentPane().add(forgetSecuritylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 140, -1, -1));
        getContentPane().add(forgetSecurity, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 137, 190, -1));

        forgetNextbutton.setText("Next");
        forgetNextbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgetNextbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(forgetNextbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 196, -1, -1));

        forgetNewpw.setText("New Password: ");
        getContentPane().add(forgetNewpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 265, -1, -1));

        forgetNewpw2.setText("Confirm Password:");
        getContentPane().add(forgetNewpw2, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 317, -1, -1));
        getContentPane().add(forgetpw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 262, 186, -1));
        getContentPane().add(forgetpw2, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 314, 183, -1));

        forgetConfirmbutton.setText("Confirm");
        forgetConfirmbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgetConfirmbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(forgetConfirmbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 362, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Passwords are not same!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 321, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Use better Password!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 269, 86, -1));

        forgetBack.setText("Back");
        forgetBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgetBackActionPerformed(evt);
            }
        });
        getContentPane().add(forgetBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 196, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forgetNextbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgetNextbuttonActionPerformed
        try {
            //if user email and security code matches 
            String email, security;
            email = forgetEmail.getText();
            security = forgetSecurity.getText();
            staff obj1 = new staff(email, security);
            
            String res = obj1.checkforgetpassword();
            
            //show change password section
            if(res == "Success"){
               forgetNewpw.setVisible(true);
               forgetpw1.setVisible(true);
               forgetNewpw2.setVisible(true);
               forgetpw2.setVisible(true);
               forgetConfirmbutton.setVisible(true);
               
                
            }
            else if (res == "Fail"){
                JOptionPane.showMessageDialog(null, "Invalid Email / Security Code!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(forgetpassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_forgetNextbuttonActionPerformed

    private void forgetConfirmbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgetConfirmbuttonActionPerformed
        try {
            //change password
            String email, security, password1, password2;
            boolean checkpassword = false, checkpassword2 = false;
            email = forgetEmail.getText();
            security = forgetSecurity.getText();
            password1 = forgetpw1.getText();
            password2 =forgetpw2.getText();
            
            //confirm both password field equals to each other
            if(password2.equals(password1)){
                checkpassword = true;
                jLabel1.setVisible(false);
            } else{
                jLabel1.setVisible(true);
            }  
            
            //password validations
            if ( password1.isEmpty()) {
                jLabel2.setVisible(true);
            }else if (password1.length() < 6){
                jLabel2.setVisible(true);
            }else if (!password1.matches(".*[A-Z].*") || !password1.matches(".*[a-z].*")){
                jLabel2.setVisible(true);
            }else{
                checkpassword2 = true;
                jLabel2.setVisible(false);
            }            
            
           
            staff obj1 = new staff(email, security, password1);
            String res = obj1.changepassword();
            
            
            if(checkpassword && checkpassword2){
                if (res == "Success"){
                    JOptionPane.showMessageDialog(null, "Success to change password!","Success",JOptionPane.ERROR_MESSAGE);
                    login a = new login();
                    a.setVisible(true);
                    this.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Password can't be updated!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(forgetpassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_forgetConfirmbuttonActionPerformed

    private void forgetBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgetBackActionPerformed
        login a = new login();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_forgetBackActionPerformed

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
            java.util.logging.Logger.getLogger(forgetpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgetpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgetpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgetpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgetpassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgetBack;
    private javax.swing.JButton forgetConfirmbutton;
    private javax.swing.JTextField forgetEmail;
    private javax.swing.JLabel forgetEmaillabel;
    private javax.swing.JLabel forgetNewpw;
    private javax.swing.JLabel forgetNewpw2;
    private javax.swing.JButton forgetNextbutton;
    private javax.swing.JTextField forgetSecurity;
    private javax.swing.JLabel forgetSecuritylabel;
    private javax.swing.JLabel forgetTopic;
    private javax.swing.JPasswordField forgetpw1;
    private javax.swing.JPasswordField forgetpw2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
