import tester.*
// Practice Problem 4.4
// Each account has an ID# and customerName

// An account is one of:
//	-checking
//	-savings
//	-CD

// A checking account includes the current balance and minimum balance
// A savings account includes the current balance and interest rate
// A CD includes the current balance, interest rate, and maturity date

//define account
interface Account{}

//define checking
class Checking implements Account{ 
	int idNumber;
	String customerName;
	int currentBalance;
	int minimumBalance;

	Checking(
		int idNumber, 
		String customerName, 
		int currentBalance, 
		int minimumBalance) {
			this.idNumber = idNumber;
			this.customerName = customerName;
			this.currentBalance = currentBalance;
			this.minimumBalance = minimumBalance;
	}
}

//define savings
class Savings implements Account{
	int idNumber;
	String customerName;
	int currentBalance;
	int interestRate;

	Savings(
		int idNumber, 
		String customerName, 
		int currentBalance, 
		int interestRate) {
			this.idNumber = idNumber;
			this.customerName = customerName;
			this.currentBalance = currentBalance;
			this.interestRate = interestRate;
	}
}

//define certDeposit
class certDeposit implements Account{
	int idNumber;
	String customerName;
	int currentBalance;
	int interestRate;
	int maturityDate;

	certDeposit(
		int idNumber, 
		String customerName, 
		int currentBalance, 
		int interestRate, 
		int maturityDate) {
			this.idNumber = idNumber;
			this.customerName = customerName;
			this.currentBalance = currentBalance;
			this.interestRate = interestRate;
			this.maturityDate = maturityDate;
	}
}

//define maturityDate
class maturityDate{
    String month;
    int day;
    int year;
    
    maturityDate(String month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }
}

//----------------------------------------------------------------------------
//Examples
class exampleAccounts {
    Account account1 = new Checking(
            1729, "Earl Gray", 1250, 500);
    Account account2 = new certDeposit(
            4104, "Ima Flatt", 10123, 4, new maturityDate("June", 1, 2005));
    Account account3 = new Savings(
            2992, "Annie Proulx", 800, 3.5);
}
