package sangyunpark.core.order;

import sangyunpark.core.discount.DiscountPolicy;
import sangyunpark.core.discount.FixDiscountPolicy;
import sangyunpark.core.member.Grade;
import sangyunpark.core.member.Member;
import sangyunpark.core.member.MemberRepository;
import sangyunpark.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 금액 첨부

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    @Override
    public Member searchMember(Long id) {
        Member member = memberRepository.findById(id);
        return member;
    }

    @Override
    public void adjustDiscount(Grade grade) {

    }
}
