/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * TagLog.java
 *
 * Created on Feb 7, 2022, 6:28:13 PM
 */
package View.subUI.FormDetail;

import Model.DataModeTest.DataBoxs.DataBox;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class TabItem extends AbsTabUI {

    private static final int VID_TABLE = 1;
    private final Vector<String> testColumn;
    private final Vector<String> listFunc;
    private DefaultTableModel tableModel;
    private static final int ADD_NEW_ROW = -1;

    /**
     * Creates new form TagLog
     */
    public TabItem() {
        super("Item");
        initComponents();
        this.testColumn = new Vector<>();
        this.testColumn.add("STT");
        this.testColumn.add("Item");
        this.testColumn.add("Time");
        this.testColumn.add("Staus");
        this.testColumn.add("Result");
        this.testColumn.add("Cus error code");
        this.testColumn.add("Error code");
        this.listFunc = new Vector<>();
        this.listFunc.add("STT");
        this.listFunc.add("Item");
        initTable(this.testColumn);
    }

    private void initTable(Vector<String> column) {
        int maxWith = (int) ((this.getWidth() - VID_TABLE) / 6);
        int minWith = (int) (maxWith / 3);
        int[] sizeColumn = {minWith, maxWith, minWith,minWith, minWith, maxWith, maxWith};
        this.tableItem.setModel(
                new javax.swing.table.DefaultTableModel(null, column) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        this.tableItem.getTableHeader().setReorderingAllowed(true);//
        this.tableItem.setShowGrid(true);
        this.tableModel = (DefaultTableModel) this.tableItem.getModel();
        for (int i = 0; i < column.size(); i++) {
            setPropertiesColumn(i, sizeColumn[i], JLabel.CENTER, JLabel.CENTER);
        }
    }

    private void setPropertiesColumn(int index, int width, int alignment, int header) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(alignment);
        this.tableItem.getColumnModel().getColumn(index).setMinWidth(width);
        this.tableItem.getColumnModel().getColumn(index).setCellRenderer(renderer);
        this.tableItem.getColumnModel().getColumn(index).setResizable(false);
        DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
        renderer1.setHorizontalTextPosition(header);
        this.tableItem.getColumnModel().getColumn(index).setHeaderRenderer(renderer);
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
        tableItem = new javax.swing.JTable();

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tableItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableItem.setGridColor(new java.awt.Color(0, 0, 0));
        tableItem.setName("tableItem"); // NOI18N
        tableItem.setRowHeight(22);
        tableItem.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tableItem.setShowGrid(false);
        tableItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemMouseClicked(evt);
            }
        });
        tableItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableItemKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tableItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void tableItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableItemKeyTyped
// TODO add your handling code here:
    keyEvent(evt);
}//GEN-LAST:event_tableItemKeyTyped

    private void tableItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableItemMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableItem;
    // End of variables declaration//GEN-END:variables

    public TabItem cloneUI(String name) {
        TabItem tabItem = new TabItem();
        tabItem.setName(name);
        return tabItem;
    }

    private void showListFunction() {
        initTable(listFunc);
        for (String funcName : this.uiStatus.getModeTest().getListItemFunctionName()) {
            this.tableModel.addRow(new Object[]{this.tableModel.getRowCount(), funcName});
        }
    }

    @Override
    public void keyEvent(KeyEvent evt) {
        if (!isVisible()) {
            return;
        }
        if (evt.getKeyChar() == CTRL_S) {
            showListFunction();
        }
    }
    private static final int CTRL_S = 19;

    @Override
    public void startTest() {
        super.startTest();
        initTable(testColumn);
    }

    @Override
    public void updateData() {
        List<DataBox> dataBoxs = this.uiStatus.getUiData().getDataBoxs();
        if (dataBoxs.isEmpty()) {
            return;
        }
        for (DataBox dataBox : dataBoxs) {
            
        }
        for (DataBox dataBox : dataBoxs) {
            if (dataBoxs.size() > this.tableModel.getRowCount()) {
                this.tableModel.addRow(new Object[]{this.tableModel.getRowCount()});
            }
            this.tableModel.setValueAt(dataBox.getItemName(), dataBoxs.indexOf(dataBox), 1);
            this.tableModel.setValueAt(dataBox.getResultTest(), dataBoxs.indexOf(dataBox), 4);
        }
    }
}
