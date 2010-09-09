package xmpp_javasysmon;

import com.jezhumble.javasysmon.CpuTimes;
import com.jezhumble.javasysmon.JavaSysMon;

class CpuTimer implements Runnable {

    private CpuTimes cpuTimes;
    private XmppClient xmppClient;

    public CpuTimer(XmppClient xmppClient) {
        this.xmppClient = xmppClient;
    }

    public void run() {
        CpuTimes newCpuTimes = new JavaSysMon().cpuTimes();
        if (cpuTimes != null) {
            String currentCpuUsage = newCpuTimes.getCpuUsage(cpuTimes) * 100 + "%";
            xmppClient.sendMessage(currentCpuUsage);
            System.out.println(currentCpuUsage);

        }
        cpuTimes = newCpuTimes;

    }
}
