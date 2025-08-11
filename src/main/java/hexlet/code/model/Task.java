package hexlet.code.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tasks")
@ToString(includeFieldNames = true, onlyExplicitlyIncluded = true)
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    private Integer index;

    @NotBlank
    @ToString.Include
    private String name;


    private String description;

    @NotNull
    @ManyToOne
    private TaskStatus taskStatus;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private User assignee;

    @CreatedDate
    private LocalDate createdAt;

}
