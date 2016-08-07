package com.integrace.localtest;

import java.util.Hashtable;

import com.integrace.localtest.impl.ResultListImpl;
import com.sap.aii.mappingtool.tf7.rt.ResultList;

public class RunConfigHelperUDF extends RunConfigHelper{

	private Hashtable<String, Object> input = new Hashtable<String, Object> ();
	private Hashtable<String,ResultList> output = new Hashtable<String,ResultList>();
	
	public void addInput(String name, Object obj){
		input.put(name, obj);
	}
	
	public void registerOutput(String name){
		output.put(name, new ResultListImpl());
	}
	
	public ResultList getOutput(String name){
		return output.get(name);
	}

	public Object getInput(String name){
		return input.get(name);
	}
	

}
