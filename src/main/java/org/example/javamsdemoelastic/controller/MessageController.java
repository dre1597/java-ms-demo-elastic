package org.example.javamsdemoelastic.controller;

import org.example.javamsdemoelastic.documents.MessageDocument;
import org.example.javamsdemoelastic.services.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/messages")
public class MessageController {
  private final MessageService messageService;

  public MessageController(final MessageService messageService) {
    this.messageService = Objects.requireNonNull(messageService);
  }

  @GetMapping
  public Iterable<MessageDocument> findAll() {
    return messageService.findAll();
  }
}
