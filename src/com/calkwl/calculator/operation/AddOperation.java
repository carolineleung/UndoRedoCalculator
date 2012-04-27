package com.calkwl.calculator.operation;

public class AddOperation extends AbstractOperationSingleInput {

	public AddOperation(double preOperationValue, double input) {
		super(preOperationValue, input);
	}

	@Override
	public void execute() {
		double result = getPreOperationValue() + getInput();
		setResult(result);
	}

	@Override
	public Type getType() {
		return Type.Add;
	}

}
