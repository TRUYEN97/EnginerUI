/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Functions.FunctionsTest.Base.CheckDutInfo;

import Control.Functions.AbsFunction;
import Control.Functions.FunctionsTest.Base.BaseFunction;
import Model.DataTest.FunctionData.FunctionData;
import Model.ManagerUI.UIStatus.UiStatus;
import Time.WaitTime.Class.TimeMs;
import commandprompt.Communicate.Telnet.Telnet;

/**
 *
 * @author Administrator
 */
public class CheckDutInfo extends AbsFunction {

    private final BaseFunction baseFunc;

    public CheckDutInfo(String itemName) {
        super(itemName);
        this.baseFunc = new BaseFunction(itemName);
    }

    @Override
    public void setResources(UiStatus uiStatus, FunctionData functionData) {
        super.setResources(uiStatus, functionData); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        this.baseFunc.setResources(uiStatus, functionData);
    }

    @Override
    protected boolean test() {
        String ip = this.baseFunc.getIp();
        addLog("IP: " + ip);
        if (ip == null || !this.baseFunc.pingTo(ip)) {
            return false;
        }
        return check(ip);
    }

    private boolean check(String ip) {
        Telnet telnet = this.baseFunc.getTelnet(ip, 23);
        if (telnet == null || !this.baseFunc.sendCommand(telnet, allConfig.getString("command"))) {
            return false;
        }
        return checkValue(getValue(telnet));
    }

    private boolean checkValue(String value) {
        addLog("Value is: " + value);
        String spec = productData.getString("compareWith");
        addLog("Spec is: " + spec);
        if (spec != null && value != null && spec.equals(value)) {
            setResult(value);
            return true;
        }
        return true;
    }


    private String getValue(Telnet telnet) {
        String key = allConfig.getString("keyWord");
        addLog("CONFIG", "keyWord: " + key);
        String line;
        while ((line = telnet.readLine(new TimeMs(100))) != null) {
            line = line.trim();
            addLog("Telnet", line);
            if (line.startsWith(key + "=") && line.contains("=")) {
                return line.substring(line.lastIndexOf("=") + 1).trim();
            }
        }
        return null;
    }
}
