/*
 * Class: CMSC203 CRN 23011
 * Instructor: Huseyin Aygun
 * Description: These tests check that the ManagementCompany class works.
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

public class ManagementCompanyJUnitTestStudent {

    private ManagementCompany mc;

    // runs before each test
    @BeforeEach
    public void setUp() {
        mc = new ManagementCompany("Campus Realty", "123-45-6789");
    }

    @Test
    public void testConstructor() {
        assertEquals("Campus Realty", mc.getName());
        assertEquals("123-45-6789", mc.getTaxId());
        assertEquals(0, mc.getPropertyCount());
    }

    @Test
    public void testAddPropertyAndTotalRent() {
        int index1 = mc.addProperty(new Property("Apt 1", "Rockville", 1200, "Praxton"));
        int index2 = mc.addProperty(new Property("Apt 2", "Rockville", 1500, "Dan"));
        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(2, mc.getPropertyCount());
        assertEquals(2700, mc.totalRent(), 0.001);
    }

    @Test
    public void testAddPropertyWhenFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTIES; i++) {
            mc.addProperty(new Property("P" + i, "City", 1000, "Amanda"));
        }
        int result = mc.addProperty(new Property("Extra", "City", 2000, "Lucy"));
        assertEquals(-1, result);
        assertEquals(5, mc.getPropertyCount());
    }

    @Test
    public void testCopyConstructor() {
        mc.addProperty(new Property("Apt 1", "Rockville", 1200, "Praxton"));
        mc.addProperty(new Property("Apt 2", "Rockville", 1500, "Dan"));
        ManagementCompany mc2 = new ManagementCompany(mc);
        assertEquals("Campus Realty", mc2.getName());
        assertEquals(2, mc2.getPropertyCount());
        assertEquals(2700, mc2.totalRent(), 0.001);
        assertNotSame(mc.getProperty(0), mc2.getProperty(0));
    }

    @Test
    public void testToString() {
        mc.addProperty(new Property("Property-1", "Rockville", 3500, "Amanda"));
        String expected = "Management Company: Campus Realty (Tax ID: 123-45-6789)\n"
                + "Properties:\n"
                + "  0: Property-1, Rockville, Rent: $3500.00, Owner: Amanda\n"
                + "Total Rent: $3500.00";
        assertEquals(expected, mc.toString());
    }
}
