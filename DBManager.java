package yahav_eliyahu_arad_rotem;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class DBManager {

    public static int getNextAvailableAnimalID() {
        int nextId = 1; // ברירת מחדל למקרה שהטבלה ריקה

        try (Connection conn = DBConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT MAX(AnimalID) FROM Animal")) {

            if (rs.next()) {
                nextId = rs.getInt(1) + 1;
            }

        } catch (SQLException e) {
            System.err.println("❌ Error fetching next AnimalID: " + e.getMessage());
        }

        return nextId;
    }
    public static void insertPenguin(Penguin p, int id) {
        try (Connection conn = DBConnector.connect()) {

            // Checking if a penguin with the same ID already exists
            PreparedStatement check = conn.prepareStatement("SELECT 1 FROM Penguin WHERE PenguinID = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                System.out.println("⚠️ Penguin with ID " + id + " already exists. Skipping insert.");
                return;
            }

            // Insert into Animal
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Animal VALUES (?, ?)");
            ps1.setInt(1, id);
            ps1.setInt(2, p.getAge());
            ps1.executeUpdate();

            // Insert into Penguin
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Penguin VALUES (?, ?, ?, ?, ?, ?)");
            ps2.setInt(1, id);
            ps2.setString(2, p.getName());
            ps2.setFloat(3, p.getHeight());
            ps2.setBoolean(4, p.isLeader());
            ps2.setInt(5, p.getLifeSpan());
            ps2.setInt(6, p.getHappiness());
            ps2.executeUpdate();

            System.out.println("✅ Penguin inserted successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error inserting penguin: " + e.getMessage());
        }
    }

    public static void insertLion(Lion l, int id) {
        try (Connection conn = DBConnector.connect()) {

            PreparedStatement check = conn.prepareStatement("SELECT 1 FROM Lion WHERE LionID = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                System.out.println("⚠️ Lion with ID " + id + " already exists. Skipping insert.");
                return;
            }

            // Insert into Animal
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Animal (animalid, age) VALUES (?, ?)");
            ps1.setInt(1, id);
            ps1.setInt(2, l.getAge());
            ps1.executeUpdate();

            // Insert into Predator
            PreparedStatement ps2 = conn.prepareStatement(
                    "INSERT INTO Predator (predatorid, name, weight, life_span, happiness, ismale) VALUES (?, ?, ?, ?, ?, ?)");
            ps2.setInt(1, id);
            ps2.setString(2, l.getName());
            ps2.setFloat(3, l.getWeight());
            ps2.setInt(4, l.getLifeSpan());
            ps2.setInt(5, l.getHappiness());
            ps2.setBoolean(6, l.isMale());
            ps2.executeUpdate();

            // Insert into Lion
            PreparedStatement ps3 = conn.prepareStatement(
                    "INSERT INTO Lion (lionid, manecolor) VALUES (?, ?)");
            ps3.setInt(1, id);
            ps3.setString(2, l.getManeColor());
            ps3.executeUpdate();

            System.out.println("✅ Lion inserted successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error inserting lion: " + e.getMessage());
        }
    }

    public static void insertTiger(Tiger t, int id) {
        try (Connection conn = DBConnector.connect()) {

            PreparedStatement check = conn.prepareStatement("SELECT 1 FROM Tiger WHERE TigerID = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                System.out.println("⚠️ Tiger with ID " + id + " already exists. Skipping insert.");
                return;
            }

            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Animal (animalid, age) VALUES (?, ?)");
            ps1.setInt(1, id);
            ps1.setInt(2, t.getAge());
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(
                    "INSERT INTO Predator (predatorid, name, weight, life_span, happiness, ismale) VALUES (?, ?, ?, ?, ?, ?)");
            ps2.setInt(1, id);
            ps2.setString(2, t.getName());
            ps2.setFloat(3, t.getWeight());
            ps2.setInt(4, t.getLifeSpan());
            ps2.setInt(5, t.getHappiness());
            ps2.setBoolean(6, t.isMale());
            ps2.executeUpdate();

            PreparedStatement ps3 = conn.prepareStatement("INSERT INTO Tiger (tigerid, stripecount) VALUES (?, ?)");
            ps3.setInt(1, id);
            ps3.setInt(2, t.getStripeCount());
            ps3.executeUpdate();

            System.out.println("✅ Tiger inserted successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error inserting tiger: " + e.getMessage());
        }
    }

    public static void insertSimpleFish(SimpleFish sf, int id) {
        try (Connection conn = DBConnector.connect()) {
            PreparedStatement check = conn.prepareStatement("SELECT 1 FROM SimpleFish WHERE simplefishid = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                System.out.println("⚠️ SimpleFish with ID " + id + " already exists. Skipping insert.");
                return;
            }

            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Animal (animalid, age) VALUES (?, ?)");
            ps1.setInt(1, id);
            ps1.setInt(2, sf.getAge());
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO AquariumFish (fishid, length, sign, happiness) VALUES (?, ?, ?, ?)");
            ps2.setInt(1, id);
            ps2.setFloat(2, sf.getLength());
            ps2.setString(3, sf.getSign());
            ps2.setInt(4, sf.getHappiness());
            ps2.executeUpdate();

            PreparedStatement ps3 = conn.prepareStatement("INSERT INTO SimpleFish (simplefishid, life_span) VALUES (?, ?)");
            ps3.setInt(1, id);
            ps3.setInt(2, sf.getLifeSpan());
            ps3.executeUpdate();

            System.out.println("✅ SimpleFish inserted successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error inserting simplefish: " + e.getMessage());
        }
    }

    public static void insertClownFish(ClownFish cf, int id) {
        try (Connection conn = DBConnector.connect()) {
            PreparedStatement check = conn.prepareStatement("SELECT 1 FROM ClownFish WHERE clownfishid = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                System.out.println("⚠️ ClownFish with ID " + id + " already exists. Skipping insert.");
                return;
            }

            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Animal (animalid, age) VALUES (?, ?)");
            ps1.setInt(1, id);
            ps1.setInt(2, cf.getAge());
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO AquariumFish (fishid, length, sign, happiness) VALUES (?, ?, ?, ?)");
            ps2.setInt(1, id);
            ps2.setFloat(2, cf.getLength());
            ps2.setString(3, cf.getSign());
            ps2.setInt(4, cf.getHappiness());
            ps2.executeUpdate();

            PreparedStatement ps3 = conn.prepareStatement("INSERT INTO ClownFish (clownfishid, life_span) VALUES (?, ?)");
            ps3.setInt(1, id);
            ps3.setInt(2, cf.getLifeSpan());
            ps3.executeUpdate();

            System.out.println("✅ ClownFish inserted successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error inserting clownfish: " + e.getMessage());
        }
    }

    public static void insertGoldFish(GoldFish gf, int id) {
        try (Connection conn = DBConnector.connect()) {
            PreparedStatement check = conn.prepareStatement("SELECT 1 FROM GoldFish WHERE goldfishid = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                System.out.println("⚠️ GoldFish with ID " + id + " already exists. Skipping insert.");
                return;
            }

            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Animal (animalid, age) VALUES (?, ?)");
            ps1.setInt(1, id);
            ps1.setInt(2, gf.getAge());
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO AquariumFish (fishid, length, sign, happiness) VALUES (?, ?, ?, ?)");
            ps2.setInt(1, id);
            ps2.setFloat(2, gf.getLength());
            ps2.setString(3, gf.getSign());
            ps2.setInt(4, gf.getHappiness());
            ps2.executeUpdate();

            PreparedStatement ps3 = conn.prepareStatement("INSERT INTO GoldFish (goldfishid, life_span) VALUES (?, ?)");
            ps3.setInt(1, id);
            ps3.setInt(2, gf.getLifeSpan());
            ps3.executeUpdate();

            System.out.println("✅ GoldFish inserted successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error inserting goldfish: " + e.getMessage());
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void ageOneYear() throws SQLException {
        Statement stmt = null;
        Random rand = new Random();

        try (Connection conn = DBConnector.connect()) {
            stmt = conn.createStatement();

            // 1. Age all animals (Animal table contains Age for everyone)
            stmt.executeUpdate("UPDATE Animal SET Age = Age + 1;");

            // 2. Handle Penguins: Delete if Age > LIFE_SPAN
            stmt.executeUpdate("""
            DELETE FROM Penguin 
            WHERE PenguinID IN (
                SELECT AnimalID FROM Animal 
                JOIN Penguin ON AnimalID = PenguinID
                WHERE Age > LIFE_SPAN
            )
        """);

            // 3. Randomly decrease happiness for Penguins
            try (PreparedStatement updatePenguinHappiness = conn.prepareStatement(
                    "UPDATE Penguin SET Happiness = Happiness - ? WHERE PenguinID = ?")) {

                ResultSet penguins = stmt.executeQuery("SELECT PenguinID FROM Penguin");
                while (penguins.next()) {
                    int id = penguins.getInt(1);
                    int decrease = rand.nextInt(16) + 15;
                    updatePenguinHappiness.setInt(1, decrease);
                    updatePenguinHappiness.setInt(2, id);
                    updatePenguinHappiness.addBatch();
                }
                updatePenguinHappiness.executeBatch();
            }

            // 4. Delete Penguins with Happiness <= 0
            stmt.executeUpdate("DELETE FROM Penguin WHERE Happiness <= 0;");

            // 5. Set new Penguin leader if none exists
            stmt.executeUpdate("""
            UPDATE Penguin SET IsLeader = TRUE 
            WHERE PenguinID = (SELECT PenguinID FROM Penguin LIMIT 1) 
            AND NOT EXISTS (SELECT 1 FROM Penguin WHERE IsLeader = TRUE);
        """);

            // 6. Handle Predators: Delete if Age > LIFE_SPAN
            stmt.executeUpdate("""
            DELETE FROM Predator
            WHERE PredatorID IN (
                SELECT AnimalID FROM Animal 
                JOIN Predator ON AnimalID = PredatorID
                WHERE Age > LIFE_SPAN
            )
        """);

            // 7. Randomly decrease happiness for Predators
            try (PreparedStatement updatePredatorHappiness = conn.prepareStatement(
                    "UPDATE Predator SET Happiness = Happiness - ? WHERE PredatorID = ?")) {

                ResultSet predators = stmt.executeQuery("SELECT PredatorID FROM Predator");
                while (predators.next()) {
                    int id = predators.getInt(1);
                    int decrease = rand.nextInt(16) + 15;
                    updatePredatorHappiness.setInt(1, decrease);
                    updatePredatorHappiness.setInt(2, id);
                    updatePredatorHappiness.addBatch();
                }
                updatePredatorHappiness.executeBatch();
            }

            // 8. Delete Predators with Happiness <= 0
            stmt.executeUpdate("DELETE FROM Predator WHERE Happiness <= 0;");

            // 9. Handle AquariumFish: Delete if Age > LIFE_SPAN (different tables)

            // ClownFish
            stmt.executeUpdate("""
            DELETE FROM AquariumFish
            WHERE FishID IN (
                SELECT FishID FROM AquariumFish
                JOIN ClownFish ON FishID = ClownFishID
                JOIN Animal ON FishID = AnimalID
                WHERE Age > LIFE_SPAN
            )
        """);

            // SimpleFish
            stmt.executeUpdate("""
            DELETE FROM AquariumFish
            WHERE FishID IN (
                SELECT FishID FROM AquariumFish
                JOIN SimpleFish ON FishID = SimpleFishID
                JOIN Animal ON FishID = AnimalID
                WHERE Age > LIFE_SPAN
            )
        """);

            // GoldFish
            stmt.executeUpdate("""
            DELETE FROM AquariumFish
            WHERE FishID IN (
                SELECT FishID FROM AquariumFish
                JOIN GoldFish ON FishID = GoldFishID
                JOIN Animal ON FishID = AnimalID
                WHERE Age > LIFE_SPAN
            )
        """);

            // 10. Randomly decrease happiness for AquariumFish
            try (PreparedStatement updateFishHappiness = conn.prepareStatement(
                    "UPDATE AquariumFish SET Happiness = Happiness - ? WHERE FishID = ?")) {

                ResultSet fish = stmt.executeQuery("SELECT FishID FROM AquariumFish");
                while (fish.next()) {
                    int id = fish.getInt(1);
                    int decrease = rand.nextInt(16) + 15;
                    updateFishHappiness.setInt(1, decrease);
                    updateFishHappiness.setInt(2, id);
                    updateFishHappiness.addBatch();
                }
                updateFishHappiness.executeBatch();
            }

            // 11. Delete AquariumFish with Happiness <= 0
            stmt.executeUpdate("DELETE FROM AquariumFish WHERE Happiness <= 0;");

            System.out.println("✅ All animals aged one year successfully.");
        }
    }

    public static void showPenguinFromDB() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose sorting method:");
        System.out.println("1. Sort by name (ascending)");
        System.out.println("2. Sort by height (descending)");
        System.out.println("3. Sort by age (ascending)");

        int choice = scanner.nextInt();
        String orderByClause;

        switch (choice) {
            case 1:
                orderByClause = "ORDER BY Penguin.Name ASC";
                break;
            case 2:
                orderByClause = "ORDER BY Penguin.Height DESC";
                break;
            case 3:
                orderByClause = "ORDER BY Animal.Age ASC";
                break;
            default:
                System.out.println("Invalid choice, default sorting by height.");
                orderByClause = "ORDER BY Penguin.Height DESC";
                break;
        }

        String sql = "SELECT Penguin.PenguinID, Animal.Age, Penguin.Name, Penguin.Height, " +
                "Penguin.IsLeader, Penguin.LIFE_SPAN, Penguin.Happiness " +
                "FROM Penguin " +
                "JOIN Animal ON Penguin.PenguinID = Animal.AnimalID " +
                orderByClause;

        try (Connection conn = DBConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hasResults = false;

            while (rs.next()) {
                hasResults = true;
                int id = rs.getInt("PenguinID");
                int age = rs.getInt("Age");
                String name = rs.getString("Name");
                float height = rs.getFloat("Height");
                boolean isLeader = rs.getBoolean("IsLeader");
                int lifeSpan = rs.getInt("LIFE_SPAN");
                int happiness = rs.getInt("Happiness");

                System.out.println("Penguin ID: " + id +
                        ", Name: " + name +
                        ", Age: " + age +
                        ", Height: " + height +
                        ", Is Leader: " + isLeader +
                        ", LIFE_SPAN: " + lifeSpan +
                        ", Happiness: " + happiness);
            }

            if (!hasResults) {
                System.out.println("There are no penguins in the zoo.");
            }

        } catch (SQLException e) {
            System.err.println("Error fetching penguins: " + e.getMessage());
        }
    }

    public static void showPredatorsFromDB() {
        try (Connection conn = DBConnector.connect()) {

            // Lions
            String lionSql = """
            SELECT Lion.LionID, Animal.Age, Predator.Name, Predator.Weight, Predator.LIFE_SPAN,
                   Predator.Happiness, Predator.IsMale, Lion.ManeColor
            FROM Lion
            JOIN Predator ON Lion.LionID = Predator.PredatorID
            JOIN Animal ON Predator.PredatorID = Animal.AnimalID
            ORDER BY Predator.Name ASC
            """;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(lionSql)) {

                if (!rs.isBeforeFirst()) {
                    System.out.println("There are no Lions in the zoo.");
                } else {
                    System.out.println("Lions:");
                    while (rs.next()) {
                        int id = rs.getInt("LionID");
                        String name = rs.getString("Name");
                        int age = rs.getInt("Age");
                        float weight = rs.getFloat("Weight");
                        int lifeSpan = rs.getInt("LIFE_SPAN");
                        int happiness = rs.getInt("Happiness");
                        boolean isMale = rs.getBoolean("IsMale");
                        String maneColor = rs.getString("ManeColor");

                        System.out.println("Lion ID: " + id +
                                ", Name: " + name +
                                ", Age: " + age +
                                ", Weight: " + weight +
                                ", LIFE_SPAN: " + lifeSpan +
                                ", Happiness: " + happiness +
                                ", Is Male: " + isMale +
                                ", Mane Color: " + maneColor);
                    }
                }
            }

            // Tigers
            String tigerSql = """
            SELECT Tiger.TigerID, Animal.Age, Predator.Name, Predator.Weight, Predator.LIFE_SPAN,
                   Predator.Happiness, Predator.IsMale, Tiger.StripeCount
            FROM Tiger
            JOIN Predator ON Tiger.TigerID = Predator.PredatorID
            JOIN Animal ON Predator.PredatorID = Animal.AnimalID
            ORDER BY Predator.Name ASC
            """;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(tigerSql)) {

                if (!rs.isBeforeFirst()) {
                    System.out.println("\nThere are no Tigers in the zoo.");
                } else {
                    System.out.println("\nTigers:");
                    while (rs.next()) {
                        int id = rs.getInt("TigerID");
                        String name = rs.getString("Name");
                        int age = rs.getInt("Age");
                        float weight = rs.getFloat("Weight");
                        int lifeSpan = rs.getInt("LIFE_SPAN");
                        int happiness = rs.getInt("Happiness");
                        boolean isMale = rs.getBoolean("IsMale");
                        int stripeCount = rs.getInt("StripeCount");

                        System.out.println("Tiger ID: " + id +
                                ", Name: " + name +
                                ", Age: " + age +
                                ", Weight: " + weight +
                                ", LIFE_SPAN: " + lifeSpan +
                                ", Happiness: " + happiness +
                                ", Is Male: " + isMale +
                                ", Stripe Count: " + stripeCount);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error fetching predators: " + e.getMessage());
        }
    }

    public static void showAquariumFishFromDB() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose which fish to display:");
        System.out.println("1. Show ClownFish");
        System.out.println("2. Show GoldFish");
        System.out.println("3. Show SimpleFish");
        System.out.println("4. Show All");

        int choice = scanner.nextInt();

        try (Connection conn = DBConnector.connect()) {

            if (choice == 1 || choice == 4) {
                System.out.println("\nClownFish:");
                String sql = """
                SELECT Animal.Age, AquariumFish.FishID, AquariumFish.Length, AquariumFish.Sign, AquariumFish.ColorArray,
                       AquariumFish.Happiness, ClownFish.LIFE_SPAN
                FROM ClownFish
                JOIN AquariumFish ON ClownFish.ClownFishID = AquariumFish.FishID
                JOIN Animal ON AquariumFish.FishID = Animal.AnimalID
                ORDER BY AquariumFish.FishID
            """;

                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("There are no ClownFish in the aquarium.");
                    } else {
                        while (rs.next()) {
                            int id = rs.getInt("FishID");
                            int age = rs.getInt("Age");
                            float length = rs.getFloat("Length");
                            String sign = rs.getString("Sign");
                            String color = rs.getString("ColorArray");
                            int happiness = rs.getInt("Happiness");
                            int lifeSpan = rs.getInt("LIFE_SPAN");

                            System.out.println("ID: " + id + ", Age: " + age + ", Length: " + length +
                                    ", Sign: " + sign + ", ColorArray: " + color + ", Happiness: " + happiness +
                                    ", LIFE_SPAN: " + lifeSpan);
                        }
                    }
                }
            }

            if (choice == 2 || choice == 4) {
                System.out.println("\nGoldFish:");
                String sql = """
                SELECT Animal.Age, AquariumFish.FishID, AquariumFish.Length, AquariumFish.Sign, AquariumFish.ColorArray,
                       AquariumFish.Happiness, GoldFish.LIFE_SPAN
                FROM GoldFish
                JOIN AquariumFish ON GoldFish.GoldFishID = AquariumFish.FishID
                JOIN Animal ON AquariumFish.FishID = Animal.AnimalID
                ORDER BY AquariumFish.FishID
            """;

                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("There are no GoldFish in the aquarium.");
                    } else {
                        while (rs.next()) {
                            int id = rs.getInt("FishID");
                            int age = rs.getInt("Age");
                            float length = rs.getFloat("Length");
                            String sign = rs.getString("Sign");
                            String color = rs.getString("ColorArray");
                            int happiness = rs.getInt("Happiness");
                            int lifeSpan = rs.getInt("LIFE_SPAN");

                            System.out.println("ID: " + id + ", Age: " + age + ", Length: " + length +
                                    ", Sign: " + sign + ", ColorArray: " + color + ", Happiness: " + happiness +
                                    ", LIFE_SPAN: " + lifeSpan);
                        }
                    }
                }
            }

            if (choice == 3 || choice == 4) {
                System.out.println("\nSimpleFish:");
                String sql = """
                SELECT Animal.Age, AquariumFish.FishID, AquariumFish.Length, AquariumFish.Sign, AquariumFish.ColorArray,
                       AquariumFish.Happiness, SimpleFish.LIFE_SPAN
                FROM SimpleFish
                JOIN AquariumFish ON SimpleFish.SimpleFishID = AquariumFish.FishID
                JOIN Animal ON AquariumFish.FishID = Animal.AnimalID
                ORDER BY AquariumFish.FishID
            """;

                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("There are no SimpleFish in the aquarium.");
                    } else {
                        while (rs.next()) {
                            int id = rs.getInt("FishID");
                            int age = rs.getInt("Age");
                            float length = rs.getFloat("Length");
                            String sign = rs.getString("Sign");
                            String color = rs.getString("ColorArray");
                            int happiness = rs.getInt("Happiness");
                            int lifeSpan = rs.getInt("LIFE_SPAN");

                            System.out.println("ID: " + id + ", Age: " + age + ", Length: " + length +
                                    ", Sign: " + sign + ", ColorArray: " + color + ", Happiness: " + happiness +
                                    ", LIFE_SPAN: " + lifeSpan);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error fetching aquarium fish: " + e.getMessage());
        }
    }

    public static void FeedTheAnimalsFromDB() {
        try (Connection conn = DBConnector.connect()) {

            System.out.println("The animals are being fed.");

            // 1. Update happiness of Penguins
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("UPDATE Penguin SET Happiness = 100");
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Penguin");
                if (rs.next()) {
                    System.out.println("The Penguins ate fishes for " + rs.getInt(1) + " Penguins");
                }
            }

            // 2. Update happiness of Predators (Lions + Tigers)
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("UPDATE Predator SET Happiness = 100");
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Predator");
                if (rs.next()) {
                    System.out.println("The Lions and Tigers ate meat for " + rs.getInt(1) + " Predators");
                }
            }

            // 3. Update happiness of AquariumFish
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("UPDATE AquariumFish SET Happiness = 100");
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM AquariumFish");
                if (rs.next()) {
                    System.out.println("The fish ate food for " + rs.getInt(1) + " Fish");
                }
            }

            System.out.println("✅ All animals are now happy (Happiness = 100)");

        } catch (SQLException e) {
            System.err.println("Error while feeding the animals: " + e.getMessage());
        }
    }

}
