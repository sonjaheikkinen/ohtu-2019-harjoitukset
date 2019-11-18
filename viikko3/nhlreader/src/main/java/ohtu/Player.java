package ohtu;

public class Player implements Comparable<Player> {

    private String name;
    private int goals;
    private int assists;
    private String team;
    private String nationality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    
    @Override
    public int compareTo(Player p) {
        return (p.assists + p.goals) - (this.assists + this.goals);
    }

    @Override
    public String toString() {
        return name + " " + team + " " + goals + " + " + assists + " = " + (goals + assists);
    }

}
