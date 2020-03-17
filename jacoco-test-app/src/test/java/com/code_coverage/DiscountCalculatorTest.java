package com.code_coverage;

import org.junit.Test;

public class DiscountCalculatorTest{
	
	private DiscountCalculator discountCalculator = new DiscountCalculator();
	
	@Test(expected=IllegalArgumentException.class)
	public void whenPurchaseAmt_IsNegative_ShouldThrow_IllegalArgumentException(){
		//Assert.fail("this is fail");
		discountCalculator.calculateDiscountAmt(-20);
	}
}