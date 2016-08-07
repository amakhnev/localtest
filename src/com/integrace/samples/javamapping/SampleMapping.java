package com.integrace.samples.javamapping;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.sap.aii.mapping.api.AbstractTransformation;
import com.sap.aii.mapping.api.DynamicConfiguration;
import com.sap.aii.mapping.api.DynamicConfigurationKey;
import com.sap.aii.mapping.api.InputHeader;
import com.sap.aii.mapping.api.StreamTransformationException;
import com.sap.aii.mapping.api.TransformationInput;
import com.sap.aii.mapping.api.TransformationOutput;

public class SampleMapping extends AbstractTransformation {

	// 2. DynamicConfigurationKey denotes an adapter specific message attribute.
	// It consists of a name and a namespace
	// class associated is com.sap.aii.mapping.api.DynamicConfigurationKey
	private static final DynamicConfigurationKey KEY_FILENAME = DynamicConfigurationKey
			.create("http://sap.com/xi/XI/System/File", "FileName");

	// 3. Each JAVA Mapping using program 7.1 API must implement the method
	// transform(TransformationInput in, TransformationOutput out)
	// as oppose to execute Method in earlier version.
	public void transform(TransformationInput trInput, TransformationOutput trOutput)
			throws StreamTransformationException {
		
		// 4. An info message is added to trace. An instance of trace of object
		// is obtained by calling
		// the getTrace method of class AbstractTransformation
		getTrace().addInfo("JAVA Mapping Called");
		
		// 5. Input payload is obtained by using
		// arg0.getInputPayload().getInputStream()
		String inData = convertStreamToString(trInput.getInputPayload()
				.getInputStream());
		
		// 6. Input parameter is read using from the TransformationInput class
		// using method
		// arg0.getInputParameters().getString("<Parameter Name>"). This
		// Parameter name should be same as interface mapping
		String inParam = trInput.getInputParameters().getString("PARAM_IN1");
		getTrace().addInfo("Input Parameter: " + inParam);
		int offset = inData.indexOf(inParam);
		
		// 7. Reader Message ID from Message Header
		InputHeader messageHeader = trInput.getInputHeader();
		String messageId = messageHeader.getMessageId();
		
		// 8. A DynamicConfiguration is a map containing adapter specific
		// message attributes.
		// It associates DynamicConfigurationKeys with string values. The
		// DynamicConfiguration object is obtained using
		// method getDynamicConfiguration()of class
		// com.sap.aii.mapping.api.TransformationInput;
		DynamicConfiguration conf = trInput.getDynamicConfiguration();
		String filename = conf.get(KEY_FILENAME);
		
		conf.put(KEY_FILENAME, "testoutputfor_"+filename);
		
		
		// you can transform input as you like
		String outData = inData;
		if (offset > 0) {
			int offset1 = inData.indexOf(">", offset);
			String StartString = inData.substring(0, offset1);
			String messageIdString = " message_id=\""+messageId+"\"";
			String RemainingString = inData.substring(offset1);
			outData = StartString + messageIdString + RemainingString;
		}
		
		try {
			// 9. The JAVA mapping output payload is returned using the
			// TransformationOutput class
		
			trOutput.getOutputPayload().getOutputStream().write(
					outData.getBytes("UTF-8"));
		} catch (Exception exception1) {
		}
	}

	public String convertStreamToString(InputStream in) {
		StringBuffer sb = new StringBuffer();
		try {
			InputStreamReader isr = new InputStreamReader(in);
			Reader reader = new BufferedReader(isr);
			int ch;
			while ((ch = in.read()) > -1) {
				sb.append((char) ch);
			}
			reader.close();
		} catch (Exception exception) {
		}
		return sb.toString();
	}

}