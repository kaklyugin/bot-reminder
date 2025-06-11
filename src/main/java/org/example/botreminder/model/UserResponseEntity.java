package org.example.botreminder.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;


@Entity
@Data
@SuperBuilder
@Table(name = "user_updates")
public class UserResponseEntity {
    @Id
    @SequenceGenerator(name = "user_updates_sequence", sequenceName = "user_updates_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_updates_sequence")
    private Long id;

    @Column(name = "update_id", nullable = false, unique=true)
    private Long updateId;

    @Column(name = "user_id", nullable = false)
    @NotBlank
    private Long userId;

    @Column(name = "chat_id", nullable = false)
    private String chatId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "raw_message",columnDefinition = "jsonb", nullable = false)
    @Type(JsonType.class)
    private String rawJson;

    public UserResponseEntity() {

    }
}
