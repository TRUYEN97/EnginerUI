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

    private final Vector<String> testColumn;
    private final Vector<String> listFunc;
    private final ItemLog itemLog;
    private DefaultTableModel tableModel;

    /**
     * Creates new form TagLog
     */
    public TabItem() {
        super(ITEM);
        initComponents();
        this.testColumn = new Vector<>();
        this.listFunc = new Vector<>();
        addTestClomn();
        addListClomn();
        initTable(this.testColumn);
        this.itemLog = new ItemLog();
    }

    private void addListClomn() {
        this.listFunc.add("STT");
        this.listFunc.add(ITEM);
    }

    private void addTestClomn() {
        this.testColumn.add("STT");
        this.testColumn.add(ITEM);
        this.testColumn.add(TIME);
        this.testColumn.add(STAUS);
        this.testColumn.add("Cus error code");
        this.testColumn.add("Error code");
    }
    private static final String STAUS = "Staus";
    private static final String TIME = "Time";
    private static final String ITEM = "Item";

    private void initTable(Vector<String> column) {
        int maxWith = (int) ((this.getWidth() - 1) / 6);
        int minWith = (int) (maxWith / 3);
        int[] sizeColumn = {minWith, maxWith, minWith, minWith, maxWith, maxWith};
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
        if (evt.getClickCount() > 1) {
            int row = this.tableItem.getSelectedRow();
            System.out.println(row);
            DataBox dataBox = this.uiStatus.getUiData().getDataBox(row);
            if (dataBox == null) {
                return;
            }
            this.itemLog.setDataBox(dataBox);
            this.itemLog.showLog();
        }
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
        if (evt.getKeyChar() == CTRL_S && !this.uiStatus.isTesting()) {
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
    public void endTest() {
        updateData();
        super.endTest();
    }

    @Override
    public void updateData() {
        if (!this.isVisible()) {
            this.tableModel.setRowCount(0);
            return;
        }
        List<DataBox> dataBoxs = this.uiStatus.getUiData().getDataBoxs();
        for (DataBox dataBox : dataBoxs) {
            int row = dataBoxs.indexOf(dataBox);
            if (row > this.tableModel.getRowCount() - 1) {
                this.tableModel.addRow(new Object[]{this.tableModel.getRowCount()});
                editRow(dataBox.getItemName(), row, ITEM);
                editRow(dataBox.getRunTime(), row, TIME);
                editRow(getStatus(dataBox), row, STAUS);
            } else {
                editRow(dataBox.getRunTime(), row, TIME);
                editRow(getStatus(dataBox), row, STAUS);
            }
        }
    }

    private void editRow(Object value, int row, String colmn) {
        if (row < 0 || !this.testColumn.contains(colmn)) {
            return;
        }
        this.tableModel.setValueAt(value, row, this.testColumn.indexOf(colmn));
    }

    private Object getStatus(DataBox dataBox) {
        if (!dataBox.isTesting()) {
            return dataBox.getResultTest();
        }
        if (dataBox.isMultiStacking()) {
            return "Multistacking";
        } else {
            return "Testing";
        }
    }
}
