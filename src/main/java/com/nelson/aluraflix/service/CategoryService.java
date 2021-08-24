package com.nelson.aluraflix.service;

import com.nelson.aluraflix.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> findAll();

    CategoryDTO findCategoryById(Integer id);

    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO);

    void deleteCategoryById(Integer id);
}
