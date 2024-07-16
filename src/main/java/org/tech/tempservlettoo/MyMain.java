package org.tech.tempservlettoo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tech.tempservlettoo.queue.MessageCustomer;

import org.tech.tempservlettoo.queue.MessageProducer;
import org.tech.tempservlettoo.rest.TestRest;

/**
 *
 
 */
public class MyMain {
    
  private static final Logger logger = LogManager.getLogger(TestRest.class);   
        
  public static void main( String[] avgr ) {
    
    System.out.println("vvv");  
    
    var chatRoom = MessageProducer.getInstance(); 
    
    MessageCustomer alice = new MessageCustomer<String>();  
    chatRoom.addSubscriber( alice );
    MessageCustomer bob = new MessageCustomer<String>(); 
    chatRoom.addSubscriber( bob );
    MessageCustomer charlie = new MessageCustomer<String>();
    chatRoom.addSubscriber( charlie );
    
    chatRoom.sendMessage("Hello, everyone!");  
  
    chatRoom.removeSubscriber(bob);  
  
    chatRoom.sendMessage("Goodbye, Bob!");  
  
    chatRoom.removeSubscriber(charlie);  
  
    chatRoom.sendMessage("Goodbye, Charlie!");
    
    chatRoom.sendMessage("Hello, everyone!");  
    
  } 
    
}
