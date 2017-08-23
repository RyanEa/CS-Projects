import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
A bank contains account numbers and balances of each customer.
*/
public class Bank
{
private ArrayList<BankAccount> accountList=new ArrayList<BankAccount>();

/**
Construct a Bank object.
*/

/**
Reads a file with account numbers and balances and adds the accounts
to the bank.
@param filename the name of the file
*/
public void readFile(String filename) throws IOException
{ //Create File object, a scanner object to read data from the file.
  //call the method read 

try
{
    File reader = new File(filename);
    Scanner in = new Scanner(reader);
    read(in);
    in.close();
}
catch(FileNotFoundException e){
	throw new FileNotFoundException();
}
finally{
}
}

//Note: call the method read

/**
Read a file with account numbers and balances and adds the accounts
to the bank.
@param in the scanner for reading the input
*/
private void read(Scanner in) throws IOException {
while (in.hasNext())
{//Create a BankAccount object
	BankAccount temp=new BankAccount();	
//input data for the BankAccount object
	temp.read(in);
//Add the BankAccount object to the accountlist 
	addBankAccount(temp);
}
}

/**
Add an account to the bank.
@param b the BankAccount reference
*/
void addBankAccount(BankAccount temp){
	accountList.add(temp);
}
/**
Gets the account with the highest balance.
@return the account with the highest balance
*/
public BankAccount getHighestBalance()
{
	int index=0;
	double highest=accountList.get(0).getBalance();
	for(int i=0;i<accountList.size();i++){
		if(accountList.get(index).getBalance() < accountList.get(i).getBalance()){
			index=i;
			highest=accountList.get(i).getBalance();
		}
	}
	return accountList.get(index);
}

}