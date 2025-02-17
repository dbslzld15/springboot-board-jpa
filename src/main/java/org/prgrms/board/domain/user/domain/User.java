package org.prgrms.board.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.prgrms.board.domain.post.domain.Post;
import org.prgrms.board.global.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Embedded
    private Name name;

    @Column(nullable = false)
    private int age;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Post> posts = new ArrayList<>();

    @Builder
    public User(Long id, Name name, int age, Email email, Password password) {
        validateAge(age);
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    private void validateAge(int age) {
        if(age <= 0) {
            throw new IllegalArgumentException("나이는 0이하가 될 수 없습니다.");
        }
    }

    public void addPost(Post post) {
        post.changeUser(this);
    }
}
