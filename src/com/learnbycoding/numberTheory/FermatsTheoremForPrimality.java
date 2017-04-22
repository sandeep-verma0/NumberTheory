package com.learnbycoding.numberTheory;

import java.math.BigInteger;

public class FermatsTheoremForPrimality {
	
	static boolean isPrime(int p, int k){
		
		if(p==0 || p==1)
			return false;
		
		if(p==2)
			return true;
		
		while(k!=0){
			
			int a= (int)(Math.random()*(p-4)+2); 
			
			if(modulo(a, p-1, p)!=1)
				return false;
			k--;
		}
		
		return true;
	}
	
	
	static long modulo(int a , int d, int n){
		
		if(d==0)
			return 1;
		else if(d==1)
			return a%n;
		else {
			long halfModulo = modulo(a, d/2, n)%n;
			return (halfModulo*halfModulo* (d%2==0 ? 1: a))%n;
		}
	}
	
	
static BigInteger moduloLong(BigInteger a , BigInteger d, BigInteger n){
		
		if(d.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		else if(d.equals(BigInteger.ONE))
			return a.mod(n);
		else {
			BigInteger halfModulo = moduloLong(a, d.divide(new BigInteger("2")), n).mod(n);
			return (halfModulo.multiply(halfModulo).multiply( moduloLong(a, d.mod(new BigInteger("2")), n))).mod(n);
		}
	}
	
public static void main(String[] args) {

	int n=6947;
	int k=2;
	System.out.println("Is "+ n + " prime ?? " + isPrime(n, k));
}
}
