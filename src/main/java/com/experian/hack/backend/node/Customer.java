package com.experian.hack.backend.node;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
@Getter @Setter @Accessors(chain = true)
public class Customer {

    @Id @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;

    @Index(unique = true)
    private String email;

    @Relationship(type = "OWNS")
    private Set<Opportunity> opportunities = new HashSet<>();

    public void create(Opportunity opportunity) {
        opportunities.add(opportunity);
    }
}
