/*
 * Class: CMSC203 CRN 23011
 * Instructor: Huseyin Aygun
 * Description: These tests check that the Property class works.
 * Due: 10/27/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 *   Print your Name here: Gabriela Million
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyJUnitTestStudent {

    private Property property;

    // runs before each test
    @BeforeEach
    public void setUp() {
        property = new Property("Sunset Villa", "Rockville", 1500.00, "Amanda");
    }

    @Test
    public void testDefaultConstructor() {
        Property p = new Property();
        assertEquals("", p.getPropertyName());
        assertEquals(0.0, p.getRentAmount(), 0.001);
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals("Sunset Villa", property.getPropertyName());
        assertEquals("Rockville", property.getCity());
        assertEquals(1500.00, property.getRentAmount(), 0.001);
        assertEquals("Amanda", property.getOwner());
    }

    @Test
    public void testCopyConstructor() {
        Property copy = new Property(property);
        assertEquals("Sunset Villa", copy.getPropertyName());
        assertEquals("Rockville", copy.getCity());
        assertEquals(1500.00, copy.getRentAmount(), 0.001);
        assertEquals("Amanda", copy.getOwner());
        assertNotSame(property, copy);
    }

    @Test
    public void testSetters() {
        property.setPropertyName("Moon House");
        property.setCity("Bethesda");
        property.setRentAmount(2000);
        property.setOwner("Lucy");
        assertEquals("Moon House", property.getPropertyName());
        assertEquals("Bethesda", property.getCity());
        assertEquals(2000, property.getRentAmount(), 0.001);
        assertEquals("Lucy", property.getOwner());
    }

    @Test
    public void testToString() {
        String expected = "Sunset Villa, Rockville, Rent: $1500.00, Owner: Amanda";
        assertEquals(expected, property.toString());
    }
}
