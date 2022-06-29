/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DataTest;

import Model.DataSource.DataWareHouse;
import Model.ErrorLog;
import com.alibaba.fastjson.JSONObject;
import javax.swing.JOptionPane;

/**
 *
 * @author 21AK22
 */
public class ProductData {

    private final DataWareHouse wareHouse;

    public ProductData() {
        this.wareHouse = new DataWareHouse();
    }
    
    public boolean setInputData(InputData inputData)
    {
        if (inputData == null) {
            String mess = "Input = null, can not to test!";
            JOptionPane.showMessageDialog(null, mess);
            ErrorLog.addError(mess);
            System.exit(1);
        }
        this.wareHouse.clear();
        return wareHouse.putAll(inputData.toJson());
    }

    public JSONObject toJson() {
        return this.wareHouse.toJson();
    }

    public void put(String key, Object data) {
        if (key == null || key.isBlank()) {
            return;
        }
        this.wareHouse.put(key, data);
    }

    public String getString(String key) {
        return this.wareHouse.getString(key);
    }

}
