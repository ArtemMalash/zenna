package com.project.store.repos;

import com.project.store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Override
    Category getById(Long Id);
}
