package com.calkwl.calculator;

import java.util.ArrayList;
import java.util.List;

import com.calkwl.calculator.operation.AddOperation;
import com.calkwl.calculator.operation.IOperation;
import com.calkwl.calculator.operation.SubtractOperation;

/**
 * Controller class for the Calculator with undo/redo support.
 * 
 * @author carolineleung
 */
public class UndoRedoCalculator implements IUndoRedoCalculator {

	private List<IOperation> operations = new ArrayList<IOperation>();
	private IOperation lastUndoOperation;

	public List<IOperation> getOperations() {
		return operations;
	}

	public IOperation getLastUndoOperation() {
		return lastUndoOperation;
	}

	public double getCurrValue() {
		IOperation lastOperation = getLastOperation();
		return lastOperation != null ? lastOperation.getResult() : 0;
	}

	@Override
	public void apply(IOperation operation) {
		operation.execute();
		operations.add(operation);
		resetLastUndoOperation();
	}

	@Override
	public boolean undoLastOperation() {
		boolean undoSuccessful = false;
		IOperation lastOperation = getLastOperation();
		if (lastOperation != null) {
			lastUndoOperation = operations.remove(operations.size() - 1);
			undoSuccessful = true;
		}
		return undoSuccessful;
	}

	@Override
	public boolean redoLastOperation() {
		if (lastUndoOperation != null) {
			operations.add(lastUndoOperation);
			resetLastUndoOperation(); // Reset lastUndoOperation since it's already applied
			return true;
		}
		return false;
	}

	private IOperation getLastOperation() {
		IOperation lastOperation = null;
		int numOperations = operations.size();
		if (numOperations > 0) {
			lastOperation = operations.get(numOperations - 1);
		}
		return lastOperation;
	}

	private void resetLastUndoOperation() {
		lastUndoOperation = null;
	}

	public static final void main(String... args) {
		UndoRedoCalculator calculator = new UndoRedoCalculator();
		calculator.apply(new AddOperation(0, 1));
		IOperation lastOp = calculator.getLastOperation();
		System.out.println(lastOp);

		calculator.apply(new AddOperation(lastOp.getResult(), 2.5));
		System.out.println(calculator.getLastOperation());

		calculator.undoLastOperation();
		System.out.println(calculator.getLastOperation());

		calculator.redoLastOperation();
		System.out.println(calculator.getLastOperation());

		calculator.apply(new SubtractOperation(calculator.getLastOperation().getResult(), 1));
		System.out.println(calculator.getLastOperation());

	}
}
