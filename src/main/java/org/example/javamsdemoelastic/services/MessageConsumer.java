package org.example.javamsdemoelastic.services;

import org.example.javamsdemoelastic.dto.MessagePayload;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
  public static final String DEMO_QUEUE = "demo.queue";

  @RabbitListener(queues = DEMO_QUEUE)
  public void receiveMessage(final MessagePayload payload) {
    System.out.printf("Received: title='%s', message='%s'%n", payload.title(), payload.message());
  }
}
