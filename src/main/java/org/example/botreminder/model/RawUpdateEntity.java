package org.example.botreminder.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;


@Entity
@Data
@SuperBuilder
@Table(name = "raw_updates")
public class RawUpdateEntity {
    @Id
    @SequenceGenerator(name = "raw_updates_sequence", sequenceName = "raw_updates_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "raw_updates_sequence")
    private Long id;

    @Column(name = "message", columnDefinition = "jsonb", nullable = false)
    @Type(JsonType.class)
    private String rawJson;

}
