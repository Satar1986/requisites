package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.event.EventRequisites;
import org.example.model.Requisites;
import org.example.repository.RequisitesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequisitesService {
 private final RequisitesRepository requisitesRepository;
public List<Requisites> readAll() {
    return requisitesRepository.findAll();
}
public Requisites readById(String id) {
 return requisitesRepository.findByExternalId(id);
}
}
