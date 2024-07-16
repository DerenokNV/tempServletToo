package org.tech.tempservlettoo.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  1. Парсер от него
 *  2. Запись в БД в таблицы Message
 */
public class MessageCustomer<T> implements Subscriber<T> {
    
  private static final Logger logger = LogManager.getLogger(MessageCustomer.class);      
    
  public MessageCustomer(){      
  }
    
    
  @Override  
  public void receive( T message ) {  
    logger.info( "user '" + "dsf" + "' received message: " + message );  
    System.out.println("user '" + "dsf" + "' received message: " + message);  
  }     
}
