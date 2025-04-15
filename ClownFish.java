package yahav_eliyahu_matanya_cohen_arad_rotem;

public class ClownFish extends AquariumFish{
    public static final int LIFE_SPAN=8;

    public ClownFish(int age, float length) {
        super(age, length);
        String [] colors={"Orange","Black","White"};
        setColorsArray(colors);
        setSign("Strips");
        setHappiness(100);
    }

    public ClownFish() {
    }

    public float feed(){
        return 2;
    }
}
