package sangyunpark.core.order;

import sangyunpark.core.member.discount.DiscountPolicy;
import sangyunpark.core.member.discount.FixDiscountPolicy;
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
}
