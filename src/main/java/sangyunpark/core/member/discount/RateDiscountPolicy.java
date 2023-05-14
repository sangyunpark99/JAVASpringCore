package sangyunpark.core.member.discount;
import sangyunpark.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(Member member, int price) {
        return 0;
    }
}
