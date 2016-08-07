package com.integrace.localtest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSentGenerator implements INamedParameterGenerator {

	public String generate(Object... args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
		return sdf.format(new Date());
	}

}
