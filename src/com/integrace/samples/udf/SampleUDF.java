package com.integrace.samples.udf;

import com.sap.aii.mapping.api.StreamTransformationException;
import com.sap.aii.mappingtool.tf7.rt.Container;
import com.sap.aii.mappingtool.tf7.rt.GlobalContainer;
import com.sap.aii.mappingtool.tf7.rt.ResultList;

public class SampleUDF {
	
	// beginning of attributes and methods 72418d956989a1e71aecbea9d5a90ecf

	// end of attributes and methods 72418d956989a1e71aecbea9d5a90ecf



	  public void init(GlobalContainer container) throws StreamTransformationException{
	  // beginning of init f2bfdf97b7d432d057584464aabdb643

	  // end of init f2bfdf97b7d432d057584464aabdb643
	  }


	  public void cleanUp(GlobalContainer container) throws StreamTransformationException{
	  // beginning of cleanUp 7e26d344ee3a9ad7648ebff5b3eb584b
	  
	  // end of cleanUp 7e26d344ee3a9ad7648ebff5b3eb584b
	  }
	
	public void mapNodeWithDefault(String [] inputNode,String [] defaultNode,ResultList result, Container container) throws StreamTransformationException{
		boolean useDefault = true;
		for (int i=0;useDefault&&i<inputNode.length;i++){
			String value =inputNode[i]; 
			if (value.equals("")){
				useDefault = false;
			}
		}
		String [] resultStr = useDefault?defaultNode:inputNode;
		for (int i=0;i<resultStr.length;i++){
			if (resultStr[i].equals(ResultList.CC)){
				result.addContextChange();
			}else 
			if (resultStr[i].equals(ResultList.SUPPRESS)){
				result.addSuppress();
			}else{
				result.addValue(resultStr[i]);
			}

		}
		
	}
	
	
}
