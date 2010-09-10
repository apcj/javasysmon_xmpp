package xmpp_javasysmon;

import com.jezhumble.javasysmon.CpuTimes;
import com.jezhumble.javasysmon.JavaSysMon;

import static xmpp_javasysmon.MeasurementField.field;
import static xmpp_javasysmon.MeasurementRecord.record;

class CpuTimer implements Runnable {

    private CpuTimes cpuTimes;
    private XmppClient xmppClient;

    public CpuTimer(XmppClient xmppClient) {
        this.xmppClient = xmppClient;
    }

    public void run() {
        CpuTimes newCpuTimes = new JavaSysMon().cpuTimes();
        if (cpuTimes != null) {
            xmppClient.sendMessage(record(field("cpuUsage", newCpuTimes.getCpuUsage(cpuTimes) * 100)).toJson());

        }
        cpuTimes = newCpuTimes;

    }
}
