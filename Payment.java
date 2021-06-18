package Assignment3;

//2.5 Interface 
interface PaymentF { //for fee
	
	double getPayment(double f); // method with no body
	
	double getPayment(double f, double d); // method with no body
}

interface Payment { //for salary & income
	
	double getPayment(double f, int n); // method with no body
}


