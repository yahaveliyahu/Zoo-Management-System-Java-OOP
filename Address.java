package yahav_eliyahu_arad_rotem;

public class Address {
    private String city;
    private String street;
    private String number;

    public Address(String city, String street, String number) {
        setCity(city);
        setStreet(street);
        setNumber(number);
    }

    public Address(Address other) {
        setCity(other.city);
        setStreet(other.street);
        setNumber(other.number);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
