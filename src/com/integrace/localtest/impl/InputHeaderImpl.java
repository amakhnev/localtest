package com.integrace.localtest.impl;

import java.util.Hashtable;
import java.util.Map;

import com.integrace.localtest.NamedParameter;
import com.sap.aii.mapping.api.InputHeader;

public class InputHeaderImpl extends InputHeader {
	
	
	
	private Hashtable<NamedParameter,String> params;
	
	protected InputHeaderImpl(){}
	
	public InputHeaderImpl(Hashtable<NamedParameter, String> inputMessageParameters){
		this.params = inputMessageParameters;
	}
	

	
	@Override
	public Object get(String arg0) {
		return getAll().get(arg0);
	}

	@Override
	public Map<String, Object> getAll() {
		Hashtable<String, Object> parameters = new Hashtable<String, Object>(); 
		
		for (NamedParameter nparam: params.keySet()){
			parameters.put(nparam.getName(), params.get(nparam));
		}
		
		return parameters;
	}

	@Override
	public String getConversationId() {
		return params.get(NamedParameter.CONVERSATION_ID);
	}

	@Override
	public String getInterface() {
		return params.get(NamedParameter.INTERFACE);
	}

	@Override
	public String getInterfaceNamespace() {
		return params.get(NamedParameter.INTERFACE_NAMESPACE);
	}

	@Override
	public String getMessageClass() {
		return params.get(NamedParameter.MESSAGE_CLASS);
	}

	@Override
	public String getMessageId() {
		return params.get(NamedParameter.MESSAGE_ID);
	}

	@Override
	public String getProcessingMode() {
		return params.get(NamedParameter.PROCESSING_MODE);
	}

	@Override
	public String getReceiverInterface() {
		return params.get(NamedParameter.RECEIVER_INTERFACE_NAME);
	}

	@Override
	public String getReceiverInterfaceNamespace() {
		return params.get(NamedParameter.RECEIVER_INTERFACE_NAMESPACE);
	}

	@Override
	public String getReceiverParty() {
		return params.get(NamedParameter.RECEIVER_PARTY);
	}

	@Override
	public String getReceiverPartyAgency() {
		return params.get(NamedParameter.RECEIVER_PARTY_AGENCY);
	}

	@Override
	public String getReceiverPartyScheme() {
		return params.get(NamedParameter.RECEIVER_PARTY_SCHEME);
	}

	@Override
	public String getReceiverService() {
		return params.get(NamedParameter.RECEIVER_SERVICE);
	}

	@Override
	public String getRefToMessageId() {
		return params.get(NamedParameter.REF_TO_MESSAGE_ID);
	}

	@Override
	public String getSenderInterface() {
		return params.get(NamedParameter.SENDER_INTERFACE_NAME);
	}

	@Override
	public String getSenderInterfaceNamespace() {
		return params.get(NamedParameter.SENDER_INTERFACE_NAMESPACE);
	}

	@Override
	public String getSenderParty() {
		return params.get(NamedParameter.SENDER_PARTY);
	}

	@Override
	public String getSenderPartyScheme() {
		return params.get(NamedParameter.SENDER_PARTY_SCHEME);
	}

	@Override
	public String getSenderParytAgency() {
		return params.get(NamedParameter.SENDER_PARTY_AGENCY);
	}

	@Override
	public String getSenderService() {
		return params.get(NamedParameter.SENDER_SERVICE);
	}

	@Override
	public String getTimeSent() {
		return params.get(NamedParameter.TIME_SENT);
	}

	@Override
	public String getVersionMajor() {
		return params.get(NamedParameter.VERSION_MAJOR);
	}

	@Override
	public String getVersionMinor() {
		return params.get(NamedParameter.VERSION_MINOR);
	}
}
