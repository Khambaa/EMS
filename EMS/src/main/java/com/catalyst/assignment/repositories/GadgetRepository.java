package com.catalyst.assignment.repositories;

import com.catalyst.assignment.entities.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget,Long> {
}
