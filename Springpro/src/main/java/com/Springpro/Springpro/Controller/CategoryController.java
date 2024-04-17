package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Model.entity.CategoryModel;
import com.Springpro.Springpro.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        List<CategoryModel> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/ById")
    public ResponseEntity<CategoryModel> getCategoryById(@RequestParam Integer id) {
        CategoryModel category = categoryService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel category) {
        CategoryModel createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @PutMapping("/updateById")
    public ResponseEntity<CategoryModel> updateCategory(@RequestParam Integer id, @RequestBody CategoryModel category) {
        CategoryModel updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/partiallyUpdatedCategory")
    public ResponseEntity<CategoryModel> partiallyUpdateCategory(@RequestParam Integer id, @RequestBody CategoryModel categoryUpdates) {
        CategoryModel updatedCategory = categoryService.partiallyUpdateCategory(id, categoryUpdates);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
