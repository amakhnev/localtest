package com.integrace.localtest.impl;

import java.io.InputStream;
import java.util.Hashtable;

import com.integrace.localtest.NamedParameter;
import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mapping.api.Attachment;
import com.sap.aii.mapping.api.DynamicConfiguration;
import com.sap.aii.mapping.api.InputAttachments;
import com.sap.aii.mapping.api.InputHeader;
import com.sap.aii.mapping.api.InputParameters;
import com.sap.aii.mapping.api.InputPayload;
import com.sap.aii.mapping.api.TransformationInput;

public class TransformationInputImpl extends TransformationInput {
	
	InputAttachmentsImpl _atts = new InputAttachmentsImpl();
	InputHeaderImpl _header;
	private InputStream _stream;
	
	DynamicConfiguration _dynamicConf;
	InputParameters _inputParams;
	
	InputPayload payload = new InputPayload() {
		@Override
		public InputStream getInputStream() {
			return _stream;
		}
	};
	
	public TransformationInputImpl(InputStream stream, 
			Hashtable<NamedParameter, String> messageParams,
			Hashtable<NamedParameter, String> dynamicParams, 
			Hashtable<String, String> mappingParams,
			AbstractTrace trace){
		this._stream = stream;
		this._dynamicConf = new DynamicConfigurationImpl(dynamicParams);
		this._header = new InputHeaderImpl(messageParams);
		this._inputParams = new InputParametersImpl(_dynamicConf,trace,mappingParams);
	
	}
	
	boolean addAttachment(Attachment attachment){
		return _atts.addAttachment(attachment);
	}
	
	
	@Override
	public DynamicConfiguration getDynamicConfiguration() {
		return _dynamicConf;
	}
	
	
	@Override
	public InputAttachments getInputAttachments() {
		return _atts;
	}

	@Override
	public InputHeader getInputHeader() {
		return _header;
	}

	@Override
	public InputParameters getInputParameters() {
		return _inputParams;
	}

	@Override
	public InputPayload getInputPayload() {
		return new InputPayload() {
			@Override
			public InputStream getInputStream() {
				return _stream;
			}
		};
	}

}
