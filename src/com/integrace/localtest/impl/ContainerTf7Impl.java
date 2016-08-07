package com.integrace.localtest.impl;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.integrace.localtest.NamedParameter;
import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mapping.api.InputAttachments;
import com.sap.aii.mapping.api.InputHeader;
import com.sap.aii.mapping.api.InputParameters;
import com.sap.aii.mapping.api.OutputAttachments;
import com.sap.aii.mapping.api.OutputHeader;
import com.sap.aii.mapping.api.OutputParameters;
import com.sap.aii.mappingtool.tf7.rt.Container;
import com.sap.aii.mappingtool.tf7.rt.GlobalContainer;

public class ContainerTf7Impl implements Container{

	static {
		System.out.println("loaded by " + ContainerTf7Impl
				.class.getClassLoader().getClass().getName());
	}
	
	AbstractTrace _trace;
	protected Hashtable<NamedParameter, String> _inputMessageParameters;
	protected Hashtable<NamedParameter, String> _inputAdapterSpecificParameters ;
	protected Hashtable<String, String> _inputMappingParameters; 

	protected Hashtable<NamedParameter, String> _outputMessageParameters; 
	protected Hashtable<String, String> _outputMappingParameters; 
	
	private DynamicConfigurationImpl dynConf;
	private InputParametersImpl inputParameters;
	
	HashMap<String, Object> localContainerParameters = new HashMap<String, Object>();
	
	Container _this;
	
	public ContainerTf7Impl (AbstractTrace trace, 
			Hashtable<NamedParameter, String> inputMessageParameters,
			Hashtable<NamedParameter, String> inputAdapterSpecificParameters,
			Hashtable<String, String> inputMappingParameters,
			Hashtable<NamedParameter, String> outputMessageParameters,
			Hashtable<String, String> outputMappingParameters){
		_this = this;
		this._trace=trace;
		this._inputMessageParameters = inputMessageParameters;
		this._inputAdapterSpecificParameters = inputAdapterSpecificParameters;
		this._inputMappingParameters = inputMappingParameters;
		this._outputMessageParameters = outputMessageParameters;
		this._outputMappingParameters = outputMappingParameters;
		dynConf = new DynamicConfigurationImpl(_inputAdapterSpecificParameters);
		inputParameters = new InputParametersImpl(dynConf,_trace,inputMappingParameters);
	}
	
	public GlobalContainer getGlobalContainer(){
		GlobalContainer container = new GlobalContainer() {
			
			HashMap<String, Object> globalContainerParameters = new HashMap<String, Object>();
			
			public void setParameter(String key, Object value) {
				globalContainerParameters.put(key, value);
			}
			
			public AbstractTrace getTrace() {
				return _this.getTrace();
			}
			
			public Map getParameters() {
				return _this.getTransformationParameters();
			}
			
			public Object getParameter(String arg0) {
				return globalContainerParameters.get(arg0);
				
			}
			
			public OutputParameters getOutputParameters() {
				return _this.getOutputParameters();
			}
			
			public OutputHeader getOutputHeader() {
				return _this.getOutputHeader();
			}
			
			public OutputAttachments getOutputAttachments() {
				throw new UnsupportedOperationException();
			}
			
			public InputParameters getInputParameters() {
				return _this.getInputParameters();
			}
			
			public InputHeader getInputHeader() {
				return _this.getInputHeader();
			}
			
			public InputAttachments getInputAttachments() {
				throw new UnsupportedOperationException();
			}
			
			public void copyInputAttachments() {
				throw new UnsupportedOperationException();
			}
		};
		return container;
	}
	
	
	public InputHeader getInputHeader() {
		return new InputHeaderImpl(_inputMessageParameters);
	}

	public InputParameters getInputParameters() {
		
		return inputParameters;
	}

	public OutputHeader getOutputHeader() {
		
		return new OutputHeaderImpl(_outputMessageParameters);
	}

	public OutputParameters getOutputParameters() {
		return new OutputParametersImpl(_outputMappingParameters);
	}

	public Object getParameter(String arg0) {
		return localContainerParameters.get(arg0);
	}

	public AbstractTrace getTrace() {
		return _trace;
	}

	public void setTrace(AbstractTrace trace){
		this._trace = trace;
	}

	
	public Map getTransformationParameters() {
		TransformationParametersHelper trHelper = new TransformationParametersHelper(_inputMessageParameters,dynConf,this._trace);
		return trHelper.getMap();
	}

	public void setParameter(String key, Object value) {
		localContainerParameters.put(key, value);
	}

}
