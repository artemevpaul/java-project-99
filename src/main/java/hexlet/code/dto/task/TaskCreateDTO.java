package hexlet.code.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import hexlet.code.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
public class TaskCreateDTO {

    @NotBlank
    private String name;

    private Integer index;

    private String description;

    @NotNull
    private TaskStatus taskStatus;

    @JsonProperty("assignee_id")
    private JsonNullable<Long> assigneeId;
}
