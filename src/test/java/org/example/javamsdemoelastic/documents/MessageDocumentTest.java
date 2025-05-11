package org.example.javamsdemoelastic.documents;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MessageDocumentTest {
  @Test
  void shouldCreateWithConstructorAndAutoSetTimestamp() {
    final var title = "any_title";
    final var message = "any_message";
    final var before = Instant.now();

    final var document = new MessageDocument(title, message);

    assertThat(document.getTitle()).isEqualTo(title);
    assertThat(document.getMessage()).isEqualTo(message);
    assertThat(document.getTimestamp()).isAfterOrEqualTo(before);
  }

  @Test
  void shouldSetAndGetAllFields() {
    final var document = new MessageDocument();
    final var id = "any_id";
    final var title = "any_title";
    final var message = "any_message";
    final var timestamp = Instant.now();

    document.setId(id);
    document.setTitle(title);
    document.setMessage(message);
    document.setTimestamp(timestamp);

    assertThat(document.getId()).isEqualTo(id);
    assertThat(document.getTitle()).isEqualTo(title);
    assertThat(document.getMessage()).isEqualTo(message);
    assertThat(document.getTimestamp()).isEqualTo(timestamp);
  }
}
