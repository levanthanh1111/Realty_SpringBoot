package com.example.land.controller;

import com.example.land.dto.DocumentDTO;
import com.example.land.entity.Document;
import com.example.land.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/document")
public class DocumentController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    DocumentService documentService;

    @GetMapping("")
    public List<DocumentDTO>getAll(){
        return documentService.getAll().stream().map(document -> modelMapper.map(document,DocumentDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getDocument(@PathVariable("id") Long id){
        Document document = documentService.getDocument(id);
        DocumentDTO documentDTO = modelMapper.map(document, DocumentDTO.class);

        return ResponseEntity.ok().body(documentDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<DocumentDTO> createDocument(@RequestBody DocumentDTO documentDTO){
        Document documentRequest = modelMapper.map(documentDTO, Document.class);
        Document document = documentService.createDocument(documentRequest);
        DocumentDTO documentResponse = modelMapper.map(document, DocumentDTO.class);
        return new ResponseEntity<DocumentDTO>(documentResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DocumentDTO> updateDocument(@RequestBody DocumentDTO documentDTO,@PathVariable("id") Long id){
        Document documentRequest = modelMapper.map(documentDTO, Document.class);
        Document document = documentService.updateDocument(documentRequest,id);
        DocumentDTO documentResponse = modelMapper.map(document, DocumentDTO.class);
        return ResponseEntity.ok().body(documentResponse);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteDocument(@PathVariable("id") Long id){
        return documentService.deleteDocument(id);
    }
}
