package hexlet.code.dto.task;

import hexlet.code.model.TaskStatus;
import hexlet.code.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
public class TaskUpdateDTO {
    @NotBlank
    private JsonNullable<String> name;

    private JsonNullable<Integer> index;

    @NotBlank
    private JsonNullable<String> description;

    @NotBlank
    private JsonNullable<TaskStatus> taskStatus;

    private JsonNullable<Long> assigneeId;

}
