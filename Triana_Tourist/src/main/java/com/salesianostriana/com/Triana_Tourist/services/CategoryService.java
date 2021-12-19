package com.salesianostriana.com.Triana_Tourist.services;

import com.salesianostriana.com.Triana_Tourist.dto.Category.CategoryDTOConverter;
import com.salesianostriana.com.Triana_Tourist.dto.Category.CreateCategoryDTO;
import com.salesianostriana.com.Triana_Tourist.dto.Category.GetCategoryDTO;
import com.salesianostriana.com.Triana_Tourist.error.tiposErrores.EntityNotFoundException;
import com.salesianostriana.com.Triana_Tourist.error.tiposErrores.ListEntityNotFoundException;
import com.salesianostriana.com.Triana_Tourist.model.Category;
import com.salesianostriana.com.Triana_Tourist.repositories.CategoryRepository;
import com.salesianostriana.com.Triana_Tourist.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService extends BaseService<Category, Long, CategoryRepository> {

    private final CategoryRepository repository;
    private final CategoryDTOConverter dtoConverter;

    public List<Category> findAll() throws ListEntityNotFoundException {

        List<Category> lista = repository.findAll();

        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }
        else {
            return lista;
        }
    }

    public Category findOne(Long id) throws EntityNotFoundException{

        Optional<Category> category = repository.findById(id);

        if (category.isEmpty()){
            throw new EntityNotFoundException(id, Category.class);
        }
        else  {
            return category.get();
        }
    }

    public Category addCategory(CreateCategoryDTO c) {

        Category category = dtoConverter.createCategory(c);

        repository.save(category);

        return category;
    }

    public Category editCategory(GetCategoryDTO c, Long id) {

        Optional<Category> category = repository.findById(id);

        if(category.isEmpty()){
            throw new EntityNotFoundException(id, Category.class);
        }

        return category.map(ct -> {
                    ct.setName(c.getName());
                    repository.save(ct);
                    return ct;
                }).get();


    }

    public void delete(Long id){

        Optional<Category> category = repository.findById(id);

        if(category.isEmpty()){
            throw new EntityNotFoundException(id, Category.class);
        }

        repository.delete(category.get());

    }

}
