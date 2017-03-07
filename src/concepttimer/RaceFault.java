package concepttimer;

public class RaceFault {
    private String time;
    private Dog dog;

public RaceFault(String s, Dog d){
    this.dog = d;
    this.time = s;
}
   
    public String getTime() {
        return time;
    }

    
    public void setTime(String time) {
        this.time = time;
    }

    
    public String getDog() {
        return dog;
    }

    
    public void setDog(String dog) {
        this.dog = dog;
    }
    
    
    
}
