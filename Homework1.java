//Christopher Santiago
//Sales Commission Calculator
//01.08.19
import java.text.DecimalFormat;

public class Homework1 {

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		for(double i = 1000; i <= 20000; i+=1000) {
			System.out.print("$" + formatter.format(i) + "\t");
			System.out.println("$" + formatter.format(computeIncome(i)));
		}//end of for loop
	}// end of main

	public static double computeIncome(double salesAmount) {
		double result;
		double base = 5000;
		double commissionRate;
		double firstTier = 400;
		double secondTier = 500;
		if(salesAmount <= 5000) {
			commissionRate = .08;
			result = (salesAmount * commissionRate) + base;
		} else if (salesAmount > 5000 && salesAmount <= 10000 ) {
			commissionRate = .10;
			result = ((salesAmount - base) * commissionRate) + base + firstTier;
		} else {
			commissionRate = .12;
			result = ((salesAmount - 10000) * commissionRate) + base + firstTier + secondTier;
		}
		return result;
	}//end of computeIncome
}//end of HomeWork1
