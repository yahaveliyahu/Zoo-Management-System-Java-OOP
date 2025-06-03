package yahav_eliyahu_matanya_cohen_arad_rotem;

public class Predator extends Animal {
    private String name;
    private float weight;
    private boolean isMale;
    private int happiness;
    public static final int LIFE_SPAN = 15;

    public Predator(String name, int age, float weight, boolean isMale) {
        super(age);
        this.name = name;
        this.weight = weight;
        this.isMale = isMale;
        this.happiness = 100;// at the start every animal has 100 happiness
    }



    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Name=" + name
                + ", Weight=" + weight
                + ", isMale=" + isMale
                + ", Happiness=" + happiness;
    }
}
