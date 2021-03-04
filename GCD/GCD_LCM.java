public class GCD_LCM{
	public static void main(String ... args){
		int a = 90, b = 12;
		System.out.println("1) GCD of number "+a+" and "+b+" is "+eucl_gcd(a, b));
		System.out.println("2) GCD of number "+a+" and "+b+" is "+gcd(a, b));
	}
	//Euclidean Alorithm:
	static int eucl_gcd(int a, int b){
		if(a == 0 || b == 0)
			return 0;
		if(a == b)
			return a;
		if(a>b)
			return eucl_gcd(a-b, b);
		else
			return eucl_gcd(a, b-a);
	}
	//Modulo
	static int gcd(int a, int b){
		int n1 = a > b ? a : b;
		int n2 = a < b ? a : b;
		System.out.println("n1 = "+n1+", n2 = "+n2);
		int temp;
		while(n1 != 0){
			temp = n1;
			n1 = n2 % n1;
			System.out.println("n1 = "+n1);
			n2 = temp;
			System.out.println("n1 = "+n1+", n2 = "+n2);
		}
		return n2;
	}
}
// Theories ----->
	/**
	1) Euclidean Alorithm:
		Based on principle that GCD does not change if the larger number is 
		replaced by its difference with smaller number.
		Hence:
			step 1: replace larger number by its difference with smaller number
			step 2: repeat step 1 untill both numbers are equal
			step 3: finish

		example:
			a = 12, b = 90
			b = b - a
			a = 12, b = 78
			b = b - a
			a = 12, b = 66
			b = b - a
			a = 12, b = 54
			b = b - a
			a = 12, b = 42
			b = b - a
			a = 12, b = 30
			b = b - a
			a = 12, b = 18
			b = b - a
			a = 12, b = 6
			a = a - b
			a = 6, b = 6
			GCD of number 12 and 90 is 6

	2) Modulo Approach:

		example:
			n1 = 90, n2 = 12

			n1 = n2 % n1, n2 = n1
			n1 = 12, n2 = 90
			
			n1 = n2 % n1, n2 = n1
			n1 = 6, n2 = 12
			
			n1 = n2 % n1, n2 = n1
			n1 = 0, n2 = 6
			
			GCD of number 90 and 12 is 6
	**/