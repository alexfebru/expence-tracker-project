package expence_tracker_project.tacker_app.service;

import expence_tracker_project.tacker_app.dto.ExpenseDto;

import java.util.List;
import java.util.UUID;

public interface ExpenseService {
    ExpenseDto createExpense(ExpenseDto expenseDto);
    ExpenseDto getExpenseById(UUID expenseId);
    List<ExpenseDto> getAllExpenses();
    ExpenseDto updateExpense(UUID expenseId ,ExpenseDto expenseDto);
    ExpenseDto deleteExpenseById(UUID expenseId);

}
