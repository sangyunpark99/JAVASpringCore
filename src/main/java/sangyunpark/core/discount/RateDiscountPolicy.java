package sangyunpark.core.discount;
import org.springframework.stereotype.Component;
import sangyunpark.core.member.Grade;
import sangyunpark.core.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
