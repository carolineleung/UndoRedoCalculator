package com.calkwl.calculator.operation;

public interface IOperation {

	void execute();

	double getInput();

	double getPreOperationValue();  // Calculated value before applying the operation

	double getResult();
	
	String getOperatorSign();

}
