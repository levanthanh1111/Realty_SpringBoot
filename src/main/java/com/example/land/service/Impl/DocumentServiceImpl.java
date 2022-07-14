package com.example.land.service.Impl;

import com.example.land.entity.Document;
import com.example.land.repository.DocumentRepository;
import com.example.land.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocument(Long id) {
        return documentRepository.getById(id);
    }

    @Override
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(Document document, Long id) {
            Document d = documentRepository.getById(id);
            d.setDisc(document.getDisc());
            return documentRepository.save(d);
    }

    @Override
    public Boolean deleteDocument(Long id) {
        documentRepository.deleteById(id);
        return true;
    }
}
