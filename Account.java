public class Account {
    String id = "";
    String name = "";
    static public double totaldeposits = 0;
    static public double totalwithdraws = 0;
    static public int numberoftransactions = 0;
    static public int pendingLoans = 0;
    static public double pendingLoanTotal = 0;
    static public int approvedLoans = 0;
    static public double approvedLoanTotal = 0;
    static public int rejectedLoans = 0;
    static public double rejectedLoanTotal = 0;

    public Account() {

        this.name = "";
        this.id = "";


    }

    public Account(String newname, String newId) {

        this.name = newname;
        this.id = newId;

    }

    public void setId(String id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
