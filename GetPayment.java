package Assignment3;

class TotalFee implements PaymentF{ //implementing an interface for fee
	
	public double getPayment(double f) { //Method implementation
		double totalF = f-20; //join 2 classes of software training will get RM20 cash back
		return totalF; 
	}
	
	public double getPayment(double f, double d) { //Method implementation
		double totalF = (f -30) * (1-d);//join 3 classes of software training will get RM30 cash back and 5% discount
		return totalF; 
	}
}

class TotalSalary implements Payment{ //implementing an interface for salary
	
	public double getPayment(double f, int n) { //Method implementation
		double totalS = f * 3 / 5 * n; //the employee can get 3/5 of the income of that particular type of software training
		return totalS; 
	}	
}

class TotalIncome implements Payment{ //implementing an interface for income
	
	public double getPayment(double f, int n) { //Method implementation
		double totalI = f * n;  // calculate total income of a particular type of software training(fee multiply by number of participants)
		return totalI; 
	}	
}


