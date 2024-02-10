class Employee {
    // Declare instance variables to store employee information
    private String employeeName;          
    private int employeeIdNumber;         
    private String employeeDepartment;    
    private String employeePosition;      

    // Constructors to create Employee instances
    public Employee(String name, int idNumber, String department, String position) {
       
        // Set the employee's details using provided values
        setEmployeeName(name);
        setEmployeeIdNumber(idNumber);
        setEmployeeDepartment(department);
        setEmployeePosition(position);
    }

    // Constructor with only name and ID
    public Employee(String name, int idNumber) {
        setEmployeeName(name);
        setEmployeeIdNumber(idNumber);
        setEmployeeDepartment("");
        setEmployeePosition("");
    }

    // No-arg constructor with default values
    public Employee() {
        setEmployeeName("");
        setEmployeeIdNumber(0);
        setEmployeeDepartment("");
        setEmployeePosition("");
    }

    // Accessor methods to get employee details
    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeIdNumber() {
        return employeeIdNumber;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    // Mutator methods to set employee details
    public void setEmployeeName(String name) {
        employeeName = name;
    }

    public void setEmployeeIdNumber(int idNumber) {
        employeeIdNumber = idNumber;
    }

    public void setEmployeeDepartment(String department) {
        employeeDepartment = department;
    }

    public void setEmployeePosition(String position) {
        employeePosition = position;
    }
}

