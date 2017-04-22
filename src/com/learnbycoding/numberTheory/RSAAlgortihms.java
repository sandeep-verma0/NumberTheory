package com.learnbycoding.numberTheory;

import java.math.BigInteger;
import java.util.Random;

public class RSAAlgortihms {

	static BigInteger p=BigInteger.ZERO;
	static BigInteger q=BigInteger.ZERO;
	static BigInteger phi=BigInteger.ZERO;
	static void encryptDecrypt(String message) {
	
		System.out.println("MEssage is - > "  +message);
		BigInteger messageLong =new  BigInteger(message);
		
	
		Random newRandom = new Random();
	
			p = BigInteger.probablePrime(70,newRandom);
			System.out.println("p is " +  p.toString());

			/*
			if (RabinMillerEqualityTest.isPrime(p, 3)) {
				break;
			}
			
			*/
		
			q =BigInteger.probablePrime(80, newRandom);
			System.out.println("q is " +  q.toString());

			/*
			if (RabinMillerEqualityTest.isPrime(q, 3)) {
				break;
			}
		*/
		
		phi= p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)) ;
		BigInteger n = p.multiply(q);
		BigInteger cipher = messageLong;
		
		System.out.println("Phi is " + phi.toString());
		System.out.println("n is " + n.toString());
		
		
		BigInteger e =  BigInteger.probablePrime(20, newRandom);
		System.out.println("e is " + e);
		
		while(phi.mod(e).equals(BigInteger.ZERO)){
			e=BigInteger.probablePrime(10, newRandom);
		}
		
		BigInteger d=ExtendedGCDByEuclidean.extendedEuclidBigInteger(e, phi);
		
		if(d.compareTo(BigInteger.ZERO)==-1)
			d= (d.add(phi)).mod(phi);
		
		System.out.println("d is " + d.toString());
        BigInteger encryptedMessageIs = FermatsTheoremForPrimality.moduloLong(cipher, e, n);
		
		if(encryptedMessageIs.compareTo(BigInteger.ZERO)==-1)
			encryptedMessageIs = (encryptedMessageIs.add(n)).mod(n) ;
		
		String encrypted = String.valueOf(encryptedMessageIs);
		System.out.println("encryptedMessageIs -> " + encrypted);
		 
		BigInteger decrypted =  FermatsTheoremForPrimality.moduloLong(encryptedMessageIs, d, n);
		 
			if(decrypted.compareTo(BigInteger.ZERO)==-1)
				decrypted = (decrypted.add(n)).mod(n) ;

		String decryptedMess = String.valueOf(decrypted);
		System.out.println("decryptedMessageIs -> " + decryptedMess);
		 
		char[] decryptMessage = decryptedMess.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<decryptedMess.length();i++){
			sb.append((char)decryptMessage[i]+ "");
		}

		System.out.println(sb.toString());
	}

	public static void main(String[] args) {

		String message = "Whats up hello r";
		char[] messageChar = message.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<messageChar.length;i++){
			sb.append((int)messageChar[i]+ "");
		}
		
		encryptDecrypt(sb.toString());

	}

}
