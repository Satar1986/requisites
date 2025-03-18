package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.event.EventRequisites;
import org.example.model.Requisites;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequisitesProcessService {
    private final RequisitesTransaction requisitesTransaction;
public void processRequisites(EventRequisites eventRequisites) {
 Requisites requisites=requisitesTransaction.readById(eventRequisites.getExternalId());
     if (requisites!=null) {
          requisites.setClient_id(eventRequisites.getClient_id());
          requisites.setExternalId(eventRequisites.getExternalId());
          requisites.setAddress(eventRequisites.getAddress());
          requisites.setBusiness_address(eventRequisites.getBusiness_address());
          requisites.setAss(eventRequisites.getAss());
          requisites.setCorr_ass(eventRequisites.getCorr_ass());
          requisites.setBank_name(eventRequisites.getBank_name());
          requisites.setKpp(eventRequisites.getKpp());
          requisites.setInn(eventRequisites.getInn());
          requisites.setOgrn(eventRequisites.getOgrn());
          requisites.setRcbic(eventRequisites.getRcbic());
          requisites.setName_company(eventRequisites.getName_company());
Requisites savedRequisites = requisitesTransaction.savedRequisites(requisites);
return;
}
     Requisites requisites1=Requisites.builder().
             client_id(eventRequisites.getClient_id()).
             externalId(eventRequisites.getExternalId()).
             address(eventRequisites.getAddress()).
             business_address(eventRequisites.getBusiness_address()).
             ass(eventRequisites.getAss()).
             corr_ass(eventRequisites.getCorr_ass()).
             bank_name(eventRequisites.getBank_name()).
             kpp(eventRequisites.getKpp()).
             inn(eventRequisites.getInn()).
             ogrn(eventRequisites.getOgrn()).
             rcbic(eventRequisites.getRcbic()).
             name_company(eventRequisites.getName_company()).build();
     Requisites savedRequisites=requisitesTransaction.savedRequisites(requisites1);

}
}
