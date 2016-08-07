package com.integrace.localtest.impl;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mapping.api.DynamicConfiguration;
import com.sap.aii.mapping.api.InputParameters;
import com.sap.aii.mapping.api.StreamTransformationConstants;
import com.sap.aii.mapping.lookup.Channel;

public class InputParametersImpl extends InputParameters {

	private Hashtable<String, String> _params;
	private DynamicConfiguration _dynconf;
	private AbstractTrace _trace;

	protected InputParametersImpl() {
	};

	public InputParametersImpl(DynamicConfiguration dynconf,
			AbstractTrace trace, Hashtable<String, String> jmParams) {
		this._dynconf = dynconf;
		this._trace = trace;
		this._params = jmParams;

	}

	@Override
	public Channel getChannel(String arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getInt(String arg0) {
		Object param = _params.get(arg0);
		if (param != null) {
			return Integer.parseInt((String) param);
		}
		return 0;
	}

	@Override
	public String getString(String arg0) {
		Object param = _params.get(arg0);
		if (param != null) {
			return param.toString();
		}
		return null;
	}

	@Override
	public Object getValue(String arg0) {
		if (arg0.equals(StreamTransformationConstants.DYNAMIC_CONFIGURATION)){
			return _dynconf;
		}else if (arg0.equals(StreamTransformationConstants.MAPPING_TRACE)){
			return _trace;
		}
		return _params.get(arg0);

	}
	
	public Map<String, Object> getMap(){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.putAll(_params);
		result.put(StreamTransformationConstants.DYNAMIC_CONFIGURATION, _dynconf);
		result.put(StreamTransformationConstants.MAPPING_TRACE, _trace);
		return result;
	}

}
