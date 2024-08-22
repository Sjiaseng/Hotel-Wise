/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class modifyprofile extends javax.swing.JFrame {

    /**
     * Creates new form modifyprofile
     */
    public modifyprofile() {
        initComponents();
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        
        //get array data from staff
        String[] myArrayData = staff.myData;
        
        profileUsername.setText(myArrayData[0]);
        profileEmail.setText(myArrayData[1]);
        profilePassword1.setText(myArrayData[2]);
        profilePassword2.setText(myArrayData[2]);
        profileSecurity.setText(myArrayData[3]);
    }

    //numbers to iterates for login.txt
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        profileUsername = new javax.swing.JTextField();
        profileEmail = new javax.swing.JTextField();
        profilePassword1 = new javax.swing.JPasswordField();
        profilePassword2 = new javax.swing.JPasswordField();
        profileSecurity = new javax.swing.JTextField();
        profileSave = new javax.swing.JButton();
        profileBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        profileReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("My Profile");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 30, -1, -1));

        jLabel2.setText("Username: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 114, 309, -1));

        jLabel3.setText("Email: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 167, 37, -1));

        jLabel4.setText("Password: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 223, 101, -1));

        jLabel5.setText("Confirm Password: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 281, -1, -1));

        jLabel6.setText("Security: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 331, -1, -1));
        getContentPane().add(profileUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 111, 201, -1));
        getContentPane().add(profileEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 164, 201, -1));
        getContentPane().add(profilePassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 220, 201, -1));
        getContentPane().add(profilePassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 278, 201, -1));
        getContentPane().add(profileSecurity, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 328, 201, -1));

        profileSave.setText("Save Changes");
        profileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileSaveActionPerformed(evt);
            }
        });
        getContentPane().add(profileSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 392, -1, -1));

        profileBack.setText("Back");
        profileBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBackActionPerformed(evt);
            }
        });
        getContentPane().add(profileBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Username can't contain Integer / Special Character!");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 118, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Invalid Email!");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 171, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Password should be more than 6 characters  and must with upper + lower case!");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 227, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Password does not match!");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 285, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Security code should contain at least 5 characters!");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 335, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Password and Security Code can't be the same!");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 368, 243, -1));

        profileReset.setText("Reset");
        profileReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileResetActionPerformed(evt);
            }
        });
        getContentPane().add(profileReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 392, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileSaveActionPerformed
        try {
            //editing profile
            String username, email, password1, password2, security;
            boolean isUsername = false, isEmail = false, isPassword = false, samePassword = false, isSecurity = false, checkEmail = false, checkSecurity = false;
            username = profileUsername.getText();
            email = profileEmail.getText();
            password1 = profilePassword1.getText();
            password2 = profilePassword2.getText();
            security = profileSecurity.getText();
            String pattern = ".*[!@#$%^&*()\\-_=+\\[\\]{};:\'\"<>,./?\\\\|`~].*";

            String myusername, myemail, mypassword, mysecurity, mydate, myspace;
            
            RandomAccessFile raf = new RandomAccessFile("Login.txt", "rw");
            
            for(int i=1; i < countlines() ; i++){
                
                myusername = raf.readLine().substring(10);
                myemail = raf.readLine().substring(7);
                mypassword = raf.readLine().substring(10);
                mysecurity = raf.readLine().substring(10);
                mydate =raf.readLine().substring(15);
                myspace =raf.readLine().substring(0);
                    
                    //check if email exist / duplicate
                    if(myemail.equals(email)){
                        JOptionPane.showMessageDialog(null,"Email is registered please use another email!","Error",JOptionPane.INFORMATION_MESSAGE);
                        profileEmail.setText("");
                    } else {
                        checkEmail= true;
                    }
                    
            }       
                    //password validation
                    if(password1.equals(security)){
                        jLabel12.setVisible(true);
                        profileSecurity.setText("");
                    } else{
                        checkSecurity = true;
                        jLabel12.setVisible(false);
                    }
                    
                    //username validation
                    if (username.length() < 2 || username.isEmpty()){
                        jLabel7.setVisible(true);
                    } else if (username.matches(".*\\d+.*")|| username.matches(pattern)){
                        jLabel7.setVisible(true);
                    } else{
                        isUsername = true;
                        jLabel7.setVisible(false);
                    }           

                    //email validation
                    if ((email == null || email.isEmpty())){
                        jLabel8.setVisible(true);
                    } else if (!email.contains("@") || (!email.contains(".com"))){
                        jLabel8.setVisible(true);
                    } else{
                        isEmail = true;
                        jLabel8.setVisible(false);
                    }
                    
                    //password validation
                    if ( password1.isEmpty()) {
                        jLabel9.setVisible(true);
                    }else if (password1.length() < 6){
                        jLabel9.setVisible(true);
                    }else if (!password1.matches(".*[A-Z].*") || !password1.matches(".*[a-z].*")){
                        jLabel9.setVisible(true);
                    }else{
                        isPassword = true;
                        jLabel9.setVisible(false);
                    }

                    //security code validation
                    if (security.isEmpty()) {
                        jLabel10.setVisible(true);
                    }else if (security.length() < 5){
                        jLabel10.setVisible(true);
                    }else{
                        isSecurity = true;
                        jLabel10.setVisible(false);
                    }
                    
                    //password similarities with confirm password
                    if(password2.equals(password1)){
                        samePassword = true;
                        jLabel11.setVisible(false);
                    } else{
                        jLabel11.setVisible(true);
                    }  

                    
                    if (isUsername && isEmail && isPassword && samePassword && isSecurity && checkEmail && checkSecurity){
                        
                        staff obj1 = new staff(username, email, password1, security);
                        String res=obj1.modifyprofile();
                        
                        if(res == "Success"){
                            JOptionPane.showMessageDialog(null,"Success in modifying profile!","Success",JOptionPane.INFORMATION_MESSAGE);
                            menu a = new menu();
                            a.setVisible(true);
                            this.setVisible(false);
                            staff obj2 = new staff(email, password1);
                            obj2.mySession();
                        }else
                            JOptionPane.showMessageDialog(null, "Failed to Modify Profile!","Error",JOptionPane.ERROR_MESSAGE);
                    }             

        } catch (FileNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
            

    }//GEN-LAST:event_profileSaveActionPerformed

    private void profileBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBackActionPerformed
        // ask user whether to leave the page
        int n = JOptionPane.showConfirmDialog(null,"Changes will not be saved!", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){
            menu a = new menu();
            a.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_profileBackActionPerformed

    private void profileResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileResetActionPerformed
        String[] myArrayData = staff.myData;
        
        profileUsername.setText(myArrayData[0]);
        profileEmail.setText(myArrayData[1]);
        profilePassword1.setText(myArrayData[2]);
        profilePassword2.setText(myArrayData[2]);
        profileSecurity.setText(myArrayData[3]);
    }//GEN-LAST:event_profileResetActionPerformed

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
            java.util.logging.Logger.getLogger(modifyprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifyprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifyprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifyprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modifyprofile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton profileBack;
    private javax.swing.JTextField profileEmail;
    private javax.swing.JPasswordField profilePassword1;
    private javax.swing.JPasswordField profilePassword2;
    private javax.swing.JButton profileReset;
    private javax.swing.JButton profileSave;
    private javax.swing.JTextField profileSecurity;
    private javax.swing.JTextField profileUsername;
    // End of variables declaration//GEN-END:variables
}
