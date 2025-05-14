project title: ATM Simulation System

  A Java-based application that emulates the functionalities of an Automated Teller Machine (ATM), allowing users to perform banking transactions through a graphical user interface.

Overview:

  The ATM Simulation System provides users with a platform to simulate banking transactions such as withdrawals, deposits, balance inquiries, and account management. It offers a user-friendly interface.

Features:

    User Authentication: Secure login using card number and PIN.
    Withdrawals: Withdraw funds from the account.
    Deposits: Deposit funds into the account.
    Balance Inquiry: Check current account balance.
    Transaction History: View past transactions.

Atm.java


package atm;

public class Atm {

	private double balance;
 
	private double depositAmount;
 
	private double withdrawAmount;
 
	public Atm() {
 
		super();
  
	}
 
	public double getBalance() {
 
		return balance;
  
	}
 
	public void setBalance(double balance) {
 
		this.balance = balance;
  
	}
 
	public double getDepositAmount() {
 
		return depositAmount;
  
	}
 
	public void setDepositAmount(double depositAmount) {
 
		this.depositAmount = depositAmount;
  
	}
 
	public double getWithdrawAmount() {
 
		return withdrawAmount;
  
	}
 
	public void setWithdrawAmount(double withdrawAmount) {
 
		this.withdrawAmount = withdrawAmount;
  
	}
 
	@Override
 
	public String toString() {
 
		return "Atm [balance=" + balance + ", depositAmount=" + depositAmount + ", withdrawAmount=" + withdrawAmount
				+ "]";
    
	}
		

}


Technologies Used:

   programming language: java
   
    note:  used classes inteface packages to complete the atm simulation system project. 

  AtmInterface.java
  
  package atm;

public interface AtmInterface {

	public void viewBalance();
 
	public void withdrawAmount(double withdrawAmount);
 
	public void depositAmount(double depositAmount);
 
	public void viewMiniStatement();

}

AtmOperationalImpl.java

package atm;

import java.util.HashMap;

import java.util.Map;

import java.util.Set;

public class AtmOperationImpl implements AtmInterface {

	Atm atm=new Atm();
 
	Map<Double,String> ministmt=new HashMap<>();
 
	public void viewBalance() {
 
		System.out.println("AvailableBalance :"+atm.getBalance());	
  
	}

	public void withdrawAmount(double withdrawAmount) {
		
		if(withdrawAmount%500==0) {
  
			if(withdrawAmount<=atm.getBalance()) {
   
				System.out.println("collect the cash"+withdrawAmount);
    
				atm.setBalance(atm.getBalance()-withdrawAmount);
    
				ministmt.put(withdrawAmount,"Amount withdraw");
    
				viewBalance();
    
			}
   
			else {
   
				System.out.println("Insufficient Balance!!!");
    
			}
		}
  
		else {
  
			System.out.println("Enter the amount in terms of 500!!");
   
		}
		
	}

	
	public void depositAmount(double depositAmount) {
		
		System.out.println("DepositedAmount is :"+depositAmount);
  
		atm.setBalance(atm.getBalance()+depositAmount);
  
		ministmt.put(depositAmount, "Deposited Successfully!!!");
  
		viewBalance();
  
	}

	
	public void viewMiniStatement() {
		
		Set<Double> set=ministmt.keySet();
  
		for(Double d:set) {
  
			System.out.println(d+"="+ministmt.get(d));
   
		}
		
		}

}

UserInterface.java

package atm;

import java.util.Scanner;

public class UserInterface {

	private static int status;
 
	public static void main(String[] args) {
 
		AtmOperationImpl impl=new AtmOperationImpl();
  
		Scanner scan=new Scanner(System.in);
  
		int atmnumber=784241;
  
		int atmpin=1234;
  
		System.out.println("Welcome to ATM Machine....!");
  
		System.out.println("Enter the ATM number:");
  
		int atmnum1=scan.nextInt();
  
		System.out.println("Enter the ATM pin:");
  
		int atmpin1=scan.nextInt();
  
		if(atmnumber==atmnum1 && atmpin==atmpin1) {
  
			while(true) {
   
		System.out.println("1.viewAvailable Balance\n 2.withdrawAmount\n 3.DepositAmount\n 4.viewMinistatement\n 5.Exit");
  
		      System.out.println("Enter your choice:");
        
		      int ch=scan.nextInt();
        
		      if(ch==1) {
        
		    	  impl.viewBalance();
         
		      }
        
		      else if(ch==2) {
        
		    	  System.out.println("Enter the amount to withdraw...");
         
		    	  double withdrawamount=scan.nextDouble();
         
		    	  impl.withdrawAmount(withdrawamount);
         
		    }
		      else if(ch==3) {
        
		    	  System.out.println("Enter the amount to Deposit");
         
		    	  double depositAmount=scan.nextDouble();
         
		    	  impl.depositAmount(depositAmount);
         
		      }
        
		      else if(ch==4){
        
		    	  impl.viewMiniStatement();
         
		      }
        
		      else if(ch==5) {
        
		    	  System.out.println("Collect your ATM CARD\n ThankYou\n Visit again.....!");
         
		    	  System.exit(status);
         
		      }
        
			}
			
		}
  
		else {
  
			System.out.println("Incorrect ATM number or pin........!");
   
		}
			
	}

}

      
sample output:

   note:enter correct atm number and pin
   
     Welcome to ATM Machine....!
     
Enter the ATM number:

784241

Enter the ATM pin:

1234

1.viewAvailable Balance

 2.withdrawAmount
 
 3.DepositAmount
 
 4.viewMinistatement
 
 5.Exit
 
Enter your choice:

3

Enter the amount to Deposit

1000

DepositedAmount is :1000.0

AvailableBalance :1000.0

1.viewAvailable Balance

 2.withdrawAmount
 
 3.DepositAmount
 
 4.viewMinistatement
 
 5.Exit
 
Enter your choice:

1

AvailableBalance :1000.0

1.viewAvailable Balance

 2.withdrawAmount
 
 3.DepositAmount
 
 4.viewMinistatement
 
 5.Exit
 
Enter your choice:

4

1000.0=Deposited Successfully!!!

1.viewAvailable Balance

 2.withdrawAmount
 
 3.DepositAmount
 
 4.viewMinistatement
 
 5.Exit

Enter your choice:

2

Enter the amount to withdraw...

500

collect the cash500.0

AvailableBalance :500.0

1.viewAvailable Balance

 2.withdrawAmount
 
 3.DepositAmount
 
 4.viewMinistatement
 
 5.Exit
 
Enter your choice:

5

Collect your ATM CARD

 ThankYou
 
 Visit again.....!

sample output :

 note: enter incorrect atm number or pin
 
   Welcome to ATM Machine....!
   
Enter the ATM number:

123456

Enter the ATM pin:

1234

Incorrect ATM number or pin........!
