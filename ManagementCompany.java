/*
 * Class: CMSC203 CRN 23011
 * Instructor: Huseyin Aygun
 * Description: This class holds a list of properties and adds up their rent.
 * Due: 10/27/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 *   Print your Name here: Gabriela Million
 */

public class ManagementCompany {

    // the most properties we can have
    public static final int MAX_PROPERTIES = 5;

    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;

    // makes a company with an empty list
    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        properties = new Property[MAX_PROPERTIES];
        propertyCount = 0;
    }

    // makes a copy of another company
    // each property gets copied too, so they are not shared
    public ManagementCompany(ManagementCompany other) {
        name = other.name;
        taxId = other.taxId;
        properties = new Property[MAX_PROPERTIES];
        propertyCount = other.propertyCount;
        for (int i = 0; i < other.propertyCount; i++) {
            properties[i] = new Property(other.properties[i]);
        }
    }

    // adds a property and gives back its spot number
    // gives back -1 if the list is full
    public int addProperty(Property p) {
        if (propertyCount == MAX_PROPERTIES) {
            return -1;
        }
        properties[propertyCount] = new Property(p);
        propertyCount++;
        return propertyCount - 1;
    }

    // adds up all the rent
    public double totalRent() {
        double total = 0;
        for (int i = 0; i < propertyCount; i++) {
            total = total + properties[i].getRentAmount();
        }
        return total;
    }

    public int getPropertyCount() {
        return propertyCount;
    }

    // gives back the property at a spot number
    public Property getProperty(int index) {
        if (index < 0 || index >= propertyCount) {
            return null;
        }
        return properties[index];
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    // gives the company and all its properties as words
    public String toString() {
        String result = "Management Company: " + name + " (Tax ID: " + taxId + ")\n";
        result = result + "Properties:\n";
        for (int i = 0; i < propertyCount; i++) {
            result = result + "  " + i + ": " + properties[i] + "\n";
        }
        result = result + "Total Rent: $" + String.format("%.2f", totalRent());
        return result;
    }
}
