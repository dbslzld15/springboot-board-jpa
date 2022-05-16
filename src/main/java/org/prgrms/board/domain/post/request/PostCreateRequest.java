package org.prgrms.board.domain.post.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class PostCreateRequest {
    @NotBlank
    @Size(max = 100)
    private String title;
    @NotBlank
    private String content;
}