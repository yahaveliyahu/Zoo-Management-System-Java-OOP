package yahav_eliyahu_arad_rotem;

public class Lion extends Predator{

    private String maneColor;
    private int meatAmount;

    public Lion(String name, int age, float weight, boolean isMale, int lifeSpan, String maneColor) {
        super(name, age, weight, isMale, Predator.LIFE_SPAN);
        this.meatAmount = feed();
        if (isMale && maneColor != null) {
            this.maneColor = maneColor;
        } else {
            this.maneColor = null;
        }
    }

    public String getManeColor() {
        return maneColor;
    }

    public int feed() {//check how much food this lion needs to get
        double meat;
        if (this.isMale()) {
            meat = getWeight() * getAge() * 0.02;
        } else {
            meat = getWeight() * getAge() * 0.03;
        }
        if (meat > 25)//Lions cant eat more than 25 kg of meat
            return 25;
        return (int) meat;
    }
//    public String makeNoise()
//    {
//        return "ROAR";
//    }


    public int getMeatAmount() {
        return feed();
    }

}


