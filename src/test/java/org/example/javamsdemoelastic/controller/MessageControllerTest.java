package org.example.javamsdemoelastic.controller;

import org.example.javamsdemoelastic.documents.MessageDocument;
import org.example.javamsdemoelastic.services.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

  @Mock
  private MessageService service;

  @InjectMocks
  private MessageController controller;

  @Test
  void shouldReturnAllDocuments() {
    final var firstDocument = new MessageDocument("any_title", "any_message");
    final var secondDocument = new MessageDocument("other_title", "other_message");
    final var documents = List.of(firstDocument, secondDocument);

    when(service.findAll()).thenReturn(documents);

    final var result = controller.findAll();

    assertThat(result).containsExactlyElementsOf(documents);
    verify(service).findAll();
  }
}
