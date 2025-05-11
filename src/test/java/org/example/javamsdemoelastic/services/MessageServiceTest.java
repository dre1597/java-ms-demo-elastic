package org.example.javamsdemoelastic.services;

import org.example.javamsdemoelastic.documents.MessageDocument;
import org.example.javamsdemoelastic.repositories.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {
  @Mock
  private MessageRepository repository;

  @InjectMocks
  private MessageService service;

  @Test
  void shouldReturnAllDocumentsFilteredByTitle() {
    final var firstDocument = new MessageDocument("any_title", "any_message");
    final var secondDocument = new MessageDocument("other_title", "other_message");
    final var documents = new PageImpl<>(List.of(firstDocument, secondDocument));

    final var title = "any";
    final var pageable = PageRequest.of(0, 10);

    when(repository.findAllByTitleContainingIgnoreCase(title, pageable)).thenReturn(documents);

    final var result = service.findAll(title, pageable);

    assertThat(result).containsExactlyElementsOf(documents);
    verify(repository).findAllByTitleContainingIgnoreCase(title, pageable);
  }
}
