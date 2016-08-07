package com.integrace.samples.javamapping;

import com.integrace.localtest.NamedParameter;
import com.integrace.localtest.ParameterClass;
import com.integrace.localtest.ParameterDirection;
import com.integrace.localtest.RunConfigHelperJM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



public class SampleMappingStarter {

	public static void main(String [] args){
		try {
		    // init helper

			RunConfigHelperJM _helper = new RunConfigHelperJM();
		    // set input/output files
			File input = new File("C:\\projects\\data\\test\\in.xml"); 
			_helper.setInputFile(new FileInputStream(input));
			_helper.setOutputFile(new FileOutputStream(new File("C:\\projects\\data\\test\\out.xml")));
			
		    // set message params
			_helper.setInputMessageParameter(NamedParameter.MESSAGE_ID, NamedParameter.MESSAGE_ID.getGenerator().generate());
			_helper.setInputMessageParameter(NamedParameter.TIME_SENT, NamedParameter.TIME_SENT.getGenerator().generate());



		    // set adapter specific params
			_helper.setInputMessageParameter(NamedParameter.FILE_FILENAME, NamedParameter.FILE_FILENAME.getGenerator().generate(input));
			
		    // set general message mapping params
            _helper.setInputMappingParameter("PARAM_IN1", "RootNode");

		    // init message mapping
			SampleMapping sampleMapping = new SampleMapping();
			sampleMapping.setHelper(_helper.getAbstractHelper());
			
		    // START OF TRANSFORMATION
			sampleMapping.transform(_helper.getInput(), _helper.getOutput());
            // FINISH OF TRANSFORMATION

			
		    // See output in out folder (if necessary)
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
