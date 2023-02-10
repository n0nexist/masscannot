package www.n0nexist.gq.utils;

import www.n0nexist.gq.OutputFile;

public class PingAndCheck {

    static MinecraftPinger mcpinger = new MinecraftPinger();

    public static void processServer(String ip, int port){
        try {
            String[] data = mcpinger.ping(ip, port);
            MinecraftServer mcserver = new MinecraftServer(ip,port,Integer.parseInt(data[3]));
            String result = "";
            try {
                mcserver.connect();
                mcserver.sendHandshakePacket();
                mcserver.sendLoginStartPacket();
                result = mcserver.check();
                Thread.sleep(1000L);
                mcserver.disconnect();
                String full = result+" | "+ip+":"+port+" [motd]=> "+Purifica.purificaDalFormatting(data[0])+" [players]=> "+data[1]+" [version]=> "+data[2];
                System.out.println(full);
                full = Purifica.purificaDagliAnsi(full);
                OutputFile.write(full);
            } catch (Exception ee) {}
        }catch(Exception e){}
    }
}
