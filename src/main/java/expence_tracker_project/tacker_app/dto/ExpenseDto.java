package expence_tracker_project.tacker_app.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ExpenseDto(UUID id,
                         BigDecimal amount,
                         LocalDateTime expenseDate,
                         CategoryDto category) {
}
