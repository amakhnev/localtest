package com.integrace.localtest.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

import com.sap.aii.mapping.api.Attachment;
import com.sap.aii.mapping.api.InputAttachments;

public class InputAttachmentsImpl implements InputAttachments {
	
	Hashtable <String, Attachment> _attachments = new Hashtable <String, Attachment>();
	
	InputAttachmentsImpl(){
		
	}
	
	boolean addAttachment(Attachment attachment){
		if (attachment==null || _attachments.containsKey(attachment.getContentId())){
			return false;
		}
		_attachments.put(attachment.getContentId(), attachment);
		return true;
	}
	
	
	public boolean areAttachmentsAvailable() {
		return !_attachments.isEmpty();
	}

	public Collection<String> getAllContentIds(boolean arg0) {
		return Collections.list(_attachments.keys());
	}

	public Attachment getAttachment(String arg0) {
		return _attachments.get(arg0);
	}
	
	

}
