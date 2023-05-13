package sangyunpark.core.member;

public interface MemberRepository {
    void save(Member member); // 회원 데이터 저장

    Member findById(Long memberId); // 회원 아이디 찾
}
