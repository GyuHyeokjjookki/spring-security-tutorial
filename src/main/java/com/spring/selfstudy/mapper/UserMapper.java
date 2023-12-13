package com.spring.selfstudy.mapper;

import com.spring.selfstudy.web.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserVo getUserAccount(String userId);
    void saveUser(UserVo userVo);
}
