package org.example.javamsdemoelastic.services;

import org.example.javamsdemoelastic.documents.MessageDocument;
import org.example.javamsdemoelastic.dto.MessagePayload;
import org.example.javamsdemoelastic.repositories.MessageRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MessageConsumer {
  public static final String DEMO_QUEUE = "demo.queue";
  private final MessageRepository messageRepository;

  public MessageConsumer(final MessageRepository messageRepository) {
    this.messageRepository = Objects.requireNonNull(messageRepository);
  }

  @RabbitListener(queues = DEMO_QUEUE)
  public void receiveMessage(final MessagePayload payload) {
    System.out.printf("Received: title='%s', message='%s'%n", payload.title(), payload.message());

    final var document = new MessageDocument(payload.title(), payload.message());
    messageRepository.save(document);

    System.out.println("Message saved to Elasticsearch with ID: " + document.getId());
  }
}
