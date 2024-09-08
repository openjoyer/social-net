package org.tylerpants.postservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.tylerpants.postservice.model.User;

@AllArgsConstructor
@Getter
@Setter
public class PostDTO {
    private String description;

    private User user;
}
