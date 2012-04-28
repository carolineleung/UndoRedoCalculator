package com.calkwl.calculator.operation;

public abstract class AbstractOperationSingleInput implements IOperation {

	private double input;
	private double preOperationValue;
	private double result;

	public AbstractOperationSingleInput(double preOperationValue, double input) {
		this.preOperationValue = preOperationValue;
		this.input = input;
	}

	public double getInput() {
		return input;
	}

	public double getPreOperationValue() {
		return preOperationValue;
	}

	protected void setResult(double result) {
		this.result = result;
	}

	@Override
	public double getResult() {
		return result;
	}

	@Override
	public String toString() {
		return preOperationValue + " " + getOperatorSign() + " " + input + " = " + result;
	}

}
