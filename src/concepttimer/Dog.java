package concepttimer;


public class Dog {
    private String name;
    private String owner;
    private String team;
    private int faults;
    private int numberOfRaces;
    private int avgFaults = faults/numberOfRaces;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvgFaults() {
        return avgFaults;
    }

    public void setAvgFaults(int avgFaults) {
        this.avgFaults = avgFaults;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
          
    
}
