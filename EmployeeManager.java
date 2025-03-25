import java.io.*;
import java.util.*;

public class EmployeeManager {
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private Map<Integer, PerformanceReview> reviewMap = new HashMap<>();

    // Add employee
    public void addEmployee(Employee emp) {
        employeeMap.put(emp.getId(), emp);
        System.out.println("Employee added!");
    }

    // View all employees
    public void viewAll() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee emp : employeeMap.values()) {
            System.out.println(emp);
        }
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        return employeeMap.get(id);
    }

    // Delete employee
    public void deleteEmployee(int id) {
        if (employeeMap.remove(id) != null)
            System.out.println("Employee removed.");
        else
            System.out.println("Employee not found.");
    }

    // Update employee
    public void updateEmployee(int id, String newName, String newDept, double newSalary) {
        Employee emp = employeeMap.get(id);
        if (emp != null) {
            emp.setName(newName);
            emp.setDepartment(newDept);
            emp.setSalary(newSalary);
            System.out.println("Employee updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Search by name
    public void searchByName(String name) {
        boolean found = false;
        for (Employee emp : employeeMap.values()) {
            if (emp.getName().equalsIgnoreCase(name)) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) System.out.println("No employee found with that name.");
    }

    // Search by department
    public void searchByDepartment(String dept) {
        boolean found = false;
        for (Employee emp : employeeMap.values()) {
            if (emp.getDepartment().equalsIgnoreCase(dept)) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) System.out.println("No employees in this department.");
    }

    // Add review
    public void addPerformanceReview(int empId, int rating, String feedback) {
        if (employeeMap.containsKey(empId)) {
            reviewMap.put(empId, new PerformanceReview(empId, rating, feedback));
            System.out.println("Review added.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // View review
    public void viewReview(int empId) {
        if (reviewMap.containsKey(empId)) {
            System.out.println("Review for Employee ID " + empId + ":");
            System.out.println(reviewMap.get(empId));
        } else {
            System.out.println("No review available.");
        }
    }

    // Department summary
    public void departmentSummary() {
        Map<String, Integer> deptCount = new HashMap<>();
        for (Employee emp : employeeMap.values()) {
            deptCount.put(emp.getDepartment(), deptCount.getOrDefault(emp.getDepartment(), 0) + 1);
        }

        System.out.println("--- Department Summary ---");
        for (String dept : deptCount.keySet()) {
            System.out.println(dept + ": " + deptCount.get(dept) + " employee(s)");
        }
    }

    // Save to file
    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            out.writeObject(employeeMap);
            System.out.println("Data saved.");
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load from file
    public void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            employeeMap = (HashMap<Integer, Employee>) in.readObject();
            System.out.println("Data loaded.");
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
