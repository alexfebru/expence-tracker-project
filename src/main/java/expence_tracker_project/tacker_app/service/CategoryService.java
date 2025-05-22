package expence_tracker_project.tacker_app.service;


import expence_tracker_project.tacker_app.dto.CategoryDto;

import java.util.List;
import java.util.UUID;


public interface CategoryService {
    CategoryDto createCategory(CategoryDto category);
    CategoryDto getCategoryById(UUID categoryId);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(UUID categoryId, CategoryDto category);
    CategoryDto deleteCategory(UUID categoryId);
}
