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
