package yahav_eliyahu_matanya_cohen_arad_rotem;

public class SimpleFish extends AquariumFish{
    public static final int LIFE_SPAN=25;

    public SimpleFish(int age, float length, String pattern, String[] colors) {
    super(age, length,pattern,colors);
        setHappiness(100);
    }
}
