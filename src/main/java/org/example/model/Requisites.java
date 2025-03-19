package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Requisites {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CCustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id",updatable = false, nullable = false)
    private UUID id;
    @Column(name = "external_id", nullable = false,length = 50)
    private String externalId;
    @Column(name = "client_id",nullable = false,length = 20)
    private String client_id;
    @Column(name = "name_company", nullable = false,length = 50)
    private String name_company;
    @Column(name = "inn", nullable = false)
    private Long inn;
    @Column(name = "kpp", nullable = false)
    private Integer kpp;
    @Column(name = "ogrn", nullable = false)
    private Long ogrn;
    @Column(name = "business_address", nullable = false, length = 100)
    private String business_address;
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "rcbic", nullable = false)
    private Integer rcbic;
    @Column(name = "corr_ass", nullable = false)
    private Float corr_ass;
    @Column(name = "ass",nullable = false)
    private Float ass;
    @Column(name = "bank_name",nullable = false,length = 50)
    private String bank_name;
    @Column(name = "created_time")
    private Date created;
    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
    @Column(name = "updated_time")
    private Date updated;
    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}


