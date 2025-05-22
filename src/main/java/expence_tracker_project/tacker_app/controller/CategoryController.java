package expence_tracker_project.tacker_app.controller;


import expence_tracker_project.tacker_app.dto.CategoryDto;
import expence_tracker_project.tacker_app.mapper.CategoryMapper;
import expence_tracker_project.tacker_app.model.Category;
import expence_tracker_project.tacker_app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;


    // Create func for creating category with REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") UUID categoryId) {
        CategoryDto category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto> > getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories , HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") UUID categoryId,
                                                      @RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.updateCategory(categoryId, categoryDto);
        return new ResponseEntity<>(category , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable("id") UUID categoryId) {
        CategoryDto category = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(category , HttpStatus.OK );
    }
}
