package com.calkwl.calculator.operation;

public interface IOperation {

	enum Type {
		Add("+"), Subtract("-"), Multiply("*"), Divide("/");

		private String symbol;

		private Type(String symbol) {
			this.symbol = symbol;
		}

		public String getSymbol() {
			return symbol;
		}
	}

	void execute();

	Type getType();

	double getInput();

	double getPreOperationValue();  // Calculated value before applying the operation

	double getResult();

}
