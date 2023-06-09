package sangyunpark.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import sangyunpark.core.discount.DiscountPolicy;
import sangyunpark.core.discount.FixDiscountPolicy;
import sangyunpark.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan( // 제외할 부분을 지정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean
    DiscountPolicy fixDiscountPolicy(){
        return new FixDiscountPolicy();
    }
}


