package com.salesianostriana.com.Triana_Tourist.dto.Category;

import com.salesianostriana.com.Triana_Tourist.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOConverter {

    public Category createCategory(CreateCategoryDTO c){
        return new Category(c.getName());
    }

    public GetCategoryDTO categoryTOCategoryDTO(Category c){
        return GetCategoryDTO
                .builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }

}
