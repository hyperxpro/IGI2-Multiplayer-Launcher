
package launcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.net.URLConnection;

public class Web {

    public static List<String> getServerList() {
        
        List<String> serverList = new ArrayList();
        BufferedReader br = null;
        URLConnection connection = null;

        try {
            connection = new URL("https://igi-2-masterserver-masterserver-igi2masterserver-global-cdn-nlb.igi2.co.in/igi2/masterserver/igi2_masterserver/servers/igi2-masterserver/servers/launcher_9-6/igi2_servers_igi2.LAUNCHER").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/58.0.1271.95 Safari/537.11");
            connection.connect();

            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = null;
            while ((line = br.readLine()) != null) {
                serverList.add(line);
            }

            br.close();

        } catch (IOException ex) {

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                }
            }
        }

        return serverList;
    }
}
