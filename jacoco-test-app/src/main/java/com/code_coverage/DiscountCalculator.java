package com.code_coverage;

public class DiscountCalculator {
	
	public double calculateDiscountAmt(final int purchaseAmt){
		if(purchaseAmt<0){
			throw new IllegalArgumentException("Purchasing Amount shoudn't be negative");
		}
		if(purchaseAmt >=20_000){
			return (purchaseAmt/10)*100;
		}
		return (purchaseAmt/5)*100;
		
	}
}