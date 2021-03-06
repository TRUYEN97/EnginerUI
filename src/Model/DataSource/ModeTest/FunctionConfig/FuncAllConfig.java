/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DataSource.ModeTest.FunctionConfig;

import Model.AllKeyWord;
import Model.DataSource.DataWareHouse;
import Model.DataSource.ModeTest.ErrorCode.ErrorCodeElement;
import Model.DataSource.ModeTest.Limit.Limit;
import Model.DataSource.ModeTest.Limit.LimitElement;
import Model.ErrorLog;
import Model.ManagerUI.UIStatus.UiStatus;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class FuncAllConfig {

    private final DataWareHouse wareHouse;
    private final String itemName;
    private FunctionElement functionElement;
    private LimitElement limitElement;
    private Limit limit;
    private ErrorCodeElement localErrorCode;
    private static final String CHECK = ".+_[0-9]+$";

    public FuncAllConfig(String itemConfig) {
        this.wareHouse = new DataWareHouse();
        this.itemName = itemConfig;
    }
    
   public void setResources(UiStatus uiStatus, FunctionElement functionElement) {
        this.functionElement = functionElement;
        if(this.functionElement == null)
        {
            JOptionPane.showMessageDialog(null, 
                    String.format("Missing %s in the function config!", this.itemName));
            System.exit(0);
        }
        this.limit = uiStatus.getModeTest().getModeTestSource().getLimit();
        this.limitElement = findLimit(itemName);
        this.localErrorCode = uiStatus.getModeTest().
                getModeTestSource().getErrorCodeSource().getElement( itemName);
        getAllValueOfConfig();
        getAllValueOfLimit();
    }

    private LimitElement findLimit(String itemName) {
        if (itemName.matches(CHECK) && getLimit(itemName) == null) {
            String newItemName = itemName.substring(0, itemName.lastIndexOf("_"));
            return getLimit(newItemName);
        }
        return getLimit(itemName);
    }

    private LimitElement getLimit(String nameItem) {
        return this.limit.getElement(nameItem);
    }

    public JSONObject getLocalErrorCode(String type) {
        if (localErrorCode == null) {
            String mess = String.format("Missing error code of %s - %s type !!",
                    this.functionElement.getItemName(), type);
            JOptionPane.showMessageDialog(null, mess);
            ErrorLog.addError(this, mess);
            return null;
        }
        return this.localErrorCode.getErrorType(type);
    }

    private void getAllValueOfLimit() {
        if (this.limitElement == null) {
            return;
        }
        this.wareHouse.putAll(limitElement.getJson());
    }

    private void getAllValueOfConfig() {
        this.wareHouse.putAll(this.functionElement.getJson());
    }

    public Limit getLimits() {
        return this.limit;
    }

    public String getFunctionName() {
        return this.functionElement.getFunctionName();
    }

    public String getString(String key) {
        return wareHouse.getString(key);
    }

    public Object getObject(String key) {
        return wareHouse.get(key);
    }

    public List<String> getListJsonArray(String key) {
        return wareHouse.getListJsonArray(key);
    }

    public List<String> getListSlip(String key, String regex) {
        return wareHouse.getListSlip(key, regex);
    }

    public String getTestType() {
        return wareHouse.getString(AllKeyWord.LIMIT_TYPE);
    }

    public boolean isLimitAvailable() {
        return limitFileAvailable() || funcConfigAvailable();
    }

    private boolean limitFileAvailable() {
        return this.limitElement != null
                && this.limitElement.getInteger(AllKeyWord.REQUIRED) != null
                && this.limitElement.getInteger(AllKeyWord.REQUIRED) > 0
                && (!this.limitElement.getString(AllKeyWord.LOWER_LIMIT).isBlank()
                || !this.limitElement.getString(AllKeyWord.UPPER_LIMIT).isBlank());
    }

    private boolean funcConfigAvailable() {
        return this.functionElement != null
                && this.functionElement.getString(AllKeyWord.LIMIT_TYPE) != null
                && (!this.functionElement.getString(AllKeyWord.LOWER_LIMIT).isBlank()
                || !this.functionElement.getString(AllKeyWord.UPPER_LIMIT).isBlank());
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getInteger(String key) {
        return this.wareHouse.getInteger(key);
    }

    public Integer getInteger(String key, int defaultV) {
        Integer value = getInteger(key);
        return value == null ? defaultV : value;
    }
}
