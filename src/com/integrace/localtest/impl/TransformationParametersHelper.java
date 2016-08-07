package com.integrace.localtest.impl;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.integrace.localtest.NamedParameter;
import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mapping.api.DynamicConfiguration;
import com.sap.aii.mapping.api.StreamTransformationConstants;

public class TransformationParametersHelper {

	Hashtable<NamedParameter, String> _messageParams;
	DynamicConfiguration _dynamicConf;
	AbstractTrace _trace;
	
	
	
	public TransformationParametersHelper(
			Hashtable<NamedParameter, String> params,
			DynamicConfiguration conf, AbstractTrace trace) {
		super();
		this._messageParams = params;
		this._dynamicConf = conf;
		this._trace = trace;
	}



	public Map getMap(){
		HashMap<String, Object> result = new HashMap<String, Object>();
		for (NamedParameter nparam:_messageParams.keySet()){
			result.put(nparam.getName(), _messageParams.get(nparam));
		}
		result.put(StreamTransformationConstants.DYNAMIC_CONFIGURATION, _dynamicConf);
		result.put(StreamTransformationConstants.MAPPING_TRACE, _trace);
		return result;
	}
	
	
}
