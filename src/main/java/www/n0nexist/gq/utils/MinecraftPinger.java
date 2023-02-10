package www.n0nexist.gq.utils;

import www.n0nexist.gq.mcserverping.MCPing;
import www.n0nexist.gq.mcserverping.MCPingOptions;
import www.n0nexist.gq.mcserverping.MCPingResponse;

import java.io.IOException;

public class MinecraftPinger {

    @SuppressWarnings("unchecked")
    public static String[] ping(String ip, int port) throws IOException {
        MCPingOptions options = MCPingOptions.builder()
                .hostname(ip)
                .port(port)
                .build();
        MCPingResponse data = MCPing.getPing(options);
        return new String[]{
                data.getDescription().getStrippedText(),
                data.getPlayers().getOnline() + "/" + data.getPlayers().getMax(),
                data.getVersion().getName(),
                String.valueOf(data.getVersion().getProtocol())
        };
    }
}
