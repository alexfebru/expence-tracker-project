package expence_tracker_project.tacker_app.mapper;

import expence_tracker_project.tacker_app.dto.CategoryDto;
import expence_tracker_project.tacker_app.model.Category;

public class CategoryMapper {

    // Map CategoryDto to Category-Entity
    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }

    // Map Category-Entity to CategoryDto
    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }
}
