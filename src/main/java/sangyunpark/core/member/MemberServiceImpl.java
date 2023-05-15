package sangyunpark.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // 추상화에만 의존

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) { // 회원 가입
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) { // 회원 찾기
        return memberRepository.findById(memberId);
    }
}
