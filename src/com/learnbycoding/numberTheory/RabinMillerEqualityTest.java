package com.learnbycoding.numberTheory;

public class RabinMillerEqualityTest {
	
	static boolean isPrime(long n, long k){
		
		if(n<=1 || n==4)
			return false;
		if(n<=3)
			return true;
		
		if(n%2==0)
			return false;
		
		if(n%3==0)
			return false;
		
	  long d=n-1;
		
		while(d%2==0){
			d/=2;
		}
		
		//System.out.println("d is " + d);
		while(k!=0){
			
			if(rabinMillerTest(d, n)==false)
			    return false;
			
			k--;
		}
		
		return true;
	}
	
	
	private static boolean rabinMillerTest(long d ,long n){
		
		long a=(long)(Math.random()*(n-4) + 2);
		
		long moduloResult = modulo(a, d, n);
		//System.out.println("moduloResult -> " + moduloResult + " a is -> " + a);
		if(moduloResult==1 || moduloResult==n-1)
			return true;
		
		while(d!=n-1){
			
			moduloResult= (moduloResult)*(moduloResult)%n;
			d*=2;
			
			//System.out.println("moduloResult squaring " + moduloResult + " d is -> " + d);
			
			//moduloResult=(moduloResult+n)%n;
			if(moduloResult==1)
				return false;
			if(moduloResult==n-1)
				return true;
		}
		
		//Return composite
		return false;
		
	}
	
	
	private static long modulo(long a , long d, long n){
		
		long res=1;
		a= a%n;
		while(d!=0){
			
			if(d%2==1)
				res= (a*res)%n;
			
			d/=2;
			a=(a*a)%n;
		}
		
		return (res+n)%n;
	}
	
	
public static void main(String[] args) {

	//for(int i=1;i<1000000;i++)
		//if(isPrime(i, 2))
	   //System.out.println(i+" ");
	
	System.out.println((isPrime(999931, 2)));
	
}
}
