package org.example.javamsdemoelastic.services;

import org.example.javamsdemoelastic.documents.MessageDocument;
import org.example.javamsdemoelastic.dto.MessagePayload;
import org.example.javamsdemoelastic.repositories.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessageConsumerTest {
  @Mock
  private MessageRepository repository;

  @InjectMocks
  private MessageConsumer consumer;

  @Test
  void shouldSaveDocumentWhenMessageIsReceived() {
    final var payload = new MessagePayload("any_title", "any_message");

    consumer.receiveMessage(payload);

    final var captor = ArgumentCaptor.forClass(MessageDocument.class);
    verify(repository).save(captor.capture());

    final var document = captor.getValue();
    assertThat(document.getTitle()).isEqualTo("any_title");
    assertThat(document.getMessage()).isEqualTo("any_message");
    assertThat(document.getTimestamp()).isNotNull();
  }
}
