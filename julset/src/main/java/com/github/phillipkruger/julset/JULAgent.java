package com.github.phillipkruger.julset;

import java.lang.instrument.Instrumentation;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Agent that can set log levels on startup
 * @author Phillip Kruger (phillip.kruger@redhat.com)
 */
public class JULAgent {
    
    private static final String IDENTIFIER = "jul.";
    
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        Properties properties = System.getProperties();
        for(Map.Entry<Object, Object> property:properties.entrySet()){
            String key = (String)property.getKey();
            
            if(key.startsWith(IDENTIFIER)){
                String loggerName = key.substring(4);
                String value = (String)property.getValue();
                
                java.util.logging.Level level = java.util.logging.Level.parse(value);
                
                setLoggerLevel(loggerName,level);
                
                LogManager manager = LogManager.getLogManager();
                Enumeration<String> names = manager.getLoggerNames();
                while(names.hasMoreElements()){
                    String current = names.nextElement();
                    if(current.equals(loggerName) || current.startsWith(loggerName+DOT)){
                        setLoggerLevel(current, level);
                    }
                }
            }
        }
    }
    
    private static void setLoggerLevel(String loggerName, Level level){
        Logger logger = Logger.getLogger(loggerName);
        logger.setLevel(level);
        
        if(logger.getHandlers().length==0){
            logger.addHandler(new ConsoleHandler());
        }
        
        Handler[] handlers = logger.getHandlers();
        for(Handler handler:handlers){
            handler.setLevel(level);
        }
    }
    
    private static final String DOT=".";
}
