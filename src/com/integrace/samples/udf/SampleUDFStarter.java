package com.integrace.samples.udf;


import com.integrace.localtest.NamedParameter;
import com.integrace.localtest.RunConfigHelperUDF;

public class SampleUDFStarter {

	public static void main(String [] args){
		try {
		// init helper
			
			RunConfigHelperUDF _helper = new RunConfigHelperUDF();
		// set input/output queues
			_helper.addInput("inputNode",new String [] {"1","2","3"});
			_helper.addInput("defaultNode",new String [] {"1","2","3"});
			_helper.registerOutput("result");

			
		// set message params
			_helper.setInputMessageParameter(NamedParameter.MESSAGE_ID, NamedParameter.MESSAGE_ID.getGenerator().generate());
			_helper.setInputMessageParameter(NamedParameter.TIME_SENT, NamedParameter.TIME_SENT.getGenerator().generate());

		// set adapter specific params
			_helper.setInputMessageParameter(NamedParameter.FILE_FILENAME, "SomeTestData");
			
		// set general message mapping params
			
		// init UDF mapping
			SampleUDF sampleUDF = new SampleUDF();
			boolean runInit = true;
			if (runInit){
				sampleUDF.init(_helper.getGlobalContainer());
			}
			
			
			sampleUDF.mapNodeWithDefault((String [])_helper.getInput("inputNode"), (String [])_helper.getInput("defaultNode"), _helper.getOutput("result"), _helper.getContainer());
			
			
		// Write output to console (if necessary)
			
			System.out.print(_helper.getOutput("result").toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
