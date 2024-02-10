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

public class Main {
    public static void main(String[] args){
        try {
            for (int i = 0; i < 5; i++){ // prompts user 5 times
                String empName = JOptionPane.showInputDialog("Please enter the Employee's Name: ");
                int empID = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID: "));
                int grossSalary = Integer.parseInt(JOptionPane.showInputDialog("Enter gross Salary: " ));
                double annualBonus = Double.parseDouble(JOptionPane.showInputDialog("Enter annual bonus:"));

                // Creates the employee objects and returns data
                Employee emp = new Employee(empName, empID, grossSalary, annualBonus);
                JOptionPane.showMessageDialog(null, "Employee " + (i + 1) + " created: ");
                emp.displayEmpData();
                emp.showGrossPayOut();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Please enter a valid digit format.");
        }

        } catch (faultyComputationError e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
            
            
    