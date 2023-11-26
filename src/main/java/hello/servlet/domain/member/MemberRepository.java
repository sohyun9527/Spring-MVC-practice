package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    // static 으로 멤버 변수들을 생성해뒀음. MemberRepository 가 아무리 많아도 얘네는 하나임
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository(); // singleton

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {

    }
    /* 싱글톤으로 생성하기 위해 MemberRepository 생성 막고, 무조건 getInstance 를 통해 생성.
     * 이렇게 되면 멤버 변수들의 static 떼도 되는데, 명시성을 위해 걍 두자
     * */

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
