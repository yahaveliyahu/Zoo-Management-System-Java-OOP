package yahav_eliyahu_arad_rotem;

import java.util.Arrays;
import java.util.Objects;

public class AquariumFish extends Animal {
    private float length;
    private String sign;
    private String[] colorsArray;
    private int happiness;

    public AquariumFish(int age, float length, String sign, String[] colors) {
        super(age);
        this.length = length;
        this.sign = sign;
        this.colorsArray = colors;
        happiness=100;// at the start every animal has 100 happiness
    }

    public AquariumFish(int age, float length) {
        super(age);
        this.length = length;
        this.colorsArray = new String[0]; // אתחול כדי למנוע NullPointerException
        this.happiness = 100;
    }



//    public AquariumFish(){
//        this.colorsArray=new String[0];
//    }
//
//    public AquariumFish(int age, float length) {
//        this.age=age;
//        this.length=length;
//    }


    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setColorsArray(String[] colorsArray) {
        this.colorsArray = colorsArray;
    }

    @Override
    public String toString() {
        return super.toString()
                        + ", length=" + String.format("%.2f",length)
                        + ", sign='" + sign + '\''
                        + ", colors=" + Arrays.toString(colorsArray)
                        + ", Happiness="+happiness;
    }
    public String[] getColorsArray() {
        return colorsArray;
    }

    public void addColor(String color){
        colorsArray = Arrays.copyOf(colorsArray, colorsArray.length + 1);
        colorsArray[colorsArray.length - 1] = color;
    }
    public boolean isColorExist(String color) {
        for (String s : colorsArray) {
            if (Objects.equals(s, color)) {
                return true;
            }
        }
        return false;
    }
    public float feed() {
        if (age < 3)
            return 3;
        return length + 3;
    }
//    public String makeNoise()
//    {
//        return "blop";
//    }
}
