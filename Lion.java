package yahav_eliyahu_matanya_cohen_arad_rotem;

public class Lion extends Predator{

    public Lion(String name, int age, float weight, boolean isMale) {
        super(name, age, weight, isMale);
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

}


