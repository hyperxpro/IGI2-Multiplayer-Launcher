
package launcher;

public class Player {

    private String ID;
    private String Nick;
    private String Stats;
    private String Ping;
    private String Team;

    public Player(String ID, String Nick, String Stats, String Ping, String Team) {
        this.ID = ID;
        this.Nick = Nick;
        this.Stats = Stats;
        this.Ping = Ping;
        this.Team = Team;
    }

    public String getID() {
        return this.ID;
    }

    public String getNick() {
        return this.Nick;
    }

    public String getStats() {
        return this.Stats;
    }

    public String getPing() {
        return this.Ping;
    }

    public String getTeam() {
        return this.Team;
    }
}
