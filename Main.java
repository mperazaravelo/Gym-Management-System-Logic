/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  January 24, 2025
  Main.java
  Class that implements the other classes, objects, and methods
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //creating the objects and variables
        GymManagementSystem gms = new GymManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice =-1;

        //do-while loop that contains the switch statement
        do {
            //Displaying title, patrons and menu
            System.out.println("\nGym Management System");
            System.out.println("****************************");
            gms.displayMenu();
            // Validate input to prevent InputMismatchException
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                continue; // Restart loop to ask for input again
            }

            //beginning of the switch statement
            switch (choice) {
                //Add employees from file
                case 1:
                    gms.displayEmployees();
                    break;
                case 2:
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();
                    gms.newEmployeeFromFile(filePath);
                    break;
                //Add a patron manually
                case 3:
                    gms.newEmployeeManually(scanner);
                    break;
                //Remove an employee by ID
                case 4:
                    try {
                        System.out.print("Enter ID to remove: ");
                        int id = scanner.nextInt();
                        gms.removeEmployeeById(id);
                    }catch (InputMismatchException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                //update employee fields
                case 5:
                    try {

                        //Prompt the user to enter Id
                        System.out.println("Please enter the ID of the record you wish to update: ");
                        int recordID = scanner.nextInt();

                        //validate recordID
                        if (recordID < 1 || recordID > 9999999) {
                            throw new InvalidIDRangeException("The ID number must be between 1 and 9999999. ");
                        }
                        //consume new line character
                        scanner.nextLine();

                        //Prompt the user to enter name
                        System.out.println("Please enter the name of the employee (if name is unchanged, enter the current name): ");
                        String newName = scanner.nextLine();

                        //Prompt the user to enter last name
                        System.out.println("Please enter the last name of the employee (if last name is unchanged, enter the current last name): ");
                        String newLastName = scanner.nextLine();

                        //Prompt the user to enter job title
                        System.out.println("Please enter the new job title of the employee (if job title is unchanged, enter the current job title): ");
                        String newJobTitle = scanner.nextLine();

                        //Prompt the user to enter hourly wage
                        System.out.println("Please enter the new hourly (if hourly wage is unchanged, enter the current wage): ");
                        double newHourlyWage = scanner.nextDouble();

                        //validate newHourlyWage
                        if (newHourlyWage < 12.00 || newHourlyWage > 40.00) {
                            throw new InvalidHourlyWageException("The Hourly Wage must be between $12.00 and $40.00");
                        }
                        //consume new line character
                        scanner.nextLine();

                        //Prompt the user to enter date
                        System.out.println("Please enter the new date in format YYYY-MM-DD (if date is unchanged, enter the current date): ");
                        String newDate = scanner.nextLine();

                        //validate newDate
                        if (!newDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                            throw new InvalidDateException("The date must be formatted as YYYY-MM-DD");
                        }
                       //call the updateRecord method
                        gms.updateRecord(recordID, newName, newLastName, newJobTitle, newHourlyWage, newDate);

                    }catch (InputMismatchException | InvalidIDRangeException | InvalidHourlyWageException | InvalidDateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                //Display all employees
                case 6:
                    double avg = gms.displayAvgWage();
                    if (avg!=-1) {
                        System.out.println("The average wage is " + String.format("%.2f", avg));
                    }
                    else{
                        System.out.println("There are no employees in the system. ");
                    }
                    break;
                //exit
                case 7:
                    System.out.println("Exiting the system");
                    break;
                //Invalid choice
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        //closing the scanner
        scanner.close();
    }
}
