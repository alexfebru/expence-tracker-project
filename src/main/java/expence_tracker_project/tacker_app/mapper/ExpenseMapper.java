package expence_tracker_project.tacker_app.mapper;

import expence_tracker_project.tacker_app.dto.CategoryDto;
import expence_tracker_project.tacker_app.dto.ExpenseDto;
import expence_tracker_project.tacker_app.model.Category;
import expence_tracker_project.tacker_app.model.Expense;

public class ExpenseMapper {
    public static ExpenseDto mapToExpenseDto(Expense expense) {
        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }

    public static Expense mapToExpense(ExpenseDto expenseDto) {
        Category category = new Category();
        category.setId(expenseDto.id());

        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );

    }


}
