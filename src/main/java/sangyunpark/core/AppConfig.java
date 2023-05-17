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

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // 오잉?! 이렇게 되면 싱글톤 패턴이 깨지는거 아닌가?

@Configuration
public class AppConfig { // 역할과 구현을 확실하게 해준다. + 싱글톤 패턴 적용

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository(){

        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){

        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService(){ // 구체적인 방식은 여기서 선택
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 생성자 주입
    }

}
