package org.tech.tempservlettoo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/person")
public class TestRest {
    
  private static final Logger logger = LogManager.getLogger(TestRest.class);  
    
  @GET  
  public Response testMethod() {
      
    logger.info( "BBBBBBBBBBBBBBBBBBBBBBBB" );
    
    Integer d = 900;
    
      
    return Response
            .status( Response.Status.OK )
            .entity( "TEST" )
            .build();  
  }  
    
  
  /*
  catalina.bat = set "JDPA_JAVA=-agentlib:jdwp=transport=dt_socket,server=y,address=*:8000,suspend=n"
set "JAVA_OPTS=%JAVA_OPTS% %JDPA_JAVA%" 
 
  */
    
}
