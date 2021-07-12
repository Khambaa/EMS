package com.catalyst.assignment.repositories;

import com.catalyst.assignment.entities.AccessoryCategory;
import com.catalyst.assignment.entities.GadgetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryCategoryRepository extends JpaRepository<AccessoryCategory,Long> {

}
