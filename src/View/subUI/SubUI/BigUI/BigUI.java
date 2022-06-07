/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.subUI.SubUI.BigUI;

import View.subUI.SubUI.AbsSubUi;

/**
 *
 * @author Administrator
 */
public class BigUI extends AbsSubUi {

    
    /**
     * Creates new form BigUI
     * @param indexName
     */
    public BigUI(String indexName) {
        super(indexName, 500);
        initComponents();
        this.PanelUp.add(this.tabDetail);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUp = new javax.swing.JPanel();
        panelDown = new javax.swing.JPanel();
        Process = new javax.swing.JProgressBar();
        lbItemName = new javax.swing.JLabel();
        btTest = new javax.swing.JButton();
        lbTime = new javax.swing.JLabel();

        PanelUp.setLayout(new java.awt.BorderLayout());

        panelDown.setBackground(new java.awt.Color(153, 153, 153));

        lbItemName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbItemName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbItemName.setText("Item");
        lbItemName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btTest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btTest.setText("Test");
        btTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTestActionPerformed(evt);
            }
        });

        lbTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTime.setText("00:00");

        javax.swing.GroupLayout panelDownLayout = new javax.swing.GroupLayout(panelDown);
        panelDown.setLayout(panelDownLayout);
        panelDownLayout.setHorizontalGroup(
            panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbItemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Process, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDownLayout.createSequentialGroup()
                        .addComponent(btTest, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDownLayout.setVerticalGroup(
            panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDownLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbItemName)
                    .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Process, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(panelDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTestActionPerformed
        // TODO add your handling code here:
        //    this.loadMode.getCurrentMode().iWannaDedug(null, this);
    }//GEN-LAST:event_btTestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelUp;
    private javax.swing.JProgressBar Process;
    private javax.swing.JButton btTest;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbTime;
    private javax.swing.JPanel panelDown;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setText(String txt) {
    }

    @Override
    public void updateData() {
        lbTime.setText(getTestTime());
    }

   
}
