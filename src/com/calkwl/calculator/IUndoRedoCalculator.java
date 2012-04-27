package com.calkwl.calculator;

import java.util.List;

import com.calkwl.calculator.operation.IOperation;

public interface IUndoRedoCalculator extends ICalculator {

	List<IOperation> getOperations();

	IOperation getLastUndoOperation();

	void apply(IOperation operation);

	boolean undoLastOperation();

	boolean redoLastOperation();

}
