package org.tech.tempservlettoo.queue;

/**
 *
 * 
 */
public interface MessageLoad<T> {
  void sendMessage(T message);  
  void sendMessageQueue(); 
}
