package com.integrace.localtest.impl;

import java.util.Hashtable;

import com.integrace.localtest.NamedParameter;
import com.sap.aii.mapping.api.OutputHeader;

public class OutputHeaderImpl extends OutputHeader {

	Hashtable<NamedParameter, String> _outputMessageParameters;
	
	private OutputHeaderImpl(){}
	
	public OutputHeaderImpl(Hashtable<NamedParameter, String> outputMessageParameters){
		this();
		this._outputMessageParameters = outputMessageParameters;
		
	}
	
	
	@Override
	public void setContentType(String value) {
		_outputMessageParameters.put(NamedParameter.CONTENT_TYPE, value);
	}

}
