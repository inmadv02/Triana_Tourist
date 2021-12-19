package com.salesianostriana.com.Triana_Tourist.controller;

import com.salesianostriana.com.Triana_Tourist.dto.Category.CreateCategoryDTO;
import com.salesianostriana.com.Triana_Tourist.dto.Category.GetCategoryDTO;
import com.salesianostriana.com.Triana_Tourist.model.Category;
import com.salesianostriana.com.Triana_Tourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> todasLasCategorias(){

        List<Category> categories = categoryService.findAll();

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> unaCategoria(@PathVariable Long id){

        Category category = categoryService.findOne(id);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/")
    public ResponseEntity<CreateCategoryDTO> nuevaCategoria (@Valid @RequestBody CreateCategoryDTO dto){

        categoryService.addCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetCategoryDTO> editarCategoria(@Valid @RequestBody GetCategoryDTO dto, @PathVariable Long id){

        categoryService.editCategory(dto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarCategoria(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
