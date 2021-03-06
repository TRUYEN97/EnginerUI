/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Functions.FunctionsTest.Runin.OnOffPing;

import Control.Functions.FunctionsTest.Base.BaseFunction.AnalysisBase;
import Control.Functions.FunctionsTest.Base.BaseFunction.FunctionBase;
import Control.Functions.FunctionsTest.Runin.PowerSwitch.PowerSwitchFunc;
import Model.DataSource.ModeTest.FunctionConfig.FunctionElement;
import Model.DataTest.FunctionData.FunctionData;
import Model.ManagerUI.UIStatus.UiStatus;

/**
 *
 * @author Administrator
 */
public class OnOffPing extends PowerSwitchFunc{

    private final FunctionBase baseFunc;
    private final AnalysisBase analysisBase;

    public OnOffPing(String itemName) {
        super(itemName);
        this.baseFunc = new FunctionBase(itemName);
        this.analysisBase = new AnalysisBase(itemName);
    }

    @Override
    public void setResources(FunctionElement funcConfig, UiStatus uiStatus, FunctionData functionData) {
        super.setResources(funcConfig, uiStatus, functionData); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        this.baseFunc.setResources(funcConfig, uiStatus, functionData);
        this.analysisBase.setResources(funcConfig, uiStatus, functionData);
    }
    @Override
    public boolean doSomethings() {
        String ip = this.analysisBase.getIp();
        addLog("IP: " + ip);
        if (ip == null) {
            return false;
        }
        return this.baseFunc.pingTo(ip, 35);
    }
    
}
