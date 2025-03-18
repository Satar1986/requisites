package org.example.handler;

import lombok.RequiredArgsConstructor;
import org.example.event.EventRequisites;

import org.example.service.RequisitesProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequisitesHandler {
private final Logger logger = LoggerFactory.getLogger(RequisitesHandler.class);
private final RequisitesProcessService requisitesProcessService;
@KafkaListener(topics = "Account_requisites")
public void handle(@Payload EventRequisites eventRequisites,
                   @Header("externalId")String externalId) {
logger.info("Received event: {}", eventRequisites.getExternalId());

try {
requisitesProcessService.processRequisites(eventRequisites);
}catch (Exception e) {
    logger.error(e.getMessage());}
}
}
