package sangyunpark.core.order;

import sangyunpark.core.discount.DiscountPolicy;
import sangyunpark.core.member.Member;
import sangyunpark.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 금액 첨부

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
