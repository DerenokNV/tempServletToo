package org.tech.tempservlettoo.queue;

/**
 * Интерфейс, задача которого - получать сообщения
 * 
 */
public interface  Subscriber<T> {
  void receive(T message);  
}
