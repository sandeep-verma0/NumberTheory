package com.learnbycoding.numberTheory;

public class GCD {

	static int getGCDIteratively(int a, int b) {

		while (b >= 1) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	static int getGCDRecursive(int a, int b) {

		//System.out.println("b is" + b);
		if(b==0)
			return a;
		else {
			return getGCDRecursive(b, a%b);
		}
	}

	public static void main(String[] args) {

		System.out.println(getGCDIteratively(20, 15));
		System.out.println(getGCDRecursive(75, 5));
		//System.out.println(5%0);
	}
}
