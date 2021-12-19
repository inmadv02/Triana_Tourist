package com.salesianostriana.com.Triana_Tourist.repositories;

import com.salesianostriana.com.Triana_Tourist.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);
}
