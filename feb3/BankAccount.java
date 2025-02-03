package feb3;

public class  BankAccount {

    static String bankName;
    String accountHolderName;
    final int  accountNumber;
    static int NoOfAccount=0;
     
    static int getTotalAccounts(){
        return NoOfAccount;
    }
    public BankAccount(String bankName,String accountHolderName,int accountNumber){
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        this.bankName = bankName;

    }

    public static void main(String[] args) {
        BankAccount  customer = new BankAccount("SBI", "Sachin Sharma", 31941);
       if(customer instanceof BankAccount){
            customer.NoOfAccount++;
            System.out.println(customer.accountHolderName);
            System.out.println(customer.accountNumber);
            System.out.println(customer.bankName);
            System.out.println(customer.getTotalAccounts());
       }
       else{
        System.out.println("This object is not part of BankAccount Class");
       }
    }
}