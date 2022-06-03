/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Functions;

import Control.Core.ModeTest;
import Model.DataSource.FunctionConfig.FunctionConfig;
import Model.DataSource.FunctionConfig.FunctionElement;
import Model.DataSource.Limit.Limit;
import Model.ManagerUI.UIStatus.Elemants.UiData;
import Model.ManagerUI.UIStatus.UiStatus;
import View.subUI.SubUI.AbsSubUi;
import Model.Interface.IFunction;
import Model.DataModeTest.DataBoxs.FunctionData;
import Model.DataModeTest.ErrorLog;

/**
 *
 * @author 21AK22
 */
public abstract class AbsFunction implements IFunction {

    protected final FunctionElement funcConfig;
    protected final Limit limit;
    protected UiData uIData;
    protected FunctionData dataBox;
    protected ModeTest modeTest;
    protected AbsSubUi subUi;

    protected AbsFunction(String itemName) {
        this.funcConfig = FunctionConfig.getInstance().getElement(itemName);
        this.limit = Limit.getInstance();
    }

    public void setUIStatus(UiStatus uiStatus) {
        this.uIData = uiStatus.getUiData();
        this.subUi = uiStatus.getSubUi();
        this.modeTest = uiStatus.getModeTest();
    }

    public FunctionElement getFuncConfig() {
        return funcConfig;
    }

    @Override
    public void run() {
        try {
            if (isModeSkip()) {
                this.dataBox.addLog("Mode Skip: " + modeTest.toString());
                this.dataBox.addLog("This function will be canceled because the mode is " + modeTest.toString());
                this.dataBox.setResult("Canceled");
                this.dataBox.setPass();
                return;
            }
            for (int turn = 0; turn < getRetry(); turn++) {
                this.dataBox.addLog(String.format("Turn %s:", turn));
                if (test()) {
                    this.dataBox.setPass();
                    return;
                }
            }
            this.dataBox.setFail();
        } catch (Exception e) {
            ErrorLog.addError(e.getLocalizedMessage());
            this.addLog(e.getMessage());
        }
    }

    public ModeTest getModeTest() {
        return modeTest;
    }

    public void setRsutlt(String result) {
        this.dataBox.setResult(result);
    }

    public abstract boolean test();

    @Override
    public boolean isPass() {
        return dataBox.isPass();
    }

    public String getItemName() {
        return this.funcConfig.getItemName();
    }

    public String getFuncName() {
        return this.funcConfig.getFunctionName();
    }

    public void addLog(Object str) {
        this.dataBox.addLog(str);
    }

    public double getRunTime() {
        return dataBox.getRunTime();
    }

    void createDataBox() {
        this.dataBox = this.uIData.getDataBox(funcConfig.getItemName());
        if (funcConfig.isMutiTasking()) {
            this.dataBox.setMultistacking();
        }
        this.dataBox.start();
    }

    void end() {
        this.dataBox.end();
    }

    private int getRetry() {
        if (funcConfig != null) {
            return funcConfig.getRetry();
        }
        return 1;
    }

    private boolean isModeSkip() {
        String modeSkip = this.funcConfig.getModeCancel();
        return modeSkip != null && !modeSkip.isBlank() && modeSkip.equals(modeTest.toString());
    }

    String getResult() {
        return this.dataBox.getResultTest();
    }

    public UiData getUiData() {
        return uIData;
    }
}
