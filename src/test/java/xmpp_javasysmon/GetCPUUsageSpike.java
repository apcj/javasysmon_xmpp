package xmpp_javasysmon;

import org.junit.Test;

public class GetCPUUsageSpike {


    @Test
    public void shouldGetCPUUsage() throws InterruptedException {

        ReportingCpuMonitor monitor = new ReportingCpuMonitor();
        XmppClient xmppClient1 = new XmppClient();
        xmppClient1.connect("jalewis.thoughtworks.com", "performance@chatrooms.jalewis.thoughtworks.com", "server", "server");
        XmppClient xmppClient = xmppClient1;

        monitor.startTiming(xmppClient);

        Thread.sleep(1000 * 10);

    }

}
