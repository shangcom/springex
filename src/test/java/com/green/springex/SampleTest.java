package com.green.springex;

import com.green.springex.sample.SampleService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2 //  로그 메시지를 기록하는데 사용.
@ExtendWith(SpringExtension.class) // SpringExtension을 테스트 실행에 확장함으로써, Spring TestContext Framework를 테스트에 통합
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml") // 스프링의 어플리케이션 컨텍스트를 설정하는 XML 파일의 위치를 지정
public class SampleTest {

    @Autowired // SampleService 타입의 객체를 자동으로 주입받음(필드 주입 방식)
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;
    
    
    @Test //  단위 테스트 케이스를 정의
    public void testService1() {
        log.info("sampleService 객체 : " + sampleService);
        Assertions.assertNotNull(sampleService);
        //이 메소드는 sampleService 객체가 null이 아닌지 확인하는 테스트를 수행.
        // 이는 SampleService 객체가 스프링 컨텍스트에 의해 성공적으로 생성되고, 의존성 주입이 제대로 이루어졌는지를 검증.
    }

    @Test // DB 연결 테스트
    public void testConnect() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info("커넥션 객체 : " + connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }


}


/*
@ExtendWith(SpringExtension.class)
Unit Jupiter에서 제공하는 기능으로, JUnit 5 테스트 실행 방식을 확장할 수 있도록 함.
@ExtendWith를 사용하여 커스텀 어노테이션을 통해 테스트 생명주기 훅(hook)에 로직을 추가하거나,
스프링과 같은 외부 프레임워크와의 통합을 지원하는 확장을 테스트에 적용할 수 있음.
@ExtendWith는 SpringExtension.class와 함께 사용되어, JUnit 5 테스트에 스프링 테스트 컨텍스트 프레임워크를 통합함.
SpringExtension은 스프링 테스트 모듈의 일부로서, 스프링 애플리케이션 컨텍스트의 로딩 및 캐싱, 스프링 빈의 의존성 주입, 트랜잭션 관리 등 스프링의 기능을 JUnit 테스트 케이스에 제공.
*/