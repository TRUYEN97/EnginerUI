/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.ManagerUI.UIStatus;

import Model.DataTest.ProcessTest.ProcessData;
import Control.Core.Core;
import Control.Core.ModeTest;
import Control.Core.CellTest;
import Model.AllKeyWord;
import Model.DataTest.ProcessTest.InputData;
import Model.DataTest.ProcessTest.UiInformartion;
import Model.Interface.IUpdate;
import View.subUI.SubUI.AbsSubUi;
import static java.util.Objects.isNull;

/**
 *
 * @author 21AK22
 */
public class UiStatus implements IUpdate {

    private final UiInformartion informartion;
    private final AbsSubUi subUi;
    private final Core core;
    private final ProcessData processData;
    private final CellTest cellTest;
    private ModeTest modeTest;

    public UiStatus(AbsSubUi subUi, Core core, int id, int row, int column) {
        this.informartion = new UiInformartion(subUi.getName(), column, row, id);
        this.subUi = subUi;
        this.core = core;
        this.processData = new ProcessData(this.informartion);
        this.cellTest = new CellTest(this);
    }

    public ProcessData getProcessData() {
        return processData;
    }

    public AbsSubUi getSubUi() {
        return subUi;
    }

    public ModeTest getModeTest() {
        return this.modeTest;
    }

    public CellTest getCellTest() {
        return cellTest;
    }

    public boolean isTesting() {
        return cellTest.isTesting();
    }
    
    public UiInformartion getInfo()
    {
        return informartion;
    }

    @Override
    public boolean update() {
        if (!this.isTesting()) {
            this.modeTest = core.getCurrMode();
            if (this.subUi.update()) {
                return true;
            }
        }
        return false;
    }

    public boolean isName(String name) {
        if (isNull(name)) {
            return false;
        }
        return getName().equals(name);
    }

    public boolean isUI(AbsSubUi ui) {
        if (isNull(ui)) {
            return false;
        }
        return this.subUi.equals(ui);
    }

    void setModeTest(ModeTest modeTest) {
        this.modeTest = modeTest;
    }

    public String getName() {
        return this.informartion.getName();
    }

    public void startTest(InputData inputData) {
        inputData.put(AllKeyWord.MODE, this.modeTest.getModeType());
        this.processData.getProductData().setInputData(inputData);
        this.cellTest.start();
    }
}
