/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Control.Core.Core;
import Control.Core.ModeTest;
import Control.LoadModelTime.LoadModeTime;
import Control.CheckInput;
import Model.DataSource.PcInformation;
import View.subUI.SubUI.AbsSubUi;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author Administrator
 */
public class UIView extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    private final LoadModeTime modeTime;
    private final DefaultComboBoxModel comboBoxModel;
    private CheckInput checkInput;
    private Core core;

    public UIView() {
        this.modeTime = new LoadModeTime();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        initComponents();
        this.comboBoxModel = (DefaultComboBoxModel) this.cbbModeTest.getModel();
    }

    public void showPcName(String pcName) {
        if (pcName == null) {
            return;
        }
        this.lbNamePC.setText(pcName);
    }
    
    public void showIp(String ip) {
        if (ip == null) {
            return;
        }
        this.lbIP.setText(ip);
    }
    
    public void setPnName(String pnName) {
        if (pnName == null) {
            return;
        }
        this.lbProductname.setText(pnName);
    }
    
    public void showGiaiDoan(String giaiDoan) {
        if (giaiDoan == null) {
            return;
        }
        this.lbGiaiDoan.setText(giaiDoan);
    }

    public void setCheckInput(CheckInput checkInput) {
        this.checkInput = checkInput;
    }

    public void setBoardSubUISize(int row, int column) {
        this.BoardSubUI.removeAll();
        this.BoardSubUI.setLayout(new GridLayout(row, column, 2, 2));
    }

    public void addSubUi(AbsSubUi subUi) {
        subUi.setUiView(this);
        this.BoardSubUI.add(subUi);
        this.BoardSubUI.updateUI();
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public Core getCore() {
        return core;
    }

    public void setMode(List<ModeTest> modeTests) {
        this.comboBoxModel.addAll(modeTests);
    }

    public void setSelectMode(ModeTest currMode) {
        this.comboBoxModel.setSelectedItem(currMode);
    }

    public void setInputText(String mess) {
        this.txtInput.setText(mess);
    }

    public void setShowText(String mess) {
        this.txtShow.setText(mess);
    }

    public void showMessager(String mess) {
        this.textMess.setText(mess);
    }

    public JTextArea getTextMess() {
        return textMess;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        lbNamePC = new javax.swing.JLabel();
        lbIP = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbProductname = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbGiaiDoan = new javax.swing.JLabel();
        lbTimeVN = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textMess = new javax.swing.JTextArea();
        cbbModeTest = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtShow = new javax.swing.JTextArea();
        BoardSubUI = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AmbitUI");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelBackground.setBackground(new java.awt.Color(0, 0, 0));
        panelBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelBackground.setPreferredSize(new java.awt.Dimension(1104, 768));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        txtInput.setEditable(false);
        txtInput.setColumns(20);
        txtInput.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        txtInput.setLineWrap(true);
        txtInput.setRows(2);
        txtInput.setWrapStyleWord(true);
        txtInput.setMinimumSize(new java.awt.Dimension(113, 200));
        txtInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInputKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtInput);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbNamePC.setBackground(new java.awt.Color(102, 102, 102));
        lbNamePC.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lbNamePC.setForeground(new java.awt.Color(255, 255, 255));
        lbNamePC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNamePC.setText("----------");
        lbNamePC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbNamePC.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbIP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbIP.setForeground(new java.awt.Color(255, 255, 255));
        lbIP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIP.setText("---");
        lbIP.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNamePC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbIP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbIP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNamePC, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbProductname.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lbProductname.setForeground(new java.awt.Color(255, 255, 255));
        lbProductname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProductname.setText("----------");
        lbProductname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbProductname.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbProductname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbProductname, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbGiaiDoan.setBackground(new java.awt.Color(153, 153, 255));
        lbGiaiDoan.setFont(new java.awt.Font("Arial 14 粗体", 1, 20)); // NOI18N
        lbGiaiDoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGiaiDoan.setText("---");
        lbGiaiDoan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbGiaiDoan.setOpaque(true);

        lbTimeVN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTimeVN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTimeVN.setText("14 : 45 : 00");
        lbTimeVN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbTimeVN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTimeVNMouseClicked(evt);
            }
        });

        textMess.setEditable(false);
        textMess.setColumns(20);
        textMess.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        textMess.setLineWrap(true);
        textMess.setRows(4);
        textMess.setWrapStyleWord(true);
        textMess.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(textMess);

        cbbModeTest.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbbModeTest.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbModeTestItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(lbGiaiDoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTimeVN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbModeTest, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbGiaiDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbModeTest, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTimeVN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        this.cbbModeTest.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList jList, Object o, int i, boolean b, boolean b1) {
                JLabel rendrlbl = (JLabel) super.getListCellRendererComponent(jList, o, i, b, b1);    //todo: override
                rendrlbl.setHorizontalAlignment(SwingConstants.CENTER);
                return rendrlbl;
            }
        });

        txtShow.setEditable(false);
        txtShow.setColumns(20);
        txtShow.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtShow.setLineWrap(true);
        txtShow.setRows(3);
        txtShow.setWrapStyleWord(true);
        txtShow.setMinimumSize(new java.awt.Dimension(113, 200));
        txtShow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtShowKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtShow);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        BoardSubUI.setBackground(new java.awt.Color(51, 51, 51));
        BoardSubUI.setPreferredSize(new java.awt.Dimension(794, 700));

        javax.swing.GroupLayout BoardSubUILayout = new javax.swing.GroupLayout(BoardSubUI);
        BoardSubUI.setLayout(BoardSubUILayout);
        BoardSubUILayout.setHorizontalGroup(
            BoardSubUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        BoardSubUILayout.setVerticalGroup(
            BoardSubUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoardSubUI, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BoardSubUI, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyTyped
        checkinput(evt.getKeyChar());
    }//GEN-LAST:event_txtInputKeyTyped

    private void checkinput(char input) throws HeadlessException {
        if (this.checkInput == null) {
            return;
        }
        this.checkInput.inputAnalysis(input);
    }


    private void lbTimeVNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTimeVNMouseClicked
        // TODO add your handling code here:
        modeTime.next();
    }//GEN-LAST:event_lbTimeVNMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        modeTime.setLabel(this.lbTimeVN);
        modeTime.setBackground(this.BoardSubUI);
        modeTime.run();
    }//GEN-LAST:event_formWindowOpened

    private void txtShowKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtShowKeyTyped
        checkinput(evt.getKeyChar());
    }//GEN-LAST:event_txtShowKeyTyped

    private void cbbModeTestItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbModeTestItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ModeTest item = (ModeTest) evt.getItem();
            this.core.setCurrMode(item);
        }
    }//GEN-LAST:event_cbbModeTestItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BoardSubUI;
    private javax.swing.JComboBox<String> cbbModeTest;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbGiaiDoan;
    private javax.swing.JLabel lbIP;
    private javax.swing.JLabel lbNamePC;
    private javax.swing.JLabel lbProductname;
    private javax.swing.JLabel lbTimeVN;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JTextArea textMess;
    private javax.swing.JTextArea txtInput;
    private javax.swing.JTextArea txtShow;
    // End of variables declaration//GEN-END:variables

}
