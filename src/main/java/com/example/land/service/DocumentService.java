package com.example.land.service;

import com.example.land.entity.Document;

import java.util.List;

public interface DocumentService {
    List<Document> getAll();
    Document getDocument(Long id);
    Document createDocument(Document document);
    Document updateDocument(Document document, Long id);
    Boolean deleteDocument(Long id);
}
