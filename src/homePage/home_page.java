/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package homePage;

import expense_screen.*;
import income_screen.*;
import saving_screen.saving_history;

import saving_screen.saving_page;

/**
 *
 * @author nadiaislam
 */
public class home_page extends javax.swing.JFrame {

    static int user_id;

    /**
     * Creates new form home_page
     *
     * @param user_id
     */
    public home_page(int user_id) {
        home_page.user_id = user_id;
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

        incomeB = new javax.swing.JButton();
        saveB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        expenseB = new javax.swing.JButton();
        shB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        incomeB.setFont(new java.awt.Font("Cantarell", 0, 25)); // NOI18N
        incomeB.setForeground(new java.awt.Color(51, 204, 0));
        incomeB.setText("Income Page");
        incomeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeBActionPerformed(evt);
            }
        });

        saveB.setFont(new java.awt.Font("Cantarell", 0, 25)); // NOI18N
        saveB.setForeground(new java.awt.Color(153, 0, 153));
        saveB.setText("Savings Page");
        saveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 39)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("Home Page");

        expenseB.setFont(new java.awt.Font("Cantarell", 0, 25)); // NOI18N
        expenseB.setForeground(new java.awt.Color(255, 0, 51));
        expenseB.setText("Expenses page");
        expenseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseBActionPerformed(evt);
            }
        });

        shB.setText("Savings History");
        shB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(expenseB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(incomeB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(shB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(incomeB)
                .addGap(52, 52, 52)
                .addComponent(expenseB)
                .addGap(46, 46, 46)
                .addComponent(saveB)
                .addGap(18, 18, 18)
                .addComponent(shB)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void incomeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incomeBActionPerformed
        // TODO add your handling code here:
        new show_income(user_id).setVisible(true);
        dispose();
    }//GEN-LAST:event_incomeBActionPerformed

    private void expenseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseBActionPerformed
        // TODO add your handling code here:
        ShowExpense show = new ShowExpense(user_id);
        show.setVisible(true);
        dispose();
    }//GEN-LAST:event_expenseBActionPerformed

    private void saveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBActionPerformed
        // TODO add your handling code here:
        saving_page saving = new saving_page(user_id);
        saving.setVisible(true);
        dispose();
    }//GEN-LAST:event_saveBActionPerformed

    private void shBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shBActionPerformed
        // TODO add your handling code here:
        new saving_history(user_id).setVisible(true);
        dispose();
    }//GEN-LAST:event_shBActionPerformed

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
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home_page(user_id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton expenseB;
    private javax.swing.JButton incomeB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton saveB;
    private javax.swing.JButton shB;
    // End of variables declaration//GEN-END:variables
}
