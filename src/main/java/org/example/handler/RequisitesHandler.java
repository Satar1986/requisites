package org.example.handler;

import org.example.event.EventRequisites;
import org.example.model.Requisites;
import org.example.repository.RequisitesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@KafkaListener(topics = "Account_requisites")
public class RequisitesHandler {
private final Logger logger = LoggerFactory.getLogger(RequisitesHandler.class);
private RequisitesRepository requisitesRepository;
public RequisitesHandler(RequisitesRepository requisitesRepository) {
    this.requisitesRepository = requisitesRepository;
}
@Transactional
@KafkaHandler
public void handle(@Payload EventRequisites eventRequisites,
                   @Header("externalId")String externalId) {
logger.info("Received event: {}", eventRequisites.getExternalId());
Requisites requisites = requisitesRepository.findByExternalId(externalId);
if (requisites != null) {
logger.info("Duplicate transaction:{}", eventRequisites.getExternalId());
return;
}
try {
requisitesRepository.save(Requisites.builder().
        externalId(eventRequisites.getExternalId()).
        client_id(eventRequisites.getClient_id()).
        name_company(eventRequisites.getName_company()).
        inn(eventRequisites.getInn()).
        kpp(eventRequisites.getKpp()).
        ogrn(eventRequisites.getOgrn()).
        business_address(eventRequisites.getBusiness_address()).
        address(eventRequisites.getAddress()).
        rcbic(eventRequisites.getRcbic()).
        corr_ass(eventRequisites.getCorr_ass()).
        ass(eventRequisites.getAss()).
        bank_name(eventRequisites.getBank_name()).
        build());
}catch (Exception e) {
    logger.error(e.getMessage());}
}
}
