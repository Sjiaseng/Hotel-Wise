/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class mybooking extends javax.swing.JFrame {

    /**
     * Creates new form booking
     */
    public mybooking() {
        initComponents();
        bookingError.setVisible(false);
    }
    
    //number to iterates through booking.txt
    static int countlines() throws FileNotFoundException {
    File file = new File("Booking.txt");
    Scanner scanner = new Scanner(file);
    int count = 0;

    while (scanner.hasNextLine()) {
        scanner.nextLine();
        count++;
    }

    scanner.close();

    return count / 13 + 1; // Divide by 13 since each booking consists of 13 lines
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bookingBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bookingSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bookingformID = new javax.swing.JComboBox<>();
        bookingCheckin = new javax.swing.JButton();
        bookingformIC = new javax.swing.JComboBox<>();
        bookingCheckout = new javax.swing.JButton();
        bookingModify = new javax.swing.JButton();
        bookingDelete = new javax.swing.JButton();
        bookingError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        String[] COLUMN_NAMES = {"Room ID", "Level", "Size", "IC/Passport", "Name", "Email",
            "Contact", "Start Date", "End Date", "Days of stay", "Check In", "Check Out" };
        DefaultTableModel model = new DefaultTableModel(COLUMN_NAMES, 0);
        bookingTable.setModel(model);
        try (RandomAccessFile raf = new RandomAccessFile(new File("Booking.txt"), "r")) {

            String line;
            while ((line = raf.readLine()) != null) {
                String[] data = new String[13];
                data[0] = line.substring(9); //id
                line = raf.readLine();
                data[1] = line.substring(12); //level
                line = raf.readLine();
                data[2] = line.substring(11); //size
                line = raf.readLine();
                data[3] = line.substring(13); // ic
                line = raf.readLine();
                data[4] = line.substring(6); //name
                line = raf.readLine();
                data[5] = line.substring(7); //email
                line = raf.readLine();
                data[6] = line.substring(9); //contact
                line = raf.readLine();
                data[7] = line.substring(12); //start
                line = raf.readLine();
                data[8] = line.substring(10); //end
                line = raf.readLine();
                data[9] = line.substring(14); //day to stay
                line = raf.readLine();
                data[10] = line.substring(10); //checkin
                line = raf.readLine();
                data[11] = line.substring(11); //checkout
                line = raf.readLine();

                model.addRow(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        jScrollPane1.setViewportView(bookingTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 108, 1087, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Booking");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 22, -1, -1));

        bookingBack.setText("Back");
        bookingBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingBackActionPerformed(evt);
            }
        });
        getContentPane().add(bookingBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 25, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Search: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 68, -1, -1));

        bookingSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookingSearchKeyReleased(evt);
            }
        });
        getContentPane().add(bookingSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 68, 179, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Room ID + IC :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 100, -1));

        String roomid;

        RandomAccessFile raf = null;
        List<String> bookingidroom = new ArrayList<>();

        try {
            raf = new RandomAccessFile("Booking.txt", "rw");

            for (int i = 1; i < countlines(); i++) {

                roomid = raf.readLine().substring(9);
                raf.readLine();
                raf.readLine();
                raf.readLine();
                raf.readLine();
                raf.readLine();
                raf.readLine();
                raf.readLine();
                raf.readLine();
                raf.readLine();
                raf.readLine();
                raf.readLine();
                raf.readLine();
                if (!bookingidroom.contains(roomid)) {
                    bookingidroom.add(roomid);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Create a DefaultComboBoxModel to hold the IC/Passport data
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("None");
        // Iterate over the IC/Passport numbers and add them to the ComboBoxModel
        for (String room : bookingidroom) {
            comboBoxModel.addElement(room);
        }
        bookingformID.setModel(comboBoxModel);
        getContentPane().add(bookingformID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, 130, -1));

        bookingCheckin.setText("Check In");
        bookingCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingCheckinActionPerformed(evt);
            }
        });
        getContentPane().add(bookingCheckin, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, -1, -1));

        String customeric;

        RandomAccessFile raf2 = null;
        List<String> icpassport = new ArrayList<>();

        try {
            raf2 = new RandomAccessFile("Booking.txt", "rw");

            for (int i = 1; i < countlines(); i++) {

                raf2.readLine();
                raf2.readLine();
                raf2.readLine();
                customeric = raf2.readLine().substring(13);
                raf2.readLine();
                raf2.readLine();
                raf2.readLine();
                raf2.readLine();
                raf2.readLine();
                raf2.readLine();
                raf2.readLine();
                raf2.readLine();
                raf2.readLine();
                if (!icpassport.contains(customeric)) {
                    icpassport.add(customeric);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Create a DefaultComboBoxModel to hold the IC/Passport data
        DefaultComboBoxModel<String> comboBoxModel2 = new DefaultComboBoxModel<>();
        comboBoxModel2.addElement("None");
        // Iterate over the IC/Passport numbers and add them to the ComboBoxModel
        for (String ic : icpassport) {
            comboBoxModel2.addElement(ic);
        }
        bookingformIC.setModel(comboBoxModel2);
        getContentPane().add(bookingformIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, 130, -1));

        bookingCheckout.setText("Check Out");
        bookingCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingCheckoutActionPerformed(evt);
            }
        });
        getContentPane().add(bookingCheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 540, -1, -1));

        bookingModify.setText("Modify");
        bookingModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingModifyActionPerformed(evt);
            }
        });
        getContentPane().add(bookingModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, -1, -1));

        bookingDelete.setText("Delete");
        bookingDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(bookingDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 540, -1, -1));

        bookingError.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bookingError.setForeground(new java.awt.Color(255, 0, 51));
        bookingError.setText("Please fill up the information before proceed !");
        getContentPane().add(bookingError, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 572, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookingBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingBackActionPerformed
        menu a = new menu();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bookingBackActionPerformed
    
    private void bookingSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookingSearchKeyReleased
        //filter bookingtable
        DefaultTableModel obj = (DefaultTableModel) bookingTable.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        bookingTable.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(bookingSearch.getText()));
    }//GEN-LAST:event_bookingSearchKeyReleased

    private void bookingCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingCheckinActionPerformed
        try {
            //check in into the room
            String roomid = String.valueOf(bookingformID.getSelectedItem());
            String customeric = String.valueOf(bookingformIC.getSelectedItem());
            
            //Get the current date and time
            LocalDateTime currentDateTime = LocalDateTime.now();
            
            // Define the desired date and time format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            
            // Format the current date and time using the formatter
            String formattedDateTime = currentDateTime.format(formatter);
            
            if (roomid.equals("None") || customeric.equals("None")) {
                bookingError.setVisible(true);
                
            }
            else{
                bookingError.setVisible(false);
                booking obj1 = new booking(roomid, customeric, formattedDateTime);
                String res = obj1.checkin();

                if(res == "Success"){
                    JOptionPane.showMessageDialog(null,"Successfully Check In!","Check In",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(mybooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_bookingCheckinActionPerformed

    private void bookingCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingCheckoutActionPerformed
        try {
            //checkout from the room
            String roomid = String.valueOf(bookingformID.getSelectedItem());
            String customeric = String.valueOf(bookingformIC.getSelectedItem());
            
            //Get the current date and time
            LocalDateTime currentDateTime = LocalDateTime.now();
            
            // Define the desired date and time format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            
            // Format the current date and time using the formatter
            String formattedDateTime = currentDateTime.format(formatter);
            
            if (roomid.equals("None") || customeric.equals("None")) {
                bookingError.setVisible(true);
                
            }
            else{
                bookingError.setVisible(false);
                booking obj1 = new booking(roomid, customeric, formattedDateTime);
                String res = obj1.checkout();

                if(res == "Success"){
                    obj1.getData();
                    JOptionPane.showMessageDialog(null,"Successfully Checked Out!","Check Out",JOptionPane.INFORMATION_MESSAGE);

                    receipt a = new receipt();
                    a.setVisible(true);
                    this.setVisible(false);
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(mybooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookingCheckoutActionPerformed

    private void bookingModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingModifyActionPerformed
        //modfying the booking data
        String roomid = String.valueOf(bookingformID.getSelectedItem());
        String customeric = String.valueOf(bookingformIC.getSelectedItem());
        if (roomid.equals("None") || customeric.equals("None")) {
                bookingError.setVisible(true);
        }else{

            try {
                bookingError.setVisible(false);
                booking obj1 = new booking(roomid, customeric);
                String res = obj1.modifycontent();
                if(res == "Success"){
                    modifybooking a = new modifybooking();
                    a.setVisible(true);
                    this.setVisible(false);
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(mybooking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(mybooking.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        
    }//GEN-LAST:event_bookingModifyActionPerformed

    private void bookingDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingDeleteActionPerformed
        //deleting a booking data
        String roomid = String.valueOf(bookingformID.getSelectedItem());
        String customeric = String.valueOf(bookingformIC.getSelectedItem());
        if (roomid.equals("None") || customeric.equals("None")) {
                bookingError.setVisible(true);
        }else{
            try {
                bookingError.setVisible(false);
                booking obj1 = new booking(roomid, customeric);
                String res = obj1.deleterecord();
                
                if(res == "Success"){
                   JOptionPane.showMessageDialog(null,"Record Deleted!","Delete",JOptionPane.INFORMATION_MESSAGE);
                    mybooking a = new mybooking();
                    a.setVisible(true);
                    this.setVisible(false);
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(mybooking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bookingDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(mybooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mybooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mybooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mybooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mybooking().setVisible(true);
            }
        });
    }
    
    

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookingBack;
    private javax.swing.JButton bookingCheckin;
    private javax.swing.JButton bookingCheckout;
    private javax.swing.JButton bookingDelete;
    private javax.swing.JLabel bookingError;
    private javax.swing.JButton bookingModify;
    private javax.swing.JTextField bookingSearch;
    private javax.swing.JTable bookingTable;
    private javax.swing.JComboBox<String> bookingformIC;
    private javax.swing.JComboBox<String> bookingformID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    String writeBooking() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
