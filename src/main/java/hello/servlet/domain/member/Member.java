package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    //정보
    private Long id;
    private String username;
    private int age;
    //기본 생성자
    public Member() {

    }
    //생성자
    public Member(String username, int age){
        this.username = username;
        this.age = age;
    }
}
