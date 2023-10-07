/**
 * @author Vivek Bhadkamkar (vab85)
 * @author Sajin Saju (@ss3652)
 */
public class AccountDatabase
{
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    private int find(Account account)
    {
        return 0;
    } //search for an account in the array
    private void grow() //increase the capacity by 4
    {
        Account[] temp = new Account[accounts.length + 4];
        for(int i = 0; i < accounts.length; i++){
            temp[i] = accounts[i];
        }

        accounts = temp;
    }
    public boolean contains(Account account)//overload if necessary
    {
        for(int i = 0; i < accounts.length; i++)
        {
            if(accounts[i] != null && accounts[i].compareTo(account) == 0)
            {
                return true;
            }
        }
        return false;
    }
    public boolean open(Account account) //add a new account
    {
        return false;
    }
    public boolean close(Account account) //remove the given account
    {
        return true;
    }
    public boolean withdraw(Account account){return true;} //false if insufficient fund
    public void deposit(Account account){}
    public void printSorted(){} //sort by account type and profile
    public void printFeesAndInterests(){} //calculate interests/fees
    public void printUpdatedBalances(){} //apply the interests/fees
}
