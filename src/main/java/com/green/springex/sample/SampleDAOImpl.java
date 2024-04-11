package com.green.springex.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary // @Autowired가 주입할 빈을 찾을 때, 이 어노테이션이 붙은 것을 우선함.
public class SampleDAOImpl implements SampleDAO {
}

/*
DI 시 빈이 여러개 일때?
@Autowired에 필요한 과정
1) Component Scan(root-context.xml) + @Component(@Service @Repository @Controller로 객체를 스프링 빈에 등록
2) @Autowired를 통해 등록된 빈에서 필요한 의존관계를 설정
        (우선적으로,타입(Type)으로 해당 빈(Bean)을 찾는다!)
만약, @Autowired를 통한 자동 의존관계 주입시 여러개의 빈을 찾는다면?
오류가 발생!
스프링은 찾은 여러개의 빈(Bean)들 중 어떤 것을 할 기준이 없기 때문

여러개의 빈을 찾을 때 해결할 수 있는 3가지 방법

1) @Autowired 필드 명 매칭
필드의 이름을 인터페이스가 아닌 실제 원하는 구현체의 이름으로 적용!
이렇게 필드명을 원하는 구현체와 일치시키면 여러개의 빈 찾을 때 해결가능
잘 안쓰는 방법.

2) @Qualifier
스프링 컨테이너가 여러개의 빈을 찾았을 때, 추가적으로 판단할 수 있는 정보를 주는 원리
선택되는 구현체들 / 사용 하는 코드 에 @Qualifier("찾는이름")을 작성해야 한다.

3) @Primary
FixDiscountPolicy에 @Primary를 붙혀 @Autowired시 우선적으로 빈을 찾게 하면, 여러개의 빈을 찾을 때 원하는 대로 해결 가능!
실무에서 많이 사용하는 방법
*/
