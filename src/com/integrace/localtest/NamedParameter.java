package com.integrace.localtest;

public enum NamedParameter {

	MESSAGE_ID("http://sap.com/xi/XI","MessageId", ParameterClass.SYSTEM,new MessageIDGenerator()),
	CONVERSATION_ID("http://sap.com/xi/XI","ConversationId",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	INTERFACE("http://sap.com/xi/XI","Interface",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	INTERFACE_NAMESPACE("http://sap.com/xi/XI","InterfaceNamespace",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	MESSAGE_CLASS("http://sap.com/xi/XI","MessageClass",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	PROCESSING_MODE("http://sap.com/xi/XI","ProcessingMode",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	RECEIVER_INTERFACE_NAME("http://sap.com/xi/XI","ReceiverName",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	RECEIVER_INTERFACE_NAMESPACE("http://sap.com/xi/XI","ReceiverNamespace",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	SENDER_INTERFACE_NAME("http://sap.com/xi/XI","SenderName",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	SENDER_INTERFACE_NAMESPACE("http://sap.com/xi/XI","SenderNamespace",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	RECEIVER_PARTY("http://sap.com/xi/XI","ReceiverParty",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	RECEIVER_PARTY_AGENCY("http://sap.com/xi/XI","ReceiverPartyAgency",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	RECEIVER_PARTY_SCHEME("http://sap.com/xi/XI","ReceiverPartyScheme",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	RECEIVER_SERVICE("http://sap.com/xi/XI","ReceiverService",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	REF_TO_MESSAGE_ID("http://sap.com/xi/XI","RefToMessageId",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	SENDER_PARTY("http://sap.com/xi/XI","SenderParty",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	SENDER_PARTY_AGENCY("http://sap.com/xi/XI","SenderPartyAgency",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	SENDER_PARTY_SCHEME("http://sap.com/xi/XI","SenderPartyScheme",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	SENDER_SERVICE("http://sap.com/xi/XI","SenderService",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	TIME_SENT("http://sap.com/xi/XI","TimeSent",ParameterClass.SYSTEM,new TimeSentGenerator()),
	VERSION_MAJOR("http://sap.com/xi/XI","VersionMajor",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	VERSION_MINOR("http://sap.com/xi/XI","VersionMinor",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),

	
	CONTENT_TYPE("http://sap.com/xi/XI","ContentType",ParameterClass.SYSTEM,ParameterDirection.INPUT_OUTPUT),
	DIRECTION("http://sap.com/xi/XI","Direction",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	DIRECTION_FAULT("http://sap.com/xi/XI","Fault",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	DIRECTION_REQUEST("http://sap.com/xi/XI","Request",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	DIRECTION_RESPONSE("http://sap.com/xi/XI","Response",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	RECEIVER_SYSTEM("http://sap.com/xi/XI","ReceiverSystem",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	SENDER_SYSTEM("http://sap.com/xi/XI","SenderSystem",ParameterClass.SYSTEM,ParameterDirection.INPUT_ONLY),
	
	
	
	
	/* FILE ADAPTER */
	
	FILE_FILENAME		("http://sap.com/xi/XI/System/File","FileName",ParameterClass.FILE,new FileAttGenerator(FileAttGenerator.AttributeName.FileName)),
	FILE_DIRECTORY		("http://sap.com/xi/XI/System/File","Directory",ParameterClass.FILE,new FileAttGenerator(FileAttGenerator.AttributeName.Directory)),
	FILE_FILETYPE		("http://sap.com/xi/XI/System/File","FileType",ParameterClass.FILE,new FileAttGenerator(FileAttGenerator.AttributeName.FileType)),
	FILE_FILEENC		("http://sap.com/xi/XI/System/File","FileEncoding",ParameterClass.FILE,new FileAttGenerator(FileAttGenerator.AttributeName.FileEncoding)),
	FILE_SOURCEFILESIZE	("http://sap.com/xi/XI/System/File","SourceFileSize",ParameterClass.FILE,new FileAttGenerator(FileAttGenerator.AttributeName.SourceFileSize),ParameterDirection.INPUT_ONLY),
	FILE_SOURCEFILETIMESTAMP("http://sap.com/xi/XI/System/File","SourceFileTimeStamp",ParameterClass.FILE,new FileAttGenerator(FileAttGenerator.AttributeName.SourceFileTimeStamp),ParameterDirection.INPUT_ONLY),
	FILE_SOURCEFTPHOST	("http://sap.com/xi/XI/System/File","SourceFTPHost",ParameterClass.FILE,ParameterDirection.INPUT_ONLY),

	
	FILE_TARGETTEMPFILENAME("http://sap.com/xi/XI/System/File","TargetTempFileName",ParameterClass.FILE,ParameterDirection.OUTPUT_ONLY),
	
	/* RFC ADAPTER */
	
	RFC_DESTINATION		("http://sap.com/xi/XI/System/RFC","RfcDestination",ParameterClass.RFC,ParameterDirection.INPUT_ONLY),

	
	/* HTTP ADAPTER */
	
	HTTP_HEADER1		("http://sap.com/xi/XI/System/HTTP","HeaderFieldOne",ParameterClass.HTTP),
	HTTP_HEADER2		("http://sap.com/xi/XI/System/HTTP","HeaderFieldTwo",ParameterClass.HTTP),
	HTTP_HEADER3		("http://sap.com/xi/XI/System/HTTP","HeaderFieldThree",ParameterClass.HTTP),
	HTTP_HEADER4		("http://sap.com/xi/XI/System/HTTP","HeaderFieldFour",ParameterClass.HTTP),
	HTTP_HEADER5		("http://sap.com/xi/XI/System/HTTP","HeaderFieldFive",ParameterClass.HTTP),
	HTTP_HEADER6		("http://sap.com/xi/XI/System/HTTP","HeaderFieldSix",ParameterClass.HTTP),
	HTTP_URLPARAM1		("http://sap.com/xi/XI/System/HTTP","URLParamOne",ParameterClass.HTTP),
	HTTP_URLPARAM2		("http://sap.com/xi/XI/System/HTTP","URLParamTwo",ParameterClass.HTTP),
	HTTP_URLPARAM3		("http://sap.com/xi/XI/System/HTTP","URLParamThree",ParameterClass.HTTP),
	HTTP_URLPARAM4		("http://sap.com/xi/XI/System/HTTP","URLParamFour",ParameterClass.HTTP),
	HTTP_URLPARAM5		("http://sap.com/xi/XI/System/HTTP","URLParamFive",ParameterClass.HTTP),
	HTTP_URLPARAM6		("http://sap.com/xi/XI/System/HTTP","URLParamSix",ParameterClass.HTTP),

	HTTP_TARGETURL		("http://sap.com/xi/XI/System/HTTP","TargetURL",ParameterClass.HTTP,ParameterDirection.OUTPUT_ONLY),
	HTTP_HTTPDEST		("http://sap.com/xi/XI/System/HTTP","HTTPDest",ParameterClass.HTTP,ParameterDirection.OUTPUT_ONLY),
	
	CUSTOM("","",ParameterClass.CUSTOM)
	;
	
	
	
	private String name;
	private String namespace;
	private ParameterClass parameterClass;
	private boolean generatable;
	private INamedParameterGenerator generator;
	
	private ParameterDirection direction;
	
	
	
	private NamedParameter (String name, String namespace, ParameterClass parameterClass, INamedParameterGenerator generator, ParameterDirection direction) {
		this.name = name;
		this.namespace = namespace;
		this.parameterClass = parameterClass;
		this.generator = generator;
		this.direction = direction;
	}
	
	private NamedParameter (String name, String namespace, ParameterClass parameterClass, ParameterDirection direction) {
		this(name,namespace,parameterClass,null,direction);
	}
	private NamedParameter (String name, String namespace, ParameterClass parameterClass, INamedParameterGenerator generator) {
		this(name,namespace,parameterClass,generator,ParameterDirection.INPUT_OUTPUT);
	}

	private NamedParameter (String name, String namespace, ParameterClass parameterClass) {
		this(name,namespace,parameterClass,null,ParameterDirection.INPUT_OUTPUT);
	}

	
	public String getName() {
		return name;
	}
	
	public String getNamespace() {
		return namespace;
	}
	
	
	public ParameterClass getParameterClass() {
		return parameterClass;
	}
	
	
	public boolean isGeneratable() {
		return generatable;
	}

	public ParameterDirection getDirection() {
		return direction;
	}
	
		
	public INamedParameterGenerator getGenerator() {
		return generator;
	}

	public static NamedParameter customNamedParameter(String name, String namespace, ParameterClass parameterClass, boolean generatable, ParameterDirection direction){
		NamedParameter _instance = NamedParameter.CUSTOM;
		_instance.name = name;
		_instance.namespace = namespace;
		_instance.parameterClass = parameterClass;
		_instance.generatable= generatable;
		_instance.direction = direction;
		return _instance;
	}

	public static NamedParameter customNamedParameter(String name, String namespace, ParameterClass parameterClass,  ParameterDirection direction){
		return customNamedParameter( name,  namespace,  parameterClass,false,  direction);
	}
	
	
	
}
