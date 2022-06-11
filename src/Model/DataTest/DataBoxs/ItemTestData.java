/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DataTest.DataBoxs;

import Model.AllKeyWord;
import Model.DataTest.FuncAllConfig;
import MyLoger.MyLoger;
import Time.TimeBase;
import Time.WaitTime.Class.TimeS;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author 21AK22
 */
public class ItemTestData {

    private final String itemTestName;
    private final FuncAllConfig allConfig;
    private final JSONObject data;
    private final TimeS timeS;
    private MyLoger loger;
    private String result;
    private boolean isPass;
    private boolean testing;

    public ItemTestData(String itemTestName, FuncAllConfig allConfig) {
        this.itemTestName = itemTestName;
        this.allConfig = allConfig;
        this.data = new JSONObject();
        this.timeS = new TimeS();
        this.isPass = false;
    }

    public void start() {
        this.timeS.start(0);
        this.testing = true;
        this.data.put(AllKeyWord.TEST_NAME, this.itemTestName);
        this.data.put(AllKeyWord.START_TIME, new TimeBase().getSimpleDateTime());
    }

    public void put(String key, String value) {
        this.data.put(key, value);
    }

    public String getString(String key) {
        return data.getString(key);
    }

    public String getItemTestName() {
        return itemTestName;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean isPass) {
        this.isPass = isPass;
    }

    public void end() {
        if (!this.isPass()) {
            addErrorCode();
        }
        addResult();
        this.data.put(AllKeyWord.STATUS, isPass ? "passed" : "failed");
        this.data.put(AllKeyWord.CYCLE_TIME, String.format("%.3f", timeS.getTime()));
        this.data.put(AllKeyWord.FINISH_TIME, new TimeBase().getSimpleDateTime());
        logEnd();
        this.testing = false;
    }

    private void addResult() {
        if (result == null) {
            this.data.put(AllKeyWord.TEST_VALUE, isPass ? "PASS" : "FAIL");
        } else {
            this.data.put(AllKeyWord.TEST_VALUE, result);
        }
    }

    private void addErrorCode() {
        String errorCode = allConfig.getString(AllKeyWord.ERROR_CODE);
        this.data.put(AllKeyWord.ERROR_DES, itemTestName);
        if (errorCode != null && !errorCode.isBlank()) {
            this.data.put(AllKeyWord.ERROR_CODE, errorCode);
        } else {
            this.data.put(AllKeyWord.ERROR_CODE, "-1");
        }
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultTest() {
        return this.data.getString(AllKeyWord.TEST_VALUE);
    }

    public boolean isTest() {
        return testing;
    }

    public double getRunTime() {
        if (isTest()) {
            return timeS.getTime();
        }
        return this.data.getDouble(AllKeyWord.CYCLE_TIME);
    }

    void setLoger(MyLoger loger) {
        this.loger = loger;
    }

    private void logEnd() {
        String upperLimit = this.data.getString(AllKeyWord.UPPER_LIMIT);
        String lowerLimit = this.data.getString(AllKeyWord.LOWER_LIMIT);
        String value = this.data.getString(AllKeyWord.TEST_VALUE);
        String mess = String.format("""
                                            Upper limit: %s\r
                                            Lower limit: %s\r
                                            Value      : %s\r
                                            Item Name  : %s
                                            """, upperLimit,
                lowerLimit,
                value, itemTestName
        );
        this.loger.addLog(mess);
    }

}
