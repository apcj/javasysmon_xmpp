package xmpp_javasysmon;

public class Main {


    public static void main(String[] args) {
        new Main().run(
                System.getProperty("xmppServerAddress", "jalewis.thoughtworks.com"),
                System.getProperty("chatroomName", "performance@chatrooms.jalewis.thoughtworks.com")
        );
    }

    public void run(String xmppServerAddress, String chatroomName) {

        XmppClient xmppClient = new XmppClient();
        xmppClient.connect(xmppServerAddress, chatroomName, "server", "server");

        ReportingCpuMonitor monitor = new ReportingCpuMonitor();
        monitor.startTiming(xmppClient);
    }

}
