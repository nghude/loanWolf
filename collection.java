
import java.util.Scanner;
public class collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0;
		double interestPaid = 0;
		
		Scanner userInput = new Scanner(System.in);

		System.out.println("Enter principal: ");
		double principal = userInput.nextDouble();
		
		System.out.println("Enter interest rate (as a decimal): ");
		double rate = userInput.nextDouble();
		
		System.out.println("Enter minimum payment: ");
		double minPayment = userInput.nextDouble();
		
		System.out.println("Enter number of payments: ");
		int numPayments = userInput.nextInt();
		
		while (count != numPayments) {
			count++;
			interestPaid = getInterestPayment(principal,rate,numPayments);
			principal = principal - (minPayment - interestPaid);
			System.out.println("Month " + count + ":");
			System.out.println("You paid $" + interestPaid + " in interest.");
			System.out.println("You paid $" + (minPayment - interestPaid) + " of your principal.");
			System.out.println("You now owe $" + principal + ".");
			System.out.println("-----------------------------------------------------------------");
		}
		
		userInput.close();
	}
	
	public static double getInterestPayment (double principal, double rate, int numPayments) {
		
		return (rate/numPayments) * principal;
		
	}

}
