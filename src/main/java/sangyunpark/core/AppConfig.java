package sangyunpark.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sangyunpark.core.member.MemberRepository;
import sangyunpark.core.member.MemberService;
import sangyunpark.core.member.MemberServiceImpl;
import sangyunpark.core.member.MemoryMemberRepository;
import sangyunpark.core.discount.DiscountPolicy;
import sangyunpark.core.discount.RateDiscountPolicy;
import sangyunpark.core.order.OrderService;
import sangyunpark.core.order.OrderServiceImpl;

@Configuration
public class AppConfig { // 역할과 구현을 확실하게 해준다.

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService(){ // 구체적인 방식은 여기서 선택
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy()); // 생성자 주입
    }

}
