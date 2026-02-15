public class Customer extends Account{
    private double balance = 0;
    Boolean active = true;
    private double pendingLoanAmount = 0;
    private boolean hasLoanRequest = false;
    private double approvedLoan = 0;

    public Customer(String name, String id){
        super(name,id);
    }

    // Loan getters and setters
    public double getPendingLoanAmount() {
        return pendingLoanAmount;
    }

    public boolean hasLoanRequest() {
        return hasLoanRequest;
    }

    public double getApprovedLoan() {
        return approvedLoan;
    }

    public void requestLoan(double amount) {
        if (!active) {
            System.out.println("Error, Account is not active");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Loan amount must be positive");
            return;
        }
        if (hasLoanRequest) {
            System.out.println("You already have a pending loan request of $" + pendingLoanAmount);
            return;
        }
        pendingLoanAmount = amount;
        hasLoanRequest = true;
        pendingLoans++;
        pendingLoanTotal += amount;
        System.out.println("Loan request of $" + amount + " submitted successfully. Waiting for approval.");
    }

    public void approveLoan() {
        if (hasLoanRequest) {
            approvedLoans++;
            approvedLoanTotal += pendingLoanAmount;
            pendingLoans--;
            pendingLoanTotal -= pendingLoanAmount;
            approvedLoan += pendingLoanAmount;
            balance += pendingLoanAmount;
            System.out.println("Loan of $" + pendingLoanAmount + " approved and added to balance.");
            pendingLoanAmount = 0;
            hasLoanRequest = false;
            numberoftransactions++;
            totaldeposits += approvedLoan;
        } else {
            System.out.println("No pending loan request for this customer.");
        }
    }

    public void rejectLoan() {
        if (hasLoanRequest) {
            rejectedLoans++;
            rejectedLoanTotal += pendingLoanAmount;
            pendingLoans--;
            pendingLoanTotal -= pendingLoanAmount;
            System.out.println("Loan request of $" + pendingLoanAmount + " has been rejected.");
            pendingLoanAmount = 0;
            hasLoanRequest = false;
        } else {
            System.out.println("No pending loan request for this customer.");
        }
    }

    public void transfer(Customer recipient, double amount) {
        if (!active) {
            System.out.println("Error, Your account is not active");
            return;
        }
        if (!recipient.active) {
            System.out.println("Error, Recipient's account is not active");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Transfer amount must be positive");
            return;
        }
        if (amount > balance) {
            System.out.println("Transaction cancelled: Insufficient balance");
            return;
        }
        this.balance -= amount;
        recipient.balance += amount;
        numberoftransactions += 2;
        totalwithdraws += amount;
        totaldeposits += amount;
        System.out.println("Transfer of $" + amount + " to " + recipient.getName() + " completed successfully.");
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getbalance(){
        return this.balance;
    }


    public void withdraw(double amount){
        if(active){
            if(amount<=this.balance){
                this.balance = this.balance - Math.abs(amount);
                numberoftransactions++;
                totalwithdraws = totalwithdraws + amount;
                System.out.println("Withdraw performed successfully");
            }
            else{
                System.out.println("Transaction has been cancelled, you have exceded your balance");
            }
        }
        else{
            System.out.println("Error, Account is not active");
        }
    }


    public void deposit(double amount){
        if(active){
            if(amount>=0){
                this.balance = this.balance + amount;
                numberoftransactions++;
                totaldeposits = totaldeposits + amount;
                System.out.println("Deposit performed successfully");
            }
            else{
                System.out.println("Transaction has been cancelled, you cannot deposit a negative value");

            }
        }
        else{
            System.out.println("Error, Account is not active");
        }
    }
}
