package sangyunpark.core.discount;

import sangyunpark.core.member.Grade;
import sangyunpark.core.member.Member;

public interface DiscountPolicy {

//  @return 할인대상 금액
    int discount(Member member, int price); // 할인 정책
}
