package com.integrace.localtest.impl;

import java.util.Hashtable;

import com.sap.aii.mapping.api.OutputParameters;
import com.sap.aii.mapping.api.UndefinedParameterException;
import com.sap.aii.mapping.api.WrongParameterTypeException;

public class OutputParametersImpl extends OutputParameters {
	
	private Hashtable<String,String> _params;
	
	private OutputParametersImpl() {
	}

	public OutputParametersImpl(Hashtable<String,String> params){
		this();
		this._params = params;
	}
	
	@Override
	public boolean exists(String arg0) {
		return _params.contains(arg0);
	}

	@Override
	public void setInt(String key, int value)
			throws UndefinedParameterException, WrongParameterTypeException {
		_params.put(key, ""+value);
	}

	@Override
	public void setString(String key, String value)
			throws UndefinedParameterException, WrongParameterTypeException {
		_params.put(key, value);
	}

	@Override
	public void setValue(String key, Object value)
			throws UndefinedParameterException, WrongParameterTypeException {
		_params.put(key, value.toString());
	}

}
