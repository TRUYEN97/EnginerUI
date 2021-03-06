/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Core;

import Control.CheckInput;
import Model.DataSource.PcInformation;
import Model.DataSource.Setting.Setting;
import Model.DataSource.Setting.ModeElement;
import Time.TimeBase;
import View.UIView;
import commandprompt.Communicate.DHCP.DHCP;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Engine {

    private final Setting setting;
    private final Core core;
    private final List<ModeTest> modeTests;
    private final CheckInput checkInput;
    private final UIView view;
    private final PcInformation pcInfor;
    private final DHCP dhcp;

    public Engine() {
        this.setting = Setting.getInstance();
        this.modeTests = new ArrayList<>();
        this.core = new Core(new UIView());
        this.view = this.core.getView();
        this.pcInfor = PcInformation.getInstance();
        this.checkInput = new CheckInput(core, view);
        this.view.setCheckInput(checkInput);
        this.dhcp = new DHCP();
    }

    public void run() {
        initDHCP();
        getAllMode();
        setMode();
        showUI();
    }

    private void getAllMode() {
        for (ModeElement modeInfo : setting.getElments()) {
            this.modeTests.add(new ModeTest(modeInfo));
        }
    }

    private void setMode() {
        this.view.setMode(this.modeTests);
        if (!modeTests.isEmpty()) {
            this.core.setCurrMode(modeTests.get(0));
        }
    }

    private void showUI() {
        this.view.showIp(pcInfor.getIp());
        this.view.showPcName(pcInfor.getPcName());
        this.view.showGiaiDoan(setting.getGiaiDoan());
        java.awt.EventQueue.invokeLater(() -> {
            this.view.setVisible(true);
        });
    }

    private void initDHCP() {
        if (!setting.isOnDHCP()) {
            return;
        }
        String netIP = this.setting.getDhcpNetIP();
        this.view.showMessager("////DHCP//////\r\nSet net IP: " + netIP);
        this.dhcp.setView(this.view.getTextMess());
        if ( this.dhcp.setNetIP(netIP) && this.dhcp.init(createFilePath())) {
            new Thread(this.dhcp).start();
        }
    }

    private File createFilePath() {
        String localLog = Setting.getInstance().getLocalLogPath();
        return new File(String.format("%s/DHCP/%s.txt",
                localLog, new TimeBase().getDate()));
    }
}
