package com.learnbycoding.numberTheory;

import java.math.BigInteger;

public class ExtendedGCDByEuclidean {

	static class Point{
		int x;
		int y;
		
		public Point(){
			this.x=0;
			this.y=0;
		}
	}
	
	private static int extendedEuclid(int a , int b , Point point){
		
		if(a==0)
		{
			point.x=0;
			point.y=1;
			return b;
		}
		
		Point newPoint = new Point();
		int gcd= extendedEuclid(b%a ,a, newPoint);
		
		int q= b/a;
		point.x= newPoint.y - q *newPoint.x;
		point.y= newPoint.x;
		
		return gcd;
	}
	
	public static long extendedEuclid(long a, long b)
    {
        long x = 0, y = 1, lastx = 1, lasty = 0, temp;
        while (b != 0)
        {
            long q = a / b;
            long r = a % b;
 
            a = b;
            b = r;
 
            temp = x;
            x = lastx - q * x;
            lastx = temp;
 
            temp = y;
            y = lasty - q * y;
            lasty = temp;            
        }
        
        return lastx;
       // System.out.println("Roots  x : "+ lastx +" y :"+ lasty);
    }
	
	public static BigInteger extendedEuclidBigInteger(BigInteger a, BigInteger b)
    {
		BigInteger x = BigInteger.ZERO, y = BigInteger.ONE, lastx = BigInteger.ONE, lasty = BigInteger.ZERO, temp;
        while (b.compareTo(BigInteger.ZERO)!=0)
        {
            BigInteger q = a.divide(b);
            BigInteger r = a.mod(b);
 
            a = b;
            b = r;
 
            temp = x;
            x = lastx.subtract(q.multiply(x));
            lastx = temp;
 
                    
        }
        
        return lastx;
       // System.out.println("Roots  x : "+ lastx +" y :"+ lasty);
    }
	
	public static void main(String[] args) {

		Point p= new Point();
		int a=35;
		int b=11;
		System.out.println(extendedEuclid(a, b,p));
		System.out.println(p.x + " " + p.y);
		
		System.out.println("Multiplicative Inverse of " + a+ " mod "+ b+ " is -> " + (p.x+b)%b );
	}

}
