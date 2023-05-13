package sangyunpark.core;

import sangyunpark.core.member.Grade;
import sangyunpark.core.member.Member;
import sangyunpark.core.member.MemberService;
import sangyunpark.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
