package concepttimer;


public class Dog {
    private String name;
    private String owner;
    private int team;
    private int faults;
    private int numberOfRaces =1;
    private int avgFaults = faults/numberOfRaces;

    public Dog(String n, int t){
        this.name = n;
        this.team = t;
                
    } 
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

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
    
          
    
}
