package yahav_eliyahu_arad_rotem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

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
}