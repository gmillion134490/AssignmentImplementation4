/*
 * Class: CMSC203 CRN 23011
 * Instructor: Huseyin Aygun
 * Description: This class holds the info for one rental property.
 * Due: 10/27/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 *   Print your Name here: Gabriela Million
 */

public class Property {

    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    // makes an empty property
    public Property() {
        propertyName = "";
        city = "";
        rentAmount = 0;
        owner = "";
    }

    // makes a property with the info we give it
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    // makes a copy of another property
    public Property(Property other) {
        propertyName = other.propertyName;
        city = other.city;
        rentAmount = other.rentAmount;
        owner = other.owner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    // gives the property as words
    // %.2f shows the rent with 2 numbers after the dot
    public String toString() {
        return propertyName + ", " + city + ", Rent: $"
                + String.format("%.2f", rentAmount) + ", Owner: " + owner;
    }
}
