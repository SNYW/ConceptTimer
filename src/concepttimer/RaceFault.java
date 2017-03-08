package concepttimer;

public class RaceFault {

    private String time;
    private Dog dog;

    public RaceFault(String s, Dog d) {
        this.dog = d;
        this.time = s;
    }

    @Override
    public String toString() {

        String dogString = this.dog.getName() + " Faulted at " + this.time;

        return dogString;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

}
