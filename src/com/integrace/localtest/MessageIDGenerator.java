package com.integrace.localtest;

import java.util.UUID;

public class MessageIDGenerator implements INamedParameterGenerator {

	public String generate(Object... args) {
		return UUID.randomUUID().toString().toUpperCase();
	}

}
