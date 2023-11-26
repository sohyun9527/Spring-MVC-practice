package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();
    // Spring 쓰면 싱글톤 할 필요 없음.. Spring 이 싱글톤 보장해준다.

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member);
        memberRepository.save(member2);
        //when
        List<Member> members = memberRepository.findAll();
        //then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member, member2);
    }

    @Test
    void clearStore() {
    }
}