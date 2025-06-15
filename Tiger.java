package yahav_eliyahu_arad_rotem;

import java.util.Random;

public class Tiger extends Predator {

    private int stripeCount;
    private int meatAmount;

    Random r = new Random();

    public Tiger(String name, int age, float weight, boolean isMale, int lifeSpan ,int stripeCount) {
        super(name, age, weight, isMale, Predator.LIFE_SPAN);
        this.stripeCount= r.nextInt(21) + 100;
        this.meatAmount=feed();
    }

    public int feed() {//check how much food this tiger needs to get
        double meat;
        if (this.isMale()) {
            meat = getWeight() * getAge() * 0.02;
        } else {
            meat = getWeight() * getAge() * 0.03;
        }
        return (int) meat;
        //Tigers CAN eat more than 25 kg of meat
    }

//    public String makeNoise() {
//        return "roar";
//    }

    public int getStripeCount() {
        return stripeCount;
    }
    public int getMeatAmount(){
        return feed();
    }

}

