package com.learnbycoding.numberTheory;

public class FastExponentiation {

	private static long recursiveExponent(int a , int n){
		
		if(n==0)
			return 1;
		if(n==1)
			return a;
		
		long result= recursiveExponent(a, n/2);
		 return result*result*(n%2==0 ? 1: a);
	}
	
	public static void main(String[] args) {

		int a=8;
		int n=15;
		
		long result=1;
		
		long temp=n;
		while(temp >0){
			
			if(temp%2==1)
				result=result*a;
		
			temp=temp/2;
			a=a*a;
		}
		
		System.out.println(result);
		
		int b=8;
		System.out.println(recursiveExponent(b, n));
	}

}
