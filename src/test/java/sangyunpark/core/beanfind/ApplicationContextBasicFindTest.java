package sangyunpark.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sangyunpark.core.AppConfig;
import sangyunpark.core.member.MemberService;
import sangyunpark.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    // 코드가 구현에 의존하므로 좋지 않다!! 역할에 의존하는게 제일 좋은 코드이다.
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByType2(){
        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    // Test코드는 항상 테스트 오류가 발생하는 경우를 생각해 주어야 한다.
    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findByNameX(){
        assertThrows(NoSuchBeanDefinitionException.class, () ->  ac.getBean("xxxx", MemberService.class));
    }
}
