package com.testenv.utils;

public interface FileConstants extends ObjectConstants
{

	String TEST_HOME 			= System.getProperty("test.home", "./");

	String RESOURCES_HOME 		= TEST_HOME + "resources/";

	String OBJ_PROPERTIES 		= RESOURCES_HOME + "object.properties";

	String SERVER_PROPERTIES 	= RESOURCES_HOME + "server.properties";

}
