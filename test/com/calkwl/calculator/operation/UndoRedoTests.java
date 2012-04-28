package com.calkwl.calculator.operation;

import junit.framework.Assert;

import org.junit.Test;

import com.calkwl.calculator.IUndoRedoCalculator;
import com.calkwl.calculator.UndoRedoCalculator;

public class UndoRedoTests {

	@Test
	public void testUndoRedo() {
		IUndoRedoCalculator calculator = new UndoRedoCalculator();
		calculator.apply(new AddOperation(0, 10));
		Assert.assertEquals(10.0, calculator.getCurrValue());
		calculator.undoLastOperation();
		Assert.assertEquals(0.0, calculator.getCurrValue());		
		calculator.redoLastOperation();
		Assert.assertEquals(10.0, calculator.getCurrValue());

	}
	
	@Test
	public void testUndoRedoTwice() {
		IUndoRedoCalculator calculator = new UndoRedoCalculator();
		calculator.apply(new AddOperation(0, 10));
		Assert.assertEquals(10.0, calculator.getCurrValue());
		calculator.undoLastOperation();
		Assert.assertEquals(0.0, calculator.getCurrValue());		
		calculator.redoLastOperation();
		Assert.assertEquals(10.0, calculator.getCurrValue());

		calculator.apply(new AddOperation(calculator.getCurrValue(), 10));
		Assert.assertEquals(20.0, calculator.getCurrValue());
		calculator.undoLastOperation();
		Assert.assertEquals(10.0, calculator.getCurrValue());		
		calculator.redoLastOperation();
		Assert.assertEquals(20.0, calculator.getCurrValue());

	}
	

}
