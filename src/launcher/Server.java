/*
 * IGI-2 Multiplayer Launcher
 * ________________________________________
 * End-User License Agreement ("Agreement")
 *
 * Last updated: 12-February-2019
 *
 * Please read this End-User License Agreement ("Agreement") carefully before clicking the "I Agree" button, downloading or using IGI-2 Multiplayer Launcher ("Application").
 *
 * By clicking the "I Agree" button, downloading or using the Application, you are agreeing to be bound by the terms and conditions of this Agreement.
 *
 * If you do not agree to the terms of this Agreement, do not click on the "I Agree" button and do not download or use the Application.
 *
 * License
 *
 * Aayush Atharva grants you a revocable, non-exclusive, non-transferable, limited license to download, install, modify and use the Application solely for your personal, non-commercial purposes strictly in accordance with the terms of this Agreement. 
 *
 * Restrictions
 *
 * You agree not to, and you will not permit others to:
 *
 * a) license, sell, rent, lease, assign, distribute, transmit, host, outsource, disclose or otherwise commercially exploit the Application or make the Application available to any third party.
 *
 *
 * Modifications to Application
 *
 * Aayush Atharva reserves the right to modify, suspend or discontinue, temporarily or permanently, the Application or any service to which it connects, with or without notice and without liability to you.
 *
 *
 * Term and Termination
 *
 * This Agreement shall remain in effect until terminated by you or Aayush Atharva.
 *
 * Aayush Atharva may, in its sole discretion, at any time and for any or no reason, suspend or terminate this Agreement with or without prior notice.
 *
 * This Agreement will terminate immediately, without prior notice from Aayush Atharva, in the event that you fail to comply with any provision of this Agreement. You may also terminate this Agreement by deleting the Application and all copies thereof from any device where itÃ¢â‚¬â„¢s stored.
 *
 * Upon termination of this Agreement, you shall cease all use of the Application and delete all copies of the Application from any device where itÃ¢â‚¬â„¢s stored.
 *
 * Severability
 *
 * If any provision of this Agreement is held to be unenforceable or invalid, such provision will be changed and interpreted to accomplish the objectives of such provision to the greatest extent possible under applicable law and the remaining provisions will continue in full force and effect.
 *
 * Amendments to this Agreement
 *
 * Aayush Atharva reserves the right, at its sole discretion, to modify or replace this Agreement at any time. If a revision is material I will provide at least 7 days notice prior to any new terms taking effect. What constitutes a material change will be determined at our sole discretion.
 *
 * Contact Information
 *
 * If you have any questions about this Agreement, please contact me.
 *
 *
 * Aayush Atharva
 * Email: aayush@aayushatharva.com
 */
