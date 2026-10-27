/*
 * Class: CMSC203 CRN 23011
 * Instructor: Huseyin Aygun
 * Description: This is the main program. It shows a menu and runs the company.
 * Due: 10/27/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 *   Print your Name here: Gabriela Million
 */

import java.util.Scanner;

public class PropertyDriver {

    // makes the company
    public static ManagementCompany createCompany() {
        return new ManagementCompany("Campus Realty", "123-45-6789");
    }

    // makes a copy of a company
    public static ManagementCompany makeCopy(ManagementCompany company) {
        return new ManagementCompany(company);
    }

    // shows the menu
    public static void printMenu() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("   Assignment 4: Property Manager   ");
        System.out.println("====================================");
        System.out.println("1 - Add Property");
        System.out.println("2 - Display All Properties");
        System.out.println("3 - Show Total Rent");
        System.out.println("4 - Exit");
        System.out.println();
        System.out.print("Enter choice (1-4): ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManagementCompany company = createCompany();
        int choice = 0;

        // keep showing the menu until the user picks 4
        while (choice != 4) {
            printMenu();
            choice = input.nextInt();
            input.nextLine();   // clears the Enter key

            if (choice == 1) {
                System.out.print("Enter property name: ");
                String name = input.nextLine();
                System.out.print("Enter city: ");
                String city = input.nextLine();
                System.out.print("Enter monthly rent: ");
                double rent = input.nextDouble();
                input.nextLine();   // clears the Enter key
                System.out.print("Enter owner name: ");
                String owner = input.nextLine();

                Property p = new Property(name, city, rent, owner);
                int index = company.addProperty(p);
                if (index == -1) {
                    System.out.println("Company is full. Property was not added.");
                } else {
                    System.out.println("Property added at index " + index + ".");
                }
            } else if (choice == 2) {
                System.out.println(company);
            } else if (choice == 3) {
                System.out.println("Total rent: $" + String.format("%.2f", company.totalRent()));
            } else if (choice == 4) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }

        // show that the copy works
        ManagementCompany copy = makeCopy(company);
        System.out.println();
        System.out.println("Copy constructor demo:");
        System.out.println("Copy has " + copy.getPropertyCount() + " properties, total rent: $"
                + String.format("%.2f", copy.totalRent()));

        System.out.println();
        System.out.println("Programmer: Gabriela Million");
        input.close();
    }
}
