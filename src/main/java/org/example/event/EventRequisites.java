package org.example.event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventRequisites {
    private String externalId;
    private String client_id;
    private String name_company;
    private Long inn;
    private Integer kpp;
    private Long ogrn;
    private String business_address;
    private String address;
    private Integer rcbic;
    private Float corr_ass;
    private Float ass;
    private String bank_name;
}
