package com.github.phillipkruger.myapp;

import java.util.logging.Logger;

/**
 * Just some application
 * @author Phillip Kruger (phillip.kruger@redhat.com)
 */
public class MyApplication {
    private static final Logger log = Logger.getLogger(MyApplication.class.getName());
            
    private AnotherClass anotherClass = new AnotherClass();
            
    public void printSomeStuff(){
        log.info("Here a info message");
        log.warning("Here a warning message");
        log.severe("Here a severe message");
        log.fine("Here a fine message");
        log.finer("Here a finer message");
        log.finest("Here a finest message");
        
        anotherClass.printSomeStuff();
    }
    
    public static void main(String[] args) {
        MyApplication myApplication = new MyApplication();
        myApplication.printSomeStuff();
    }
}
