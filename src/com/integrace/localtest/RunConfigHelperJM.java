package com.integrace.localtest;

import java.io.InputStream;
import java.io.OutputStream;

import com.integrace.localtest.impl.TransformationInputImpl;
import com.integrace.localtest.impl.TransformationOutputImpl;
import com.sap.aii.mapping.api.TransformationInput;
import com.sap.aii.mapping.api.TransformationOutput;

public class RunConfigHelperJM extends RunConfigHelper{

	private InputStream input;
	private OutputStream output;
	
	public void setInputFile(InputStream input){
		this.input = input;
	}
	
	public void setOutputFile(OutputStream output){
		this.output = output;
	}
	
	
	public TransformationInput getInput(){
		TransformationInputImpl tInput = new TransformationInputImpl(input, inputMessageParameters, adapterSpecificParameters, inputMappingParameters,_trace);
		
		return tInput;
	}
	public TransformationOutput getOutput(){
		return new TransformationOutputImpl(output,outputMessageParameters,outputMappingParameters);
	}
		
}
