package org.prgrms.board.domain.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class UserSearchResponse {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
}

