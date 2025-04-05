package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.ClientReq;
import org.example.model.Requisites;
import org.example.repository.ClientReqRepository;
import org.example.repository.RequisitesRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequisitesTransaction {
    private final ClientReqRepository clientReqRepository;
    private final RequisitesRepository requisitesRepository;
public List<Requisites> readAll() {
    return requisitesRepository.findAll();
}
public Requisites readById(String id) {
 return requisitesRepository.findByExternalId(id);
}
public Requisites savedRequisites(Requisites requisites, Integer id) {
    return requisitesRepository.save(requisites.setClientReq(clientReqRepository.findById(id).orElseThrow(()->
            new RuntimeException("Not found" + id))));
}

@EntityGraph(type = EntityGraph.EntityGraphType.FETCH,value = "client_entity-graph")
public List<ClientReq> readAllClient() {
     return clientReqRepository.findAll();
}
public ClientReq readClientReqById(Integer id) {
        return clientReqRepository.findById(id).orElse(null);
    }
}
