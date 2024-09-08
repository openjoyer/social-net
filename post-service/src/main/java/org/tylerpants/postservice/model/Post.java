package org.tylerpants.postservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @SequenceGenerator(name = "post_seq",
            sequenceName = "post_sequence",
            initialValue = 0, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    private Integer id;

    private String description;

    @Column(name = "created-time")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(description, post.description) && Objects.equals(createdAt, post.createdAt) && Objects.equals(user, post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createdAt, user);
    }
}
