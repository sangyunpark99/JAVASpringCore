package sangyunpark.core;

import sangyunpark.core.member.MemberService;
import sangyunpark.core.member.MemberServiceImpl;
import sangyunpark.core.member.MemoryMemberRepository;
import sangyunpark.core.member.discount.FixDiscountPolicy;
import sangyunpark.core.order.OrderService;
import sangyunpark.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 주입
    }

    public OrderService orderService(){ // 구체적인 방식은 여기서 선택
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy()); // 생성자 주입
    }

}
