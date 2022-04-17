/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Factory;

import View.DrawBoardUI.FormDetail.AbsTabUI;
import View.DrawBoardUI.SubUI.AbsSubUi;
import View.DrawBoardUI.UIWarehouse.BigUIProxy;
import View.DrawBoardUI.UIWarehouse.SmallProxy;
import View.DrawBoardUI.UIWarehouse.TabItemProxy;
import View.DrawBoardUI.UIWarehouse.TabLogProxy;
import View.DrawBoardUI.UIWarehouse.TabViewProxy;

/**
 *
 * @author 21AK22
 */
public class Factory {

    private static volatile Factory instance;
    private final FactoryType<AbsSubUi> subUIFactory;
    private final FactoryType<AbsTabUI> tabUIFactory;

    private Factory() {
        this.subUIFactory = new FactoryType<>();
        addSubUI();
        this.tabUIFactory = new FactoryType<>();
        addTabUI();
    }

    public static Factory getInstance() {
        Factory ins = Factory.instance;
        if (ins == null) {
            synchronized (Factory.class) {
                ins = Factory.instance;
                if (ins == null) {
                    Factory.instance = ins = new Factory();
                }
            }
        }
        return ins;
    }

    public AbsSubUi getSubUI(String type, String index) {
        return this.subUIFactory.takeIt(type, index);
    }

    public AbsTabUI getTabUI(String type) {
        return this.tabUIFactory.takeIt(type);
    }

    private void addSubUI() {
        this.subUIFactory.addType(new BigUIProxy("Big"));
        this.subUIFactory.addType(new SmallProxy("Small"));
    }

    private void addTabUI() {
        this.tabUIFactory.addType(new TabViewProxy("View"));
        this.tabUIFactory.addType(new TabItemProxy("Item"));
        this.tabUIFactory.addType(new TabLogProxy("Log"));
    }
}
