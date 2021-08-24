package com.nelson.aluraflix.controller;

import com.nelson.aluraflix.DTO.CategoryDTO;
import com.nelson.aluraflix.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAllCategories() {

        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findCategryById(@PathVariable Integer id) {

        return ResponseEntity.ok(categoryService.findCategoryById(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {

        return ResponseEntity.ok(categoryService.saveCategory(categoryDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody @Valid CategoryDTO categoryDTO) {

        return ResponseEntity.ok(categoryService.updateCategory(categoryDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Integer id) {

        categoryService.deleteCategoryById(id);
    }
}
