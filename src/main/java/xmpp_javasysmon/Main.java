package xmpp_javasysmon;

public class Main {

    public static void main(String[] args) {
        new Main().run(
                System.getProperty("xmppServerAddress", "jalewis.thoughtworks.com"),
                System.getProperty("chatroomName", "performance@chatrooms.jalewis.thoughtworks.com"),
                System.getProperty("jabberUsername", "server"),
                System.getProperty("jabberPassword", "server")
        );
    }

    public void run(String xmppServerAddress, String chatroomName, String jabberUsername, String jabberPassword) {

        XmppClient xmppClient = new XmppClient();
        xmppClient.connect(xmppServerAddress, chatroomName, jabberUsername, jabberPassword);

        ReportingCpuMonitor monitor = new ReportingCpuMonitor();
        monitor.startTiming(xmppClient);
    }

}
