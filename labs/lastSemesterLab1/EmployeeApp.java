public class EmployeeApp {
    public static void main(String[] args) {
        // Create Employee instances with specific details
        Employee employee1 = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
        Employee employee2 = new Employee("Mark Jones", 39119, "IT", "Programmer");
        Employee employee3 = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer");

        // Print header for employee details
        System.out.println("Employee Name          ID Number    Department      Position");
        System.out.println(employee1.getEmployeeName() + "           " + employee1.getEmployeeIdNumber() + "        " + employee1.getEmployeeDepartment() + "      " + employee1.getEmployeePosition());
        System.out.println(employee2.getEmployeeName() + "             " + employee2.getEmployeeIdNumber() + "        " + employee2.getEmployeeDepartment() + "              " + employee2.getEmployeePosition());
        System.out.println(employee3.getEmployeeName() + "             " + employee3.getEmployeeIdNumber() + "        " + employee3.getEmployeeDepartment() + "   " + employee3.getEmployeePosition());
    }

   
}
