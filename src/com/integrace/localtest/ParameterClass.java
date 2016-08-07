package com.integrace.localtest;

public enum ParameterClass {
	
	SYSTEM(false),
	FILE(true),
	RFC(true),
	HTTP(true),
	CUSTOM(false)
	;
	
	private boolean adapterSpecific;

	public boolean isAdapterSpecific() {
		return adapterSpecific;
	}

	private ParameterClass(boolean adapterSpecific) {
		this.adapterSpecific = adapterSpecific;
	}
	
	
}
