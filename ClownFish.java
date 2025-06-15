package yahav_eliyahu_arad_rotem;

public class ClownFish extends AquariumFish{
    public static final int LIFE_SPAN=8;

    public ClownFish(int age, float length, String mainColor) {
        super(age, length);
        String[] colors = {"White", mainColor};
        setColorsArray(colors);
        setSign("Strips");
        setHappiness(100);
    }

    public ClownFish() {
        super(0, 0f);
        setHappiness(100);
    }

    public float feed(){
        return 2;
    }

    public int getLifeSpan() {
        return LIFE_SPAN;
    }

}
