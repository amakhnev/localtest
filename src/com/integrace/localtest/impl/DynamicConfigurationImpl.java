package com.integrace.localtest.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import com.integrace.localtest.NamedParameter;
import com.sap.aii.mapping.api.DynamicConfiguration;
import com.sap.aii.mapping.api.DynamicConfigurationKey;

public class DynamicConfigurationImpl extends DynamicConfiguration {
	private Hashtable<DynamicConfigurationKey, String> conf = new Hashtable<DynamicConfigurationKey, String>();
	
	private DynamicConfigurationImpl(){}
	
	public DynamicConfigurationImpl(Hashtable<NamedParameter, String> dynamicParams){
		this();
		for (NamedParameter nparam: dynamicParams.keySet()){
			put(DynamicConfigurationKey.create(nparam.getNamespace(), nparam.getName()),dynamicParams.get(nparam));
		}
	
	}
	
	
	
	@Override
	public boolean containsKey(DynamicConfigurationKey arg0) {
		return conf.containsKey(arg0);
	}

	@Override
	public String get(DynamicConfigurationKey arg0) {
		return conf.get(arg0);
	}

	@Override
	public Iterator getKeys() {
		ArrayList<DynamicConfigurationKey> result = new ArrayList<DynamicConfigurationKey>();
		for (Enumeration<DynamicConfigurationKey> keysEnum= conf.keys(); keysEnum.hasMoreElements();) {
			DynamicConfigurationKey key = keysEnum.nextElement();
			result.add(key);
		}
		return  result.iterator();
	}

	@Override
	public Iterator getKeys(String arg0) {
		ArrayList<DynamicConfigurationKey>  result = new ArrayList<DynamicConfigurationKey>();
		for (Enumeration<DynamicConfigurationKey> keysEnum= conf.keys(); keysEnum.hasMoreElements();) {
			DynamicConfigurationKey key = keysEnum.nextElement();
			if (key.getNamespace().equals(arg0)){
				result.add(key);
			}
		}
		return  result.iterator();

	}

	
	@Override
	public String put(DynamicConfigurationKey key, String value) {
		return conf.put(key, value);
	}

	@Override
	public String remove(DynamicConfigurationKey key) {
		return conf.remove(key);
	}

	@Override
	public void removeAll() {
		conf.clear();
	}

	@Override
	public void removeNamespace(String arg0) {
		for (Iterator keys = getKeys(arg0); keys.hasNext();) {
			DynamicConfigurationKey key = (DynamicConfigurationKey) keys.next();
			conf.remove(key);
		}
	}

	@Override
	public int size() {
		return conf.size();
	}

	@Override
	public int size(String arg0) {
		int result = 0;
		for (Enumeration<DynamicConfigurationKey> keysEnum= conf.keys(); keysEnum.hasMoreElements();) {
			DynamicConfigurationKey key = keysEnum.nextElement();
			if (key.getNamespace().equals(arg0)){
				result++;
			}
		}
		return result;
	}
	


	
}
