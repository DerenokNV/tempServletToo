package org.tech.tempservlettoo.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 *
 * 
 */
public class MessageProducer<T> implements MessageLoad<T>, Publisher<T> {
           
  private final List<Subscriber<T>> subscribers = new ArrayList<>();  
  private final Queue<String> numbers = new LinkedList<>();
  private boolean knifeSwitchOff = false;
  
  private static MessageProducer instance;
  
  private MessageProducer() {}
      
  public static MessageProducer getInstance(){ 
    if( instance == null ) {
       instance = new MessageProducer();
    }
    
    return instance;	
  }  
     
  public void sendQueueMessage( String message ) {
    numbers.add( message );
    if ( ! isKnifeSwitchOff() ) {
      sendMessageQueue();
    }  
  }
  
  @Override  
  public void addSubscriber(final Subscriber<T> subscriber) {  
    Objects.requireNonNull(subscriber, "subscriber must not be null");  
    subscribers.add(subscriber);  
  }  
  
  @Override  
  public void removeSubscriber(final Subscriber<T> subscriber) {  
    if (Objects.isNull(subscriber)) {  
      return;  
    }  
    subscribers.remove(subscriber);  
  }  
  
  @Override  
  public void notifySubscribers(final T message) {  
    if (Objects.isNull(message)) {  
      return;  
    }  
    subscribers.forEach(sub -> sub.receive(message));  
  }      
  
  @Override  
  public void sendMessage(T message) {  
    notifySubscribers(message);  
  }  
  
  @Override  
  public void sendMessageQueue() {
    // потоком....  
    if ( numbers.isEmpty() )  {
      return;
    }
    
    notifySubscribers( (T) numbers.poll() );
  }  
  
  public void sendMessageQueueIn() {
    while ( ! isKnifeSwitchOff() && ! numbers.isEmpty() ) {
      notifySubscribers( (T) numbers.poll() );
    }
        
  }  
    
  public boolean isKnifeSwitchOff() {
    return knifeSwitchOff;
  }
    
  public void setKnifeSwitchOff( boolean knifeSwitchOff ) {
    this.knifeSwitchOff = knifeSwitchOff;
    if ( ! knifeSwitchOff ) {
      sendMessageQueueIn();  
    }
  }
}