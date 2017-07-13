package b;
import java.util.Scanner;
import java.util.Date;
public class IllegalArgumentException {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		//Enter yearly interest rate
		System.out.print(
			"Enter yearly interest rate, for example, 8.25: ");
		double annualInterstRate = input.nextDouble();
		try{
			if( annualInterstRate<=0)
				throw new ArithmeticException("IllegalArgumentException");
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Illegal Argument Exception!");
			System.out.print("Please check your rate and enter again:");
			annualInterstRate = input.nextDouble();
		}
		//Enter number of years
		System.out.print("Enter number of years as an integer: ");
		int numberOfYears = input.nextInt();
		try{
			if( numberOfYears<=0)
				throw new ArithmeticException("IllegalArgumentException");
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Illegal Argument Exception!");
			System.out.print("Please check your number and enter again:");
			numberOfYears = input.nextInt();
		}
		//Enter loan amount
		System.out.print("Enter loan amount, for example, 12000.95: ");
		double loanAmount = input.nextDouble();
		
		//if the loan amount, interest rate, 
		//or number of years is less than or equal to zero.
		try{
			if(loanAmount<=0)
				throw new ArithmeticException("IllegalArgumentException");
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Illegal Argument Exception!");
			System.out.println("Please check your amount and enter again:");
			loanAmount = input.nextDouble();
		}
		Loan loan = new Loan(annualInterstRate,numberOfYears,loanAmount);
		
		//Display loan date, monthly payment, and total payment
		System.out.printf("The loan was created on %s\n" +
		 "The monthly payment is %.2f\nThe total payment is %.2f\n", 
		 loan.getLoanDate(), loan.getMonthlyPayment(),
		 loan.getTotalPayment());
	}
	public static class Loan{
		private double annualInterestRate;
		private int numberOfYears;
		private double loanAmount;
		private Date loanDate;
		
		//Default construtor
		public Loan(){
			this(2.5, 1, 1000);
		}
		
		public Loan(double anIRate, int nuOfYears, double loanAmount) {
			this.annualInterestRate = anIRate;
			this.numberOfYears = nuOfYears;
			this.loanAmount = loanAmount;
		}
		
		public double getAnnualInterestRate() {
			return annualInterestRate;
		}
		public void setAnnualInterestRate(double rate){
			this.annualInterestRate = rate;
		}
		public int getNumberOfYears() {
			return numberOfYears;
		}
		public void setNumberOfYears(int num){
			this.numberOfYears = num;
		}
		public double getLoanAmount(){
			return loanAmount;
		}
		public void setLoanAmount(double loanAmount){
			this.loanAmount = loanAmount;
		}
		public double getMonthlyPayment(){
			double monthlyInterestRate = annualInterestRate / 1200;
			double monthlyPayment = loanAmount * monthlyInterestRate /
					(1-(Math.pow(1/(1+monthlyInterestRate), numberOfYears *12)));
			return monthlyPayment;
		}
		public double getTotalPayment(){
			double totalPayment = getMonthlyPayment() * numberOfYears *12;
			return totalPayment;
		}
		public Date getLoanDate(){
			loanDate = new Date();
			return loanDate;
		}
	}
	
}

