package com.catalyst.assignment.repositories;

import com.catalyst.assignment.entities.GadgetCategory;
import com.catalyst.assignment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetCategoryRepository extends JpaRepository<GadgetCategory,Long> {

}
