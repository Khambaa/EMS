package com.catalyst.assignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "gadgets")
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Gadget {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="gadget_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "make")
    private String make;

    @Column(name = "quantity")
    private Integer quantity;

    @Transient
    List<Integer> accessoryIds=new ArrayList<Integer>();

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private GadgetCategory gadgetCategory;


    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.LAZY)
    @JoinTable(
            name = "gadgets_accessories",
            joinColumns = { @JoinColumn(name = "gadget_id") },
            inverseJoinColumns = { @JoinColumn(name = "accessory_id") }
    )
    private Set<Accessory> accessories=new HashSet<Accessory>();
}
