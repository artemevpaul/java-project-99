package hexlet.code.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {

    private long id;

    private Integer index;

    private String name;

    private String description;

    private String status;

    @JsonProperty("assignee_id")
    private Long assigneeId;

    private String createdAt;
}
