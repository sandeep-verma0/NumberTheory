package com.learnbycoding.numberTheory;

public class ChineseRemainderTheoremInefficient {
	
	private static int chineseRemainder (int[] num , int rem[] ,int k){
		int j=0;
		while(true){

			int i;
			for(i=0;i<k;i++){
				
			  if(j%num[i]!=rem[i])
				  break;
			}
						
			if(i==k)
				return j;
			
			j++;
		}
	
	}
	
public static void main(String[] args) {
	
	 int num[] = {3, 4, 5};
	 int rem[] = {2, 3, 1};
	System.out.println("number is -> " + chineseRemainder(num, rem, num.length));
}
}
