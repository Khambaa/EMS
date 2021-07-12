package com.catalyst.assignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="gadget_category")
@Getter
@Setter
@NoArgsConstructor
public class GadgetCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="gadget_category_id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "gadgetCategory")
    @JsonIgnore
    private Set<Gadget> gadgets=new HashSet<Gadget>();
}
