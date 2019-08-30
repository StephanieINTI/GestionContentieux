package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Document;
import com.inti.service.interfaces.IDocumentService;


@Service
@Transactional
public class DocumentService extends ManagerService<Document> implements IDocumentService{

}
