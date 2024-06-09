package org.tech.tempservlettoo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tech.tempservlettoo.rest.TestRest;

/**
 *
 
 */
public class MyMain {
    
  private static final Logger logger = LogManager.getLogger(TestRest.class);   
        
  public static void main( String[] avgr ) {
    logger.info( "BBBBBBBBBBBBBBBBBBBBBBBB" );  
    System.out.println("vvv");  
    Integer t = 9;
    Integer d = t + 9;
    
    System.out.println(" vvv = " + d ); 
  } 
    
}
