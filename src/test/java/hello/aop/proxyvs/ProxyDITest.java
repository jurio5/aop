package hello.aop.proxyvs;

import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import hello.aop.proxyvs.code.ProxyDIAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"}) // JDK 동적 프록시 설정
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"}) // CGLIB PROXY
// spring.aop.proxy-target-class 설정을 하지 않으면 기본적으로 CGLIB를 사용
@SpringBootTest
@Import(ProxyDIAspect.class)
public class ProxyDITest {

    @Autowired
    MemberService memberService; // 인터페이스

    @Autowired
    MemberServiceImpl memberServiceImpl; // 구체 클래스

    @Test
    void go() {
        log.info("memberService.class={}", memberService.getClass());
        log.info("memberServiceImpl.class={}", memberServiceImpl.getClass());
        memberService.hello("hello");
    }
}
