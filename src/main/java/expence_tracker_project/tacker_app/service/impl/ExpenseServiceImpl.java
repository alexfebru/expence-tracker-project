package expence_tracker_project.tacker_app.service.impl;

import expence_tracker_project.tacker_app.dto.ExpenseDto;
import expence_tracker_project.tacker_app.mapper.ExpenseMapper;
import expence_tracker_project.tacker_app.model.Category;
import expence_tracker_project.tacker_app.model.Expense;
import expence_tracker_project.tacker_app.repository.CategoryRepository;
import expence_tracker_project.tacker_app.repository.ExpenseRepository;
import expence_tracker_project.tacker_app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        // Convert ExpenseDto to ExpenseEntity
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);

        // Save ExpenseEntity to database
        Expense savedExpense = expenseRepository.save(expense);

        // Convert save ExpenseEntity into ExpenseDto
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(UUID expenseId) {
        Expense getExpenseById = expenseRepository
                .findById(expenseId)
                .orElseThrow(
                        () -> new RuntimeException("Expense not found with id " + expenseId)
                );
        return ExpenseMapper.mapToExpenseDto(getExpenseById);
    }


    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = (List<Expense>) expenseRepository.findAll();

        return expenses
                .stream()
                .map(ExpenseMapper::mapToExpenseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(UUID expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(
                () -> new RuntimeException("Expense not found with id " + expenseId)
        );

        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());
        if (expenseDto.categoryDto() != null) {
            Category category = categoryRepository
                    .findById(expenseDto.categoryDto().id())
                    .orElseThrow(
                        () -> new RuntimeException("Category not fount with id " + expenseDto.categoryDto().id())
            );

            expense.setCategory(category);
        }
        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto deleteExpenseById(UUID expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(
                () -> new RuntimeException("Expense not found with id " + expenseId)
        );

        expenseRepository.delete(expense);
        return ExpenseMapper.mapToExpenseDto(expense);
    }
}
