package expence_tracker_project.tacker_app.repository;

import expence_tracker_project.tacker_app.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {

}
