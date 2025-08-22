package hexlet.code.specification;

import hexlet.code.dto.TaskParamsDTO;
import hexlet.code.model.Task;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TaskSpecification {

    public Specification<Task> build(TaskParamsDTO params) {

        return withTitleCont(params.getTitleCont())
                .and(withAssigneeId(params.getAssigneeId()))
                .and(withStatus(params.getStatus()))
                .and(withLabelId(params.getLabelId()));
    }

    private Specification<Task> withTitleCont(String titleCont) {
        return ((root, query, cb) ->
                titleCont == null ? cb.conjunction() : cb.like(cb.lower(root.get("name")),
                        "%" + titleCont.toLowerCase() + "%"));
    }

    private Specification<Task> withAssigneeId(Long assigneeId) {
        return ((root, query, cb) ->
                assigneeId == null ? cb.conjunction() : cb.equal(root.get("assignee").get("id"), assigneeId));
    }

    private Specification<Task> withStatus(String status) {
        return (root, query, cb) -> {
            if (status == null || status.isBlank()) {
                return cb.conjunction();
            }
            var statusJoin = root.join("taskStatus");
            return cb.equal(cb.lower(statusJoin.get("slug")), status.toLowerCase());
        };
    }

    private Specification<Task> withLabelId(Long labelId) {
        return (root, query, cb) ->
                labelId == null ? cb.conjunction() : cb.equal(root.join("labels").get("id"), labelId);
    }

}
