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




    }

