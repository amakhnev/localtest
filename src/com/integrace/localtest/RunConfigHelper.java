package com.integrace.localtest;

import java.io.InputStream;
import java.util.Hashtable;

import com.integrace.localtest.impl.AbstractTraceImpl;
import org.xml.sax.EntityResolver;

import com.integrace.localtest.impl.ContainerTf7Impl;
import com.sap.aii.mapping.api.AbstractHelper;
import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mappingtool.tf7.rt.Container;
import com.sap.aii.mappingtool.tf7.rt.GlobalContainer;

public class RunConfigHelper {

	protected AbstractTrace _trace = new AbstractTraceImpl();
	
	protected Hashtable<NamedParameter, String> inputMessageParameters = new Hashtable<NamedParameter, String>(); 
	protected Hashtable<NamedParameter, String> adapterSpecificParameters = new Hashtable<NamedParameter, String>(); 
	protected Hashtable<String, String> inputMappingParameters = new Hashtable<String, String>(); 

	protected Hashtable<NamedParameter, String> outputMessageParameters = new Hashtable<NamedParameter, String>(); 
	protected Hashtable<String, String> outputMappingParameters = new Hashtable<String, String>(); 
	
	protected ContainerTf7Impl _container;
	
	
	public void setInputMessageParameter(NamedParameter param, String value ){
		inputMessageParameters.put(param, value);
	}
	
	public void setInputAdapterSpecificParameter(NamedParameter param, String value ){
		adapterSpecificParameters.put(param, value);
	}
	
	public void setInputMappingParameter(String name, String value ){
		inputMappingParameters.put(name, value);		
	}

	public Container getContainer(){
		if (_container == null){
			_container = new ContainerTf7Impl(_trace,
					inputMessageParameters,adapterSpecificParameters,inputMappingParameters,
					outputMessageParameters,outputMappingParameters);
		}
		return _container;
	}
	public Hashtable<NamedParameter,String> getInputMessageParameters(){
		return inputMessageParameters;
	}
	public Hashtable<NamedParameter,String> getOutputMessageParameters(){
		return outputMessageParameters;
	}
	public Hashtable<String,String> getOutputMappingParameters(){
		return outputMappingParameters;
	}
	public Hashtable<NamedParameter,String> getAdapterSpecificParameters(){
		return adapterSpecificParameters;
	}
	
	public AbstractHelper getAbstractHelper(){
		
		AbstractHelper _helper = new AbstractHelper() {
			@Override
			public AbstractTrace getTrace() {
				return _trace;
			}
			
			@Override
			public InputStream getResourceAsStream(String arg0) {
				throw new RuntimeException("Method getResourceAsStream is not implemented.");
			}
			
			@Override
			public EntityResolver getEntityResolver() {
				throw new RuntimeException("Method getEntityResolver is not implemented.");
			}
		};
		return _helper;
	}
	
	
	public GlobalContainer getGlobalContainer(){
		return getContainer().getGlobalContainer();
	}
	

}