package launcher;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread {

    public String name;
    public String ip;
    public int port;
    String ips;
    String map;
    public int numpl;
    public int maxpl;
    String uptime;
    String time;
    String mapstat;
    boolean password;
    DatagramSocket socket;
    List<Player> players;
    boolean stop = false;
    public String PasswordStatus;

    public Server(String IP) {
        try {
            this.ips = IP;
            this.ip = IP.substring(0, IP.indexOf(':'));
            this.port = Integer.parseInt(IP.substring(IP.indexOf(':') + ":".length(), IP.indexOf(" [", IP.indexOf(':') + 1)));
            this.PasswordStatus = IP.substring(IP.indexOf('[') + "[".length(), IP.indexOf(']', IP.indexOf('{') + 1));
            this.socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Server(Server server) {
        try {
            this.ips = server.ips;
            this.ip = server.ip;
            this.port = server.port;
            this.PasswordStatus = server.PasswordStatus;
            this.socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Player> getPlayers() {
        String message = "";
        try {
            InetAddress servAddr = InetAddress.getByName(ip);
            byte[] buf = "\\players\\".getBytes();
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(1000);
            socket.send(new DatagramPacket(buf, buf.length, servAddr, port));
            buf = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            socket.close();
            message = new String(packet.getData());
            message = message.trim();
        } catch (Exception ex) {
            return null;
        }

        this.players = new ArrayList();
        setNewPlayer(message);
        return this.players;
    }

    public void setNewPlayer(String status) {
        while (status.lastIndexOf("player") > 0) {
            String sfrag = "frags_";
            String sdeath = "deaths_";
            String sping = "ping_";
            String steam = "team_";
            String splayer = "player_";
            if (!status.contains(splayer)) {
                return;
            }
            String id = status.substring(status.indexOf(splayer) + splayer.length(), status.indexOf("\\", status.indexOf(splayer) + splayer.length()));
            splayer = splayer + id + "\\";
            sfrag = sfrag + id + "\\";
            sdeath = sdeath + id + "\\";
            sping = sping + id + "\\";
            steam = steam + id + "\\";
            String pom = status.substring(status.indexOf(splayer) + splayer.length(), status.indexOf(sfrag) - 1);
            String nick = pom;
            pom = status.substring(status.indexOf(sfrag) + sfrag.length(), status.indexOf(sdeath) - 1);
            String stats = pom;
            pom = status.substring(status.indexOf(sdeath) + sdeath.length(), status.indexOf(sping) - 1);
            stats = stats + "/" + pom;
            pom = status.substring(status.indexOf(sping) + sping.length(), status.indexOf(steam) - 1);
            String ping = pom;
            pom = status.substring(status.indexOf(steam) + steam.length(), status.indexOf(steam) + steam.length() + 1);
            String team = pom;
            Player p = new Player(id, nick, stats, ping, team);
            status = status.substring(status.indexOf(splayer) + splayer.length() + 2);
            this.players.add(p);
        }
    }

    @Override
    public void run() {
        if (setServer(sendStatus())) {
            Main.lista.add(this);
        }
        Main.update += 1;
    }

    public String sendStrPck(String msg) {
        String message = "";
        try {
            InetAddress servAddr = InetAddress.getByName(this.ip);
            byte[] buf = msg.getBytes();
            this.socket.setSoTimeout(1000);
            this.socket.send(new DatagramPacket(buf, buf.length, servAddr, this.port));
            buf = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            this.socket.receive(packet);
            message = new String(packet.getData());
            message = message.trim();
        } catch (Exception ex) {
            System.out.print(".");
        }
        return message;
    }

    public String sendStatus() {
        String message = "";
        try {
            InetAddress servAddr = InetAddress.getByName(this.ip);
            byte[] buf = "\\status\\".getBytes();
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(1000);
            socket.send(new DatagramPacket(buf, buf.length, servAddr, this.port));
            buf = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            socket.close();
            message = new String(packet.getData());
            message = message.trim();
        } catch (Exception ex) {
            return "";
        }
        return message;
    }

    public String sendHexPck(byte[] msg) {
        String message = "";
        try {
            InetAddress servAddr = InetAddress.getByName(this.ip);
            byte[] buf = msg;
            this.socket.setSoTimeout(1000);
            this.socket.send(new DatagramPacket(buf, buf.length, servAddr, this.port));
            byte[] buff = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buff, buff.length);
            this.socket.receive(packet);
        } catch (Exception ex) {
            //   System.out.println("pakiet " + ex);
        }
        return message;
    }

    public boolean setServer(String status) {
        if (status.length() <= 0) {
            return false;
        }
        try {
            String pom = status.substring(status.indexOf("hostname\\") + 9, status.indexOf("\\hostport"));
            this.name = pom;
            pom = status.substring(status.indexOf("mapname\\") + 8, status.indexOf("\\gametype"));
            this.map = pom;
            pom = status.substring(status.indexOf("numplayers\\") + 11, status.indexOf("\\maxplayers"));
            this.numpl = Integer.parseInt(pom);
            pom = status.substring(status.indexOf("maxplayers\\") + 11, status.indexOf("\\gamemode"));
            this.maxpl = Integer.parseInt(pom);
            pom = status.substring(status.indexOf("uptime\\") + 7, status.indexOf("\\timeleft"));

            int up = Integer.parseInt(pom);
            this.uptime = (up / 60 + "h " + up % 60 + "min");
            pom = status.substring(status.indexOf("timeleft\\") + 9, status.indexOf("\\mapstat"));
            this.time = pom;
            pom = status.substring(status.indexOf("mapstat\\") + 8, status.indexOf("\\timelimit"));
            this.mapstat = pom;
            pom = status.substring(status.indexOf("password\\") + 9, status.indexOf("\\team_t0"));
            if (pom.equals("1")) {
                this.password = true;
            } else {
                this.password = false;
            }
        } catch (StringIndexOutOfBoundsException ex) {
            //    System.out.println("Info-updateInfo " + ex.toString() + status);
        }
        return true;
    }

    public String updateServerStatus() {
        String ServerName, ServerMapAndTime, ServerPlayer;
        try {
            InetAddress servAddr = InetAddress.getByName(this.ip);
            byte[] buf = "\\status\\".getBytes();
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(1000);
            socket.send(new DatagramPacket(buf, buf.length, servAddr, this.port));
            buf = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            socket.close();
            String PacketData = new String(packet.getData());
            PacketData = PacketData.trim();
            ServerName = "Server Name: " + PacketData.substring(PacketData.indexOf("hostname\\") + 9, PacketData.indexOf("\\hostport"));
            ServerMapAndTime = "Map: " + PacketData.substring(PacketData.indexOf("mapname\\") + 8, PacketData.indexOf("\\gametype")) + " | Maptime: " + PacketData.substring(PacketData.indexOf("timeleft\\") + 9, PacketData.indexOf("\\mapstat"));
            ServerPlayer = "Players: " + PacketData.substring(PacketData.indexOf("numplayers\\") + 11, PacketData.indexOf("\\maxplayers")) + "/" + PacketData.substring(PacketData.indexOf("maxplayers\\") + 11, PacketData.indexOf("\\gamemode"));
        } catch (Exception ex) {
            return null;
        }
        return "ServerName=" + ServerName + "\n" + "ServerMapAndTime=" + ServerMapAndTime + "\n" + "ServerPlayer=" + ServerPlayer;
    }

    public void info() {
        System.out.print(this.ip + " " + this.port + "  ");
        System.out.print(this.name + " ");
        System.out.print(this.uptime + "   ");
        System.out.print(this.map + "  ");
        System.out.print(this.numpl + "/" + this.maxpl + "  ");
        System.out.print(this.time + " ");
        System.out.println(this.mapstat + "    ");
    }
}
