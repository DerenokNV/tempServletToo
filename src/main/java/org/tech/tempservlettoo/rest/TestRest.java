package org.tech.tempservlettoo.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/person")
public class TestRest {
    
  private static final Logger logger = LogManager.getLogger(TestRest.class);  
    
  @GET  
  @Path("/test")
  public Response testMethod() {      
    logger.info( "BBBBBBBBBBBBBBBBBBBBBBBB" );
    
    Integer d = 900;
      
    return Response
            .status( Response.Status.OK )
            .entity( "TEST" )
            .build();  
  }  
  
  @POST  
  @Path("/test2")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response upload() { 
     
      
     return Response
            .status( Response.Status.OK )
            .entity( "UPLOAD" )
            .build();  
  }
  
    
  @POST  
    @Path("/upload")  
    @Consumes(MediaType.MULTIPART_FORM_DATA)  //C:\Web\Tomcat9\data
    public Response uploadFile(  
            @FormDataParam("file") InputStream uploadedInputStream,  
            @FormDataParam("file") FormDataContentDisposition fileDetail) {  
            String fileLocation = "c://Web/Tomcat9/data" + fileDetail.getFileName();  
                    //saving file  
            try {  
                FileOutputStream out = new FileOutputStream(new File(fileLocation));  
                int read = 0;  
                byte[] bytes = new byte[1024];  
                out = new FileOutputStream(new File(fileLocation));  
                while ((read = uploadedInputStream.read(bytes)) != -1) {  
                    out.write(bytes, 0, read);  
                }  
                out.flush();  
                out.close();  
            } catch (IOException e) {e.printStackTrace();}  
            String output = "File successfully uploaded to : " + fileLocation;  
            return Response.status(200).entity(output).build();  
        }   
   
    
}
