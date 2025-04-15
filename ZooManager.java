package yahav_eliyahu_matanya_cohen_arad_rotem;

import java.util.Random;

public class ZooManager {
    public final String[] fishColors = {"Black", "Yellow", "Gold", "Orange", "White", "Green", "Blue", "Brown", "Red", "Cyan"};
    private final String zooName;
    private final Address zooAddress;
    private final String[] fishPattern = {"Dots", "Strips", "Stains", "Blank"};
    private Object[] animals = new Object[0];

    public ZooManager() {
        this.zooName = "Hatanachi Zoo";
        this.zooAddress = new Address("Jerusalem", "Aharon Shuluv", "1");
    }

    public Lion[] getLionArray() {
        Lion[] lionArray = new Lion[animals.length];
        int count = 0;
        for (Object li : animals) {
            if (li instanceof Lion) {
                lionArray[count] = (Lion) li;
                count++;
            }
        }
        return lionArray;
    }
    public int getArrayLength(Object [] objects) {//return the length of the array without null
        int count = 0;
        for (Object li : objects) {
            if (li==null) {
                continue;
            }
            else {
                count++;
            }
        }
        return count;
    }

    public Tiger[] getTigerArray() {
        Tiger[] tigerArray = new Tiger[animals.length];
        int count = 0;
        for (Object li : animals) {
            if (li instanceof Tiger) {
                tigerArray[count] = (Tiger) li;
                count++;
            }
        }
        return tigerArray;
    }

    public Penguin[] getPenguinsArray() {
        Penguin[] penguinArray = new Penguin[animals.length];
        int count = 0;
        for (Object li : animals) {
            if (li instanceof Penguin) {
                penguinArray[count] = (Penguin) li;
                count++;
            }
        }
        return penguinArray;
    }

    public AquariumFish[] getFishArray() {

        AquariumFish[] fishArray = new AquariumFish[animals.length];
        int count = 0;
        for (Object li : animals) {
            if (li instanceof AquariumFish) {

                fishArray[count] = (AquariumFish) li;
                count++;
            }
        }
        return fishArray;
    }

    public Object[] getAnimalArray() {
        return animals;
    }

    public void setAnimalArray(Object[] a) {
        this.animals = a;
    }

    @Override
    public String toString() {
        return "Zoo name: '" + zooName + '\'' +
                ", it's address: " + zooAddress;
    }

    public void builtInAnimals() {
        Penguin leader = new Penguin("Skeeper", 4, 200, true);//Leader penguin at the beginning
        animals = new Object[20];
        int openPlace = FindOpenPlace(animals);
        animals[openPlace] = leader;
        Penguin p1 = new Penguin("Ricco", 3, 180, false);
        openPlace = FindOpenPlace(animals);
        animals[openPlace] = p1;
        Penguin p2 = new Penguin("Private", 2, 170, false);
        openPlace = FindOpenPlace(animals);
        animals[openPlace] = p2;

        Lion l1 = new Lion("Mufasa", 12, 60, true);// Male that eats 25 Kg of meat
        Lion l2 = new Lion("Simba", 5, 30, true);// Male that eats less than 25 Kg of meat
        Lion l3 = new Lion("Sarabi", 11, 40, false);// Female that eats 25 Kg of meat
        Lion l4 = new Lion("Nala", 7, 30, false);// Female that eats less than 25 Kg of meat
        openPlace = FindOpenPlace(animals);
        animals[openPlace] = l1;
        openPlace = FindOpenPlace(animals);
        animals[openPlace] = l2;
        openPlace = FindOpenPlace(animals);
        animals[openPlace] = l3;
        openPlace = FindOpenPlace(animals);
        animals[openPlace] = l4;


        addFish(10);//default num

    }

