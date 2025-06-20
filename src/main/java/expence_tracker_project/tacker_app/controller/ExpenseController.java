package expence_tracker_project.tacker_app.controller;


import expence_tracker_project.tacker_app.dto.ExpenseDto;
import expence_tracker_project.tacker_app.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto expense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") UUID id) {
        ExpenseDto expense = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpenseById(@PathVariable("id") UUID id, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto expense = expenseService.updateExpense(id, expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ExpenseDto> deleteExpenseById(@PathVariable("id") UUID id) {
        ExpenseDto expense = expenseService.deleteExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }
}
