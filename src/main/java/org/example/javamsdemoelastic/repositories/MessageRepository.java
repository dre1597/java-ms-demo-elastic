package org.example.javamsdemoelastic.repositories;

import org.example.javamsdemoelastic.documents.MessageDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MessageRepository extends ElasticsearchRepository<MessageDocument, String> {
}
