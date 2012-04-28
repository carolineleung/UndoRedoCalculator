package com.calkwl.calculator.operation;

public class AddOperation extends AbstractOperationSingleInput {
	
	private static final String SIGN = "+";

	public AddOperation(double preOperationValue, double input) {
		super(preOperationValue, input);
	}

	@Override
	public void execute() {
		double result = getPreOperationValue() + getInput();
		setResult(result);
	}

	@Override
	public String getOperatorSign() {
		return SIGN;
	}

}
