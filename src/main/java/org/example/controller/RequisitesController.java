package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Requisites;
import org.example.service.RequisitesTransaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/requisites")
public class RequisitesController {
    private final RequisitesTransaction requisitesService;
@GetMapping
    public ResponseEntity<List<Requisites>> getRequisites() {
    return new ResponseEntity<>(requisitesService.readAll(), HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<Requisites> getRequisitesById(@PathVariable String id) {
    return new ResponseEntity<>(requisitesService.readById(id), HttpStatus.OK);
}
}
