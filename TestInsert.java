package yahav_eliyahu_arad_rotem;

public class TestInsert {
    public static void main(String[] args) {
        insertPenguins();
        insertLions();
        insertTigers();
        insertSimpleFish();
        insertGoldFish();
        insertClownFish();

        System.out.println("🎉 All test data inserted!");
    }

    private static void insertPenguins() {
        Penguin p1 = new Penguin("Skeeper", 4, 200, true, 6);
        p1.setHappiness(100);
        DBManager.insertPenguin(p1, 1);

        Penguin p2 = new Penguin("Ricco", 3, 180, false, 6);
        p2.setHappiness(100);
        DBManager.insertPenguin(p2, 2);

        Penguin p3 = new Penguin("Private", 2, 170, false, 6);
        p3.setHappiness(100);
        DBManager.insertPenguin(p3, 3);
    }

    private static void insertLions() {
        Lion l1 = new Lion("Mufasa", 12, 60, true, Predator.LIFE_SPAN, "DarkBrown");
        l1.setHappiness(100);
        DBManager.insertLion(l1, 4);

        Lion l2 = new Lion("Simba", 5, 30, true, Predator.LIFE_SPAN, "Golden");
        l2.setHappiness(100);
        DBManager.insertLion(l2, 5);

        Lion l3 = new Lion("Sarabi", 11, 40, false, Predator.LIFE_SPAN, null);
        l3.setHappiness(100);
        DBManager.insertLion(l3, 6);

        Lion l4 = new Lion("Nala", 5, 30, false, Predator.LIFE_SPAN, null);
        l4.setHappiness(100);
        DBManager.insertLion(l4, 7);

    }

    private static void insertTigers() {
        Tiger t1 = new Tiger("Shere Khan", 10, 60, true, Predator.LIFE_SPAN, 100);
        t1.setHappiness(100);
        DBManager.insertTiger(t1, 8);

        Tiger t2 = new Tiger("Tai Lung", 7, 40, true, Predator.LIFE_SPAN, 120);
        t2.setHappiness(100);
        DBManager.insertTiger(t2, 9);
    }

    private static void insertSimpleFish() {
        String[] colors1 = {"gray", "black"};
        SimpleFish simpleFish = new SimpleFish(3, 5.5f, "Dots", colors1);
        DBManager.insertSimpleFish(simpleFish, 10);
    }

    private static void insertGoldFish() {
        GoldFish goldFish = new GoldFish(1, 1.8f);
        DBManager.insertGoldFish(goldFish, 11);
    }

    private static void insertClownFish() {
        String[] colors3 = {"orange", "white"};
        ClownFish clownFish = new ClownFish(2, 2.3f, "Orange");
        DBManager.insertClownFish(clownFish, 12);
    }

}


