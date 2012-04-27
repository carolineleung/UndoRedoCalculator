package com.calkwl.calculator.operation;

public class SubtractOperation extends AbstractOperationSingleInput {

	public SubtractOperation(double preOperationValue, double input) {
		super(preOperationValue, input);
	}

	@Override
	public void execute() {
		double result = getPreOperationValue() - getInput();
		setResult(result);
	}

	@Override
	public Type getType() {
		return Type.Subtract;
	}

}
