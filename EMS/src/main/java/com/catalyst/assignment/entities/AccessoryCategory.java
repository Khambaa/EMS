package com.catalyst.assignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="accessory_category")
@Getter
@Setter
@NoArgsConstructor
public class AccessoryCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="accessory_category_id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Accessory> accessories=new HashSet<Accessory>();
}
