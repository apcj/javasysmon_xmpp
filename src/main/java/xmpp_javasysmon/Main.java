package xmpp_javasysmon;

public class Main {

    public static void main(String[] args) {
        new Main().run(
                System.getProperty("xmppServerAddress", "alistair-jones-macbook-pro.local"),
                System.getProperty("chatroomName", "performance@chatrooms.alistair-jones-macbook-pro.local")
        );
    }

    public void run(String xmppServerAddress, String chatroomName) {

        XmppClient xmppClient = new XmppClient();
        xmppClient.connect(xmppServerAddress, chatroomName, "javasysmon", "javasysmon");

        ReportingCpuMonitor monitor = new ReportingCpuMonitor();
        monitor.startTiming(xmppClient);
    }

}
