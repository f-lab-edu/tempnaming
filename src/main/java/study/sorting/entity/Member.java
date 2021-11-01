package study.sorting.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;

    public Member(String name) {
        this.name = name;
    }
}
