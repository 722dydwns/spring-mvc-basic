package hello.servlet.domain.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
동시성 문제가 고려되어있지 않음.
실무에서는 ConcurrentHashMap, AtomicLong 사용 고려 */
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    //싱글톤 private
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository() {

    }

    //save
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    //findByID
    public Member findById(Long id){
        return store.get(id);
    }
    //findAll
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
    //다 날리기
    public void clearStore(){
        store.clear();
    }


}
