/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  January 24, 2025
  Main.java
  Class that implements the other classes, objects, and methods
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //creating the objects and variables
        GymManagementSystem gms = new GymManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        //do-while loop that contains the switch statement
        do {
            //Displaying title, patrons and menu
            System.out.println("\nGym Management System");
            System.out.println("****************************");
            gms.displayEmployees();
            gms.displayMenu();

            choice = scanner.nextInt();
            // Consume newline character
            scanner.nextLine();

            //beginning of the switch statement
            switch (choice) {
                //Add employees from file
                case 1:
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();
                    gms.newEmployeeFromFile(filePath);
                    break;
                //Add a patron manually
                case 2:
                    gms.newEmployeeManually(scanner);
                    break;
                //Remove an employee by ID
                case 3:
                    System.out.print("Enter ID to remove: ");
                    int id = scanner.nextInt();
                    gms.removeEmployeeById(id);
                    break;
                //update employee fields
                case 4:
                    gms.updateRecord();
                    break;
                //Display all employees
                case 5:
                    double avg = gms.displayAvgWage();
                    if (avg!=-1) {
                        System.out.println("The average wage is " + String.format("%.2f", avg));
                    }
                    else{
                        System.out.println("There are no employees in the system. ");
                    }
                    break;
                //exit
                case 6:
                    System.out.println("Exiting the system");
                    break;
                //Invalid choice
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        //closing the scanner
        scanner.close();
    }
}