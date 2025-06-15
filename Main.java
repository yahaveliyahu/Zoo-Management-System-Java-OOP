/**
 * submitting:
 * Yahav Eliyahu 315906818,
 * Matanya Cohen 312522196,
 * Arad Rotem 207748468
 **/


package yahav_eliyahu_matanya_cohen_arad_rotem;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private final static String[] MENU = {
            "Exit Program",
            "Show Zoo Details",
            "Add a Penguin",
            "Add a Predator",
            "Add a Fish",
            "Show Penguins",
            "Show Predators",
            "Show Fishes",
            "Feed The Animals",
            "Hear The Animals",
            "Age All Animals One Year"
    };
    public static Scanner s = new Scanner(System.in);
    public static ZooManager zoo = new ZooManager();

    public static void main() {

        zoo.builtInAnimals();//Hard coded that was required
        run();
        s.close();
    }

    public static void run() {
        int choice;
        do {

            choice = showMenu();

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program, GOODBYE!");
                    break;
                case 1:
                    showZoo(zoo);
                    break;
                case 2:
                    addPenguin();
                    break;
                case 3:
                    addPredators();
                    break;
                case 4:
                    addFish();
                    break;
                case 5:
                    showPenguin();
                    DBManager.showPenguinFromDB();

                    break;
                case 6:
                    showPredators();
                    DBManager.showPredatorsFromDB();

                    break;
                case 7:
                    showFish();
                    DBManager.showAquariumFishFromDB();
                    break;
                case 8:
                    FeedTheAnimals();
                    DBManager.FeedTheAnimalsFromDB();

                    break;
                case 9:
                  //  HearTheAnimals();
                    break;
                case 10:
                    AgeOneYear();
                    DBManager.ageOneYear();

                    System.out.println("All animals have aged one year.");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
                    break;

            }
        }
        while (choice != 0);
    }


    private static int showMenu() {
        System.out.println("\n Program Menu: \n");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ") " + MENU[i]);
        }
        System.out.println("Enter your chose:");
        return s.nextInt();
    }

    public static void showZoo(ZooManager z) {
        System.out.println(z.toString());
        System.out.println("The Zoo have:");
        System.out.println(zoo.getArrayLength(zoo.getPenguinsArray()) + " Penguins");
        System.out.println(zoo.getArrayLength(zoo.getLionArray()) + " Lions");
        System.out.println(zoo.getArrayLength(zoo.getTigerArray()) + " Tigers");
        int[] fishCount = zoo.CountFish();
        int clownFishCount = fishCount[0], goldFishCount = fishCount[1], simpleFishCount = fishCount[2];
        System.out.println(clownFishCount + " ClownFish. " + goldFishCount + " GoldFish and " + simpleFishCount + " SimpleFish");
    }

    public static void addPenguin() {
        String name = "", temp;
        int age = 0;
        float height;
        Penguin leader = zoo.GetLeaderPenguin();
        while (true) {
            try {
                System.out.println("Enter Penguin name: ");
                name = s.next();
                if (!name.matches("[a-zA-Z0-9]+")) {
                    throw new IllegalArgumentException("Invalid name. The name must contain at least one letter or digit, and no special characters.");
                } else {
                    break;//if the name is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Enter Penguin age: ");
                age = s.nextInt();
                if (age <= 0) {
                    throw new IllegalArgumentException("It is not possible for the age to be 0 or less than that.");
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // Exit early if the age is invalid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number for the age (greater than 0).");
                temp = s.next();
            }
        }
        while (true) {
            try {
                System.out.println("Enter Penguin height: ");
                height = s.nextFloat();
                if (height >= leader.getHeight() || height < 1) {
                    throw new IllegalArgumentException("The penguin must be shorter than the leader penguin and its height must be greater than 0.");
                } else {
                    break;//if the height is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number for the height.");
                temp = s.next();
            }
        }
        Penguin p = new Penguin(name, age, height, false);//the leader is already chosen so every new penguin cant be the leader
        Object[] newAnimalArray = zoo.getAnimalArray();

        if (zoo.getAnimalArray()[zoo.getAnimalArray().length - 1] != null) {//multiplies the array if it's full(required from the instructions)
            newAnimalArray = Arrays.copyOf(zoo.getAnimalArray(), zoo.getAnimalArray().length * 2);
        }
        int openPlace = zoo.FindOpenPlace(newAnimalArray);
        newAnimalArray[openPlace] = p;
        zoo.setAnimalArray(newAnimalArray);


    }

    private static void addPredators() {
        System.out.println("Do you want to add a L (for Lion) or a T (for Tiger) to the zoo?");
        String animal = s.next();
        while (!animal.equalsIgnoreCase("L") && !animal.equalsIgnoreCase("T")) {
            System.out.println("Invalid pattern. Please enter a valid predator (L/T): ");
            animal = s.next();
        }
        if (animal.equalsIgnoreCase("L")) {
            addLion();
        } else {
            addTiger();
        }
    }

    public static void addLion() {
        String name, temp;
        int age;
        float weight;
        boolean isMale;
        while (true) {
            try {
                System.out.println("Enter a name of lion: ");
                name = s.next();
                if (!name.matches("[a-zA-Z0-9]+")) {
                    throw new IllegalArgumentException("Invalid name. The name must contain at least one letter or digit, and no special characters.");
                } else {
                    break;//if the name is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Enter an age of lion: ");
                age = s.nextInt();
                if (age <= 0) {
                    throw new IllegalArgumentException("It is not possible for the age to be 0 or less than that.");
                } else {
                    break;//if the age is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number of age (over 0).");
                temp = s.next();
            }
        }
        while (true) {
            try {
                System.out.println("Enter a weight of lion: ");
                weight = s.nextFloat();
                if (weight <= 0) {
                    throw new IllegalArgumentException("It is not possible for the weight to be 0 or less than that.");
                } else {
                    break;//if the weight is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number of weight (over 0).");
                temp = s.next();
            }
        }
        while (true) {
            try {
                System.out.println("The lion is male? (true/false): ");
                isMale = s.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid true/false");
                temp = s.next();
            }
        }
        Lion lion = new Lion(name, age, weight, isMale);
        Object[] newAnimalArray = zoo.getAnimalArray();
        if (zoo.getAnimalArray()[zoo.getAnimalArray().length - 1] != null) {//multiplies the array if it's full(required from the instructions)
            newAnimalArray = Arrays.copyOf(newAnimalArray, newAnimalArray.length * 2);
        }
        int openPlace = zoo.FindOpenPlace(newAnimalArray);
        System.out.println(newAnimalArray.length);
        newAnimalArray[openPlace] = lion;
        zoo.setAnimalArray(newAnimalArray);

    }

    public static void addTiger() {
        String name, temp;
        int age;
        float weight;
        boolean isMale;
        while (true) {
            try {
                System.out.println("Enter a name of tiger: ");
                name = s.next();
                if (!name.matches("[a-zA-Z0-9]+")) {
                    throw new IllegalArgumentException("Invalid name. The name must contain at least one letter or digit, and no special characters.");
                } else {
                    break;//if the name is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Enter an age of tiger: ");
                age = s.nextInt();
                if (age <= 0) {
                    throw new IllegalArgumentException("It is not possible for the age to be 0 or less than that.");
                } else {
                    break;//if the age is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number of age (over 0).");
                temp = s.next();
            }
        }
        while (true) {
            try {
                System.out.println("Enter a weight of tiger: ");
                weight = s.nextFloat();
                if (weight <= 0) {
                    throw new IllegalArgumentException("It is not possible for the weight to be 0 or less than that.");
                } else {
                    break;//if the weight is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number of weight (over 0).");
                temp = s.next();
            }
        }
        while (true) {
            try {
                System.out.println("The tiger is male? (true/false): ");
                isMale = s.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid true/false");
                temp = s.next();
            }
        }
        Tiger tiger = new Tiger(name, age, weight, isMale);
        Object[] newAnimalArray = zoo.getAnimalArray();
        if (zoo.getAnimalArray()[zoo.getAnimalArray().length - 1] != null) {//multiplies the array if it's full(required from the instructions)
            newAnimalArray = Arrays.copyOf(newAnimalArray, newAnimalArray.length * 2);
        }
        int openPlace = zoo.FindOpenPlace(newAnimalArray);
        System.out.println(newAnimalArray.length);
        newAnimalArray[openPlace] = tiger;
        zoo.setAnimalArray(newAnimalArray);

    }

    public static void addFish() {
        int openPlace;
        int age, numOfColors;
        float length;
        String pattern, color, temp;
        Object[] newAnimalArray = zoo.getAnimalArray();
        if (zoo.getAnimalArray()[zoo.getAnimalArray().length - 1] != null) {//multiplies the array if it's full(required from the instructions)
            newAnimalArray = Arrays.copyOf(zoo.getAnimalArray(), zoo.getAnimalArray().length * 2);
        }
        System.out.println("Enter the type of the fish(Simple (for Simplefish)/Clown (for Clownfish)/Gold (for Goldfish)):");
        String fishtype = s.next();
        while (!fishtype.equalsIgnoreCase("Simple") && !fishtype.equalsIgnoreCase("Clown") &&
                !fishtype.equalsIgnoreCase("Gold")) {
            System.out.println("Invalid pattern. Please enter a valid fish type (Simple/Clown/Gold): ");
            fishtype = s.next();
        }
        fishtype = fishtype.substring(0, 1).toUpperCase() + fishtype.substring(1).toLowerCase();//make the first letter to an uppercase letter and the rest to lowercase letters
        while (true) {
            try {
                System.out.println("Enter fish age: ");
                age = s.nextInt();
                if (age <= 0) {
                    throw new IllegalArgumentException("Invalid age! The age must be greater than 0.");
                } else {
                    break;//if the age is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number of age (over 0): ");
                temp = s.next();
            }
        }
        while (true) {
            try {
                System.out.println("Enter fish length (in float): ");
                length = s.nextFloat();
                if (length <= 0) {
                    throw new IllegalArgumentException("Invalid length! The length must be greater than 0.");
                } else {
                    break;//if the length is valid, proceed to the next thing
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number of length (over 0).");
                temp = s.next();
            }
        }
        openPlace = zoo.FindOpenPlace(zoo.getAnimalArray());
        if (fishtype.equals("Simple")) {//if the user chose to insert a Simple fish to the Aquarium
            System.out.println("Enter fish pattern(Dots, Strips, Stains, Blank)");
            pattern = s.next();
            while (!pattern.equalsIgnoreCase("Dots") && !pattern.equalsIgnoreCase("Strips") &&
                    !pattern.equalsIgnoreCase("Stains") && !pattern.equalsIgnoreCase("Blank")) {
                System.out.println("Invalid pattern. Please enter a valid fish pattern (Dots, Strips, Stains, Blank): ");
                pattern = s.next();
            }
            pattern = pattern.substring(0, 1).toUpperCase() + pattern.substring(1).toLowerCase();//make the first letter to an uppercase letter and the rest to lowercase letters
            while (true) {
                try {
                    System.out.println("How many colors does the fish have? ");
                    numOfColors = s.nextInt();
                    if (numOfColors > 10 || numOfColors < 1) {
                        throw new IllegalArgumentException("A fish cannot have more than 10 colors or be colorless (considering that the fish can only be of the above 10 colors)."
                                + "Please enter a valid number of colors (up to 10): ");
                    } else {
                        break;//if the length is valid, proceed to the next thing
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number of length (over 0).");
                    temp = s.next();
                }
            }
            String[] colors = new String[0];
            SimpleFish fish = new SimpleFish(age, length, pattern, colors);
            for (int i = 0; i < numOfColors; i++) {
                System.out.println("Enter a color(Black, White, Green, Orange, Blue, Yellow, Brown, Gold, Red, Cyan)");
                color = s.next();
                while (!color.equalsIgnoreCase("Black") && !color.equalsIgnoreCase("White") &&
                        !color.equalsIgnoreCase("Green") && !color.equalsIgnoreCase("Orange") &&
                        !color.equalsIgnoreCase("Blue") && !color.equalsIgnoreCase("Yellow") &&
                        !color.equalsIgnoreCase("Brown") && !color.equalsIgnoreCase("Gold") &&
                        !color.equalsIgnoreCase("Red") && !color.equalsIgnoreCase("Cyan")) {
                    System.out.println("Invalid pattern. Please enter a valid color (Black, White, Green, Orange, Blue, Yellow, Brown, Gold, Red, Cyan): ");
                    color = s.next();
                }
                color = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();//make the first letter to an uppercase letter and the rest to lowercase letters
                while (fish.isColorExist(color)) {
                    System.out.println("This fish already have this color");
                    System.out.println("Please enter a different color(Black, White, Green, Orange, Blue, Yellow, Brown, Gold, Red, Cyan)");
                    color = s.next();
                }
                fish.addColor(color);
            }
            newAnimalArray[openPlace + 1] = fish;
        } else if (fishtype.equals("Clown")) {//if the user chose to insert a Clownfish to the Aquarium
            System.out.println("Enter main color of the ClownFish (Blue, Black, Orange):");
            color = s.next();

            while (!color.equalsIgnoreCase("Blue") && !color.equalsIgnoreCase("Black") && !color.equalsIgnoreCase("Orange")) {
                System.out.println("Invalid color. Please enter Blue, Black, or Orange:");
                color = s.next();
            }

            color = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
            ClownFish clownFish = new ClownFish(age, length, color);
            openPlace = zoo.FindOpenPlace(zoo.getFishArray());
            newAnimalArray[openPlace + 1] = clownFish;
        } else {//fishtype.equals("Goldfish")
            GoldFish goldFish = new GoldFish(age, length);
            openPlace = zoo.FindOpenPlace(zoo.getFishArray());
            newAnimalArray[openPlace + 1] = goldFish;
        }
        zoo.setAnimalArray(newAnimalArray);
    }

    private static void showPenguin() {
        Penguin[] penguinsArray = zoo.getPenguinsArray();

        // A filter of null values from the array
        penguinsArray = Arrays.stream(penguinsArray)
                .filter(Objects::nonNull) // Removing null values
                .toArray(Penguin[]::new);

        if (penguinsArray.length == 0) {
            System.out.println("There are no penguins in the zoo.");
            return;
        }

        System.out.println("Choose sorting method:");
        System.out.println("1. Sort by name (ascending)");
        System.out.println("2. Sort by height (descending)");
        System.out.println("3. Sort by age (ascending)");

        int choice = s.nextInt();

        switch (choice) {
            case 1:
                Arrays.sort(penguinsArray, new PenguinNameComparator()); // Sort by name
                break;
            case 2:
                Arrays.sort(penguinsArray); // Sort by height
                break;
            case 3:
                Arrays.sort(penguinsArray, new PenguinAgeComparator()); // Sort by age
                break;
            default:
                System.out.println("Invalid choice, default sorting by height.");
                Arrays.sort(penguinsArray); // Sort by height by default
                break;
        }

        for (Penguin p : penguinsArray) {
            if (p != null) {
                System.out.println(p);
            }
        }
    }

    private static void showPredators() {
        if (zoo.getLionArray().length == 0) {
            System.out.println("There are no Lions in the zoo");
        } else {
            System.out.println("Lions:");
            for (Object l : zoo.getLionArray()) {
                if (l == null) {
                    continue;
                }
                System.out.println(l);
            }
        }
        if (zoo.getTigerArray().length == 0) {
            System.out.println("There are no Tigers in the zoo");
        } else {
            System.out.println("\nTigers:");
            for (Object t : zoo.getTigerArray()) {
                if (t == null) {
                    continue;
                }
                System.out.println(t);
            }
        }
    }

    private static void showFish() {
        int[] colorsCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        AquariumFish allFishColor = new AquariumFish(0, 0f);
        // we'll create an empty fish and use only his colorsArray functions to make an array of all the colors in the Aquarium
        for (AquariumFish fish : (AquariumFish[]) zoo.getFishArray()) {
            if (fish == null) {
                continue;
            }
            System.out.println(fish);
            for (int i = 0; i < fish.getColorsArray().length; i++) {
                if (allFishColor.getColorsArray() != null) {
                    if (!allFishColor.isColorExist(fish.getColorsArray()[i])) {
                        allFishColor.addColor(fish.getColorsArray()[i]);
                    }
                } else {
                    allFishColor.addColor(fish.getColorsArray()[i]);
                }

                for (int j = 0; j < zoo.fishColors.length; j++) {//sums the colors count in the Aquarium
                    if (Objects.equals(fish.getColorsArray()[i], zoo.fishColors[j])) {
                        colorsCount[j]++;
                    }
                }
            }
        }
        int max1 = 0, max2 = 0, maxplace1 = 0, maxplace2 = 0;
        for (int k = 0; k < colorsCount.length; k++) {//check the place of the biggest num of the colors count
            if (colorsCount[k] > max1) {
                max1 = colorsCount[k];
                maxplace1 = k;
            }
        }
        for (int p = 0; p < colorsCount.length; p++) {//check the place of the second biggest num of the colors count
            if (colorsCount[p] > max2 && p != maxplace1) {//make sure the second max number isn't the same as the first
                max2 = colorsCount[p];
                maxplace2 = p;
            }
        }


        StringBuilder colors = new StringBuilder();
        for (int a = 0; a < allFishColor.getColorsArray().length; a++) {
            if (a == allFishColor.getColorsArray().length - 1) {//thr last color in the list
                colors.append("and ").append(allFishColor.getColorsArray()[a]);
            } else {
                colors.append(allFishColor.getColorsArray()[a]).append(", ");
            }
        }
        StringBuilder st = new StringBuilder();
        for (int b = 0; b < zoo.fishColors.length; b++) {//print each colors count
            st.append(zoo.fishColors[b]).append(" : ").append(colorsCount[b]).append("\n");

        }
        System.out.println("The fishes in the Aquarium have the colors: " + colors);
        //System.out.println(st.toString());//print each colors count
        if (max1 != 0 && max2 != 0) {//print if there is more than 1 color in the Aquarium
            System.out.println("And the most dominants colors are: " + zoo.fishColors[maxplace1] + " and " + zoo.fishColors[maxplace2]);
        } else if (max1 != 0) {//print if there is only 1 color in the Aquarium(like only 3 Orange GoldFish)
            System.out.println("And the most dominants color is: " + zoo.fishColors[maxplace1]);
        }
    }

    public static void FeedTheAnimals() {
        System.out.println("The animals are being fed.");
        float fishFood = zoo.fishFeedCount();
        System.out.println("The fish ate " + String.format("%.2f", fishFood) + " food portions for "+zoo.getArrayLength(zoo.getFishArray())+" Fish");//print the float with only 2 numbers after the dot

        int penguinFood = zoo.penguinFeedCount();
        System.out.println("The Penguins ate " + penguinFood + " Fishes for "+zoo.getArrayLength(zoo.getPenguinsArray()) + " Penguins");

        int lionFood = zoo.lionFeedCount();
        System.out.println("The Lions ate " + lionFood + " kg of meat for "+zoo.getArrayLength(zoo.getLionArray()) + " Lions");

        int tigerFood = zoo.tigerFeedCount();
        System.out.println("The Tigers ate " + tigerFood + " kg of meat for "+zoo.getArrayLength(zoo.getTigerArray()) + " Tigers");
        zoo.HappyAnimals();//after feeding the animals, their happiness becomes 100
    }

//    private static void HearTheAnimals() {
//        System.out.println(zoo.hearTheAnimals());
//    }

    private static void AgeOneYear() {
        zoo.AgeOneYear();
    }

}
