package expence_tracker_project.tacker_app.service.impl;

import expence_tracker_project.tacker_app.dto.CategoryDto;
import expence_tracker_project.tacker_app.mapper.CategoryMapper;
import expence_tracker_project.tacker_app.model.Category;
import expence_tracker_project.tacker_app.repository.CategoryRepository;
import expence_tracker_project.tacker_app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        // Convert CategoryDto to Category-Entity
        Category category = CategoryMapper.mapToCategory(categoryDto);

        // Save category objects into database table = categories
        Category saveCategory = categoryRepository.save(category);

        // Convert saveCategory to categoryDto
        return CategoryMapper.mapToCategoryDto(saveCategory);
    }

    @Override
    public CategoryDto getCategoryById(UUID categoryId) {
        Category getCategoryById = categoryRepository
                .findById(categoryId)
                .orElseThrow(
                        ()-> new RuntimeException("Category not found with id: " + categoryId));

        return CategoryMapper.mapToCategoryDto(getCategoryById);

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();

        return categories
                .stream()
                .map((category) -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());

    }

    @Override
    public CategoryDto updateCategory(UUID categoryId, CategoryDto categoryDto) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(
                    ()-> new RuntimeException("Category not found with id: " + categoryId)
        );

        category.setName(categoryDto.name());
        Category saveCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(saveCategory);
    }

    @Override
    public CategoryDto deleteCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()-> new RuntimeException("Category not found with id: " + categoryId)
        );

        categoryRepository.delete(category);
        return CategoryMapper.mapToCategoryDto(category);
    }


}
