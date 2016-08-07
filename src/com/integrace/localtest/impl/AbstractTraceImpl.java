package com.integrace.localtest.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.aii.mapping.api.AbstractTrace;

public class AbstractTraceImpl extends AbstractTrace {

	public static enum TRACE_TYPE {INFO, WARNING};
	
	public List<TraceMessage> messages = new ArrayList<TraceMessage>(); 
		
	
	@Override
	public void addInfo(String arg0) {
		messages.add(new TraceMessage(TRACE_TYPE.INFO, arg0));
	}

	@Override
	public void addWarning(String arg0) {
		messages.add(new TraceMessage(TRACE_TYPE.WARNING, arg0));
	}
	
    public String getTrace() {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<messages.size(); i++){
            sb.append(messages.get(i).type+":"+messages.get(i).message);
            if (i!=messages.size()-1){
            	sb.append("\n");
            }
            
        }
        return sb.toString();
    }

	public class TraceMessage{
		private TRACE_TYPE type;
		private String message;
		protected TraceMessage(){}
		public TraceMessage(TRACE_TYPE type, String message){
			this.type = type;
			this.message = message;
		}
		
	}
	
}

