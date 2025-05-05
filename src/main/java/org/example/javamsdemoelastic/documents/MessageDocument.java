package org.example.javamsdemoelastic.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Document(indexName = "messages")
public class MessageDocument {
  @Id
  private String id;

  @Field(type = FieldType.Text)
  private String title;

  @Field(type = FieldType.Text)
  private String message;

  @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second)
  private Instant timestamp;

  public MessageDocument() {
  }

  public MessageDocument(String title, String message) {
    this.title = title;
    this.message = message;
    this.timestamp = Instant.now();
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public Instant getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(final Instant timestamp) {
    this.timestamp = timestamp;
  }
}
