package yahav_eliyahu_matanya_cohen_arad_rotem;

public class GoldFish extends AquariumFish{
    public static final int LIFE_SPAN=12;

    public  GoldFish(int age,float length){
        super(age,length);
        String[] colors = {"Gold"};
        setColorsArray(colors);
        setSign("Blank");
        setHappiness(100);

    }

    public float feed(){
        return 1;
    }
}
