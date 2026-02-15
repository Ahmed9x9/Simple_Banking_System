import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    static ArrayList<Manager> managerList = new ArrayList<>();
    static ArrayList<Customer> customerList = new ArrayList<>();
    static ArrayList<Employee> employeeList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("***Bank Software***");
        boolean exit = false;
        int actionChoice = 0;
        while (!exit) {
            try {
                showActionChoices();
                actionChoice = input.nextInt();
                switch (actionChoice) {
                    case 1:
                        createAccount();
                        break;

                    case 2:
                        accountLogin();
                        break;

                    case 3:
                        exit = true;
                        System.out.print("Program Ended");
                        break;

                    default:
                        System.out.println("Error: Please choose a valid option (1-3)");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                input.nextLine(); // Clear the invalid input
            }
        }
    }

    static void showActionChoices() {
        System.out.print("""
                Enter the number of the action you want to make:\s
                 1- Create an account
                 2- Use an existing account
                 3- Exit

                 Chosen Number:\s""");
    }

    static void createAccount() {
        int accountChoice = 0;
        while (accountChoice != 4) {
            try {
                System.out.print("what kind of account do you want to create? (choose a number): ");
                showAccountsChoices();
                accountChoice = input.nextInt();
                switch (accountChoice) {
                    case 1:
                        createManagerAccount();
                        break;

                    case 2:
                        createEmployeeAccount();
                        break;

                    case 3:
                        createCustomerAccount();
                        break;

                    case 4:
                        break;

                    default:
                        System.out.println("Error: Please choose a valid option (1-4)");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                input.nextLine();
            }
        }
    }

    //Make sure there is an account to sign in to
    static boolean managercreated = false;

    static void createManagerAccount() {
        System.out.println("Enter the Account Name:");
        String accountName = input.next();

        // Check if the manager account exists
        boolean accountExists = false;
        
        //Manager selectedManager = null;
        for (Manager manager : managerList) {
            if (manager.getName().equals(accountName)) {
                accountExists = true;
                managercreated = true;
                break;
            }
        }

        if (accountExists) {
            System.out.println("Manager already exists with the given account name: " + accountName);
        } else {
            System.out.println("Enter the Account ID:");
            String accountId = input.next();

            // Create a new manager
            Manager newManager = new Manager(accountName, accountId);
            managerList.add(newManager);
            System.out.println("Manager account created successfully!");
        }
    }

    //Make sure there is an account to sign in to
    static boolean employeecreated = false;

    static void createEmployeeAccount() {
        System.out.println("Enter the Account Name:");
        String accountName = input.next();

        // Check if the employee account exists
        boolean accountExists = false;
        
        //Manager selectedManager = null;
        for (Employee employee : employeeList) {
            if (employee.getName().equals(accountName)) {
                accountExists = true;
                employeecreated = true;
                break;
            }
        }

        if (accountExists) {
            System.out.println("Employee already exists with the given account name: " + accountName);
        } else {
            System.out.println("Enter the Account ID:");
            String accountId = input.next();

            // Create a new employee
            Employee newEmployee = new Employee(accountName, accountId);
            employeeList.add(newEmployee);
            System.out.println("Employee account created successfully!");
        }
    }

    //Make sure there is an account to sign in to
    static int customercreated = 0;

    static void createCustomerAccount() {
        System.out.println("Enter the Account Name:");
        String accountName = input.next();

        // Check if the customer account exists
        boolean accountExists = false;
        
        //Manager selectedManager = null;
        for (Customer customer : customerList) {
            if (customer.getName().equals(accountName)) {
                accountExists = true;
                customercreated = 1;
                break;
            }
        }

        if (accountExists) {
            System.out.println("Customer already exists with the given account name: " + accountName);
        } else {
            System.out.println("Enter the Account ID:");
            String accountId = input.next();

            // Create a new customer
            Customer newCustomer = new Customer(accountName, accountId);
            customerList.add(newCustomer);
            System.out.println("Customer account created successfully!");
        }
    }

    static void accountLogin() {
        int accountChoice = 0;
        while (accountChoice != 4) {
            try {
                System.out.print("In which account do you want to sign in (Choose a number): ");
                showAccountsChoices();
                accountChoice = input.nextInt();
                switch (accountChoice) {
                    case 1:                  
                         managerLogin();
                        break;

                    case 2:
                         employeeLogin();                    
                        break;

                    case 3:
                         customerLogin();                 
                        break;

                    case 4:
                        break;

                    default:
                        System.out.println("Error: Please choose a valid option (1-4)");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                input.nextLine();
            }
        }
    }

    static void showAccountsChoices() {
        System.out.print("""
                \n1- Manager
                2- Employee
                3- Customer
                4- Back

                Chosen number: """);
    }

    static void managerLogin() {
        if (managerList.isEmpty()) {
            System.out.println("Error: No manager accounts exist. Please create a manager account first.");
            return;
        }
        try {
            System.out.println("Managers Accounts(Choose the number of account): ");
            showManagers();
            System.out.print("\nChosen Number: ");
            int managerChoice = input.nextInt();

            int managerSize = managerList.size();
            if (managerChoice >= 1 && managerChoice <= managerSize) {
                Manager chosenManager = managerList.get(managerChoice - 1);
                managerActions(chosenManager);
            } else {
                System.out.println("Error: Invalid selection. Please choose a number between 1 and " + managerSize);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
            input.nextLine();
        }
    }

    static void showManagers() {
        int i = 1;
        for (Manager manager : managerList) {
            
            System.out.println(i + "- Manager Name: " + manager.getName());
            System.out.println("   Manager ID: " + manager.getId());
            System.out.println();
            i++;
        }
    }

    static void managerActions(Manager chosenManager) {
        int actionChoice = 0;
        while (actionChoice != 5) {
            System.out.println("Which action do you want to make (Choose a number): ");
            showManagerActions();
            actionChoice = input.nextInt();
            switch (actionChoice) {

                case 1:
                    chosenManager.Report();
                    break;

                case 2:
                    if (employeeList.isEmpty()) {
                        System.out.println("No employees to display.");
                    } else {
                        chosenManager.listofembloyees(employeeList);
                    }
                    break;

                case 3:
                    if (customerList.isEmpty()) {
                        System.out.println("No customers to display.");
                    } else {
                        chosenManager.listofCustomers(customerList);
                    }
                    break;

                case 4:
                    // Terminate employee
                    if (employeeList.isEmpty()) {
                        System.out.println("No employees to terminate.");
                        break;
                    }
                    System.out.println("Select the employee to terminate:");
                    showEmployees();
                    System.out.print("Chosen Number: ");
                    int empChoice = input.nextInt();
                    if (empChoice >= 1 && empChoice <= employeeList.size()) {
                        System.out.print("Are you sure you want to terminate this employee? (1-Yes, 2-No): ");
                        int confirm = input.nextInt();
                        if (confirm == 1) {
                            chosenManager.terminateEmployee(employeeList, empChoice - 1);
                        } else {
                            System.out.println("Termination cancelled.");
                        }
                    } else {
                        System.out.println("Error: Invalid selection.");
                    }
                    break;
            }
        }
    }

    static void showManagerActions() {
        System.out.print("""
                1- Print a report
                2- View list of employees
                3- View list of customers
                4- Terminate an employee
                5- Back

                Chosen Number: """);
    }

    static void employeeLogin() {
        if (employeeList.isEmpty()) {
            System.out.println("Error: No employee accounts exist. Please create an employee account first.");
            return;
        }
        try {
            System.out.println("Employees Accounts(Choose the number of account): ");
            showEmployees();

            System.out.println();
            System.out.print("Chosen Number: ");
            int employeeChoice = input.nextInt();

            int employeeSize = employeeList.size();
            if (employeeChoice >= 1 && employeeChoice <= employeeSize) {
                Employee chosenEmployee = employeeList.get(employeeChoice - 1);
                employeeActions(chosenEmployee);
            } else {
                System.out.println("Error: Invalid selection. Please choose a number between 1 and " + employeeSize);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
            input.nextLine();
        }
    }

    static void showEmployees() {
        int i = 1;
        for (Employee employee : employeeList) {
            
            System.out.println(i + "- Employee Name: " + employee.getName());
            System.out.println("   Employee ID: " + employee.getId());
            System.out.println();
            i++;
        }
    }

    static void employeeActions(Employee chosenEmployee) {
        int actionChoice = 0;
        int amount;
        while (actionChoice != 6) {

            System.out.println("Which action do you want to make (Choose a number): ");
            showEmployeeActions();
            actionChoice = input.nextInt();
            
            if (actionChoice == 5) {
                // Handle loan requests separately
                handleLoanRequests(chosenEmployee);
                continue;
            }
            
            if (actionChoice >= 1 && actionChoice <= 4) {
                if (customerList.isEmpty()) {
                    System.out.println("Error: No customer accounts exist.");
                    continue;
                }
                System.out.println("Choose the customer account: ");
                showCustomers();
                System.out.print("Chosen Number: ");
                int customerChoice = input.nextInt();
                
                if (customerChoice < 1 || customerChoice > customerList.size()) {
                    System.out.println("Error: Invalid customer selection.");
                    continue;
                }
                Customer chosenCustomer = customerList.get(customerChoice - 1);
                
                switch (actionChoice) {
                    case 1:
                        chosenEmployee.lockaccount(chosenCustomer);
                        System.out.print("new customer status: " + chosenCustomer.active + " \n");
                        break;

                    case 2:
                        chosenEmployee.unlockaccount(chosenCustomer);
                        System.out.print("new customer status: " + chosenCustomer.active + " \n");
                        break;
                    case 3:
                        System.out.print("Enter the amount you want to deposit: ");
                        amount = input.nextInt();
                        chosenEmployee.depositforcustomer(chosenCustomer, amount);
                        break;
                    case 4:
                        System.out.print("Enter the amount you want to withdraw: ");
                        amount = input.nextInt();
                        chosenEmployee.withdrawforcustomer(chosenCustomer, amount);
                        break;
                }
            }
        }
    }

    static void handleLoanRequests(Employee chosenEmployee) {
        // Find customers with pending loan requests
        ArrayList<Customer> customersWithLoans = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.hasLoanRequest()) {
                customersWithLoans.add(customer);
            }
        }
        
        if (customersWithLoans.isEmpty()) {
            System.out.println("No pending loan requests.");
            return;
        }
        
        System.out.println("\n--- Pending Loan Requests ---");
        int i = 1;
        for (Customer customer : customersWithLoans) {
            System.out.println(i + "- Customer: " + customer.getName() + " (ID: " + customer.getId() + ")");
            System.out.println("   Loan Amount: $" + customer.getPendingLoanAmount());
            System.out.println();
            i++;
        }
        
        System.out.print("Select a loan request to process (0 to go back): ");
        int loanChoice = input.nextInt();
        
        if (loanChoice == 0) {
            return;
        }
        
        if (loanChoice < 1 || loanChoice > customersWithLoans.size()) {
            System.out.println("Error: Invalid selection.");
            return;
        }
        
        Customer selectedCustomer = customersWithLoans.get(loanChoice - 1);
        System.out.println("\nCustomer: " + selectedCustomer.getName());
        System.out.println("Loan Amount: $" + selectedCustomer.getPendingLoanAmount());
        System.out.println("\n1- Approve loan");
        System.out.println("2- Reject loan");
        System.out.println("3- Cancel");
        System.out.print("Chosen Number: ");
        int decision = input.nextInt();
        
        switch (decision) {
            case 1:
                chosenEmployee.approveLoan(selectedCustomer);
                break;
            case 2:
                chosenEmployee.rejectLoan(selectedCustomer);
                break;
            default:
                System.out.println("Action cancelled.");
                break;
        }
    }


    static void showEmployeeActions() {

        System.out.println("1- Lock customer account");
        System.out.println("2- unLock customer account");
        System.out.println("3- Make a deposit for customer");
        System.out.println("4- Make a withdraw for customer");
        System.out.println("5- Loan requests");
        System.out.println("6- Back");
        System.out.println();
        System.out.print("Chosen Number: ");
    }


    static void customerLogin() {
        if (customerList.isEmpty()) {
            System.out.println("Error: No customer accounts exist. Please create a customer account first.");
            return;
        }
        try {
            System.out.println("Customers Accounts(Choose the number of account): ");
            showCustomers();

            System.out.println();
            System.out.print("Chosen Number: ");
            int customerChoice = input.nextInt();

            int customerSize = customerList.size();
            if (customerChoice >= 1 && customerChoice <= customerSize) {
                Customer chosenCustomer = customerList.get(customerChoice - 1);
                customerActions(chosenCustomer);
            } else {
                System.out.println("Error: Invalid selection. Please choose a number between 1 and " + customerSize);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
            input.nextLine();
        }
    }

    static void showCustomers() {
        int i = 1;
        for (Customer customer : customerList) {
            System.out.println(i + "- Customer Name: " + customer.getName());
            System.out.println("   Customer ID: " + customer.getId());
            System.out.println(" Customer status: " + customer.active);
            System.out.println();
            i++;
        }
    }

    static void customerActions(Customer chosenCustomer) {
        int actionChoice = 0;
        int amount;
        while (actionChoice != 6) {
            System.out.println("Which action do you want to make (Choose a number): ");
            showCustomerActions();
            actionChoice = input.nextInt();
            switch (actionChoice) {

                case 1:
                    System.out.print(chosenCustomer.getbalance());
                    System.out.println("$");
                    System.out.println();
                    break;


                case 2:
                    System.out.print("Enter the amount you want to deposit: ");
                    amount = input.nextInt();
                    chosenCustomer.deposit(amount);
                    break;

                case 3:
                    System.out.print("Enter the amount you want to withdraw: ");
                    amount = input.nextInt();
                    chosenCustomer.withdraw(amount);
                    break;

                case 4:
                    // Transfer money
                    if (customerList.size() < 2) {
                        System.out.println("Error: No other customers to transfer to.");
                        break;
                    }
                    System.out.println("Select the recipient customer:");
                    int i = 1;
                    for (Customer customer : customerList) {
                        if (!customer.equals(chosenCustomer)) {
                            System.out.println(i + "- " + customer.getName() + " (ID: " + customer.getId() + ")");
                        }
                        i++;
                    }
                    System.out.print("Chosen Number: ");
                    int recipientChoice = input.nextInt();
                    if (recipientChoice < 1 || recipientChoice > customerList.size()) {
                        System.out.println("Error: Invalid selection.");
                        break;
                    }
                    Customer recipient = customerList.get(recipientChoice - 1);
                    if (recipient.equals(chosenCustomer)) {
                        System.out.println("Error: Cannot transfer to yourself.");
                        break;
                    }
                    System.out.print("Enter the amount to transfer: ");
                    amount = input.nextInt();
                    chosenCustomer.transfer(recipient, amount);
                    break;

                case 5:
                    // Request loan
                    if (chosenCustomer.hasLoanRequest()) {
                        System.out.println("You already have a pending loan request of $" + chosenCustomer.getPendingLoanAmount());
                    } else {
                        System.out.print("Enter the loan amount you want to request: ");
                        amount = input.nextInt();
                        chosenCustomer.requestLoan(amount);
                    }
                    break;

                case 6:
                    // Back
                    break;

                default:
                    System.out.println("Error: Please choose a number from the list");
                    System.out.println();
                    break;

            }
        }
    }

    static void showCustomerActions() {

        System.out.println("1- View balance");
        System.out.println("2- Make a deposit");
        System.out.println("3- Make a withdraw");
        System.out.println("4- Transfer to another customer");
        System.out.println("5- Request a loan");
        System.out.println("6- Back");
        System.out.println();
        System.out.print("Chosen Number: ");
    }


}

