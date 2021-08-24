package com.nelson.aluraflix.service.serviceImpl;

import com.nelson.aluraflix.DTO.CategoryDTO;
import com.nelson.aluraflix.entity.Category;
import com.nelson.aluraflix.repository.CategoryRepository;
import com.nelson.aluraflix.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    CategoryRepository repository;

    @Override
    public List<CategoryDTO> findAll() {

        List<Category> categories = repository.findAll();

        return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findCategoryById(Integer id) {

        Category category = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        return convertToDTO(category);
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {

        Category category = convertToEntity(categoryDTO);

        Category categorySaved = this.repository.save(category);

        return convertToDTO(categorySaved);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {

        Category category = this.repository.findById(categoryDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada para atualização"));

        category.setTitle(categoryDTO.getTitle());
        category.setColor(categoryDTO.getColor());

        Category categoryUpdated = this.repository.save(category);

        return convertToDTO(categoryUpdated);
    }

    @Override
    public void deleteCategoryById(Integer id) {

        this.repository.deleteById(id);

    }

    public CategoryDTO convertToDTO(Category category) {

        return this.modelMapper.map(category, CategoryDTO.class);
    }

    public Category convertToEntity(CategoryDTO categoryDTO) {

        return this.modelMapper.map(categoryDTO, Category.class);
    }
}
