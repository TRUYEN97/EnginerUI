/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.subUI.FormDetail.TabFaApi;

import Model.DataTest.InputData;
import Model.DataSource.Tool.FileService;
import View.subUI.FormDetail.AbsTabUI;
import com.alibaba.fastjson.JSONObject;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Administrator
 */
public class TabFaApi extends AbsTabUI {

    public static final String REPAIR_DETAIL = "RepairDetail";
    public static final String REASON_DES = "ReasonDes";
    public static final String LOCATION = "Location";
    public static final String ACTION = "Action";
    public static final String MY_KEY = "FA_API";

    private final FormOption formOption;
    private final Map<String, String> keys;

    /**
     * Creates new form TabFaApi
     *
     * @param type
     */
    public TabFaApi(String type) {
        super("Fa API", type, 500);
        this.formOption = new FormOption();
        initComponents();
        initListLocation("listLocation.txt");
        AutoCompleteDecorator.decorate(cbbLocation);
        this.keys = new HashMap<>();
        this.keys.put("- Fail at", InputData.FAIL_PC);
        this.keys.put("- Debug at", InputData.DEBUG_PC);
        this.keys.put("- Error code ", InputData.ERROR_CODE);
        this.keys.put("- Error Des ", InputData.ERROR_DES);
        this.keys.put("- Count", InputData.COUNTTEST);
    }

    private void initListLocation(String path) {
        File file = new File(path);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, String.format("%s not exists!", path));
        }
        String data = new FileService().readFile(file);
        if (data == null) {
            JOptionPane.showMessageDialog(null, String.format("%s is null!", path));
            return;
        }
        this.cbbLocation.setModel(new DefaultComboBoxModel(data.split("\r\n")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btAddArea = new javax.swing.JButton();
        cbbLocation = new javax.swing.JComboBox();
        pnSelectOption = new javax.swing.JPanel();
        btXacNhan = new javax.swing.JButton();
        lbInfo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 255));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Repair part/location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btAddArea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAddArea.setText("add");
        btAddArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddAreaActionPerformed(evt);
            }
        });

        cbbLocation.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cbbLocation.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAddArea)
                .addGap(18, 18, 18)
                .addComponent(cbbLocation, 0, 251, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btAddArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cbbLocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pnSelectOption.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnSelectOption.setLayout(new java.awt.BorderLayout());

        btXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btXacNhan.setText("Xác Nhận");
        btXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacNhanActionPerformed(evt);
            }
        });

        lbInfo.setBackground(new java.awt.Color(255, 255, 255));
        lbInfo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInfo.setText("...");
        lbInfo.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnSelectOption, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btXacNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSelectOption, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btXacNhan)
                .addGap(14, 14, 14))
        );

        pnSelectOption.add(this.formOption);
    }// </editor-fold>//GEN-END:initComponents

    private void addNewTab() {
        Object item = this.cbbLocation.getSelectedItem();
        if (item == null) {
            return;
        }
        this.formOption.addNewTab(item.toString(), new TabOption(item.toString()));
    }

    private void btAddAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddAreaActionPerformed
        // TODO add your handling code here:
        addNewTab();
    }//GEN-LAST:event_btAddAreaActionPerformed

    private void btXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacNhanActionPerformed
        // TODO add your handling code here:
        if (!checkSelectData()) {

            return;
        }
        this.formOption.config();
    }//GEN-LAST:event_btXacNhanActionPerformed

    @Override
    public void startTest() {
        super.startTest();
        this.uiStatus.getUiData().putToSignal(MY_KEY, this);
    }

    public boolean checkDataHasChange() {
        return this.formOption.hasChange();
    }

    public boolean checkSelectData() throws HeadlessException {
        // TODO add your handling code here:
        if (this.formOption.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy điền và xác nhận đầy đủ thông tin!");
            return false;
        }
        return true;
    }

    @Override
    public void keyEvent(KeyEvent evt) {
        if (!isVisible()) {
            return;
        }
        if (evt.getKeyChar() == CTRL_D) {
            this.formOption.removeAllTab();
        }
    }
    private static final int CTRL_D = 4;

    @Override
    public void updateData() {
        StringBuilder data = new StringBuilder("<html>");
        for (String key : keys.keySet()) {
            String value = this.uiStatus.getUiData().getProductInfo(keys.get(key));
            if (value != null) {
                data.append(String.format("<tr><td>%s</td><td>: %s</td></tr>", key, value));
            }
        }
        data.append("</html>");
        if (!this.lbInfo.getText().equals(data.toString())) {
            this.lbInfo.setText(data.toString());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddArea;
    private javax.swing.JButton btXacNhan;
    private javax.swing.JComboBox cbbLocation;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JPanel pnSelectOption;
    // End of variables declaration//GEN-END:variables

    public boolean isTabEmpty() {
        return this.formOption.isEmpty();
    }

    public JSONObject getData() {
        return this.formOption.getData();
    }

}