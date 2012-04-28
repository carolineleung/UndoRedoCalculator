package com.calkwl.calculator.operation;

import junit.framework.Assert;

import org.junit.Test;

public class OperationTests {

	@Test
	public void testAddPositiveValue() {
		AddOperation addPositiveOp = new AddOperation(0, 1.0);
		addPositiveOp.execute();
		Assert.assertEquals("0 + 1 failed", 1.0, addPositiveOp.getResult());		
	}

	@Test
	public void testAddNegativeValue() {
		AddOperation addPositiveOp = new AddOperation(0, -1.0);
		addPositiveOp.execute();
		Assert.assertEquals("0 + -1 add failed", -1.0, addPositiveOp.getResult());		
	}

	@Test
	public void testSubtractPositiveValue() {
		SubtractOperation op = new SubtractOperation(0, 1.0);
		op.execute();
		Assert.assertEquals("0 - 1 subtract failed", -1.0, op.getResult());		
	}

	@Test
	public void testSubtractNegativeValue() {
		SubtractOperation op = new SubtractOperation(0, -1.0);
		op.execute();
		Assert.assertEquals("0 - -1 add failed", 1.0, op.getResult());		
	}

}
