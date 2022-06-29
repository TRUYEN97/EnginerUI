/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.subUI.FormDetail;

import View.subUI.FormDetail.TabItem.TabItem;
import Model.DataTest.FunctionData.FunctionData;
import java.awt.event.ActionEvent;
import java.util.Queue;
import javax.swing.Timer;

/**
 *
 * @author Administrator
 */
public class ItemLog extends javax.swing.JFrame {

    /**
     * Creates new form ItemLog
     */
    private FunctionData dataBox;
    private Queue<String> queueLog;
    private final Timer timer;
    private final TabItem tabItem;

    public ItemLog(TabItem tabItem) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        this.tabItem = tabItem;
        int a = 0;
        this.timer = new Timer(500, (ActionEvent e) -> {
            while (!queueLog.isEmpty()) {
                this.txtLog.append(queueLog.poll());
            }
        });
    }

    public void setlog(String data) {
        this.txtLog.setText(data);
    }

    public void appenLog(String data) {
        this.txtLog.append(data);
    }

    public void showLog() {
        this.setTitle(dataBox.getItemFunctionName());
        setVisible(true);
        if (dataBox.isTesting()) {
            this.timer.start();
        } else {
            this.txtLog.setText(dataBox.getLog());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        txtLog.setEditable(false);
        txtLog.setColumns(20);
        txtLog.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLog.setRows(5);
        jScrollPane2.setViewportView(txtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        stopTimer();
        this.tabItem.getItemLogs().remove(dataBox);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    private void stopTimer() {
        this.timer.stop();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables

    public void setDataBox(FunctionData dataBox) {
        this.dataBox = dataBox;
        this.queueLog = dataBox.getLoger().getQueueLog();
    }
}
