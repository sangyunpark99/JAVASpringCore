package sangyunpark.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sangyunpark.core.AppConfig;
import sangyunpark.core.member.*;

public class OrderServiceTest {

    OrderService orderService;
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.orderService();
        memberService = appConfig.memberService();
    }

    @Test
    void createOrder(){

        Long memberId = 1L;

        Member member = new Member(memberId,"박상윤", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "상품 1", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        // VIP 인경우 1000원
    }

}
