/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Functions;

import Model.DataSource.ModeTest.FunctionConfig.FunctionElement;
import Model.ManagerUI.UIStatus.Elemants.UiData;
import Model.ManagerUI.UIStatus.UiStatus;
import View.subUI.SubUI.AbsSubUi;
import Model.Interface.IFunction;
import Model.DataTest.DataBoxs.FunctionData;
import Model.DataTest.DataBoxs.ItemTestData;
import Model.DataTest.FuncAllConfig;

/**
 *
 * @author 21AK22
 */
public abstract class AbsFunction implements IFunction {

    protected final FuncAllConfig allConfig;
    protected UiData uiData;
    protected AbsSubUi subUi;
    private ItemTestData itemTestData;
    private AnalysisResult analysisResult;
    private FunctionData functionData;

    protected AbsFunction(String functionName) {
        this.allConfig = new FuncAllConfig(functionName);
    }

    public void setResources(UiStatus uiStatus, FunctionData functionData, FunctionElement funcConfig) {
        this.functionData = functionData;
        this.allConfig.setResources(uiStatus, funcConfig);
        this.itemTestData = new ItemTestData(allConfig);
        this.analysisResult = new AnalysisResult(itemTestData, allConfig);
        this.uiData = uiStatus.getUiData();
        this.subUi = uiStatus.getSubUi();
        this.functionData.addItemtest(itemTestData);
        this.itemTestData.start();
    }

    @Override
    public void run() {
        this.analysisResult.checkResult(test(), getResult());
        this.itemTestData.endThisTurn();
    }

    protected abstract boolean test();

    protected void addLog(Object str) {
        this.functionData.addLog(str);
    }

    @Override
    public boolean isPass() {
        return itemTestData.isPass();
    }

    protected void setResult(String result) {
        this.itemTestData.setResult(result);
    }

    public String getFuntionName() {
        return this.allConfig.getFunctionName();
    }

    protected String getResult() {
        return this.functionData.getResultTest();
    }

    void end() {
        this.itemTestData.end();
    }

}
