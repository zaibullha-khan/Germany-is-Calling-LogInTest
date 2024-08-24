package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
	public class logs {
		// Initialize Log4j logs
			//public static Logger Log = Logger.getLogger(LogBaseClass.class.getName());
			//static Logger Log= LogManager.getLogger(Log.class.getName());
			static Logger Log= LogManager.getLogger(logs.class);
			public static void startTestCase(String sTestCaseName){		  
				 Log.info("====================================="+sTestCaseName+" TEST START=========================================");
				 }
			
			public static void endTestCase(String sTestCaseName){
				Log.info("====================================="+sTestCaseName+" TEST END=========================================");
				 }
			
			// Need to create below methods, so that they can be called  

			 public static void info(String message) {

					Log.info(message);

					}

			 public static void warn(String message) {

			    Log.warn(message);

				}

			 public static void error(String message) {

			    Log.error(message);

				}

			 public static void fatal(String message) {

			    Log.fatal(message);

				}

			 public static void debug(String message) {

			    Log.debug(message);

				}
	}

