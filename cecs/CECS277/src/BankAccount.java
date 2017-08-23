import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
A bank account has a balance that can be changed by deposits and withdrawals.
*/
public class BankAccount
{
private double balance;
private int accountNumber;

/**
Constructs a bank account with a zero balance.
*/
public BankAccount(){
	balance=0;
	accountNumber=0;
}
/**
Constructs a bank account with a given account number and a initial balance.
*/
public BankAccount(int accNumber, double abalance){
	accountNumber=accNumber;
	balance=abalance;
}
/**
Reads an account number and balance.
@param in the scanner
@return true if the data was read
false if the end of the stream was reached
*/
public void read(Scanner in) throws IOException
{
	String read = in.nextLine();
	String[] splits = read.split(" ");
try
{
	balance=Double.parseDouble(splits[1]);
	accountNumber=Integer.parseInt(splits[0]);

} 
catch (NumberFormatException e)
{
    throw new IOException();
}
}
//Note: You need to check for incompatible input.

/**
Deposits money into the bank account.
@param amount the amount to deposit
*/
void deposit(double deposited){
	balance+=deposited;
}
/**
Withdraws money from the bank account.
@param amount the amount to withdraw
*/
void withdraw(double takeout){
	if((balance-takeout)<0){
		System.out.println("Unable to withdraw that much");
	}
	else
		balance-=takeout;
}
/**
Gets the current balance of the bank account.
 * @return 
@return the current balance
*/
double getBalance(){
	return balance;
}
/**
Gets the account number of the bank account.
@return the account number
*/
int getAccountNumber(){
	return accountNumber;
}
}