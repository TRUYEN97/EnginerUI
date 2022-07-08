/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Functions.FunctionsTest.Base.DutPing;

import Control.Functions.AbsFunction;
import Model.DataSource.Setting.Setting;
import commandprompt.Communicate.Cmd.Cmd;
import commandprompt.Communicate.DHCP.DhcpData;

/**
 *
 * @author Administrator
 */
public class DutPing extends AbsFunction {

    public DutPing(String itemName) {
        super(itemName);
    }

    @Override
    protected boolean test() {
        addLog("Get IP!");
        String ip = getIp();
        addLog("IP: " + ip);
        if (ip == null) {
            return false;
        }
        return pingTo(ip);
    }

    private String getIp() {
        if (Setting.getInstance().isOnDHCP()) {
//            String mac = productData.getString(AllKeyWord.MAC);
            String mac = "649714048d60";
            if (mac == null) {
                return null;
            }
            return DhcpData.getInstance().getIP(mac);
        };
        return allConfig.getString("IP");
    }

    private boolean pingTo(String ip) {
        Cmd cmd = new Cmd();
        String command = String.format("ping %s -n 200", ip);
        addLog("command: " + command);
        cmd.sendCommand(command);
        String line;
        while ((line = cmd.readLine()) != null) {
            addLog("PING", line);
            if (line.contains("TTL=")) {
                return true;
            }
        }
        return false;
    }

}