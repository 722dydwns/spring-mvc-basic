package hello.servlet.domain.member;

import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HeaderRepositoryTest {
    //Test

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){ //Test끝나면 초기화하겠다
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given - 이런 상황 주어졌을때
        Member member = new Member("hello", 20);

        //when - 이런 걸 실행했을 때
        Member saveMember = memberRepository.save(member);

        //then - 결과는 이래야 함
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2); //개수랑
        assertThat(result).contains(member1, member2); //내부에 존재여부
    }

}
