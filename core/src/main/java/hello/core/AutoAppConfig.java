package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@Configuration
//@ComponentScan(
//        basePackages = "hello.core.member",
        // 빈으로 등록할 패키지 범위 지정
        // base package가 없으면, ComponentScan이 붙은 최상단 클래스 부터 하위 다 뒤짐
        // 그니까 ComponentScan 붙일 클래스 가장 최상단에 놓으면 됨

//        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 기존 예제 때문에 했음
//)
public class AutoAppConfig {

    MemberRepository memberRepository (){
        return new MemoryMemberRepository();
    }
}
