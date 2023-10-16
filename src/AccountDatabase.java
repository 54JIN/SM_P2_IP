/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public class AccountDatabase
{
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array

    //search for an account in the array
    private int find(Account account) {
        return 0;
    }

    //increase the capacity by 4
    private void grow() {
        Account[] temp = new Account[accounts.length + 4];
        for(int i = 0; i < accounts.length; i++){
            temp[i] = accounts[i];
        }

        accounts = temp;
    }

    //overload if necessary
    public boolean contains(Account account){
        if(accounts != null){
            for(int i = 0; i < accounts.length; i++)
            {
                if(accounts[i] != null && accounts[i].compareTo(account) == 0)
                {
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean ccContains(Account account){
        if(accounts != null){
            for(int i = 0; i < accounts.length; i++)
            {
                if(accounts[i] != null && accounts[i].getClass() == CollegeChecking.class && accounts[i].holder.equals(account.holder))
                {
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean cContains(Account account){
        if(accounts != null){
            for(int i = 0; i < accounts.length; i++)
            {
                if(accounts[i] != null && accounts[i].getClass() == Checking.class && accounts[i].holder.equals(account.holder))
                {
                    return true;
                }
            }
        }
        
        return false;
    }

    //add a new account
    public boolean open(Account account) {
        if(accounts == null){
            Account[] temp = new Account[4]; 
            temp[0] = account;
            accounts = temp;
            numAcct = accounts.length;
            return true;
        }
        if(contains(account)){
            return false;
        }
        int i = 0;
        while(i < accounts.length){
            if(i == accounts.length-1 && accounts[i] != null){
                grow();
                accounts[i+1] = account;
                numAcct = accounts.length;
                return true;
            }
            else if(accounts[i] == null){
                accounts[i] = account;
                numAcct = accounts.length;
                return true;
            }
            i++;
        }
        return false;
    }

    private void shrink() {
        Account[] temp = new Account[accounts.length - 4];
        
        for(int i = 0; i < temp.length; i++){
            temp[i] = accounts[i];
        }
        accounts = temp;
    }

    private boolean last4(){
        for(int i = accounts.length-4; i < accounts.length; i++){
            if(accounts[i] != null){
                return false;
            }
        }
        return true;
    }

    private void refactor(int j){
        Account[] temp = new Account[accounts.length];
        int accountsI = 0;
        for(int i = 0; i < accounts.length; i++){
            if(i == j){
                accountsI++;
                if(accountsI < accounts.length){
                    temp[i] = accounts[accountsI];
                }
                else{
                    temp[i] = null;
                }
            }
            else{
                if(accountsI < accounts.length){
                    temp[i] = accounts[accountsI];
                }
                else{
                    temp[i] = null;
                }
            }
            accountsI++;
        }
        accounts = temp;
    }

    //remove the given account
    public boolean close(Account account) {
        if(accounts == null){
            return false;
        }
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] != null && accounts[i].compareTo(account) == 0 && accounts[i].equals(account)){
                refactor(i);
                if(last4()){
                    shrink();
                }
                numAcct = accounts.length;
                return true;
            }
        }

        return false;
    }

    //false if insufficient fund
    public boolean withdraw(Account account){
        return true;
    }

    public void deposit(Account account){
        if(accounts != null){
            for(int i = 0; i < accounts.length; i++){
                if(accounts[i].compareTo(account) == 0){
                    accounts[i].balance = accounts[i].balance - account.balance;
                    if(accounts[i].getClass() == MoneyMarket.class && accounts[i].balance < 2000){
                        //change loyalty status
                    }
                }
            }
        }
    }


    //sort by account type and profile
    public void printSorted(){
        if(accounts == null){
            System.out.println("Account Database is empty!");    
        }
        else{
            System.out.println("*Accounts sorted by account type and profile.");
            
            for(int i = 0; i < accounts.length; i++) {
                if(accounts[i] != null){
                    System.out.println(accounts[i].toString());
                }
            }
            System.out.println("*end of list.");
        }
    }

    //calculate interests/fees
    public void printFeesAndInterests(){

    } 

    //apply the interests/fees
    public void printUpdatedBalances(){

    }
}
