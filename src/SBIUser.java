import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{

    //attributes
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private double rateOfInterest;

    public SBIUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        //Bank is initialising
        this.rateOfInterest = 6.5;

        //UUID(Universally unique identifier) -> it will generate random 16 digit Hexa decimal number
        this.accountNo = String.valueOf(UUID.randomUUID()); //String.valueOf() because we have
        // account number return type as String and .randomUUID() is in int datatype ...
        // to convert in into string we use String.valueOf()
    }

    // Getters and setters of all the SBIUser class data members
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override //annotation
    public double checkBalance() {
        return this.balance;
    }

    @Override
    public String addMoney(int amount) {
        balance = balance+amount;
        return "Your new Balance is : "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword , password)){
            if(amount > balance ){
                return "Sorry Insufficient money";
            }
            else{
                     balance-=amount;
                     return "Congratulations ! Here's your money";
            }
        }else{
            return "Wrong password !";
        }
    }

    @Override
    public double caculateInterest(int years) {
      return (balance*years*rateOfInterest)/100; //formula of Simple Interest SI
    }
}
