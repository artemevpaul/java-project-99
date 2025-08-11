package hexlet.code.mapper;

import hexlet.code.dto.task.TaskCreateDTO;
import hexlet.code.dto.task.TaskDTO;
import hexlet.code.dto.task.TaskUpdateDTO;
import hexlet.code.model.Task;
import org.mapstruct.*;

@Mapper(
        uses = {JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class TaskMapper {
    @Mapping(target = "assignee", source = "assigneeId")
    public abstract Task map(TaskCreateDTO taskCreateDTO);

    @Mapping(source = "assignee.id", target = "assigneeId")
    public abstract TaskDTO map(Task task);

    @Mapping(target = "assignee", source = "assigneeId")
    public abstract Task map(TaskDTO taskDTO);

    @Mapping(target = "assignee", source = "assigneeId")
    public abstract void update(TaskUpdateDTO taskUpdateDTO, @MappingTarget Task task);
}