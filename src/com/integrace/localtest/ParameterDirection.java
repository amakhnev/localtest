package com.integrace.localtest;

public enum ParameterDirection {
	INPUT_ONLY(true,false),
	OUTPUT_ONLY(false,true),
	INPUT_OUTPUT(true,true)
	;
	
	private boolean input;
	private boolean output;
	public boolean isInput() {
		return input;
	}
	public boolean isOutput() {
		return output;
	}
	private ParameterDirection(boolean input, boolean output) {
		this.input = input;
		this.output = output;
	}
	
	
	
}
