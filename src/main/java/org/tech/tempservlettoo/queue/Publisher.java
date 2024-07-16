package org.tech.tempservlettoo.queue;

/**
 * Интерфейс, описывающий контракт для публикации сообщения и оповещения подписчиков
 * 
 */
public interface  Publisher<T> {
    
  void addSubscriber(Subscriber<T> subscriber);  
  
  void removeSubscriber(Subscriber<T> subscriber);  
  
  void notifySubscribers(T message);    
}
