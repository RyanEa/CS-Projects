import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
A frame for manipulating a bank account.
*/
public class BankAccountFrame extends JFrame
{
private BankAccount account;
private JLabel label;
private JTextField amountField;

private static final int FRAME_WIDTH = 400;
private static final int FRAME_HEIGHT = 100;

/**
Constructs a BankAccountFrame for a given account.
@param anAccount the account to manipulate
*/
public BankAccountFrame(BankAccount anAccount)
{
account = anAccount;

// The label for displaying the results
label = new JLabel("balance=" + account.getBalance());

// the label, text field, and button for entering an amount
JLabel amountLabel = new JLabel("Amount:");
amountField = new JTextField(7);

// the control panel that holds the components
JPanel controlPanel = new JPanel();
controlPanel.add(amountLabel);
controlPanel.add(amountField);
//controlPanel.add(new JLabel("Amount:"));
controlPanel.add(createWithdrawButton());
controlPanel.add(createDepositButton());
controlPanel.add(label);

add(controlPanel);
setSize(FRAME_WIDTH, FRAME_HEIGHT);
}

private JButton createDepositButton()
{
JButton depositButton = new JButton("Deposit");

class DepositListener implements ActionListener
{
public void actionPerformed(ActionEvent event)
{
double depositAmount = Double.parseDouble(amountField.getText());

account.deposit(depositAmount);
label.setText("balance=" + account.getBalance());
}
}

ActionListener listener1 = new DepositListener();
depositButton.addActionListener(listener1);
return depositButton;
}

private JButton createWithdrawButton()
{
JButton withdrawButton = new JButton("Withdraw");

class WithdrawListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
	double withdrawAmount = Double.parseDouble(amountField.getText());

	account.withdraw(withdrawAmount);
	label.setText("balance=" + account.getBalance());
	}
}
ActionListener listener2 = new WithdrawListener();
withdrawButton.addActionListener(listener2);
return withdrawButton;
}
}
