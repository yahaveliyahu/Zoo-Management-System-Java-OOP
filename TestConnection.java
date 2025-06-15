package yahav_eliyahu_arad_rotem;

public class TestConnection {
    public static void main(String[] args) {
        if (DBConnector.connect() != null) {
            System.out.println("✅ Connected to PostgreSQL!");
        } else {
            System.out.println("❌ Connection failed.");
        }
    }
}

