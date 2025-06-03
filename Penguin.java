package yahav_eliyahu_matanya_cohen_arad_rotem;

public class Penguin extends Animal implements Comparable<Penguin> {
    private String name;
    private float height;
    private boolean isLeader;
    private int happiness;
    public static final int LIFE_SPAN=6;

    public Penguin(String name, int age, float height, boolean isLeader) {
        super(age);
        this.name = name;
        this.height = height;
        this.isLeader = isLeader;
        this.happiness=100;// at the start every animal has 100 happiness
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() { return height; }

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

    @Override
    public int compareTo(Penguin other) {
        return Float.compare(other.height, this.height); // Sort by height in descending order
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += ", Name: " + name + ", Height: " + height + " meters,"+ " Happiness="+happiness;
        if (isLeader) {
            result += " - I can lead the Group!";
        }
        return result;
    }
//    public String makeNoise()
//    {
//        return "squack";
//    }
    public int feed(){
        return 1;
    }
}

