package com.integrace.localtest;

import java.io.File;

public class FileAttGenerator implements INamedParameterGenerator {

	public enum AttributeName{
		FileName,
		Directory,
		FileType,
		FileEncoding,
		SourceFileSize,
		SourceFileTimeStamp
	};
	
	private AttributeName attName;
	
	public String generate(Object... args) {
		String result = "";
		
		if (args==null || args.length==0){
			return null;
		}
		
		Object param = args[0]; 
		
		if (param == null || !(param instanceof File)){
			return null;
		}
		
		File source = (File) param;
		
		if (attName == AttributeName.FileName){
			result = source.getName();
		}
		
		return result;
	}
	
	public FileAttGenerator(AttributeName attName){
		this.attName = attName;
	}

}
