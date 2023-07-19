package com.solitera.assignment.Repository;

import com.solitera.assignment.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepostiory extends JpaRepository<SubCategory,Integer> {
    Optional<SubCategory> findAllById(int id);
}
