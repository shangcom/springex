package com.green.springex.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

//    @Select("select now()") // resource/mappers/TimeTest.xml 방식으로 TimeMapperTest 돌려서 막아놨음. 이거 사용하려면 TimeTest.xml 어떻게 해야함.
    String getTime();
}

