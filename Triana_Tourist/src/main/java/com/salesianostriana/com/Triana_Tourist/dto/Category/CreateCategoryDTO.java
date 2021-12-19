package com.salesianostriana.com.Triana_Tourist.dto.Category;

import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniqueCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDTO {

    @NotNull(message = "{category.name.null}")
    @NotBlank(message = "{category.name.empty}")
    @UniqueCategory
    private String name;
}
