import java.util.ArrayList;

public class Manager extends Account {


    public Manager() {


    }

    public Manager(String name, String id) {
        super(name, id);

    }


    public void Report() {

        System.out.println("\n========== BANK REPORT ==========");
        System.out.println("\n--- Transaction Summary ---");
        System.out.println("Total deposits: $" + totaldeposits);
        System.out.println("Total withdraws: $" + totalwithdraws);
        System.out.println("Total transactions: " + numberoftransactions);
        
        System.out.println("\n--- Loan Summary ---");
        System.out.println("Pending loans: " + pendingLoans + " (Total: $" + pendingLoanTotal + ")");
        System.out.println("Approved loans: " + approvedLoans + " (Total: $" + approvedLoanTotal + ")");
        System.out.println("Rejected loans: " + rejectedLoans + " (Total: $" + rejectedLoanTotal + ")");
        System.out.println("\n=================================\n");

    }


    public void listofembloyees(Iterable<Employee> emp) {
        int i = 1;
        for (Employee employee : emp) {
            
            System.out.println(i + "- Embloyee Name: " + employee.getName());
            System.out.println("   Embloyee ID: " + employee.getId());
            System.out.println();
            i++;
       }
    }


    public void listofCustomers(ArrayList<Customer> customers) {
        int i = 1;
        for (Customer customer : customers) {
            
            System.out.println(i + "- Customers Name: " + customer.getName());
            System.out.println("   Customers ID: " + customer.getId());
            System.out.println();
            i=i+1;
        }
    }

    public boolean terminateEmployee(ArrayList<Employee> employeeList, int index) {
        if (index >= 0 && index < employeeList.size()) {
            Employee removed = employeeList.remove(index);
            System.out.println("Employee '" + removed.getName() + "' has been terminated successfully.");
            return true;
        } else {
            System.out.println("Invalid employee selection.");
            return false;
        }
    }
}
