package com.catalyst.assignment.repositories;

import com.catalyst.assignment.entities.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory,Long> {
}
