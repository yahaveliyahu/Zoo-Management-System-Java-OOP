package yahav_eliyahu_matanya_cohen_arad_rotem;

public class Penguin implements Comparable<Penguin> {
    private String name;
    private int age;
    private float height;
    private boolean isLeader;
    private int happiness;
    public static final int LIFE_SPAN=6;

    public Penguin(String name, int age, float height, boolean isLeader) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.isLeader = isLeader;
        happiness=100;// at the start every animal has 100 happiness
    }
    public Penguin(){

    }
    @Override
    public int compareTo(Penguin other) {
        return Float.compare(other.height, this.height); // Sort by height in descending order
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        String result = "Name: " + name + ", Age: " + age + ", Height: " + height + " meters"+ " Happiness="+happiness;
        if (isLeader) {
            result += " - I can lead the Group!";
        }
        return result;
    }
    public String makeNoise()
    {
        return "squack";
    }
    public int feed(){
        return 1;
    }
}

