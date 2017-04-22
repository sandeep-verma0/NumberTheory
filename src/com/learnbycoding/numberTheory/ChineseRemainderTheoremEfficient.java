package com.learnbycoding.numberTheory;

public class ChineseRemainderTheoremEfficient {
	
	
	private static int chineseRemainder (int[] num , int rem[] ,int k){
		
		int product = 1;
		
		int[] pp= new int[k];
		int[] inv= new int[k];
		
		for(int i=0;i<k;i++)
			product=product*num[i];
		
		for(int j=0;j<k;j++)
			pp[j]=product/num[j];
			
		for(int j=0;j<k;j++)
			inv[j]= ((int) ExtendedGCDByEuclidean.extendedEuclid(pp[j], num[j])+ num[j])%num[j];
		
		int numberIs=0;
		for(int j=0;j<k;j++){
			numberIs = numberIs+rem[j]*pp[j]*inv[j];
		}
		
		return numberIs%product;
	
	}
	public static void main(String[] args) {
		int num[] = { 3, 4, 5 };
		int rem[] = { 2, 3, 1 };
		System.out.println("number is -> "
				+ chineseRemainder(num, rem, num.length));
	}
}
