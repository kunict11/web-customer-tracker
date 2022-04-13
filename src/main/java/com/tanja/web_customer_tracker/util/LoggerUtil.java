package com.tanja.web_customer_tracker.util;

import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {

	private final static Logger LOGGER = Logger.getLogger(LoggerUtil.class.getName());
	private String rootLoggerLevel;
	private String parentLoggerLevel;
	
	public void setRootLoggerLevel(String rootLoggerLevel) {
		this.rootLoggerLevel = rootLoggerLevel;
	}

	public void setParentLoggerLevel(String parentLoggerLevel) {
		this.parentLoggerLevel = parentLoggerLevel;
	}
	
	public void initLogger() {
		  
		ConsoleHandler handler = new ConsoleHandler();
		
		handler.setFormatter(setupFormatter());
		
		Level rootLevel = Level.parse(rootLoggerLevel);
		Level parentLevel = Level.parse(parentLoggerLevel);
		
		Logger loggerParent = LOGGER.getParent();
		handler.setLevel(rootLevel);

		loggerParent.setLevel(parentLevel);
		LOGGER.setUseParentHandlers(true);
		
		LOGGER.addHandler(handler);
		loggerParent.addHandler(handler);
		
	}
	
	private SimpleFormatter setupFormatter() {
		return new SimpleFormatter() {
		
		String format = "%1$tF %1$tT [%2$-1s] (%3$-1s) %4$s %n";
		@Override
		public String formatMessage(LogRecord record) {
			return String.format(format,
					new Date(record.getMillis()),
					record.getLevel().getName(),
					record.getSourceClassName(),
					record.getMessage()
					);
			}
		};
	}
	
}
