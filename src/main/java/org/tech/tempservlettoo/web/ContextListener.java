
package org.tech.tempservlettoo.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tech.tempservlettoo.rest.TestRest;

/**
 *
 * @author Nataly
 */
public class ContextListener implements ServletContextListener {
    
  private static final Logger logger = LogManager.getLogger(TestRest.class);    
    
  @Override
  public void contextInitialized( ServletContextEvent event ) {
    logger.info( "START WEB APPLICATION" );  
    
    // Get servlet context
    ServletContext context = event.getServletContext();

    // Retrieve name
    String name = context.getServletContextName();

    // Log servlet init information
    logger.info("Start \"{}\"", name);
    
  } 
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    logger.info( "STOP WEB APPLICATION" );  
        
  }      
}
