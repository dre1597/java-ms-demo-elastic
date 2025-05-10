package org.example.javamsdemoelastic.services;

import org.example.javamsdemoelastic.documents.MessageDocument;
import org.example.javamsdemoelastic.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MessageService {
  private final MessageRepository messageRepository;

  public MessageService(final MessageRepository messageRepository) {
    this.messageRepository = Objects.requireNonNull(messageRepository);
  }

  public Iterable<MessageDocument> findAll() {
    return messageRepository.findAll();
  }
}
