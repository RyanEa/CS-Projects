/** 
This program runs threads that deposit and withdraw 
money from the same bank account. 
*/ 
public class BankAccountThreadRunner 
{ 
public static void main(String[] args) 
{ 
BankAccount account = new BankAccount(); 
final double AMOUNT = 10000; 
final int REPETITIONS = 10; 
final int DEPOSIT_THREADS = 10; 
final int WITHDRAW_THREADS = 2;

      for (int i = 0; i < DEPOSIT_THREADS; i++) 
{ 
DepositRunnable d = new DepositRunnable(account, AMOUNT, REPETITIONS); 
Thread t = new Thread(d); 
t.start();
} 

for (int i = 0; i < WITHDRAW_THREADS; i++) 
{ 
WithdrawRunnable d = new WithdrawRunnable(account, AMOUNT, REPETITIONS * DEPOSIT_THREADS / WITHDRAW_THREADS); 
Thread t =new Thread(d); 
t.start(); 
} 
} 
}