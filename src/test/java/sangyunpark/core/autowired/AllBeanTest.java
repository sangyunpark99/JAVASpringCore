package sangyunpark.core.autowired;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sangyunpark.core.AppConfig;
import sangyunpark.core.AutoAppConfig;
import sangyunpark.core.discount.DiscountPolicy;
import sangyunpark.core.member.Grade;
import sangyunpark.core.member.Member;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    void findAllBeans(){
       ApplicationContext ac  = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);

       DiscountService discountService = ac.getBean(DiscountService.class);
       Member member = new Member(1L, "userA", Grade.VIP);
       int discountPrice = discountService.discount(member,10000,"rateDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {

            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            return discountPolicy.discount(member,price);
        }
    }
}
