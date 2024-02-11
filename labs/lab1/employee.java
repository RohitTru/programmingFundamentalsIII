import javax.swing.JOptionPane;

// This is the exception that handles any errors derived from faulty salary or bonus computations
class faultyComputationError extends Exception {
    public faultyComputationError(String errorMessage) {
        super(errorMessage);
    }
}


class Employee {
    // Initialized fields
    private String empName;
    private int empID;
    private int grossSalary;
    private double annualBonus;

    // Errors (exceptions conditional's)
    public Employee(String empName, int empID, int grossSalary, double annualBonus) throws faultyComputationError {
        if (grossSalary <= 0){
            throw new faultyComputationError("Salary can not be negative");
        }

        if (annualBonus <= 0) {
            throw new faultyComputationError(("Bonus can not be negative"));
        }
    } 

    // The function to display stored employee data
    public void displayEmpData(){
        JOptionPane.showMessageDialog(null, "Employee Name: " + empName + ",Employee ID: " + empID + ", Gross Salary: $" + grossSalary);
        JOptionPane.showMessageDialog(null,"Monthly Salary: $" + (grossSalary / 12));

    }

    // Gross salary + annual bonus
    public void showGrossPayOut(){
        JOptionPane.showMessageDialog(null, "Gross salary: $" + grossSalary + ", Annual Bonus: $" + annualBonus);
        
    }

}

 
            
    