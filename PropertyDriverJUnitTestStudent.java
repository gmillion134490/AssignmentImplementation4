/*
 * Class: CMSC203 CRN 23011
 * Instructor: Huseyin Aygun
 * Description: These tests check that the PropertyDriver class works.
 * Due: 10/27/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 *   Print your Name here: Gabriela Million
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyDriverJUnitTestStudent {

    @Test
    public void testCreateCompany() {
        ManagementCompany company = PropertyDriver.createCompany();
        assertEquals("Campus Realty", company.getName());
        assertEquals("123-45-6789", company.getTaxId());
        assertEquals(0, company.getPropertyCount());
    }

    @Test
    public void testAddProperties() {
        ManagementCompany company = PropertyDriver.createCompany();
        int index1 = company.addProperty(new Property("Property-1", "Rockville", 3500, "Amanda"));
        int index2 = company.addProperty(new Property("Property-2", "Gaithersburg", 2500, "Lucy"));
        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(6000, company.totalRent(), 0.001);
    }

    @Test
    public void testCompanyFull() {
        ManagementCompany company = PropertyDriver.createCompany();
        for (int i = 0; i < 5; i++) {
            company.addProperty(new Property("P" + i, "City", 1000, "Dan"));
        }
        assertEquals(-1, company.addProperty(new Property("Extra", "City", 1000, "Dan")));
    }

    @Test
    public void testMakeCopy() {
        ManagementCompany company = PropertyDriver.createCompany();
        company.addProperty(new Property("Property-1", "Rockville", 3500, "Amanda"));
        ManagementCompany copy = PropertyDriver.makeCopy(company);
        assertEquals("Campus Realty", copy.getName());
        assertEquals(1, copy.getPropertyCount());
        assertEquals(3500, copy.totalRent(), 0.001);
    }

    @Test
    public void testCopyIsADifferentObject() {
        ManagementCompany company = PropertyDriver.createCompany();
        company.addProperty(new Property("Property-1", "Rockville", 3500, "Amanda"));
        ManagementCompany copy = PropertyDriver.makeCopy(company);
        assertNotSame(company, copy);
        assertNotSame(company.getProperty(0), copy.getProperty(0));
    }
}
