import javax.swing.JOptionPane;

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

        } catch (faultyComputationError e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    
    }
}
           