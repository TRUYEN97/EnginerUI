/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Functions.FunctionsTest.Base.CreateTxtLog;

import Control.Functions.AbsFunction;
import Control.Functions.FunctionsTest.Base.BaseFunction.AnalysisBase;
import Control.Functions.FunctionsTest.Base.BaseFunction.FileBaseFunction;
import Model.AllKeyWord;
import Model.DataSource.ModeTest.FunctionConfig.FunctionElement;
import Model.DataTest.FunctionData.FunctionData;
import Model.ErrorLog;
import Model.ManagerUI.UIStatus.UiStatus;
import MyLoger.MyLoger;
import java.io.File;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CreateTxt extends AbsFunction {

    private final AnalysisBase analysisBase;
    private final FileBaseFunction fileBaseFunction;

    public CreateTxt(String itemName) {
        super(itemName);
        this.analysisBase = new AnalysisBase(itemName);
        this.fileBaseFunction = new FileBaseFunction(itemName);
    }

    @Override
    public void setResources(FunctionElement funcConfig, UiStatus uiStatus, FunctionData functionData) {
        super.setResources(funcConfig, uiStatus, functionData); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        this.fileBaseFunction.setResources(funcConfig, uiStatus, functionData);
        this.analysisBase.setResources(funcConfig, uiStatus, functionData);
    }

    @Override
    protected boolean test() {
        return saveTxtFile() && saveFileZip();
    }

    private boolean saveFileZip() {
        addLog("Save file zip!");
        try {
            String filePath = this.allConfig.getString("localFile");
            List<String> elementName = this.allConfig.getListJsonArray("ElementName");
            String zipFile = this.fileBaseFunction.createNameFile(elementName, ".zip");
            String txtFile = this.fileBaseFunction.createNameFile(elementName, ".txt");
            return this.fileBaseFunction.saveZip(filePath, zipFile, txtFile);
        } catch (Exception e) {
            addLog("Save file zip failed: " + e.getMessage());
            ErrorLog.addError(this, e.getMessage());
            return false;
        }
    }

    private boolean saveTxtFile() {
        addLog("Save file txt!");
        MyLoger loger = new MyLoger();
        try {
            String filePath = this.allConfig.getString("localFile");
            List<String> elementName = this.allConfig.getListJsonArray("ElementName");
            String txtFile = this.fileBaseFunction.createNameFile(elementName, ".txt");
            String path = String.format("%s/%s", filePath, txtFile);
            if(!loger.begin(new File(path), true, true)){
               addLog("Error","Open file log failed!");
               return false;
            }
            createInfo(loger);
            for (FunctionData dataBox : processData.getDataBoxs()) {
                if (dataBox.isTesting()) {
                    continue;
                }
                addLog(" - add item: " + dataBox.getItemFunctionName());
                loger.add(dataBox.getLog());
                loger.add("//////////////////////////////////////////////////////////////////\r\n");
            }
            addLog("Save file txt in " + path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            addLog("Save file txt failed: " + e.getMessage());
            ErrorLog.addError(this, e.getMessage());
            return false;
        } finally {
            loger.close();
        }
    }

    private void createInfo(MyLoger loger) {
        loger.add("===================================================================\r\n");
        loger.add("Start at = " + processData.getString(AllKeyWord.START_TIME));
        loger.add("\r\n");
        loger.add("End test at = " + processData.getString(AllKeyWord.FINISH_TIME ));
        loger.add("\r\n");
        loger.add("Station = " + processData.getString(AllKeyWord.STATION_NAME ));
        loger.add("\r\n");
        loger.add("Localtion = " + processData.getString(AllKeyWord.INDEX ));
        loger.add("\r\n");
        loger.add("HHSN = " + processData.getString(AllKeyWord.SN ));
        loger.add("\r\n");
        loger.add("DEVICSN = " + processData.getString(AllKeyWord.MLBSN));
        loger.add("\r\n===================================================================\r\n");

    }

}
