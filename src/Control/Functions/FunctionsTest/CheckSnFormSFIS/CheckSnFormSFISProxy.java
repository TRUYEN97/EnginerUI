/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Functions.FunctionsTest.CheckSnFormSFIS;

import Control.Functions.AbsFunction;
import View.subUI.UiProxy.AbsProxy;

/**
 *
 * @author Administrator
 */
public class CheckSnFormSFISProxy extends AbsProxy<AbsFunction>{

    public CheckSnFormSFISProxy(String type) {
        super(type);
    }

    @Override
    public AbsFunction takeIt() {
        return new CheckSnFormSFIS(getName());
    }
    
}
