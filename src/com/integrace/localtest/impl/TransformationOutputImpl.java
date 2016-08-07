package com.integrace.localtest.impl;

import java.io.OutputStream;
import java.util.Hashtable;

import com.integrace.localtest.NamedParameter;
import com.sap.aii.mapping.api.OutputAttachments;
import com.sap.aii.mapping.api.OutputHeader;
import com.sap.aii.mapping.api.OutputParameters;
import com.sap.aii.mapping.api.OutputPayload;
import com.sap.aii.mapping.api.TransformationOutput;

public class TransformationOutputImpl extends TransformationOutput {
	
	OutputHeaderImpl _header;
	private OutputStream _stream;
	
	OutputParameters _outputParams;
	
	
	public TransformationOutputImpl(OutputStream stream, 
			Hashtable<NamedParameter, String> messageParams,
			Hashtable<String, String> mappingParams){
		this._stream = stream;
		this._header = new OutputHeaderImpl(messageParams);
		this._outputParams = new OutputParametersImpl(mappingParams);
	
	}
	
	
	

	@Override
	public void copyInputAttachments() {
		throw new UnsupportedOperationException();	
	}

	@Override
	public OutputAttachments getOutputAttachments() {
		throw new UnsupportedOperationException();	
	}

	@Override
	public OutputHeader getOutputHeader() {
		return _header;
	}

	@Override
	public OutputParameters getOutputParameters() {
		return _outputParams;
	}

	@Override
	public OutputPayload getOutputPayload() {
		return new OutputPayload() {

			@Override
			public OutputStream getOutputStream() {
				return _stream;
			}
		};
	}

}
