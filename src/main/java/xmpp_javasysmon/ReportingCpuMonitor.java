package xmpp_javasysmon;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ReportingCpuMonitor {

    public void startTiming(XmppClient xmppClient) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable cpuTimer = new CpuTimer(xmppClient);
        scheduler.scheduleAtFixedRate(cpuTimer, 1, 1, SECONDS);
    }
}