    public void addFish(int num) {
        int numOfColors, colorNum, age, patternNum, fishType;
        float length;
        String pattern;
        String[] colors = new String[0];
        Random r = new Random();
        int openPlace;
        for (int i = 0; i < num; i++) {//create num of fish
            age = r.nextInt(10) + 1;
            length = r.nextFloat() + r.nextInt(20);
            fishType = r.nextInt(100) % 3;//random fish type(simple,clownfish or goldfish)
            openPlace = FindOpenPlace(animals);//finds the next null space to put the new fish in
            if (fishType == 0) {//SimpleFish
                numOfColors = r.nextInt(100) % 10 + 1;// number of colors a fish have
                patternNum = r.nextInt(4);// choose a random pattern
                pattern = fishPattern[patternNum];
                colors = new String[0];
                SimpleFish simplefish = new SimpleFish(age, length, pattern, colors);
                colorNum = r.nextInt(10);
                for (int j = 0; j < numOfColors; j++) {
                    do {
                        colorNum = r.nextInt(10);//if color exist in the fish, get another random number until you get a color that the fish doesn't have yet
                    } while (simplefish.isColorExist(fishColors[colorNum]));
                    simplefish.addColor(fishColors[colorNum]);
                }
                animals[openPlace] = simplefish;
            } else if (fishType == 1) {
                colorNum = r.nextInt(10) % 4;//the colors that goldfish can have are only on places 0-3 in the fishColors array
                GoldFish goldfish = new GoldFish(age, length, fishColors[colorNum]);
                animals[openPlace] = goldfish;
            } else {//fishType==2
                ClownFish clownFish = new ClownFish(age, length);
                animals[openPlace] = clownFish;
            }
        }
    }

    public int FindOpenPlace(Object[] object) {//checks where is the closest 'null' place
        int k = object.length - 1;//default place
        for (int i = 0; i < object.length; i++) {
            if (object[i] == null) {
                k = i;
                break;
            }
        }
        return k;
    }

    public float fishFeedCount() {
        float foodCount = 0;
        GoldFish g = new GoldFish();
        ClownFish c = new ClownFish();
        for (AquariumFish fish : getFishArray()) {
            if (fish == null) {
                break;
            }
            if (fish.getClass() == c.getClass()) {//if the fish is a Clownfish
                foodCount += c.feed();
            } else if (fish.getClass() == g.getClass()) {//if the fish is a Goldfish
                foodCount += g.feed();
            } else {//if the fish is a simple fish
                foodCount += fish.feed();
            }
        }
        return foodCount;
    }

    public int penguinFeedCount() {
        int foodCount = 0;
        for (Penguin p : (Penguin[]) getPenguinsArray()) {
            if (p == null) {
                continue;
            }
            if (p.isLeader()) {//the leader eats 2 times more than the rest of the group
                foodCount += p.feed() * 2;
            } else {
                foodCount += p.feed();
            }
        }
        return foodCount;
    }

    public int lionFeedCount() {
        int foodCount = 0;
        for (Lion lion : (Lion[]) getLionArray()) {
            if (lion == null) {
                break;
            }
            foodCount += lion.feed();
        }
        return foodCount;
    }

    public int tigerFeedCount() {
        int foodCount = 0;
        for (Tiger tiger : (Tiger[]) getTigerArray()) {
            if (tiger == null) {
                break;
            }
            foodCount += tiger.feed();
        }
        return foodCount;
    }

    public String hearTheAnimals() {
        StringBuilder sb = new StringBuilder();
        Penguin penguin = new Penguin();
        Lion lion = new Lion();
        Tiger tiger = new Tiger();
        AquariumFish fish = new AquariumFish();
        if (getPenguinsArray().length != 0) {
            sb.append(penguin.makeNoise());
        }
        if (getLionArray().length != 0) {
            sb.append(lion.makeNoise());
        }
        if (getTigerArray().length != 0) {
            sb.append(tiger.makeNoise());
        }
        if (getFishArray().length != 0) {
            sb.append(fish.makeNoise());
        }
        return sb.toString();
    }

    public int[] CountFish() {
        int clownFishCount = 0, goldFishCount = 0, simpleFishCount = 0;
        for (AquariumFish fish : getFishArray()) {
            switch (fish) {
                case null -> {
                    continue;
                }
                case ClownFish clownFish -> //if the fish is a Clownfish
                        clownFishCount += 1;
                case GoldFish goldFish -> //if the fish is a Goldfish
                        goldFishCount += 1;
                default -> //if the fish is a simple fish
                        simpleFishCount += 1;
            }
        }
        return new int[]{clownFishCount, goldFishCount, simpleFishCount};
    }

    public void HappyAnimals() {
        for (Object o : animals) {
            switch (o) {
                case null -> {
                    continue;
                }
                case Penguin penguin -> penguin.setHappiness(100);
                case Predator predator -> predator.setHappiness(100);
                case AquariumFish fish -> fish.setHappiness(100);
                default -> {
                }
            }
        }

    }

