package com.project.store.repos;

import com.project.store.model.Category;
import com.project.store.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepo extends JpaRepository<Subcategory, Long> {

    @Override
    Subcategory getById(Long Id);
}
