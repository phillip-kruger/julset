package com.github.phillipkruger.myapp;

import java.util.logging.Logger;

/**
 * Just some other class in the same package
 * @author Phillip Kruger (phillip.kruger@redhat.com)
 */
public class AnotherClass {
    private static final Logger log = Logger.getLogger(AnotherClass.class.getName());
            
    public void printSomeStuff(){
        log.info("Here a info message");
        log.warning("Here a warning message");
        log.severe("Here a severe message");
        log.fine("Here a fine message");
        log.finer("Here a finer message");
        log.finest("Here a finest message");    
    }
    
}