    public void AgeOneYear() {
        Random rand = new Random();
        int happinessDecrease;

        for (int i = 0; i < animals.length; i++) {
            // Age penguins and remove those that exceed life span
            if (animals[i] instanceof Penguin penguin) {
                penguin.setAge(penguin.getAge() + 1);
                if (penguin.getAge() > Penguin.LIFE_SPAN) {
                    animals[i] = null;// Remove reference
                    if (penguin.isLeader()) {
                        SetNewPenguinLeader();
                    }
                    continue;//if the animal is dead, there is no point in continue in this i
                }
                happinessDecrease = rand.nextInt(16) + 15;
                penguin.setHappiness(penguin.getHappiness() - happinessDecrease);
                if (penguin.getHappiness() <= 0) {
                    animals[i] = null;// Remove reference
                }
                continue;
            }
            if (animals[i] instanceof Predator predator) {
                // Age lions or tigers and remove those that exceed life span
                predator.setAge(predator.getAge() + 1);
                if (predator.getAge() > Predator.LIFE_SPAN) {
                    animals[i] = null;// Remove reference
                    continue;//if the animal is dead, there is no point in continue in this i
                }
                happinessDecrease = rand.nextInt(16) + 15;
                predator.setHappiness(predator.getHappiness() - happinessDecrease);
                if (predator.getHappiness() <= 0) {
                    animals[i] = null;// Remove reference
                }
                continue;
            }

            if (animals[i] instanceof AquariumFish fish) {
                fish.setAge(fish.getAge() + 1);
                switch (fish) {
                    case ClownFish clownFish -> {// Age clown fish and remove those that exceed life span
                        if (fish.getAge() > ClownFish.LIFE_SPAN) {
                            animals[i] = null;// Remove reference
                            continue;//if the animal is dead, there is no point in continue in this i
                        }
                        happinessDecrease = rand.nextInt(16) + 15;
                        fish.setHappiness(fish.getHappiness() - happinessDecrease);
                        if (fish.getHappiness() <= 0) {
                            animals[i] = null;// Remove reference
                        }
                    }
                    case SimpleFish simpleFish -> {// Age simple fish and remove those that exceed life span
                        if (fish.getAge() > SimpleFish.LIFE_SPAN) {
                            animals[i] = null;// Remove reference
                            continue;//if the animal is dead, there is no point in continue in this i
                        }
                        happinessDecrease = rand.nextInt(16) + 15;
                        fish.setHappiness(fish.getHappiness() - happinessDecrease);
                        if (fish.getHappiness() <= 0) {
                            animals[i] = null;// Remove reference
                        }
                    }
                    case GoldFish goldFish -> {// Age goldfish and remove those that exceed life span
                        if (fish.getAge() > GoldFish.LIFE_SPAN) {
                            animals[i] = null;// Remove reference
                            continue;//if the animal is dead, there is no point in continue in this i
                        }
                        happinessDecrease = rand.nextInt(16) + 15;
                        fish.setHappiness(fish.getHappiness() - happinessDecrease);
                        if (fish.getHappiness() <= 0) {
                            animals[i] = null;// Remove reference
                        }
                    }
                    default -> {
                    }
                }
            }
        }
    }

    public Penguin GetLeaderPenguin() {//return the leader of the penguins
        for (Penguin penguin : getPenguinsArray()) {
            if (penguin == null) {
                continue;
            }
            if (penguin.isLeader()) {
                return penguin;
            }
        }
        return null;
    }

    public void SetNewPenguinLeader() {
        Penguin currentLeader = GetLeaderPenguin();
        Penguin newLeader = null;
        float max = 0;

        for (Penguin penguin : getPenguinsArray()) {
            if (penguin != null && penguin != currentLeader) {
                if (penguin.getHeight() > max) {
                    newLeader = penguin;
                    max = penguin.getHeight();
                }
            }
        }

        if (currentLeader != null) {
            currentLeader.setLeader(false);
            System.out.println(currentLeader.getName() + " is no longer the leader.");
        }


        if (newLeader != null) {
            newLeader.setLeader(true);
            System.out.println("The new leader of the penguins is: " + newLeader.getName());
        } else {
            System.out.println("No new leader could be found.");
        }
    }
}
