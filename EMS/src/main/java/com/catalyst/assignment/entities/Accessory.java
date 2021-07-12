package com.catalyst.assignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accessories")
@Getter
@Setter
@NoArgsConstructor
public class Accessory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="accessory_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private AccessoryCategory category;

    @ManyToMany(mappedBy = "accessories",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Gadget> gadgets=new HashSet<Gadget>();


    public Accessory(Integer id) {
        this.id= new Long(id);
    }
}
