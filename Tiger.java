package yahav_eliyahu_matanya_cohen_arad_rotem;

public class Tiger extends Predator {

    public Tiger(String name, int age, float weight, boolean isMale) {
        super(name, age, weight, isMale);
    }

    public Tiger(){
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

    public String makeNoise() {
        return "roar";
    }
}
