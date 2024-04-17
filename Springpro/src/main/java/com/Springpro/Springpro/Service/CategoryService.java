package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Model.entity.CategoryModel;
import com.Springpro.Springpro.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryModel getCategoryById(Integer id) {
        Optional<CategoryModel> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(new CategoryModel());
    }

    public CategoryModel createCategory(CategoryModel category) {
        return categoryRepository.save(category);
    }
    public CategoryModel updateCategory(Integer id, CategoryModel category) {
        Optional<CategoryModel> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            category.setId(id);
            return categoryRepository.save(category);
        } else {
            return new CategoryModel();
        }
    }
    public CategoryModel partiallyUpdateCategory(Integer id, CategoryModel updatedCategory) {
        Optional<CategoryModel> optionalExistingCategory = categoryRepository.findById(id);
        if (optionalExistingCategory.isPresent()) {
            CategoryModel existingCategory = optionalExistingCategory.get();

            if (updatedCategory.getName() != null) {
                existingCategory.setName(updatedCategory.getName());
            }
            if (updatedCategory.getDescription() != null) {
                existingCategory.setDescription(updatedCategory.getDescription());
            }

            return categoryRepository.save(existingCategory);
        } else {
            return new CategoryModel();
        }
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
