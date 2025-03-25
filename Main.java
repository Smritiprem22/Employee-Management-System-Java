import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        manager.loadFromFile();
        int choice;

        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Search by Name");
            System.out.println("7. Search by Department");
            System.out.println("8. Add Performance Review");
            System.out.println("9. View Performance Review");
            System.out.println("10. Department Summary Report");
            System.out.println("11. Save to File");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    manager.addEmployee(new Employee(id, name, dept, salary));
                    break;

                case 2:
                    manager.viewAll();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();
                    Employee e = manager.getEmployeeById(sid);
                    System.out.println((e != null) ? e : "Not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String nname = sc.nextLine();
                    System.out.print("New Dept: ");
                    String ndept = sc.nextLine();
                    System.out.print("New Salary: ");
                    double nsalary = sc.nextDouble();
                    manager.updateEmployee(uid, nname, ndept, nsalary);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    manager.deleteEmployee(did);
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String sname = sc.nextLine();
                    manager.searchByName(sname);
                    break;

                case 7:
                    sc.nextLine();
                    System.out.print("Enter Department: ");
                    String sdept = sc.nextLine();
                    manager.searchByDepartment(sdept);
                    break;

                case 8:
                    System.out.print("Enter Employee ID: ");
                    int rid = sc.nextInt();
                    System.out.print("Rating (1-5): ");
                    int rating = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Feedback: ");
                    String feedback = sc.nextLine();
                    manager.addPerformanceReview(rid, rating, feedback);
                    break;

                case 9:
                    System.out.print("Enter Employee ID: ");
                    int vid = sc.nextInt();
                    manager.viewReview(vid);
                    break;

                case 10:
                    manager.departmentSummary();
                    break;

                case 11:
                    manager.saveToFile();
                    break;

                case 0:
                    System.out.println("Exiting. Goodbye!");
                    manager.saveToFile();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
