package com.integrace.localtest;

public enum UdfSpecialValues {

		SUPPRESS("_sUpPresSeD_"),
		CONTEXT_CHANGE("__cC_"),
		NULL("__nL_")
		;
		
		private String _value;
		
		public String getValue(){
			return this._value;
		}
		
		UdfSpecialValues(String value){
			this._value=value;
		}
		
		public static UdfSpecialValues findByValue(String value){
			if (value != null){
				UdfSpecialValues[] values = UdfSpecialValues.values();
				for (int i = 0; i < values.length; i++) {
					if (value.equals(values[i].toString())){
						return values[i];
					}
				}
			}
			return null;
		}
}
