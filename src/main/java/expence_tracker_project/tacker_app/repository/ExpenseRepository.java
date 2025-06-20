package expence_tracker_project.tacker_app.repository;


import expence_tracker_project.tacker_app.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

}
