package org.example.javamsdemoelastic.controller;

import org.example.javamsdemoelastic.documents.MessageDocument;
import org.example.javamsdemoelastic.services.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
  void shouldReturnAllDocumentsFilteredByTitleAndPaginated() {
    final var firstDocument = new MessageDocument("any_title", "any_message");
    final var secondDocument = new MessageDocument("other_title", "other_message");
    final var documents = List.of(firstDocument, secondDocument);

    final var title = "any";
    final var page = 1;
    final var size = 5;
    final var pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());

    when(service.findAll(title, pageable)).thenReturn(documents);

    final var result = controller.findAll(title, page, size);

    assertThat(result).containsExactlyElementsOf(documents);
    verify(service).findAll(title, pageable);
  }
}
