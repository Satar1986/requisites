package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;


@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Builder
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraph(name = "client_entity-graph",attributeNodes = @NamedAttributeNode("requisitesList"))
public class ClientReq {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name",nullable = false,length = 50)
    private String name;
    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "clientReq")
    private List<Requisites> requisitesList;
}
