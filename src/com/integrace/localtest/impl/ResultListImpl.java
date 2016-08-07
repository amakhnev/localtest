package com.integrace.localtest.impl;

import java.util.ArrayList;
import java.util.Iterator;

import com.integrace.localtest.UdfSpecialValues;
import com.sap.aii.mappingtool.tf7.rt.ResultList;


public class ResultListImpl implements ResultList {

	ArrayList<String> al = new ArrayList<String>();
	
	public void addContextChange() {
		al.add(UdfSpecialValues.CONTEXT_CHANGE.getValue());
	}

	public void addSuppress() {
		al.add(UdfSpecialValues.SUPPRESS.getValue());
	}

	public void addValue(Object arg0) {
		if (arg0 instanceof String) {
			String arg0St = (String) arg0;
			al.add(arg0St);
		} else {
			al.add(arg0.toString());
//			throw new ClassCastException("Object "+arg0 + "is not of type String. This is a requirement for this implementation of ResultList.");
		}
		
	}

	public void clear() {
		al.clear();
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = al.iterator();

		sb.append("[");
		while (iter.hasNext()) {
			sb.append("{");
			sb.append(iter.next());
			sb.append("}");
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	public ArrayList<String> getResults(){
		return al;
	}
	
}
