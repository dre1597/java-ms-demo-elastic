package org.example.javamsdemoelastic.controller;

import org.example.javamsdemoelastic.documents.MessageDocument;
import org.example.javamsdemoelastic.services.MessageService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public Iterable<MessageDocument> findAll(
      @RequestParam(required = false, defaultValue = "") final String title,
      @RequestParam(required = false, defaultValue = "0") final int page,
      @RequestParam(required = false, defaultValue = "10") final int size
  ) {
    final var pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
    return messageService.findAll(title, pageable);
  }
}
