package com.green.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//필드 주입 방식
@Service
@ToString // 이렇게 해둬야 SampleTest에서 SampleService 객체에 뭐가 들어있는 지 내용 확인 가능.
//@RequiredArgsConstructor
public class SampleService {
    @Autowired
    private SampleDAO sampleDAO;
}

/*
객체 주입 방식 2가지
1. 필드 주입 방식 : 클래스에 @Autowired, 필드에는 private만 붙임.
2. 생성자 주입 방식 : 클래스에 @RequiredArgsConstructor 태그 추가. @Autowired 생략, 필드 private final으로.
*/
